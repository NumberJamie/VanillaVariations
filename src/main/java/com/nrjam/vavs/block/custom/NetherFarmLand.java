package com.nrjam.vavs.block.custom;

import com.nrjam.vavs.block.ModBlocks;
import com.nrjam.vavs.enchantments.Scorching;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.resources.ResourceKey;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.sounds.SoundSource;
import net.minecraft.tags.FluidTags;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.context.BlockPlaceContext;
import net.minecraft.world.item.enchantment.EnchantmentHelper;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.LevelReader;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.FarmBlock;
import net.minecraft.world.level.block.FenceGateBlock;
import net.minecraft.world.level.block.piston.MovingPistonBlock;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.StateDefinition;
import net.minecraft.world.level.block.state.properties.BlockStateProperties;
import net.minecraft.world.level.block.state.properties.IntegerProperty;
import net.minecraft.world.level.pathfinder.PathComputationType;
import net.minecraft.world.phys.shapes.CollisionContext;
import net.minecraft.world.phys.shapes.VoxelShape;
import org.jetbrains.annotations.NotNull;

import java.util.Random;

public class NetherFarmLand extends FarmBlock {
    public static final IntegerProperty MOISTURE = BlockStateProperties.MOISTURE;
    protected static final VoxelShape SHAPE = Block.box(0.0D, 0.0D, 0.0D, 16.0D, 15.0D, 16.0D);
    public static final int MAX_MOISTURE = 7;

    public NetherFarmLand(BlockBehaviour.Properties properties) {
        super(properties);
        this.registerDefaultState(this.stateDefinition.any().setValue(MOISTURE, 0));
    }

    public void randomTick(BlockState state, ServerLevel lvl, BlockPos pos, Random ran) {
        int i = state.getValue(MOISTURE);
        if (!isNearLava(lvl, pos) || !lvl.dimensionType().ultraWarm()) {
            if (i > 0) {
                lvl.setBlock(pos, state.setValue(MOISTURE, Integer.valueOf(i - 1)), 2);
            } else if (!isNearLava(lvl, pos) || !lvl.dimensionType().ultraWarm()) {
                turnToSoil(state, lvl, pos);
            }
        } else if (i < 7) {
            lvl.setBlock(pos, state.setValue(MOISTURE, Integer.valueOf(7)), 2);
        }
    }

    public void stepOn(Level lvl, BlockPos pos, BlockState state, Entity entity) {
        int i = state.getValue(MOISTURE);
        if (i == 7) {
            if (!entity.fireImmune() && entity instanceof LivingEntity && !Scorching.hasScoring((LivingEntity) entity)) {
                entity.hurt(DamageSource.HOT_FLOOR, 1.0F);
            }
        }
        super.stepOn(lvl, pos, state, entity);
    }

    private static boolean isNearLava(LevelReader reader, BlockPos pos) {
        for(BlockPos blockpos : BlockPos.betweenClosed(pos.offset(-2, 0, -2), pos.offset(2, 1, 2))) {
            if (reader.getFluidState(blockpos).is(FluidTags.LAVA)) {
                return true;
            }
        }
        return net.minecraftforge.common.FarmlandWaterManager.hasBlockWaterTicket(reader, pos);
    }

    public @NotNull BlockState updateShape(BlockState state, Direction direction, BlockState b_state, LevelAccessor lvl_a, BlockPos pos, BlockPos pos_2) {
        if (direction == Direction.UP && !state.canSurvive(lvl_a, pos)) {
            lvl_a.scheduleTick(pos, this, 1);
        }

        return super.updateShape(state, direction, b_state, lvl_a, pos, pos_2);
    }

    public boolean canSurvive(BlockState state, LevelReader lvl, BlockPos pos) {
        BlockState blockstate = lvl.getBlockState(pos.above());
        return !blockstate.getMaterial().isSolid() || blockstate.getBlock() instanceof FenceGateBlock || blockstate.getBlock() instanceof MovingPistonBlock;
    }

    public BlockState getStateForPlacement(BlockPlaceContext p_53249_) {
        return !this.defaultBlockState().canSurvive(p_53249_.getLevel(), p_53249_.getClickedPos()) ? Blocks.SOUL_SOIL.defaultBlockState() : super.getStateForPlacement(p_53249_);
    }

    public boolean useShapeForLightOcclusion(BlockState p_53295_) {
        return true;
    }

    public @NotNull VoxelShape getShape(BlockState p_53290_, BlockGetter p_53291_, BlockPos p_53292_, CollisionContext p_53293_) {
        return SHAPE;
    }

    public void tick(BlockState p_53262_, ServerLevel p_53263_, BlockPos p_53264_, Random p_53265_) {
        if (!p_53262_.canSurvive(p_53263_, p_53264_)) {
            turnToSoil(p_53262_, p_53263_, p_53264_);
        }

    }

    public void fallOn(Level lvl, BlockState state, BlockPos pos, Entity entity, float ran) {
        if (!lvl.isClientSide && net.minecraftforge.common.ForgeHooks.onFarmlandTrample(lvl, pos, Blocks.SOUL_SOIL.defaultBlockState(), ran, entity) && !Scorching.hasScoring((LivingEntity) entity)) {
            turnToSoil(state, lvl, pos);
        }
    }

    public static void turnToSoil(BlockState state, Level lvl, BlockPos pos) {
        lvl.setBlockAndUpdate(pos, pushEntitiesUp(state, Blocks.SOUL_SOIL.defaultBlockState(), lvl, pos));
    }

    protected void createBlockStateDefinition(StateDefinition.Builder<Block, BlockState> block) {
        block.add(MOISTURE);
    }

    public boolean isPathfindable(BlockState state, BlockGetter getter, BlockPos pos, PathComputationType computationType) {
        return false;
    }
}

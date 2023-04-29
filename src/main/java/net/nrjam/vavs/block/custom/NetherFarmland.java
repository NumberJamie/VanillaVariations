package net.nrjam.vavs.block.custom;

import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.tags.FluidTags;
import net.minecraft.util.RandomSource;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.item.AxeItem;
import net.minecraft.world.item.HoeItem;
import net.minecraft.world.item.context.BlockPlaceContext;
import net.minecraft.world.item.context.UseOnContext;
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
import net.minecraft.world.level.gameevent.GameEvent;
import net.minecraft.world.level.pathfinder.PathComputationType;
import net.minecraft.world.phys.shapes.CollisionContext;
import net.minecraft.world.phys.shapes.VoxelShape;
import net.minecraftforge.common.ToolAction;
import net.minecraftforge.common.ToolActions;
import net.minecraftforge.common.extensions.IForgeBlock;
import net.nrjam.vavs.block.ModBlocks;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.Random;

public class NetherFarmland extends FarmBlock implements IForgeBlock {
    public static final IntegerProperty MOISTURE = BlockStateProperties.MOISTURE;
    protected static final VoxelShape SHAPE = Block.box(0.0D, 0.0D, 0.0D, 16.0D, 15.0D, 16.0D);
    public static final int MAX_MOISTURE = 7;

    public NetherFarmland(BlockBehaviour.Properties properties) {
        super(properties);
        this.registerDefaultState(this.stateDefinition.any().setValue(MOISTURE, 0));
    }

    public void randomTick(BlockState blockState, @NotNull ServerLevel serverLevel, @NotNull BlockPos blockPos, @NotNull RandomSource randomSource) {
        int i = blockState.getValue(MOISTURE);
        if (!isNearLava(serverLevel, blockPos) && !serverLevel.isRainingAt(blockPos.above())) {
            if (i > 0) {
                serverLevel.setBlock(blockPos, blockState.setValue(MOISTURE, i - 1), 2);
            } else if (!isNearLava(serverLevel, blockPos) || serverLevel.dimensionType().ultraWarm()) {
                turnToSoil((Entity)null, blockState, serverLevel, blockPos);
            }
        } else if (i < 7) {
            serverLevel.setBlock(blockPos, blockState.setValue(MOISTURE, 7), 2);
        }

    }

    public void stepOn(@NotNull Level level, @NotNull BlockPos blockPos, BlockState blockState, @NotNull Entity entity) {
        int i = blockState.getValue(MOISTURE);
        if (i == 7) {
            if (!entity.isSteppingCarefully() && entity instanceof LivingEntity && !EnchantmentHelper.hasFrostWalker((LivingEntity) entity)) {
                entity.hurt(level.damageSources().hotFloor(), 1.0F);
            }
        }

        super.stepOn(level, blockPos, blockState, entity);
    }

    private static boolean isNearLava(LevelReader reader, BlockPos pos) {
        for(BlockPos blockpos : BlockPos.betweenClosed(pos.offset(-2, 0, -2), pos.offset(2, 1, 2))) {
            if (reader.getFluidState(blockpos).is(FluidTags.LAVA)) {
                return true;
            }
        }
        return net.minecraftforge.common.FarmlandWaterManager.hasBlockWaterTicket(reader, pos);
    }

    public @NotNull BlockState updateShape(@NotNull BlockState state, @NotNull Direction direction, @NotNull BlockState b_state, @NotNull LevelAccessor lvl_a, @NotNull BlockPos pos, @NotNull BlockPos pos_2) {
        if (direction == Direction.UP && !state.canSurvive(lvl_a, pos)) {
            lvl_a.scheduleTick(pos, this, 1);
        }

        return super.updateShape(state, direction, b_state, lvl_a, pos, pos_2);
    }

    public boolean canSurvive(@NotNull BlockState state, LevelReader lvl, BlockPos pos) {
        BlockState blockstate = lvl.getBlockState(pos.above());
        return !blockstate.getMaterial().isSolid() || blockstate.getBlock() instanceof FenceGateBlock || blockstate.getBlock() instanceof MovingPistonBlock;
    }

    public BlockState getStateForPlacement(BlockPlaceContext placeContext) {
        return !this.defaultBlockState().canSurvive(placeContext.getLevel(), placeContext.getClickedPos()) ? Blocks.SOUL_SOIL.defaultBlockState() : super.getStateForPlacement(placeContext);
    }

    public boolean useShapeForLightOcclusion(@NotNull BlockState p_53295_) {
        return true;
    }

    public @NotNull VoxelShape getShape(@NotNull BlockState p_53290_, @NotNull BlockGetter p_53291_, @NotNull BlockPos p_53292_, @NotNull CollisionContext p_53293_) {
        return SHAPE;
    }

    public void tick(BlockState blockState, @NotNull ServerLevel serverLevel, @NotNull BlockPos blockPos, @NotNull RandomSource randomSource) {
        if (!blockState.canSurvive(serverLevel, blockPos)) {
            turnToSoil((Entity)null, blockState, serverLevel, blockPos);
        }

    }

    public void fallOn(Level lvl, @NotNull BlockState state, @NotNull BlockPos pos, @NotNull Entity entity, float ran) {
        if (!lvl.isClientSide && net.minecraftforge.common.ForgeHooks.onFarmlandTrample(lvl, pos, Blocks.SOUL_SOIL.defaultBlockState(), ran, entity)) {
            turnToSoil((Entity)null, state, lvl, pos);
        }
    }

    public static void turnToSoil(@Nullable Entity p_270981_, BlockState p_270402_, Level p_270568_, BlockPos p_270551_) {
        BlockState blockstate = pushEntitiesUp(p_270402_, Blocks.SOUL_SOIL.defaultBlockState(), p_270568_, p_270551_);
        p_270568_.setBlockAndUpdate(p_270551_, blockstate);
        p_270568_.gameEvent(GameEvent.BLOCK_CHANGE, p_270551_, GameEvent.Context.of(p_270981_, blockstate));
    }

    protected void createBlockStateDefinition(StateDefinition.Builder<Block, BlockState> block) {
        block.add(MOISTURE);
    }

    public boolean isPathfindable(@NotNull BlockState state, @NotNull BlockGetter getter, @NotNull BlockPos pos, @NotNull PathComputationType computationType) {
        return false;
    }

    @Override
    public @Nullable BlockState getToolModifiedState(BlockState state, UseOnContext context, ToolAction toolAction, boolean simulate) {
        if (context.getItemInHand().getItem() instanceof HoeItem) {
            if (state.is(ModBlocks.NETHER_FARMLAND.get()) && context.getLevel().getBlockState(context.getClickedPos().above()).isAir()) {
                return ModBlocks.END_SOIL.get().defaultBlockState();
            }
        }
        return null;
    }
}
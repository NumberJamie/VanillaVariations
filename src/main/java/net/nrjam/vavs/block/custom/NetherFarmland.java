package net.nrjam.vavs.block.custom;

import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.tags.FluidTags;
import net.minecraft.util.RandomSource;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.LivingEntity;
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
import net.minecraft.world.level.gameevent.GameEvent;
import net.minecraft.world.level.pathfinder.PathComputationType;
import net.minecraft.world.phys.shapes.CollisionContext;
import net.minecraft.world.phys.shapes.VoxelShape;
import net.minecraftforge.common.extensions.IForgeBlock;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

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
                turnToSoil(null, blockState, serverLevel, blockPos);
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
        return !blockstate.isSolid() || blockstate.getBlock() instanceof FenceGateBlock || blockstate.getBlock() instanceof MovingPistonBlock;
    }

    public BlockState getStateForPlacement(BlockPlaceContext placeContext) {
        return !this.defaultBlockState().canSurvive(placeContext.getLevel(), placeContext.getClickedPos()) ? Blocks.SOUL_SOIL.defaultBlockState() : super.getStateForPlacement(placeContext);
    }

    public boolean useShapeForLightOcclusion(@NotNull BlockState p_53295_) {
        return true;
    }

    public @NotNull VoxelShape getShape(@NotNull BlockState state, @NotNull BlockGetter getter, @NotNull BlockPos pos, @NotNull CollisionContext context) {
        return SHAPE;
    }

    public void tick(BlockState blockState, @NotNull ServerLevel serverLevel, @NotNull BlockPos blockPos, @NotNull RandomSource randomSource) {
        if (!blockState.canSurvive(serverLevel, blockPos)) {
            turnToSoil(null, blockState, serverLevel, blockPos);
        }

    }

    public void fallOn(Level lvl, @NotNull BlockState state, @NotNull BlockPos pos, @NotNull Entity entity, float ran) {
        if (!lvl.isClientSide && net.minecraftforge.common.ForgeHooks.onFarmlandTrample(lvl, pos, Blocks.SOUL_SOIL.defaultBlockState(), ran, entity)) {
            turnToSoil(null, state, lvl, pos);
        }
    }

    public static void turnToSoil(@Nullable Entity entity, BlockState state, Level lvl, BlockPos pos) {
        BlockState blockstate = pushEntitiesUp(state, Blocks.SOUL_SOIL.defaultBlockState(), lvl, pos);
        lvl.setBlockAndUpdate(pos, blockstate);
        lvl.gameEvent(GameEvent.BLOCK_CHANGE, pos, GameEvent.Context.of(entity, blockstate));
    }

    protected void createBlockStateDefinition(StateDefinition.Builder<Block, BlockState> block) {
        block.add(MOISTURE);
    }

    public boolean isPathfindable(@NotNull BlockState state, @NotNull BlockGetter getter, @NotNull BlockPos pos, @NotNull PathComputationType computationType) {
        return false;
    }
}
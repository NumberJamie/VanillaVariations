package net.nrjam.vavs.block.natural;

import net.minecraft.core.BlockPos;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.sounds.SoundSource;
import net.minecraft.util.RandomSource;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.LevelReader;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.SweetBerryBushBlock;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.StateDefinition;
import net.minecraft.world.level.block.state.properties.BlockStateProperties;
import net.minecraft.world.level.block.state.properties.IntegerProperty;
import net.minecraft.world.phys.BlockHitResult;
import net.minecraft.world.phys.shapes.CollisionContext;
import net.minecraft.world.phys.shapes.VoxelShape;
import net.nrjam.vavs.item.ModItems;
import org.jetbrains.annotations.NotNull;

public class WarpedBerry extends SweetBerryBushBlock {
    private static final float HURT_SPEED_THRESHOLD = 0.003F;
    public static final int MAX_AGE = 3;
    public static final IntegerProperty AGE = BlockStateProperties.AGE_3;
    private static final VoxelShape SAPLING_SHAPE = Block.box(3.0D, 0.0D, 3.0D, 13.0D, 8.0D, 13.0D);
    private static final VoxelShape MID_GROWTH_SHAPE = Block.box(1.0D, 0.0D, 1.0D, 15.0D, 16.0D, 15.0D);

    public WarpedBerry(Properties properties) {
        super(properties);
        this.registerDefaultState(this.stateDefinition.any().setValue(AGE, 0));
    }

    public IntegerProperty getAgeProperty() {
        return AGE;
    }

    @Override
    public boolean mayPlaceOn(BlockState state, @NotNull BlockGetter get, @NotNull BlockPos pos) {
        return state.is(Blocks.WARPED_NYLIUM);
    }

    public @NotNull ItemStack getCloneItemStack(@NotNull BlockGetter p_57256_, @NotNull BlockPos p_57257_, @NotNull BlockState p_57258_) {
        return new ItemStack(ModItems.WARPED_BERRIES.get());
    }

    public @NotNull VoxelShape getShape(BlockState p_57291_, @NotNull BlockGetter p_57292_, @NotNull BlockPos p_57293_, @NotNull CollisionContext p_57294_) {
        if (p_57291_.getValue(AGE) == 0) {
            return SAPLING_SHAPE;
        } else {
            return p_57291_.getValue(AGE) < 3 ? MID_GROWTH_SHAPE : super.getShape(p_57291_, p_57292_, p_57293_, p_57294_);
        }
    }

    public boolean isRandomlyTicking(BlockState p_57284_) {
        return p_57284_.getValue(AGE) < 3;
    }

    public void randomTick(BlockState p_57286_, @NotNull ServerLevel p_57287_, @NotNull BlockPos p_57288_, @NotNull RandomSource p_57289_) {
        int i = p_57286_.getValue(AGE);
        if (i < 3 && net.minecraftforge.common.ForgeHooks.onCropsGrowPre(p_57287_, p_57288_, p_57286_,p_57289_.nextInt(5) == 0)) {
            p_57287_.setBlock(p_57288_, p_57286_.setValue(AGE, i + 1), 2);
            net.minecraftforge.common.ForgeHooks.onCropsGrowPost(p_57287_, p_57288_, p_57286_);
        }

    }

    @Override
    public @NotNull InteractionResult use(BlockState p_57275_, @NotNull Level p_57276_, @NotNull BlockPos p_57277_, @NotNull Player player, @NotNull InteractionHand p_57279_, @NotNull BlockHitResult p_57280_) {
        int i = p_57275_.getValue(AGE);
        boolean flag = i == 3;
        if (!flag && player.getItemInHand(p_57279_).is(Items.BONE_MEAL)) {
            return InteractionResult.PASS;
        } else if (i > 2) {
            int j = 1 + p_57276_.random.nextInt(2);
            popResource(p_57276_, p_57277_, new ItemStack(ModItems.WARPED_BERRIES.get(), j + (flag ? 1 :  0)));
            p_57276_.playSound((Player)null, p_57277_, SoundEvents.SWEET_BERRY_BUSH_PICK_BERRIES, SoundSource.BLOCKS, 1.0F, 0.8F + p_57276_.random.nextFloat() * 0.4F);
            p_57276_.setBlock(p_57277_, p_57275_.setValue(AGE, 1), 2);
            return InteractionResult.sidedSuccess(p_57276_.isClientSide);
        } else {
            return super.use(p_57275_, p_57276_, p_57277_, player, p_57279_, p_57280_);
        }
    }

    @Override
    protected void createBlockStateDefinition(StateDefinition.Builder<Block, BlockState> stateBuilder) {
        stateBuilder.add(AGE);
    }

    @Override
    public boolean canSurvive(@NotNull BlockState state, @NotNull LevelReader lvl, BlockPos pos) {
        BlockPos blockpos = pos.below();
        return this.mayPlaceOn(lvl.getBlockState(blockpos), lvl, blockpos);
    }
}
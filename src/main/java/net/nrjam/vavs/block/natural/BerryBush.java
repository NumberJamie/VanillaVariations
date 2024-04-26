package net.nrjam.vavs.block.natural;

import net.minecraft.core.BlockPos;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.sounds.SoundSource;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.LevelReader;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.SweetBerryBushBlock;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.StateDefinition;
import net.minecraft.world.level.block.state.properties.BlockStateProperties;
import net.minecraft.world.level.block.state.properties.IntegerProperty;
import net.minecraft.world.phys.BlockHitResult;
import net.minecraftforge.registries.RegistryObject;
import org.jetbrains.annotations.NotNull;


public class BerryBush extends SweetBerryBushBlock {
    public static final IntegerProperty AGE = BlockStateProperties.AGE_3;
    private final RegistryObject<Item> relatedItem;
    private final Block block;

    public BerryBush(Properties properties, RegistryObject<Item> relatedItem, Block block) {
        super(properties);
        this.registerDefaultState(this.stateDefinition.any().setValue(AGE, 0));
        this.relatedItem = relatedItem;
        this.block = block;
    }

    public IntegerProperty getAge() {
        return AGE;
    }

    @Override
    public boolean mayPlaceOn(BlockState state, @NotNull BlockGetter get, @NotNull BlockPos pos) {
        return state.is(this.block);
    }

    public @NotNull ItemStack getCloneItemStack(@NotNull BlockGetter getter, @NotNull BlockPos pos, @NotNull BlockState state) {
        return new ItemStack(relatedItem.get());
    }

    @Override
    public @NotNull InteractionResult use(BlockState state, @NotNull Level lvl, @NotNull BlockPos pos, @NotNull Player player, @NotNull InteractionHand hand, @NotNull BlockHitResult result) {
        int i = state.getValue(AGE);
        boolean flag = i == 3;
        if (!flag && player.getItemInHand(hand).is(Items.BONE_MEAL)) {
            return InteractionResult.PASS;
        } else if (i > 2) {
            int j = 1 + lvl.random.nextInt(2);
            popResource(lvl, pos, new ItemStack(relatedItem.get(), j + (flag ? 1 :  0)));
            lvl.playSound(null, pos, SoundEvents.SWEET_BERRY_BUSH_PICK_BERRIES, SoundSource.BLOCKS, 1.0F, 0.8F + lvl.random.nextFloat() * 0.4F);
            lvl.setBlock(pos, state.setValue(AGE, 1), 2);
            return InteractionResult.sidedSuccess(lvl.isClientSide);
        } else {
            return super.use(state, lvl, pos, player, hand, result);
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
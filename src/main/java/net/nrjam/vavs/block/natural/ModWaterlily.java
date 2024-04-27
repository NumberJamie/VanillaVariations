package net.nrjam.vavs.block.natural;

import net.minecraft.core.BlockPos;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.sounds.SoundSource;
import net.minecraft.tags.BlockTags;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.ClipContext;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.LevelReader;
import net.minecraft.world.level.block.WaterlilyBlock;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.gameevent.GameEvent;
import net.minecraft.world.phys.BlockHitResult;
import net.minecraftforge.common.ToolActions;
import net.nrjam.vavs.block.ModBlocks;
import org.jetbrains.annotations.NotNull;

public class ModWaterlily extends WaterlilyBlock {
    public ModWaterlily(Properties properties) {
        super(properties);
    }

    @Override
    public boolean canSurvive(@NotNull BlockState state, @NotNull LevelReader lvl, BlockPos pos) {
        BlockPos blockpos = pos.below();
        return lvl.getBlockState(blockpos).getFluidState().isSource();
    }

    @Override
    public @NotNull InteractionResult use(@NotNull BlockState state, @NotNull Level lvl, @NotNull BlockPos pos, Player player, @NotNull InteractionHand hand, @NotNull BlockHitResult result) {
        ItemStack itemstack = player.getItemInHand(hand);
        if (itemstack.canPerformAction(ToolActions.SHEARS_HARVEST) && state.is(ModBlocks.WATER_LILY.get())) {
            lvl.playSound(player, pos.getX(), pos.getY(), pos.getZ(), SoundEvents.SHEEP_SHEAR, SoundSource.BLOCKS, 1.0F, 1.0F);
            popResource(lvl, pos, new ItemStack(Items.SPORE_BLOSSOM, 1));
            itemstack.hurtAndBreak(1, player, (player1) -> {
                player1.broadcastBreakEvent(hand);
            });
            lvl.gameEvent(player, GameEvent.SHEAR, pos);
            lvl.setBlock(pos, ModBlocks.WATER_LILY_PAD.get().defaultBlockState(), 1);
            return InteractionResult.sidedSuccess(lvl.isClientSide);
        }
        return super.use(state, lvl, pos, player, hand, result);
    }
}

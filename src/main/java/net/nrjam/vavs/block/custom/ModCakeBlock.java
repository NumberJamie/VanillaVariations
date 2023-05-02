package net.nrjam.vavs.block.custom;

import net.minecraft.core.BlockPos;
import net.minecraft.tags.ItemTags;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.CakeBlock;
import net.minecraft.world.level.block.CandleBlock;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.phys.BlockHitResult;
import org.jetbrains.annotations.NotNull;

public class ModCakeBlock extends CakeBlock {
    public ModCakeBlock(Properties properties) {
        super(properties);
    }

    @Override
    public @NotNull InteractionResult use(@NotNull BlockState state, @NotNull Level lvl, @NotNull BlockPos pos, Player player, @NotNull InteractionHand hand, @NotNull BlockHitResult result) {
        ItemStack itemstack = player.getItemInHand(hand);
        Item item = itemstack.getItem();
        if (itemstack.is(ItemTags.CANDLES) && state.getValue(BITES) == 0) {
            Block block = Block.byItem(item);
            if (block instanceof CandleBlock) {
                if (!player.isCreative()) {
                    itemstack.shrink(1);
                }
            }
        }

        if (lvl.isClientSide) {
            if (eat(lvl, pos, state, player).consumesAction()) {
                return InteractionResult.SUCCESS;
            }

            if (itemstack.isEmpty()) {
                return InteractionResult.CONSUME;
            }
        }

        return eat(lvl, pos, state, player);
    }
}
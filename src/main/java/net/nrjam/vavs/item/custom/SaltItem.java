package net.nrjam.vavs.item.custom;

import com.mojang.datafixers.util.Pair;
import net.minecraft.core.BlockPos;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.sounds.SoundSource;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.context.UseOnContext;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.gameevent.GameEvent;
import org.jetbrains.annotations.NotNull;

import java.util.function.Consumer;
import java.util.function.Predicate;

public class SaltItem extends Item {
    public SaltItem(Properties properties) {
        super(properties);
    }

    @Override
    public @NotNull InteractionResult useOn(UseOnContext onUse) {
        Level level = onUse.getLevel();
        BlockPos blockpos = onUse.getClickedPos();
        BlockState toolModifiedState = level.getBlockState(blockpos).getToolModifiedState(onUse, ModToolActions.SALT_OXIDIZE, false);
        Pair<Predicate<UseOnContext>, Consumer<UseOnContext>> pair = toolModifiedState == null ? null : Pair.of(ctx -> true, changeIntoState(toolModifiedState));
        if (pair == null) {
            return InteractionResult.PASS;
        } else {
            Predicate<UseOnContext> predicate = pair.getFirst();
            Consumer<UseOnContext> consumer = pair.getSecond();
            if (predicate.test(onUse)) {
                Player player = onUse.getPlayer();
                level.playSound(player, blockpos, SoundEvents.HONEYCOMB_WAX_ON, SoundSource.BLOCKS, 1.0F, 1.0F);
                if (!level.isClientSide) {
                    consumer.accept(onUse);
                    if (player != null) {
                        onUse.getItemInHand().shrink(1);
                    }
                }

                return InteractionResult.sidedSuccess(level.isClientSide);
            } else {
                return InteractionResult.PASS;
            }
        }
    }

    public static Consumer<UseOnContext> changeIntoState(BlockState state) {
        return (onUse) -> {
            onUse.getLevel().setBlock(onUse.getClickedPos(), state, 11);
            onUse.getLevel().gameEvent(GameEvent.BLOCK_CHANGE, onUse.getClickedPos(), GameEvent.Context.of(onUse.getPlayer(), state));
        };
    }

    @Override
    public boolean canPerformAction(ItemStack stack, net.minecraftforge.common.ToolAction toolAction) {
        return ModToolActions.DEFAULT_SALT_ACTIONS.contains(toolAction);
    }
}

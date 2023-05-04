package net.nrjam.vavs.events;

import net.minecraft.world.damagesource.DamageTypes;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.WeatheringCopper;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraftforge.common.ToolAction;
import net.minecraftforge.event.entity.living.LivingAttackEvent;
import net.minecraftforge.event.level.BlockEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.nrjam.vavs.VanillaVariations;
import net.nrjam.vavs.block.ModBlocks;
import net.nrjam.vavs.item.enchantments.Scorching;

import java.util.Optional;

public class ModEvents {
    @Mod.EventBusSubscriber(modid = VanillaVariations.MOD_ID)
    public static class ForgeEvents {
        @SubscribeEvent
        public static void tillSoulSoil(BlockEvent.BlockToolModificationEvent event) {
            if (event.getToolAction() == ToolAction.get("till")) {
                if (event.getFinalState() == Blocks.SOUL_SOIL.defaultBlockState()) {
                    event.setFinalState(ModBlocks.NETHER_FARMLAND.get().defaultBlockState());
                }
            }
        }

        @SubscribeEvent
        public static void weatherCopper(BlockEvent.BlockToolModificationEvent event) {
            BlockState state = event.getFinalState();
            if (event.getToolAction() == ToolAction.get("salt_oxidize")) {
                if (state.getBlock() instanceof WeatheringCopper) {
                    WeatheringCopper.getNext(state.getBlock()).ifPresent(nextStage -> event.setFinalState(nextStage.defaultBlockState()));
                }
            }
        }

        @SubscribeEvent
        public static void noCropTrample(BlockEvent.FarmlandTrampleEvent event){
            if (Scorching.hasScorching((LivingEntity) event.getEntity())) {
                event.setCanceled(true);
            }
        }

        @SubscribeEvent
        public static void noMagmaDamage(LivingAttackEvent event){
            if (event.getSource().is(DamageTypes.HOT_FLOOR) && Scorching.hasScorching(event.getEntity())) {
                Scorching.hasScorching(event.getEntity());
                event.setCanceled(true);
            }
        }
    }
}
package net.nrjam.vavs.events;

import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraftforge.common.ToolAction;
import net.minecraftforge.event.level.BlockEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.nrjam.vavs.VanillaVariations;
import net.nrjam.vavs.block.ModBlocks;

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
    }
}
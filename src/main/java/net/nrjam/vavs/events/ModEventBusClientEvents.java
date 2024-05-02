package net.nrjam.vavs.events;

import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.client.event.EntityRenderersEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.nrjam.vavs.VanillaVariations;
import net.nrjam.vavs.entity.client.ModModelLayers;
import net.nrjam.vavs.entity.client.SquirrelModel;

@Mod.EventBusSubscriber(modid = VanillaVariations.MOD_ID, bus = Mod.EventBusSubscriber.Bus.MOD, value = Dist.CLIENT)
public class ModEventBusClientEvents {
    @SubscribeEvent
    public static void registerLayer(EntityRenderersEvent.RegisterLayerDefinitions event) {
        event.registerLayerDefinition(ModModelLayers.SQUIRREL_LAYER, SquirrelModel::createBodyLayer);
    }
}
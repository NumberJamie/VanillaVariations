package net.nrjam.vavs.events;

import net.minecraftforge.event.entity.EntityAttributeCreationEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.nrjam.vavs.VanillaVariations;
import net.nrjam.vavs.entity.ModEntities;
import net.nrjam.vavs.entity.custom.SquirrelEntity;

@Mod.EventBusSubscriber(modid = VanillaVariations.MOD_ID, bus = Mod.EventBusSubscriber.Bus.MOD)
public class ModEventBusEvents {
    @SubscribeEvent
    public static void registerAttributes(EntityAttributeCreationEvent event) {
        event.put(ModEntities.SQUIRREL.get(), SquirrelEntity.createAttributes().build());
    }
}

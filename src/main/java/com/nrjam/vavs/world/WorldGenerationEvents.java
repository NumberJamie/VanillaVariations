package com.nrjam.vavs.world;

import com.nrjam.vavs.VanillaVariations;
import com.nrjam.vavs.world.gen.FlowerGeneration;
import com.nrjam.vavs.world.gen.OreGeneration;
import com.nrjam.vavs.world.gen.TreeGeneration;
import net.minecraftforge.event.world.BiomeLoadingEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

@Mod.EventBusSubscriber(modid = VanillaVariations.MOD_ID)
public class WorldGenerationEvents {
    @SubscribeEvent
    public static void ModWorldGeneration(final BiomeLoadingEvent event) {
        OreGeneration.generateOres(event);
        FlowerGeneration.generateFeature(event);

        TreeGeneration.generateTrees(event);
        FlowerGeneration.generateFlowers(event);
    }
}

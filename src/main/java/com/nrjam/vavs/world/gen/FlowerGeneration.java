package com.nrjam.vavs.world.gen;

import net.minecraft.core.Holder;
import net.minecraft.core.Registry;
import net.minecraft.resources.ResourceKey;
import net.minecraft.world.level.biome.Biome;
import net.minecraft.world.level.biome.Biomes;
import net.minecraft.world.level.levelgen.GenerationStep;
import net.minecraft.world.level.levelgen.placement.BiomeFilter;
import net.minecraft.world.level.levelgen.placement.PlacedFeature;
import net.minecraftforge.common.BiomeDictionary;
import net.minecraftforge.event.world.BiomeLoadingEvent;

import java.util.List;
import java.util.Set;
import java.util.function.Supplier;

public class FlowerGeneration {
    public static void generateFlowers(final BiomeLoadingEvent event) {
        ResourceKey<Biome> key = ResourceKey.create(Registry.BIOME_REGISTRY, event.getName());
        Set<BiomeDictionary.Type> types = BiomeDictionary.getTypes(key);

        if(types.contains(BiomeDictionary.Type.PLAINS)) {
            List<Holder<PlacedFeature>> base =
                    event.getGeneration().getFeatures(GenerationStep.Decoration.VEGETAL_DECORATION);

            base.add(PlacedFeatures.VIOLA_PLACED);
            base.add(PlacedFeatures.WILD_CABBAGE_PLACED);
            base.add(PlacedFeatures.MARIGOLD_PLACED);
            base.add(PlacedFeatures.LAVENDER_PLACED);
            base.add(PlacedFeatures.SNAPDRAGON_PLACED);
        }
        if (types.contains(BiomeDictionary.Type.NETHER)) {
            List<Holder<PlacedFeature>> base =
                    event.getGeneration().getFeatures(GenerationStep.Decoration.VEGETAL_DECORATION);

            base.add(PlacedFeatures.SOUL_FLOWER_PLACED);
            base.add(PlacedFeatures.WARPED_SOUL_BERRY_PLACED);
            base.add(PlacedFeatures.CRIMSON_FIRE_BERRY_PLACED);
            base.add(PlacedFeatures.DEAD_ROOTS_PLACED);
            base.add(PlacedFeatures.DEAD_ROOTS_PLACED_2);
            base.add(PlacedFeatures.DEAD_ROOTS_PLACED_3);
        }
        if (types.contains(BiomeDictionary.Type.END)) {
            List<Holder<PlacedFeature>> base =
                    event.getGeneration().getFeatures(GenerationStep.Decoration.VEGETAL_DECORATION);


            base.add(PlacedFeatures.BLOSSOMING_ROOT_PLACED);
            base.add(PlacedFeatures.ENDER_ROOT_PLACED);
        }
    }

    public static void generateFeature(final BiomeLoadingEvent event){
        ResourceKey<Biome> key = ResourceKey.create(Registry.BIOME_REGISTRY, event.getName());
        Set<BiomeDictionary.Type> types = BiomeDictionary.getTypes(key);

        if (types.contains(BiomeDictionary.Type.END)) {
            List<Holder<PlacedFeature>> base =
                    event.getGeneration().getFeatures(GenerationStep.Decoration.UNDERGROUND_ORES);

            base.add(PlacedFeatures.END_SOIL_PLACED);
        }
    }
}

package net.nrjam.vavs.worldgen;

import net.minecraft.core.Holder;
import net.minecraft.core.HolderGetter;
import net.minecraft.core.registries.Registries;
import net.minecraft.data.worldgen.BootstapContext;
import net.minecraft.data.worldgen.placement.PlacementUtils;
import net.minecraft.data.worldgen.placement.VegetationPlacements;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.levelgen.VerticalAnchor;
import net.minecraft.world.level.levelgen.feature.ConfiguredFeature;
import net.minecraft.world.level.levelgen.placement.*;
import net.nrjam.vavs.VanillaVariations;
import net.nrjam.vavs.block.ModBlocks;

import java.util.List;

public class ModPlacedFeatures {
    public static final ResourceKey<PlacedFeature> WALNUT_PLACED_KEY = createKey("walnut_placed");
    public static final ResourceKey<PlacedFeature> END_SOIL_PLACED_KEY = createKey("end_soil_placed");
    public static final ResourceKey<PlacedFeature> BLOSSOMING_ROOT_PLACED_KEY = createKey("blossoming_root_placed");
    public static final ResourceKey<PlacedFeature> ENDER_ROOT_PLACED_KEY = createKey("ender_root_placed");


    public static void bootstrap(BootstapContext<PlacedFeature> context) {
        HolderGetter<ConfiguredFeature<?, ?>> configuredFeatures = context.lookup(Registries.CONFIGURED_FEATURE);

        register(context, WALNUT_PLACED_KEY, configuredFeatures.getOrThrow(ModConfiguredFeatures.WALNUT_KEY),
                VegetationPlacements.treePlacement(RarityFilter.onAverageOnceEvery(100), ModBlocks.WALNUT_SAPLING.get()));

        register(context, END_SOIL_PLACED_KEY, configuredFeatures.getOrThrow(ModConfiguredFeatures.END_SOIL_KEY),
                ModPlacementUtils.endSoilPlaced(28, HeightRangePlacement.uniform(VerticalAnchor.bottom(), VerticalAnchor.top())));

        register(context, BLOSSOMING_ROOT_PLACED_KEY, configuredFeatures.getOrThrow(ModConfiguredFeatures.BLOSSOMING_ROOT_KEY),
                RarityFilter.onAverageOnceEvery(4), InSquarePlacement.spread(), PlacementUtils.HEIGHTMAP, BiomeFilter.biome());

        register(context, ENDER_ROOT_PLACED_KEY, configuredFeatures.getOrThrow(ModConfiguredFeatures.ENDER_ROOT_KEY),
                RarityFilter.onAverageOnceEvery(4), InSquarePlacement.spread(), PlacementUtils.HEIGHTMAP, BiomeFilter.biome());
    }


    private static ResourceKey<PlacedFeature> createKey(String name) {
        return ResourceKey.create(Registries.PLACED_FEATURE, new ResourceLocation(VanillaVariations.MOD_ID, name));
    }

    private static void register(BootstapContext<PlacedFeature> context, ResourceKey<PlacedFeature> key, Holder<ConfiguredFeature<?, ?>> configuration,
                                 List<PlacementModifier> modifiers) {
        context.register(key, new PlacedFeature(configuration, List.copyOf(modifiers)));
    }

    private static void register(BootstapContext<PlacedFeature> context, ResourceKey<PlacedFeature> key, Holder<ConfiguredFeature<?, ?>> configuration,
                                 PlacementModifier... modifiers) {
        register(context, key, configuration, List.of(modifiers));
    }
}

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
    public static final ResourceKey<PlacedFeature> DEAD_ROOTS_PLACED_KEY = createKey("dead_roots_placed");
    public static final ResourceKey<PlacedFeature> SOUL_FLOWER_PLACED_KEY = createKey("soul_flower_placed");
    public static final ResourceKey<PlacedFeature> CRIMSON_BERRIES_PLACED_KEY = createKey("crimson_berries_placed");
    public static final ResourceKey<PlacedFeature> WARPED_BERRIES_PLACED_KEY = createKey("warped_berries_placed");
    public static final ResourceKey<PlacedFeature> WILD_CABBAGE_PLACED_KEY = createKey("wild_cabbage_placed");
    public static final ResourceKey<PlacedFeature> VIOLA_PLACED_KEY = createKey("viola_placed");
    public static final ResourceKey<PlacedFeature> MARIGOLD_PLACED_KEY = createKey("marigold_placed");
    public static final ResourceKey<PlacedFeature> LAVENDER_PLACED_KEY = createKey("lavender_placed");
    public static final ResourceKey<PlacedFeature> SNAPDRAGON_PLACED_KEY = createKey("snapdragon_placed");
    public static final ResourceKey<PlacedFeature> CRYSTAL_ORE_PLACED_KEY = createKey("crystal_ore_placed");
    public static final ResourceKey<PlacedFeature> GINGER_PLACED_KEY = createKey("ginger_placed");
    public static final ResourceKey<PlacedFeature> CRYING_BASALT_PLACED_KEY = createKey("crying_basalt_placed");
    public static final ResourceKey<PlacedFeature> ROCK_SALT_PLACED_KEY = createKey("rock_salt_placed");
    public static final ResourceKey<PlacedFeature> WATER_LILY_PLACED_KEY = createKey("water_lily_placed");


    public static void bootstrap(BootstapContext<PlacedFeature> context) {
        HolderGetter<ConfiguredFeature<?, ?>> configuredFeatures = context.lookup(Registries.CONFIGURED_FEATURE);

        register(context, WATER_LILY_PLACED_KEY, configuredFeatures.getOrThrow(ModConfiguredFeatures.WATER_LILY_KEY),
                PlacementUtils.HEIGHTMAP_OCEAN_FLOOR);

        register(context, WALNUT_PLACED_KEY, configuredFeatures.getOrThrow(ModConfiguredFeatures.WALNUT_KEY),
                VegetationPlacements.treePlacement(RarityFilter.onAverageOnceEvery(100), ModBlocks.WALNUT_SAPLING.get()));

        register(context, END_SOIL_PLACED_KEY, configuredFeatures.getOrThrow(ModConfiguredFeatures.END_SOIL_KEY),
                ModPlacementUtils.endSoilPlaced(28, HeightRangePlacement.uniform(VerticalAnchor.bottom(), VerticalAnchor.top())));

        register(context, ROCK_SALT_PLACED_KEY, configuredFeatures.getOrThrow(ModConfiguredFeatures.ROCK_SALT_KEY),
                ModPlacementUtils.commonOrePlacement(4, HeightRangePlacement.uniform(VerticalAnchor.bottom(), VerticalAnchor.absolute(0))));

        register(context, CRYING_BASALT_PLACED_KEY, configuredFeatures.getOrThrow(ModConfiguredFeatures.CRYING_BASALT_KEY),
                ModPlacementUtils.endSoilPlaced(1, HeightRangePlacement.uniform(VerticalAnchor.bottom(), VerticalAnchor.top())));

        register(context, BLOSSOMING_ROOT_PLACED_KEY, configuredFeatures.getOrThrow(ModConfiguredFeatures.BLOSSOMING_ROOT_KEY),
                RarityFilter.onAverageOnceEvery(4), InSquarePlacement.spread(), PlacementUtils.HEIGHTMAP);

        register(context, ENDER_ROOT_PLACED_KEY, configuredFeatures.getOrThrow(ModConfiguredFeatures.ENDER_ROOT_KEY),
                RarityFilter.onAverageOnceEvery(4), InSquarePlacement.spread(), PlacementUtils.HEIGHTMAP);

        register(context, DEAD_ROOTS_PLACED_KEY, configuredFeatures.getOrThrow(ModConfiguredFeatures.DEAD_ROOTS_KEY),
                RarityFilter.onAverageOnceEvery(1), InSquarePlacement.spread(), PlacementUtils.FULL_RANGE);

        register(context, SOUL_FLOWER_PLACED_KEY, configuredFeatures.getOrThrow(ModConfiguredFeatures.SOUL_FLOWER_KEY),
                PlacementUtils.FULL_RANGE);

        register(context, GINGER_PLACED_KEY, configuredFeatures.getOrThrow(ModConfiguredFeatures.GINGER_KEY),
                PlacementUtils.FULL_RANGE);

        register(context, CRIMSON_BERRIES_PLACED_KEY, configuredFeatures.getOrThrow(ModConfiguredFeatures.CRIMSON_BERRIES_KEY),
                RarityFilter.onAverageOnceEvery(1), InSquarePlacement.spread(), PlacementUtils.FULL_RANGE);

        register(context, WARPED_BERRIES_PLACED_KEY, configuredFeatures.getOrThrow(ModConfiguredFeatures.WARPED_BERRIES_KEY),
                RarityFilter.onAverageOnceEvery(1), InSquarePlacement.spread(), PlacementUtils.FULL_RANGE);

        register(context, WILD_CABBAGE_PLACED_KEY, configuredFeatures.getOrThrow(ModConfiguredFeatures.WILD_CABBAGE_KEY),
                RarityFilter.onAverageOnceEvery(4), PlacementUtils.FULL_RANGE);

        register(context, SNAPDRAGON_PLACED_KEY, configuredFeatures.getOrThrow(ModConfiguredFeatures.SNAPDRAGON_KEY),
                RarityFilter.onAverageOnceEvery(2), PlacementUtils.FULL_RANGE);

        register(context, LAVENDER_PLACED_KEY, configuredFeatures.getOrThrow(ModConfiguredFeatures.LAVENDER_KEY),
                RarityFilter.onAverageOnceEvery(2), PlacementUtils.FULL_RANGE);

        register(context, VIOLA_PLACED_KEY, configuredFeatures.getOrThrow(ModConfiguredFeatures.VIOLA_KEY),
                RarityFilter.onAverageOnceEvery(2), PlacementUtils.FULL_RANGE);

        register(context, MARIGOLD_PLACED_KEY, configuredFeatures.getOrThrow(ModConfiguredFeatures.MARIGOLD_KEY),
                RarityFilter.onAverageOnceEvery(4), PlacementUtils.FULL_RANGE);

        register(context, CRYSTAL_ORE_PLACED_KEY, configuredFeatures.getOrThrow(ModConfiguredFeatures.CRYSTAL_ORE_KEY),
                ModPlacementUtils.commonOrePlacement(2, HeightRangePlacement.triangle(VerticalAnchor.aboveBottom(10), VerticalAnchor.aboveBottom(80))));
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

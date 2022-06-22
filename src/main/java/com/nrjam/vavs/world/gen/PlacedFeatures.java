package com.nrjam.vavs.world.gen;

import net.minecraft.core.Holder;
import net.minecraft.data.worldgen.features.FeatureUtils;
import net.minecraft.data.worldgen.features.NetherFeatures;
import net.minecraft.data.worldgen.features.OreFeatures;
import net.minecraft.data.worldgen.placement.PlacementUtils;
import net.minecraft.data.worldgen.placement.VegetationPlacements;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.levelgen.VerticalAnchor;
import net.minecraft.world.level.levelgen.feature.ConfiguredFeature;
import net.minecraft.world.level.levelgen.feature.Feature;
import net.minecraft.world.level.levelgen.feature.configurations.RandomPatchConfiguration;
import net.minecraft.world.level.levelgen.feature.configurations.SimpleBlockConfiguration;
import net.minecraft.world.level.levelgen.feature.stateproviders.BlockStateProvider;
import net.minecraft.world.level.levelgen.placement.*;

import java.awt.*;
import java.util.List;

public class PlacedFeatures {
    public static final Holder<PlacedFeature> WALNUT_PLACED = PlacementUtils.register("walnut_placed",
            ConfiguredFeatures.WALNUT_SPAWN, VegetationPlacements.treePlacement(
                    PlacementUtils.countExtra(0, 0.1f, 1)));
    public static final Holder<PlacedFeature> SOUL_FLOWER_PLACED = PlacementUtils.register("soul_flower_placed", ConfiguredFeatures.SOUL_FLOWER_CONFIG, PlacementUtils.FULL_RANGE, BiomeFilter.biome());
    public static final Holder<PlacedFeature> END_SOIL_PLACED = PlacementUtils.register("end_soil_placed", ConfiguredFeatures.END_SOIL_CONFIG, endSoilPlaced(28, HeightRangePlacement.uniform(VerticalAnchor.bottom(), VerticalAnchor.top())));
    public static final Holder<PlacedFeature> WARPED_SOUL_BERRY_PLACED = PlacementUtils.register("warped_soul_berry_placed", ConfiguredFeatures.WARPED_SOUL_BERRY, CountOnEveryLayerPlacement.of(1), BiomeFilter.biome());
    public static final Holder<PlacedFeature> CRIMSON_FIRE_BERRY_PLACED = PlacementUtils.register("crimson_fire_berry_placed", ConfiguredFeatures.CRIMSON_FIRE_BERRY, CountOnEveryLayerPlacement.of(1), BiomeFilter.biome());
    public static final Holder<PlacedFeature> DEAD_ROOTS_PLACED = PlacementUtils.register("dead_roots_placed", ConfiguredFeatures.DEAD_ROOTS_CONFIG, PlacementUtils.FULL_RANGE, BiomeFilter.biome());
    public static final Holder<PlacedFeature> DEAD_ROOTS_PLACED_2 = PlacementUtils.register("dead_roots_placed_2", ConfiguredFeatures.DEAD_ROOTS_CONFIG_2, PlacementUtils.FULL_RANGE, BiomeFilter.biome());
    public static final Holder<PlacedFeature> DEAD_ROOTS_PLACED_3 = PlacementUtils.register("dead_roots_placed_3", ConfiguredFeatures.DEAD_ROOTS_CONFIG_3, PlacementUtils.FULL_RANGE, BiomeFilter.biome());
    public static final Holder<PlacedFeature> VIOLA_PLACED = PlacementUtils.register("viola_placed",
            ConfiguredFeatures.VIOLA_CONFIG, RarityFilter.onAverageOnceEvery(16),
                    InSquarePlacement.spread(), PlacementUtils.HEIGHTMAP, BiomeFilter.biome());
    public static final Holder<PlacedFeature> WILD_CABBAGE_PLACED = PlacementUtils.register("wild_cabbage_placed",
            ConfiguredFeatures.WILD_CABBAGE_CONFIG, RarityFilter.onAverageOnceEvery(32),
                    InSquarePlacement.spread(), PlacementUtils.HEIGHTMAP, BiomeFilter.biome());
    public static final Holder<PlacedFeature> MARIGOLD_PLACED = PlacementUtils.register("marigold_placed",
            ConfiguredFeatures.MARIGOLD_CONFIG, RarityFilter.onAverageOnceEvery(16),
                    InSquarePlacement.spread(), PlacementUtils.HEIGHTMAP, BiomeFilter.biome());
    public static final Holder<PlacedFeature> BLOSSOMING_ROOT_PLACED = PlacementUtils.register("blossoming_root_placed",
            ConfiguredFeatures.BLOSSOMING_ROOT_CONFIG, RarityFilter.onAverageOnceEvery(4),
                    InSquarePlacement.spread(), PlacementUtils.HEIGHTMAP, BiomeFilter.biome());
    public static final Holder<PlacedFeature> ENDER_ROOT_PLACED = PlacementUtils.register("ender_root_placed",
            ConfiguredFeatures.ENDER_ROOT_CONFIG, RarityFilter.onAverageOnceEvery(4),
                    InSquarePlacement.spread(), PlacementUtils.HEIGHTMAP, BiomeFilter.biome());
    public static final Holder<PlacedFeature> LAVENDER_PLACED = PlacementUtils.register("lavender_placed",
            ConfiguredFeatures.LAVENDER_CONFIG, RarityFilter.onAverageOnceEvery(16),
                    InSquarePlacement.spread(), PlacementUtils.HEIGHTMAP, BiomeFilter.biome());
    public static final Holder<PlacedFeature> SNAPDRAGON_PLACED = PlacementUtils.register("snapdragon_placed",
            ConfiguredFeatures.SNAPDRAGON_CONFIG, RarityFilter.onAverageOnceEvery(16),
                    InSquarePlacement.spread(), PlacementUtils.HEIGHTMAP, BiomeFilter.biome());

    public static final Holder<PlacedFeature> NETHER_CRYSTAL_ORE_PLACED = PlacementUtils.register("nether_crystal_ore_placed",
            ConfiguredFeatures.NETHER_CRYSTAL_ORE, OrePlacement.commonOrePlacement(2, // VeinsPerChunk
                    HeightRangePlacement.triangle(VerticalAnchor.aboveBottom(10), VerticalAnchor.aboveBottom(80))));

    public static final Holder<PlacedFeature> SALT_ORE_PLACED = PlacementUtils.register("citrine_ore_placed",
            ConfiguredFeatures.SALT_ORE, OrePlacement.commonOrePlacement(7, // VeinsPerChunk
                    HeightRangePlacement.triangle(VerticalAnchor.aboveBottom(-30), VerticalAnchor.aboveBottom(96))));

    private static List<PlacementModifier> soilPlacement(PlacementModifier p_195347_, PlacementModifier p_195348_) {
        return List.of(p_195347_, InSquarePlacement.spread(), p_195348_, BiomeFilter.biome());
    }

    private static List<PlacementModifier> endSoilPlaced(int p_195344_, PlacementModifier p_195345_) {
        return soilPlacement(CountPlacement.of(p_195344_), p_195345_);
    }
}

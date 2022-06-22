package com.nrjam.vavs.world.gen;

import com.nrjam.vavs.block.ModBlocks;
import net.minecraft.core.Holder;
import net.minecraft.core.Registry;
import net.minecraft.data.BuiltinRegistries;
import net.minecraft.data.worldgen.features.FeatureUtils;
import net.minecraft.data.worldgen.features.OreFeatures;
import net.minecraft.data.worldgen.placement.PlacementUtils;
import net.minecraft.util.random.SimpleWeightedRandomList;
import net.minecraft.util.valueproviders.ConstantInt;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.levelgen.feature.ConfiguredFeature;
import net.minecraft.world.level.levelgen.feature.Feature;
import net.minecraft.world.level.levelgen.feature.WeightedPlacedFeature;
import net.minecraft.world.level.levelgen.feature.configurations.*;
import net.minecraft.world.level.levelgen.feature.featuresize.TwoLayersFeatureSize;
import net.minecraft.world.level.levelgen.feature.foliageplacers.FancyFoliagePlacer;
import net.minecraft.world.level.levelgen.feature.foliageplacers.RandomSpreadFoliagePlacer;
import net.minecraft.world.level.levelgen.feature.stateproviders.BlockStateProvider;
import net.minecraft.world.level.levelgen.feature.stateproviders.WeightedStateProvider;
import net.minecraft.world.level.levelgen.feature.trunkplacers.ForkingTrunkPlacer;
import net.minecraft.world.level.levelgen.feature.trunkplacers.StraightTrunkPlacer;
import net.minecraft.world.level.levelgen.placement.PlacedFeature;
import net.minecraft.world.level.levelgen.structure.templatesystem.BlockMatchTest;

import java.util.List;

public class ConfiguredFeatures {
    public static final Holder<ConfiguredFeature<TreeConfiguration, ?>> WALNUT_TREE =
            FeatureUtils.register("walnut", Feature.TREE, new TreeConfiguration.TreeConfigurationBuilder(
                    BlockStateProvider.simple(ModBlocks.WALNUT_LOG.get()),
                    new StraightTrunkPlacer(5, 6, 3),
                    BlockStateProvider.simple(ModBlocks.WALNUT_LEAVES.get()),
                    new FancyFoliagePlacer(ConstantInt.of(2), ConstantInt.of(0), 4),
                    new TwoLayersFeatureSize(1, 0, 2)).build());

    public static final Holder<PlacedFeature> WALNUT_CHECKED = PlacementUtils.register("walnut_checked", WALNUT_TREE,
            PlacementUtils.filteredByBlockSurvival(ModBlocks.WALNUT_SAPLING.get()));

    public static final Holder<ConfiguredFeature<RandomFeatureConfiguration, ?>> WALNUT_SPAWN =
            FeatureUtils.register("ebony_spawn", Feature.RANDOM_SELECTOR,
                    new RandomFeatureConfiguration(List.of(new WeightedPlacedFeature(WALNUT_CHECKED,
                            0.1F)), WALNUT_CHECKED));

    public static final Holder<ConfiguredFeature<OreConfiguration, ?>> END_SOIL_CONFIG =
            FeatureUtils.register("end_soil_feature", Feature.ORE,
                    new OreConfiguration(new BlockMatchTest(Blocks.END_STONE), ModBlocks.END_SOIL.get().defaultBlockState(), 64));

    public static final Holder<ConfiguredFeature<RandomPatchConfiguration, ?>> VIOLA_CONFIG =
            FeatureUtils.register("viola_feature", Feature.FLOWER,
                    new RandomPatchConfiguration(32, 6, 2, PlacementUtils.onlyWhenEmpty(Feature.SIMPLE_BLOCK,
                            new SimpleBlockConfiguration(BlockStateProvider.simple(ModBlocks.VIOLA.get())))));

    public static final Holder<ConfiguredFeature<RandomPatchConfiguration, ?>> BLOSSOMING_ROOT_CONFIG =
            FeatureUtils.register("blossoming_root_feature", Feature.RANDOM_PATCH,
                    new RandomPatchConfiguration(128, 12, 5, PlacementUtils.onlyWhenEmpty(Feature.SIMPLE_BLOCK,
                            new SimpleBlockConfiguration(BlockStateProvider.simple(ModBlocks.BLOSSOMING_ROOT.get())))));

    public static final Holder<ConfiguredFeature<RandomPatchConfiguration, ?>> ENDER_ROOT_CONFIG =
            FeatureUtils.register("ender_root_feature", Feature.RANDOM_PATCH,
                    new RandomPatchConfiguration(128, 12, 5, PlacementUtils.onlyWhenEmpty(Feature.SIMPLE_BLOCK,
                            new SimpleBlockConfiguration(BlockStateProvider.simple(ModBlocks.ENDER_ROOT.get())))));

    public static final Holder<ConfiguredFeature<RandomPatchConfiguration, ?>> LAVENDER_CONFIG =
            FeatureUtils.register("lavender_feature", Feature.FLOWER,
                    new RandomPatchConfiguration(48, 10, 5, PlacementUtils.onlyWhenEmpty(Feature.SIMPLE_BLOCK,
                            new SimpleBlockConfiguration(BlockStateProvider.simple(ModBlocks.LAVENDER.get())))));

    public static final Holder<ConfiguredFeature<RandomPatchConfiguration, ?>> MARIGOLD_CONFIG =
            FeatureUtils.register("marigold_feature", Feature.FLOWER,
                    new RandomPatchConfiguration(48, 10, 5, PlacementUtils.onlyWhenEmpty(Feature.SIMPLE_BLOCK,
                            new SimpleBlockConfiguration(BlockStateProvider.simple(ModBlocks.MARIGOLD.get())))));

    public static final Holder<ConfiguredFeature<RandomPatchConfiguration, ?>> SNAPDRAGON_CONFIG =
            FeatureUtils.register("snapdragon_feature", Feature.FLOWER,
                    new RandomPatchConfiguration(48, 10, 5, PlacementUtils.onlyWhenEmpty(Feature.SIMPLE_BLOCK,
                            new SimpleBlockConfiguration(BlockStateProvider.simple(ModBlocks.SNAPDRAGON.get())))));

    public static final Holder<ConfiguredFeature<RandomPatchConfiguration, ?>> WILD_CABBAGE_CONFIG =
            FeatureUtils.register("wild_cabbage_feature", Feature.FLOWER,
                    new RandomPatchConfiguration(21, 5, 2, PlacementUtils.onlyWhenEmpty(Feature.SIMPLE_BLOCK,
                            new SimpleBlockConfiguration(BlockStateProvider.simple(ModBlocks.WILD_CABBAGES.get())))));

    public static final Holder<ConfiguredFeature<RandomPatchConfiguration, ?>> SOUL_FLOWER_CONFIG =
            FeatureUtils.register("soul_flower_feature", Feature.RANDOM_PATCH,
                    FeatureUtils.simplePatchConfiguration(Feature.SIMPLE_BLOCK,
                            new SimpleBlockConfiguration(BlockStateProvider.simple(ModBlocks.SOUL_FLOWER.get()))));

    public static final WeightedStateProvider WARPED_SOUL_BERRY_PROVIDER = new WeightedStateProvider(SimpleWeightedRandomList.<BlockState>builder().add(ModBlocks.WARPED_SOUL_BERRY.get().defaultBlockState(), 50));
    public static final Holder<ConfiguredFeature<NetherForestVegetationConfig, ?>> WARPED_SOUL_BERRY =
            FeatureUtils.register("warped_soul_berry", Feature.NETHER_FOREST_VEGETATION,
                    new NetherForestVegetationConfig(WARPED_SOUL_BERRY_PROVIDER, 3, 2));

    public static final WeightedStateProvider CRIMSON_FIRE_BERRY_PROVIDER = new WeightedStateProvider(SimpleWeightedRandomList.<BlockState>builder().add(ModBlocks.CRIMSON_FIRE_BERRY.get().defaultBlockState(), 50));
    public static final Holder<ConfiguredFeature<NetherForestVegetationConfig, ?>> CRIMSON_FIRE_BERRY =
            FeatureUtils.register("crimson_fire_berry", Feature.NETHER_FOREST_VEGETATION,
                    new NetherForestVegetationConfig(CRIMSON_FIRE_BERRY_PROVIDER, 3, 2));

    public static final Holder<ConfiguredFeature<RandomPatchConfiguration, ?>> DEAD_ROOTS_CONFIG =
            FeatureUtils.register("dead_roots_feature", Feature.RANDOM_PATCH,
                    FeatureUtils.simplePatchConfiguration(Feature.SIMPLE_BLOCK,
                            new SimpleBlockConfiguration(BlockStateProvider.simple(ModBlocks.DEAD_ROOTS.get()))));

    public static final Holder<ConfiguredFeature<RandomPatchConfiguration, ?>> DEAD_ROOTS_CONFIG_2 =
            FeatureUtils.register("dead_roots_feature2", Feature.RANDOM_PATCH,
                    FeatureUtils.simplePatchConfiguration(Feature.SIMPLE_BLOCK,
                            new SimpleBlockConfiguration(BlockStateProvider.simple(ModBlocks.DEAD_ROOTS.get()))));
    public static final Holder<ConfiguredFeature<RandomPatchConfiguration, ?>> DEAD_ROOTS_CONFIG_3 =

            FeatureUtils.register("dead_roots_feature3", Feature.RANDOM_PATCH,
                    FeatureUtils.simplePatchConfiguration(Feature.SIMPLE_BLOCK,
                            new SimpleBlockConfiguration(BlockStateProvider.simple(ModBlocks.DEAD_ROOTS.get()))));

    private static <FC extends FeatureConfiguration>ConfiguredFeature<FC, ?> register(String name,
                                                                                      ConfiguredFeature<FC, ?> configuredFeature) {
        return Registry.register(BuiltinRegistries.CONFIGURED_FEATURE, name, configuredFeature);
    }

    public static final List<OreConfiguration.TargetBlockState> NETHER_CRYSTAL_ORES = List.of(
            OreConfiguration.target(OreFeatures.NETHER_ORE_REPLACEABLES, ModBlocks.NETHER_CRYSTAL_ORE.get().defaultBlockState()));

    public static final Holder<ConfiguredFeature<OreConfiguration, ?>> NETHER_CRYSTAL_ORE = FeatureUtils.register("nether_crystal_ore",
            Feature.ORE, new OreConfiguration(NETHER_CRYSTAL_ORES, 4)); //MaxVeinSize


    public static final List<OreConfiguration.TargetBlockState> OVERWORLD_SALT_ORES = List.of(
            OreConfiguration.target(OreFeatures.STONE_ORE_REPLACEABLES, ModBlocks.SALT_ORE.get().defaultBlockState()),
            OreConfiguration.target(OreFeatures.DEEPSLATE_ORE_REPLACEABLES, ModBlocks.DEEPSLATE_SALT_ORE.get().defaultBlockState()));

    public static final Holder<ConfiguredFeature<OreConfiguration, ?>> SALT_ORE = FeatureUtils.register("salt_ore",
            Feature.ORE, new OreConfiguration(OVERWORLD_SALT_ORES, 6));
}

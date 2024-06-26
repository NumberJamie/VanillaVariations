package net.nrjam.vavs.worldgen;

import net.minecraft.core.Direction;
import net.minecraft.core.registries.Registries;
import net.minecraft.data.worldgen.BootstapContext;
import net.minecraft.data.worldgen.features.FeatureUtils;
import net.minecraft.data.worldgen.placement.PlacementUtils;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.BlockTags;
import net.minecraft.util.random.SimpleWeightedRandomList;
import net.minecraft.util.valueproviders.ConstantInt;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.levelgen.blockpredicates.BlockPredicate;
import net.minecraft.world.level.levelgen.feature.ConfiguredFeature;
import net.minecraft.world.level.levelgen.feature.Feature;
import net.minecraft.world.level.levelgen.feature.configurations.*;
import net.minecraft.world.level.levelgen.feature.featuresize.TwoLayersFeatureSize;
import net.minecraft.world.level.levelgen.feature.foliageplacers.FancyFoliagePlacer;
import net.minecraft.world.level.levelgen.feature.stateproviders.BlockStateProvider;
import net.minecraft.world.level.levelgen.feature.stateproviders.WeightedStateProvider;
import net.minecraft.world.level.levelgen.feature.trunkplacers.FancyTrunkPlacer;
import net.minecraft.world.level.levelgen.structure.templatesystem.BlockMatchTest;
import net.minecraft.world.level.levelgen.structure.templatesystem.RuleTest;
import net.minecraft.world.level.levelgen.structure.templatesystem.TagMatchTest;
import net.nrjam.vavs.VanillaVariations;
import net.nrjam.vavs.block.ModBlocks;
import net.nrjam.vavs.block.natural.BerryBush;

import java.util.List;

public class ModConfiguredFeatures {
    public static final ResourceKey<ConfiguredFeature<?, ?>> WALNUT_KEY = registerKey("walnut");
    public static final ResourceKey<ConfiguredFeature<?, ?>> END_SOIL_KEY = registerKey("end_soil");
    public static final ResourceKey<ConfiguredFeature<?, ?>> BLOSSOMING_ROOT_KEY = registerKey("blossoming_root");
    public static final ResourceKey<ConfiguredFeature<?, ?>> ENDER_ROOT_KEY = registerKey("ender_root");
    public static final ResourceKey<ConfiguredFeature<?, ?>> SOUL_FLOWER_KEY = registerKey("soul_flower");
    public static final ResourceKey<ConfiguredFeature<?, ?>> DEAD_ROOTS_KEY = registerKey("dead_roots");
    public static final ResourceKey<ConfiguredFeature<?, ?>> CRIMSON_BERRIES_KEY = registerKey("crimson_berries");
    public static final ResourceKey<ConfiguredFeature<?, ?>> WARPED_BERRIES_KEY = registerKey("warped_berries");
    public static final ResourceKey<ConfiguredFeature<?, ?>> WILD_CABBAGE_KEY = registerKey("wild_cabbage");
    public static final ResourceKey<ConfiguredFeature<?, ?>> VIOLA_KEY = registerKey("viola");
    public static final ResourceKey<ConfiguredFeature<?, ?>> SNAPDRAGON_KEY = registerKey("snapdragon");
    public static final ResourceKey<ConfiguredFeature<?, ?>> MARIGOLD_KEY = registerKey("marigold");
    public static final ResourceKey<ConfiguredFeature<?, ?>> LAVENDER_KEY = registerKey("lavender");
    public static final ResourceKey<ConfiguredFeature<?, ?>> CRYSTAL_ORE_KEY = registerKey("crystal_ore");
    public static final ResourceKey<ConfiguredFeature<?, ?>> GINGER_KEY = registerKey("ginger");
    public static final ResourceKey<ConfiguredFeature<?, ?>> CRYING_BASALT_KEY = registerKey("crying_basalt");
    public static final ResourceKey<ConfiguredFeature<?, ?>> ROCK_SALT_KEY = registerKey("rock_salt");
    public static final ResourceKey<ConfiguredFeature<?, ?>> WATER_LILY_KEY = registerKey("water_lily");

    public static void bootstrap(BootstapContext<ConfiguredFeature<?, ?>> context) {
        RuleTest endStoneReplaceable = new BlockMatchTest(Blocks.END_STONE);
        RuleTest netherRackReplaceable = new BlockMatchTest(Blocks.NETHERRACK);
        RuleTest basaltReplaceable = new BlockMatchTest(Blocks.BASALT);
        RuleTest deepslateReplaceable = new TagMatchTest(BlockTags.DEEPSLATE_ORE_REPLACEABLES);

        register(context, WATER_LILY_KEY, Feature.RANDOM_PATCH,
                new RandomPatchConfiguration(24, 10, 3, PlacementUtils.onlyWhenEmpty(Feature.SIMPLE_BLOCK,
                        new SimpleBlockConfiguration(new WeightedStateProvider(SimpleWeightedRandomList.<BlockState>builder()
                                .add(ModBlocks.WATER_LILY_PAD.get().defaultBlockState(), 15)
                                .add(ModBlocks.WATER_LILY.get().defaultBlockState(), 5))))));

        register(context, WALNUT_KEY, Feature.TREE, new TreeConfiguration.TreeConfigurationBuilder(
                BlockStateProvider.simple(ModBlocks.WALNUT_LOG.get()),
                new FancyTrunkPlacer(5, 8, 3),
                BlockStateProvider.simple(ModBlocks.WALNUT_LEAVES.get()),
                new FancyFoliagePlacer(ConstantInt.of(2), ConstantInt.of(4), 4),
                new TwoLayersFeatureSize(0, 0, 0)).build());

        register(context, END_SOIL_KEY, Feature.ORE, new OreConfiguration(
                endStoneReplaceable,
                ModBlocks.END_SOIL.get().defaultBlockState(), 64));

        register(context, ROCK_SALT_KEY, Feature.ORE, new OreConfiguration(
                deepslateReplaceable,
                ModBlocks.ROCK_SALT_BLOCK.get().defaultBlockState(), 8));

        register(context, CRYING_BASALT_KEY, Feature.ORE, new OreConfiguration(
                basaltReplaceable,
                ModBlocks.CRYING_BASALT.get().defaultBlockState(), 24));

        register(context, BLOSSOMING_ROOT_KEY, Feature.RANDOM_PATCH, new RandomPatchConfiguration(
                128, 12, 5, PlacementUtils.filtered(Feature.SIMPLE_BLOCK,
                new SimpleBlockConfiguration(BlockStateProvider.simple(ModBlocks.BLOSSOMING_ROOT.get())),
                BlockPredicate.allOf(BlockPredicate.replaceable(), BlockPredicate.noFluid(), BlockPredicate.matchesBlocks(Direction.DOWN.getNormal(), ModBlocks.END_SOIL.get())))
        ));

        register(context, ENDER_ROOT_KEY, Feature.RANDOM_PATCH, new RandomPatchConfiguration(
                128, 12, 5, PlacementUtils.filtered(Feature.SIMPLE_BLOCK,
                new SimpleBlockConfiguration(BlockStateProvider.simple(ModBlocks.ENDER_ROOT.get())),
                BlockPredicate.allOf(BlockPredicate.replaceable(), BlockPredicate.noFluid(), BlockPredicate.matchesBlocks(Direction.DOWN.getNormal(), ModBlocks.END_SOIL.get())))
        ));

        register(context, SOUL_FLOWER_KEY, Feature.RANDOM_PATCH, FeatureUtils.simplePatchConfiguration(
                Feature.SIMPLE_BLOCK, new SimpleBlockConfiguration(BlockStateProvider.simple(ModBlocks.SOUL_FLOWER.get())),
                List.of(Blocks.SOUL_SOIL, Blocks.SOUL_SAND)
        ));

        register(context, GINGER_KEY, Feature.RANDOM_PATCH, FeatureUtils.simplePatchConfiguration(
                Feature.SIMPLE_BLOCK, new SimpleBlockConfiguration(BlockStateProvider.simple(ModBlocks.WILD_GINGER.get())),
                List.of(Blocks.BASALT)
        ));

        register(context, DEAD_ROOTS_KEY, Feature.RANDOM_PATCH, new RandomPatchConfiguration(
                256, 12, 12, PlacementUtils.filtered(Feature.SIMPLE_BLOCK,
                new SimpleBlockConfiguration(BlockStateProvider.simple(ModBlocks.DEAD_ROOTS.get())),
                BlockPredicate.allOf(BlockPredicate.replaceable(), BlockPredicate.noFluid(), BlockPredicate.matchesBlocks(Direction.DOWN.getNormal(), Blocks.NETHERRACK)))
        ));

        register(context, CRIMSON_BERRIES_KEY, Feature.RANDOM_PATCH, FeatureUtils.simplePatchConfiguration(Feature.SIMPLE_BLOCK, new SimpleBlockConfiguration(
                BlockStateProvider.simple(ModBlocks.CRIMSON_BERRIES.get().defaultBlockState().setValue(BerryBush.AGE, 3))), List.of(Blocks.CRIMSON_NYLIUM)));

        register(context, WARPED_BERRIES_KEY, Feature.RANDOM_PATCH, FeatureUtils.simplePatchConfiguration(Feature.SIMPLE_BLOCK, new SimpleBlockConfiguration(
                BlockStateProvider.simple(ModBlocks.WARPED_BERRIES.get().defaultBlockState().setValue(BerryBush.AGE, 3))), List.of(Blocks.WARPED_NYLIUM)));

        register(context, WILD_CABBAGE_KEY, Feature.RANDOM_PATCH, FeatureUtils.simplePatchConfiguration(Feature.SIMPLE_BLOCK, new SimpleBlockConfiguration(
                BlockStateProvider.simple(ModBlocks.WILD_CABBAGE.get().defaultBlockState())), List.of(Blocks.GRASS_BLOCK)));

        register(context, VIOLA_KEY, Feature.RANDOM_PATCH, FeatureUtils.simplePatchConfiguration(Feature.SIMPLE_BLOCK, new SimpleBlockConfiguration(
                BlockStateProvider.simple(ModBlocks.VIOLA.get().defaultBlockState())), List.of(Blocks.GRASS_BLOCK)));

        register(context, MARIGOLD_KEY, Feature.RANDOM_PATCH, FeatureUtils.simplePatchConfiguration(Feature.SIMPLE_BLOCK, new SimpleBlockConfiguration(
                BlockStateProvider.simple(ModBlocks.MARIGOLD.get().defaultBlockState())), List.of(Blocks.GRASS_BLOCK)));

        register(context, LAVENDER_KEY, Feature.RANDOM_PATCH, FeatureUtils.simplePatchConfiguration(Feature.SIMPLE_BLOCK, new SimpleBlockConfiguration(
                BlockStateProvider.simple(ModBlocks.LAVENDER.get().defaultBlockState())), List.of(Blocks.GRASS_BLOCK)));

        register(context, SNAPDRAGON_KEY, Feature.RANDOM_PATCH, FeatureUtils.simplePatchConfiguration(Feature.SIMPLE_BLOCK, new SimpleBlockConfiguration(
                BlockStateProvider.simple(ModBlocks.SNAPDRAGON.get().defaultBlockState())), List.of(Blocks.GRASS_BLOCK)));

        register(context, CRYSTAL_ORE_KEY, Feature.ORE, new OreConfiguration(netherRackReplaceable, ModBlocks.CRYSTAL_ORE.get().defaultBlockState(), 4));
    }

    public static ResourceKey<ConfiguredFeature<?, ?>> registerKey(String name) {
        return ResourceKey.create(Registries.CONFIGURED_FEATURE, new ResourceLocation(VanillaVariations.MOD_ID, name));
    }

    private static <FC extends FeatureConfiguration, F extends Feature<FC>> void register(BootstapContext<ConfiguredFeature<?, ?>> context, ResourceKey<ConfiguredFeature<?, ?>> key, F feature, FC configuration) {
        context.register(key, new ConfiguredFeature<>(feature, configuration));
    }
}

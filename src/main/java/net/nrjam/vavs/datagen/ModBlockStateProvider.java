package net.nrjam.vavs.datagen;

import net.minecraft.data.PackOutput;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.block.*;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraftforge.client.model.generators.BlockStateProvider;
import net.minecraftforge.client.model.generators.ConfiguredModel;
import net.minecraftforge.client.model.generators.ModelFile;
import net.minecraftforge.client.model.generators.VariantBlockStateBuilder;
import net.minecraftforge.common.data.ExistingFileHelper;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;
import net.nrjam.vavs.VanillaVariations;
import net.nrjam.vavs.block.ModBlocks;
import net.nrjam.vavs.block.custom.ModCakeBlock;
import net.nrjam.vavs.block.custom.NetherFarmland;
import net.nrjam.vavs.block.natural.*;

import java.util.Objects;
import java.util.function.Function;


public class ModBlockStateProvider extends BlockStateProvider {

    public ModBlockStateProvider(PackOutput output, ExistingFileHelper exFileHelper) {
        super(output, VanillaVariations.MOD_ID, exFileHelper);
    }

    @Override
    protected void registerStatesAndModels() {
        blockWithItem(ModBlocks.REINFORCED_LEATHER_BLOCK);
        blockWithItem(ModBlocks.CRYSTAL_BLOCK);
        blockWithItem(ModBlocks.CRYSTAL_ORE);
        blockWithItem(ModBlocks.ROCK_SALT_BLOCK);
        blockWithItem(ModBlocks.CRYING_SMOOTH_BASALT);

        logBlock(((RotatedPillarBlock) ModBlocks.WALNUT_LOG.get()));
        axisBlock((RotatedPillarBlock) ModBlocks.WALNUT_WOOD.get(), blockTexture(ModBlocks.WALNUT_LOG.get()), blockTexture(ModBlocks.WALNUT_LOG.get()));
        axisBlock((RotatedPillarBlock) ModBlocks.STRIPPED_WALNUT_LOG.get(), new ResourceLocation(VanillaVariations.MOD_ID, "block/stripped_walnut_log"),
                new ResourceLocation(VanillaVariations.MOD_ID, "block/stripped_walnut_log_top"));
        axisBlock((RotatedPillarBlock) ModBlocks.STRIPPED_WALNUT_WOOD.get(), new ResourceLocation(VanillaVariations.MOD_ID, "block/stripped_walnut_log"),
                new ResourceLocation(VanillaVariations.MOD_ID, "block/stripped_walnut_log"));

        axisBlock((RotatedPillarBlock) ModBlocks.CRYING_POLISHED_BASALT.get(), new ResourceLocation(VanillaVariations.MOD_ID, "block/crying_polished_basalt_side"),
                new ResourceLocation(VanillaVariations.MOD_ID, "block/crying_polished_basalt_top"));
        axisBlock((RotatedPillarBlock) ModBlocks.CRYING_BASALT.get(), new ResourceLocation(VanillaVariations.MOD_ID, "block/crying_basalt_side"),
                new ResourceLocation(VanillaVariations.MOD_ID, "block/crying_basalt_top"));

        blockWithItem(ModBlocks.WALNUT_PLANKS);
        blockWithItem(ModBlocks.WALNUT_LEAVES);
        saplingBlock(ModBlocks.WALNUT_SAPLING);
        saplingBlock(ModBlocks.BLOSSOMING_ROOT);
        saplingBlock(ModBlocks.SOUL_FLOWER);
        saplingBlock(ModBlocks.DEAD_ROOTS);
        saplingBlock(ModBlocks.ENDER_ROOT);
        saplingBlock(ModBlocks.WILD_CABBAGE);
        saplingBlock(ModBlocks.LAVENDER);
        saplingBlock(ModBlocks.MARIGOLD);
        saplingBlock(ModBlocks.VIOLA);
        saplingBlock(ModBlocks.SNAPDRAGON);
        saplingBlock(ModBlocks.WILD_GINGER);
        blockWithItem(ModBlocks.SOUL_STONE);
        blockWithItem(ModBlocks.SOUL_LIGHT);

        PottedPlant(ModBlocks.POTTED_BLOSSOMING_ROOT.get(), ModBlocks.BLOSSOMING_ROOT.get());
        PottedPlant(ModBlocks.POTTED_ENDER_ROOT.get(), ModBlocks.ENDER_ROOT.get());
        PottedPlant(ModBlocks.POTTED_WALNUT_SAPLING.get(), ModBlocks.WALNUT_SAPLING.get());
        PottedPlant(ModBlocks.POTTED_SOUL_FLOWER.get(), ModBlocks.SOUL_FLOWER.get());
        PottedPlant(ModBlocks.POTTED_DEAD_ROOTS.get(), ModBlocks.DEAD_ROOTS.get());
        PottedPlant(ModBlocks.POTTED_WILD_CABBAGE.get(), ModBlocks.WILD_CABBAGE.get());
        PottedPlant(ModBlocks.POTTED_LAVENDER.get(), ModBlocks.LAVENDER.get());
        PottedPlant(ModBlocks.POTTED_MARIGOLD.get(), ModBlocks.MARIGOLD.get());
        PottedPlant(ModBlocks.POTTED_VIOLA.get(), ModBlocks.VIOLA.get());
        PottedPlant(ModBlocks.POTTED_SNAPDRAGON.get(), ModBlocks.SNAPDRAGON.get());

        slabBlock(ModBlocks.WALNUT_SLAB.get(), blockTexture(ModBlocks.WALNUT_PLANKS.get()), blockTexture(ModBlocks.WALNUT_PLANKS.get()));
        stairsBlock(ModBlocks.WALNUT_STAIRS.get(), blockTexture(ModBlocks.WALNUT_PLANKS.get()));
        slabBlock(ModBlocks.SOUL_STONE_SLAB.get(), blockTexture(ModBlocks.SOUL_STONE.get()), blockTexture(ModBlocks.SOUL_STONE.get()));
        stairsBlock(ModBlocks.SOUL_STONE_STAIRS.get(), blockTexture(ModBlocks.SOUL_STONE.get()));
        trapdoorBlockWithRenderType(ModBlocks.WALNUT_TRAPDOOR.get(), new ResourceLocation(VanillaVariations.MOD_ID, "block/walnut_trapdoor"), true, "cutout");
        doorBlockWithRenderType(ModBlocks.WALNUT_DOOR.get(), new ResourceLocation(VanillaVariations.MOD_ID, "block/walnut_door_bottom"),
                new ResourceLocation(VanillaVariations.MOD_ID, "block/walnut_door_top"), "cutout");
        buttonBlock(ModBlocks.WALNUT_BUTTON.get(), blockTexture(ModBlocks.WALNUT_PLANKS.get()));
        pressurePlateBlock(ModBlocks.WALNUT_PRESSURE_PLATE.get(), blockTexture(ModBlocks.WALNUT_PLANKS.get()));
        fenceBlock(ModBlocks.WALNUT_FENCE.get(), blockTexture(ModBlocks.WALNUT_PLANKS.get()));
        fenceGateBlock(ModBlocks.WALNUT_FENCE_GATE.get(), blockTexture(ModBlocks.WALNUT_PLANKS.get()));

        makeCrop((SoulSprouts)ModBlocks.SOUL_SPROUTS.get(), "soul_sprouts_stage", "soul_sprouts_stage", true);
        makeCrop((GingerCrop)ModBlocks.GINGER_CROP.get(), "ginger_stage", "ginger_stage", true);
        makeCrop((CabbageCrop)ModBlocks.CABBAGE_CROP.get(), "cabbage_stage", "cabbage_stage", false);
        makeCrop((AmaranthCrop)ModBlocks.AMARANTH_CROP.get(), "amaranth_stage", "amaranth_stage", false);

        makeBush((WarpedBerry)ModBlocks.WARPED_BERRIES.get(), "warped_berries_stage", "warped_berries_stage");
        makeBush((CrimsonBerry)ModBlocks.CRIMSON_BERRIES.get(), "crimson_berries_stage", "crimson_berries_stage");

        wallBlock(ModBlocks.SOUL_STONE_WALL.get(), blockTexture(ModBlocks.SOUL_STONE.get()));

        farmland(ModBlocks.NETHER_FARMLAND.get(), Blocks.SOUL_SOIL);

        simpleBlockItem(ModBlocks.SOUL_STONE_WALL.get(), models().withExistingParent("vavs:soul_stone_wall", "minecraft:block/wall_inventory").texture("wall", "vavs:block/soul_stone"));
        simpleBlockItem(ModBlocks.WALNUT_SLAB.get(), models().withExistingParent("vavs:walnut_slab", "minecraft:block/slab"));
        simpleBlockItem(ModBlocks.NETHER_FARMLAND.get(), models().withExistingParent("vavs:nether_farmland", "minecraft:block/template_farmland"));
        simpleBlockItem(ModBlocks.SOUL_STONE_SLAB.get(), models().withExistingParent("vavs:soul_stone_slab", "minecraft:block/slab"));
        simpleBlockItem(ModBlocks.WALNUT_STAIRS.get(), models().withExistingParent("vavs:walnut_stairs", "minecraft:block/stairs"));
        simpleBlockItem(ModBlocks.SOUL_STONE_STAIRS.get(), models().withExistingParent("vavs:soul_stone_stairs", "minecraft:block/stairs"));
        simpleBlockItem(ModBlocks.WALNUT_TRAPDOOR.get(), models().withExistingParent("vavs:walnut_trapdoor_bottom", "minecraft:block/template_trapdoor_bottom"));
        simpleBlockItem(ModBlocks.WALNUT_PRESSURE_PLATE.get(), models().withExistingParent("vavs:walnut_pressure_plate", "minecraft:block/pressure_plate_up"));
        simpleBlockItem(ModBlocks.WALNUT_FENCE_GATE.get(), models().withExistingParent("vavs:walnut_fence_gate", "minecraft:block/template_fence_gate"));
        simpleBlockItem(ModBlocks.WALNUT_LOG.get(), models().withExistingParent("vavs:walnut_log", "minecraft:block/cube_column"));
        simpleBlockItem(ModBlocks.CRYING_POLISHED_BASALT.get(), models().withExistingParent("vavs:crying_polished_basalt", "minecraft:block/cube_column"));
        simpleBlockItem(ModBlocks.CRYING_BASALT.get(), models().withExistingParent("vavs:crying_basalt", "minecraft:block/cube_column"));
        simpleBlockItem(ModBlocks.WALNUT_WOOD.get(), models().withExistingParent("vavs:walnut_wood", "minecraft:block/cube_column"));
        simpleBlockItem(ModBlocks.STRIPPED_WALNUT_LOG.get(), models().withExistingParent("vavs:stripped_walnut_log", "minecraft:block/cube_column"));
        simpleBlockItem(ModBlocks.STRIPPED_WALNUT_WOOD.get(), models().withExistingParent("vavs:stripped_walnut_wood", "minecraft:block/cube_column"));

        blockWithItem(ModBlocks.END_SOIL);

        makeCake(ModBlocks.CHOCOLATE_CAKE.get());
        makeCake(ModBlocks.HONEY_CAKE.get());
        makeCake(ModBlocks.CRIMSON_CAKE.get());
        makeCake(ModBlocks.WARPED_CAKE.get());
    }

    public void makeCrop(CropBlock block, String modelName, String textureName, boolean isCross) {
        Function<BlockState, ConfiguredModel[]> function = state -> states(state, block, modelName, textureName, isCross);

        getVariantBuilder(block).forAllStates(function);
    }

    private void makeCake(Block cake) {
        String side = "block/" + Objects.requireNonNull(ForgeRegistries.BLOCKS.getKey(cake)).getPath() + "_side";
        String top = "block/" + Objects.requireNonNull(ForgeRegistries.BLOCKS.getKey(cake)).getPath() + "_top";
        String bottom = "block/" + Objects.requireNonNull(ForgeRegistries.BLOCKS.getKey(cake)).getPath() + "_bottom";
        String inside = "block/" + Objects.requireNonNull(ForgeRegistries.BLOCKS.getKey(cake)).getPath() + "_inner";

        String path = Objects.requireNonNull(ForgeRegistries.BLOCKS.getKey(cake)).getPath();

        VariantBlockStateBuilder builder = getVariantBuilder(cake);
        builder.partialState().with(ModCakeBlock.BITES, 0).addModels(new ConfiguredModel(models().withExistingParent(path, this.mcLoc("cake"))
                .texture("side", side)
                .texture("top", top)
                .texture("bottom", bottom)));

        for (int i = 1; i < 7; i++) {
            builder.partialState().with(ModCakeBlock.BITES, i).addModels(new ConfiguredModel(models().withExistingParent(path + "_slice" + i, this.mcLoc("cake_slice" + i))
                    .texture("side", side)
                    .texture("top", top)
                    .texture("bottom", bottom)
                    .texture("inside", inside)));
        }
    }

    private ConfiguredModel[] states(BlockState state, CropBlock block, String modelName, String textureName, boolean isCross) {
        ConfiguredModel[] models = new ConfiguredModel[1];
        if (isCross) {
            models[0] = new ConfiguredModel(models().crop(modelName + block.getAge(state),
                    new ResourceLocation(VanillaVariations.MOD_ID, "block/" + textureName + block.getAge(state))).renderType("cutout"));
        } else {
            models[0] = new ConfiguredModel(models().cross(modelName + block.getAge(state),
                    new ResourceLocation(VanillaVariations.MOD_ID, "block/" + textureName + block.getAge(state))).renderType("cutout"));
        }
        return models;
    }

    public void makeBush(WarpedBerry block, String modelName, String textureName) {
        Function<BlockState, ConfiguredModel[]> function = state -> bushStates(state, block, modelName, textureName);

        getVariantBuilder(block).forAllStates(function);
    }

    private ConfiguredModel[] bushStates(BlockState state, WarpedBerry block, String modelName, String textureName) {
        ConfiguredModel[] models = new ConfiguredModel[1];
        models[0] = new ConfiguredModel(models().cross(modelName + state.getValue(block.getAgeProperty()),
                new ResourceLocation(VanillaVariations.MOD_ID, "block/" + textureName + state.getValue(block.getAgeProperty()))).renderType("cutout"));

        return models;
    }

    public void farmland(Block block, Block dirtBlock) {
        ModelFile farmland = this.models().withExistingParent(Objects.requireNonNull(ForgeRegistries.BLOCKS.getKey(block)).getPath(), this.mcLoc("block/template_farmland"))
                .texture("dirt", "minecraft:block/" + Objects.requireNonNull(ForgeRegistries.BLOCKS.getKey(dirtBlock)).getPath())
                .texture("top", this.modLoc("block/" + Objects.requireNonNull(ForgeRegistries.BLOCKS.getKey(block)).getPath()));
        ModelFile moist = this.models().withExistingParent(Objects.requireNonNull(ForgeRegistries.BLOCKS.getKey(block)).getPath() + "_moist", this.mcLoc("block/template_farmland"))
                .texture("dirt", "minecraft:block/" + Objects.requireNonNull(ForgeRegistries.BLOCKS.getKey(dirtBlock)).getPath())
                .texture("top", this.modLoc("block/" + Objects.requireNonNull(ForgeRegistries.BLOCKS.getKey(block)).getPath() + "_moist"));
        this.getVariantBuilder(block).forAllStatesExcept(state -> {
            int moisture = state.getValue(NetherFarmland.MOISTURE);
            return ConfiguredModel.builder()
                    .modelFile(moisture < NetherFarmland.MAX_MOISTURE ? farmland : moist)
                    .build();
        });
    }

    public void PottedPlant(Block block, Block flower) {
        ModelFile pot = this.models().withExistingParent(Objects.requireNonNull(ForgeRegistries.BLOCKS.getKey(block)).getPath(), this.mcLoc("block/flower_pot_cross")).texture("plant", this.modLoc("block/" + Objects.requireNonNull(ForgeRegistries.BLOCKS.getKey(flower)).getPath())).renderType("cutout");
        this.getVariantBuilder(block).partialState().addModels(new ConfiguredModel(pot));
    }

    private void blockWithItem(RegistryObject<Block> blockRegistryObject) {
        simpleBlockWithItem(blockRegistryObject.get(), cubeAll(blockRegistryObject.get()));
    }

    private void saplingBlock(RegistryObject<Block> blockRegistryObject) {
        simpleBlock(blockRegistryObject.get(),
                models().cross(Objects.requireNonNull(ForgeRegistries.BLOCKS.getKey(blockRegistryObject.get())).getPath(), blockTexture(blockRegistryObject.get())).renderType("cutout"));
    }
}

package net.nrjam.vavs.datagen;

import net.minecraft.data.PackOutput;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.FenceBlock;
import net.minecraft.world.level.block.RotatedPillarBlock;
import net.minecraftforge.client.model.generators.BlockStateProvider;
import net.minecraftforge.client.model.generators.ConfiguredModel;
import net.minecraftforge.client.model.generators.ModelFile;
import net.minecraftforge.common.data.ExistingFileHelper;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;
import net.nrjam.vavs.VanillaVariations;
import net.nrjam.vavs.block.ModBlocks;

public class ModBlockStateProvider extends BlockStateProvider {

    public ModBlockStateProvider(PackOutput output, ExistingFileHelper exFileHelper) {
        super(output, VanillaVariations.MOD_ID, exFileHelper);
    }

    @Override
    protected void registerStatesAndModels() {
        blockWithItem(ModBlocks.REINFORCED_LEATHER_BLOCK);

        logBlock(((RotatedPillarBlock) ModBlocks.WALNUT_LOG.get()));
        axisBlock((RotatedPillarBlock) ModBlocks.WALNUT_WOOD.get(), blockTexture(ModBlocks.WALNUT_LOG.get()), blockTexture(ModBlocks.WALNUT_LOG.get()));
        axisBlock((RotatedPillarBlock) ModBlocks.STRIPPED_WALNUT_LOG.get(), new ResourceLocation(VanillaVariations.MOD_ID, "block/stripped_walnut_log"),
                new ResourceLocation(VanillaVariations.MOD_ID, "block/stripped_walnut_log_top"));
        axisBlock((RotatedPillarBlock) ModBlocks.STRIPPED_WALNUT_WOOD.get(), new ResourceLocation(VanillaVariations.MOD_ID, "block/stripped_walnut_log"),
                new ResourceLocation(VanillaVariations.MOD_ID, "block/stripped_walnut_log"));

        blockWithItem(ModBlocks.WALNUT_PLANKS);
        blockWithItem(ModBlocks.WALNUT_LEAVES);
        saplingBlock(ModBlocks.WALNUT_SAPLING);
        saplingBlock(ModBlocks.BLOSSOMING_ROOT);
        saplingBlock(ModBlocks.ENDER_ROOT);
        blockWithItem(ModBlocks.SOUL_STONE);
        blockWithItem(ModBlocks.SOUL_LIGHT);

        PottedPlant(ModBlocks.POTTED_BLOSSOMING_ROOT.get(), ModBlocks.BLOSSOMING_ROOT.get());
        PottedPlant(ModBlocks.POTTED_ENDER_ROOT.get(), ModBlocks.BLOSSOMING_ROOT.get());
        PottedPlant(ModBlocks.POTTED_WALNUT_SAPLING.get(), ModBlocks.BLOSSOMING_ROOT.get());

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

        wallBlock(ModBlocks.SOUL_STONE_WALL.get(), blockTexture(ModBlocks.SOUL_STONE.get()));

        simpleBlockItem(ModBlocks.SOUL_STONE_WALL.get(), models().withExistingParent("vavs:soul_stone_wall", "minecraft:block/wall_inventory").texture("wall", "vavs:block/soul_stone"));
        simpleBlockItem(ModBlocks.WALNUT_SLAB.get(), models().withExistingParent("vavs:walnut_slab", "minecraft:block/slab"));
        simpleBlockItem(ModBlocks.SOUL_STONE_SLAB.get(), models().withExistingParent("vavs:soul_stone_slab", "minecraft:block/slab"));
        simpleBlockItem(ModBlocks.WALNUT_STAIRS.get(), models().withExistingParent("vavs:walnut_stairs", "minecraft:block/stairs"));
        simpleBlockItem(ModBlocks.SOUL_STONE_STAIRS.get(), models().withExistingParent("vavs:soul_stone_stairs", "minecraft:block/stairs"));
        simpleBlockItem(ModBlocks.WALNUT_TRAPDOOR.get(), models().withExistingParent("vavs:walnut_trapdoor_bottom", "minecraft:block/template_trapdoor_bottom"));
        simpleBlockItem(ModBlocks.WALNUT_PRESSURE_PLATE.get(), models().withExistingParent("vavs:walnut_pressure_plate", "minecraft:block/pressure_plate_up"));
        simpleBlockItem(ModBlocks.WALNUT_FENCE_GATE.get(), models().withExistingParent("vavs:walnut_fence_gate", "minecraft:block/template_fence_gate"));
        simpleBlockItem(ModBlocks.WALNUT_LOG.get(), models().withExistingParent("vavs:walnut_log", "minecraft:block/cube_column"));
        simpleBlockItem(ModBlocks.WALNUT_WOOD.get(), models().withExistingParent("vavs:walnut_wood", "minecraft:block/cube_column"));
        simpleBlockItem(ModBlocks.STRIPPED_WALNUT_LOG.get(), models().withExistingParent("vavs:stripped_walnut_log", "minecraft:block/cube_column"));
        simpleBlockItem(ModBlocks.STRIPPED_WALNUT_WOOD.get(), models().withExistingParent("vavs:stripped_walnut_wood", "minecraft:block/cube_column"));

        blockWithItem(ModBlocks.END_SOIL);
    }

    public void PottedPlant(Block block, Block flower) {
        ModelFile pot = this.models().withExistingParent(ForgeRegistries.BLOCKS.getKey(block).getPath(), this.mcLoc("block/flower_pot_cross")).texture("plant", this.modLoc("block/" + ForgeRegistries.BLOCKS.getKey(flower).getPath())).renderType("cutout");
        this.getVariantBuilder(block).partialState().addModels(new ConfiguredModel(pot));
    }

    private void blockWithItem(RegistryObject<Block> blockRegistryObject) {
        simpleBlockWithItem(blockRegistryObject.get(), cubeAll(blockRegistryObject.get()));
    }

    private void saplingBlock(RegistryObject<Block> blockRegistryObject) {
        simpleBlock(blockRegistryObject.get(),
                models().cross(ForgeRegistries.BLOCKS.getKey(blockRegistryObject.get()).getPath(), blockTexture(blockRegistryObject.get())).renderType("cutout"));
    }
}

package net.nrjam.vavs.datagen;

import net.minecraft.data.PackOutput;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.RotatedPillarBlock;
import net.minecraftforge.client.model.generators.BlockStateProvider;
import net.minecraftforge.common.data.ExistingFileHelper;
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

        simpleBlockItem(ModBlocks.WALNUT_LOG.get(), models().withExistingParent("vavs:walnut_log", "minecraft:block/cube_column"));
        simpleBlockItem(ModBlocks.WALNUT_WOOD.get(), models().withExistingParent("vavs:walnut_wood", "minecraft:block/cube_column"));
        simpleBlockItem(ModBlocks.STRIPPED_WALNUT_LOG.get(), models().withExistingParent("vavs:stripped_walnut_log", "minecraft:block/cube_column"));
        simpleBlockItem(ModBlocks.STRIPPED_WALNUT_WOOD.get(), models().withExistingParent("vavs:stripped_walnut_wood", "minecraft:block/cube_column"));
    }

    private void blockWithItem(RegistryObject<Block> blockRegistryObject) {
        simpleBlockWithItem(blockRegistryObject.get(), cubeAll(blockRegistryObject.get()));
    }

    private void saplingBlock(RegistryObject<Block> blockRegistryObject) {
        simpleBlock(blockRegistryObject.get(),
                models().cross(ForgeRegistries.BLOCKS.getKey(blockRegistryObject.get()).getPath(), blockTexture(blockRegistryObject.get())).renderType("cutout"));
    }
}

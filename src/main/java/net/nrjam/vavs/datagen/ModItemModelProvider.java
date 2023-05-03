package net.nrjam.vavs.datagen;

import net.minecraft.data.PackOutput;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.*;
import net.minecraftforge.client.model.generators.ItemModelBuilder;
import net.minecraftforge.client.model.generators.ItemModelProvider;
import net.minecraftforge.common.data.ExistingFileHelper;
import net.minecraftforge.registries.RegistryObject;
import net.nrjam.vavs.VanillaVariations;
import net.nrjam.vavs.block.ModBlocks;
import net.nrjam.vavs.item.ModItems;

public class ModItemModelProvider extends ItemModelProvider {
    public ModItemModelProvider(PackOutput output, ExistingFileHelper existingFileHelper) {
        super(output, VanillaVariations.MOD_ID, existingFileHelper);
    }

    @Override
    protected void registerModels() {
        simpleItem(ModItems.CRYSTAL);
        simpleItem(ModItems.REINFORCED_LEATHER);
        simpleItem(ModItems.SOUL_ESSENCE);
        simpleItem(ModItems.AMARANTH_ESSENCE);
        simpleItem(ModItems.SOUL_SPROUT);
        simpleItem(ModItems.CRIMSON_BERRIES);
        simpleItem(ModItems.WARPED_BERRIES);

        simpleItem(ModItems.CABBAGE);
        simpleItem(ModItems.CABBAGE_SEED);

        simpleItem(ModItems.AMARANTH);
        simpleItem(ModItems.AMARANTH_SEED);

        simpleItem(ModItems.SWEET_BERRY_PIE);
        simpleItem(ModItems.APPLE_PIE);
        simpleItem(ModItems.CHORUS_FRUIT_PIE);
        simpleItem(ModItems.SOUL_SPROUT_PIE);
        simpleItem(ModItems.WARPED_BERRY_PIE);
        simpleItem(ModItems.CRIMSON_BERRY_PIE);
        simpleItem(ModItems.AMARANTH_PIE);

        simpleItem(ModItems.AMARANTH_BREAD);
        simpleItem(ModItems.AMARANTH_COOKIE);

        simpleItem(ModItems.SOUL_SPROUT_STEW);
        simpleItem(ModItems.DRIED_KELP_SOUP);
        simpleItem(ModItems.AMARANTH_SOUP);

        simpleItem(ModItems.SALMON_SALAD);
        simpleItem(ModItems.SWEET_SALAD);
        simpleItem(ModItems.SOUL_SPROUT_SALAD);
        simpleItem(ModItems.GARDEN_SALAD);
        simpleItem(ModItems.MEAT_SALAD);
        simpleItem(ModItems.AMARANTH_SALAD);

        simpleItem(ModItems.REINFORCED_LEATHER_HELMET);
        simpleItem(ModItems.REINFORCED_LEATHER_CHESTPLATE);
        simpleItem(ModItems.REINFORCED_LEATHER_LEGGINGS);
        simpleItem(ModItems.REINFORCED_LEATHER_BOOTS);

        simpleItem(ModItems.FUSED_AMARANTH_HELMET);
        simpleItem(ModItems.FUSED_AMARANTH_CHESTPLATE);
        simpleItem(ModItems.FUSED_AMARANTH_LEGGINGS);
        simpleItem(ModItems.FUSED_AMARANTH_BOOTS);

        simpleItem(ModItems.CRYSTAL_BOOTS);
        simpleItem(ModItems.CRYSTAL_LEGGINGS);
        simpleItem(ModItems.CRYSTAL_CHESTPLATE);
        simpleItem(ModItems.CRYSTAL_HELMET);

        simpleItem(ModItems.FLOWER_CROWN);

        handheldItem(ModItems.CRYSTAL_SWORD);
        handheldItem(ModItems.CRYSTAL_AXE);
        handheldItem(ModItems.CRYSTAL_PICKAXE);
        handheldItem(ModItems.CRYSTAL_HOE);
        handheldItem(ModItems.CRYSTAL_SHOVEL);

        handheldItem(ModItems.FUSED_AMARANTH_SWORD);
        handheldItem(ModItems.FUSED_AMARANTH_AXE);
        handheldItem(ModItems.FUSED_AMARANTH_PICKAXE);
        handheldItem(ModItems.FUSED_AMARANTH_HOE);
        handheldItem(ModItems.FUSED_AMARANTH_SHOVEL);

        simpleItem(ModItems.FUSED_SOUL_HELMET);
        simpleItem(ModItems.FUSED_SOUL_CHESTPLATE);
        simpleItem(ModItems.FUSED_SOUL_LEGGINGS);
        simpleItem(ModItems.FUSED_SOUL_BOOTS);

        saplingItem(ModBlocks.WALNUT_SAPLING);
        saplingItem(ModBlocks.BLOSSOMING_ROOT);
        saplingItem(ModBlocks.ENDER_ROOT);
        saplingItem(ModBlocks.SOUL_FLOWER);
        saplingItem(ModBlocks.DEAD_ROOTS);
        saplingItem(ModBlocks.WILD_CABBAGE);

        saplingItem(ModBlocks.VIOLA);
        saplingItem(ModBlocks.SNAPDRAGON);
        saplingItem(ModBlocks.MARIGOLD);
        saplingItem(ModBlocks.LAVENDER);

        blockParentItem(ModBlocks.HONEY_CAKE);
        blockParentItem(ModBlocks.CHOCOLATE_CAKE);

        itemFence(ModBlocks.WALNUT_FENCE, ModBlocks.WALNUT_PLANKS);
        itemButton(ModBlocks.WALNUT_BUTTON, ModBlocks.WALNUT_PLANKS);
        customDoorItemBlock(ModBlocks.WALNUT_DOOR);
    }

    public void itemButton(RegistryObject<ButtonBlock> block, RegistryObject<Block> baseBlock) {
        this.withExistingParent(block.getId().getPath(),
                new ResourceLocation("block/button_inventory")).texture("texture",
                new ResourceLocation(VanillaVariations.MOD_ID,"block/" + baseBlock.getId().getPath()));
    }

    public void itemFence(RegistryObject<FenceBlock> block, RegistryObject<Block> baseBlock) {
        this.withExistingParent(block.getId().getPath(),
                new ResourceLocation("block/fence_inventory")).texture("texture",
                new ResourceLocation(VanillaVariations.MOD_ID,"block/" + baseBlock.getId().getPath()));
    }

    private void saplingItem(RegistryObject<Block> block) {
        withExistingParent(block.getId().getPath(),
                new ResourceLocation("item/generated")).texture("layer0",
                new ResourceLocation(VanillaVariations.MOD_ID, "block/" + block.getId().getPath()));
    }

    private void blockParentItem(RegistryObject<Block> block) {
        withExistingParent(block.getId().getPath(),
                new ResourceLocation("item/generated")).texture("layer0",
                new ResourceLocation(VanillaVariations.MOD_ID, "item/" + block.getId().getPath()));
    }

    private void customDoorItemBlock(RegistryObject<DoorBlock> block) {
        withExistingParent(block.getId().getPath(),
                new ResourceLocation("item/generated")).texture("layer0",
                new ResourceLocation(VanillaVariations.MOD_ID, "item/" + block.getId().getPath()));
    }

    private void simpleItem(RegistryObject<Item> item) {
        withExistingParent(item.getId().getPath(),
                new ResourceLocation("item/generated")).texture("layer0",
                new ResourceLocation(VanillaVariations.MOD_ID, "item/" + item.getId().getPath()));
    }

    private ItemModelBuilder handheldItem(RegistryObject<Item> item) {
        return withExistingParent(item.getId().getPath(),
                new ResourceLocation("item/handheld")).texture("layer0",
                new ResourceLocation(VanillaVariations.MOD_ID,"item/" + item.getId().getPath()));
    }
}

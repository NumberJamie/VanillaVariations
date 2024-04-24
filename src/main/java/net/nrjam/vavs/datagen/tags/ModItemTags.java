package net.nrjam.vavs.datagen.tags;

import net.minecraft.core.HolderLookup;
import net.minecraft.data.PackOutput;
import net.minecraft.data.tags.ItemTagsProvider;
import net.minecraft.tags.BlockTags;
import net.minecraft.tags.ItemTags;
import net.minecraft.world.level.block.Block;
import net.minecraftforge.common.data.ExistingFileHelper;
import net.nrjam.vavs.VanillaVariations;
import net.nrjam.vavs.block.ModBlocks;
import net.nrjam.vavs.item.ModItems;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.concurrent.CompletableFuture;

public class ModItemTags extends ItemTagsProvider {
    public ModItemTags(PackOutput output, CompletableFuture<HolderLookup.Provider> registries, CompletableFuture<TagLookup<Block>> blockTags, @Nullable ExistingFileHelper helper) {
        super(output, registries, blockTags, VanillaVariations.MOD_ID, helper);
    }

    @Override
    protected void addTags(HolderLookup.@NotNull Provider provider) {
        this.copy(ModTags.Blocks.WALNUT_LOGS, ModTags.Items.WALNUT_LOGS);
        this.copy(BlockTags.FLOWERS, ItemTags.FLOWERS);
        this.tag(ItemTags.PLANKS).add(ModBlocks.WALNUT_PLANKS.get().asItem());
        this.tag(ItemTags.TRIMMABLE_ARMOR).add(
                ModItems.REINFORCED_LEATHER_HELMET.get(),
                ModItems.REINFORCED_LEATHER_CHESTPLATE.get(),
                ModItems.REINFORCED_LEATHER_LEGGINGS.get(),
                ModItems.REINFORCED_LEATHER_BOOTS.get(),
                ModItems.FUSED_SOUL_HELMET.get(),
                ModItems.FUSED_SOUL_CHESTPLATE.get(),
                ModItems.FUSED_SOUL_LEGGINGS.get(),
                ModItems.FUSED_SOUL_BOOTS.get(),
                ModItems.FUSED_AMARANTH_HELMET.get(),
                ModItems.FUSED_AMARANTH_CHESTPLATE.get(),
                ModItems.FUSED_AMARANTH_LEGGINGS.get(),
                ModItems.FUSED_AMARANTH_BOOTS.get(),
                ModItems.CRYSTAL_HELMET.get(),
                ModItems.CRYSTAL_CHESTPLATE.get(),
                ModItems.CRYSTAL_LEGGINGS.get(),
                ModItems.CRYSTAL_BOOTS.get()
        );
    }
}

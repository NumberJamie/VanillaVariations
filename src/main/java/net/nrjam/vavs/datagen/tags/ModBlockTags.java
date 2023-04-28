package net.nrjam.vavs.datagen.tags;

import net.minecraft.core.HolderLookup;
import net.minecraft.data.PackOutput;
import net.minecraft.tags.BlockTags;
import net.minecraftforge.common.data.BlockTagsProvider;
import net.minecraftforge.common.data.ExistingFileHelper;
import net.minecraftforge.fml.common.Mod;
import net.nrjam.vavs.VanillaVariations;
import net.nrjam.vavs.block.ModBlocks;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.concurrent.CompletableFuture;

public class ModBlockTags extends BlockTagsProvider {

    public ModBlockTags(PackOutput output, CompletableFuture<HolderLookup.Provider> lookupProvider, @Nullable ExistingFileHelper existingFileHelper) {
        super(output, lookupProvider, VanillaVariations.MOD_ID, existingFileHelper);
    }

    @SuppressWarnings("unchecked")
    @Override
    protected void addTags(HolderLookup.@NotNull Provider provider) {
        this.tag(ModTags.Blocks.WALNUT_LOGS).add(ModBlocks.WALNUT_LOG.get())
                .add(ModBlocks.STRIPPED_WALNUT_LOG.get())
                .add(ModBlocks.WALNUT_WOOD.get())
                .add(ModBlocks.STRIPPED_WALNUT_WOOD.get());

        this.tag(BlockTags.SNAPS_GOAT_HORN).addTags(ModTags.Blocks.WALNUT_LOGS);
        this.tag(BlockTags.OVERWORLD_NATURAL_LOGS).addTags(ModTags.Blocks.WALNUT_LOGS);
        this.tag(BlockTags.LOGS_THAT_BURN).addTags(ModTags.Blocks.WALNUT_LOGS);
        this.tag(BlockTags.LOGS).addTags(ModTags.Blocks.WALNUT_LOGS);
        this.tag(BlockTags.COMPLETES_FIND_TREE_TUTORIAL).addTags(ModTags.Blocks.WALNUT_LOGS);
        this.tag(BlockTags.FENCES).add(ModBlocks.WALNUT_FENCE.get());
        this.tag(BlockTags.FENCE_GATES).add(ModBlocks.WALNUT_FENCE_GATE.get());
        this.tag(BlockTags.WOODEN_FENCES).add(ModBlocks.WALNUT_FENCE.get());
        this.tag(BlockTags.WOODEN_SLABS).add(ModBlocks.WALNUT_SLAB.get());
        this.tag(BlockTags.WOODEN_STAIRS).add(ModBlocks.WALNUT_STAIRS.get());
        this.tag(BlockTags.WOODEN_DOORS).add(ModBlocks.WALNUT_DOOR.get());
        this.tag(BlockTags.WOODEN_TRAPDOORS).add(ModBlocks.WALNUT_TRAPDOOR.get());
        this.tag(BlockTags.WOODEN_BUTTONS).add(ModBlocks.WALNUT_BUTTON.get());
        this.tag(BlockTags.PLANKS).add(ModBlocks.WALNUT_PLANKS.get());
        this.tag(BlockTags.WOODEN_PRESSURE_PLATES).add(ModBlocks.WALNUT_PRESSURE_PLATE.get());
        this.tag(BlockTags.MINEABLE_WITH_AXE).add(ModBlocks.WALNUT_SLAB.get())
                .add(ModBlocks.WALNUT_STAIRS.get())
                .add(ModBlocks.WALNUT_DOOR.get())
                .add(ModBlocks.WALNUT_BUTTON.get())
                .add(ModBlocks.WALNUT_PRESSURE_PLATE.get())
                .add(ModBlocks.WALNUT_TRAPDOOR.get())
                .add(ModBlocks.WALNUT_PLANKS.get());
        this.tag(BlockTags.MINEABLE_WITH_SHOVEL).add(ModBlocks.END_SOIL.get());
        this.tag(BlockTags.DRAGON_IMMUNE).add(ModBlocks.END_SOIL.get());
        this.tag(BlockTags.SCULK_REPLACEABLE).add(ModBlocks.END_SOIL.get());
    }
}

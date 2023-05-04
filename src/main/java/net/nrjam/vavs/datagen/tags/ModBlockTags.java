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
        this.tag(ModTags.Blocks.SOUL_STONES).add(ModBlocks.SOUL_STONE.get())
                .add(ModBlocks.SOUL_STONE_SLAB.get())
                .add(ModBlocks.SOUL_STONE_STAIRS.get())
                .add(ModBlocks.SOUL_STONE_WALL.get());
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
        this.tag(BlockTags.MINEABLE_WITH_HOE).add(ModBlocks.SOUL_LIGHT.get());
        this.tag(BlockTags.MINEABLE_WITH_SHOVEL).add(ModBlocks.END_SOIL.get())
                .add(ModBlocks.NETHER_FARMLAND.get());
        this.tag(BlockTags.DRAGON_IMMUNE).add(ModBlocks.END_SOIL.get());
        this.tag(BlockTags.SCULK_REPLACEABLE).add(ModBlocks.END_SOIL.get());
        this.tag(BlockTags.FLOWER_POTS).add(ModBlocks.POTTED_BLOSSOMING_ROOT.get())
                .add(ModBlocks.POTTED_ENDER_ROOT.get())
                .add(ModBlocks.POTTED_WILD_CABBAGE.get())
                .add(ModBlocks.POTTED_VIOLA.get())
                .add(ModBlocks.POTTED_DEAD_ROOTS.get())
                .add(ModBlocks.POTTED_SOUL_FLOWER.get())
                .add(ModBlocks.POTTED_SNAPDRAGON.get())
                .add(ModBlocks.POTTED_MARIGOLD.get())
                .add(ModBlocks.POTTED_LAVENDER.get())
                .add(ModBlocks.POTTED_WALNUT_SAPLING.get());
        this.tag(BlockTags.INFINIBURN_NETHER).addTag(ModTags.Blocks.SOUL_STONES)
                .add(ModBlocks.SOUL_LIGHT.get());
        this.tag(BlockTags.MINEABLE_WITH_PICKAXE).addTag(ModTags.Blocks.SOUL_STONES)
                .add(ModBlocks.CRYSTAL_BLOCK.get())
                .add(ModBlocks.CRYSTAL_ORE.get())
                .add(ModBlocks.CRYING_SMOOTH_BASALT.get())
                .add(ModBlocks.CRYING_BASALT.get())
                .add(ModBlocks.CRYING_POLISHED_BASALT.get())
                .add(ModBlocks.ROCK_SALT_BLOCK.get());
        this.tag(BlockTags.WALLS).add(ModBlocks.SOUL_STONE_WALL.get());
        this.tag(BlockTags.FLOWERS).add(ModBlocks.VIOLA.get())
                .add(ModBlocks.SOUL_FLOWER.get())
                .add(ModBlocks.SNAPDRAGON.get())
                .add(ModBlocks.MARIGOLD.get())
                .add(ModBlocks.LAVENDER.get());
        this.tag(BlockTags.NEEDS_DIAMOND_TOOL).add(ModBlocks.CRYSTAL_BLOCK.get())
                .add(ModBlocks.CRYSTAL_ORE.get());
    }
}

package net.nrjam.vavs.datagen;

import net.minecraft.data.loot.BlockLootSubProvider;
import net.minecraft.world.flag.FeatureFlags;
import net.minecraft.world.item.Items;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.storage.loot.entries.LootItem;
import net.minecraft.world.level.storage.loot.functions.SetItemCountFunction;
import net.minecraft.world.level.storage.loot.providers.number.UniformGenerator;
import net.minecraftforge.registries.RegistryObject;
import net.nrjam.vavs.block.ModBlocks;
import org.jetbrains.annotations.NotNull;


import java.util.Set;

public class ModBlockLootTables extends BlockLootSubProvider {
    public ModBlockLootTables() {
        super(Set.of(), FeatureFlags.REGISTRY.allFlags());
    }

    @Override
    protected void generate() {
        dropSelf(ModBlocks.REINFORCED_LEATHER_BLOCK.get());

        this.dropSelf(ModBlocks.WALNUT_LOG.get());
        this.dropSelf(ModBlocks.WALNUT_WOOD.get());
        this.dropSelf(ModBlocks.WALNUT_PLANKS.get());
        this.dropSelf(ModBlocks.STRIPPED_WALNUT_WOOD.get());
        this.dropSelf(ModBlocks.STRIPPED_WALNUT_LOG.get());
        this.dropSelf(ModBlocks.WALNUT_SAPLING.get());
        this.dropSelf(ModBlocks.WALNUT_SLAB.get());
        this.dropSelf(ModBlocks.WALNUT_STAIRS.get());
        this.dropSelf(ModBlocks.WALNUT_TRAPDOOR.get());
        this.add(ModBlocks.WALNUT_DOOR.get(), createDoorTable(ModBlocks.WALNUT_DOOR.get()));
        this.dropSelf(ModBlocks.WALNUT_FENCE.get());
        this.dropSelf(ModBlocks.WALNUT_FENCE_GATE.get());
        this.dropSelf(ModBlocks.WALNUT_PRESSURE_PLATE.get());
        this.dropSelf(ModBlocks.WALNUT_BUTTON.get());

        this.dropSelf(ModBlocks.SOUL_LIGHT.get());
        this.dropSelf(ModBlocks.SOUL_STONE.get());
        this.dropSelf(ModBlocks.SOUL_STONE_STAIRS.get());
        this.dropSelf(ModBlocks.SOUL_STONE_SLAB.get());
        this.dropSelf(ModBlocks.SOUL_STONE_WALL.get());

        this.dropSelf(ModBlocks.END_SOIL.get());

        this.add(ModBlocks.WALNUT_LEAVES.get(), (block) ->
                createLeavesDrops(block, ModBlocks.WALNUT_SAPLING.get(), NORMAL_LEAVES_SAPLING_CHANCES));

        this.add(ModBlocks.BLOSSOMING_ROOT.get(), (p_250546_) -> createSilkTouchOrShearsDispatchTable(p_250546_, this.applyExplosionCondition(p_250546_, LootItem.lootTableItem(Items.STICK))));
        this.add(ModBlocks.ENDER_ROOT.get(), (p_250546_) -> createSilkTouchOrShearsDispatchTable(p_250546_, this.applyExplosionCondition(p_250546_, LootItem.lootTableItem(Items.STICK))));

        this.dropPottedContents(ModBlocks.POTTED_BLOSSOMING_ROOT.get());
        this.dropPottedContents(ModBlocks.POTTED_ENDER_ROOT.get());
        this.dropPottedContents(ModBlocks.POTTED_WALNUT_SAPLING.get());
    }

    @Override
    protected @NotNull Iterable<Block> getKnownBlocks() {
        return ModBlocks.BLOCKS.getEntries().stream().map(RegistryObject::get)::iterator;
    }
}

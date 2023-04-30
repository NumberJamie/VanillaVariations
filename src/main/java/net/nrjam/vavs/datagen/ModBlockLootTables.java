package net.nrjam.vavs.datagen;

import net.minecraft.advancements.critereon.StatePropertiesPredicate;
import net.minecraft.data.loot.BlockLootSubProvider;
import net.minecraft.world.flag.FeatureFlags;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.enchantment.Enchantments;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.CarrotBlock;
import net.minecraft.world.level.storage.loot.LootPool;
import net.minecraft.world.level.storage.loot.LootTable;
import net.minecraft.world.level.storage.loot.entries.LootItem;
import net.minecraft.world.level.storage.loot.functions.ApplyBonusCount;
import net.minecraft.world.level.storage.loot.functions.SetItemCountFunction;
import net.minecraft.world.level.storage.loot.predicates.LootItemBlockStatePropertyCondition;
import net.minecraft.world.level.storage.loot.predicates.LootItemCondition;
import net.minecraft.world.level.storage.loot.predicates.LootItemRandomChanceCondition;
import net.minecraft.world.level.storage.loot.providers.number.UniformGenerator;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.registries.RegistryObject;
import net.nrjam.vavs.block.ModBlocks;
import net.nrjam.vavs.block.natural.SoulSprouts;
import net.nrjam.vavs.datagen.tags.ModItemTags;
import net.nrjam.vavs.item.ModItems;
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

        this.dropOther(ModBlocks.NETHER_FARMLAND.get(), Blocks.SOUL_SOIL);

        this.dropSelf(ModBlocks.SOUL_LIGHT.get());
        this.dropSelf(ModBlocks.SOUL_STONE.get());
        this.dropSelf(ModBlocks.SOUL_STONE_STAIRS.get());
        this.dropSelf(ModBlocks.SOUL_STONE_SLAB.get());
        this.dropSelf(ModBlocks.SOUL_STONE_WALL.get());

        this.dropSelf(ModBlocks.END_SOIL.get());

        this.add(ModBlocks.WALNUT_LEAVES.get(), (block) ->
                createLeavesDrops(block, ModBlocks.WALNUT_SAPLING.get(), NORMAL_LEAVES_SAPLING_CHANCES));

        this.add(ModBlocks.BLOSSOMING_ROOT.get(), (p_250546_) -> createSilkTouchOrShearsDispatchTable(p_250546_, this.applyExplosionCondition(p_250546_, LootItem.lootTableItem(Items.STICK).when(LootItemRandomChanceCondition.randomChance(0.125F)))));
        this.add(ModBlocks.ENDER_ROOT.get(), (p_250546_) -> createSilkTouchOrShearsDispatchTable(p_250546_, this.applyExplosionCondition(p_250546_, LootItem.lootTableItem(Items.STICK).when(LootItemRandomChanceCondition.randomChance(0.125F)))));
        this.add(ModBlocks.SOUL_FLOWER.get(), (p_250546_) -> createSilkTouchOrShearsDispatchTable(p_250546_, this.applyExplosionCondition(p_250546_, LootItem.lootTableItem(ModItems.SOUL_ESSENCE.get()).when(LootItemRandomChanceCondition.randomChance(0.05F)))));
        this.add(ModBlocks.DEAD_ROOTS.get(), (p_250546_) -> createSilkTouchOrShearsDispatchTable(p_250546_, this.applyExplosionCondition(p_250546_, LootItem.lootTableItem(Items.STICK).when(LootItemRandomChanceCondition.randomChance(0.125F)))));

        LootItemCondition.Builder lootitemcondition$builder2 = LootItemBlockStatePropertyCondition.hasBlockStateProperties(ModBlocks.SOUL_SPROUTS.get()).setProperties(StatePropertiesPredicate.Builder.properties().hasProperty(SoulSprouts.AGE, 3));
        this.add(ModBlocks.SOUL_SPROUTS.get(), this.applyExplosionDecay(ModBlocks.SOUL_SPROUTS.get().asItem(), LootTable.lootTable().withPool(LootPool.lootPool().add(LootItem.lootTableItem(ModItems.SOUL_SPROUT.get()))).withPool(LootPool.lootPool().when(lootitemcondition$builder2).add(LootItem.lootTableItem(ModItems.SOUL_SPROUT.get()).apply(ApplyBonusCount.addBonusBinomialDistributionCount(Enchantments.BLOCK_FORTUNE, 0.2514286F, 1))))));

        this.dropPottedContents(ModBlocks.POTTED_BLOSSOMING_ROOT.get());
        this.dropPottedContents(ModBlocks.POTTED_ENDER_ROOT.get());
        this.dropPottedContents(ModBlocks.POTTED_WALNUT_SAPLING.get());
        this.dropPottedContents(ModBlocks.POTTED_DEAD_ROOTS.get());
        this.dropPottedContents(ModBlocks.POTTED_SOUL_FLOWER.get());
    }

    @Override
    protected @NotNull Iterable<Block> getKnownBlocks() {
        return ModBlocks.BLOCKS.getEntries().stream().map(RegistryObject::get)::iterator;
    }
}

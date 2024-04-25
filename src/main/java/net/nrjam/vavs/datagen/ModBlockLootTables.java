package net.nrjam.vavs.datagen;

import net.minecraft.advancements.critereon.StatePropertiesPredicate;
import net.minecraft.data.loot.BlockLootSubProvider;
import net.minecraft.world.flag.FeatureFlags;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.enchantment.Enchantments;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.CropBlock;
import net.minecraft.world.level.storage.loot.LootPool;
import net.minecraft.world.level.storage.loot.LootTable;
import net.minecraft.world.level.storage.loot.entries.LootItem;
import net.minecraft.world.level.storage.loot.functions.ApplyBonusCount;
import net.minecraft.world.level.storage.loot.predicates.LootItemBlockStatePropertyCondition;
import net.minecraft.world.level.storage.loot.predicates.LootItemCondition;
import net.minecraft.world.level.storage.loot.predicates.LootItemRandomChanceCondition;
import net.minecraft.world.level.storage.loot.providers.number.ConstantValue;
import net.minecraftforge.registries.RegistryObject;
import net.nrjam.vavs.block.ModBlocks;
import net.nrjam.vavs.block.natural.CrimsonBerry;
import net.nrjam.vavs.block.natural.GingerCrop;
import net.nrjam.vavs.block.natural.SoulSprouts;
import net.nrjam.vavs.block.natural.WarpedBerry;
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
        dropSelf(ModBlocks.CRYSTAL_BLOCK.get());

        this.add(ModBlocks.CRYSTAL_ORE.get(), (block) -> this.createOreDrop(block, ModItems.CRYSTAL.get()));
        this.add(ModBlocks.ROCK_SALT_BLOCK.get(), (block) -> this.createOreDrop(block, ModItems.ROCK_SALT.get()));
        this.add(ModBlocks.HONEY_CAKE.get(), noDrop());
        this.add(ModBlocks.CHOCOLATE_CAKE.get(), noDrop());
        this.add(ModBlocks.WARPED_CAKE.get(), noDrop());
        this.add(ModBlocks.CRIMSON_CAKE.get(), noDrop());

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

        this.dropSelf(ModBlocks.LAVENDER.get());
        this.dropSelf(ModBlocks.VIOLA.get());
        this.dropSelf(ModBlocks.MARIGOLD.get());
        this.dropSelf(ModBlocks.SNAPDRAGON.get());

        this.dropSelf(ModBlocks.CRYING_BASALT.get());
        this.dropSelf(ModBlocks.CRYING_POLISHED_BASALT.get());
        this.dropSelf(ModBlocks.CRYING_SMOOTH_BASALT.get());

        this.dropSelf(ModBlocks.END_SOIL.get());

        this.add(ModBlocks.WALNUT_LEAVES.get(), (block) -> createLeavesDrops(block, ModBlocks.WALNUT_SAPLING.get(), NORMAL_LEAVES_SAPLING_CHANCES));

        this.add(ModBlocks.BLOSSOMING_ROOT.get(), (block) -> dropSingleRandomChance(ModBlocks.BLOSSOMING_ROOT.get(), Items.STICK, 0.125F, 1));
        this.add(ModBlocks.ENDER_ROOT.get(), (block) -> dropSingleRandomChance(block, Items.STICK, 0.125F, 1));
        this.add(ModBlocks.WILD_CABBAGE.get(), (block) -> dropSingleRandomChance(block, ModItems.CABBAGE_SEED.get(), 0.1F, 0));
        this.add(ModBlocks.WILD_GINGER.get(), (block) -> dropSingleRandomChance(block, ModItems.GINGER.get(), 0.1F, 0));
        this.add(ModBlocks.SOUL_FLOWER.get(), (block) -> dropMultiRandomChance(block, ModItems.SOUL_ESSENCE.get(), 0.1F, 0, ModItems.SOUL_SPROUT.get(), 0.01F, 0));
        this.add(ModBlocks.DEAD_ROOTS.get(), (block) -> dropSingleRandomChance(block, ModItems.AMARANTH_SEED.get(), 0.1F, 0));

        LootItemCondition.Builder lootitemcondition$builder1 = LootItemBlockStatePropertyCondition.hasBlockStateProperties(ModBlocks.CABBAGE_CROP.get()).setProperties(StatePropertiesPredicate.Builder.properties().hasProperty(CropBlock.AGE, 7));
        this.add(ModBlocks.CABBAGE_CROP.get(), this.createCropDrops(ModBlocks.CABBAGE_CROP.get(), ModItems.CABBAGE.get(), ModItems.CABBAGE_SEED.get(), lootitemcondition$builder1));
        LootItemCondition.Builder lootitemcondition$builder2 = LootItemBlockStatePropertyCondition.hasBlockStateProperties(ModBlocks.SOUL_SPROUTS.get()).setProperties(StatePropertiesPredicate.Builder.properties().hasProperty(SoulSprouts.AGE, 3));
        this.add(ModBlocks.SOUL_SPROUTS.get(), this.applyExplosionDecay(ModBlocks.SOUL_SPROUTS.get().asItem(), LootTable.lootTable().withPool(LootPool.lootPool().setRolls(ConstantValue.exactly(0.45F)).add(LootItem.lootTableItem(ModItems.SOUL_SPROUT.get()))).withPool(LootPool.lootPool().when(lootitemcondition$builder2).add(LootItem.lootTableItem(ModItems.SOUL_SPROUT.get()).apply(ApplyBonusCount.addBonusBinomialDistributionCount(Enchantments.BLOCK_FORTUNE, 0.2714286F, 1))))));
        LootItemCondition.Builder lootitemcondition$builder3 = LootItemBlockStatePropertyCondition.hasBlockStateProperties(ModBlocks.AMARANTH_CROP.get()).setProperties(StatePropertiesPredicate.Builder.properties().hasProperty(CropBlock.AGE, 7));
        this.add(ModBlocks.AMARANTH_CROP.get(), this.applyExplosionDecay(ModBlocks.AMARANTH_CROP.get(), LootTable.lootTable().withPool(LootPool.lootPool().add(LootItem.lootTableItem(ModItems.AMARANTH.get()))).withPool(LootPool.lootPool().when(lootitemcondition$builder3).add(LootItem.lootTableItem(ModItems.AMARANTH.get()).apply(ApplyBonusCount.addBonusBinomialDistributionCount(Enchantments.BLOCK_FORTUNE, 0.2314286F, 1)))).withPool(LootPool.lootPool().when(lootitemcondition$builder3).add(LootItem.lootTableItem(ModItems.AMARANTH_ESSENCE.get()).when(LootItemRandomChanceCondition.randomChance(0.1F))))).withPool(LootPool.lootPool().when(lootitemcondition$builder3).add(LootItem.lootTableItem(ModItems.AMARANTH_SEED.get()).apply(ApplyBonusCount.addBonusBinomialDistributionCount(Enchantments.BLOCK_FORTUNE, 0.2314286F, 1)))));
        LootItemCondition.Builder lootitemcondition$builder4 = LootItemBlockStatePropertyCondition.hasBlockStateProperties(ModBlocks.GINGER_CROP.get()).setProperties(StatePropertiesPredicate.Builder.properties().hasProperty(GingerCrop.AGE, 3));
        this.add(ModBlocks.GINGER_CROP.get(), this.applyExplosionDecay(ModBlocks.GINGER_CROP.get().asItem(), LootTable.lootTable().withPool(LootPool.lootPool().setRolls(ConstantValue.exactly(0.95F)).add(LootItem.lootTableItem(ModItems.GINGER.get()))).withPool(LootPool.lootPool().when(lootitemcondition$builder4).add(LootItem.lootTableItem(ModItems.GINGER.get()).apply(ApplyBonusCount.addBonusBinomialDistributionCount(Enchantments.BLOCK_FORTUNE, 0.2714286F, 2))))));

        this.add(ModBlocks.WARPED_BERRIES.get(), this.applyExplosionDecay(ModBlocks.WARPED_BERRIES.get().asItem(), LootTable.lootTable().withPool(LootPool.lootPool().setRolls(ConstantValue.exactly(1.0F)).add(LootItem.lootTableItem(ModItems.WARPED_BERRIES.get()))).withPool(LootPool.lootPool().when(LootItemBlockStatePropertyCondition.hasBlockStateProperties(ModBlocks.WARPED_BERRIES.get()).setProperties(StatePropertiesPredicate.Builder.properties().hasProperty(WarpedBerry.AGE, 3))))));
        this.add(ModBlocks.CRIMSON_BERRIES.get(), this.applyExplosionDecay(ModBlocks.CRIMSON_BERRIES.get().asItem(), LootTable.lootTable().withPool(LootPool.lootPool().setRolls(ConstantValue.exactly(1.0F)).add(LootItem.lootTableItem(ModItems.CRIMSON_BERRIES.get()))).withPool(LootPool.lootPool().when(LootItemBlockStatePropertyCondition.hasBlockStateProperties(ModBlocks.CRIMSON_BERRIES.get()).setProperties(StatePropertiesPredicate.Builder.properties().hasProperty(CrimsonBerry.AGE, 3))))));

        this.dropPottedContents(ModBlocks.POTTED_BLOSSOMING_ROOT.get());
        this.dropPottedContents(ModBlocks.POTTED_ENDER_ROOT.get());
        this.dropPottedContents(ModBlocks.POTTED_WALNUT_SAPLING.get());
        this.dropPottedContents(ModBlocks.POTTED_DEAD_ROOTS.get());
        this.dropPottedContents(ModBlocks.POTTED_SOUL_FLOWER.get());
        this.dropPottedContents(ModBlocks.POTTED_WILD_CABBAGE.get());

        this.dropPottedContents(ModBlocks.POTTED_VIOLA.get());
        this.dropPottedContents(ModBlocks.POTTED_LAVENDER.get());
        this.dropPottedContents(ModBlocks.POTTED_MARIGOLD.get());
        this.dropPottedContents(ModBlocks.POTTED_SNAPDRAGON.get());

    }

    protected LootTable.Builder dropSingleRandomChance(Block block, Item item, float chance, int bonus) {
        return createSilkTouchOrShearsDispatchTable(block, this.applyExplosionCondition(block,
                LootItem.lootTableItem(item)
                        .when(LootItemRandomChanceCondition.randomChance(chance))
                        .apply(ApplyBonusCount.addUniformBonusCount(Enchantments.BLOCK_FORTUNE, bonus))));
    }

    protected LootTable.Builder dropMultiRandomChance(Block block, Item item, float chance, int bonus, Item item2, float chance2, int bonus2) {
        return createSilkTouchOrShearsDispatchTable(block, this.applyExplosionDecay(block,
                LootItem.lootTableItem(item)
                        .when(LootItemRandomChanceCondition.randomChance(chance))
                        .apply(ApplyBonusCount.addUniformBonusCount(Enchantments.BLOCK_FORTUNE, bonus))))
                .withPool(LootPool.lootPool().setRolls(ConstantValue.exactly(1.0F))
                        .add(this.applyExplosionDecay(block, LootItem.lootTableItem(item2)
                                .when(LootItemRandomChanceCondition.randomChance(chance2))
                                .apply(ApplyBonusCount.addUniformBonusCount(Enchantments.BLOCK_FORTUNE, bonus2)))));
    }

    @Override
    protected @NotNull Iterable<Block> getKnownBlocks() {
        return ModBlocks.BLOCKS.getEntries().stream().map(RegistryObject::get)::iterator;
    }
}

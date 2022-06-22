package com.nrjam.vavs.item;

import com.nrjam.vavs.VanillaVariations;
import com.nrjam.vavs.block.ModBlocks;
import com.nrjam.vavs.item.custom.*;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.item.*;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class Items {
    public static final DeferredRegister<Item> ITEMS = DeferredRegister.create(ForgeRegistries.ITEMS, VanillaVariations.MOD_ID);

    public static final RegistryObject<Item> SOUL_TORCH = ITEMS.register("dragons_breath_torch", () -> new StandingAndWallBlockItem(ModBlocks.DRAGONS_BREATH_TORCH.get(), ModBlocks.DRAGONS_BREATH_WALL_TORCH.get(), (new Item.Properties()).tab(CreativeModeTab.TAB_DECORATIONS)));

    public static final RegistryObject<Item> HEART = ITEMS.register("heart", () -> new FoiledItem(new Item.Properties().tab(CreativeModeTab.TAB_MISC).food(FoodItems.HEART)));
    public static final RegistryObject<Item> CURSED_HEART = ITEMS.register("cursed_heart", () -> new Item(new Item.Properties().tab(CreativeModeTab.TAB_MISC).food(FoodItems.HEART)));
    public static final RegistryObject<Item> NETHER_CRYSTAL = ITEMS.register("nether_crystal", () -> new Item(new Item.Properties().tab(CreativeModeTab.TAB_MISC).fireResistant()));
    public static final RegistryObject<Item> REINFORCED_LEATHER = ITEMS.register("reinforced_leather", () -> new Item(new Item.Properties().tab(CreativeModeTab.TAB_MISC)));
    public static final RegistryObject<Item> CRYSTALLIZED_HONEY = ITEMS.register("crystallized_honey", () -> new Item(new Item.Properties().tab(CreativeModeTab.TAB_MISC).food(FoodItems.CRYSTALLIZED_HONEY)));
    public static final RegistryObject<Item> CRYSTALLIZED_COAL = ITEMS.register("crystallized_coal", () -> new CrystallizedCoalItem(new Item.Properties().tab(CreativeModeTab.TAB_MISC)));
    public static final RegistryObject<Item> SOLID_LAVA = ITEMS.register("solid_lava", () -> new SolidLavaItem(new Item.Properties().tab(CreativeModeTab.TAB_MISC)));

    public static final RegistryObject<Item> CRUSHED_SOUL = ITEMS.register("crushed_soul", () -> new Item(new Item.Properties().tab(CreativeModeTab.TAB_MISC)));
    public static final RegistryObject<Item> RAW_SALT = ITEMS.register("raw_salt", () -> new Item(new Item.Properties().tab(CreativeModeTab.TAB_MISC)));
    public static final RegistryObject<Item> SALT = ITEMS.register("salt", () -> new Item(new Item.Properties().tab(CreativeModeTab.TAB_MISC)));

    public static final RegistryObject<ShovelItem> NETHER_CRYSTAL_SHOVEL = ITEMS.register("nether_crystal_shovel", () -> new ShovelItem(ItemTier.NETHER_CRYSTAL, 3.5f, -3f, new Item.Properties().tab(CreativeModeTab.TAB_TOOLS).fireResistant()));
    public static final RegistryObject<SwordItem> NETHER_CRYSTAL_SWORD = ITEMS.register("nether_crystal_sword", () -> new SwordItem(ItemTier.NETHER_CRYSTAL, 5, -2.4f, new Item.Properties().tab(CreativeModeTab.TAB_COMBAT).fireResistant()));
    public static final RegistryObject<PickaxeItem> NETHER_CRYSTAL_PICKAXE = ITEMS.register("nether_crystal_pickaxe", () -> new PickaxeItem(ItemTier.NETHER_CRYSTAL, 3, -2.8f, new Item.Properties().tab(CreativeModeTab.TAB_TOOLS).fireResistant()));
    public static final RegistryObject<AxeItem> NETHER_CRYSTAL_AXE = ITEMS.register("nether_crystal_axe", () -> new AxeItem(ItemTier.NETHER_CRYSTAL, 7, -3f, new Item.Properties().tab(CreativeModeTab.TAB_TOOLS).fireResistant()));
    public static final RegistryObject<HoeItem> NETHER_CRYSTAL_HOE = ITEMS.register("nether_crystal_hoe", () -> new HoeItem(ItemTier.NETHER_CRYSTAL, -2, 0f, new Item.Properties().tab(CreativeModeTab.TAB_TOOLS).fireResistant()));

    public static final RegistryObject<Item> NETHER_CRYSTAL_BOW = ITEMS.register("nether_crystal_bow", () -> new BowItem(new Item.Properties().tab(CreativeModeTab.TAB_COMBAT).durability(800).fireResistant()));

    public static final RegistryObject<ArmorItem> REINFORCED_LEATHER_HELMET = ITEMS.register("reinforced_leather_helmet", () -> new ArmorItem(ArmorMaterial.REINFORCED_LEATHER, EquipmentSlot.HEAD, new Item.Properties().tab(CreativeModeTab.TAB_COMBAT)));
    public static final RegistryObject<ArmorItem> REINFORCED_LEATHER_CHESTPLATE = ITEMS.register("reinforced_leather_chestplate", () -> new ArmorItem(ArmorMaterial.REINFORCED_LEATHER, EquipmentSlot.CHEST, new Item.Properties().tab(CreativeModeTab.TAB_COMBAT)));
    public static final RegistryObject<ArmorItem> REINFORCED_LEATHER_LEGGINGS = ITEMS.register("reinforced_leather_leggings", () -> new ArmorItem(ArmorMaterial.REINFORCED_LEATHER, EquipmentSlot.LEGS, new Item.Properties().tab(CreativeModeTab.TAB_COMBAT)));
    public static final RegistryObject<ArmorItem> REINFORCED_LEATHER_BOOTS = ITEMS.register("reinforced_leather_boots", () -> new ArmorItem(ArmorMaterial.REINFORCED_LEATHER, EquipmentSlot.FEET, new Item.Properties().tab(CreativeModeTab.TAB_COMBAT)));
    public static final RegistryObject<ArmorItem> GILDED_LEATHER_HELMET = ITEMS.register("gilded_leather_helmet", () -> new GildedLeather(ArmorMaterial.GILDED_LEATHER, EquipmentSlot.HEAD, new Item.Properties().tab(CreativeModeTab.TAB_COMBAT)));
    public static final RegistryObject<ArmorItem> GILDED_LEATHER_CHESTPLATE = ITEMS.register("gilded_leather_chestplate", () -> new GildedLeather(ArmorMaterial.GILDED_LEATHER, EquipmentSlot.CHEST, new Item.Properties().tab(CreativeModeTab.TAB_COMBAT)));
    public static final RegistryObject<ArmorItem> GILDED_LEATHER_LEGGINGS = ITEMS.register("gilded_leather_leggings", () -> new GildedLeather(ArmorMaterial.GILDED_LEATHER, EquipmentSlot.LEGS, new Item.Properties().tab(CreativeModeTab.TAB_COMBAT)));
    public static final RegistryObject<ArmorItem> GILDED_LEATHER_BOOTS = ITEMS.register("gilded_leather_boots", () -> new GildedLeather(ArmorMaterial.GILDED_LEATHER, EquipmentSlot.FEET, new Item.Properties().tab(CreativeModeTab.TAB_COMBAT)));
    public static final RegistryObject<ArmorItem> NETHER_CRYSTAL_HELMET = ITEMS.register("nether_crystal_helmet", () -> new ArmorItem(ArmorMaterial.NETHER_CRYSTAL, EquipmentSlot.HEAD, new Item.Properties().tab(CreativeModeTab.TAB_COMBAT).fireResistant()));
    public static final RegistryObject<ArmorItem> NETHER_CRYSTAL_CHESTPLATE = ITEMS.register("nether_crystal_chestplate", () -> new ArmorItem(ArmorMaterial.NETHER_CRYSTAL, EquipmentSlot.CHEST, new Item.Properties().tab(CreativeModeTab.TAB_COMBAT).fireResistant()));
    public static final RegistryObject<ArmorItem> NETHER_CRYSTAL_LEGGINGS = ITEMS.register("nether_crystal_leggings", () -> new ArmorItem(ArmorMaterial.NETHER_CRYSTAL, EquipmentSlot.LEGS, new Item.Properties().tab(CreativeModeTab.TAB_COMBAT).fireResistant()));
    public static final RegistryObject<ArmorItem> NETHER_CRYSTAL_BOOTS = ITEMS.register("nether_crystal_boots", () -> new ArmorItem(ArmorMaterial.NETHER_CRYSTAL, EquipmentSlot.FEET, new Item.Properties().tab(CreativeModeTab.TAB_COMBAT).fireResistant()));

    public static final RegistryObject<ArmorItem> FUSED_SOUL_HELMET = ITEMS.register("fused_soul_helmet", () -> new FusedSoul(ArmorMaterial.FUSED_SOUL, EquipmentSlot.HEAD, new Item.Properties().tab(CreativeModeTab.TAB_COMBAT)));
    public static final RegistryObject<ArmorItem> FUSED_SOUL_CHESTPLATE = ITEMS.register("fused_soul_chestplate", () -> new FusedSoul(ArmorMaterial.FUSED_SOUL, EquipmentSlot.CHEST, new Item.Properties().tab(CreativeModeTab.TAB_COMBAT)));
    public static final RegistryObject<ArmorItem> FUSED_SOUL_LEGGINGS = ITEMS.register("fused_soul_leggings", () -> new FusedSoul(ArmorMaterial.FUSED_SOUL, EquipmentSlot.LEGS, new Item.Properties().tab(CreativeModeTab.TAB_COMBAT)));
    public static final RegistryObject<ArmorItem> FUSED_SOUL_BOOTS = ITEMS.register("fused_soul_boots", () -> new FusedSoul(ArmorMaterial.FUSED_SOUL, EquipmentSlot.FEET, new Item.Properties().tab(CreativeModeTab.TAB_COMBAT)));

    public static final RegistryObject<ArmorItem> FLOWER_CROWN = ITEMS.register("flower_crown", () -> new FlowerCrown(ArmorMaterial.FLOWER_CROWN, EquipmentSlot.HEAD, new Item.Properties().tab(CreativeModeTab.TAB_COMBAT)));

    public static final RegistryObject<Item> CABBAGE_SEED = ITEMS.register("cabbage_seed", () -> new BlockItem(ModBlocks.CABBAGES.get(), (new Item.Properties()).tab(CreativeModeTab.TAB_MISC)));
    public static final RegistryObject<Item> SOUL_SPROUT = ITEMS.register("soul_sprout", () -> new BlockItem(ModBlocks.SOUL_SPROUTS.get(), (new Item.Properties()).tab(CreativeModeTab.TAB_FOOD).food(FoodItems.SOUL_SPROUT)));
    public static final RegistryObject<Item> ENDER_SPROUT = ITEMS.register("ender_sprout", () -> new BlockItem(ModBlocks.ENDER_SPROUTS.get(), (new Item.Properties()).tab(CreativeModeTab.TAB_FOOD).food(FoodItems.ENDER_SPROUT)));
    public static final RegistryObject<Item> ASH_ROOT = ITEMS.register("ash_root", () -> new BlockItem(ModBlocks.ASH_ROOT.get(), (new Item.Properties()).tab(CreativeModeTab.TAB_FOOD).food(FoodItems.ASH_ROOT)));
    public static final RegistryObject<Item> WARPED_SOUL_BERRY = ITEMS.register("warped_soul_berry", () -> new BlockItem(ModBlocks.WARPED_SOUL_BERRY.get(), (new Item.Properties()).tab(CreativeModeTab.TAB_FOOD).food(FoodItems.WARPED_SOUL_BERRY)));
    public static final RegistryObject<Item> CRIMSON_FIRE_BERRY = ITEMS.register("crimson_fire_berry", () -> new BlockItem(ModBlocks.CRIMSON_FIRE_BERRY.get(), (new Item.Properties()).tab(CreativeModeTab.TAB_FOOD).food(FoodItems.CRIMSON_FIRE_BERRY)));
    public static final RegistryObject<Item> WILD_CABBAGE = ITEMS.register("wild_cabbage", () -> new BlockItem(ModBlocks.WILD_CABBAGES.get(), (new Item.Properties()).tab(CreativeModeTab.TAB_DECORATIONS)));
    public static final RegistryObject<Item> CABBAGE = ITEMS.register("cabbage", () -> new Item(new Item.Properties().tab(CreativeModeTab.TAB_FOOD).food(FoodItems.CABBAGE)));

    public static final RegistryObject<Item> CRYSTALLIZED_COAL_BLOCK  = ITEMS.register("crystallized_coal_block", () -> new CrystallizedCoalBlockItem(ModBlocks.CRYSTALLIZED_COAL_BLOCK.get(), (new Item.Properties()).tab(CreativeModeTab.TAB_BUILDING_BLOCKS)));

    public static final RegistryObject<Item> HONEY_CAKE = ITEMS.register("honey_cake", () -> new BlockItem(ModBlocks.HONEY_CAKE.get(), (new Item.Properties().stacksTo(1)).tab(CreativeModeTab.TAB_FOOD)));
    public static final RegistryObject<Item> CHOCOLATE_CAKE = ITEMS.register("chocolate_cake", () -> new BlockItem(ModBlocks.CHOCOLATE_CAKE.get(), (new Item.Properties().stacksTo(1)).tab(CreativeModeTab.TAB_FOOD)));

    public static final RegistryObject<Item> SWEET_BERRY_PIE = ITEMS.register("sweet_berry_pie", () -> new Item(new Item.Properties().tab(CreativeModeTab.TAB_FOOD).food(FoodItems.SWEET_BERRY_PIE)));
    public static final RegistryObject<Item> APPLE_PIE = ITEMS.register("apple_pie", () -> new Item(new Item.Properties().tab(CreativeModeTab.TAB_FOOD).food(FoodItems.APPLE_PIE)));
    public static final RegistryObject<Item> CHORUS_FRUIT_PIE = ITEMS.register("chorus_fruit_pie", () -> new TeleportItem(new Item.Properties().tab(CreativeModeTab.TAB_FOOD).food(FoodItems.CHORUS_FRUIT_PIE)));
    public static final RegistryObject<Item> SOUL_SPROUT_PIE = ITEMS.register("soul_sprout_pie", () -> new Item(new Item.Properties().tab(CreativeModeTab.TAB_FOOD).food(FoodItems.SOUL_SPROUT_PIE)));
    public static final RegistryObject<Item> ENDER_SPROUT_PIE = ITEMS.register("ender_sprout_pie", () -> new Item(new Item.Properties().tab(CreativeModeTab.TAB_FOOD).food(FoodItems.ENDER_SPROUT_PIE)));
    public static final RegistryObject<Item> ASH_ROOT_PIE = ITEMS.register("ash_root_pie", () -> new Item(new Item.Properties().tab(CreativeModeTab.TAB_FOOD).food(FoodItems.ASH_ROOT_PIE)));
    public static final RegistryObject<Item> WARPED_SOUL_BERRY_PIE = ITEMS.register("warped_soul_berry_pie", () -> new Item(new Item.Properties().tab(CreativeModeTab.TAB_FOOD).food(FoodItems.WARPED_SOUL_BERRY_PIE)));
    public static final RegistryObject<Item> CRIMSON_FIRE_BERRY_PIE = ITEMS.register("crimson_fire_berry_pie", () -> new Item(new Item.Properties().tab(CreativeModeTab.TAB_FOOD).food(FoodItems.CRIMSON_FIRE_BERRY_PIE)));

    public static final RegistryObject<Item> DRIED_KELP_SOUP = ITEMS.register("dried_kelp_soup", () -> new BowlFoodItem(new Item.Properties().stacksTo(1).tab(CreativeModeTab.TAB_FOOD).food(FoodItems.DRIED_KELP_SOUP)));
    public static final RegistryObject<Item> SOUL_SPROUT_STEW = ITEMS.register("soul_sprout_stew", () -> new BowlFoodItem(new Item.Properties().stacksTo(1).tab(CreativeModeTab.TAB_FOOD).food(FoodItems.SOUL_SPROUT_STEW)));
    public static final RegistryObject<Item> ENDER_SPROUT_STEW = ITEMS.register("ender_sprout_stew", () -> new BowlFoodItem(new Item.Properties().stacksTo(1).tab(CreativeModeTab.TAB_FOOD).food(FoodItems.ENDER_SPROUT_STEW)));
    public static final RegistryObject<Item> ASH_ROOT_SOUP = ITEMS.register("ash_root_soup", () -> new BowlFoodItem(new Item.Properties().stacksTo(1).tab(CreativeModeTab.TAB_FOOD).food(FoodItems.ASH_ROOT_SOUP)));

    public static final RegistryObject<Item> GARDEN_SALAD = ITEMS.register("garden_salad", () -> new BowlFoodItem(new Item.Properties().stacksTo(1).tab(CreativeModeTab.TAB_FOOD).food(FoodItems.GARDEN_SALAD)));
    public static final RegistryObject<Item> MEAT_SALAD = ITEMS.register("meat_salad", () -> new BowlFoodItem(new Item.Properties().stacksTo(1).tab(CreativeModeTab.TAB_FOOD).food(FoodItems.MEAT_SALAD)));
    public static final RegistryObject<Item> SALMON_SALAD = ITEMS.register("salmon_salad", () -> new BowlFoodItem(new Item.Properties().stacksTo(1).tab(CreativeModeTab.TAB_FOOD).food(FoodItems.SALMON_SALAD)));
    public static final RegistryObject<Item> SWEET_SALAD = ITEMS.register("sweet_salad", () -> new BowlFoodItem(new Item.Properties().stacksTo(1).tab(CreativeModeTab.TAB_FOOD).food(FoodItems.SWEET_SALAD)));
    public static final RegistryObject<Item> SOUL_SPROUT_SALAD = ITEMS.register("soul_sprout_salad", () -> new BowlFoodItem(new Item.Properties().stacksTo(1).tab(CreativeModeTab.TAB_FOOD).food(FoodItems.SOUL_SPROUT_SALAD)));
    public static final RegistryObject<Item> ENDER_SPROUT_SALAD = ITEMS.register("ender_sprout_salad", () -> new BowlFoodItem(new Item.Properties().stacksTo(1).tab(CreativeModeTab.TAB_FOOD).food(FoodItems.ENDER_SPROUT_SALAD)));
    public static final RegistryObject<Item> ASH_ROOT_SALAD = ITEMS.register("ash_root_salad", () -> new BowlFoodItem(new Item.Properties().stacksTo(1).tab(CreativeModeTab.TAB_FOOD).food(FoodItems.ASH_ROOT_SALAD)));

    public static final RegistryObject<Item> STEAK_SANDWICH = ITEMS.register("steak_sandwich", () -> new Item(new Item.Properties().tab(CreativeModeTab.TAB_FOOD).food(FoodItems.STEAK_SANDWICH)));
    public static final RegistryObject<Item> PORK_SANDWICH = ITEMS.register("pork_sandwich", () -> new Item(new Item.Properties().tab(CreativeModeTab.TAB_FOOD).food(FoodItems.PORK_SANDWICH)));
    public static final RegistryObject<Item> CHICKEN_SANDWICH = ITEMS.register("chicken_sandwich", () -> new Item(new Item.Properties().tab(CreativeModeTab.TAB_FOOD).food(FoodItems.CHICKEN_SANDWICH)));

    public static final RegistryObject<Item> HONEYED_CARROT = ITEMS.register("honeyed_carrot", () -> new Item(new Item.Properties().tab(CreativeModeTab.TAB_FOOD).food(FoodItems.HONEYED_CARROT)));
    public static final RegistryObject<Item> HONEYED_GOLDEN_CARROT = ITEMS.register("honeyed_golden_carrot", () -> new Item(new Item.Properties().tab(CreativeModeTab.TAB_FOOD).food(FoodItems.HONEYED_GOLDEN_CARROT)));
    public static final RegistryObject<Item> HONEY_BREAD = ITEMS.register("honey_bread", () -> new Item(new Item.Properties().tab(CreativeModeTab.TAB_FOOD).food(FoodItems.HONEY_BREAD)));

    public static final RegistryObject<Item> CHOCOLATE_APPLE = ITEMS.register("chocolate_apple", () -> new Item(new Item.Properties().tab(CreativeModeTab.TAB_FOOD).food(FoodItems.CHOCOLATE_APPLE)));
    public static final RegistryObject<Item> CHOCOLATE_GOLDEN_APPLE = ITEMS.register("chocolate_golden_apple", () -> new Item(new Item.Properties().tab(CreativeModeTab.TAB_FOOD).food(FoodItems.CHOCOLATE_GOLDEN_APPLE)));
    public static final RegistryObject<Item> CHOCOLATE_ENCHANTED_GOLDEN_APPLE = ITEMS.register("chocolate_enchanted_golden_apple", () -> new FoiledItem(new Item.Properties().tab(CreativeModeTab.TAB_FOOD).food(FoodItems.CHOCOLATE_ENCHANTED_GOLDEN_APPLE)));

    public static void register(IEventBus eventBus) {
        ITEMS.register(eventBus);
    }
}

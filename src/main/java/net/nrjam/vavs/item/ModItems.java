package net.nrjam.vavs.item;

import net.minecraft.world.item.*;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;
import net.nrjam.vavs.VanillaVariations;
import net.nrjam.vavs.block.ModBlocks;
import net.nrjam.vavs.item.custom.FlowerCrownItem;
import net.nrjam.vavs.item.custom.FusedSoulItem;
import net.nrjam.vavs.item.custom.ReinforcedLeatherItem;
import net.nrjam.vavs.item.custom.TeleportItem;

public class ModItems {
    public static final DeferredRegister<Item> ITEMS = DeferredRegister.create(ForgeRegistries.ITEMS, VanillaVariations.MOD_ID);

    public static final RegistryObject<Item> SOUL_ESSENCE = ITEMS.register("soul_essence",
            () -> new Item(new Item.Properties()));
    public static final RegistryObject<Item> AMARANTH_ESSENCE = ITEMS.register("amaranth_essence",
            () -> new Item(new Item.Properties()));
    public static final RegistryObject<Item> REINFORCED_LEATHER = ITEMS.register("reinforced_leather",
            () -> new Item(new Item.Properties()));

    public static final RegistryObject<Item> REINFORCED_LEATHER_HELMET = ITEMS.register("reinforced_leather_helmet",
            () -> new ReinforcedLeatherItem(ModArmorMaterials.REINFORCED_LEATHER, ArmorItem.Type.HELMET, new Item.Properties()));
    public static final RegistryObject<Item> REINFORCED_LEATHER_CHESTPLATE = ITEMS.register("reinforced_leather_chestplate",
            () -> new ReinforcedLeatherItem(ModArmorMaterials.REINFORCED_LEATHER, ArmorItem.Type.CHESTPLATE, new Item.Properties()));
    public static final RegistryObject<Item> REINFORCED_LEATHER_LEGGINGS = ITEMS.register("reinforced_leather_leggings",
            () -> new ReinforcedLeatherItem(ModArmorMaterials.REINFORCED_LEATHER, ArmorItem.Type.LEGGINGS, new Item.Properties()));
    public static final RegistryObject<Item> REINFORCED_LEATHER_BOOTS = ITEMS.register("reinforced_leather_boots",
            () -> new ReinforcedLeatherItem(ModArmorMaterials.REINFORCED_LEATHER, ArmorItem.Type.BOOTS, new Item.Properties()));

    public static final RegistryObject<Item> FUSED_SOUL_HELMET = ITEMS.register("fused_soul_helmet",
            () -> new FusedSoulItem(ModArmorMaterials.FUSED_SOUL, ArmorItem.Type.HELMET, new Item.Properties()));
    public static final RegistryObject<Item> FUSED_SOUL_CHESTPLATE = ITEMS.register("fused_soul_chestplate",
            () -> new FusedSoulItem(ModArmorMaterials.FUSED_SOUL, ArmorItem.Type.CHESTPLATE, new Item.Properties()));
    public static final RegistryObject<Item> FUSED_SOUL_LEGGINGS = ITEMS.register("fused_soul_leggings",
            () -> new FusedSoulItem(ModArmorMaterials.FUSED_SOUL, ArmorItem.Type.LEGGINGS, new Item.Properties()));
    public static final RegistryObject<Item> FUSED_SOUL_BOOTS = ITEMS.register("fused_soul_boots",
            () -> new FusedSoulItem(ModArmorMaterials.FUSED_SOUL, ArmorItem.Type.BOOTS, new Item.Properties()));

    public static final RegistryObject<Item> SOUL_SPROUT = ITEMS.register("soul_sprout",
            () -> new BlockItem(ModBlocks.SOUL_SPROUTS.get(), (new Item.Properties()).food(ModFoodItems.SOUL_SPROUT)));
    public static final RegistryObject<Item> WARPED_BERRIES = ITEMS.register("warped_berries",
            () -> new BlockItem(ModBlocks.WARPED_BERRIES.get(), (new Item.Properties()).food(ModFoodItems.WARPED_BERRIES)));
    public static final RegistryObject<Item> CRIMSON_BERRIES = ITEMS.register("crimson_berries",
            () -> new BlockItem(ModBlocks.CRIMSON_BERRIES.get(), (new Item.Properties()).food(ModFoodItems.CRIMSON_BERRIES)));

    public static final RegistryObject<Item> SWEET_BERRY_PIE = ITEMS.register("sweet_berry_pie",
            () -> new Item(new Item.Properties().food(ModFoodItems.SWEET_BERRY_PIE)));
    public static final RegistryObject<Item> APPLE_PIE = ITEMS.register("apple_pie",
            () -> new Item(new Item.Properties().food(ModFoodItems.APPLE_PIE)));
    public static final RegistryObject<Item> CHORUS_FRUIT_PIE = ITEMS.register("chorus_fruit_pie",
            () -> new TeleportItem(new Item.Properties().food(ModFoodItems.CHORUS_FRUIT_PIE)));
    public static final RegistryObject<Item> SOUL_SPROUT_PIE = ITEMS.register("soul_sprout_pie",
            () -> new Item(new Item.Properties().food(ModFoodItems.SOUL_SPROUT_PIE)));
    public static final RegistryObject<Item> WARPED_BERRY_PIE = ITEMS.register("warped_berry_pie",
            () -> new Item(new Item.Properties().food(ModFoodItems.WARPED_BERRY_PIE)));
    public static final RegistryObject<Item> CRIMSON_BERRY_PIE = ITEMS.register("crimson_berry_pie",
            () -> new Item(new Item.Properties().food(ModFoodItems.CRIMSON_BERRY_PIE)));
    public static final RegistryObject<Item> AMARANTH_PIE = ITEMS.register("amaranth_pie",
            () -> new Item(new Item.Properties().food(ModFoodItems.AMARANTH_PIE)));

    public static final RegistryObject<Item> CABBAGE_SEED = ITEMS.register("cabbage_seed",
            () -> new BlockItem(ModBlocks.CABBAGE_CROP.get(), (new Item.Properties())));
    public static final RegistryObject<Item> CABBAGE = ITEMS.register("cabbage",
            () -> new Item(new Item.Properties().food(ModFoodItems.CABBAGE)));

    public static final RegistryObject<Item> AMARANTH_SEED = ITEMS.register("amaranth_seed",
            () -> new BlockItem(ModBlocks.AMARANTH_CROP.get(), (new Item.Properties())));
    public static final RegistryObject<Item> AMARANTH = ITEMS.register("amaranth",
            () -> new Item(new Item.Properties().food(ModFoodItems.AMARANTH)));

    public static final RegistryObject<Item> AMARANTH_BREAD = ITEMS.register("amaranth_bread",
            () -> new Item(new Item.Properties().food(ModFoodItems.AMARANTH_BREAD)));
    public static final RegistryObject<Item> AMARANTH_COOKIE = ITEMS.register("amaranth_cookie",
            () -> new Item(new Item.Properties().food(ModFoodItems.AMARANTH_COOKIE)));

    public static final RegistryObject<Item> DRIED_KELP_SOUP = ITEMS.register("dried_kelp_soup",
            () -> new BowlFoodItem(new Item.Properties().stacksTo(1).food(ModFoodItems.DRIED_KELP_SOUP)));
    public static final RegistryObject<Item> SOUL_SPROUT_STEW = ITEMS.register("soul_sprout_stew",
            () -> new BowlFoodItem(new Item.Properties().stacksTo(1).food(ModFoodItems.SOUL_SPROUT_STEW)));
    public static final RegistryObject<Item> AMARANTH_SOUP = ITEMS.register("amaranth_soup",
            () -> new BowlFoodItem(new Item.Properties().stacksTo(1).food(ModFoodItems.AMARANTH_SOUP)));

    public static final RegistryObject<Item> GARDEN_SALAD = ITEMS.register("garden_salad",
            () -> new BowlFoodItem(new Item.Properties().stacksTo(1).food(ModFoodItems.GARDEN_SALAD)));
    public static final RegistryObject<Item> MEAT_SALAD = ITEMS.register("meat_salad",
            () -> new BowlFoodItem(new Item.Properties().stacksTo(1).food(ModFoodItems.MEAT_SALAD)));
    public static final RegistryObject<Item> SALMON_SALAD = ITEMS.register("salmon_salad",
            () -> new BowlFoodItem(new Item.Properties().stacksTo(1).food(ModFoodItems.SALMON_SALAD)));
    public static final RegistryObject<Item> SWEET_SALAD = ITEMS.register("sweet_salad",
            () -> new BowlFoodItem(new Item.Properties().stacksTo(1).food(ModFoodItems.SWEET_SALAD)));
    public static final RegistryObject<Item> SOUL_SPROUT_SALAD = ITEMS.register("soul_sprout_salad",
            () -> new BowlFoodItem(new Item.Properties().stacksTo(1).food(ModFoodItems.SOUL_SPROUT_SALAD)));
    public static final RegistryObject<Item> AMARANTH_SALAD = ITEMS.register("amaranth_salad",
            () -> new BowlFoodItem(new Item.Properties().stacksTo(1).food(ModFoodItems.AMARANTH_SALAD)));

    public static final RegistryObject<Item> CRYSTAL = ITEMS.register("crystal",
            () -> new Item(new Item.Properties().fireResistant()));

    public static final RegistryObject<Item> CRYSTAL_HELMET = ITEMS.register("crystal_helmet",
            () -> new ArmorItem(ModArmorMaterials.CRYSTAL, ArmorItem.Type.HELMET, new Item.Properties().fireResistant()));
    public static final RegistryObject<Item> CRYSTAL_CHESTPLATE = ITEMS.register("crystal_chestplate",
            () -> new ArmorItem(ModArmorMaterials.CRYSTAL, ArmorItem.Type.CHESTPLATE, new Item.Properties().fireResistant()));
    public static final RegistryObject<Item> CRYSTAL_LEGGINGS = ITEMS.register("crystal_leggings",
            () -> new ArmorItem(ModArmorMaterials.CRYSTAL, ArmorItem.Type.LEGGINGS, new Item.Properties().fireResistant()));
    public static final RegistryObject<Item> CRYSTAL_BOOTS = ITEMS.register("crystal_boots",
            () -> new ArmorItem(ModArmorMaterials.CRYSTAL, ArmorItem.Type.BOOTS, new Item.Properties().fireResistant()));

    public static final RegistryObject<Item> CRYSTAL_SHOVEL = ITEMS.register("crystal_shovel",
            () -> new ShovelItem(ModItemTier.CRYSTAL, 3.5f, -3f, new Item.Properties().fireResistant()));
    public static final RegistryObject<Item> CRYSTAL_SWORD = ITEMS.register("crystal_sword",
            () -> new SwordItem(ModItemTier.CRYSTAL, 5, -2.4f, new Item.Properties().fireResistant()));
    public static final RegistryObject<Item> CRYSTAL_PICKAXE = ITEMS.register("crystal_pickaxe",
            () -> new PickaxeItem(ModItemTier.CRYSTAL, 3, -2.8f, new Item.Properties().fireResistant()));
    public static final RegistryObject<Item> CRYSTAL_AXE = ITEMS.register("crystal_axe",
            () -> new AxeItem(ModItemTier.CRYSTAL, 7, -3f, new Item.Properties().fireResistant()));
    public static final RegistryObject<Item> CRYSTAL_HOE = ITEMS.register("crystal_hoe",
            () -> new HoeItem(ModItemTier.CRYSTAL, -2, 0f, new Item.Properties().fireResistant()));

    public static final RegistryObject<Item> FUSED_AMARANTH_HELMET = ITEMS.register("fused_amaranth_helmet",
            () -> new ArmorItem(ModArmorMaterials.FUSED_AMARANTH, ArmorItem.Type.HELMET, new Item.Properties().fireResistant()));
    public static final RegistryObject<Item> FUSED_AMARANTH_CHESTPLATE = ITEMS.register("fused_amaranth_chestplate",
            () -> new ArmorItem(ModArmorMaterials.FUSED_AMARANTH, ArmorItem.Type.CHESTPLATE, new Item.Properties().fireResistant()));
    public static final RegistryObject<Item> FUSED_AMARANTH_LEGGINGS = ITEMS.register("fused_amaranth_leggings",
            () -> new ArmorItem(ModArmorMaterials.FUSED_AMARANTH, ArmorItem.Type.LEGGINGS, new Item.Properties().fireResistant()));
    public static final RegistryObject<Item> FUSED_AMARANTH_BOOTS = ITEMS.register("fused_amaranth_boots",
            () -> new ArmorItem(ModArmorMaterials.FUSED_AMARANTH, ArmorItem.Type.BOOTS, new Item.Properties().fireResistant()));

    public static final RegistryObject<Item> FUSED_AMARANTH_SHOVEL = ITEMS.register("fused_amaranth_shovel",
            () -> new ShovelItem(ModItemTier.FUSED_AMARANTH, 3.5f, -3f, new Item.Properties().fireResistant()));
    public static final RegistryObject<Item> FUSED_AMARANTH_SWORD = ITEMS.register("fused_amaranth_sword",
            () -> new SwordItem(ModItemTier.FUSED_AMARANTH, 5, -2.4f, new Item.Properties().fireResistant()));
    public static final RegistryObject<Item> FUSED_AMARANTH_PICKAXE = ITEMS.register("fused_amaranth_pickaxe",
            () -> new PickaxeItem(ModItemTier.FUSED_AMARANTH, 3, -2.8f, new Item.Properties().fireResistant()));
    public static final RegistryObject<Item> FUSED_AMARANTH_AXE = ITEMS.register("fused_amaranth_axe",
            () -> new AxeItem(ModItemTier.FUSED_AMARANTH, 7, -3f, new Item.Properties().fireResistant()));
    public static final RegistryObject<Item> FUSED_AMARANTH_HOE = ITEMS.register("fused_amaranth_hoe",
            () -> new HoeItem(ModItemTier.FUSED_AMARANTH, -2, 0f, new Item.Properties().fireResistant()));

    public static final RegistryObject<Item> FLOWER_CROWN = ITEMS.register("flower_crown",
            () -> new FlowerCrownItem(ModArmorMaterials.FLOWER_CROWN, ArmorItem.Type.HELMET, new Item.Properties()));

    public static void register(IEventBus eventBus) {
        ITEMS.register(eventBus);
    }
}

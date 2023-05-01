package net.nrjam.vavs.item;

import net.minecraft.world.item.ArmorItem;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.Item;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;
import net.nrjam.vavs.VanillaVariations;
import net.nrjam.vavs.block.ModBlocks;
import net.nrjam.vavs.item.custom.FusedSoulItem;
import net.nrjam.vavs.item.custom.ReinforcedLeatherItem;
import net.nrjam.vavs.item.custom.TeleportItem;

public class ModItems {
    public static final DeferredRegister<Item> ITEMS = DeferredRegister.create(ForgeRegistries.ITEMS, VanillaVariations.MOD_ID);

    public static final RegistryObject<Item> SOUL_ESSENCE = ITEMS.register("soul_essence",
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

    public static final RegistryObject<Item> SWEET_BERRY_PIE = ITEMS.register("sweet_berry_pie", () -> new Item(new Item.Properties().food(ModFoodItems.SWEET_BERRY_PIE)));
    public static final RegistryObject<Item> APPLE_PIE = ITEMS.register("apple_pie", () -> new Item(new Item.Properties().food(ModFoodItems.APPLE_PIE)));
    public static final RegistryObject<Item> CHORUS_FRUIT_PIE = ITEMS.register("chorus_fruit_pie", () -> new TeleportItem(new Item.Properties().food(ModFoodItems.CHORUS_FRUIT_PIE)));
    public static final RegistryObject<Item> SOUL_SPROUT_PIE = ITEMS.register("soul_sprout_pie", () -> new Item(new Item.Properties().food(ModFoodItems.SOUL_SPROUT_PIE)));
    public static final RegistryObject<Item> WARPED_BERRY_PIE = ITEMS.register("warped_berry_pie", () -> new Item(new Item.Properties().food(ModFoodItems.WARPED_BERRY_PIE)));
    public static final RegistryObject<Item> CRIMSON_BERRY_PIE = ITEMS.register("crimson_berry_pie", () -> new Item(new Item.Properties().food(ModFoodItems.CRIMSON_BERRY_PIE)));


    public static void register(IEventBus eventBus) {
        ITEMS.register(eventBus);
    }
}

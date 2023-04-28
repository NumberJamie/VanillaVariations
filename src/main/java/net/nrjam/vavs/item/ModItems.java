package net.nrjam.vavs.item;

import net.minecraft.world.item.ArmorItem;
import net.minecraft.world.item.Item;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;
import net.nrjam.vavs.VanillaVariations;
import net.nrjam.vavs.item.custom.FusedSoulItem;
import net.nrjam.vavs.item.custom.ReinforcedLeatherItem;

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

    public static void register(IEventBus eventBus) {
        ITEMS.register(eventBus);
    }
}

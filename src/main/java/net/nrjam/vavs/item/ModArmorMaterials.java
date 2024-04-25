package net.nrjam.vavs.item;

import net.minecraft.Util;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.world.item.ArmorItem;
import net.minecraft.world.item.ArmorMaterial;
import net.minecraft.world.item.crafting.Ingredient;
import net.nrjam.vavs.VanillaVariations;
import org.jetbrains.annotations.NotNull;

import java.util.EnumMap;
import java.util.function.Supplier;

public enum ModArmorMaterials implements ArmorMaterial {
    REINFORCED_LEATHER("reinforced_leather", 23, Util.make(new EnumMap<>(ArmorItem.Type.class), (armorItem) -> {
        armorItem.put(ArmorItem.Type.BOOTS, 3);
        armorItem.put(ArmorItem.Type.LEGGINGS, 5);
        armorItem.put(ArmorItem.Type.CHESTPLATE, 7);
        armorItem.put(ArmorItem.Type.HELMET, 3);
    }), 15, SoundEvents.ARMOR_EQUIP_CHAIN, 0F, 0.0F, () -> Ingredient.of(ModItems.REINFORCED_LEATHER.get())),
    FUSED_SOUL("fused_soul", 30, Util.make(new EnumMap<>(ArmorItem.Type.class), (armorItem) -> {
        armorItem.put(ArmorItem.Type.BOOTS, 1);
        armorItem.put(ArmorItem.Type.LEGGINGS, 3);
        armorItem.put(ArmorItem.Type.CHESTPLATE, 5);
        armorItem.put(ArmorItem.Type.HELMET, 2);
    }), 25, SoundEvents.SOUL_ESCAPE, 0F, 0.0F, () -> Ingredient.of(ModItems.SOUL_ESSENCE.get())),
    FUSED_AMARANTH("fused_amaranth", 64, Util.make(new EnumMap<>(ArmorItem.Type.class), (armorItem) -> {
        armorItem.put(ArmorItem.Type.BOOTS, 1);
        armorItem.put(ArmorItem.Type.LEGGINGS, 3);
        armorItem.put(ArmorItem.Type.CHESTPLATE, 5);
        armorItem.put(ArmorItem.Type.HELMET, 2);
    }), 22, SoundEvents.ARMOR_EQUIP_GENERIC, 0F, 0.0F, () -> Ingredient.of(ModItems.AMARANTH.get())),
    CRYSTAL("crystal", 36, Util.make(new EnumMap<>(ArmorItem.Type.class), (armorItem) -> {
        armorItem.put(ArmorItem.Type.BOOTS, 4);
        armorItem.put(ArmorItem.Type.LEGGINGS, 6);
        armorItem.put(ArmorItem.Type.CHESTPLATE, 9);
        armorItem.put(ArmorItem.Type.HELMET, 4);
    }), 13, SoundEvents.ARMOR_EQUIP_IRON, 1.0F, 0.0F, () -> Ingredient.of(ModItems.CRYSTAL.get())),
    FLOWER_CROWN("flower_crown", 30, Util.make(new EnumMap<>(ArmorItem.Type.class), (armorItem) -> {
        armorItem.put(ArmorItem.Type.BOOTS, 0);
        armorItem.put(ArmorItem.Type.LEGGINGS, 0);
        armorItem.put(ArmorItem.Type.CHESTPLATE, 0);
        armorItem.put(ArmorItem.Type.HELMET, 0);
    }), 20, SoundEvents.AMETHYST_BLOCK_CHIME, 0.0F, 0.0F, () -> Ingredient.of(ModItems.CRYSTAL.get()));

    private static final EnumMap<ArmorItem.Type, Integer> HEALTH_FUNCTION_FOR_TYPE = Util.make(new EnumMap<>(ArmorItem.Type.class), (armorItem) -> {
        armorItem.put(ArmorItem.Type.BOOTS, 13);
        armorItem.put(ArmorItem.Type.LEGGINGS, 15);
        armorItem.put(ArmorItem.Type.CHESTPLATE, 16);
        armorItem.put(ArmorItem.Type.HELMET, 11);
    });
    private final String name;
    private final int durabilityMultiplier;
    private final EnumMap<ArmorItem.Type, Integer> protectionFunctionForType;
    private final int enchantmentValue;
    private final SoundEvent sound;
    private final float toughness;
    private final float knockbackResistance;
    private final Supplier<Ingredient> repairIngredient;

    ModArmorMaterials(String name, int durabilityMultiplier, EnumMap<ArmorItem.Type, Integer> protectionFunctionForType, int enchantmentValue, SoundEvent sound, float toughness, float knockbackResistance, Supplier<Ingredient> repairIngredient) {
        this.name = name;
        this.durabilityMultiplier = durabilityMultiplier;
        this.protectionFunctionForType = protectionFunctionForType;
        this.enchantmentValue = enchantmentValue;
        this.sound = sound;
        this.toughness = toughness;
        this.knockbackResistance = knockbackResistance;
        this.repairIngredient = repairIngredient;
    }

    public int getDurabilityForType(ArmorItem.@NotNull Type armorType) {
        return HEALTH_FUNCTION_FOR_TYPE.get(armorType) * this.durabilityMultiplier;
    }

    public int getDefenseForType(ArmorItem.@NotNull Type armorType) {
        return this.protectionFunctionForType.get(armorType);
    }

    public int getEnchantmentValue() {
        return this.enchantmentValue;
    }

    public @NotNull SoundEvent getEquipSound() {
        return this.sound;
    }

    public @NotNull Ingredient getRepairIngredient() {
        return this.repairIngredient.get();
    }

    public @NotNull String getName() {
        return VanillaVariations.MOD_ID + ':' + this.name;
    }

    public float getToughness() {
        return this.toughness;
    }

    public float getKnockbackResistance() {
        return this.knockbackResistance;
    }
}
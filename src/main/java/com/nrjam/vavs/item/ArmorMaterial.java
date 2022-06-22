package com.nrjam.vavs.item;

import com.nrjam.vavs.VanillaVariations;
import com.nrjam.vavs.block.ModBlocks;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.util.LazyLoadedValue;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.item.crafting.Ingredient;

import java.util.function.Supplier;

public enum ArmorMaterial implements net.minecraft.world.item.ArmorMaterial {
    NETHER_CRYSTAL(VanillaVariations.MOD_ID + ":nether_crystal", 36, new int[]{4, 6, 9, 4}, 13, SoundEvents.ARMOR_EQUIP_IRON, 1.0F, 0.0F, () -> {
        return Ingredient.of(Items.NETHER_CRYSTAL.get());
    }),
    REINFORCED_LEATHER(VanillaVariations.MOD_ID + ":reinforced_leather", 23, new int[]{3, 5, 7, 3}, 15, SoundEvents.ARMOR_EQUIP_CHAIN, 0F, 0.0F, () -> {
        return Ingredient.of(Items.REINFORCED_LEATHER.get());
    }),
    GILDED_LEATHER(VanillaVariations.MOD_ID + ":gilded_leather", 23, new int[]{3, 5, 7, 3}, 15, SoundEvents.ARMOR_EQUIP_CHAIN, 0F, 0.0F, () -> {
        return Ingredient.of(Items.REINFORCED_LEATHER.get());
    }),
    FLOWER_CROWN(VanillaVariations.MOD_ID + ":flower_crown", 30, new int[]{0, 0, 0, 0}, 20, SoundEvents.AMETHYST_BLOCK_CHIME, 0F, 0.0F, () -> {
        return Ingredient.of(ModBlocks.LAVENDER.get());
    }),
    FUSED_SOUL(VanillaVariations.MOD_ID + ":soul_fused", 30, new int[]{1, 3, 5, 2}, 25, SoundEvents.SOUL_ESCAPE, 0F, 0.0F, () -> {
        return Ingredient.of(Items.CRUSHED_SOUL.get());
    });

    private static final int[] HEALTH_PER_SLOT = new int[]{13, 15, 16, 11};
    private final String name;
    private final int durabilityMultiplier;
    private final int[] slotProtections;
    private final int enchantmentValue;
    private final SoundEvent sound;
    private final float toughness;
    private final float knockbackResistance;
    private final LazyLoadedValue<Ingredient> repairIngredient;

    ArmorMaterial(String name, int durabilityMultiplier, int[] slotProtections, int enchantmentValue, SoundEvent sound, float toughness, float knockbackResistance, Supplier<Ingredient> repairIngredient) {
        this.name = name;
        this.durabilityMultiplier = durabilityMultiplier;
        this.slotProtections = slotProtections;
        this.enchantmentValue = enchantmentValue;
        this.sound = sound;
        this.toughness = toughness;
        this.knockbackResistance = knockbackResistance;
        this.repairIngredient = new LazyLoadedValue<>(repairIngredient);
    }

    @Override
    public int getDurabilityForSlot(EquipmentSlot p_40484_) {
        return HEALTH_PER_SLOT[p_40484_.getIndex()] * this.durabilityMultiplier;
    }

    @Override
    public int getDefenseForSlot(EquipmentSlot p_40487_) {
        return this.slotProtections[p_40487_.getIndex()];
    }

    @Override
    public int getEnchantmentValue() {
        return this.enchantmentValue;
    }

    @Override
    public SoundEvent getEquipSound() {
        return this.sound;
    }

    @Override
    public Ingredient getRepairIngredient() {
        return this.repairIngredient.get();
    }

    @Override
    public String getName() {
        return this.name;
    }

    @Override
    public float getToughness() {
        return this.toughness;
    }

    @Override
    public float getKnockbackResistance() {
        return this.knockbackResistance;
    }
}

package net.nrjam.vavs.item.enchantments;

import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.enchantment.Enchantment;
import net.minecraft.world.item.enchantment.EnchantmentCategory;
import net.minecraft.world.item.enchantment.EnchantmentHelper;
import net.minecraft.world.item.enchantment.Enchantments;
import org.jetbrains.annotations.NotNull;

public class Scorching extends Enchantment {
    protected Scorching(Rarity rarity, EnchantmentCategory category, EquipmentSlot... slots) {
        super(rarity, category , slots);
    }

    public static boolean hasScorching(LivingEntity player) {
        return EnchantmentHelper.getEnchantmentLevel(ModEnchantments.SCORCHING.get(), player) > 0;
    }

    public int getMinCost(int minCost) {
        return 5 + (minCost - 1) * 8;
    }

    public int getMaxCost(int maxCost) {
        return super.getMinCost(maxCost) + 50;
    }

    @Override
    public boolean checkCompatibility(@NotNull Enchantment enchantment) {
        return super.checkCompatibility(enchantment) && enchantment != Enchantments.FROST_WALKER;
    }

    @Override
    public boolean canEnchant(@NotNull ItemStack stack) {
        return canApplyAtEnchantingTable(stack);
    }

    @Override
    public boolean canApplyAtEnchantingTable(@NotNull ItemStack stack) {
        return true;
    }

}
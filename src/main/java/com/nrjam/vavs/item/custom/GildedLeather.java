package com.nrjam.vavs.item.custom;

import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.item.ArmorItem;
import net.minecraft.world.item.ArmorMaterial;
import net.minecraft.world.item.ItemStack;

public class GildedLeather extends ArmorItem {
    public GildedLeather(ArmorMaterial material, EquipmentSlot slot, Properties properties) {
        super(material, slot, properties);
    }

    @Override
    public boolean makesPiglinsNeutral(ItemStack stack, LivingEntity wearer)
    {
        return stack.getItem() instanceof ArmorItem && ((ArmorItem) stack.getItem()).getMaterial() == com.nrjam.vavs.item.ArmorMaterial.GILDED_LEATHER;
    }
}

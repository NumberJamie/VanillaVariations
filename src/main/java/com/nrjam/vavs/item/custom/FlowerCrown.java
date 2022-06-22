package com.nrjam.vavs.item.custom;

import com.google.common.collect.ImmutableMap;
import com.nrjam.vavs.item.Items;
import net.minecraft.network.chat.Component;
import net.minecraft.network.chat.TranslatableComponent;
import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.monster.EnderMan;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ArmorItem;
import net.minecraft.world.item.ArmorMaterial;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.TooltipFlag;
import net.minecraft.world.level.Level;
import net.minecraftforge.common.extensions.IForgeItem;
import org.jetbrains.annotations.Nullable;

import java.util.List;
import java.util.Map;
import java.util.Random;

public class FlowerCrown extends ArmorItem implements IForgeItem {
    private static final Map<com.nrjam.vavs.item.ArmorMaterial, MobEffect> MATERIAL_MOB_EFFECT_MAP = (new ImmutableMap.Builder<com.nrjam.vavs.item.ArmorMaterial, MobEffect>())
            .put(com.nrjam.vavs.item.ArmorMaterial.FLOWER_CROWN, MobEffects.REGENERATION).build();

    public FlowerCrown(ArmorMaterial material, EquipmentSlot slot, Properties properties) {
        super(material, slot, properties);
    }

    @Override
    public void appendHoverText(ItemStack stack, @Nullable Level lvl, List<Component> comp, TooltipFlag flag) {
        comp.add(new TranslatableComponent("tooltip.vavs.flower_crown"));
        super.appendHoverText(stack, lvl, comp, flag);
    }

    public boolean isEnderMask(ItemStack stack, Player player, EnderMan endermanEntity)
    {
        return stack.getItem() == Items.FLOWER_CROWN.get();
    }

    @Override
    public void inventoryTick(ItemStack stack, Level lvl, Entity entity, int slot, boolean selected) {
        if (!lvl.isClientSide()) {
            if(entity instanceof Player) {
                Player player = (Player)entity;
                if(hasHelmetOn(player)){
                    evaluateArmorEffects(player);
                }
            }
        }
        super.inventoryTick(stack, lvl, entity, slot, selected);
    }

    private void evaluateArmorEffects(Player player) {
        for (Map.Entry<com.nrjam.vavs.item.ArmorMaterial, MobEffect> entry : MATERIAL_MOB_EFFECT_MAP.entrySet()) {
            ArmorMaterial mapArmorMaterial = entry.getKey();
            MobEffect mapStatusEffect = entry.getValue();

            if(hasCorrectHelmetOn(mapArmorMaterial, player)) {
                addStatusEffectForMaterial(player, mapArmorMaterial, mapStatusEffect);
            }
        }
    }

    private void addStatusEffectForMaterial(Player player, ArmorMaterial mapArmorMaterial,
                                            MobEffect mapStatusEffect) {
        boolean hasPlayerEffect = player.hasEffect(mapStatusEffect);

        if(hasCorrectHelmetOn(mapArmorMaterial, player) && !hasPlayerEffect) {
            if(new Random().nextFloat() > 0.99995f) {
                player.addEffect(new MobEffectInstance(mapStatusEffect, 175, 1));
            }
        }
    }

    private boolean hasHelmetOn(Player player) {
        ItemStack helmet = player.getInventory().getArmor(3);
        return !helmet.isEmpty();
    }

    private boolean hasCorrectHelmetOn(ArmorMaterial material, Player player) {
        ArmorItem helmet = ((ArmorItem)player.getInventory().getArmor(3).getItem());
        return helmet.getMaterial() == material;
    }
}

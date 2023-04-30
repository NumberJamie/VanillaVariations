package net.nrjam.vavs.item;

import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.food.FoodProperties;


public class ModFoodItems {
    public static final FoodProperties SOUL_SPROUT = (new FoodProperties.Builder().nutrition(2).saturationMod(1.2f).fast().effect(() -> new MobEffectInstance(MobEffects.MOVEMENT_SPEED, 150, 0), 1f).effect(() -> new MobEffectInstance(MobEffects.GLOWING, 150, 0), 1f).build());
}
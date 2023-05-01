package net.nrjam.vavs.item;

import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.food.FoodProperties;


public class ModFoodItems {
    public static final FoodProperties CABBAGE = (new FoodProperties.Builder().nutrition(2).saturationMod(1.2f).build());

    public static final FoodProperties SOUL_SPROUT = (new FoodProperties.Builder().nutrition(2).saturationMod(1.2f).fast().effect(() -> new MobEffectInstance(MobEffects.MOVEMENT_SPEED, 150, 0), 1f).effect(() -> new MobEffectInstance(MobEffects.GLOWING, 150, 0), 1f).build());
    public static final FoodProperties WARPED_BERRIES = (new FoodProperties.Builder().nutrition(1).saturationMod(0.25f).fast().effect(() -> new MobEffectInstance(MobEffects.MOVEMENT_SPEED, 30, 0), 1f).effect(() -> new MobEffectInstance(MobEffects.GLOWING, 30, 0), 1f).build());
    public static final FoodProperties CRIMSON_BERRIES = (new FoodProperties.Builder().nutrition(1).saturationMod(0.25f).fast().effect(() -> new MobEffectInstance(MobEffects.FIRE_RESISTANCE, 30, 0), 1f).build());

    public static final FoodProperties SOUL_SPROUT_PIE = (new FoodProperties.Builder().nutrition(5).saturationMod(1f).effect(() -> new MobEffectInstance(MobEffects.MOVEMENT_SPEED, 30*20, 0), 1f).effect(() -> new MobEffectInstance(MobEffects.GLOWING, 20*20, 0), 1f).build());
    public static final FoodProperties SWEET_BERRY_PIE = (new FoodProperties.Builder().nutrition(6).saturationMod(0.5f).build());
    public static final FoodProperties APPLE_PIE = (new FoodProperties.Builder().nutrition(6).saturationMod(0.6f).build());
    public static final FoodProperties WARPED_BERRY_PIE = (new FoodProperties.Builder().nutrition(3).saturationMod(1f).effect(() -> new MobEffectInstance(MobEffects.MOVEMENT_SPEED, 15*20, 0), 1f).effect(() -> new MobEffectInstance(MobEffects.GLOWING, 15*20, 0), 1f).build());
    public static final FoodProperties CRIMSON_BERRY_PIE = (new FoodProperties.Builder().nutrition(3).saturationMod(1f).effect(() -> new MobEffectInstance(MobEffects.FIRE_RESISTANCE, 15*20, 0), 1f).build());
    public static final FoodProperties CHORUS_FRUIT_PIE = (new FoodProperties.Builder().nutrition(5).saturationMod(1f).build());

}
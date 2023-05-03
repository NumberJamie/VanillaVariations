package net.nrjam.vavs.item;

import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.food.FoodProperties;


public class ModFoodItems {
    public static final FoodProperties CABBAGE = (new FoodProperties.Builder().nutrition(2).saturationMod(1.2f).build());
    public static final FoodProperties AMARANTH = (new FoodProperties.Builder().nutrition(2).saturationMod(1.2f).effect(() -> new MobEffectInstance(MobEffects.FIRE_RESISTANCE, 2*20, 0), 1f)).build();

    public static final FoodProperties AMARANTH_BREAD = (new FoodProperties.Builder().nutrition(6).saturationMod(1.2f).effect(() -> new MobEffectInstance(MobEffects.FIRE_RESISTANCE, 30*20, 0), 1f)).build();
    public static final FoodProperties AMARANTH_COOKIE = (new FoodProperties.Builder().nutrition(3).saturationMod(1.2f).effect(() -> new MobEffectInstance(MobEffects.FIRE_RESISTANCE, 15*20, 0), 1f)).build();

    public static final FoodProperties SOUL_SPROUT = (new FoodProperties.Builder().nutrition(2).saturationMod(1.2f).fast().effect(() -> new MobEffectInstance(MobEffects.MOVEMENT_SPEED, 150, 0), 1f).effect(() -> new MobEffectInstance(MobEffects.GLOWING, 150, 0), 1f).build());
    public static final FoodProperties WARPED_BERRIES = (new FoodProperties.Builder().nutrition(1).saturationMod(0.25f).fast().effect(() -> new MobEffectInstance(MobEffects.MOVEMENT_SPEED, 30, 0), 1f).effect(() -> new MobEffectInstance(MobEffects.GLOWING, 30, 0), 1f).build());
    public static final FoodProperties CRIMSON_BERRIES = (new FoodProperties.Builder().nutrition(1).saturationMod(0.25f).fast().effect(() -> new MobEffectInstance(MobEffects.FIRE_RESISTANCE, 30, 0), 1f).build());

    public static final FoodProperties SOUL_SPROUT_PIE = (new FoodProperties.Builder().nutrition(5).saturationMod(1f).effect(() -> new MobEffectInstance(MobEffects.MOVEMENT_SPEED, 30*20, 0), 1f).effect(() -> new MobEffectInstance(MobEffects.GLOWING, 20*20, 0), 1f).build());
    public static final FoodProperties SWEET_BERRY_PIE = (new FoodProperties.Builder().nutrition(6).saturationMod(0.5f).build());
    public static final FoodProperties APPLE_PIE = (new FoodProperties.Builder().nutrition(6).saturationMod(0.6f).build());
    public static final FoodProperties WARPED_BERRY_PIE = (new FoodProperties.Builder().nutrition(3).saturationMod(1f).effect(() -> new MobEffectInstance(MobEffects.MOVEMENT_SPEED, 15*20, 0), 1f).effect(() -> new MobEffectInstance(MobEffects.GLOWING, 15*20, 0), 1f).build());
    public static final FoodProperties AMARANTH_PIE = (new FoodProperties.Builder().nutrition(5).saturationMod(1f).effect(() -> new MobEffectInstance(MobEffects.FIRE_RESISTANCE, 15*20, 0), 1f).build());
    public static final FoodProperties CRIMSON_BERRY_PIE = (new FoodProperties.Builder().nutrition(3).saturationMod(1f).effect(() -> new MobEffectInstance(MobEffects.FIRE_RESISTANCE, 15*20, 0), 1f).build());
    public static final FoodProperties CHORUS_FRUIT_PIE = (new FoodProperties.Builder().nutrition(5).saturationMod(1f).build());

    public static final FoodProperties SOUL_SPROUT_STEW = (new FoodProperties.Builder().nutrition(6).saturationMod(0.6f).effect(() -> new MobEffectInstance(MobEffects.MOVEMENT_SPEED, 45*20, 0), 1f).effect(() -> new MobEffectInstance(MobEffects.GLOWING, 15*20, 0), 1f).build());
    public static final FoodProperties DRIED_KELP_SOUP = (new FoodProperties.Builder().nutrition(4).saturationMod(0.5f).build());
    public static final FoodProperties AMARANTH_SOUP = (new FoodProperties.Builder().nutrition(6).saturationMod(0.8f).effect(() -> new MobEffectInstance(MobEffects.FIRE_RESISTANCE, 45*20, 0), 1f).build());

    public static final FoodProperties SOUL_SPROUT_SALAD = (new FoodProperties.Builder().nutrition(5).saturationMod(1.5f).effect(() -> new MobEffectInstance(MobEffects.MOVEMENT_SPEED, 15*20, 0), 1f).effect(() -> new MobEffectInstance(MobEffects.GLOWING, 15*20, 0), 1f).build());
    public static final FoodProperties GARDEN_SALAD = (new FoodProperties.Builder().nutrition(6).saturationMod(1.2f).build());
    public static final FoodProperties MEAT_SALAD = (new FoodProperties.Builder().nutrition(10).saturationMod(1f).build());
    public static final FoodProperties SALMON_SALAD = (new FoodProperties.Builder().nutrition(6).saturationMod(1.2f).build());
    public static final FoodProperties SWEET_SALAD = (new FoodProperties.Builder().nutrition(5).saturationMod(1.5f).build());
    public static final FoodProperties AMARANTH_SALAD = (new FoodProperties.Builder().nutrition(7).saturationMod(1.2f).effect(() -> new MobEffectInstance(MobEffects.FIRE_RESISTANCE, 15*20, 0), 1f).build());
}
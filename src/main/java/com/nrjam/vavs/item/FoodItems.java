package com.nrjam.vavs.item;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.food.FoodProperties;
import net.minecraft.world.food.Foods;


public class FoodItems {
    public static final FoodProperties HEART = (new FoodProperties.Builder().nutrition(1).saturationMod(0.2f).effect(() -> new MobEffectInstance(MobEffects.HUNGER, 15*20, 0), 1f).effect(() -> new MobEffectInstance(MobEffects.POISON, 20*20, 1), 1f).build());

    public static final FoodProperties CABBAGE = (new FoodProperties.Builder().nutrition(2).saturationMod(1.2f).build());
    public static final FoodProperties SOUL_SPROUT = (new FoodProperties.Builder().nutrition(2).saturationMod(1.2f).fast().effect(() -> new MobEffectInstance(MobEffects.MOVEMENT_SPEED, 150, 0), 1f).effect(() -> new MobEffectInstance(MobEffects.GLOWING, 150, 0), 1f).build());
    public static final FoodProperties ASH_ROOT = (new FoodProperties.Builder().nutrition(1).saturationMod(1.0f).effect(() -> new MobEffectInstance(MobEffects.FIRE_RESISTANCE, 150, 0), 1f).build());
    public static final FoodProperties ENDER_SPROUT = (new FoodProperties.Builder().nutrition(3).saturationMod(1.2f).fast().effect(() -> new MobEffectInstance(MobEffects.LEVITATION, 30, 0), 1f).build());
    public static final FoodProperties WARPED_SOUL_BERRY = (new FoodProperties.Builder().nutrition(1).saturationMod(0.25f).fast().effect(() -> new MobEffectInstance(MobEffects.MOVEMENT_SPEED, 30, 0), 1f).effect(() -> new MobEffectInstance(MobEffects.GLOWING, 30, 0), 1f).build());
    public static final FoodProperties CRIMSON_FIRE_BERRY = (new FoodProperties.Builder().nutrition(1).saturationMod(0.25f).fast().effect(() -> new MobEffectInstance(MobEffects.FIRE_RESISTANCE, 30, 0), 1f).build());
    public static final FoodProperties SOUL_SPROUT_SALAD = (new FoodProperties.Builder().nutrition(5).saturationMod(1.5f).effect(() -> new MobEffectInstance(MobEffects.MOVEMENT_SPEED, 15*20, 0), 1f).effect(() -> new MobEffectInstance(MobEffects.GLOWING, 15*20, 0), 1f).build());
    public static final FoodProperties SOUL_SPROUT_PIE = (new FoodProperties.Builder().nutrition(5).saturationMod(1f).effect(() -> new MobEffectInstance(MobEffects.MOVEMENT_SPEED, 30*20, 0), 1f).effect(() -> new MobEffectInstance(MobEffects.GLOWING, 20*20, 0), 1f).build());
    public static final FoodProperties SOUL_SPROUT_STEW = (new FoodProperties.Builder().nutrition(6).saturationMod(0.6f).effect(() -> new MobEffectInstance(MobEffects.MOVEMENT_SPEED, 45*20, 0), 1f).effect(() -> new MobEffectInstance(MobEffects.GLOWING, 15*20, 0), 1f).build());
    public static final FoodProperties ASH_ROOT_SALAD = (new FoodProperties.Builder().nutrition(4).saturationMod(1.5f).effect(() -> new MobEffectInstance(MobEffects.FIRE_RESISTANCE, 15*20, 0), 1f).build());
    public static final FoodProperties ASH_ROOT_PIE = (new FoodProperties.Builder().nutrition(4).saturationMod(1f).effect(() -> new MobEffectInstance(MobEffects.FIRE_RESISTANCE, 30*20, 0), 1f).build());
    public static final FoodProperties ASH_ROOT_SOUP = (new FoodProperties.Builder().nutrition(4).saturationMod(0.6f).effect(() -> new MobEffectInstance(MobEffects.FIRE_RESISTANCE, 45*20, 0), 1f).build());

    public static final FoodProperties ENDER_SPROUT_PIE = (new FoodProperties.Builder().nutrition(6).saturationMod(1f).fast().effect(() -> new MobEffectInstance(MobEffects.LEVITATION, 30, 0), 1f).effect(() -> new MobEffectInstance(MobEffects.DIG_SPEED, 30*20, 1), 1f).build());
    public static final FoodProperties ENDER_SPROUT_STEW = (new FoodProperties.Builder().nutrition(6).saturationMod(0.6f).fast().effect(() -> new MobEffectInstance(MobEffects.LEVITATION, 30, 0), 1f).effect(() -> new MobEffectInstance(MobEffects.DIG_SPEED, 45*20, 1), 1f).build());
    public static final FoodProperties ENDER_SPROUT_SALAD = (new FoodProperties.Builder().nutrition(6).saturationMod(1.5f).fast().effect(() -> new MobEffectInstance(MobEffects.LEVITATION, 30, 0), 1f).effect(() -> new MobEffectInstance(MobEffects.DIG_SPEED, 25*20, 1), 1f).build());
    public static final FoodProperties SWEET_BERRY_PIE = (new FoodProperties.Builder().nutrition(6).saturationMod(0.5f).build());
    public static final FoodProperties APPLE_PIE = (new FoodProperties.Builder().nutrition(6).saturationMod(0.6f).build());
    public static final FoodProperties WARPED_SOUL_BERRY_PIE = (new FoodProperties.Builder().nutrition(3).saturationMod(1f).effect(() -> new MobEffectInstance(MobEffects.MOVEMENT_SPEED, 15*20, 0), 1f).effect(() -> new MobEffectInstance(MobEffects.GLOWING, 15*20, 0), 1f).build());
    public static final FoodProperties CRIMSON_FIRE_BERRY_PIE = (new FoodProperties.Builder().nutrition(3).saturationMod(1f).effect(() -> new MobEffectInstance(MobEffects.FIRE_RESISTANCE, 15*20, 0), 1f).build());
    public static final FoodProperties CHORUS_FRUIT_PIE = (new FoodProperties.Builder().nutrition(5).saturationMod(1f).build());
    public static final FoodProperties DRIED_KELP_SOUP = (new FoodProperties.Builder().nutrition(4).saturationMod(0.5f).build());

    public static final FoodProperties STEAK_SANDWICH = (new FoodProperties.Builder().nutrition(10).saturationMod(0.75f).build());
    public static final FoodProperties PORK_SANDWICH = (new FoodProperties.Builder().nutrition(10).saturationMod(0.75f).build());
    public static final FoodProperties CHICKEN_SANDWICH = (new FoodProperties.Builder().nutrition(8).saturationMod(0.5f).build());

    public static final FoodProperties GARDEN_SALAD = (new FoodProperties.Builder().nutrition(6).saturationMod(1.2f).build());
    public static final FoodProperties MEAT_SALAD = (new FoodProperties.Builder().nutrition(10).saturationMod(1f).build());
    public static final FoodProperties SALMON_SALAD = (new FoodProperties.Builder().nutrition(6).saturationMod(1.2f).build());
    public static final FoodProperties SWEET_SALAD = (new FoodProperties.Builder().nutrition(5).saturationMod(1.5f).build());

    public static final FoodProperties HONEYED_CARROT = (new FoodProperties.Builder().nutrition(5).saturationMod(0.7f).build());
    public static final FoodProperties HONEYED_GOLDEN_CARROT = (new FoodProperties.Builder().nutrition(8).saturationMod(1.1f).build());
    public static final FoodProperties HONEY_BREAD = (new FoodProperties.Builder().nutrition(6).saturationMod(0.7f).build());

    public static final FoodProperties CRYSTALLIZED_HONEY = (new FoodProperties.Builder().nutrition(6).saturationMod(0.6f).build());

    public static final FoodProperties CHOCOLATE = (new FoodProperties.Builder().nutrition(4).saturationMod(1f).build());
    public static final FoodProperties CHOCOLATE_APPLE = (new FoodProperties.Builder().nutrition(6).saturationMod(0.5f).effect(() -> new MobEffectInstance(MobEffects.SATURATION, 30*20, 0), 1f).build());
    public static final FoodProperties CHOCOLATE_GOLDEN_APPLE = (new FoodProperties.Builder().nutrition(6).saturationMod(0.9f)).effect(() -> new MobEffectInstance(MobEffects.SATURATION, 45*20, 0), 1f).effect(() -> new MobEffectInstance(MobEffects.ABSORPTION, 180*20, 0), 1f).effect(() -> new MobEffectInstance(MobEffects.REGENERATION, 7*20, 1), 1f).build();
    public static final FoodProperties CHOCOLATE_ENCHANTED_GOLDEN_APPLE = (new FoodProperties.Builder().nutrition(6).saturationMod(0.9f)).effect(() -> new MobEffectInstance(MobEffects.SATURATION, 60*20, 0), 1f).effect(() -> new MobEffectInstance(MobEffects.ABSORPTION, 180*20, 3), 1f).effect(() -> new MobEffectInstance(MobEffects.REGENERATION, 26*20, 1), 1f).effect(() -> new MobEffectInstance(MobEffects.FIRE_RESISTANCE, 400*20, 0), 1f).effect(() -> new MobEffectInstance(MobEffects.DAMAGE_RESISTANCE, 400*20, 0), 1f).build();

}

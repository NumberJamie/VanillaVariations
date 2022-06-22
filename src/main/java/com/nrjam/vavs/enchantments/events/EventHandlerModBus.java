package com.nrjam.vavs.enchantments.events;

import com.nrjam.vavs.VanillaVariations;
import com.nrjam.vavs.enchantments.events.loot.*;
import com.nrjam.vavs.recipe.CrystallizerRecipe;
import net.minecraft.core.Registry;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.crafting.RecipeSerializer;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.common.loot.GlobalLootModifierSerializer;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import org.checkerframework.checker.index.qual.PolyUpperBound;

import javax.annotation.Nonnull;
import javax.annotation.Nullable;

@Mod.EventBusSubscriber(modid = VanillaVariations.MOD_ID, bus = Mod.EventBusSubscriber.Bus.MOD)

public class EventHandlerModBus {
    @SubscribeEvent
    public static void registerModifierSerializers(@Nonnull final RegistryEvent.Register<GlobalLootModifierSerializer<?>> event) {
        event.getRegistry().registerAll(
                new CabbageSeedFromVillage.Serializer().setRegistryName(new ResourceLocation(VanillaVariations.MOD_ID, "cabbage_seed_from_village")),
                new DragonsBreathLanternFromEndCity.Serializer().setRegistryName(new ResourceLocation(VanillaVariations.MOD_ID, "dragons_breath_lantern_from_end_city")),
                new DragonsBreathTorchFromEndCity.Serializer().setRegistryName(new ResourceLocation(VanillaVariations.MOD_ID, "dragons_breath_torch_from_end_city")),
                new WildCabbageFromVillage.Serializer().setRegistryName(new ResourceLocation(VanillaVariations.MOD_ID, "wild_cabbage_from_village")),
                new HeartFromBastion.Serializer().setRegistryName(new ResourceLocation(VanillaVariations.MOD_ID, "heart_from_bastion"))
        );
    }

    @SubscribeEvent
    public static void registerRecipeTypes(final RegistryEvent.Register<RecipeSerializer<?>> event) {
        Registry.register(Registry.RECIPE_TYPE, CrystallizerRecipe.Type.ID, CrystallizerRecipe.Type.INSTANCE);
    }
}

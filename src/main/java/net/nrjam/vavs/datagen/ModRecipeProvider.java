package net.nrjam.vavs.datagen;

import net.minecraft.data.PackOutput;
import net.minecraft.data.recipes.*;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.TagKey;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.crafting.Ingredient;
import net.minecraft.world.level.ItemLike;
import net.minecraftforge.common.crafting.conditions.IConditionBuilder;
import net.nrjam.vavs.VanillaVariations;
import net.nrjam.vavs.block.ModBlocks;
import net.nrjam.vavs.datagen.tags.ModTags;
import net.nrjam.vavs.item.ModItems;
import org.jetbrains.annotations.NotNull;

import javax.annotation.Nullable;
import java.util.function.Consumer;

public class ModRecipeProvider extends RecipeProvider implements IConditionBuilder {
    public ModRecipeProvider(PackOutput output) {
        super(output);
    }

    @Override
    protected void buildRecipes(@NotNull Consumer<FinishedRecipe> consumer) {
        nineBlockStorageRecipes(consumer, RecipeCategory.BUILDING_BLOCKS, ModItems.REINFORCED_LEATHER.get(),
                RecipeCategory.MISC, ModBlocks.REINFORCED_LEATHER_BLOCK.get());
        ShapedRecipeBuilder.shaped(RecipeCategory.COMBAT, ModItems.REINFORCED_LEATHER_HELMET.get()).define('X', ModItems.REINFORCED_LEATHER.get())
                .pattern("XXX").pattern("X X")
                .unlockedBy("has_reinforced_leather", has(ModItems.REINFORCED_LEATHER.get())).save(consumer);
        ShapedRecipeBuilder.shaped(RecipeCategory.COMBAT, ModItems.REINFORCED_LEATHER_CHESTPLATE.get()).define('X', ModItems.REINFORCED_LEATHER.get())
                .pattern("X X").pattern("XXX").pattern("XXX")
                .unlockedBy("has_reinforced_leather", has(ModItems.REINFORCED_LEATHER.get())).save(consumer);
        ShapedRecipeBuilder.shaped(RecipeCategory.COMBAT, ModItems.REINFORCED_LEATHER_LEGGINGS.get()).define('X', ModItems.REINFORCED_LEATHER.get())
                .pattern("XXX").pattern("X X").pattern("X X")
                .unlockedBy("has_reinforced_leather", has(ModItems.REINFORCED_LEATHER.get())).save(consumer);
        ShapedRecipeBuilder.shaped(RecipeCategory.COMBAT, ModItems.REINFORCED_LEATHER_BOOTS.get()).define('X', ModItems.REINFORCED_LEATHER.get())
                .pattern("X X").pattern("X X")
                .unlockedBy("has_reinforced_leather", has(ModItems.REINFORCED_LEATHER.get())).save(consumer);
        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, ModItems.REINFORCED_LEATHER.get()).define('Y', Items.LEATHER).define('X', Items.IRON_INGOT)
                .pattern("XYX").pattern("YYY").pattern("XYX")
                .unlockedBy("has_leather", has(Items.LEATHER)).save(consumer);
        woodFromLogs(consumer, ModBlocks.WALNUT_LOG.get(), ModBlocks.WALNUT_WOOD.get());
        woodFromLogs(consumer, ModBlocks.STRIPPED_WALNUT_LOG.get(), ModBlocks.STRIPPED_WALNUT_WOOD.get());
        planksFromLogs(consumer, ModBlocks.WALNUT_PLANKS.get(), ModTags.Items.WALNUT_LOGS, 4);
    }

    protected static void planksFromLogs(@NotNull Consumer<FinishedRecipe> consumer, ItemLike p_259193_, TagKey<Item> p_259818_, int p_259807_) {
        ShapelessRecipeBuilder.shapeless(RecipeCategory.BUILDING_BLOCKS, p_259193_, p_259807_).requires(p_259818_).group("planks").unlockedBy("has_logs", has(p_259818_)).save(consumer);
    }

    protected static void woodFromLogs(@NotNull Consumer<FinishedRecipe> consumer, ItemLike p_126004_, @NotNull ItemLike p_126005_) {
        ShapedRecipeBuilder.shaped(RecipeCategory.BUILDING_BLOCKS, p_126004_, 3).define('#', p_126005_).pattern("##").pattern("##").group("bark").unlockedBy("has_log", has(p_126005_)).save(consumer);
    }

    protected static void nineBlockStorageRecipes(@NotNull Consumer<FinishedRecipe> consumer, @NotNull RecipeCategory recipeCategory, ItemLike itemLike, @NotNull RecipeCategory recipeCategory1, ItemLike itemLike1) {
        nineBlockStorageRecipes(consumer, recipeCategory, itemLike, recipeCategory1, itemLike1, getSimpleRecipeName(itemLike1), (String)null, getSimpleRecipeName(itemLike), (String)null);
    }

    protected static void nineBlockStorageRecipes(@NotNull Consumer<FinishedRecipe> consumer, @NotNull RecipeCategory recipeCategory, ItemLike itemLike, @NotNull RecipeCategory recipeCategory1, ItemLike itemLike1, String s, @Nullable String s1, String s2, @Nullable String s3) {
        String compressedS2 = s2 + "_compressed";
        ShapelessRecipeBuilder.shapeless(recipeCategory, itemLike, 9).requires(itemLike1).group(s3).unlockedBy(getHasName(itemLike1), has(itemLike1)).save(consumer, new ResourceLocation(VanillaVariations.MOD_ID, compressedS2));
        ShapedRecipeBuilder.shaped(recipeCategory1, itemLike1).define('#', itemLike).pattern("###").pattern("###").pattern("###").group(s1).unlockedBy(getHasName(itemLike), has(itemLike)).save(consumer, new ResourceLocation(VanillaVariations.MOD_ID, s));
    }
}

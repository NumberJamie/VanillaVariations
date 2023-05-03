package net.nrjam.vavs.datagen;

import net.minecraft.data.PackOutput;
import net.minecraft.data.recipes.*;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.BlockTags;
import net.minecraft.tags.ItemTags;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.crafting.Ingredient;
import net.minecraft.world.level.ItemLike;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
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
        nineBlockStorageRecipes(consumer, RecipeCategory.BUILDING_BLOCKS, ModItems.CRYSTAL.get(),
                RecipeCategory.MISC, ModBlocks.CRYSTAL_BLOCK.get());
        helmetRecipe(consumer, ModItems.CRYSTAL_HELMET.get(), ModItems.CRYSTAL.get());
        chestplateRecipe(consumer, ModItems.CRYSTAL_CHESTPLATE.get(), ModItems.CRYSTAL.get());
        leggingsRecipe(consumer, ModItems.CRYSTAL_LEGGINGS.get(), ModItems.CRYSTAL.get());
        bootsRecipe(consumer, ModItems.CRYSTAL_BOOTS.get(), ModItems.CRYSTAL.get());
        helmetRecipe(consumer, ModItems.REINFORCED_LEATHER_HELMET.get(), ModItems.REINFORCED_LEATHER.get());
        chestplateRecipe(consumer, ModItems.REINFORCED_LEATHER_CHESTPLATE.get(), ModItems.REINFORCED_LEATHER.get());
        leggingsRecipe(consumer, ModItems.REINFORCED_LEATHER_LEGGINGS.get(), ModItems.REINFORCED_LEATHER.get());
        bootsRecipe(consumer, ModItems.REINFORCED_LEATHER_BOOTS.get(), ModItems.REINFORCED_LEATHER.get());
        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, ModItems.REINFORCED_LEATHER.get()).define('Y', Items.LEATHER).define('X', Items.IRON_INGOT)
                .pattern("XYX").pattern("YYY").pattern("XYX")
                .unlockedBy("has_leather", has(Items.LEATHER)).save(consumer);
        ShapedRecipeBuilder.shaped(RecipeCategory.BUILDING_BLOCKS, ModBlocks.SOUL_STONE.get()).define('X', Blocks.SOUL_SOIL)
                .pattern("XX").pattern("XX")
                .unlockedBy("has_soul_soil", has(Blocks.SOUL_SOIL)).save(consumer);
        ShapedRecipeBuilder.shaped(RecipeCategory.BUILDING_BLOCKS, ModBlocks.SOUL_LIGHT.get()).define('X', Blocks.GLOWSTONE).define('Y', ModItems.SOUL_ESSENCE.get())
                .pattern("YYY").pattern("YXY").pattern("YYY")
                .unlockedBy("has_soul_essence", has(ModItems.SOUL_ESSENCE.get())).save(consumer);
        ShapedRecipeBuilder.shaped(RecipeCategory.COMBAT, ModItems.FLOWER_CROWN.get()).define('Y', ItemTags.FLOWERS)
                .pattern("YYY").pattern("Y Y").pattern("YYY")
                .unlockedBy("has_flowers", has(ItemTags.FLOWERS)).save(consumer);
        wallBuilder(RecipeCategory.BUILDING_BLOCKS, ModBlocks.SOUL_STONE_WALL.get(), Ingredient.of(ModBlocks.SOUL_STONE.get())).unlockedBy(getHasName(ModBlocks.SOUL_STONE.get()), has(ModBlocks.SOUL_STONE.get())).save(consumer);
        woodFromLogs(consumer, ModBlocks.WALNUT_LOG.get(), ModBlocks.WALNUT_WOOD.get());
        woodFromLogs(consumer, ModBlocks.STRIPPED_WALNUT_LOG.get(), ModBlocks.STRIPPED_WALNUT_WOOD.get());
        planksFromLogs(consumer, ModBlocks.WALNUT_PLANKS.get(), ModTags.Items.WALNUT_LOGS, 4);
        stairBuilder(ModBlocks.WALNUT_STAIRS.get(), Ingredient.of(ModBlocks.WALNUT_PLANKS.get())).unlockedBy(getHasName(ModBlocks.WALNUT_PLANKS.get()), has(ModBlocks.WALNUT_PLANKS.get())).group("wooden_stairs").save(consumer);
        stairBuilder(ModBlocks.SOUL_STONE_STAIRS.get(), Ingredient.of(ModBlocks.SOUL_STONE.get())).unlockedBy(getHasName(ModBlocks.SOUL_STONE.get()), has(ModBlocks.SOUL_STONE.get())).group("stone_wall").save(consumer);
        fenceBuilder(ModBlocks.WALNUT_FENCE.get(), Ingredient.of(ModBlocks.WALNUT_PLANKS.get())).unlockedBy(getHasName(ModBlocks.WALNUT_PLANKS.get()), has(ModBlocks.WALNUT_PLANKS.get())).group("wooden_fence").save(consumer);
        fenceGateBuilder(ModBlocks.WALNUT_FENCE_GATE.get(), Ingredient.of(ModBlocks.WALNUT_PLANKS.get())).unlockedBy(getHasName(ModBlocks.WALNUT_PLANKS.get()), has(ModBlocks.WALNUT_PLANKS.get())).group("wooden_fence").save(consumer);
        slab(consumer, RecipeCategory.BUILDING_BLOCKS, ModBlocks.WALNUT_SLAB.get(), ModBlocks.WALNUT_PLANKS.get());
        slab(consumer, RecipeCategory.BUILDING_BLOCKS, ModBlocks.SOUL_STONE_SLAB.get(), ModBlocks.SOUL_STONE.get());
        doorBuilder(ModBlocks.WALNUT_DOOR.get(), Ingredient.of(ModBlocks.WALNUT_PLANKS.get())).unlockedBy(getHasName(ModBlocks.WALNUT_PLANKS.get()), has(ModBlocks.WALNUT_PLANKS.get())).group("wooden_door").save(consumer);
        trapdoorBuilder(ModBlocks.WALNUT_TRAPDOOR.get(), Ingredient.of(ModBlocks.WALNUT_PLANKS.get())).unlockedBy(getHasName(ModBlocks.WALNUT_PLANKS.get()), has(ModBlocks.WALNUT_PLANKS.get())).group("wooden_trapdoor_top").save(consumer);
        buttonBuilder(ModBlocks.WALNUT_BUTTON.get(), Ingredient.of(ModBlocks.WALNUT_PLANKS.get())).unlockedBy(getHasName(ModBlocks.WALNUT_PLANKS.get()), has(ModBlocks.WALNUT_PLANKS.get())).group("wooden_button").save(consumer);
        pressurePlateBuilder(RecipeCategory.REDSTONE, ModBlocks.WALNUT_PRESSURE_PLATE.get(), Ingredient.of(ModBlocks.WALNUT_PLANKS.get())).unlockedBy(getHasName(ModBlocks.WALNUT_PLANKS.get()), has(ModBlocks.WALNUT_PLANKS.get())).group("wooden_pressure_plate").save(consumer);

        pieRecipe(consumer, ModItems.SWEET_BERRY_PIE.get(), Items.SWEET_BERRIES);
        pieRecipe(consumer, ModItems.APPLE_PIE.get(), Items.APPLE);
        pieRecipe(consumer, ModItems.CHORUS_FRUIT_PIE.get(), Items.CHORUS_FRUIT);
        pieRecipe(consumer, ModItems.SOUL_SPROUT_PIE.get(), ModItems.SOUL_SPROUT.get());
        pieRecipe(consumer, ModItems.WARPED_BERRY_PIE.get(), ModItems.WARPED_BERRIES.get());
        pieRecipe(consumer, ModItems.CRIMSON_BERRY_PIE.get(), ModItems.CRIMSON_BERRIES.get());
        pieRecipe(consumer, ModItems.AMARANTH_PIE.get(), ModItems.AMARANTH.get());

        flowerRecipe(consumer, Items.BLACK_DYE, ModBlocks.VIOLA.get());
        flowerRecipe(consumer, Items.PURPLE_DYE, ModBlocks.LAVENDER.get());
        flowerRecipe(consumer, Items.ORANGE_DYE, ModBlocks.MARIGOLD.get());
        flowerRecipe(consumer, Items.MAGENTA_DYE, ModBlocks.SNAPDRAGON.get());

        stewRecipe(consumer, ModItems.DRIED_KELP_SOUP.get(), Items.DRIED_KELP);
        stewRecipe(consumer, ModItems.SOUL_SPROUT_STEW.get(), ModItems.SOUL_SPROUT.get());
        stewRecipe(consumer, ModItems.AMARANTH_SOUP.get(), ModItems.AMARANTH.get());

        saladRecipe(consumer, ModItems.MEAT_SALAD.get(), Items.COOKED_PORKCHOP, Items.COOKED_CHICKEN, Items.COOKED_BEEF);
        saladRecipe(consumer, ModItems.SALMON_SALAD.get(), Items.DRIED_KELP, Items.DRIED_KELP, Items.COOKED_SALMON);
        saladRecipe(consumer, ModItems.GARDEN_SALAD.get(), Items.SWEET_BERRIES, Items.APPLE, Items.MELON_SLICE);
        saladRecipe(consumer, ModItems.SOUL_SPROUT_SALAD.get(), ModItems.SOUL_SPROUT.get(), ModItems.SOUL_SPROUT.get(), ModItems.SOUL_SPROUT.get());
        saladRecipe(consumer, ModItems.SWEET_SALAD.get(), Items.SWEET_BERRIES, Items.HONEY_BOTTLE, Items.SWEET_BERRIES);
        saladRecipe(consumer, ModItems.AMARANTH_SALAD.get(), ModItems.AMARANTH.get(), Items.DRIED_KELP, ModItems.AMARANTH.get());

        cakeRecipe(consumer, ModBlocks.CHOCOLATE_CAKE.get(), Items.COCOA_BEANS);
        cakeRecipe(consumer, ModBlocks.HONEY_CAKE.get(), Items.HONEY_BOTTLE);

        hoeRecipe(consumer, ModItems.CRYSTAL_HOE.get(), ModItems.CRYSTAL.get());
        shovelRecipe(consumer, ModItems.CRYSTAL_SHOVEL.get(), ModItems.CRYSTAL.get());
        axeRecipe(consumer, ModItems.CRYSTAL_AXE.get(), ModItems.CRYSTAL.get());
        pickaxeRecipe(consumer, ModItems.CRYSTAL_PICKAXE.get(), ModItems.CRYSTAL.get());
        swordRecipe(consumer, ModItems.CRYSTAL_SWORD.get(), ModItems.CRYSTAL.get());

        surroundRecipe(consumer, ModItems.FUSED_AMARANTH_SWORD.get(), ModItems.AMARANTH_ESSENCE.get(), Items.GOLDEN_SWORD);
        surroundRecipe(consumer, ModItems.FUSED_AMARANTH_SHOVEL.get(), ModItems.AMARANTH_ESSENCE.get(), Items.GOLDEN_SHOVEL);
        surroundRecipe(consumer, ModItems.FUSED_AMARANTH_PICKAXE.get(), ModItems.AMARANTH_ESSENCE.get(), Items.GOLDEN_PICKAXE);
        surroundRecipe(consumer, ModItems.FUSED_AMARANTH_AXE.get(), ModItems.AMARANTH_ESSENCE.get(), Items.GOLDEN_AXE);
        surroundRecipe(consumer, ModItems.FUSED_AMARANTH_HOE.get(), ModItems.AMARANTH_ESSENCE.get(), Items.GOLDEN_HOE);

        surroundRecipe(consumer, ModItems.FUSED_AMARANTH_HELMET.get(), ModItems.AMARANTH_ESSENCE.get(), Items.GOLDEN_HELMET);
        surroundRecipe(consumer, ModItems.FUSED_AMARANTH_CHESTPLATE.get(), ModItems.AMARANTH_ESSENCE.get(), Items.GOLDEN_CHESTPLATE);
        surroundRecipe(consumer, ModItems.FUSED_AMARANTH_LEGGINGS.get(), ModItems.AMARANTH_ESSENCE.get(), Items.GOLDEN_LEGGINGS);
        surroundRecipe(consumer, ModItems.FUSED_AMARANTH_BOOTS.get(), ModItems.AMARANTH_ESSENCE.get(), Items.GOLDEN_BOOTS);

        surroundRecipe(consumer, ModItems.FUSED_SOUL_HELMET.get(), ModItems.SOUL_ESSENCE.get(), Items.GOLDEN_HELMET);
        surroundRecipe(consumer, ModItems.FUSED_SOUL_CHESTPLATE.get(), ModItems.SOUL_ESSENCE.get(), Items.GOLDEN_CHESTPLATE);
        surroundRecipe(consumer, ModItems.FUSED_SOUL_LEGGINGS.get(), ModItems.SOUL_ESSENCE.get(), Items.GOLDEN_LEGGINGS);
        surroundRecipe(consumer, ModItems.FUSED_SOUL_BOOTS.get(), ModItems.SOUL_ESSENCE.get(), Items.GOLDEN_BOOTS);

        ShapelessRecipeBuilder.shapeless(RecipeCategory.FOOD, ModItems.AMARANTH_COOKIE.get(), 8).requires(ModItems.AMARANTH_COOKIE.get()).requires(ModItems.AMARANTH_COOKIE.get()).requires(Items.COCOA_BEANS).unlockedBy(getHasName(ModItems.AMARANTH_COOKIE.get()), has(ModItems.AMARANTH_COOKIE.get())).save(consumer);
        ShapedRecipeBuilder.shaped(RecipeCategory.COMBAT, ModItems.AMARANTH_BREAD.get()).define('X', ModItems.AMARANTH.get()).pattern("XXX").unlockedBy(getHasName(ModItems.AMARANTH.get()), has(ModItems.AMARANTH.get())).save(consumer);
    }

    protected static void hoeRecipe(Consumer<FinishedRecipe> consumer, Item result, Item item){
        ShapedRecipeBuilder.shaped(RecipeCategory.COMBAT, result).define('X', item).define('W', Items.STICK)
                .pattern("XX").pattern("W ").pattern("W ")
                .unlockedBy(getHasName(item), has(item)).save(consumer);
    }

    protected static void axeRecipe(Consumer<FinishedRecipe> consumer, Item result, Item item){
        ShapedRecipeBuilder.shaped(RecipeCategory.COMBAT, result).define('X', item).define('W', Items.STICK)
                .pattern("XX").pattern("WX").pattern("W ")
                .unlockedBy(getHasName(item), has(item)).save(consumer);
    }

    protected static void pickaxeRecipe(Consumer<FinishedRecipe> consumer, Item result, Item item){
        ShapedRecipeBuilder.shaped(RecipeCategory.COMBAT, result).define('X', item).define('W', Items.STICK)
                .pattern("XXX").pattern(" W ").pattern(" W ")
                .unlockedBy(getHasName(item), has(item)).save(consumer);
    }

    protected static void shovelRecipe(Consumer<FinishedRecipe> consumer, Item result, Item item){
        ShapedRecipeBuilder.shaped(RecipeCategory.COMBAT, result).define('X', item).define('W', Items.STICK)
                .pattern("X").pattern("W").pattern("W")
                .unlockedBy(getHasName(item), has(item)).save(consumer);
    }

    protected static void swordRecipe(Consumer<FinishedRecipe> consumer, Item result, Item item){
        ShapedRecipeBuilder.shaped(RecipeCategory.COMBAT, result).define('X', item).define('W', Items.STICK)
                .pattern("X").pattern("X").pattern("W")
                .unlockedBy(getHasName(item), has(item)).save(consumer);
    }

    protected static void helmetRecipe(Consumer<FinishedRecipe> consumer, Item result, Item item){
        ShapedRecipeBuilder.shaped(RecipeCategory.COMBAT, result).define('X', item)
                .pattern("XXX").pattern("X X")
                .unlockedBy(getHasName(item), has(item)).save(consumer);
    }

    protected static void leggingsRecipe(Consumer<FinishedRecipe> consumer, Item result, Item item){
        ShapedRecipeBuilder.shaped(RecipeCategory.COMBAT, result).define('X', item)
                .pattern("XXX").pattern("X X").pattern("X X")
                .unlockedBy(getHasName(item), has(item)).save(consumer);
    }

    protected static void chestplateRecipe(Consumer<FinishedRecipe> consumer, Item result, Item item){
        ShapedRecipeBuilder.shaped(RecipeCategory.COMBAT, result).define('X', item)
                .pattern("X X").pattern("XXX").pattern("XXX")
                .unlockedBy(getHasName(item), has(item)).save(consumer);
    }

    protected static void bootsRecipe(Consumer<FinishedRecipe> consumer, Item result, Item item){
        ShapedRecipeBuilder.shaped(RecipeCategory.COMBAT, result).define('X', item)
                .pattern("X X").pattern("X X")
                .unlockedBy(getHasName(item), has(item)).save(consumer);
    }

    protected static void cakeRecipe(Consumer<FinishedRecipe> consumer, Block result, Item item){
        ShapedRecipeBuilder.shaped(RecipeCategory.FOOD, result).define('X', item).define('Y', Items.SUGAR).define('Z', Items.EGG).define('W', Items.WHEAT)
                .pattern("XXX").pattern("YZY").pattern("WWW")
                .unlockedBy(getHasName(item), has(item)).save(consumer);
    }

    protected static void surroundRecipe(Consumer<FinishedRecipe> consumer, Item result, Item item, Item item1){
        ShapedRecipeBuilder.shaped(RecipeCategory.COMBAT, result).define('X', item).define('Y', item1)
                .pattern("XXX").pattern("XYX").pattern("XXX")
                .unlockedBy(getHasName(item), has(item)).save(consumer);
    }

    protected static void flowerRecipe(Consumer<FinishedRecipe> consumer, Item result, Block item){
        ShapelessRecipeBuilder.shapeless(RecipeCategory.MISC, result, 1).requires(item).unlockedBy(getHasName(item), has(item)).save(consumer);
    }

    protected static void saladRecipe(Consumer<FinishedRecipe> consumer, Item result, Item item, Item item1, Item item2){
        ShapelessRecipeBuilder.shapeless(RecipeCategory.FOOD, result, 1).requires(item).requires(item1).requires(item2).requires(ModItems.CABBAGE.get()).requires(Items.BOWL).unlockedBy(getHasName(ModItems.CABBAGE.get()), has(ModItems.CABBAGE.get())).save(consumer);
    }

    protected static void stewRecipe(Consumer<FinishedRecipe> consumer, Item result, Item item){
        ShapelessRecipeBuilder.shapeless(RecipeCategory.FOOD, result, 1).requires(item).requires(item).requires(item).requires(Items.BOWL).unlockedBy(getHasName(item), has(item)).save(consumer);
    }

    protected static void pieRecipe(Consumer<FinishedRecipe> consumer, Item result, Item item){
        ShapelessRecipeBuilder.shapeless(RecipeCategory.FOOD, result, 1).requires(item).requires(Items.SUGAR).requires(Items.EGG).unlockedBy(getHasName(Items.EGG), has(Items.EGG)).save(consumer);
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

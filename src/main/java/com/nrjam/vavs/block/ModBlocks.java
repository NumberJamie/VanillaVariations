package com.nrjam.vavs.block;

import com.nrjam.vavs.VanillaVariations;
import com.nrjam.vavs.block.custom.CakeBlockCustom;
import com.nrjam.vavs.block.custom.Copper.CopperDoor;
import com.nrjam.vavs.block.custom.Copper.CopperTrapdoor;
import com.nrjam.vavs.block.custom.CropsAndFlowers.*;
import com.nrjam.vavs.block.custom.EndFarmLand;
import com.nrjam.vavs.block.custom.FlammableRotatableBlock;
import com.nrjam.vavs.block.custom.NetherFarmLand;
import com.nrjam.vavs.block.custom.block.CrystallizerBlock;
import com.nrjam.vavs.item.Items;
import com.nrjam.vavs.world.gen.tree.WalnutTreeGrow;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.block.*;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.material.Material;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

import java.util.function.Supplier;

public class ModBlocks {

    public static final DeferredRegister<Block> BLOCKS = DeferredRegister.create(ForgeRegistries.BLOCKS, VanillaVariations.MOD_ID);

    public static final RegistryObject<Block> CRYSTALLIZER = registerBlockDecoration("crystallizer", () -> new CrystallizerBlock(BlockBehaviour.Properties.copy(Blocks.OAK_PLANKS).noOcclusion()));

    public static final RegistryObject<Block> NETHER_FARMLAND = registerBlockDecoration("nether_farmland", () -> new NetherFarmLand(BlockBehaviour.Properties.of(Material.DIRT).sound(SoundType.SOUL_SOIL).randomTicks().strength(1.6f, 1.6f)));
    public static final RegistryObject<Block> END_FARMLAND = registerBlockDecoration("end_farmland", () -> new EndFarmLand(BlockBehaviour.Properties.of(Material.DIRT).sound(SoundType.SOUL_SOIL).randomTicks().lightLevel((p_50886_) -> 8).strength(1.6f, 1.6f)));

    public static final RegistryObject<Block> SALT_ORE = registerBlock( "salt_ore", () -> new Block(BlockBehaviour.Properties.of(Material.STONE).strength(3f, 3f).requiresCorrectToolForDrops()));
    public static final RegistryObject<Block> DEEPSLATE_SALT_ORE = registerBlock( "deepslate_salt_ore", () -> new Block(BlockBehaviour.Properties.of(Material.STONE).strength(4.5F, 3.0F).requiresCorrectToolForDrops()));
    public static final RegistryObject<Block> SALT_BLOCK = registerBlock("salt_block", () -> new Block(BlockBehaviour.Properties.of(Material.STONE).sound(SoundType.BAMBOO).strength(4.5f, 3.5f).requiresCorrectToolForDrops()));
    public static final RegistryObject<Block> RAW_SALT_BLOCK = registerBlock("raw_salt_block", () -> new Block(BlockBehaviour.Properties.of(Material.STONE).sound(SoundType.BAMBOO).strength(4.5f, 3.5f)));
    public static final RegistryObject<Block> CRYSTALLIZED_COAL_BLOCK = BLOCKS.register("crystallized_coal_block", () -> new Block(BlockBehaviour.Properties.of(Material.STONE).sound(SoundType.STONE).strength(3f, 3f)));
    public static final RegistryObject<Block> CRYSTALLIZED_HONEY_BLOCK = registerBlock("crystallized_honey_block", () -> new Block(BlockBehaviour.Properties.of(Material.STONE).sound(SoundType.CORAL_BLOCK).strength(2f, 2f)));
    public static final RegistryObject<Block> CRYSTALLIZED_HONEY_LAMP = registerBlock("crystallized_honey_lamp", () -> new Block(BlockBehaviour.Properties.of(Material.STONE).sound(SoundType.CORAL_BLOCK).strength(2f, 2f).lightLevel((p_152607_) -> 14).noOcclusion()));

    public static final RegistryObject<Block> COMPRESSED_REINFORCED_LEATHER = registerBlock("compressed_reinforced_leather", () -> new Block(BlockBehaviour.Properties.of(Material.WOOL).strength(1.6f, 1.6f)));
    public static final RegistryObject<Block> NETHER_CRYSTAL_BLOCK = registerBlock("nether_crystal_block", () -> new Block(BlockBehaviour.Properties.of(Material.METAL).sound(SoundType.AMETHYST).strength(4.5f, 7.5f).requiresCorrectToolForDrops()));

    public static final RegistryObject<Block> NETHER_CRYSTAL_ORE = registerBlock( "nether_crystal_ore", () -> new Block(BlockBehaviour.Properties.of(Material.STONE).strength(3f, 6f).requiresCorrectToolForDrops()));

    public static final RegistryObject<Block> SOUL_LIGHT = registerBlock("soul_light", () -> new Block(BlockBehaviour.Properties.of(Material.GLASS).lightLevel((p_50886_) -> 14).sound(SoundType.GLASS).strength(1.6f, 1.6f)));
/*
    public static final RegistryObject<Block> CRYSTALLIZED_GLASS_PANE = registerBlock("crystallized_glass_pane", () -> new IronBarsBlock(BlockBehaviour.Properties.of(Material.GLASS).strength(0.3F).sound(SoundType.GLASS).noOcclusion()));
    public static final RegistryObject<Block> WHITE_CRYSTALLIZED_GLASS_PANE = registerBlock("white_crystallized_glass_pane", () -> new IronBarsBlock(BlockBehaviour.Properties.of(Material.GLASS).strength(0.3F).sound(SoundType.GLASS).noOcclusion()));
    public static final RegistryObject<Block> ORANGE_CRYSTALLIZED_GLASS_PANE = registerBlock("orange_crystallized_glass_pane", () -> new IronBarsBlock(BlockBehaviour.Properties.of(Material.GLASS).strength(0.3F).sound(SoundType.GLASS).noOcclusion()));
    public static final RegistryObject<Block> MAGENTA_CRYSTALLIZED_GLASS_PANE = registerBlock("magenta_crystallized_glass_pane", () -> new IronBarsBlock(BlockBehaviour.Properties.of(Material.GLASS).strength(0.3F).sound(SoundType.GLASS).noOcclusion()));
    public static final RegistryObject<Block> LIGHT_BLUE_CRYSTALLIZED_GLASS_PANE = registerBlock("light_blue_crystallized_glass_pane", () -> new IronBarsBlock(BlockBehaviour.Properties.of(Material.GLASS).strength(0.3F).sound(SoundType.GLASS).noOcclusion()));
    public static final RegistryObject<Block> YELLOW_CRYSTALLIZED_GLASS_PANE = registerBlock("yellow_crystallized_glass_pane", () -> new IronBarsBlock(BlockBehaviour.Properties.of(Material.GLASS).strength(0.3F).sound(SoundType.GLASS).noOcclusion()));
    public static final RegistryObject<Block> LIME_CRYSTALLIZED_GLASS_PANE = registerBlock("lime_crystallized_glass_pane", () -> new IronBarsBlock(BlockBehaviour.Properties.of(Material.GLASS).strength(0.3F).sound(SoundType.GLASS).noOcclusion()));
    public static final RegistryObject<Block> PINK_CRYSTALLIZED_GLASS_PANE = registerBlock("pink_crystallized_glass_pane", () -> new IronBarsBlock(BlockBehaviour.Properties.of(Material.GLASS).strength(0.3F).sound(SoundType.GLASS).noOcclusion()));
    public static final RegistryObject<Block> GRAY_CRYSTALLIZED_GLASS_PANE = registerBlock("gray_crystallized_glass_pane", () -> new IronBarsBlock(BlockBehaviour.Properties.of(Material.GLASS).strength(0.3F).sound(SoundType.GLASS).noOcclusion()));
    public static final RegistryObject<Block> LIGHT_GRAY_CRYSTALLIZED_GLASS_PANE = registerBlock("light_gray_crystallized_glass_pane", () -> new IronBarsBlock(BlockBehaviour.Properties.of(Material.GLASS).strength(0.3F).sound(SoundType.GLASS).noOcclusion()));
    public static final RegistryObject<Block> CYAN_CRYSTALLIZED_GLASS_PANE = registerBlock("cyan_crystallized_glass_pane", () -> new IronBarsBlock(BlockBehaviour.Properties.of(Material.GLASS).strength(0.3F).sound(SoundType.GLASS).noOcclusion()));
    public static final RegistryObject<Block> PURPLE_CRYSTALLIZED_GLASS_PANE = registerBlock("purple_crystallized_glass_pane", () -> new IronBarsBlock(BlockBehaviour.Properties.of(Material.GLASS).strength(0.3F).sound(SoundType.GLASS).noOcclusion()));
    public static final RegistryObject<Block> BLUE_CRYSTALLIZED_GLASS_PANE = registerBlock("blue_crystallized_glass_pane", () -> new IronBarsBlock(BlockBehaviour.Properties.of(Material.GLASS).strength(0.3F).sound(SoundType.GLASS).noOcclusion()));
    public static final RegistryObject<Block> BROWN_CRYSTALLIZED_GLASS_PANE = registerBlock("brown_crystallized_glass_pane", () -> new IronBarsBlock(BlockBehaviour.Properties.of(Material.GLASS).strength(0.3F).sound(SoundType.GLASS).noOcclusion()));
    public static final RegistryObject<Block> GREEN_CRYSTALLIZED_GLASS_PANE = registerBlock("green_crystallized_glass_pane", () -> new IronBarsBlock(BlockBehaviour.Properties.of(Material.GLASS).strength(0.3F).sound(SoundType.GLASS).noOcclusion()));
    public static final RegistryObject<Block> RED_CRYSTALLIZED_GLASS_PANE = registerBlock("red_crystallized_glass_pane", () -> new IronBarsBlock(BlockBehaviour.Properties.of(Material.GLASS).strength(0.3F).sound(SoundType.GLASS).noOcclusion()));
    public static final RegistryObject<Block> BLACK_CRYSTALLIZED_GLASS_PANE = registerBlock("black_crystallized_glass_pane", () -> new IronBarsBlock(BlockBehaviour.Properties.of(Material.GLASS).strength(0.3F).sound(SoundType.GLASS).noOcclusion()));
*/
    public static final RegistryObject<Block> CRYSTALLIZED_GLASS = registerBlock("crystallized_glass", () -> new Block(BlockBehaviour.Properties.of(Material.GLASS).strength(0.3F).sound(SoundType.GLASS).noOcclusion().isViewBlocking(Blocks::False)));
    public static final RegistryObject<Block> WHITE_CRYSTALLIZED_GLASS = registerBlock("white_crystallized_glass", () -> new Block(BlockBehaviour.Properties.of(Material.GLASS).strength(0.3F).sound(SoundType.GLASS).noOcclusion()));
    public static final RegistryObject<Block> ORANGE_CRYSTALLIZED_GLASS = registerBlock("orange_crystallized_glass", () -> new Block(BlockBehaviour.Properties.of(Material.GLASS).strength(0.3F).sound(SoundType.GLASS).noOcclusion()));
    public static final RegistryObject<Block> MAGENTA_CRYSTALLIZED_GLASS = registerBlock("magenta_crystallized_glass", () -> new Block(BlockBehaviour.Properties.of(Material.GLASS).strength(0.3F).sound(SoundType.GLASS).noOcclusion()));
    public static final RegistryObject<Block> LIGHT_BLUE_CRYSTALLIZED_GLASS = registerBlock("light_blue_crystallized_glass", () -> new Block(BlockBehaviour.Properties.of(Material.GLASS).strength(0.3F).sound(SoundType.GLASS).noOcclusion()));
    public static final RegistryObject<Block> YELLOW_CRYSTALLIZED_GLASS = registerBlock("yellow_crystallized_glass", () -> new Block(BlockBehaviour.Properties.of(Material.GLASS).strength(0.3F).sound(SoundType.GLASS).noOcclusion()));
    public static final RegistryObject<Block> LIME_CRYSTALLIZED_GLASS = registerBlock("lime_crystallized_glass", () -> new Block(BlockBehaviour.Properties.of(Material.GLASS).strength(0.3F).sound(SoundType.GLASS).noOcclusion()));
    public static final RegistryObject<Block> PINK_CRYSTALLIZED_GLASS = registerBlock("pink_crystallized_glass", () -> new Block(BlockBehaviour.Properties.of(Material.GLASS).strength(0.3F).sound(SoundType.GLASS).noOcclusion()));
    public static final RegistryObject<Block> GRAY_CRYSTALLIZED_GLASS = registerBlock("gray_crystallized_glass", () -> new Block(BlockBehaviour.Properties.of(Material.GLASS).strength(0.3F).sound(SoundType.GLASS).noOcclusion()));
    public static final RegistryObject<Block> LIGHT_GRAY_CRYSTALLIZED_GLASS = registerBlock("light_gray_crystallized_glass", () -> new Block(BlockBehaviour.Properties.of(Material.GLASS).strength(0.3F).sound(SoundType.GLASS).noOcclusion()));
    public static final RegistryObject<Block> CYAN_CRYSTALLIZED_GLASS = registerBlock("cyan_crystallized_glass", () -> new Block(BlockBehaviour.Properties.of(Material.GLASS).strength(0.3F).sound(SoundType.GLASS).noOcclusion()));
    public static final RegistryObject<Block> PURPLE_CRYSTALLIZED_GLASS = registerBlock("purple_crystallized_glass", () -> new Block(BlockBehaviour.Properties.of(Material.GLASS).strength(0.3F).sound(SoundType.GLASS).noOcclusion()));
    public static final RegistryObject<Block> BLUE_CRYSTALLIZED_GLASS = registerBlock("blue_crystallized_glass", () -> new Block(BlockBehaviour.Properties.of(Material.GLASS).strength(0.3F).sound(SoundType.GLASS).noOcclusion()));
    public static final RegistryObject<Block> BROWN_CRYSTALLIZED_GLASS = registerBlock("brown_crystallized_glass", () -> new Block(BlockBehaviour.Properties.of(Material.GLASS).strength(0.3F).sound(SoundType.GLASS).noOcclusion()));
    public static final RegistryObject<Block> GREEN_CRYSTALLIZED_GLASS = registerBlock("green_crystallized_glass", () -> new Block(BlockBehaviour.Properties.of(Material.GLASS).strength(0.3F).sound(SoundType.GLASS).noOcclusion()));
    public static final RegistryObject<Block> RED_CRYSTALLIZED_GLASS = registerBlock("red_crystallized_glass", () -> new Block(BlockBehaviour.Properties.of(Material.GLASS).strength(0.3F).sound(SoundType.GLASS).noOcclusion()));
    public static final RegistryObject<Block> BLACK_CRYSTALLIZED_GLASS = registerBlock("black_crystallized_glass", () -> new Block(BlockBehaviour.Properties.of(Material.GLASS).strength(0.3F).sound(SoundType.GLASS).noOcclusion()));


    public static final RegistryObject<Block> SOUL_STONE = registerBlock("soul_stone", () -> new Block(BlockBehaviour.Properties.of(Material.STONE).strength(1.25f, 4.2f)));
    public static final RegistryObject<Block> SOUL_STONE_STAIRS = registerBlock("soul_stone_stairs", () -> new StairBlock(() -> SOUL_STONE.get().defaultBlockState(), BlockBehaviour.Properties.of(Material.STONE).strength(1.25f, 4.2f)));
    public static final RegistryObject<Block> SOUL_STONE_SLAB = registerBlock("soul_stone_slab", () -> new SlabBlock(BlockBehaviour.Properties.of(Material.STONE).strength(1.25f, 4.2f)));
    public static final RegistryObject<Block> SOUL_STONE_WALL = registerBlock("soul_stone_wall", () -> new WallBlock(BlockBehaviour.Properties.of(Material.STONE).strength(1.25f, 4.2f)));

    public static final RegistryObject<Block> END_SOIL = registerBlock("end_soil", () -> new Block(BlockBehaviour.Properties.of(Material.DIRT).sound(SoundType.SOUL_SOIL).strength(1.6f, 1.6f)));
    public static final RegistryObject<Block> SPROUTED_LIGHT = registerBlock("sprouted_light", () -> new Block(BlockBehaviour.Properties.of(Material.GLASS).lightLevel((p_50886_) -> 14).sound(SoundType.GLASS).strength(1.6f, 1.6f)));

    public static final RegistryObject<Block> CHOCOLATE_CAKE = BLOCKS.register("chocolate_cake", () -> new CakeBlockCustom(BlockBehaviour.Properties.of(Material.CAKE).sound(SoundType.WOOL)));
    public static final RegistryObject<Block> HONEY_CAKE = BLOCKS.register("honey_cake", () -> new CakeBlockCustom(BlockBehaviour.Properties.of(Material.CAKE).sound(SoundType.WOOL)));

    public static final RegistryObject<Block> CABBAGES = BLOCKS.register("cabbages", () -> new Cabbage(BlockBehaviour.Properties.of(Material.PLANT).noCollission().randomTicks().instabreak().sound(SoundType.CROP)));
    public static final RegistryObject<Block> SOUL_SPROUTS = BLOCKS.register("soul_sprouts", () -> new SoulSprouts(BlockBehaviour.Properties.of(Material.PLANT).noCollission().randomTicks().instabreak().lightLevel((p_50886_) -> 7).sound(SoundType.CROP)));
    public static final RegistryObject<Block> ENDER_SPROUTS = BLOCKS.register("ender_sprouts", () -> new EnderSprout(BlockBehaviour.Properties.of(Material.PLANT).noCollission().randomTicks().instabreak().lightLevel((p_50886_) -> 12).sound(SoundType.CROP)));
    public static final RegistryObject<Block> ASH_ROOT = BLOCKS.register("ash_root", () -> new AshRoot(BlockBehaviour.Properties.of(Material.PLANT).noCollission().randomTicks().instabreak().sound(SoundType.CROP)));
    public static final RegistryObject<Block> WARPED_SOUL_BERRY = BLOCKS.register("warped_soul_berry", () -> new WarpedSoulBerries(BlockBehaviour.Properties.of(Material.PLANT).noCollission().randomTicks().instabreak().lightLevel((p_50886_) -> 5).sound(SoundType.CROP)));
    public static final RegistryObject<Block> CRIMSON_FIRE_BERRY = BLOCKS.register("crimson_fire_berry", () -> new CrimsonFireBerries(BlockBehaviour.Properties.of(Material.PLANT).noCollission().randomTicks().instabreak().lightLevel((p_50886_) -> 5).sound(SoundType.CROP)));
    public static final RegistryObject<Block> VIOLA = registerBlockDecoration("viola", () -> new FlowerBlock(MobEffects.POISON, 5*20, BlockBehaviour.Properties.of(Material.PLANT).noCollission().instabreak().sound(SoundType.GRASS)));
    public static final RegistryObject<Block> WILD_CABBAGES = BLOCKS.register("wild_cabbages", () -> new FlowerBlock(MobEffects.CONFUSION, 5*20, BlockBehaviour.Properties.of(Material.PLANT).noCollission().instabreak().sound(SoundType.GRASS)));
    public static final RegistryObject<Block> LAVENDER = registerBlockDecoration("lavender", () -> new FlowerBlock(MobEffects.CONFUSION, 5*20, BlockBehaviour.Properties.of(Material.PLANT).noCollission().instabreak().sound(SoundType.GRASS)));
    public static final RegistryObject<Block> MARIGOLD = registerBlockDecoration("marigold", () -> new FlowerBlock(MobEffects.FIRE_RESISTANCE, 3*20, BlockBehaviour.Properties.of(Material.PLANT).noCollission().instabreak().sound(SoundType.GRASS)));
    public static final RegistryObject<Block> SNAPDRAGON = registerBlockDecoration("snapdragon", () -> new FlowerBlock(MobEffects.CONFUSION, 5*20, BlockBehaviour.Properties.of(Material.PLANT).noCollission().instabreak().sound(SoundType.GRASS)));
    public static final RegistryObject<Block> SOUL_FLOWER = registerBlockDecoration("soul_flower", () -> new SoulSoilFlower(MobEffects.MOVEMENT_SPEED, 3*20, BlockBehaviour.Properties.of(Material.PLANT).noCollission().instabreak().lightLevel((p_50886_) -> 7).sound(SoundType.GRASS)));
    public static final RegistryObject<Block> DEAD_ROOTS = registerBlockDecoration("dead_roots", () -> new NetherRackFlower(MobEffects.FIRE_RESISTANCE, 4*20, BlockBehaviour.Properties.of(Material.PLANT).noCollission().instabreak().sound(SoundType.GRASS)));

    public static final RegistryObject<Block> POTTED_VIOLA = BLOCKS.register("potted_viola", () -> new PottedFlower(ModBlocks.VIOLA.get(), BlockBehaviour.Properties.of(Material.DECORATION).instabreak().noOcclusion()));
    public static final RegistryObject<Block> POTTED_WILD_CABBAGES = BLOCKS.register("potted_wild_cabbages", () -> new PottedFlower(ModBlocks.WILD_CABBAGES.get(), BlockBehaviour.Properties.of(Material.DECORATION).instabreak().noOcclusion()));
    public static final RegistryObject<Block> POTTED_LAVENDER = BLOCKS.register("potted_lavender", () -> new PottedFlower(ModBlocks.LAVENDER.get(), BlockBehaviour.Properties.of(Material.DECORATION).instabreak().noOcclusion()));
    public static final RegistryObject<Block> POTTED_MARIGOLD = BLOCKS.register("potted_marigold", () -> new PottedFlower(ModBlocks.MARIGOLD.get(), BlockBehaviour.Properties.of(Material.DECORATION).instabreak().noOcclusion()));
    public static final RegistryObject<Block> POTTED_SNAPDRAGON = BLOCKS.register("potted_snapdragon", () -> new PottedFlower(ModBlocks.SNAPDRAGON.get(), BlockBehaviour.Properties.of(Material.DECORATION).instabreak().noOcclusion()));
    public static final RegistryObject<Block> POTTED_SOUL_FLOWER = BLOCKS.register("potted_soul_flower", () -> new PottedFlower(ModBlocks.SOUL_FLOWER.get(), BlockBehaviour.Properties.of(Material.DECORATION).instabreak().lightLevel((p_50886_) -> 5).noCollission()));
    public static final RegistryObject<Block> POTTED_DEAD_ROOTS = BLOCKS.register("potted_dead_roots", () -> new PottedFlower(ModBlocks.DEAD_ROOTS.get(), BlockBehaviour.Properties.of(Material.DECORATION).instabreak().noOcclusion()));

    public static final RegistryObject<Block> WALNUT_LOG = registerBlock("walnut_log", () -> new FlammableRotatableBlock(BlockBehaviour.Properties.copy(Blocks.OAK_LOG)));
    public static final RegistryObject<Block> WALNUT_WOOD = registerBlock("walnut_wood", () -> new FlammableRotatableBlock(BlockBehaviour.Properties.copy(Blocks.OAK_WOOD)));
    public static final RegistryObject<Block> STRIPPED_WALNUT_LOG = registerBlock("stripped_walnut_log", () -> new FlammableRotatableBlock(BlockBehaviour.Properties.copy(Blocks.STRIPPED_OAK_LOG)));
    public static final RegistryObject<Block> STRIPPED_WALNUT_WOOD = registerBlock("stripped_walnut_wood", () -> new FlammableRotatableBlock(BlockBehaviour.Properties.copy(Blocks.STRIPPED_OAK_WOOD)));
    public static final RegistryObject<Block> WALNUT_PLANKS = registerBlock("walnut_planks", () -> new Block(BlockBehaviour.Properties.copy(Blocks.OAK_PLANKS)){
        @Override
        public boolean isFlammable(BlockState state, BlockGetter world, BlockPos pos, Direction face){
            return true;
        }

        @Override
        public int getFlammability(BlockState state, BlockGetter world, BlockPos pos, Direction face){
            return 20;
        }

        @Override
        public int getFireSpreadSpeed(BlockState state, BlockGetter world, BlockPos pos, Direction face){
            return 5;
        }
    });
    public static final RegistryObject<Block> WALNUT_LEAVES = registerBlockDecoration("walnut_leaves", () -> new LeavesBlock(BlockBehaviour.Properties.copy(Blocks.OAK_LEAVES)){
        @Override
        public boolean isFlammable(BlockState state, BlockGetter world, BlockPos pos, Direction face){
            return true;
        }

        @Override
        public int getFlammability(BlockState state, BlockGetter world, BlockPos pos, Direction face){
            return 60;
        }

        @Override
        public int getFireSpreadSpeed(BlockState state, BlockGetter world, BlockPos pos, Direction face){
            return 30;
        }
    });
    public static final RegistryObject<Block> WALNUT_SAPLING = registerBlockDecoration("walnut_sapling", () -> new SaplingBlock(new WalnutTreeGrow(),BlockBehaviour.Properties.copy(Blocks.OAK_SAPLING).strength(0.3f).noOcclusion()));
    public static final RegistryObject<Block> POTTED_WALNUT_SAPLING = BLOCKS.register("potted_walnut_sapling", () -> new PottedFlower(ModBlocks.WALNUT_SAPLING.get(), BlockBehaviour.Properties.of(Material.DECORATION).instabreak().noOcclusion()));

    public static final RegistryObject<Block> WALNUT_STAIRS = registerBlock("walnut_stairs", () -> new StairBlock(() -> WALNUT_PLANKS.get().defaultBlockState(), BlockBehaviour.Properties.of(Material.WOOD).strength(2.0F, 3.0F)));
    public static final RegistryObject<Block> WALNUT_SLAB = registerBlock("walnut_slab", () -> new SlabBlock(BlockBehaviour.Properties.of(Material.WOOD).strength(2.0F, 3.0F)));
    public static final RegistryObject<Block> WALNUT_FENCE = registerBlockDecoration("walnut_fence", () -> new FenceBlock(BlockBehaviour.Properties.of(Material.WOOD).strength(2.0F, 3.0F)));
    public static final RegistryObject<Block> WALNUT_FENCE_GATE = registerBlockRedStone("walnut_fence_gate", () -> new FenceGateBlock(BlockBehaviour.Properties.of(Material.WOOD).strength(2.0F, 3.0F)));

    public static final RegistryObject<Block> WALNUT_BUTTON = registerBlockRedStone("walnut_button", () -> new WoodButtonBlock(BlockBehaviour.Properties.of(Material.WOOD).strength(2.0F, 3.0F)));
    public static final RegistryObject<Block> WALNUT_PRESSURE_PLATE = registerBlockRedStone("walnut_pressure_plate", () -> new PressurePlateBlock(PressurePlateBlock.Sensitivity.EVERYTHING ,BlockBehaviour.Properties.of(Material.WOOD).strength(2.0F, 3.0F)));
    public static final RegistryObject<Block> WALNUT_DOOR = registerBlockRedStone("walnut_door", () -> new DoorBlock(BlockBehaviour.Properties.of(Material.WOOD).strength(2.0F, 3.0F).noOcclusion()));
    public static final RegistryObject<Block> WALNUT_DOOR_HEART = registerBlockRedStone("walnut_door_heart", () -> new DoorBlock(BlockBehaviour.Properties.of(Material.WOOD).strength(2.0F, 3.0F).noOcclusion()));
    public static final RegistryObject<Block> WALNUT_TRAPDOOR = registerBlockRedStone("walnut_trapdoor", () -> new TrapDoorBlock(BlockBehaviour.Properties.of(Material.WOOD).strength(2.0F, 3.0F).noOcclusion()));
    public static final RegistryObject<Block> WALNUT_TRAPDOOR_ROUND = registerBlockRedStone("walnut_trapdoor_round", () -> new TrapDoorBlock(BlockBehaviour.Properties.of(Material.WOOD).strength(2.0F, 3.0F).noOcclusion()));
    public static final RegistryObject<Block> WALNUT_TRAPDOOR_HEART = registerBlockRedStone("walnut_trapdoor_heart", () -> new TrapDoorBlock(BlockBehaviour.Properties.of(Material.WOOD).strength(2.0F, 3.0F).noOcclusion()));

    public static final RegistryObject<Block> COPPER_TRAPDOOR = registerBlockRedStone("copper_trapdoor", () -> new CopperTrapdoor(WeatheringCopper.WeatherState.UNAFFECTED, BlockBehaviour.Properties.of(Material.WOOD).strength(4.5f, 7.5f).sound(SoundType.COPPER)));
    public static final RegistryObject<Block> EXPOSED_COPPER_TRAPDOOR = registerBlockRedStone("exposed_copper_trapdoor", () -> new CopperTrapdoor(WeatheringCopper.WeatherState.EXPOSED, BlockBehaviour.Properties.of(Material.WOOD).strength(4.5f, 7.5f).sound(SoundType.COPPER)));
    public static final RegistryObject<Block> WEATHERED_COPPER_TRAPDOOR = registerBlockRedStone("weathered_copper_trapdoor", () -> new CopperTrapdoor(WeatheringCopper.WeatherState.WEATHERED, BlockBehaviour.Properties.of(Material.WOOD).strength(4.5f, 7.5f).sound(SoundType.COPPER)));
    public static final RegistryObject<Block> OXIDIZED_COPPER_TRAPDOOR = registerBlockRedStone("oxidized_copper_trapdoor", () -> new CopperTrapdoor(WeatheringCopper.WeatherState.OXIDIZED, BlockBehaviour.Properties.of(Material.WOOD).strength(4.5f, 7.5f).sound(SoundType.COPPER)));

    public static final RegistryObject<Block> WAXED_COPPER_TRAPDOOR = registerBlockRedStone("waxed_copper_trapdoor", () -> new TrapDoorBlock(BlockBehaviour.Properties.of(Material.WOOD).strength(4.5f, 7.5f).sound(SoundType.COPPER)));
    public static final RegistryObject<Block> WAXED_EXPOSED_COPPER_TRAPDOOR = registerBlockRedStone("waxed_exposed_copper_trapdoor", () -> new TrapDoorBlock(BlockBehaviour.Properties.of(Material.WOOD).strength(4.5f, 7.5f).sound(SoundType.COPPER)));
    public static final RegistryObject<Block> WAXED_WEATHERED_COPPER_TRAPDOOR = registerBlockRedStone("waxed_weathered_copper_trapdoor", () -> new TrapDoorBlock(BlockBehaviour.Properties.of(Material.WOOD).strength(4.5f, 7.5f).sound(SoundType.COPPER)));
    public static final RegistryObject<Block> WAXED_OXIDIZED_COPPER_TRAPDOOR = registerBlockRedStone("waxed_oxidized_copper_trapdoor", () -> new TrapDoorBlock(BlockBehaviour.Properties.of(Material.WOOD).strength(4.5f, 7.5f).sound(SoundType.COPPER)));

    public static final RegistryObject<Block> COPPER_DOOR = registerBlockRedStone("copper_door", () -> new CopperDoor(WeatheringCopper.WeatherState.UNAFFECTED, BlockBehaviour.Properties.of(Material.WOOD).strength(4.5f, 7.5f).sound(SoundType.COPPER)));
    public static final RegistryObject<Block> EXPOSED_COPPER_DOOR = registerBlockRedStone("exposed_copper_door", () -> new CopperDoor(WeatheringCopper.WeatherState.EXPOSED, BlockBehaviour.Properties.of(Material.WOOD).strength(4.5f, 7.5f).sound(SoundType.COPPER)));
    public static final RegistryObject<Block> WEATHERED_COPPER_DOOR = registerBlockRedStone("weathered_copper_door", () -> new CopperDoor(WeatheringCopper.WeatherState.WEATHERED, BlockBehaviour.Properties.of(Material.WOOD).strength(4.5f, 7.5f).sound(SoundType.COPPER)));
    public static final RegistryObject<Block> OXIDIZED_COPPER_DOOR = registerBlockRedStone("oxidized_copper_door", () -> new CopperDoor(WeatheringCopper.WeatherState.OXIDIZED, BlockBehaviour.Properties.of(Material.WOOD).strength(4.5f, 7.5f).sound(SoundType.COPPER)));

    public static final RegistryObject<Block> WAXED_COPPER_DOOR = registerBlockRedStone("waxed_copper_door", () -> new DoorBlock(BlockBehaviour.Properties.of(Material.WOOD).strength(4.5f, 7.5f).sound(SoundType.COPPER)));
    public static final RegistryObject<Block> WAXED_EXPOSED_COPPER_DOOR = registerBlockRedStone("waxed_exposed_copper_door", () -> new DoorBlock(BlockBehaviour.Properties.of(Material.WOOD).strength(4.5f, 7.5f).sound(SoundType.COPPER)));
    public static final RegistryObject<Block> WAXED_WEATHERED_COPPER_DOOR = registerBlockRedStone("waxed_weathered_copper_door", () -> new DoorBlock(BlockBehaviour.Properties.of(Material.WOOD).strength(4.5f, 7.5f).sound(SoundType.COPPER)));
    public static final RegistryObject<Block> WAXED_OXIDIZED_COPPER_DOOR = registerBlockRedStone("waxed_oxidized_copper_door", () -> new DoorBlock(BlockBehaviour.Properties.of(Material.WOOD).strength(4.5f, 7.5f).sound(SoundType.COPPER)));

    public static final RegistryObject<Block> DRAGONS_BREATH_TORCH = BLOCKS.register("dragons_breath_torch", () -> new TorchBlock(BlockBehaviour.Properties.of(Material.DECORATION).noCollission().instabreak().lightLevel((p_50886_) -> 14).sound(SoundType.WOOD), ParticleTypes.DRAGON_BREATH));
    public static final RegistryObject<Block> DRAGONS_BREATH_WALL_TORCH = BLOCKS.register("dragons_breath_wall_torch", () -> new WallTorchBlock(BlockBehaviour.Properties.of(Material.DECORATION).noCollission().instabreak().lightLevel((p_152607_) -> 14).sound(SoundType.WOOD).dropsLike(ModBlocks.DRAGONS_BREATH_TORCH.get()), ParticleTypes.DRAGON_BREATH));
    public static final RegistryObject<Block> DRAGONS_BREATH_LANTERN = registerBlockDecoration("dragons_breath_lantern", () -> new LanternBlock(BlockBehaviour.Properties.of(Material.METAL).requiresCorrectToolForDrops().strength(2.5F).sound(SoundType.LANTERN).lightLevel((p_187433_) -> 15).noOcclusion()));

    public static final RegistryObject<Block> BLOSSOMING_ROOT = registerBlockDecoration("blossoming_root", () -> new EndSoilFlower(MobEffects.LEVITATION, 3*20, BlockBehaviour.Properties.of(Material.PLANT).noCollission().instabreak().lightLevel((p_152607_) -> 12).sound(SoundType.GRASS)));
    public static final RegistryObject<Block> ENDER_ROOT = registerBlockDecoration("ender_root", () -> new EndSoilFlower(MobEffects.LEVITATION, 3*20, BlockBehaviour.Properties.of(Material.PLANT).noCollission().instabreak().sound(SoundType.GRASS)));

    public static final RegistryObject<Block> POTTED_BLOSSOMING_ROOT = BLOCKS.register("potted_blossoming_root", () -> new PottedFlower(ModBlocks.BLOSSOMING_ROOT.get(), BlockBehaviour.Properties.of(Material.DECORATION).instabreak().lightLevel((p_50886_) -> 12).noCollission()));
    public static final RegistryObject<Block> POTTED_ENDER_ROOT = BLOCKS.register("potted_ender_root", () -> new PottedFlower(ModBlocks.ENDER_ROOT.get(), BlockBehaviour.Properties.of(Material.DECORATION).instabreak().noOcclusion()));

    private static <T extends Block>RegistryObject<T> registerBlock(String name, Supplier<T> block) {
        RegistryObject<T> toReturn = BLOCKS.register(name, block);
        registerBlockItem(name, toReturn);
        return toReturn;
    }

    private static <T extends Block>RegistryObject<T> registerBlockRedStone(String name, Supplier<T> block) {
        RegistryObject<T> toReturn = BLOCKS.register(name, block);
        registerBlockItemRedStone(name, toReturn);
        return toReturn;
    }

    private static <T extends Block>RegistryObject<T> registerBlockDecoration(String name, Supplier<T> block) {
        RegistryObject<T> toReturn = BLOCKS.register(name, block);
        registerBlockItemDecoration(name, toReturn);
        return toReturn;
    }

    private static <T extends Block> void registerBlockItem(String name, RegistryObject<T> block) {
        Items.ITEMS.register(name, () -> new BlockItem(block.get(), new Item.Properties().tab(CreativeModeTab.TAB_BUILDING_BLOCKS)));
    }

    private static <T extends Block> void registerBlockItemRedStone(String name, RegistryObject<T> block) {
        Items.ITEMS.register(name, () -> new BlockItem(block.get(), new Item.Properties().tab(CreativeModeTab.TAB_REDSTONE)));
    }

    private static <T extends Block> void registerBlockItemDecoration(String name, RegistryObject<T> block) {
        Items.ITEMS.register(name, () -> new BlockItem(block.get(), new Item.Properties().tab(CreativeModeTab.TAB_DECORATIONS)));
    }

    public static void register(IEventBus eventBus) {
        BLOCKS.register(eventBus);
    }
}

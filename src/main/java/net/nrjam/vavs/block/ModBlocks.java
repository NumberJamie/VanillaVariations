package net.nrjam.vavs.block;

import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.block.*;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.material.MapColor;
import net.minecraft.world.level.material.PushReaction;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;
import net.nrjam.vavs.VanillaVariations;
import net.nrjam.vavs.block.custom.*;
import net.nrjam.vavs.block.natural.*;
import net.nrjam.vavs.item.ModItems;
import net.nrjam.vavs.worldgen.tree.WalnutTreeGrower;

import java.util.function.Supplier;

public class ModBlocks {
    public static final DeferredRegister<Block> BLOCKS = DeferredRegister.create(ForgeRegistries.BLOCKS, VanillaVariations.MOD_ID);

    public static final RegistryObject<Block> REINFORCED_LEATHER_BLOCK = register("reinforced_leather_block",
            () -> new Block(BlockBehaviour.Properties.copy(Blocks.WHITE_WOOL).strength(1.6f).sound(SoundType.WOOL)));
    public static final RegistryObject<Block> ROCK_SALT_BLOCK = register("rock_salt_block",
            () -> new Block(BlockBehaviour.Properties.copy(Blocks.WHITE_WOOL).strength(4.2f).sound(SoundType.COPPER)));

    public static final RegistryObject<Block> CRYING_BASALT = register("crying_basalt",
            () -> new RotatedPillarBlock(BlockBehaviour.Properties.copy(Blocks.STONE).strength(1.25F, 4.2F).sound(SoundType.BASALT)));
    public static final RegistryObject<Block> CRYING_SMOOTH_BASALT = register("crying_smooth_basalt",
            () -> new RotatedPillarBlock(BlockBehaviour.Properties.copy(Blocks.STONE).strength(1.25F, 4.2F).sound(SoundType.BASALT)));
    public static final RegistryObject<Block> CRYING_POLISHED_BASALT = register("crying_polished_basalt",
            () -> new RotatedPillarBlock(BlockBehaviour.Properties.copy(Blocks.STONE).strength(1.25F, 4.2F).sound(SoundType.BASALT)));

    public static final RegistryObject<Block> SOUL_LIGHT = register("soul_light",
            () -> new Block(BlockBehaviour.Properties.copy(Blocks.GLASS).lightLevel((p_50886_) -> 14).sound(SoundType.GLASS).strength(1.6f, 1.6f)));

    public static final RegistryObject<Block> SOUL_STONE = register("soul_stone",
            () -> new Block(BlockBehaviour.Properties.copy(Blocks.STONE).strength(1.25f, 4.2f)));
    public static final RegistryObject<StairBlock> SOUL_STONE_STAIRS = register("soul_stone_stairs",
            () -> new StairBlock(() -> SOUL_STONE.get().defaultBlockState(), BlockBehaviour.Properties.copy(Blocks.STONE).strength(1.25f, 4.2f)));
    public static final RegistryObject<SlabBlock> SOUL_STONE_SLAB = register("soul_stone_slab",
            () -> new SlabBlock(BlockBehaviour.Properties.copy(Blocks.STONE).strength(1.25f, 4.2f)));
    public static final RegistryObject<WallBlock> SOUL_STONE_WALL = register("soul_stone_wall",
            () -> new WallBlock(BlockBehaviour.Properties.copy(Blocks.STONE).strength(1.25f, 4.2f)));

    public static final RegistryObject<Block> WALNUT_LOG = register("walnut_log",
            () -> new ModFlammableRotatedPillarBlock(BlockBehaviour.Properties.copy(Blocks.OAK_LOG).strength(2.0F, 3.0F)));
    public static final RegistryObject<Block> WALNUT_WOOD = register("walnut_wood",
            () -> new ModFlammableRotatedPillarBlock(BlockBehaviour.Properties.copy(Blocks.OAK_WOOD).strength(2.0F, 3.0F)));
    public static final RegistryObject<Block> STRIPPED_WALNUT_LOG = register("stripped_walnut_log",
            () -> new ModFlammableRotatedPillarBlock(BlockBehaviour.Properties.copy(Blocks.STRIPPED_OAK_LOG).strength(2.0F, 3.0F)));
    public static final RegistryObject<Block> STRIPPED_WALNUT_WOOD = register("stripped_walnut_wood",
            () -> new ModFlammableRotatedPillarBlock(BlockBehaviour.Properties.copy(Blocks.STRIPPED_OAK_WOOD).strength(2.0F, 3.0F)));

    public static final RegistryObject<Block> WALNUT_PLANKS = register("walnut_planks",
            () -> new Block(BlockBehaviour.Properties.copy(Blocks.OAK_PLANKS).strength(2.0F, 3.0F)){
                @Override
                public boolean isFlammable(BlockState state, BlockGetter world, BlockPos pos, Direction face) {
                    return true;
                }

                @Override
                public int getFlammability(BlockState state, BlockGetter world, BlockPos pos, Direction face) {
                    return 5;
                }

                @Override
                public int getFireSpreadSpeed(BlockState state, BlockGetter world, BlockPos pos, Direction face) {
                    return 20;
                }
            });
    public static final RegistryObject<Block> WALNUT_LEAVES = register("walnut_leaves",
            () -> new LeavesBlock(BlockBehaviour.Properties.copy(Blocks.OAK_LEAVES)){
                @Override
                public boolean isFlammable(BlockState state, BlockGetter world, BlockPos pos, Direction face) {
                    return true;
                }

                @Override
                public int getFlammability(BlockState state, BlockGetter world, BlockPos pos, Direction face) {
                    return 30;
                }

                @Override
                public int getFireSpreadSpeed(BlockState state, BlockGetter world, BlockPos pos, Direction face) {
                    return 60;
                }
            });

    public static final RegistryObject<Block> WALNUT_SAPLING = register("walnut_sapling",
            () -> new SaplingBlock(new WalnutTreeGrower(), BlockBehaviour.Properties.copy(Blocks.OAK_SAPLING)));
    public static final RegistryObject<Block> POTTED_WALNUT_SAPLING = BLOCKS.register("potted_walnut_sapling",
            () -> new PottedFlower(ModBlocks.WALNUT_SAPLING.get(), BlockBehaviour.Properties.copy(Blocks.POTTED_POPPY).instabreak()));

    public static final RegistryObject<StairBlock> WALNUT_STAIRS = register("walnut_stairs",
            () -> new StairBlock(() -> WALNUT_PLANKS.get().defaultBlockState(), Block.Properties.copy(ModBlocks.WALNUT_PLANKS.get())));
    public static final RegistryObject<SlabBlock> WALNUT_SLAB = register("walnut_slab",
            () -> new SlabBlock(Block.Properties.copy(ModBlocks.WALNUT_PLANKS.get()).strength(2.0F, 3.0F)));

    public static final RegistryObject<FenceBlock> WALNUT_FENCE = register("walnut_fence",
            () -> new FenceBlock(Block.Properties.copy(Blocks.OAK_FENCE)));
    public static final RegistryObject<FenceGateBlock> WALNUT_FENCE_GATE = register("walnut_fence_gate",
            () -> new FenceGateBlock(Block.Properties.copy(Blocks.OAK_FENCE_GATE), ModWoodTypes.WALNUT));
    public static final RegistryObject<DoorBlock> WALNUT_DOOR = register("walnut_door",
            () -> new DoorBlock(Block.Properties.copy(Blocks.OAK_DOOR), ModWoodTypes.WALNUT_BLOCK_SET));
    public static final RegistryObject<TrapDoorBlock> WALNUT_TRAPDOOR = register("walnut_trapdoor",
            () -> new TrapDoorBlock(Block.Properties.copy(Blocks.OAK_TRAPDOOR), ModWoodTypes.WALNUT_BLOCK_SET));
    public static final RegistryObject<ButtonBlock> WALNUT_BUTTON = register("walnut_button",
            () -> new ButtonBlock(Block.Properties.copy(Blocks.OAK_BUTTON), ModWoodTypes.WALNUT_BLOCK_SET, 30, true));
    public static final RegistryObject<PressurePlateBlock> WALNUT_PRESSURE_PLATE = register("walnut_pressure_plate",
            () -> new PressurePlateBlock(PressurePlateBlock.Sensitivity.EVERYTHING, Block.Properties.copy(Blocks.OAK_PRESSURE_PLATE), ModWoodTypes.WALNUT_BLOCK_SET));

    public static final RegistryObject<Block> END_SOIL = register("end_soil",
            () -> new Block(BlockBehaviour.Properties.copy(Blocks.DIRT).sound(SoundType.SOUL_SOIL).strength(1.6f, 1.6f)));

    public static final RegistryObject<Block> BLOSSOMING_ROOT = register("blossoming_root", () -> new EndSoilFlower(
            () -> MobEffects.LEVITATION, 3*20, BlockBehaviour.Properties.copy(Blocks.POPPY).noCollission().instabreak().lightLevel((p_152607_) -> 12).sound(SoundType.GRASS)));
    public static final RegistryObject<Block> ENDER_ROOT = register("ender_root", () -> new EndSoilFlower(
            () -> MobEffects.LEVITATION, 3*20, BlockBehaviour.Properties.copy(Blocks.POPPY).noCollission().instabreak().sound(SoundType.GRASS)));
    public static final RegistryObject<Block> SOUL_FLOWER = register("soul_flower", () -> new SoulSoilFlower(
            () -> MobEffects.MOVEMENT_SPEED, 3*20, BlockBehaviour.Properties.copy(Blocks.POPPY).noCollission().instabreak().lightLevel((p_50886_) -> 7).sound(SoundType.GRASS)));
    public static final RegistryObject<Block> DEAD_ROOTS = register("dead_roots", () -> new NetherFlower(
            () -> MobEffects.FIRE_RESISTANCE, 4*20, BlockBehaviour.Properties.copy(Blocks.POPPY).noCollission().instabreak().sound(SoundType.GRASS)));
    public static final RegistryObject<Block> WILD_GINGER = register("wild_ginger", () -> new NetherFlower(
            () -> MobEffects.NIGHT_VISION, 4*20, BlockBehaviour.Properties.copy(Blocks.POPPY).noCollission().instabreak().sound(SoundType.GRASS)));

    public static final RegistryObject<FarmBlock> NETHER_FARMLAND = register("nether_farmland",
            () -> new NetherFarmland((BlockBehaviour.Properties.copy(Blocks.DIRT).sound(SoundType.SOUL_SOIL).randomTicks().strength(1.6f, 1.6f))));

    public static final RegistryObject<Block> POTTED_BLOSSOMING_ROOT = BLOCKS.register("potted_blossoming_root",
            () -> new PottedFlower(ModBlocks.BLOSSOMING_ROOT.get(), BlockBehaviour.Properties.copy(Blocks.POTTED_POPPY).instabreak().lightLevel((p_50886_) -> 12)));
    public static final RegistryObject<Block> POTTED_ENDER_ROOT = BLOCKS.register("potted_ender_root",
            () -> new PottedFlower(ModBlocks.ENDER_ROOT.get(), BlockBehaviour.Properties.copy(Blocks.POTTED_POPPY).instabreak()));
    public static final RegistryObject<Block> POTTED_SOUL_FLOWER = BLOCKS.register("potted_soul_flower",
            () -> new PottedFlower(ModBlocks.SOUL_FLOWER.get(), BlockBehaviour.Properties.copy(Blocks.POTTED_POPPY).instabreak()));
    public static final RegistryObject<Block> POTTED_DEAD_ROOTS = BLOCKS.register("potted_dead_roots",
            () -> new PottedFlower(ModBlocks.DEAD_ROOTS.get(), BlockBehaviour.Properties.copy(Blocks.POTTED_POPPY).instabreak()));

    public static final RegistryObject<Block> SOUL_SPROUTS = BLOCKS.register("soul_sprouts",
            () -> new SoulSprouts(BlockBehaviour.Properties.copy(Blocks.WHEAT).noCollission().randomTicks().instabreak().lightLevel((p_50886_) -> 7).sound(SoundType.CROP)));

    public static final RegistryObject<Block> WARPED_BERRIES = BLOCKS.register("warped_berries",
            () -> new BerryBush(BlockBehaviour.Properties.copy(Blocks.SWEET_BERRY_BUSH).noCollission().randomTicks().instabreak().lightLevel((p_50886_) -> 5).sound(SoundType.CROP), ModItems.WARPED_BERRIES, Blocks.WARPED_NYLIUM));
    public static final RegistryObject<Block> CRIMSON_BERRIES = BLOCKS.register("crimson_berries",
            () -> new BerryBush(BlockBehaviour.Properties.copy(Blocks.SWEET_BERRY_BUSH).noCollission().randomTicks().instabreak().lightLevel((p_50886_) -> 5).sound(SoundType.CROP),  ModItems.CRIMSON_BERRIES, Blocks.CRIMSON_NYLIUM));

    public static final RegistryObject<Block> CABBAGE_CROP = BLOCKS.register("cabbage_crop",
            () -> new CabbageCrop(BlockBehaviour.Properties.copy(Blocks.WHEAT).noCollission().randomTicks().instabreak().sound(SoundType.CROP)));
    public static final RegistryObject<Block> AMARANTH_CROP = BLOCKS.register("amaranth_crop",
            () -> new AmaranthCrop(BlockBehaviour.Properties.copy(Blocks.WHEAT).noCollission().randomTicks().instabreak().sound(SoundType.CROP)));
    public static final RegistryObject<Block> GINGER_CROP = BLOCKS.register("ginger_crop",
            () -> new GingerCrop(BlockBehaviour.Properties.copy(Blocks.WHEAT).noCollission().randomTicks().instabreak().sound(SoundType.CROP)));

    public static final RegistryObject<Block> WILD_CABBAGE = register("wild_cabbage", () -> dirtFlower(MobEffects.CONFUSION, 4));
    public static final RegistryObject<Block> VIOLA = register("viola", () -> dirtFlower(MobEffects.POISON, 5));
    public static final RegistryObject<Block> MARIGOLD = register("marigold", () -> dirtFlower(MobEffects.FIRE_RESISTANCE, 3));
    public static final RegistryObject<Block> SNAPDRAGON = register("snapdragon", () -> dirtFlower(MobEffects.CONFUSION, 5));
    public static final RegistryObject<Block> LAVENDER = register("lavender", () -> dirtFlower(MobEffects.CONFUSION, 5));

    public static final RegistryObject<Block> WATER_LILY = BLOCKS.register("water_lily",
            () -> new ModWaterlily(BlockBehaviour.Properties.copy(Blocks.LILY_PAD).instabreak().sound(SoundType.LILY_PAD).pushReaction(PushReaction.DESTROY)));
    public static final RegistryObject<Block> WATER_LILY_PAD = BLOCKS.register("water_lily_pad",
            () -> new ModWaterlily(BlockBehaviour.Properties.copy(Blocks.LILY_PAD).instabreak().sound(SoundType.LILY_PAD).pushReaction(PushReaction.DESTROY)));

    public static final RegistryObject<Block> POTTED_WILD_CABBAGE = BLOCKS.register("potted_wild_cabbage",
            () -> new PottedFlower(ModBlocks.WILD_CABBAGE.get(), BlockBehaviour.Properties.copy(Blocks.POTTED_POPPY).instabreak()));
    public static final RegistryObject<Block> POTTED_VIOLA = BLOCKS.register("potted_viola",
            () -> new PottedFlower(ModBlocks.VIOLA.get(), BlockBehaviour.Properties.copy(Blocks.POTTED_POPPY).instabreak()));
    public static final RegistryObject<Block> POTTED_MARIGOLD = BLOCKS.register("potted_marigold",
            () -> new PottedFlower(ModBlocks.MARIGOLD.get(), BlockBehaviour.Properties.copy(Blocks.POTTED_POPPY).instabreak()));
    public static final RegistryObject<Block> POTTED_SNAPDRAGON = BLOCKS.register("potted_snapdragon",
            () -> new PottedFlower(ModBlocks.SNAPDRAGON.get(), BlockBehaviour.Properties.copy(Blocks.POTTED_POPPY).instabreak()));
    public static final RegistryObject<Block> POTTED_LAVENDER = BLOCKS.register("potted_lavender",
            () -> new PottedFlower(ModBlocks.LAVENDER.get(), BlockBehaviour.Properties.copy(Blocks.POTTED_POPPY).instabreak()));

    public static final RegistryObject<Block> CHOCOLATE_CAKE = register("chocolate_cake",
            () -> new ModCakeBlock(BlockBehaviour.Properties.copy(Blocks.CAKE).sound(SoundType.WOOL)));
    public static final RegistryObject<Block> HONEY_CAKE = register("honey_cake",
            () -> new ModCakeBlock(BlockBehaviour.Properties.copy(Blocks.CAKE).sound(SoundType.WOOL)));

    public static final RegistryObject<Block> CRIMSON_CAKE = register("crimson_cake",
            () -> new ModCakeBlock(BlockBehaviour.Properties.copy(Blocks.CAKE).sound(SoundType.WOOL)));
    public static final RegistryObject<Block> WARPED_CAKE = register("warped_cake",
            () -> new ModCakeBlock(BlockBehaviour.Properties.copy(Blocks.CAKE).sound(SoundType.WOOL)));

    public static final RegistryObject<Block> CRYSTAL_BLOCK = register("crystal_block",
            () -> new Block(BlockBehaviour.Properties.copy(Blocks.IRON_BLOCK).sound(SoundType.AMETHYST).strength(4.5f, 7.5f).requiresCorrectToolForDrops()));
    public static final RegistryObject<Block> CRYSTAL_ORE = register( "crystal_ore",
            () -> new Block(BlockBehaviour.Properties.copy(Blocks.STONE).strength(3f, 6f).requiresCorrectToolForDrops()));

    private static DirtFlower dirtFlower(MobEffect effect, int durationS) {
        return new DirtFlower(() -> effect, durationS*20, BlockBehaviour.Properties.of()
                .mapColor(MapColor.PLANT).noOcclusion().noCollission().instabreak().sound(SoundType.GRASS)
                .offsetType(BlockBehaviour.OffsetType.XZ).pushReaction(PushReaction.DESTROY));
    }

    private static <T extends Block> RegistryObject<T> register(String name, Supplier<T> block) {
        RegistryObject<T> toReturn = BLOCKS.register(name, block);
        registerBlockItem(name, toReturn);
        return toReturn;
    }

    private static <T extends Block> void registerBlockItem(String name, RegistryObject<T> block)  {
        ModItems.ITEMS.register(name, () -> new BlockItem(block.get(), new Item.Properties()));
    }

    public static void register(IEventBus eventBus) {
        BLOCKS.register(eventBus);
    }
}

package net.nrjam.vavs.block;

import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.block.*;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.material.Material;
import net.minecraftforge.common.ToolActions;
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

    public static final RegistryObject<Block> REINFORCED_LEATHER_BLOCK = registerBlock("reinforced_leather_block",
            () -> new Block(BlockBehaviour.Properties.of(Material.WOOL).strength(1.6f).sound(SoundType.WOOL)));

    public static final RegistryObject<Block> SOUL_LIGHT = registerBlock("soul_light",
            () -> new Block(BlockBehaviour.Properties.of(Material.GLASS).lightLevel((p_50886_) -> 14).sound(SoundType.GLASS).strength(1.6f, 1.6f)));

    public static final RegistryObject<Block> SOUL_STONE = registerBlock("soul_stone",
            () -> new Block(BlockBehaviour.Properties.of(Material.STONE).strength(1.25f, 4.2f)));
    public static final RegistryObject<StairBlock> SOUL_STONE_STAIRS = registerBlock("soul_stone_stairs",
            () -> new StairBlock(() -> SOUL_STONE.get().defaultBlockState(), BlockBehaviour.Properties.of(Material.STONE).strength(1.25f, 4.2f)));
    public static final RegistryObject<SlabBlock> SOUL_STONE_SLAB = registerBlock("soul_stone_slab",
            () -> new SlabBlock(BlockBehaviour.Properties.of(Material.STONE).strength(1.25f, 4.2f)));
    public static final RegistryObject<WallBlock> SOUL_STONE_WALL = registerBlock("soul_stone_wall",
            () -> new WallBlock(BlockBehaviour.Properties.of(Material.STONE).strength(1.25f, 4.2f)));

    public static final RegistryObject<Block> WALNUT_LOG = registerBlock("walnut_log",
            () -> new ModFlammableRotatedPillarBlock(BlockBehaviour.Properties.copy(Blocks.OAK_LOG).strength(2.0F, 3.0F)));
    public static final RegistryObject<Block> WALNUT_WOOD = registerBlock("walnut_wood",
            () -> new ModFlammableRotatedPillarBlock(BlockBehaviour.Properties.copy(Blocks.OAK_WOOD).strength(2.0F, 3.0F)));
    public static final RegistryObject<Block> STRIPPED_WALNUT_LOG = registerBlock("stripped_walnut_log",
            () -> new ModFlammableRotatedPillarBlock(BlockBehaviour.Properties.copy(Blocks.STRIPPED_OAK_LOG).strength(2.0F, 3.0F)));
    public static final RegistryObject<Block> STRIPPED_WALNUT_WOOD = registerBlock("stripped_walnut_wood",
            () -> new ModFlammableRotatedPillarBlock(BlockBehaviour.Properties.copy(Blocks.STRIPPED_OAK_WOOD).strength(2.0F, 3.0F)));

    public static final RegistryObject<Block> WALNUT_PLANKS = registerBlock("walnut_planks",
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
    public static final RegistryObject<Block> WALNUT_LEAVES = registerBlock("walnut_leaves",
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

    public static final RegistryObject<Block> WALNUT_SAPLING = registerBlock("walnut_sapling",
            () -> new SaplingBlock(new WalnutTreeGrower(), BlockBehaviour.Properties.copy(Blocks.OAK_SAPLING)));
    public static final RegistryObject<Block> POTTED_WALNUT_SAPLING = BLOCKS.register("potted_walnut_sapling",
            () -> new PottedFlower(ModBlocks.WALNUT_SAPLING.get(), BlockBehaviour.Properties.of(Material.DECORATION).instabreak()));

    public static final RegistryObject<StairBlock> WALNUT_STAIRS = registerBlock("walnut_stairs",
            () -> new StairBlock(() -> WALNUT_PLANKS.get().defaultBlockState(), Block.Properties.copy(ModBlocks.WALNUT_PLANKS.get())));
    public static final RegistryObject<SlabBlock> WALNUT_SLAB = registerBlock("walnut_slab",
            () -> new SlabBlock(Block.Properties.copy(ModBlocks.WALNUT_PLANKS.get()).strength(2.0F, 3.0F)));

    public static final RegistryObject<FenceBlock> WALNUT_FENCE = registerBlock("walnut_fence",
            () -> new FenceBlock(Block.Properties.copy(Blocks.OAK_FENCE)));
    public static final RegistryObject<FenceGateBlock> WALNUT_FENCE_GATE = registerBlock("walnut_fence_gate",
            () -> new FenceGateBlock(Block.Properties.copy(Blocks.OAK_FENCE_GATE), ModWoodTypes.WALNUT));
    public static final RegistryObject<DoorBlock> WALNUT_DOOR = registerBlock("walnut_door",
            () -> new DoorBlock(Block.Properties.copy(Blocks.OAK_DOOR), ModWoodTypes.WALNUT_BLOCK_SET));
    public static final RegistryObject<TrapDoorBlock> WALNUT_TRAPDOOR = registerBlock("walnut_trapdoor",
            () -> new TrapDoorBlock(Block.Properties.copy(Blocks.OAK_TRAPDOOR), ModWoodTypes.WALNUT_BLOCK_SET));
    public static final RegistryObject<ButtonBlock> WALNUT_BUTTON = registerBlock("walnut_button",
            () -> new ButtonBlock(Block.Properties.copy(Blocks.OAK_BUTTON), ModWoodTypes.WALNUT_BLOCK_SET, 30, true));
    public static final RegistryObject<PressurePlateBlock> WALNUT_PRESSURE_PLATE = registerBlock("walnut_pressure_plate",
            () -> new PressurePlateBlock(PressurePlateBlock.Sensitivity.EVERYTHING, Block.Properties.copy(Blocks.OAK_PRESSURE_PLATE), ModWoodTypes.WALNUT_BLOCK_SET));

    public static final RegistryObject<Block> END_SOIL = registerBlock("end_soil",
            () -> new Block(BlockBehaviour.Properties.of(Material.DIRT).sound(SoundType.SOUL_SOIL).strength(1.6f, 1.6f)));

    public static final RegistryObject<Block> BLOSSOMING_ROOT = registerBlock("blossoming_root",
            () -> new EndSoilFlower(MobEffects.LEVITATION, 3*20, BlockBehaviour.Properties.of(Material.PLANT).noCollission().instabreak().lightLevel((p_152607_) -> 12).sound(SoundType.GRASS)));
    public static final RegistryObject<Block> ENDER_ROOT = registerBlock("ender_root",
            () -> new EndSoilFlower(MobEffects.LEVITATION, 3*20, BlockBehaviour.Properties.of(Material.PLANT).noCollission().instabreak().sound(SoundType.GRASS)));
    public static final RegistryObject<Block> SOUL_FLOWER = registerBlock("soul_flower",
            () -> new SoulSoilFlower(MobEffects.MOVEMENT_SPEED, 3*20, BlockBehaviour.Properties.of(Material.PLANT).noCollission().instabreak().lightLevel((p_50886_) -> 7).sound(SoundType.GRASS)));
    public static final RegistryObject<Block> DEAD_ROOTS = registerBlock("dead_roots",
            () -> new NetherFlower(MobEffects.FIRE_RESISTANCE, 4*20, BlockBehaviour.Properties.of(Material.PLANT).noCollission().instabreak().sound(SoundType.GRASS)));

    public static final RegistryObject<FarmBlock> NETHER_FARMLAND = registerBlock("nether_farmland",
            () -> new NetherFarmland((BlockBehaviour.Properties.of(Material.DIRT).sound(SoundType.SOUL_SOIL).randomTicks().strength(1.6f, 1.6f))));

    public static final RegistryObject<Block> POTTED_BLOSSOMING_ROOT = BLOCKS.register("potted_blossoming_root",
            () -> new PottedFlower(ModBlocks.BLOSSOMING_ROOT.get(), BlockBehaviour.Properties.of(Material.DECORATION).instabreak().lightLevel((p_50886_) -> 12)));
    public static final RegistryObject<Block> POTTED_ENDER_ROOT = BLOCKS.register("potted_ender_root",
            () -> new PottedFlower(ModBlocks.ENDER_ROOT.get(), BlockBehaviour.Properties.of(Material.DECORATION).instabreak()));
    public static final RegistryObject<Block> POTTED_SOUL_FLOWER = BLOCKS.register("potted_soul_flower",
            () -> new PottedFlower(ModBlocks.SOUL_FLOWER.get(), BlockBehaviour.Properties.of(Material.DECORATION).instabreak()));
    public static final RegistryObject<Block> POTTED_DEAD_ROOTS = BLOCKS.register("potted_dead_roots",
            () -> new PottedFlower(ModBlocks.DEAD_ROOTS.get(), BlockBehaviour.Properties.of(Material.DECORATION).instabreak()));

    public static final RegistryObject<Block> SOUL_SPROUTS = BLOCKS.register("soul_sprouts",
            () -> new SoulSprouts(BlockBehaviour.Properties.of(Material.PLANT).noCollission().randomTicks().instabreak().lightLevel((p_50886_) -> 7).sound(SoundType.CROP)));

    public static final RegistryObject<Block> WARPED_BERRY = BLOCKS.register("warped_berry",
            () -> new WarpedBerry(BlockBehaviour.Properties.of(Material.PLANT).noCollission().randomTicks().instabreak().lightLevel((p_50886_) -> 5).sound(SoundType.CROP)));
    public static final RegistryObject<Block> CRIMSON_BERRY = BLOCKS.register("crimson_berry",
            () -> new CrimsonBerry(BlockBehaviour.Properties.of(Material.PLANT).noCollission().randomTicks().instabreak().lightLevel((p_50886_) -> 5).sound(SoundType.CROP)));


    private static <T extends Block> RegistryObject<T> registerBlock(String name, Supplier<T> block) {
        RegistryObject<T> toReturn = BLOCKS.register(name, block);
        registerBlockItem(name, toReturn);
        return toReturn;
    }

    private static <T extends Block> RegistryObject<Item> registerBlockItem(String name, RegistryObject<T> block)  {
        return ModItems.ITEMS.register(name, () -> new BlockItem(block.get(), new Item.Properties()));
    }

    public static void register(IEventBus eventBus) {
        BLOCKS.register(eventBus);
    }
}

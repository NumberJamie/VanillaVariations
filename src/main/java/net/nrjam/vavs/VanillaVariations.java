package net.nrjam.vavs;

import com.mojang.logging.LogUtils;
import net.minecraft.world.item.CreativeModeTabs;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.event.CreativeModeTabEvent;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import net.nrjam.vavs.block.ModBlocks;
import net.nrjam.vavs.item.ModItems;
import net.nrjam.vavs.item.enchantments.ModEnchantments;
import org.slf4j.Logger;

@Mod(VanillaVariations.MOD_ID)
public class VanillaVariations
{
    public static final String MOD_ID = "vavs";
    private static final Logger LOGGER = LogUtils.getLogger();

    public VanillaVariations()
    {
        IEventBus modEventBus = FMLJavaModLoadingContext.get().getModEventBus();

        ModItems.register(modEventBus);
        ModBlocks.register(modEventBus);
        ModEnchantments.register(modEventBus);

        modEventBus.addListener(this::commonSetup);
        MinecraftForge.EVENT_BUS.register(this);
        modEventBus.addListener(this::addCreative);
    }

    private void commonSetup(final FMLCommonSetupEvent event)
    {
    }

    private void addCreative(CreativeModeTabEvent.BuildContents event) {
        if(event.getTab() == CreativeModeTabs.INGREDIENTS) {
            event.accept(ModItems.CRYSTAL);
            event.accept(ModItems.SOUL_ESSENCE);
            event.accept(ModItems.AMARANTH_ESSENCE);
            event.accept(ModItems.REINFORCED_LEATHER);
            event.accept(ModItems.CABBAGE_SEED);
            event.accept(ModItems.AMARANTH_SEED);
        }
        if(event.getTab() == CreativeModeTabs.TOOLS_AND_UTILITIES) {
            event.accept(ModItems.FUSED_AMARANTH_SHOVEL);
            event.accept(ModItems.FUSED_AMARANTH_PICKAXE);
            event.accept(ModItems.FUSED_AMARANTH_AXE);
            event.accept(ModItems.FUSED_AMARANTH_HOE);
            event.accept(ModItems.CRYSTAL_SHOVEL);
            event.accept(ModItems.CRYSTAL_PICKAXE);
            event.accept(ModItems.CRYSTAL_AXE);
            event.accept(ModItems.CRYSTAL_HOE);
        }
        if(event.getTab() == CreativeModeTabs.BUILDING_BLOCKS) {
            event.accept(ModBlocks.CRYSTAL_BLOCK);
            event.accept(ModBlocks.CRYSTAL_ORE);
            event.accept(ModBlocks.END_SOIL);
            event.accept(ModBlocks.WALNUT_LOG);
            event.accept(ModBlocks.WALNUT_WOOD);
            event.accept(ModBlocks.STRIPPED_WALNUT_LOG);
            event.accept(ModBlocks.STRIPPED_WALNUT_WOOD);
            event.accept(ModBlocks.WALNUT_PLANKS);
            event.accept(ModBlocks.WALNUT_STAIRS);
            event.accept(ModBlocks.WALNUT_SLAB);
            event.accept(ModBlocks.WALNUT_FENCE);
            event.accept(ModBlocks.WALNUT_FENCE_GATE);
            event.accept(ModBlocks.WALNUT_DOOR);
            event.accept(ModBlocks.WALNUT_TRAPDOOR);
            event.accept(ModBlocks.WALNUT_PRESSURE_PLATE);
            event.accept(ModBlocks.WALNUT_BUTTON);
            event.accept(ModBlocks.CRYING_BASALT);
            event.accept(ModBlocks.CRYING_SMOOTH_BASALT);
            event.accept(ModBlocks.CRYING_POLISHED_BASALT);
            event.accept(ModBlocks.SOUL_LIGHT);
            event.accept(ModBlocks.SOUL_STONE);
            event.accept(ModBlocks.SOUL_STONE_STAIRS);
            event.accept(ModBlocks.SOUL_STONE_SLAB);
            event.accept(ModBlocks.SOUL_STONE_WALL);
        }
        if(event.getTab() == CreativeModeTabs.COMBAT) {
            event.accept(ModItems.CRYSTAL_SWORD);
            event.accept(ModItems.CRYSTAL_AXE);
            event.accept(ModItems.FUSED_AMARANTH_SWORD);
            event.accept(ModItems.FUSED_AMARANTH_AXE);
            event.accept(ModItems.FLOWER_CROWN);
            event.accept(ModItems.REINFORCED_LEATHER_HELMET);
            event.accept(ModItems.REINFORCED_LEATHER_CHESTPLATE);
            event.accept(ModItems.REINFORCED_LEATHER_LEGGINGS);
            event.accept(ModItems.REINFORCED_LEATHER_BOOTS);
            event.accept(ModItems.FUSED_SOUL_HELMET);
            event.accept(ModItems.FUSED_SOUL_CHESTPLATE);
            event.accept(ModItems.FUSED_SOUL_LEGGINGS);
            event.accept(ModItems.FUSED_SOUL_BOOTS);
            event.accept(ModItems.FUSED_AMARANTH_HELMET);
            event.accept(ModItems.FUSED_AMARANTH_CHESTPLATE);
            event.accept(ModItems.FUSED_AMARANTH_LEGGINGS);
            event.accept(ModItems.FUSED_AMARANTH_BOOTS);
            event.accept(ModItems.CRYSTAL_HELMET);
            event.accept(ModItems.CRYSTAL_CHESTPLATE);
            event.accept(ModItems.CRYSTAL_LEGGINGS);
            event.accept(ModItems.CRYSTAL_BOOTS);
        }
        if(event.getTab() == CreativeModeTabs.NATURAL_BLOCKS) {
            event.accept(ModBlocks.WALNUT_LOG);
            event.accept(ModBlocks.WALNUT_LEAVES);
            event.accept(ModBlocks.WALNUT_SAPLING);
            event.accept(ModBlocks.END_SOIL);
            event.accept(ModBlocks.CRYSTAL_ORE);
            event.accept(ModBlocks.NETHER_FARMLAND);
            event.accept(ModBlocks.CRYING_BASALT);
            event.accept(ModBlocks.BLOSSOMING_ROOT);
            event.accept(ModBlocks.ENDER_ROOT);
            event.accept(ModBlocks.SOUL_FLOWER);
            event.accept(ModBlocks.DEAD_ROOTS);
            event.accept(ModItems.WARPED_BERRIES);
            event.accept(ModItems.CRIMSON_BERRIES);
            event.accept(ModItems.CABBAGE_SEED);
            event.accept(ModItems.AMARANTH_SEED);
            event.accept(ModBlocks.WILD_CABBAGE);
            event.accept(ModBlocks.WILD_GINGER);
            event.accept(ModBlocks.VIOLA);
            event.accept(ModBlocks.MARIGOLD);
            event.accept(ModBlocks.LAVENDER);
            event.accept(ModBlocks.SNAPDRAGON);
        }
        if(event.getTab() == CreativeModeTabs.FUNCTIONAL_BLOCKS) {
            event.accept(ModBlocks.SOUL_LIGHT);
        }
        if (event.getTab() == CreativeModeTabs.FOOD_AND_DRINKS) {
            // ingredients
            event.accept(ModItems.CABBAGE);
            event.accept(ModItems.GINGER);
            event.accept(ModItems.AMARANTH);
            event.accept(ModItems.SOUL_SPROUT);
            event.accept(ModItems.WARPED_BERRIES);
            event.accept(ModItems.CRIMSON_BERRIES);

            // pies
            event.accept(ModItems.SWEET_BERRY_PIE);
            event.accept(ModItems.APPLE_PIE);
            event.accept(ModItems.CHORUS_FRUIT_PIE);
            event.accept(ModItems.SOUL_SPROUT_PIE);
            event.accept(ModItems.WARPED_BERRY_PIE);
            event.accept(ModItems.CRIMSON_BERRY_PIE);
            event.accept(ModItems.AMARANTH_PIE);
            event.accept(ModItems.GINGER_PIE);

            // stews
            event.accept(ModItems.DRIED_KELP_SOUP);
            event.accept(ModItems.SOUL_SPROUT_STEW);
            event.accept(ModItems.AMARANTH_SOUP);

            // salads
            event.accept(ModItems.SWEET_SALAD);
            event.accept(ModItems.SALMON_SALAD);
            event.accept(ModItems.MEAT_SALAD);
            event.accept(ModItems.GARDEN_SALAD);
            event.accept(ModItems.SOUL_SPROUT_SALAD);
            event.accept(ModItems.AMARANTH_SALAD);
            event.accept(ModItems.GINGER_SALAD);

            // misc
            event.accept(ModItems.AMARANTH_BREAD);
            event.accept(ModItems.GINGER_BREAD);
            event.accept(ModItems.AMARANTH_GINGER_BREAD);
            event.accept(ModItems.AMARANTH_COOKIE);

            // cakes
            event.accept(ModBlocks.CHOCOLATE_CAKE);
            event.accept(ModBlocks.HONEY_CAKE);
            event.accept(ModBlocks.CRIMSON_CAKE);
            event.accept(ModBlocks.WARPED_CAKE);
        }
    }

    @Mod.EventBusSubscriber(modid = MOD_ID, bus = Mod.EventBusSubscriber.Bus.MOD, value = Dist.CLIENT)
    public static class ClientModEvents
    {
        @SubscribeEvent
        public static void onClientSetup(FMLClientSetupEvent event)
        {

        }
    }
}

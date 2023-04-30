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

        modEventBus.addListener(this::commonSetup);
        MinecraftForge.EVENT_BUS.register(this);
        modEventBus.addListener(this::addCreative);
    }

    private void commonSetup(final FMLCommonSetupEvent event)
    {
    }

    private void addCreative(CreativeModeTabEvent.BuildContents event) {
        if(event.getTab() == CreativeModeTabs.INGREDIENTS) {
            event.accept(ModItems.SOUL_ESSENCE);
            event.accept(ModItems.REINFORCED_LEATHER);
        }
        if(event.getTab() == CreativeModeTabs.BUILDING_BLOCKS) {
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
            event.accept(ModBlocks.SOUL_LIGHT);
            event.accept(ModBlocks.SOUL_STONE);
            event.accept(ModBlocks.SOUL_STONE_STAIRS);
            event.accept(ModBlocks.SOUL_STONE_SLAB);
            event.accept(ModBlocks.SOUL_STONE_WALL);
        }
        if(event.getTab() == CreativeModeTabs.COMBAT) {
            event.accept(ModItems.REINFORCED_LEATHER_HELMET);
            event.accept(ModItems.REINFORCED_LEATHER_CHESTPLATE);
            event.accept(ModItems.REINFORCED_LEATHER_LEGGINGS);
            event.accept(ModItems.REINFORCED_LEATHER_BOOTS);
            event.accept(ModItems.FUSED_SOUL_HELMET);
            event.accept(ModItems.FUSED_SOUL_CHESTPLATE);
            event.accept(ModItems.FUSED_SOUL_LEGGINGS);
            event.accept(ModItems.FUSED_SOUL_BOOTS);
        }
        if(event.getTab() == CreativeModeTabs.NATURAL_BLOCKS) {
            event.accept(ModBlocks.WALNUT_LOG);
            event.accept(ModBlocks.WALNUT_LEAVES);
            event.accept(ModBlocks.WALNUT_SAPLING);
            event.accept(ModBlocks.END_SOIL);
            event.accept(ModBlocks.NETHER_FARMLAND);
            event.accept(ModBlocks.BLOSSOMING_ROOT);
            event.accept(ModBlocks.ENDER_ROOT);
            event.accept(ModBlocks.SOUL_FLOWER);
            event.accept(ModBlocks.DEAD_ROOTS);
        }
        if(event.getTab() == CreativeModeTabs.FUNCTIONAL_BLOCKS) {
            event.accept(ModBlocks.SOUL_LIGHT);
        }
        if (event.getTab() == CreativeModeTabs.FOOD_AND_DRINKS) {
            event.accept(ModItems.SOUL_SPROUT);
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

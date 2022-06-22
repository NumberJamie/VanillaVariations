package com.nrjam.vavs;

import com.google.common.collect.ImmutableBiMap;
import com.google.common.collect.ImmutableMap;
import com.mojang.datafixers.util.Pair;
import com.nrjam.vavs.block.ModBlocks;
import com.nrjam.vavs.block.entity.BlockEntities;
import com.nrjam.vavs.enchantments.ModEnchantments;
import com.nrjam.vavs.item.Items;
import com.nrjam.vavs.item.custom.ModItemProperties;
import com.nrjam.vavs.recipe.ModRecipes;
import com.nrjam.vavs.screen.CrystallizerMenu;
import com.nrjam.vavs.screen.CrystallizerScreen;
import com.nrjam.vavs.screen.MenuTypes;
import net.minecraft.client.gui.screens.MenuScreens;
import net.minecraft.client.renderer.ItemBlockRenderTypes;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.world.item.AxeItem;
import net.minecraft.world.item.HoeItem;
import net.minecraft.world.item.HoneycombItem;
import net.minecraft.world.item.context.UseOnContext;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.InterModComms;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.event.lifecycle.InterModEnqueueEvent;
import net.minecraftforge.fml.event.lifecycle.InterModProcessEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.function.Consumer;
import java.util.function.Predicate;

@Mod(VanillaVariations.MOD_ID)
public class VanillaVariations
{

    public static final String MOD_ID = "vavs";

    private static final Logger LOGGER = LogManager.getLogger();

    public VanillaVariations() {
        IEventBus eventBus = FMLJavaModLoadingContext.get().getModEventBus();

        Items.register(eventBus);
        ModBlocks.register(eventBus);

        ModEnchantments.register(eventBus);

        BlockEntities.register(eventBus);
        MenuTypes.register(eventBus);

        ModRecipes.register(eventBus);

        eventBus.addListener(this::setup);
        eventBus.addListener(this::enqueueIMC);
        eventBus.addListener(this::processIMC);
        eventBus.addListener(this::ClientSetup);

        MinecraftForge.EVENT_BUS.register(this);
    }

    private void setup(final FMLCommonSetupEvent event)
    {
        event.enqueueWork(() -> {
            AxeItem.STRIPPABLES = new ImmutableMap.Builder<Block, Block>().putAll(AxeItem.STRIPPABLES)
                    .put(ModBlocks.WALNUT_LOG.get(), ModBlocks.STRIPPED_WALNUT_LOG.get())
                    .put(ModBlocks.WALNUT_WOOD.get(), ModBlocks.STRIPPED_WALNUT_WOOD.get()).build();
        });
        event.enqueueWork(() -> {
            HoeItem.TILLABLES = new ImmutableMap.Builder<Block, Pair<Predicate<UseOnContext>, Consumer<UseOnContext>>>()
                    .putAll(HoeItem.TILLABLES)
                    .putAll(ImmutableMap.of(Blocks.SOUL_SOIL, Pair.of(HoeItem::onlyIfAirAbove, HoeItem.changeIntoState(ModBlocks.NETHER_FARMLAND.get().defaultBlockState()))))
                    .putAll(ImmutableMap.of(ModBlocks.END_SOIL.get(), Pair.of(HoeItem::onlyIfAirAbove, HoeItem.changeIntoState(ModBlocks.END_FARMLAND.get().defaultBlockState())))).build();
        });
    }

    private void ClientSetup(final FMLClientSetupEvent event) {
        ModItemProperties.addCustomItemProperties();

        event.enqueueWork(() -> {
            ItemBlockRenderTypes.setRenderLayer(ModBlocks.VIOLA.get(), RenderType.cutout());
            ItemBlockRenderTypes.setRenderLayer(ModBlocks.LAVENDER.get(), RenderType.cutout());
            ItemBlockRenderTypes.setRenderLayer(ModBlocks.MARIGOLD.get(), RenderType.cutout());
            ItemBlockRenderTypes.setRenderLayer(ModBlocks.SNAPDRAGON.get(), RenderType.cutout());
            ItemBlockRenderTypes.setRenderLayer(ModBlocks.CABBAGES.get(), RenderType.cutout());
            ItemBlockRenderTypes.setRenderLayer(ModBlocks.WILD_CABBAGES.get(), RenderType.cutout());
            ItemBlockRenderTypes.setRenderLayer(ModBlocks.POTTED_VIOLA.get(), RenderType.cutout());
            ItemBlockRenderTypes.setRenderLayer(ModBlocks.POTTED_LAVENDER.get(), RenderType.cutout());
            ItemBlockRenderTypes.setRenderLayer(ModBlocks.POTTED_MARIGOLD.get(), RenderType.cutout());
            ItemBlockRenderTypes.setRenderLayer(ModBlocks.POTTED_SNAPDRAGON.get(), RenderType.cutout());
            ItemBlockRenderTypes.setRenderLayer(ModBlocks.POTTED_WALNUT_SAPLING.get(), RenderType.cutout());
            ItemBlockRenderTypes.setRenderLayer(ModBlocks.POTTED_WILD_CABBAGES.get(), RenderType.cutout());
            ItemBlockRenderTypes.setRenderLayer(ModBlocks.WALNUT_DOOR.get(), RenderType.cutout());
            ItemBlockRenderTypes.setRenderLayer(ModBlocks.WALNUT_TRAPDOOR.get(), RenderType.cutout());
            ItemBlockRenderTypes.setRenderLayer(ModBlocks.WALNUT_TRAPDOOR_HEART.get(), RenderType.cutout());
            ItemBlockRenderTypes.setRenderLayer(ModBlocks.WALNUT_TRAPDOOR_ROUND.get(), RenderType.cutout());
            ItemBlockRenderTypes.setRenderLayer(ModBlocks.WALNUT_DOOR_HEART.get(), RenderType.cutout());
            ItemBlockRenderTypes.setRenderLayer(ModBlocks.WALNUT_SAPLING.get(), RenderType.cutout());
            ItemBlockRenderTypes.setRenderLayer(ModBlocks.WALNUT_LEAVES.get(), RenderType.cutout());
            ItemBlockRenderTypes.setRenderLayer(ModBlocks.DRAGONS_BREATH_TORCH.get(), RenderType.cutout());
            ItemBlockRenderTypes.setRenderLayer(ModBlocks.DRAGONS_BREATH_WALL_TORCH.get(), RenderType.cutout());
            ItemBlockRenderTypes.setRenderLayer(ModBlocks.DRAGONS_BREATH_LANTERN.get(), RenderType.cutout());
            ItemBlockRenderTypes.setRenderLayer(ModBlocks.SOUL_FLOWER.get(), RenderType.cutout());
            ItemBlockRenderTypes.setRenderLayer(ModBlocks.POTTED_SOUL_FLOWER.get(), RenderType.cutout());
            ItemBlockRenderTypes.setRenderLayer(ModBlocks.SOUL_SPROUTS.get(), RenderType.cutout());
            ItemBlockRenderTypes.setRenderLayer(ModBlocks.DEAD_ROOTS.get(), RenderType.cutout());
            ItemBlockRenderTypes.setRenderLayer(ModBlocks.POTTED_DEAD_ROOTS.get(), RenderType.cutout());
            ItemBlockRenderTypes.setRenderLayer(ModBlocks.ASH_ROOT.get(), RenderType.cutout());
            ItemBlockRenderTypes.setRenderLayer(ModBlocks.WARPED_SOUL_BERRY.get(), RenderType.cutout());
            ItemBlockRenderTypes.setRenderLayer(ModBlocks.CRIMSON_FIRE_BERRY.get(), RenderType.cutout());
            ItemBlockRenderTypes.setRenderLayer(ModBlocks.BLOSSOMING_ROOT.get(), RenderType.cutout());
            ItemBlockRenderTypes.setRenderLayer(ModBlocks.POTTED_BLOSSOMING_ROOT.get(), RenderType.cutout());
            ItemBlockRenderTypes.setRenderLayer(ModBlocks.ENDER_ROOT.get(), RenderType.cutout());
            ItemBlockRenderTypes.setRenderLayer(ModBlocks.POTTED_ENDER_ROOT.get(), RenderType.cutout());
            ItemBlockRenderTypes.setRenderLayer(ModBlocks.ENDER_SPROUTS.get(), RenderType.cutout());
            ItemBlockRenderTypes.setRenderLayer(ModBlocks.CRYSTALLIZED_HONEY_LAMP.get(), RenderType.translucent());
            ItemBlockRenderTypes.setRenderLayer(ModBlocks.CRYSTALLIZED_GLASS.get(), RenderType.translucent());
            ItemBlockRenderTypes.setRenderLayer(ModBlocks.WHITE_CRYSTALLIZED_GLASS.get(), RenderType.translucent());
            ItemBlockRenderTypes.setRenderLayer(ModBlocks.ORANGE_CRYSTALLIZED_GLASS.get(), RenderType.translucent());
            ItemBlockRenderTypes.setRenderLayer(ModBlocks.MAGENTA_CRYSTALLIZED_GLASS.get(), RenderType.translucent());
            ItemBlockRenderTypes.setRenderLayer(ModBlocks.LIGHT_BLUE_CRYSTALLIZED_GLASS.get(), RenderType.translucent());
            ItemBlockRenderTypes.setRenderLayer(ModBlocks.YELLOW_CRYSTALLIZED_GLASS.get(), RenderType.translucent());
            ItemBlockRenderTypes.setRenderLayer(ModBlocks.LIME_CRYSTALLIZED_GLASS.get(), RenderType.translucent());
            ItemBlockRenderTypes.setRenderLayer(ModBlocks.PINK_CRYSTALLIZED_GLASS.get(), RenderType.translucent());
            ItemBlockRenderTypes.setRenderLayer(ModBlocks.GRAY_CRYSTALLIZED_GLASS.get(), RenderType.translucent());
            ItemBlockRenderTypes.setRenderLayer(ModBlocks.LIGHT_GRAY_CRYSTALLIZED_GLASS.get(), RenderType.translucent());
            ItemBlockRenderTypes.setRenderLayer(ModBlocks.CYAN_CRYSTALLIZED_GLASS.get(), RenderType.translucent());
            ItemBlockRenderTypes.setRenderLayer(ModBlocks.PURPLE_CRYSTALLIZED_GLASS.get(), RenderType.translucent());
            ItemBlockRenderTypes.setRenderLayer(ModBlocks.BLUE_CRYSTALLIZED_GLASS.get(), RenderType.translucent());
            ItemBlockRenderTypes.setRenderLayer(ModBlocks.BROWN_CRYSTALLIZED_GLASS.get(), RenderType.translucent());
            ItemBlockRenderTypes.setRenderLayer(ModBlocks.GREEN_CRYSTALLIZED_GLASS.get(), RenderType.translucent());
            ItemBlockRenderTypes.setRenderLayer(ModBlocks.RED_CRYSTALLIZED_GLASS.get(), RenderType.translucent());
            ItemBlockRenderTypes.setRenderLayer(ModBlocks.BLACK_CRYSTALLIZED_GLASS.get(), RenderType.translucent());
            /*
            ItemBlockRenderTypes.setRenderLayer(ModBlocks.CRYSTALLIZED_GLASS_PANE.get(), RenderType.translucent());
            ItemBlockRenderTypes.setRenderLayer(ModBlocks.WHITE_CRYSTALLIZED_GLASS_PANE.get(), RenderType.translucent());
            ItemBlockRenderTypes.setRenderLayer(ModBlocks.ORANGE_CRYSTALLIZED_GLASS_PANE.get(), RenderType.translucent());
            ItemBlockRenderTypes.setRenderLayer(ModBlocks.MAGENTA_CRYSTALLIZED_GLASS_PANE.get(), RenderType.translucent());
            ItemBlockRenderTypes.setRenderLayer(ModBlocks.LIGHT_BLUE_CRYSTALLIZED_GLASS_PANE.get(), RenderType.translucent());
            ItemBlockRenderTypes.setRenderLayer(ModBlocks.YELLOW_CRYSTALLIZED_GLASS_PANE.get(), RenderType.translucent());
            ItemBlockRenderTypes.setRenderLayer(ModBlocks.LIME_CRYSTALLIZED_GLASS_PANE.get(), RenderType.translucent());
            ItemBlockRenderTypes.setRenderLayer(ModBlocks.PINK_CRYSTALLIZED_GLASS_PANE.get(), RenderType.translucent());
            ItemBlockRenderTypes.setRenderLayer(ModBlocks.GRAY_CRYSTALLIZED_GLASS_PANE.get(), RenderType.translucent());
            ItemBlockRenderTypes.setRenderLayer(ModBlocks.LIGHT_GRAY_CRYSTALLIZED_GLASS_PANE.get(), RenderType.translucent());
            ItemBlockRenderTypes.setRenderLayer(ModBlocks.CYAN_CRYSTALLIZED_GLASS_PANE.get(), RenderType.translucent());
            ItemBlockRenderTypes.setRenderLayer(ModBlocks.PURPLE_CRYSTALLIZED_GLASS_PANE.get(), RenderType.translucent());
            ItemBlockRenderTypes.setRenderLayer(ModBlocks.BLUE_CRYSTALLIZED_GLASS_PANE.get(), RenderType.translucent());
            ItemBlockRenderTypes.setRenderLayer(ModBlocks.BROWN_CRYSTALLIZED_GLASS_PANE.get(), RenderType.translucent());
            ItemBlockRenderTypes.setRenderLayer(ModBlocks.GREEN_CRYSTALLIZED_GLASS_PANE.get(), RenderType.translucent());
            ItemBlockRenderTypes.setRenderLayer(ModBlocks.RED_CRYSTALLIZED_GLASS_PANE.get(), RenderType.translucent());
            ItemBlockRenderTypes.setRenderLayer(ModBlocks.BLACK_CRYSTALLIZED_GLASS_PANE.get(), RenderType.translucent());

             */
        });

        MenuScreens.register(MenuTypes.CRYSTALLIZER_MENU.get(), CrystallizerScreen::new);
    }

    private void enqueueIMC(final InterModEnqueueEvent event)
    {
        // some example code to dispatch IMC to another mod
        InterModComms.sendTo("vavs", "helloworld", () -> { LOGGER.info("Hello world from the MDK"); return "Hello world";});
    }

    private void processIMC(final InterModProcessEvent event)
    {
    }
    // You can use SubscribeEvent and let the Event Bus discover methods to call

    @Mod.EventBusSubscriber(bus=Mod.EventBusSubscriber.Bus.MOD)
    public static class RegistryEvents {
        @SubscribeEvent
        public static void onBlocksRegistry(final RegistryEvent.Register<Block> blockRegistryEvent) {
            LOGGER.info("HELLO from Register Block");
        }
    }
}

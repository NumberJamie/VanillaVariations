package com.nrjam.vavs.enchantments.events;

import com.nrjam.vavs.VanillaVariations;
import com.nrjam.vavs.enchantments.Scorching;
import net.minecraft.client.model.EntityModel;
import net.minecraft.commands.arguments.EntityAnchorArgument;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.entity.*;
import net.minecraft.world.entity.monster.EnderMan;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Items;
import net.minecraft.world.level.pathfinder.Target;
import net.minecraft.world.level.storage.loot.BuiltInLootTables;
import net.minecraft.world.level.storage.loot.LootPool;
import net.minecraft.world.level.storage.loot.LootTables;
import net.minecraft.world.level.storage.loot.functions.LootItemFunction;
import net.minecraft.world.level.storage.loot.predicates.ConditionUserBuilder;
import net.minecraft.world.level.storage.loot.predicates.LootItemCondition;
import net.minecraftforge.accesstransformer.TargetType;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.event.LootTableLoadEvent;
import net.minecraftforge.event.entity.living.LivingAttackEvent;
import net.minecraftforge.event.entity.living.LivingSetAttackTargetEvent;
import net.minecraftforge.event.world.BlockEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

@Mod.EventBusSubscriber(modid = VanillaVariations.MOD_ID, bus = Mod.EventBusSubscriber.Bus.FORGE, value = Dist.CLIENT)
public class EventHandler {

    @SubscribeEvent
    public static void noCropTrample(BlockEvent.FarmlandTrampleEvent event){
        if (Scorching.hasScoring((LivingEntity) event.getEntity())) {
            event.setCanceled(true);
        }
    }

    @SubscribeEvent
    public static void noMagmaDamage(LivingAttackEvent event){
        if (event.getSource() == DamageSource.HOT_FLOOR && Scorching.hasScoring((LivingEntity) event.getEntity()) || event.getSource() == DamageSource.CACTUS && Scorching.hasScoring((LivingEntity) event.getEntity()) || event.getSource() == DamageSource.SWEET_BERRY_BUSH && Scorching.hasScoring((LivingEntity) event.getEntity())) {
            event.setCanceled(true);
        }
    }
}

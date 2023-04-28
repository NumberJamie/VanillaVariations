package net.nrjam.vavs.item.custom;

import com.google.common.collect.ImmutableMap;
import net.minecraft.ChatFormatting;
import net.minecraft.network.chat.Component;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ArmorItem;
import net.minecraft.world.item.ArmorMaterial;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.TooltipFlag;
import net.minecraft.world.level.Level;
import net.nrjam.vavs.item.ModArmorMaterials;

import javax.annotation.Nullable;
import java.util.List;
import java.util.Map;

public class FusedSoulItem extends ArmorItem {
    private static final Map<ArmorMaterial, MobEffectInstance> MATERIAL_TO_EFFECT_MAP =
            (new ImmutableMap.Builder<ArmorMaterial, MobEffectInstance>())
                    .put(ModArmorMaterials.FUSED_SOUL,
                            new MobEffectInstance(MobEffects.WITHER, 200, 1)).build();

    public FusedSoulItem(ArmorMaterial material, Type slot, Properties settings) {
        super(material, slot, settings);
    }

    @Override
    public boolean makesPiglinsNeutral(ItemStack stack, LivingEntity wearer) {
        return super.makesPiglinsNeutral(stack, wearer);
    }

    @Override
    public void appendHoverText(ItemStack stack, @Nullable Level lvl, List<Component> comp, TooltipFlag flag) {
        super.appendHoverText(stack, lvl, comp, flag);
        comp.add(Component.translatable("tooltip.vavs.fused_soul").withStyle(ChatFormatting.GRAY));
    }

    @Override
    public void onArmorTick(ItemStack stack, Level world, Player player) {
        if(!world.isClientSide()) {
            if(hasFullSuitOfArmorOn(player)) {
                evaluateArmorEffects(player);
            }
        }
    }

    private void evaluateArmorEffects(Player player) {
        for (Map.Entry<ArmorMaterial, MobEffectInstance> entry : MATERIAL_TO_EFFECT_MAP.entrySet()) {
            ArmorMaterial mapArmorMaterial = entry.getKey();
            MobEffectInstance mapStatusEffect = entry.getValue();

            if(hasCorrectArmorOn(mapArmorMaterial, player)) {
                removeStatusEffectForMaterial(player, mapArmorMaterial, mapStatusEffect);
            }
        }
    }

    private void removeStatusEffectForMaterial(Player player, ArmorMaterial mapArmorMaterial,
                                               MobEffectInstance mapStatusEffect) {
        boolean hasPlayerEffect = player.hasEffect(mapStatusEffect.getEffect());

        if(hasCorrectArmorOn(mapArmorMaterial, player) && hasPlayerEffect) {
            player.removeEffect(mapStatusEffect.getEffect());
        }
    }

    private boolean hasFullSuitOfArmorOn(Player player) {
        ItemStack boots = player.getInventory().getArmor(0);
        ItemStack leggings = player.getInventory().getArmor(1);
        ItemStack breastplate = player.getInventory().getArmor(2);
        ItemStack helmet = player.getInventory().getArmor(3);

        return !helmet.isEmpty() && !breastplate.isEmpty()
                && !leggings.isEmpty() && !boots.isEmpty();
    }

    private boolean hasCorrectArmorOn(ArmorMaterial material, Player player) {
        ArmorItem boots = ((ArmorItem)player.getInventory().getArmor(0).getItem());
        ArmorItem leggings = ((ArmorItem)player.getInventory().getArmor(1).getItem());
        ArmorItem breastplate = ((ArmorItem)player.getInventory().getArmor(2).getItem());
        ArmorItem helmet = ((ArmorItem)player.getInventory().getArmor(3).getItem());

        return helmet.getMaterial() == material && breastplate.getMaterial() == material &&
                leggings.getMaterial() == material && boots.getMaterial() == material;
    }
}

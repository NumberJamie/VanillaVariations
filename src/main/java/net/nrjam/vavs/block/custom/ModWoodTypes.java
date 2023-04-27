package net.nrjam.vavs.block.custom;

import net.minecraft.world.level.block.state.properties.BlockSetType;
import net.minecraft.world.level.block.state.properties.WoodType;
import net.nrjam.vavs.VanillaVariations;

public class ModWoodTypes {
    public static final BlockSetType WALNUT_BLOCK_SET = new BlockSetType(VanillaVariations.MOD_ID + ":walnut");
    public static final WoodType WALNUT = new WoodType(VanillaVariations.MOD_ID + ":walnut", WALNUT_BLOCK_SET);
}
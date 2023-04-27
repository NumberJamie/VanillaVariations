package net.nrjam.vavs.worldgen.tree;

import net.minecraft.resources.ResourceKey;
import net.minecraft.util.RandomSource;
import net.minecraft.world.level.block.grower.AbstractTreeGrower;
import net.minecraft.world.level.levelgen.feature.ConfiguredFeature;
import net.nrjam.vavs.worldgen.ModConfiguredFeatures;
import org.jetbrains.annotations.NotNull;

import javax.annotation.Nullable;

public class WalnutTreeGrower extends AbstractTreeGrower {
    @Nullable
    @Override
    protected ResourceKey<ConfiguredFeature<?, ?>> getConfiguredFeature(@NotNull RandomSource p_222910_, boolean p_222911_) {
        return ModConfiguredFeatures.WALNUT_KEY;
    }
}

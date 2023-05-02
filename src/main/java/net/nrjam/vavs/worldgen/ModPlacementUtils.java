package net.nrjam.vavs.worldgen;

import net.minecraft.world.level.levelgen.placement.*;

import java.util.List;

public class ModPlacementUtils {
    public static List<PlacementModifier> placement(PlacementModifier p_195347_, PlacementModifier p_195348_) {
        return List.of(p_195347_, InSquarePlacement.spread(), p_195348_, BiomeFilter.biome());
    }

    public static List<PlacementModifier> endSoilPlaced(int p_195344_, PlacementModifier p_195345_) {
        return placement(CountPlacement.of(p_195344_), p_195345_);
    }

    public static List<PlacementModifier> commonOrePlacement(int p_195344_, PlacementModifier p_195345_) {
        return placement(CountPlacement.of(p_195344_), p_195345_);
    }

    public static List<PlacementModifier> rareOrePlacement(int p_195350_, PlacementModifier p_195351_) {
        return placement(RarityFilter.onAverageOnceEvery(p_195350_), p_195351_);
    }
}

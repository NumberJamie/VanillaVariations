package net.nrjam.vavs.worldgen;

import net.minecraft.world.level.levelgen.placement.*;

import java.util.List;

public class ModPlacementUtils {
    public static List<PlacementModifier> placement(PlacementModifier modifier, PlacementModifier modifier2) {
        return List.of(modifier, InSquarePlacement.spread(), modifier2, BiomeFilter.biome());
    }

    public static List<PlacementModifier> endSoilPlaced(int count, PlacementModifier amount) {
        return placement(CountPlacement.of(count), amount);
    }

    public static List<PlacementModifier> commonOrePlacement(int count, PlacementModifier amount) {
        return placement(CountPlacement.of(count), amount);
    }

    public static List<PlacementModifier> rareOrePlacement(int count, PlacementModifier amount) {
        return placement(RarityFilter.onAverageOnceEvery(count), amount);
    }
}

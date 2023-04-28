package net.nrjam.vavs.worldgen;

import net.minecraft.world.level.levelgen.placement.BiomeFilter;
import net.minecraft.world.level.levelgen.placement.CountPlacement;
import net.minecraft.world.level.levelgen.placement.InSquarePlacement;
import net.minecraft.world.level.levelgen.placement.PlacementModifier;

import java.util.List;

public class ModPlacementUtils {
    public static List<PlacementModifier> soilPlacement(PlacementModifier p_195347_, PlacementModifier p_195348_) {
        return List.of(p_195347_, InSquarePlacement.spread(), p_195348_, BiomeFilter.biome());
    }

    public static List<PlacementModifier> endSoilPlaced(int p_195344_, PlacementModifier p_195345_) {
        return soilPlacement(CountPlacement.of(p_195344_), p_195345_);
    }
}

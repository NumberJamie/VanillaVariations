package net.nrjam.vavs.datagen.tags;

import net.minecraft.core.registries.Registries;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.TagKey;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import net.nrjam.vavs.VanillaVariations;

public class ModTags {
    public static class Blocks {
        public static final TagKey<Block> WALNUT_LOGS = tag("walnut_logs");
        public static final TagKey<Block> SOUL_STONES = tag("soul_stones");

        private static TagKey<Block> tag(String name) {
            return TagKey.create(Registries.BLOCK, new ResourceLocation(VanillaVariations.MOD_ID, name));
        }
    }

    public static class Items {
        public static final TagKey<Item> WALNUT_LOGS = tag("walnut_logs");

        private static TagKey<Item> tag(String name) {
            return TagKey.create(Registries.ITEM, new ResourceLocation(VanillaVariations.MOD_ID, name));
        }
    }
}

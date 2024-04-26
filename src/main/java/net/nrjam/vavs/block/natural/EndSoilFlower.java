package net.nrjam.vavs.block.natural;

import net.minecraft.core.BlockPos;
import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.LevelReader;
import net.minecraft.world.level.block.FlowerBlock;
import net.minecraft.world.level.block.state.BlockState;
import net.nrjam.vavs.block.ModBlocks;
import net.nrjam.vavs.datagen.tags.ModTags;
import org.jetbrains.annotations.NotNull;

import java.util.function.Supplier;

public class EndSoilFlower extends FlowerBlock {
    public EndSoilFlower(Supplier<MobEffect> effect, int duration, Properties properties) {
        super(effect, duration, properties);
    }

    @Override
    public boolean canSurvive(BlockState state, @NotNull LevelReader lvl, @NotNull BlockPos pos) {
        if (state.getBlock() == this) return lvl.getBlockState(pos).is(ModBlocks.END_SOIL.get());
        return this.mayPlaceOn(lvl.getBlockState(pos), lvl, pos);
    }

    @Override
    public boolean mayPlaceOn(BlockState state, @NotNull BlockGetter get, @NotNull BlockPos pos) {
        return state.is(ModTags.Blocks.END_FLOWER_PLACEABLE);
    }
}

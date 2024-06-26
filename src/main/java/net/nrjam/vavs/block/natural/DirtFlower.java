package net.nrjam.vavs.block.natural;

import net.minecraft.core.BlockPos;
import net.minecraft.tags.BlockTags;
import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.LevelReader;
import net.minecraft.world.level.block.FlowerBlock;
import net.minecraft.world.level.block.state.BlockState;
import org.jetbrains.annotations.NotNull;

import java.util.function.Supplier;


public class DirtFlower extends FlowerBlock {
    public DirtFlower(Supplier<MobEffect> effect, int duration, Properties properties) {
        super(effect, duration, properties);
    }

    @Override
    public boolean canSurvive(@NotNull BlockState state, @NotNull LevelReader lvl, BlockPos pos) {
        BlockPos blockpos = pos.below();
        return this.mayPlaceOn(lvl.getBlockState(blockpos), lvl, blockpos);
    }

    @Override
    public boolean mayPlaceOn(BlockState state, @NotNull BlockGetter get, @NotNull BlockPos pos) {
        return state.is(BlockTags.DIRT);
    }
}
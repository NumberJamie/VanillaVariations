package net.nrjam.vavs.block.natural;

import net.minecraft.core.BlockPos;
import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.LevelReader;
import net.minecraft.world.level.block.FlowerBlock;
import net.minecraft.world.level.block.state.BlockState;
import net.nrjam.vavs.datagen.tags.ModTags;
import org.jetbrains.annotations.NotNull;

import java.util.function.Supplier;

public class NetherFlower extends FlowerBlock {
    public NetherFlower(Supplier<MobEffect> effect, int duration, Properties properties) {
        super(effect, duration, properties);
    }

    @Override
    public boolean canSurvive(@NotNull BlockState state, @NotNull LevelReader lvl, @NotNull BlockPos pos) {
        BlockPos blockPos = pos.below();
        return this.mayPlaceOn(lvl.getBlockState(blockPos), lvl, blockPos);
    }

    @Override
    public boolean mayPlaceOn(BlockState state, @NotNull BlockGetter get, @NotNull BlockPos pos) {
        return state.is(ModTags.Blocks.NETHER_FLOWER_PLACEABLE);
    }
}
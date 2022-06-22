package com.nrjam.vavs.block.custom.CropsAndFlowers;

import net.minecraft.core.BlockPos;
import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.LevelReader;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.FlowerBlock;
import net.minecraft.world.level.block.state.BlockState;

public class NetherRackFlower extends FlowerBlock {
    public NetherRackFlower(MobEffect p_53512_, int p_53513_, Properties p_53514_) {
        super(p_53512_, p_53513_, p_53514_);
    }

    @Override
    public boolean canSurvive(BlockState state, LevelReader lvl, BlockPos pos) {
        BlockPos blockpos = pos.below();
        return this.mayPlaceOn(lvl.getBlockState(blockpos), lvl, blockpos);
    }

    @Override
    public boolean mayPlaceOn(BlockState state, BlockGetter get, BlockPos pos) {
        return state.is(Blocks.NETHERRACK);
    }
}

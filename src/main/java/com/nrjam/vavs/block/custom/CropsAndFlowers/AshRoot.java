package com.nrjam.vavs.block.custom.CropsAndFlowers;

import com.nrjam.vavs.block.ModBlocks;
import com.nrjam.vavs.item.Items;
import net.minecraft.core.BlockPos;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.ItemLike;
import net.minecraft.world.level.LevelReader;
import net.minecraft.world.level.block.BeetrootBlock;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.phys.shapes.CollisionContext;
import net.minecraft.world.phys.shapes.VoxelShape;

public class AshRoot extends BeetrootBlock {
    private static final VoxelShape[] SHAPES = new VoxelShape[]{Block.box(0.0D, 0.0D, 0.0D, 16.0D, 2.0D, 16.0D), Block.box(0.0D, 0.0D, 0.0D, 16.0D, 4.0D, 16.0D), Block.box(0.0D, 0.0D, 0.0D, 16.0D, 6.0D, 16.0D), Block.box(0.0D, 0.0D, 0.0D, 16.0D, 9.0D, 16.0D)};

    public AshRoot(Properties builder) {
        super(builder);
    }

    @Override
    protected ItemLike getBaseSeedId() {
        return Items.ASH_ROOT.get();
    }

    @Override
    public VoxelShape getShape(BlockState state, BlockGetter getter, BlockPos pos, CollisionContext context) {
        return SHAPES[state.getValue(this.getAgeProperty())];
    }

    @Override
    public boolean mayPlaceOn(BlockState state, BlockGetter get, BlockPos pos) {
        return state.is(ModBlocks.NETHER_FARMLAND.get());
    }

    @Override
    public boolean canSurvive(BlockState state, LevelReader lvl, BlockPos pos) {
        BlockPos blockpos = pos.below();
        return this.mayPlaceOn(lvl.getBlockState(blockpos), lvl, blockpos);
    }
}

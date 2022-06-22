package com.nrjam.vavs.block.custom.CropsAndFlowers;

import com.nrjam.vavs.block.ModBlocks;
import com.nrjam.vavs.item.Items;
import net.minecraft.core.BlockPos;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.ItemLike;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.LevelReader;
import net.minecraft.world.level.block.BeetrootBlock;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.phys.shapes.CollisionContext;
import net.minecraft.world.phys.shapes.VoxelShape;

import java.util.Random;

public class EnderSprout extends BeetrootBlock {
    private static final VoxelShape[] SHAPES = new VoxelShape[]{Block.box(0.0D, 0.0D, 0.0D, 16.0D, 2.0D, 16.0D), Block.box(0.0D, 0.0D, 0.0D, 16.0D, 4.0D, 16.0D), Block.box(0.0D, 0.0D, 0.0D, 16.0D, 6.0D, 16.0D), Block.box(0.0D, 0.0D, 0.0D, 16.0D, 9.0D, 16.0D)};

    public EnderSprout(Properties builder) {
        super(builder);
    }

    @Override
    public void animateTick(BlockState state, Level lvl, BlockPos pos, Random rand) {
        float chance = 0.95f;
        if(chance < rand.nextFloat()) {
            lvl.addParticle(ParticleTypes.DRAGON_BREATH, pos.getX() + rand.nextDouble(),
                    pos.getY() + 0.1D, pos.getZ() + rand.nextDouble(),
                    0d,0.02d,0d);

            lvl.addParticle(ParticleTypes.DRAGON_BREATH, pos.getX() + rand.nextDouble(),
                    pos.getY() + 0.1D, pos.getZ() + rand.nextDouble(),
                    0.0D, 0.02D, 0.0D);
        }

        super.animateTick(state, lvl, pos, rand);
    }

    @Override
    protected ItemLike getBaseSeedId() {
        return Items.ENDER_SPROUT.get();
    }

    @Override
    public VoxelShape getShape(BlockState state, BlockGetter getter, BlockPos pos, CollisionContext context) {
        return SHAPES[state.getValue(this.getAgeProperty())];
    }

    @Override
    public boolean mayPlaceOn(BlockState state, BlockGetter get, BlockPos pos) {
        return state.is(ModBlocks.END_FARMLAND.get());
    }

    @Override
    public boolean canSurvive(BlockState state, LevelReader lvl, BlockPos pos) {
        BlockPos blockpos = pos.below();
        return this.mayPlaceOn(lvl.getBlockState(blockpos), lvl, blockpos);
    }
}

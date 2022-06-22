package com.nrjam.vavs.block.custom.Copper;

import com.google.common.base.Suppliers;
import com.google.common.collect.BiMap;
import com.google.common.collect.ImmutableBiMap;
import com.nrjam.vavs.block.ModBlocks;
import net.minecraft.core.BlockPos;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.ChangeOverTimeBlock;
import net.minecraft.world.level.block.WeatheringCopper;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.properties.BlockStateProperties;
import net.minecraft.world.level.block.state.properties.DoubleBlockHalf;
import net.minecraft.world.level.block.state.properties.EnumProperty;
import net.minecraft.world.level.block.state.properties.Property;

import java.util.Objects;
import java.util.Optional;
import java.util.Random;
import java.util.function.Supplier;

public interface CopperDoorLogic extends ChangeOverTimeBlock<WeatheringCopper.WeatherState> {
    Supplier<BiMap<Block, Block>> NEXT_BY_BLOCK = Suppliers.memoize(() -> ImmutableBiMap.<Block, Block>builder().put(ModBlocks.COPPER_DOOR.get(), ModBlocks.EXPOSED_COPPER_DOOR.get()).put(ModBlocks.EXPOSED_COPPER_DOOR.get(), ModBlocks.WEATHERED_COPPER_DOOR.get()).put(ModBlocks.WEATHERED_COPPER_DOOR.get(), ModBlocks.OXIDIZED_COPPER_DOOR.get()).build());
    Supplier<BiMap<Block, Block>> PREVIOUS_BY_BLOCK = Suppliers.memoize(() -> Objects.requireNonNull(NEXT_BY_BLOCK.get()).inverse());

    static Optional<Block> getPrevious(Block p_154891_) {
        return Optional.ofNullable(PREVIOUS_BY_BLOCK.get().get(p_154891_));
    }

    default void onRandomTick(BlockState p_153042_, ServerLevel p_153043_, BlockPos p_153044_, Random p_153045_) {
        float f = 0.05688889F;
        if (p_153045_.nextFloat() < 0.05688889F) {
            this.applyChangeOverTime(p_153042_, p_153043_, p_153044_, p_153045_);
        }

    }

    default void applyChangeOverTime(BlockState p_153047_, ServerLevel p_153048_, BlockPos p_153049_, Random p_153050_) {
        int i = this.getAge().ordinal();
        int j = 0;
        int k = 0;

        for(BlockPos blockpos : BlockPos.withinManhattan(p_153049_, 4, 4, 4)) {
            int l = blockpos.distManhattan(p_153049_);
            if (l > 4) {
                break;
            }

            if (!blockpos.equals(p_153049_)) {
                BlockState blockstate = p_153048_.getBlockState(blockpos);
                Block block = blockstate.getBlock();
                if (block instanceof net.minecraft.world.level.block.ChangeOverTimeBlock) {
                    Enum<?> oenum = ((net.minecraft.world.level.block.ChangeOverTimeBlock)block).getAge();
                    if (this.getAge().getClass() == oenum.getClass()) {
                        int i1 = oenum.ordinal();
                        if (i1 < i) {
                            return;
                        }

                        if (i1 > i) {
                            ++k;
                        } else {
                            ++j;
                        }
                    }
                }
            }
        }

        float f = (float)(k + 1) / (float)(k + j + 1);
        float f1 = f * f * this.getChanceModifier();
        if (p_153050_.nextFloat() < f1) {
            this.getNext(p_153047_).ifPresent((p_153039_) -> {
                Property<DoubleBlockHalf> HALF2 = BlockStateProperties.DOUBLE_BLOCK_HALF;
                p_153048_.setBlockAndUpdate(p_153049_.above(), Blocks.AIR.defaultBlockState());
                p_153048_.setBlockAndUpdate(p_153049_, Blocks.AIR.defaultBlockState());
                p_153048_.setBlockAndUpdate(p_153049_.above(), p_153039_.setValue(HALF2, DoubleBlockHalf.UPPER));
                p_153048_.setBlock(p_153049_, p_153039_.setValue(HALF2, DoubleBlockHalf.LOWER), 512);
            });
        }

    }

    static Block getFirst(Block p_154898_) {
        Block block = p_154898_;

        for(Block block1 = PREVIOUS_BY_BLOCK.get().get(p_154898_); block1 != null; block1 = PREVIOUS_BY_BLOCK.get().get(block1)) {
            block = block1;
        }

        return block;
    }

    static Optional<BlockState> getPrevious(BlockState p_154900_) {
        return getPrevious(p_154900_.getBlock()).map((p_154903_) -> p_154903_.withPropertiesOf(p_154900_));
    }

    static Optional<Block> getNext(Block p_154905_) {
        return Optional.ofNullable(NEXT_BY_BLOCK.get().get(p_154905_));
    }

    static BlockState getFirst(BlockState p_154907_) {
        return getFirst(p_154907_.getBlock()).withPropertiesOf(p_154907_);
    }

    default Optional<BlockState> getNext(BlockState p_154893_) {
        return getNext(p_154893_.getBlock()).map((p_154896_) -> p_154896_.withPropertiesOf(p_154893_));
    }

    default float getChanceModifier() {
        return this.getAge() == WeatheringCopper.WeatherState.UNAFFECTED ? 0.75F : 1.0F;
    }
}

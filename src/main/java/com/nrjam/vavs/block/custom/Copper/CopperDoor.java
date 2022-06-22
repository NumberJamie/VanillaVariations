package com.nrjam.vavs.block.custom.Copper;

import net.minecraft.core.BlockPos;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.world.level.block.DoorBlock;
import net.minecraft.world.level.block.WeatheringCopper;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.properties.DoubleBlockHalf;

import java.util.Optional;
import java.util.Random;

public class CopperDoor extends DoorBlock implements CopperDoorLogic {
    private final WeatheringCopper.WeatherState weatherState;

    public CopperDoor(WeatheringCopper.WeatherState state, Properties properties) {
        super(properties);
        this.weatherState = state;
    }

    public void randomTick(BlockState state, ServerLevel lvl, BlockPos pos, Random ran) {
        DoubleBlockHalf doubleblockhalf = state.getValue(HALF);
        if (doubleblockhalf == DoubleBlockHalf.LOWER) {
            this.onRandomTick(state, lvl, pos, ran);
        }
    }

    @Override
    public boolean isRandomlyTicking(BlockState state) {
        return CopperDoorLogic.getNext(state.getBlock()).isPresent();
    }

    @Override
    public void onRandomTick(BlockState state, ServerLevel lvl, BlockPos pos, Random ran) {
            CopperDoorLogic.super.onRandomTick(state, lvl, pos, ran);
    }

    @Override
    public WeatheringCopper.WeatherState getAge() {
        return this.weatherState;
    }

    @Override
    public void applyChangeOverTime(BlockState state, ServerLevel lvl, BlockPos pos, Random ran) {
        DoubleBlockHalf doubleblockhalf = state.getValue(HALF);
        if (doubleblockhalf == DoubleBlockHalf.LOWER) {
            CopperDoorLogic.super.applyChangeOverTime(state, lvl, pos, ran);
        }
    }

    @Override
    public Optional<BlockState> getNext(BlockState state) {
        return CopperDoorLogic.super.getNext(state);
    }

    @Override
    public float getChanceModifier() {
        return CopperDoorLogic.super.getChanceModifier();
    }
}
package com.nrjam.vavs.block.custom.Copper;

import net.minecraft.core.BlockPos;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.world.level.block.TrapDoorBlock;
import net.minecraft.world.level.block.WeatheringCopper;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.state.BlockState;

import java.util.Optional;
import java.util.Random;

public class CopperTrapdoor extends TrapDoorBlock implements CopperTrapdoorLogic {
    private final WeatheringCopper.WeatherState weatherState;

    public CopperTrapdoor(WeatheringCopper.WeatherState p_154925_, BlockBehaviour.Properties p_154926_) {
        super(p_154926_);
        this.weatherState = p_154925_;
    }

    @Override
    public void randomTick(BlockState p_154929_, ServerLevel p_154930_, BlockPos p_154931_, Random p_154932_) {
        this.onRandomTick(p_154929_, p_154930_, p_154931_, p_154932_);
    }

    @Override
    public boolean isRandomlyTicking(BlockState p_154935_) {
        return CopperTrapdoorLogic.getNext(p_154935_.getBlock()).isPresent();
    }

    @Override
    public void onRandomTick(BlockState p_153042_, ServerLevel p_153043_, BlockPos p_153044_, Random p_153045_) {
        CopperTrapdoorLogic.super.onRandomTick(p_153042_, p_153043_, p_153044_, p_153045_);
    }

    @Override
    public WeatheringCopper.WeatherState getAge() {
        return this.weatherState;
    }

    @Override
    public void applyChangeOverTime(BlockState p_153047_, ServerLevel p_153048_, BlockPos p_153049_, Random p_153050_) {
        CopperTrapdoorLogic.super.applyChangeOverTime(p_153047_, p_153048_, p_153049_, p_153050_);
    }

    @Override
    public Optional<BlockState> getNext(BlockState p_154893_) {
        return CopperTrapdoorLogic.super.getNext(p_154893_);
    }

    @Override
    public float getChanceModifier() {
        return CopperTrapdoorLogic.super.getChanceModifier();
    }
}
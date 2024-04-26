package net.nrjam.vavs.block.natural;

import net.minecraft.core.BlockPos;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.util.RandomSource;
import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.state.BlockState;
import org.jetbrains.annotations.NotNull;

import java.util.function.Supplier;


public class SoulSoilFlower extends NetherFlower {
    public SoulSoilFlower(Supplier<MobEffect> effect, int duration, Properties properties) {
        super(effect, duration, properties);
    }

    @Override
    public void animateTick(@NotNull BlockState state, @NotNull Level lvl, @NotNull BlockPos pos, RandomSource rand) {
        float chance = 0.90f;
        if(chance < rand.nextFloat()) {
            lvl.addParticle(ParticleTypes.SOUL, pos.getX() + rand.nextDouble(),
                    pos.getY() + 0.5D, pos.getZ() + rand.nextDouble(),
                    0d,0.05d,0d);

            lvl.addParticle(ParticleTypes.SOUL, pos.getX() + rand.nextDouble(),
                    pos.getY() + 0.5D, pos.getZ() + rand.nextDouble(),
                    0.0D, 0.05D, 0.0D);
        }
        super.animateTick(state, lvl, pos, rand);
    }
}
package net.nrjam.vavs.entity;

import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.MobCategory;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;
import net.nrjam.vavs.VanillaVariations;
import net.nrjam.vavs.entity.custom.SquirrelEntity;

public class ModEntities {
    public static final DeferredRegister<EntityType<?>> ENTITY_TYPES = DeferredRegister.create(ForgeRegistries.ENTITY_TYPES, VanillaVariations.MOD_ID);

    public static final RegistryObject<EntityType<SquirrelEntity>> SQUIRREL =
            ENTITY_TYPES.register("squirrel", () -> EntityType.Builder.of(SquirrelEntity::new, MobCategory.CREATURE)
                    .sized(1f, 1f).build("squirrel"));

    public static void register(IEventBus eventBus){
        ENTITY_TYPES.register(eventBus);
    }
}

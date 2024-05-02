package net.nrjam.vavs.entity.client;

import com.mojang.blaze3d.vertex.PoseStack;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.resources.ResourceLocation;
import net.nrjam.vavs.VanillaVariations;
import net.nrjam.vavs.entity.custom.SquirrelEntity;
import org.jetbrains.annotations.NotNull;

public class SquirrelRenderer extends MobRenderer<SquirrelEntity, SquirrelModel<SquirrelEntity>> {
    public SquirrelRenderer(EntityRendererProvider.Context pContext) {
        super(pContext, new SquirrelModel<>(pContext.bakeLayer(ModModelLayers.SQUIRREL_LAYER)), 2f);
    }

    @Override
    public @NotNull ResourceLocation getTextureLocation(@NotNull SquirrelEntity pEntity) {
        return new ResourceLocation(VanillaVariations.MOD_ID, "textures/entity/squirrel.png");
    }

    @Override
    public void render(SquirrelEntity entity, float yaw, float ticks, @NotNull PoseStack stack, @NotNull MultiBufferSource buf, int light) {
        if(entity.isBaby()) {
            stack.scale(0.5f, 0.5f, 0.5f);
        }

        super.render(entity, yaw, ticks, stack, buf, light);
    }
}

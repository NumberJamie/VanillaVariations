package net.nrjam.vavs.entity.client;


import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.vertex.VertexConsumer;
import net.minecraft.client.model.HierarchicalModel;
import net.minecraft.client.model.geom.ModelPart;
import net.minecraft.client.model.geom.PartPose;
import net.minecraft.client.model.geom.builders.*;
import net.minecraft.world.entity.Entity;
import org.jetbrains.annotations.NotNull;

public class SquirrelModel<T extends Entity> extends HierarchicalModel<T> {
	private final ModelPart squirrel;

	public SquirrelModel(ModelPart root) {
		this.squirrel = root.getChild("squirrel");
	}

	public static LayerDefinition createBodyLayer() {
		MeshDefinition meshdefinition = new MeshDefinition();
		PartDefinition partdefinition = meshdefinition.getRoot();

		PartDefinition squirrel = partdefinition.addOrReplaceChild("squirrel", CubeListBuilder.create(), PartPose.offset(0.0F, 24.0F, 0.0F));

		PartDefinition body = squirrel.addOrReplaceChild("body", CubeListBuilder.create(), PartPose.offset(0.0F, -4.0F, 4.0F));

		PartDefinition head = body.addOrReplaceChild("head", CubeListBuilder.create().texOffs(14, 12).addBox(-2.0F, -3.0F, -4.0F, 4.0F, 4.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 0.0F, -7.0F));

		PartDefinition snout = head.addOrReplaceChild("snout", CubeListBuilder.create().texOffs(12, 20).addBox(-1.5F, -1.0F, -1.0F, 3.0F, 2.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 0.0F, -4.5F));

		PartDefinition left_ear = head.addOrReplaceChild("left_ear", CubeListBuilder.create().texOffs(24, 4).addBox(-0.5F, -1.5F, -1.0F, 1.0F, 2.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offset(2.0F, -3.0F, -1.5F));

		PartDefinition right_ear = head.addOrReplaceChild("right_ear", CubeListBuilder.create().texOffs(24, 8).addBox(-0.5F, -1.5F, -1.0F, 1.0F, 2.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offset(-2.0F, -3.0F, -1.5F));

		PartDefinition torso = body.addOrReplaceChild("torso", CubeListBuilder.create().texOffs(0, 0).addBox(-2.0F, -3.0F, -7.0F, 4.0F, 4.0F, 8.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 0.0F, 0.0F));

		PartDefinition tail = torso.addOrReplaceChild("tail", CubeListBuilder.create().texOffs(0, 12).addBox(-1.0F, -6.25F, -0.75F, 2.0F, 5.0F, 5.0F, new CubeDeformation(0.0F))
				.texOffs(9, 12).addBox(-1.0F, -1.25F, -0.75F, 2.0F, 2.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, -0.75F, 1.25F));

		PartDefinition left_front_leg = body.addOrReplaceChild("left_front_leg", CubeListBuilder.create().texOffs(6, 22).addBox(-0.5F, -1.0F, -1.0F, 1.0F, 5.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offset(2.0F, 0.0F, -5.5F));

		PartDefinition right_front_leg = body.addOrReplaceChild("right_front_leg", CubeListBuilder.create().texOffs(0, 22).addBox(-0.5F, -1.0F, -1.0F, 1.0F, 5.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offset(-2.0F, 0.0F, -5.5F));

		PartDefinition right_back_leg = body.addOrReplaceChild("right_back_leg", CubeListBuilder.create().texOffs(16, 0).addBox(-0.5F, -1.5F, -1.5F, 1.0F, 5.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offset(-2.0F, -0.5F, 0.0F));

		PartDefinition right_foot = right_back_leg.addOrReplaceChild("right_foot", CubeListBuilder.create().texOffs(19, 21).addBox(-0.5F, 1.0F, -3.0F, 1.0F, 1.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 2.5F, -0.5F));

		PartDefinition left_back_leg = body.addOrReplaceChild("left_back_leg", CubeListBuilder.create().texOffs(0, 0).addBox(-0.5F, -1.5F, -1.5F, 1.0F, 5.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offset(2.0F, -0.5F, 0.0F));

		PartDefinition left_foot = left_back_leg.addOrReplaceChild("left_foot", CubeListBuilder.create().texOffs(24, 0).addBox(-0.5F, 1.0F, -4.0F, 1.0F, 1.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 2.5F, 0.5F));

		return LayerDefinition.create(meshdefinition, 32, 32);
	}

	@Override
	public void setupAnim(@NotNull T entity, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch) {

	}

	@Override
	public void renderToBuffer(@NotNull PoseStack poseStack, @NotNull VertexConsumer vertexConsumer, int packedLight, int packedOverlay, float red, float green, float blue, float alpha) {
		squirrel.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
	}

	@Override
	public @NotNull ModelPart root() {
		return squirrel;
	}
}
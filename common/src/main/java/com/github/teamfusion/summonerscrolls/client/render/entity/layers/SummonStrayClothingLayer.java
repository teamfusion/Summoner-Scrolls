package com.github.teamfusion.summonerscrolls.client.render.entity.layers;

import com.github.teamfusion.summonerscrolls.SummonerScrolls;
import com.mojang.blaze3d.vertex.PoseStack;
import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.minecraft.MethodsReturnNonnullByDefault;
import net.minecraft.client.model.EntityModel;
import net.minecraft.client.model.SkeletonModel;
import net.minecraft.client.model.geom.EntityModelSet;
import net.minecraft.client.model.geom.ModelLayers;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.entity.RenderLayerParent;
import net.minecraft.client.renderer.entity.layers.RenderLayer;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.Mob;
import net.minecraft.world.entity.monster.RangedAttackMob;

import javax.annotation.ParametersAreNonnullByDefault;

@ParametersAreNonnullByDefault
@MethodsReturnNonnullByDefault
@SuppressWarnings({"rawtypes", "unchecked"})
@Environment(EnvType.CLIENT)
public class SummonStrayClothingLayer<T extends Mob & RangedAttackMob, M extends EntityModel<T>> extends RenderLayer<T, M> {
    private static final ResourceLocation STRAY_CLOTHES_LOCATION = new ResourceLocation(SummonerScrolls.MOD_ID, "textures/entity/summon/stray_summon_overlay.png");
    private final SkeletonModel<T> layerModel;

    public SummonStrayClothingLayer(RenderLayerParent<T, M> renderLayerParent, EntityModelSet entityModelSet) {
        super(renderLayerParent);
        this.layerModel = new SkeletonModel(entityModelSet.bakeLayer(ModelLayers.STRAY_OUTER_LAYER));
    }

    public void render(PoseStack poseStack, MultiBufferSource multiBufferSource, int i, T mob, float f, float g, float h, float j, float k, float l) {
        coloredCutoutModelCopyLayerRender(this.getParentModel(), this.layerModel, STRAY_CLOTHES_LOCATION, poseStack, multiBufferSource, i, mob, f, g, j, k, l, h, 1.0F, 1.0F, 1.0F);
    }
}
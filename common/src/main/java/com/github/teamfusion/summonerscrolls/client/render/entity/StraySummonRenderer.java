package com.github.teamfusion.summonerscrolls.client.render.entity;

import com.github.teamfusion.summonerscrolls.client.render.entity.layers.SummonStrayClothingLayer;
import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.minecraft.MethodsReturnNonnullByDefault;
import net.minecraft.client.model.geom.ModelLayers;
import net.minecraft.client.renderer.entity.EntityRendererProvider;

import javax.annotation.ParametersAreNonnullByDefault;

@ParametersAreNonnullByDefault
@MethodsReturnNonnullByDefault
@Environment(EnvType.CLIENT)
public class StraySummonRenderer extends SkeletonSummonRenderer {
    public StraySummonRenderer(EntityRendererProvider.Context context) {
        super(context, ModelLayers.STRAY, ModelLayers.STRAY_INNER_ARMOR, ModelLayers.STRAY_OUTER_ARMOR);
        this.addLayer(new SummonStrayClothingLayer<>(this, context.getModelSet()));
    }
}
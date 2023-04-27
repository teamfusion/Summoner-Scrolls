package com.github.teamfusion.summonerscrolls.client.render.entity;

import com.github.teamfusion.summonerscrolls.SummonerScrolls;
import com.github.teamfusion.summonerscrolls.client.render.entity.layers.SummonStrayClothingLayer;
import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.minecraft.MethodsReturnNonnullByDefault;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.monster.EnderMan;

import javax.annotation.ParametersAreNonnullByDefault;

@ParametersAreNonnullByDefault
@MethodsReturnNonnullByDefault
@Environment(EnvType.CLIENT)
public class ShulkermanRenderer extends EndermanSummonRenderer {
    public static final ResourceLocation SUMMON_LOCATION = new ResourceLocation(SummonerScrolls.MOD_ID, "textures/entity/summon/enderman_summon.png");

    public ShulkermanRenderer(EntityRendererProvider.Context context) {
        super(context);
        this.addLayer(new SummonStrayClothingLayer<>(this, context.getModelSet()));
    }

    @Override
    public ResourceLocation getTextureLocation(EnderMan summon) {
        return SUMMON_LOCATION;
    }
}
package com.github.teamfusion.summonerscrolls.client.render.entity;

import com.github.teamfusion.summonerscrolls.SummonerScrolls;
import com.github.teamfusion.summonerscrolls.client.render.entity.layers.SummonGlowLayer;
import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.minecraft.client.model.SkeletonModel;
import net.minecraft.client.model.geom.ModelLayerLocation;
import net.minecraft.client.model.geom.ModelLayers;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.entity.HumanoidMobRenderer;
import net.minecraft.client.renderer.entity.SkeletonRenderer;
import net.minecraft.client.renderer.entity.layers.HumanoidArmorLayer;
import net.minecraft.core.BlockPos;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.monster.AbstractSkeleton;
import org.jetbrains.annotations.Nullable;

import javax.annotation.ParametersAreNonnullByDefault;

@ParametersAreNonnullByDefault
@Environment(EnvType.CLIENT)
public class SkeletonSummonRenderer extends HumanoidMobRenderer<AbstractSkeleton, SkeletonModel<AbstractSkeleton>> {
    public static final String SUMMON_NAME = "skeleton";
    public static final ResourceLocation SUMMON_LOCATION = new ResourceLocation(SummonerScrolls.MOD_ID, "textures/entity/summon/" + SUMMON_NAME + "_summon.png");

    public SkeletonSummonRenderer(EntityRendererProvider.Context context) {
        this(context, ModelLayers.SKELETON, ModelLayers.SKELETON_INNER_ARMOR, ModelLayers.SKELETON_OUTER_ARMOR);
    }

    public SkeletonSummonRenderer(EntityRendererProvider.Context context, ModelLayerLocation modelLayerLocation, ModelLayerLocation modelLayerLocation2, ModelLayerLocation modelLayerLocation3) {
        super(context, new SkeletonModel(context.bakeLayer(modelLayerLocation)), 0.5F);
        this.addLayer(new HumanoidArmorLayer(this, new SkeletonModel(context.bakeLayer(modelLayerLocation2)), new SkeletonModel(context.bakeLayer(modelLayerLocation3))));
        this.addLayer(new SummonGlowLayer<>(this, SUMMON_NAME));
    }

    @Nullable
    @Override
    protected RenderType getRenderType(AbstractSkeleton livingEntity, boolean bl, boolean bl2, boolean bl3) {
        return RenderType.entityTranslucent(getTextureLocation(livingEntity));
    }

    @Override
    protected int getBlockLightLevel(AbstractSkeleton entity, BlockPos blockPos) {
        return 15;
    }

    @Override
    public ResourceLocation getTextureLocation(AbstractSkeleton entity) {
        return SUMMON_LOCATION;
    }
}

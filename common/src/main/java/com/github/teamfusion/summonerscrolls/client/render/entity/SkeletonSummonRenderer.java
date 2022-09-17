package com.github.teamfusion.summonerscrolls.client.render.entity;

import com.github.teamfusion.summonerscrolls.SummonerScrolls;
import com.github.teamfusion.summonerscrolls.client.render.entity.layers.SummonGlowLayer;
import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.entity.SkeletonRenderer;
import net.minecraft.core.BlockPos;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.monster.AbstractSkeleton;
import org.jetbrains.annotations.Nullable;

import javax.annotation.ParametersAreNonnullByDefault;

@ParametersAreNonnullByDefault
@Environment(EnvType.CLIENT)
public class SkeletonSummonRenderer extends SkeletonRenderer {
    public static final String SUMMON_NAME = "skeleton";
    public static final ResourceLocation SUMMON_LOCATION = new ResourceLocation(SummonerScrolls.MOD_ID, "textures/entity/summon/" + SUMMON_NAME + "_summon.png");

    public SkeletonSummonRenderer(EntityRendererProvider.Context context) {
        super(context);
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

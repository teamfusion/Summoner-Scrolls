package com.github.teamfusion.summonerscrolls.client.render.entity;

import com.github.teamfusion.summonerscrolls.SummonerScrolls;
import com.github.teamfusion.summonerscrolls.client.render.entity.layers.SummonGlowLayer;
import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.minecraft.MethodsReturnNonnullByDefault;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.entity.HuskRenderer;
import net.minecraft.core.BlockPos;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.monster.Zombie;
import org.jetbrains.annotations.Nullable;

@MethodsReturnNonnullByDefault
@Environment(EnvType.CLIENT)
public class HuskSummonRenderer extends HuskRenderer {
    public static final ResourceLocation SUMMON_LOCATION = new ResourceLocation(SummonerScrolls.MOD_ID, "textures/entity/summon/husk_summon.png");

    public HuskSummonRenderer(EntityRendererProvider.Context context) {
        super(context);
        this.addLayer(new SummonGlowLayer<>(this, SUMMON_LOCATION));
    }

    @Nullable
    @Override
    protected RenderType getRenderType(Zombie summon, boolean bl, boolean bl2, boolean bl3) {
        return RenderType.entityTranslucent(getTextureLocation(summon));
    }

    @Override
    protected int getBlockLightLevel(Zombie summon, BlockPos blockPos) {
        return 15;
    }

    @Override
    public ResourceLocation getTextureLocation(Zombie summon) {
        return SUMMON_LOCATION;
    }
}
package com.github.teamfusion.summonerscrolls.client.render.entity;

import com.github.teamfusion.summonerscrolls.SummonerScrolls;
import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.entity.ZombieRenderer;
import net.minecraft.core.BlockPos;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.monster.Zombie;
import org.jetbrains.annotations.Nullable;

import javax.annotation.ParametersAreNonnullByDefault;

@ParametersAreNonnullByDefault
@Environment(EnvType.CLIENT)
public class ZombieSummonEntityRenderer extends ZombieRenderer {
    public static final ResourceLocation TEXTURE = new ResourceLocation(SummonerScrolls.MOD_ID, "textures/entity/zombie_summon.png");

    public ZombieSummonEntityRenderer(EntityRendererProvider.Context context) {
        super(context);
    }

    @Nullable
    @Override
    protected RenderType getRenderType(Zombie livingEntity, boolean bl, boolean bl2, boolean bl3) {
        return RenderType.entityTranslucent(getTextureLocation(livingEntity));
    }

    @Override
    protected int getBlockLightLevel(Zombie entity, BlockPos blockPos) {
        return 15;
    }

    @Override
    public ResourceLocation getTextureLocation(Zombie zombie) {
        return TEXTURE;
    }
}

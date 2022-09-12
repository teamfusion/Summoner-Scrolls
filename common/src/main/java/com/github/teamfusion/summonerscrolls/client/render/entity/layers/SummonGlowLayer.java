package com.github.teamfusion.summonerscrolls.client.render.entity.layers;

import com.github.teamfusion.summonerscrolls.SummonerScrolls;
import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.minecraft.client.model.ZombieModel;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.entity.RenderLayerParent;
import net.minecraft.client.renderer.entity.layers.EyesLayer;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.monster.Zombie;

@Environment(EnvType.CLIENT)
public class SummonGlowLayer<T extends Zombie> extends EyesLayer<T, ZombieModel<T>> {
    public String SUMMON_NAME;
    private final RenderType SUMMON_GLOW_LAYER = RenderType.eyes(new ResourceLocation(SummonerScrolls.MOD_ID, "textures/entity/summon/" + SUMMON_NAME + "_summon_glow.png"));

    public SummonGlowLayer(RenderLayerParent<T, ZombieModel<T>> renderLayerParent, String summonName) {
        super(renderLayerParent);
        this.SUMMON_NAME = summonName;
    }

    @Override
    public RenderType renderType() {
        return SUMMON_GLOW_LAYER;
    }
}
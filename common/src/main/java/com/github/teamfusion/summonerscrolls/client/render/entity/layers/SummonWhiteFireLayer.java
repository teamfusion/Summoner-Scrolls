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
public class SummonWhiteFireLayer<T extends Zombie> extends EyesLayer<T, ZombieModel<T>> {
    private static final RenderType SUMMON_WHITE_FIRE = RenderType.eyes(new ResourceLocation(SummonerScrolls.MOD_ID, "textures/entity/summon/zombie_summon_white_fire.png"));

    public SummonWhiteFireLayer(RenderLayerParent<T, ZombieModel<T>> renderLayerParent) {
        super(renderLayerParent);
    }

    public RenderType renderType() {
        return SUMMON_WHITE_FIRE;
    }
}
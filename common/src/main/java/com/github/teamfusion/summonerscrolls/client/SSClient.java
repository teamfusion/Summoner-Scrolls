package com.github.teamfusion.summonerscrolls.client;

import com.github.teamfusion.summonerscrolls.SummonerScrolls;
import com.github.teamfusion.summonerscrolls.client.render.entity.HuskSummonRenderer;
import com.github.teamfusion.summonerscrolls.client.render.entity.SkeletonSummonRenderer;
import com.github.teamfusion.summonerscrolls.client.render.entity.ZombieSummonRenderer;
import com.github.teamfusion.summonerscrolls.common.registry.SSEntityTypes;
import dev.architectury.registry.client.level.entity.EntityRendererRegistry;
import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;


@Environment(EnvType.CLIENT)
public class SSClient extends SummonerScrolls {
    public static void commonClientInitialize() {
        LOGGER.info("Initializing {}-CLIENT", MOD_NAME);

        EntityRendererRegistry.register(SSEntityTypes.ZOMBIE_SUMMON, ZombieSummonRenderer::new);
        EntityRendererRegistry.register(SSEntityTypes.HUSK_SUMMON, HuskSummonRenderer::new);
        EntityRendererRegistry.register(SSEntityTypes.SKELETON_SUMMON, SkeletonSummonRenderer::new);
    }
}
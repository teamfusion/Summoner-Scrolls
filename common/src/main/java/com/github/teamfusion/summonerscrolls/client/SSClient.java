package com.github.teamfusion.summonerscrolls.client;

import com.github.teamfusion.summonerscrolls.SummonerScrolls;
import com.github.teamfusion.summonerscrolls.client.render.entity.CaveSpiderSummonRenderer;
import com.github.teamfusion.summonerscrolls.client.render.entity.CreeperSummonRenderer;
import com.github.teamfusion.summonerscrolls.client.render.entity.EndermanSummonRenderer;
import com.github.teamfusion.summonerscrolls.client.render.entity.HuskSummonRenderer;
import com.github.teamfusion.summonerscrolls.client.render.entity.SkeletonSummonRenderer;
import com.github.teamfusion.summonerscrolls.client.render.entity.SpiderSummonRenderer;
import com.github.teamfusion.summonerscrolls.client.render.entity.StraySummonRenderer;
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
        EntityRendererRegistry.register(SSEntityTypes.SPIDER_SUMMON, SpiderSummonRenderer::new);
        EntityRendererRegistry.register(SSEntityTypes.SKELETON_SUMMON, SkeletonSummonRenderer::new);

        EntityRendererRegistry.register(SSEntityTypes.HUSK_SUMMON, HuskSummonRenderer::new);
        EntityRendererRegistry.register(SSEntityTypes.STRAY_SUMMON, StraySummonRenderer::new);
        EntityRendererRegistry.register(SSEntityTypes.CAVE_SPIDER_SUMMON, CaveSpiderSummonRenderer::new);
        EntityRendererRegistry.register(SSEntityTypes.ENDERMAN_SUMMON, EndermanSummonRenderer::new);

        EntityRendererRegistry.register(SSEntityTypes.CREEPER_SUMMON, CreeperSummonRenderer::new);
        EntityRendererRegistry.register(SSEntityTypes.CHARGED_CREEPER_SUMMON, CreeperSummonRenderer::new);
    }
}
package com.github.teamfusion.summonerscrolls.client;

import com.github.teamfusion.summonerscrolls.SummonerScrolls;
import com.github.teamfusion.summonerscrolls.client.render.entity.HuskSummonRenderer;
import com.github.teamfusion.summonerscrolls.client.render.entity.ZombieSummonRenderer;
import com.github.teamfusion.summonerscrolls.entity.SummonerScrollsEntityTypes;
import dev.architectury.registry.client.level.entity.EntityRendererRegistry;
import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;


@Environment(EnvType.CLIENT)
public class SummonerScrollsClient extends SummonerScrolls {
    public static void commonClientInitialize() {
        LOGGER.info("Initializing {}-CLIENT", MOD_NAME);

        EntityRendererRegistry.register(SummonerScrollsEntityTypes.ZOMBIE_SUMMON, ZombieSummonRenderer::new);
        EntityRendererRegistry.register(SummonerScrollsEntityTypes.HUSK_SUMMON, HuskSummonRenderer::new);
    }
}
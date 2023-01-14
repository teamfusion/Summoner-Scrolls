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
import com.github.teamfusion.summonerscrolls.common.registry.SSItems;
import com.github.teamfusion.summonerscrolls.platform.client.RenderRegistry;
import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.minecraft.client.renderer.item.ItemProperties;
import net.minecraft.resources.ResourceLocation;


@Environment(EnvType.CLIENT)
public class SSClient {
    public static void commonClientInitialize() {
        SummonerScrolls.LOGGER.info("Initializing {}-CLIENT", SummonerScrolls.MOD_NAME);

        RenderRegistry.renderer(SSEntityTypes.ZOMBIE_SUMMON, ZombieSummonRenderer::new);
        RenderRegistry.renderer(SSEntityTypes.SPIDER_SUMMON, SpiderSummonRenderer::new);
        RenderRegistry.renderer(SSEntityTypes.SKELETON_SUMMON, SkeletonSummonRenderer::new);

        RenderRegistry.renderer(SSEntityTypes.HUSK_SUMMON, HuskSummonRenderer::new);
        RenderRegistry.renderer(SSEntityTypes.STRAY_SUMMON, StraySummonRenderer::new);
        RenderRegistry.renderer(SSEntityTypes.CAVE_SPIDER_SUMMON, CaveSpiderSummonRenderer::new);
        RenderRegistry.renderer(SSEntityTypes.ENDERMAN_SUMMON, EndermanSummonRenderer::new);

        RenderRegistry.renderer(SSEntityTypes.CREEPER_SUMMON, CreeperSummonRenderer::new);
        RenderRegistry.renderer(SSEntityTypes.CHARGED_CREEPER_SUMMON, CreeperSummonRenderer::new);

//        ItemProperties.register(SSItems.SUMMON_BOW.get(), new ResourceLocation("pull"), (itemStack, clientLevel, livingEntity, i) -> {
//            if (livingEntity == null) {
//                return 0.0F;
//            } else {
//                return livingEntity.getUseItem() != itemStack ? 0.0F : (float)(itemStack.getUseDuration() - livingEntity.getUseItemRemainingTicks()) / 20.0F;
//            }
//        });
//
//        ItemProperties.register(SSItems.SUMMON_BOW.get(), new ResourceLocation("pulling"), (itemStack, clientLevel, livingEntity, i) -> livingEntity != null && livingEntity.isUsingItem() && livingEntity.getUseItem() == itemStack ? 1.0F : 0.0F);
    }
}
package com.github.teamfusion.summonerscrolls.client;

import com.github.teamfusion.summonerscrolls.SummonerScrolls;
import com.github.teamfusion.summonerscrolls.client.render.entity.*;
import com.github.teamfusion.summonerscrolls.common.registry.SSEntityTypes;
import com.github.teamfusion.summonerscrolls.common.registry.SSItems;
import com.github.teamfusion.summonerscrolls.mixin.ItemPropertiesAccessor;
import com.github.teamfusion.summonerscrolls.platform.client.RenderRegistry;
import com.google.common.collect.Maps;
import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.minecraft.client.renderer.item.ClampedItemPropertyFunction;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.Item;

import java.util.function.Supplier;

@Environment(EnvType.CLIENT)
public class SSClient {
    public static void commonClientInitialize() {
        SummonerScrolls.LOGGER.info("Initializing {}-CLIENT", SummonerScrolls.MOD_NAME);

        RenderRegistry.renderer(SSEntityTypes.ZOMBIE_SUMMON, ZombieSummonRenderer::new);
        RenderRegistry.renderer(SSEntityTypes.SPIDER_SUMMON, SpiderSummonRenderer::new);
        RenderRegistry.renderer(SSEntityTypes.SKELETON_SUMMON, SkeletonSummonRenderer::new);
        RenderRegistry.renderer(SSEntityTypes.BEE_SUMMON, BeeSummonRenderer::new);

        RenderRegistry.renderer(SSEntityTypes.HUSK_SUMMON, HuskSummonRenderer::new);
        RenderRegistry.renderer(SSEntityTypes.STRAY_SUMMON, StraySummonRenderer::new);
        RenderRegistry.renderer(SSEntityTypes.CAVE_SPIDER_SUMMON, CaveSpiderSummonRenderer::new);
        RenderRegistry.renderer(SSEntityTypes.ENDERMAN_SUMMON, EndermanSummonRenderer::new);
        RenderRegistry.renderer(SSEntityTypes.PIGLIN_SUMMON, PiglinSummonRenderer::new);

        RenderRegistry.renderer(SSEntityTypes.CREEPER_SUMMON, CreeperSummonRenderer::new);
        RenderRegistry.renderer(SSEntityTypes.CHARGED_CREEPER_SUMMON, CreeperSummonRenderer::new);
        RenderRegistry.renderer(SSEntityTypes.PIGLIN_BRUTE_SUMMON, PiglinBruteSummonRenderer::new);
        RenderRegistry.renderer(SSEntityTypes.SHULKERMAN_SUMMON, ShulkermanSummonRenderer::new);
        RenderRegistry.renderer(SSEntityTypes.IRON_GOLEM_SUMMON, IronGolemSummonRenderer::new);
    }

    public static void postClientInitialize() {
        registerProperties(SSItems.SUMMON_BOW, new ResourceLocation("pull"), (itemStack, clientLevel, livingEntity, i) -> {
            if (livingEntity == null) {
                return 0.0F;
            } else {
                return livingEntity.getUseItem() != itemStack ? 0.0F : (float)(itemStack.getUseDuration() - livingEntity.getUseItemRemainingTicks()) / 20.0F;
            }
        });

        registerProperties(SSItems.SUMMON_BOW, new ResourceLocation("pulling"), (itemStack, clientLevel, livingEntity, i) -> livingEntity != null && livingEntity.isUsingItem() && livingEntity.getUseItem() == itemStack ? 1.0F : 0.0F);
    }

    private static void registerProperties(Supplier<Item> item, ResourceLocation state, ClampedItemPropertyFunction function) {
        ItemPropertiesAccessor.getPROPERTIES().computeIfAbsent(item.get(), entry -> Maps.newHashMap()).put(state, function);
    }
}
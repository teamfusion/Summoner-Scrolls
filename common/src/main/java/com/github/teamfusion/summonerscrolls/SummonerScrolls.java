package com.github.teamfusion.summonerscrolls;

import com.github.teamfusion.summonerscrolls.client.SummonerScrollsClient;
import com.github.teamfusion.summonerscrolls.client.particle.SummonerScrollsParticles;
import com.github.teamfusion.summonerscrolls.enchantment.SummonerScrollsEnchantments;
import com.github.teamfusion.summonerscrolls.entity.SummonerScrollsEntityTypes;
import com.github.teamfusion.summonerscrolls.item.SummonerScrollsItems;
import com.github.teamfusion.summonerscrolls.loot.SummonerScrollsLootTables;
import com.github.teamfusion.summonerscrolls.sound.SummonerScrollsSoundEvents;
import com.github.teamfusion.summonerscrolls.trade.SummonerScrollsTrades;
import dev.architectury.registry.CreativeTabRegistry;
import dev.architectury.utils.EnvExecutor;
import net.fabricmc.api.EnvType;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.ItemStack;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class SummonerScrolls {
    public static final String MOD_ID = "summonerscrolls";
    public static final String MOD_NAME = "Summoner Scrolls";
    public static final Logger LOGGER = LoggerFactory.getLogger(MOD_NAME);

    public static final CreativeModeTab SCROLLS_TAB = CreativeTabRegistry.create(new ResourceLocation(MOD_ID, "scrolls_tab"), () ->
            new ItemStack(SummonerScrollsItems.ENHANCEMENT_SCROLL.get()));
    
    public static void commonInitialize() {
        LOGGER.info("Initializing {}", MOD_NAME);

        SummonerScrollsEnchantments.ENCHANTMENTS.register();
        SummonerScrollsItems.ITEMS.register();
        SummonerScrollsEntityTypes.ENTITY_TYPES.register();
        SummonerScrollsSoundEvents.SOUND_EVENTS.register();

        SummonerScrollsEntityTypes.postRegister();

        SummonerScrollsParticles.init();
        SummonerScrollsLootTables.init();
        SummonerScrollsTrades.init();

        EnvExecutor.runInEnv(EnvType.CLIENT, () -> SummonerScrollsClient::commonClientInitialize);
    }

    //TODO: add enchantment target for all tools
}
package com.github.teamfusion.summonerscrolls;

import com.github.teamfusion.summonerscrolls.client.SSClient;
import com.github.teamfusion.summonerscrolls.client.particle.SummonerScrollsParticles;
import com.github.teamfusion.summonerscrolls.common.entity.ISummon;
import com.github.teamfusion.summonerscrolls.common.registry.SSEnchantments;
import com.github.teamfusion.summonerscrolls.common.registry.SSEntityTypes;
import com.github.teamfusion.summonerscrolls.common.registry.SSEvents;
import com.github.teamfusion.summonerscrolls.common.registry.SSItems;
import com.github.teamfusion.summonerscrolls.common.sound.SummonerScrollsSoundEvents;
import com.github.teamfusion.summonerscrolls.common.util.ScrollUtil;
import com.github.teamfusion.summonerscrolls.common.util.loot.SSLootTables;
import com.github.teamfusion.summonerscrolls.common.util.trade.SSTrades;
import dev.architectury.event.EventResult;
import dev.architectury.event.events.common.InteractionEvent;
import dev.architectury.registry.CreativeTabRegistry;
import dev.architectury.utils.EnvExecutor;
import net.fabricmc.api.EnvType;
import net.minecraft.core.BlockPos;
import net.minecraft.network.chat.TranslatableComponent;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.MobSpawnType;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.TieredItem;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.gameevent.GameEvent;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.HashMap;
import java.util.Map;

public class SummonerScrolls {
    public static final String MOD_ID = "summonerscrolls";
    public static final String MOD_NAME = "Summoner Scrolls";
    public static final Logger LOGGER = LoggerFactory.getLogger(MOD_NAME);

    public static final CreativeModeTab SCROLLS_TAB = CreativeTabRegistry.create(new ResourceLocation(MOD_ID, "scrolls_tab"), () ->
            new ItemStack(SSItems.ENHANCEMENT_SCROLL.get()));

    private static final Map<Item, Integer> COOLDOWNS = new HashMap<>();

    public static void commonInitialize() {
        LOGGER.info("Initializing {}", MOD_NAME);

        SSEnchantments.ENCHANTMENTS.register();
        SSItems.ITEMS.register();
        SSEntityTypes.ENTITY_TYPES.register();
        SummonerScrollsSoundEvents.SOUND_EVENTS.register();

        SSEntityTypes.postRegister();

        SummonerScrollsParticles.init();
        SSLootTables.init();
        SSTrades.init();
        SSEvents.init();

        EnvExecutor.runInEnv(EnvType.CLIENT, () -> SSClient::commonClientInitialize);
    }

    //todo: put todos in respective classes
    //todo: blue enchantment glare for summon scrolls
    //todo: create spawn eggs
    //TODO: add enchantment target for all tools
    //todo: add comments for everything
    //todo: use less accesswidener stuff and more accessors
}
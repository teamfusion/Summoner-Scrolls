package com.github.teamfusion.summonerscrolls.platform.common.forge;

import com.github.teamfusion.summonerscrolls.SummonerScrolls;
import com.github.teamfusion.summonerscrolls.platform.common.LootRegistry;
import net.minecraftforge.event.LootTableLoadEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import java.util.function.Consumer;

@Mod.EventBusSubscriber(modid = SummonerScrolls.MOD_ID)
public class LootRegistryImpl {
    private static final Set<Consumer<LootTableLoadEvent>> MODIFICATIONS = ConcurrentHashMap.newKeySet();
    @SubscribeEvent
    public static void onModify(LootTableLoadEvent event) {
        MODIFICATIONS.forEach(consumer -> consumer.accept(event));
    }

    public static void modify(LootRegistry.LootTableModifier modifier) {
        MODIFICATIONS.add(event -> modifier.modify(event.getLootTableManager(), event.getName(), pool -> event.getTable().addPool(pool), true));
//        MinecraftForge.EVENT_BUS.<LootTableLoadEvent>addListener(event -> modifier.modify(event.getLootTableManager(), event.getName(), pool -> event.getTable().addPool(pool), true));
//        FMLJavaModLoadingContext.get().getModEventBus().<LootTableLoadEvent>addListener(event -> modifier.modify(event.getLootTableManager(), event.getName(), pool -> event.getTable().addPool(pool), true));
    }
}
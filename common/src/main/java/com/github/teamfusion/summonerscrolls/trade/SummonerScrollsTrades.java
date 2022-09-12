package com.github.teamfusion.summonerscrolls.trade;

import com.github.teamfusion.summonerscrolls.item.SummonerScrollsItems;
import dev.architectury.registry.level.entity.trade.TradeRegistry;
import net.minecraft.world.entity.npc.VillagerProfession;
import net.minecraft.world.entity.npc.VillagerTrades;

public class SummonerScrollsTrades {
    public static void init() {
        SummonerScrollsItems.ZOMBIE_SCROLL.listen((item) -> TradeRegistry.registerVillagerTrade(
                VillagerProfession.CLERIC, 1, new VillagerTrades.EmeraldForItems(item, 1, 5, 2)
        ));
        SummonerScrollsItems.SPIDER_SCROLL.listen((item) -> TradeRegistry.registerVillagerTrade(
                VillagerProfession.CLERIC, 1, new VillagerTrades.EmeraldForItems(item, 1, 5, 2)
        ));
        SummonerScrollsItems.SKELETON_SCROLL.listen((item) -> TradeRegistry.registerVillagerTrade(
                VillagerProfession.CLERIC, 1, new VillagerTrades.EmeraldForItems(item, 1, 5, 2)
        ));
        SummonerScrollsItems.BEE_SCROLL.listen((item) -> TradeRegistry.registerVillagerTrade(
                VillagerProfession.CLERIC, 1, new VillagerTrades.EmeraldForItems(item, 1, 5, 2)
        ));
    }
}
package com.github.teamfusion.summonerscrolls.common.util.trade;

import com.github.teamfusion.summonerscrolls.common.registry.SSItems;
import dev.architectury.registry.level.entity.trade.TradeRegistry;
import net.minecraft.world.entity.npc.VillagerProfession;
import net.minecraft.world.entity.npc.VillagerTrades;

public class SSTrades {
    public static void init() {
        SSItems.ZOMBIE_SCROLL.listen((item) -> TradeRegistry.registerVillagerTrade(
                VillagerProfession.CLERIC, 1, new VillagerTrades.EmeraldForItems(item, 1, 5, 2)
        ));
        SSItems.SPIDER_SCROLL.listen((item) -> TradeRegistry.registerVillagerTrade(
                VillagerProfession.CLERIC, 1, new VillagerTrades.EmeraldForItems(item, 1, 5, 2)
        ));
        SSItems.SKELETON_SCROLL.listen((item) -> TradeRegistry.registerVillagerTrade(
                VillagerProfession.CLERIC, 1, new VillagerTrades.EmeraldForItems(item, 1, 5, 2)
        ));
        SSItems.BEE_SCROLL.listen((item) -> TradeRegistry.registerVillagerTrade(
                VillagerProfession.CLERIC, 1, new VillagerTrades.EmeraldForItems(item, 1, 5, 2)
        ));
    }
}
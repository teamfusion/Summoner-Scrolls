package com.github.teamfusion.trade;

import com.github.teamfusion.summonerscrolls.item.SummonerScrollsItems;
import dev.architectury.registry.level.entity.trade.TradeRegistry;
import net.minecraft.world.entity.npc.VillagerProfession;
import net.minecraft.world.entity.npc.VillagerTrades;

public class SummonerScrollsTrades {
    public static void init() {
        TradeRegistry.registerVillagerTrade(VillagerProfession.TOOLSMITH, 1,
                new VillagerTrades.EmeraldForItems(SummonerScrollsItems.ZOMBIE_SCROLL.get(), 1, 5, 2),
                new VillagerTrades.EmeraldForItems(SummonerScrollsItems.SKELETON_SCROLL.get(), 1, 5, 2),
                new VillagerTrades.EmeraldForItems(SummonerScrollsItems.SPIDER_SCROLL.get(), 1, 5, 2),
                new VillagerTrades.EmeraldForItems(SummonerScrollsItems.ENDERMAN_SCROLL.get(), 1, 5, 2)
        );
        TradeRegistry.registerVillagerTrade(VillagerProfession.WEAPONSMITH, 1,
                new VillagerTrades.EmeraldForItems(SummonerScrollsItems.ZOMBIE_SCROLL.get(), 1, 5, 2),
                new VillagerTrades.EmeraldForItems(SummonerScrollsItems.SKELETON_SCROLL.get(), 1, 5, 2),
                new VillagerTrades.EmeraldForItems(SummonerScrollsItems.SPIDER_SCROLL.get(), 1, 5, 2),
                new VillagerTrades.EmeraldForItems(SummonerScrollsItems.ENDERMAN_SCROLL.get(), 1, 5, 2)
        );
    }
}
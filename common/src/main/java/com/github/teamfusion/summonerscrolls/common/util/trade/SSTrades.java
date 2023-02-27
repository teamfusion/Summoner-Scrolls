package com.github.teamfusion.summonerscrolls.common.util.trade;

import com.github.teamfusion.summonerscrolls.common.registry.SSItems;
import com.github.teamfusion.summonerscrolls.platform.common.VillagerRegistry;
import com.google.common.collect.ImmutableList;
import net.minecraft.world.entity.npc.VillagerProfession;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.trading.MerchantOffer;

import java.util.List;
import java.util.function.Supplier;

public class SSTrades {
    public static void init() {
        List<Supplier<Item>> items = ImmutableList.of(SSItems.ZOMBIE_SCROLL, SSItems.SPIDER_SCROLL, SSItems.SKELETON_SCROLL, SSItems.BEE_SCROLL);

        // for some reason, forge doesn't want to accept EmeraldForItems, so we have to get the offer manually for some reason... may try implementing the listen() method in a future.
        items.forEach(item -> VillagerRegistry.addTrade(VillagerProfession.CLERIC, 1, (entity, random) -> new MerchantOffer(new ItemStack(item.get(), 1), new ItemStack(Items.EMERALD), 5, 2, 0.05F)));

//        SSItems.ZOMBIE_SCROLL.listen((item) -> TradeRegistry.registerVillagerTrade(
//                VillagerProfession.CLERIC, 1, new VillagerTrades.EmeraldForItems(item, 1, 5, 2)
//        ));
//        SSItems.SPIDER_SCROLL.listen((item) -> TradeRegistry.registerVillagerTrade(
//                VillagerProfession.CLERIC, 1, new VillagerTrades.EmeraldForItems(item, 1, 5, 2)
//        ));
//        SSItems.SKELETON_SCROLL.listen((item) -> TradeRegistry.registerVillagerTrade(
//                VillagerProfession.CLERIC, 1, new VillagerTrades.EmeraldForItems(item, 1, 5, 2)
//        ));
//        SSItems.BEE_SCROLL.listen((item) -> TradeRegistry.registerVillagerTrade(
//                VillagerProfession.CLERIC, 1, new VillagerTrades.EmeraldForItems(item, 1, 5, 2)
//        ));
    }
}
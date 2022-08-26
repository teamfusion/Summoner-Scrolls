package com.github.teamfusion.summonerscrolls.loot;

import com.github.teamfusion.summonerscrolls.item.SummonerScrollsItems;
import dev.architectury.event.events.common.LootEvent;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.storage.loot.BuiltInLootTables;
import net.minecraft.world.level.storage.loot.LootPool;
import net.minecraft.world.level.storage.loot.entries.LootItem;
import net.minecraft.world.level.storage.loot.providers.number.BinomialDistributionGenerator;

import java.util.Collection;
import java.util.Set;

public class SummonerScrollsLootTables {
    public static final Collection<ResourceLocation> SCROLL_TABLES = Set.of(BuiltInLootTables.JUNGLE_TEMPLE, BuiltInLootTables.DESERT_PYRAMID, BuiltInLootTables.STRONGHOLD_LIBRARY, BuiltInLootTables.BASTION_TREASURE, BuiltInLootTables.FISHING_TREASURE);

    public static void init() {
        SummonerScrollsItems.ZOMBIE_SCROLL.listen((item) ->
                LootEvent.MODIFY_LOOT_TABLE.register((lootTables, id, context, builtin) -> {
                    if (SCROLL_TABLES.contains(id)) {
                        LootPool.Builder pool = LootPool.lootPool()
                                .add(LootItem.lootTableItem(item)).setRolls(BinomialDistributionGenerator.binomial(1, 0.5F));
                        context.addPool(pool);
                    }
                })
        );
        SummonerScrollsItems.SKELETON_SCROLL.listen((item) ->
                LootEvent.MODIFY_LOOT_TABLE.register((lootTables, id, context, builtin) -> {
                    if (SCROLL_TABLES.contains(id)) {
                        LootPool.Builder pool = LootPool.lootPool()
                                .add(LootItem.lootTableItem(item)).setRolls(BinomialDistributionGenerator.binomial(1, 0.5F));
                        context.addPool(pool);
                    }
                })
        );
        SummonerScrollsItems.SPIDER_SCROLL.listen((item) ->
                LootEvent.MODIFY_LOOT_TABLE.register((lootTables, id, context, builtin) -> {
                    if (SCROLL_TABLES.contains(id)) {
                        LootPool.Builder pool = LootPool.lootPool()
                                .add(LootItem.lootTableItem(item)).setRolls(BinomialDistributionGenerator.binomial(1, 0.5F));
                        context.addPool(pool);
                    }
                })
        );
        SummonerScrollsItems.ENDERMAN_SCROLL.listen((item) ->
                LootEvent.MODIFY_LOOT_TABLE.register((lootTables, id, context, builtin) -> {
                    if (SCROLL_TABLES.contains(id)) {
                        LootPool.Builder pool = LootPool.lootPool()
                                .add(LootItem.lootTableItem(item)).setRolls(BinomialDistributionGenerator.binomial(1, 0.5F));
                        context.addPool(pool);
                    }
                })
        );
    }
}
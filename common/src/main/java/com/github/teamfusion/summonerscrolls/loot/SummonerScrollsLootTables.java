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
    public static final Collection<ResourceLocation> TIER_ONE_SCROLL_TABLES = Set.of(BuiltInLootTables.SIMPLE_DUNGEON);
    public static final Collection<ResourceLocation> TIER_TWO_SCROLL_TABLES = Set.of(BuiltInLootTables.BASTION_TREASURE, BuiltInLootTables.BASTION_BRIDGE, BuiltInLootTables.BASTION_HOGLIN_STABLE, BuiltInLootTables.BASTION_OTHER);
    public static final Collection<ResourceLocation> TIER_THREE_SCROLL_TABLES = Set.of(BuiltInLootTables.END_CITY_TREASURE);

    public static void init() {
        /* Loot - Tier 1 */
        SummonerScrollsItems.ZOMBIE_SCROLL.listen((item) ->
                LootEvent.MODIFY_LOOT_TABLE.register((lootTables, id, context, builtin) -> {
                    if (TIER_ONE_SCROLL_TABLES.contains(id)) {
                        LootPool.Builder pool = LootPool.lootPool()
                                .add(LootItem.lootTableItem(item)).setRolls(BinomialDistributionGenerator.binomial(1, 0.5F));
                        context.addPool(pool);
                    }
                })
        );
        SummonerScrollsItems.SPIDER_SCROLL.listen((item) ->
                LootEvent.MODIFY_LOOT_TABLE.register((lootTables, id, context, builtin) -> {
                    if (TIER_ONE_SCROLL_TABLES.contains(id)) {
                        LootPool.Builder pool = LootPool.lootPool()
                                .add(LootItem.lootTableItem(item)).setRolls(BinomialDistributionGenerator.binomial(1, 0.5F));
                        context.addPool(pool);
                    }
                })
        );
        SummonerScrollsItems.SKELETON_SCROLL.listen((item) ->
                LootEvent.MODIFY_LOOT_TABLE.register((lootTables, id, context, builtin) -> {
                    if (TIER_ONE_SCROLL_TABLES.contains(id)) {
                        LootPool.Builder pool = LootPool.lootPool()
                                .add(LootItem.lootTableItem(item)).setRolls(BinomialDistributionGenerator.binomial(1, 0.5F));
                        context.addPool(pool);
                    }
                })
        );
        SummonerScrollsItems.BEE_SCROLL.listen((item) ->
                LootEvent.MODIFY_LOOT_TABLE.register((lootTables, id, context, builtin) -> {
                    if (TIER_ONE_SCROLL_TABLES.contains(id)) {
                        LootPool.Builder pool = LootPool.lootPool()
                                .add(LootItem.lootTableItem(item)).setRolls(BinomialDistributionGenerator.binomial(1, 0.5F));
                        context.addPool(pool);
                    }
                })
        );

        /* Loot - Tier 2 */
        SummonerScrollsItems.HUSK_SCROLL.listen((item) ->
                LootEvent.MODIFY_LOOT_TABLE.register((lootTables, id, context, builtin) -> {
                    if (TIER_TWO_SCROLL_TABLES.contains(id)) {
                        LootPool.Builder pool = LootPool.lootPool()
                                .add(LootItem.lootTableItem(item)).setRolls(BinomialDistributionGenerator.binomial(1, 0.5F));
                        context.addPool(pool);
                    }
                })
        );
        SummonerScrollsItems.STRAY_SCROLL.listen((item) ->
                LootEvent.MODIFY_LOOT_TABLE.register((lootTables, id, context, builtin) -> {
                    if (TIER_TWO_SCROLL_TABLES.contains(id)) {
                        LootPool.Builder pool = LootPool.lootPool()
                                .add(LootItem.lootTableItem(item)).setRolls(BinomialDistributionGenerator.binomial(1, 0.5F));
                        context.addPool(pool);
                    }
                })
        );
        SummonerScrollsItems.CAVE_SPIDER_SCROLL.listen((item) ->
                LootEvent.MODIFY_LOOT_TABLE.register((lootTables, id, context, builtin) -> {
                    if (TIER_TWO_SCROLL_TABLES.contains(id)) {
                        LootPool.Builder pool = LootPool.lootPool()
                                .add(LootItem.lootTableItem(item)).setRolls(BinomialDistributionGenerator.binomial(1, 0.5F));
                        context.addPool(pool);
                    }
                })
        );
        SummonerScrollsItems.ENDERMAN_SCROLL.listen((item) ->
                LootEvent.MODIFY_LOOT_TABLE.register((lootTables, id, context, builtin) -> {
                    if (TIER_TWO_SCROLL_TABLES.contains(id)) {
                        LootPool.Builder pool = LootPool.lootPool()
                                .add(LootItem.lootTableItem(item)).setRolls(BinomialDistributionGenerator.binomial(1, 0.5F));
                        context.addPool(pool);
                    }
                })
        );
        SummonerScrollsItems.PIGLIN_SCROLL.listen((item) ->
                LootEvent.MODIFY_LOOT_TABLE.register((lootTables, id, context, builtin) -> {
                    if (TIER_TWO_SCROLL_TABLES.contains(id)) {
                        LootPool.Builder pool = LootPool.lootPool()
                                .add(LootItem.lootTableItem(item)).setRolls(BinomialDistributionGenerator.binomial(1, 0.5F));
                        context.addPool(pool);
                    }
                })
        );

        /* Loot - Tier 3 */

//        SummonerScrollsItems.SHULKERMAN_SCROLL.listen((item) ->
//                LootEvent.MODIFY_LOOT_TABLE.register((lootTables, id, context, builtin) -> {
//                    if (TIER_THREE_SCROLL_TABLES.contains(id)) {
//                        LootPool.Builder pool = LootPool.lootPool()
//                                .add(LootItem.lootTableItem(item)).setRolls(BinomialDistributionGenerator.binomial(1, 0.5F));
//                        context.addPool(pool);
//                    }
//                })
//        );
        SummonerScrollsItems.CREEPER_SCROLL.listen((item) ->
                LootEvent.MODIFY_LOOT_TABLE.register((lootTables, id, context, builtin) -> {
                    if (TIER_THREE_SCROLL_TABLES.contains(id)) {
                        LootPool.Builder pool = LootPool.lootPool()
                                .add(LootItem.lootTableItem(item)).setRolls(BinomialDistributionGenerator.binomial(1, 0.5F));
                        context.addPool(pool);
                    }
                })
        );
        SummonerScrollsItems.PIGLIN_BRUTE_SCROLL.listen((item) ->
                LootEvent.MODIFY_LOOT_TABLE.register((lootTables, id, context, builtin) -> {
                    if (TIER_THREE_SCROLL_TABLES.contains(id)) {
                        LootPool.Builder pool = LootPool.lootPool()
                                .add(LootItem.lootTableItem(item)).setRolls(BinomialDistributionGenerator.binomial(1, 0.5F));
                        context.addPool(pool);
                    }
                })
        );
        SummonerScrollsItems.IRON_GOLEM_SCROLL.listen((item) ->
                LootEvent.MODIFY_LOOT_TABLE.register((lootTables, id, context, builtin) -> {
                    if (TIER_THREE_SCROLL_TABLES.contains(id)) {
                        LootPool.Builder pool = LootPool.lootPool()
                                .add(LootItem.lootTableItem(item)).setRolls(BinomialDistributionGenerator.binomial(1, 0.5F));
                        context.addPool(pool);
                    }
                })
        );
        SummonerScrollsItems.CHARGED_CREEPER_SCROLL.listen((item) ->
                LootEvent.MODIFY_LOOT_TABLE.register((lootTables, id, context, builtin) -> {
                    if (TIER_THREE_SCROLL_TABLES.contains(id)) {
                        LootPool.Builder pool = LootPool.lootPool()
                                .add(LootItem.lootTableItem(item)).setRolls(BinomialDistributionGenerator.binomial(1, 0.5F));
                        context.addPool(pool);
                    }
                })
        );
    }
}
package com.github.teamfusion.summonerscrolls.common.util.loot;

import com.github.teamfusion.summonerscrolls.common.registry.SSItems;
import com.github.teamfusion.summonerscrolls.platform.common.LootRegistry;
import com.google.common.collect.ImmutableMap;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.storage.loot.BuiltInLootTables;
import net.minecraft.world.level.storage.loot.LootPool;
import net.minecraft.world.level.storage.loot.entries.LootItem;
import net.minecraft.world.level.storage.loot.providers.number.BinomialDistributionGenerator;

import java.util.Collection;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.function.Supplier;

public class SSLootTables {
    public static final Collection<ResourceLocation> TIER_ONE_SCROLL_TABLES = Set.of(BuiltInLootTables.SIMPLE_DUNGEON);
    public static final Collection<ResourceLocation> TIER_TWO_SCROLL_TABLES = Set.of(BuiltInLootTables.BASTION_TREASURE, BuiltInLootTables.BASTION_BRIDGE, BuiltInLootTables.BASTION_HOGLIN_STABLE, BuiltInLootTables.BASTION_OTHER);
    public static final Collection<ResourceLocation> TIER_THREE_SCROLL_TABLES = Set.of(BuiltInLootTables.END_CITY_TREASURE);

    private static final Map<Collection<ResourceLocation>, List<Supplier<Item>>> LOOT_PER_TIER = ImmutableMap.of(
            TIER_ONE_SCROLL_TABLES, List.of(SSItems.ZOMBIE_SCROLL, SSItems.SPIDER_SCROLL, SSItems.SKELETON_SCROLL, SSItems.BEE_SCROLL),
            TIER_TWO_SCROLL_TABLES, List.of(SSItems.HUSK_SCROLL, SSItems.STRAY_SCROLL, SSItems.CAVE_SPIDER_SCROLL, SSItems.ENDERMAN_SCROLL, SSItems.PIGLIN_SCROLL),
            TIER_THREE_SCROLL_TABLES, List.of(SSItems.CREEPER_SCROLL, SSItems.PIGLIN_BRUTE_SCROLL, SSItems.SHULKERMAN_SCROLL, SSItems.IRON_GOLEM_SCROLL, SSItems.CHARGED_CREEPER_SCROLL)
    );

    public static void init() {
        LootRegistry.modify((tables, location, context, builtin) -> {
            LOOT_PER_TIER.forEach((lootTable, items) -> {
                if (lootTable.contains(location)) {
                    items.forEach(item -> {
                        LootPool.Builder pool = LootPool.lootPool().add(LootItem.lootTableItem(item.get())).setRolls(BinomialDistributionGenerator.binomial(1, 0.5F));
                        context.addPool(pool);
                    });
                }
            });
        });




//        /* Loot - Tier 1 */
//        SSItems.ZOMBIE_SCROLL.listen((item) ->
//                LootEvent.MODIFY_LOOT_TABLE.register((lootTables, id, context, builtin) -> {
//                    if (TIER_ONE_SCROLL_TABLES.contains(id)) {
//                        LootPool.Builder pool = LootPool.lootPool()
//                                .add(LootItem.lootTableItem(item)).setRolls(BinomialDistributionGenerator.binomial(1, 0.5F));
//                        context.addPool(pool);
//                    }
//                })
//        );
//        SSItems.SPIDER_SCROLL.listen((item) ->
//                LootEvent.MODIFY_LOOT_TABLE.register((lootTables, id, context, builtin) -> {
//                    if (TIER_ONE_SCROLL_TABLES.contains(id)) {
//                        LootPool.Builder pool = LootPool.lootPool()
//                                .add(LootItem.lootTableItem(item)).setRolls(BinomialDistributionGenerator.binomial(1, 0.5F));
//                        context.addPool(pool);
//                    }
//                })
//        );
//        SSItems.SKELETON_SCROLL.listen((item) ->
//                LootEvent.MODIFY_LOOT_TABLE.register((lootTables, id, context, builtin) -> {
//                    if (TIER_ONE_SCROLL_TABLES.contains(id)) {
//                        LootPool.Builder pool = LootPool.lootPool()
//                                .add(LootItem.lootTableItem(item)).setRolls(BinomialDistributionGenerator.binomial(1, 0.5F));
//                        context.addPool(pool);
//                    }
//                })
//        );
//        SSItems.BEE_SCROLL.listen((item) ->
//                LootEvent.MODIFY_LOOT_TABLE.register((lootTables, id, context, builtin) -> {
//                    if (TIER_ONE_SCROLL_TABLES.contains(id)) {
//                        LootPool.Builder pool = LootPool.lootPool()
//                                .add(LootItem.lootTableItem(item)).setRolls(BinomialDistributionGenerator.binomial(1, 0.5F));
//                        context.addPool(pool);
//                    }
//                })
//        );
//
//        /* Loot - Tier 2 */
//        SSItems.HUSK_SCROLL.listen((item) ->
//                LootEvent.MODIFY_LOOT_TABLE.register((lootTables, id, context, builtin) -> {
//                    if (TIER_TWO_SCROLL_TABLES.contains(id)) {
//                        LootPool.Builder pool = LootPool.lootPool()
//                                .add(LootItem.lootTableItem(item)).setRolls(BinomialDistributionGenerator.binomial(1, 0.5F));
//                        context.addPool(pool);
//                    }
//                })
//        );
//        SSItems.STRAY_SCROLL.listen((item) ->
//                LootEvent.MODIFY_LOOT_TABLE.register((lootTables, id, context, builtin) -> {
//                    if (TIER_TWO_SCROLL_TABLES.contains(id)) {
//                        LootPool.Builder pool = LootPool.lootPool()
//                                .add(LootItem.lootTableItem(item)).setRolls(BinomialDistributionGenerator.binomial(1, 0.5F));
//                        context.addPool(pool);
//                    }
//                })
//        );
//        SSItems.CAVE_SPIDER_SCROLL.listen((item) ->
//                LootEvent.MODIFY_LOOT_TABLE.register((lootTables, id, context, builtin) -> {
//                    if (TIER_TWO_SCROLL_TABLES.contains(id)) {
//                        LootPool.Builder pool = LootPool.lootPool()
//                                .add(LootItem.lootTableItem(item)).setRolls(BinomialDistributionGenerator.binomial(1, 0.5F));
//                        context.addPool(pool);
//                    }
//                })
//        );
//        SSItems.ENDERMAN_SCROLL.listen((item) ->
//                LootEvent.MODIFY_LOOT_TABLE.register((lootTables, id, context, builtin) -> {
//                    if (TIER_TWO_SCROLL_TABLES.contains(id)) {
//                        LootPool.Builder pool = LootPool.lootPool()
//                                .add(LootItem.lootTableItem(item)).setRolls(BinomialDistributionGenerator.binomial(1, 0.5F));
//                        context.addPool(pool);
//                    }
//                })
//        );
//        SSItems.PIGLIN_SCROLL.listen((item) ->
//                LootEvent.MODIFY_LOOT_TABLE.register((lootTables, id, context, builtin) -> {
//                    if (TIER_TWO_SCROLL_TABLES.contains(id)) {
//                        LootPool.Builder pool = LootPool.lootPool()
//                                .add(LootItem.lootTableItem(item)).setRolls(BinomialDistributionGenerator.binomial(1, 0.5F));
//                        context.addPool(pool);
//                    }
//                })
//        );
//
//        /* Loot - Tier 3
//        SummonerScrollsItems.SHULKERMAN_SCROLL.listen((item) ->
//                LootEvent.MODIFY_LOOT_TABLE.register((lootTables, id, context, builtin) -> {
//                    if (TIER_THREE_SCROLL_TABLES.contains(id)) {
//                        LootPool.Builder pool = LootPool.lootPool()
//                                .add(LootItem.lootTableItem(item)).setRolls(BinomialDistributionGenerator.binomial(1, 0.5F));
//                        context.addPool(pool);
//                    }
//                })
//        );
//         */
//        SSItems.CREEPER_SCROLL.listen((item) ->
//                LootEvent.MODIFY_LOOT_TABLE.register((lootTables, id, context, builtin) -> {
//                    if (TIER_THREE_SCROLL_TABLES.contains(id)) {
//                        LootPool.Builder pool = LootPool.lootPool()
//                                .add(LootItem.lootTableItem(item)).setRolls(BinomialDistributionGenerator.binomial(1, 0.5F));
//                        context.addPool(pool);
//                    }
//                })
//        );
//        SSItems.PIGLIN_BRUTE_SCROLL.listen((item) ->
//                LootEvent.MODIFY_LOOT_TABLE.register((lootTables, id, context, builtin) -> {
//                    if (TIER_THREE_SCROLL_TABLES.contains(id)) {
//                        LootPool.Builder pool = LootPool.lootPool()
//                                .add(LootItem.lootTableItem(item)).setRolls(BinomialDistributionGenerator.binomial(1, 0.5F));
//                        context.addPool(pool);
//                    }
//                })
//        );
//        SSItems.IRON_GOLEM_SCROLL.listen((item) ->
//                LootEvent.MODIFY_LOOT_TABLE.register((lootTables, id, context, builtin) -> {
//                    if (TIER_THREE_SCROLL_TABLES.contains(id)) {
//                        LootPool.Builder pool = LootPool.lootPool()
//                                .add(LootItem.lootTableItem(item)).setRolls(BinomialDistributionGenerator.binomial(1, 0.5F));
//                        context.addPool(pool);
//                    }
//                })
//        );
//        SSItems.CHARGED_CREEPER_SCROLL.listen((item) ->
//                LootEvent.MODIFY_LOOT_TABLE.register((lootTables, id, context, builtin) -> {
//                    if (TIER_THREE_SCROLL_TABLES.contains(id)) {
//                        LootPool.Builder pool = LootPool.lootPool()
//                                .add(LootItem.lootTableItem(item)).setRolls(BinomialDistributionGenerator.binomial(1, 0.5F));
//                        context.addPool(pool);
//                    }
//                })
//        );
    }
}
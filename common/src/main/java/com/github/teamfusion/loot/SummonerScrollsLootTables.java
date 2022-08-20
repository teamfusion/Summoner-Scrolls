package com.github.teamfusion.loot;

import com.github.teamfusion.summonerscrolls.item.SummonerScrollsItems;
import dev.architectury.event.events.common.LootEvent;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.storage.loot.BuiltInLootTables;
import net.minecraft.world.level.storage.loot.LootPool;
import net.minecraft.world.level.storage.loot.entries.LootItem;

import java.util.Collection;
import java.util.Set;

public class SummonerScrollsLootTables {
    public static final Collection<ResourceLocation> SCROLL_TABLES = Set.of(BuiltInLootTables.JUNGLE_TEMPLE, BuiltInLootTables.DESERT_PYRAMID, BuiltInLootTables.STRONGHOLD_LIBRARY, BuiltInLootTables.BASTION_TREASURE, BuiltInLootTables.FISHING_TREASURE);

    public static void init() {
        LootEvent.MODIFY_LOOT_TABLE.register((lootTables, id, context, builtin) -> {
            if (SCROLL_TABLES.contains(id)) {
                LootPool.Builder pool = LootPool.lootPool()
                        .add(LootItem.lootTableItem(SummonerScrollsItems.ZOMBIE_SCROLL.get()))
                        .add(LootItem.lootTableItem(SummonerScrollsItems.SKELETON_SCROLL.get()))
                        .add(LootItem.lootTableItem(SummonerScrollsItems.SPIDER_SCROLL.get()))
                        .add(LootItem.lootTableItem(SummonerScrollsItems.ENDERMAN_SCROLL.get()));
                context.addPool(pool);
            }
        });
    }
}
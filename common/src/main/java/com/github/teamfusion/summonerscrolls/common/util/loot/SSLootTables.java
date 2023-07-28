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
    public static final Collection<ResourceLocation> TIER_ONE_SCROLL_TABLES = Set.of(BuiltInLootTables.SIMPLE_DUNGEON, BuiltInLootTables.WOODLAND_MANSION);
    public static final Collection<ResourceLocation> TIER_TWO_SCROLL_TABLES = Set.of(BuiltInLootTables.BASTION_TREASURE, BuiltInLootTables.BASTION_BRIDGE, BuiltInLootTables.BASTION_HOGLIN_STABLE, BuiltInLootTables.BASTION_OTHER, BuiltInLootTables.WOODLAND_MANSION);
    public static final Collection<ResourceLocation> TIER_THREE_SCROLL_TABLES = Set.of(BuiltInLootTables.END_CITY_TREASURE, BuiltInLootTables.WOODLAND_MANSION);

    private static final Map<Collection<ResourceLocation>, List<Supplier<Item>>> LOOT_PER_TIER = ImmutableMap.of(
            TIER_ONE_SCROLL_TABLES, List.of(SSItems.ZOMBIE_SCROLL, SSItems.SPIDER_SCROLL, SSItems.SPIDER_JOCKEY_SCROLL, SSItems.SKELETON_SCROLL, SSItems.BEE_SCROLL),
            TIER_TWO_SCROLL_TABLES, List.of(SSItems.HUSK_SCROLL, SSItems.STRAY_SCROLL, SSItems.CAVE_SPIDER_SCROLL, SSItems.ENDERMAN_SCROLL, SSItems.PIGLIN_SCROLL),
            TIER_THREE_SCROLL_TABLES, List.of(SSItems.CREEPER_SCROLL, SSItems.PIGLIN_BRUTE_SCROLL, SSItems.SHULKERMAN_SCROLL, SSItems.IRON_GOLEM_SCROLL, SSItems.CHARGED_CREEPER_SCROLL)
    );

    public static void init() {
        LootRegistry.modify((tables, location, context, builtin) -> {
            LOOT_PER_TIER.forEach((lootTable, items) -> {
                if (lootTable.contains(location)) {
                    items.forEach(item -> {
                        LootPool.Builder pool = LootPool.lootPool().add(LootItem.lootTableItem(item.get())).setRolls(BinomialDistributionGenerator.binomial(1, getTierProbability(lootTable)));
                        context.addPool(pool);
                    });
                }
            });
        });
    }

    // Adjust these probabilities as per rarity preference
    private static float getTierProbability(Collection<ResourceLocation> lootTable) {
        if (lootTable == TIER_ONE_SCROLL_TABLES) {
            return 0.1F;
        } else if (lootTable == TIER_TWO_SCROLL_TABLES) {
            return 0.3F;
        } else if (lootTable == TIER_THREE_SCROLL_TABLES) {
            return 0.5F;
        } else {
            return 0.6F; // Default probability if the loot table doesn't belong to any tier
        }
    }
}
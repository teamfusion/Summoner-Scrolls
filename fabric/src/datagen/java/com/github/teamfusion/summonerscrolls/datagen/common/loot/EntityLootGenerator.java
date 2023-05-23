package com.github.teamfusion.summonerscrolls.datagen.common.loot;

import com.github.teamfusion.summonerscrolls.common.registry.SSEntityTypes;
import com.github.teamfusion.summonerscrolls.common.registry.SSItems;
import net.fabricmc.fabric.api.datagen.v1.FabricDataGenerator;
import net.fabricmc.fabric.api.datagen.v1.provider.SimpleFabricLootTableProvider;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.level.storage.loot.LootPool;
import net.minecraft.world.level.storage.loot.LootTable;
import net.minecraft.world.level.storage.loot.entries.LootItem;
import net.minecraft.world.level.storage.loot.functions.LootingEnchantFunction;
import net.minecraft.world.level.storage.loot.parameters.LootContextParamSets;
import net.minecraft.world.level.storage.loot.predicates.LootItemKilledByPlayerCondition;
import net.minecraft.world.level.storage.loot.predicates.LootItemRandomChanceCondition;
import net.minecraft.world.level.storage.loot.predicates.LootItemRandomChanceWithLootingCondition;
import net.minecraft.world.level.storage.loot.providers.number.ConstantValue;

import java.util.function.BiConsumer;
import java.util.function.Supplier;

public class EntityLootGenerator extends SimpleFabricLootTableProvider {
    public EntityLootGenerator(FabricDataGenerator dataGenerator) {
        super(dataGenerator, LootContextParamSets.ENTITY);
    }

    @Override
    public void accept(BiConsumer<ResourceLocation, LootTable.Builder> consumer) {
        /* Tier 1 */
        this.add(SSEntityTypes.ZOMBIE_SUMMON, consumer, LootTable.lootTable()
                .withPool(LootPool.lootPool().setRolls(ConstantValue.exactly(1))
                        .add(LootItem.lootTableItem(SSItems.ZOMBIE_SCROLL.get()))
                        .when(LootItemKilledByPlayerCondition.killedByPlayer())
                        .when(LootItemRandomChanceWithLootingCondition.randomChanceAndLootingBoost(0.025F, 0.01F))
                )
        );
        this.add(SSEntityTypes.SPIDER_SUMMON, consumer, LootTable.lootTable()
                .withPool(LootPool.lootPool().setRolls(ConstantValue.exactly(1))
                        .add(LootItem.lootTableItem(SSItems.SPIDER_SCROLL.get()))
                        .when(LootItemKilledByPlayerCondition.killedByPlayer())
                        .when(LootItemRandomChanceWithLootingCondition.randomChanceAndLootingBoost(0.025F, 0.01F))
                )
        );
        this.add(SSEntityTypes.SKELETON_SUMMON, consumer, LootTable.lootTable()
                .withPool(LootPool.lootPool().setRolls(ConstantValue.exactly(1))
                        .add(LootItem.lootTableItem(SSItems.SKELETON_SCROLL.get()))
                        .when(LootItemKilledByPlayerCondition.killedByPlayer())
                        .when(LootItemRandomChanceWithLootingCondition.randomChanceAndLootingBoost(0.025F, 0.01F))
                )
        );
        this.add(SSEntityTypes.BEE_SUMMON, consumer, LootTable.lootTable()
                .withPool(LootPool.lootPool().setRolls(ConstantValue.exactly(1))
                        .add(LootItem.lootTableItem(SSItems.BEE_SCROLL.get()).when(LootItemRandomChanceCondition.randomChance(0.01F)))
                        .apply(LootingEnchantFunction.lootingMultiplier(ConstantValue.exactly(0.01F)))
                        .when(LootItemKilledByPlayerCondition.killedByPlayer())
                )
        );

        /* Tier 2 */
        this.add(SSEntityTypes.HUSK_SUMMON, consumer, LootTable.lootTable()
                .withPool(LootPool.lootPool().setRolls(ConstantValue.exactly(1))
                        .add(LootItem.lootTableItem(SSItems.HUSK_SCROLL.get()))
                        .when(LootItemKilledByPlayerCondition.killedByPlayer())
                        .when(LootItemRandomChanceWithLootingCondition.randomChanceAndLootingBoost(0.025F, 0.01F))
                )
        );
        this.add(SSEntityTypes.STRAY_SUMMON, consumer, LootTable.lootTable()
                .withPool(LootPool.lootPool().setRolls(ConstantValue.exactly(1))
                        .add(LootItem.lootTableItem(SSItems.STRAY_SCROLL.get()))
                        .when(LootItemKilledByPlayerCondition.killedByPlayer())
                        .when(LootItemRandomChanceWithLootingCondition.randomChanceAndLootingBoost(0.025F, 0.01F))
                )
        );
        this.add(SSEntityTypes.CAVE_SPIDER_SUMMON, consumer, LootTable.lootTable()
                .withPool(LootPool.lootPool().setRolls(ConstantValue.exactly(1))
                        .add(LootItem.lootTableItem(SSItems.CAVE_SPIDER_SCROLL.get()))
                        .when(LootItemKilledByPlayerCondition.killedByPlayer())
                        .when(LootItemRandomChanceWithLootingCondition.randomChanceAndLootingBoost(0.025F, 0.01F))
                )
        );
        this.add(SSEntityTypes.ENDERMAN_SUMMON, consumer, LootTable.lootTable()
                .withPool(LootPool.lootPool().setRolls(ConstantValue.exactly(1))
                        .add(LootItem.lootTableItem(SSItems.ENDERMAN_SCROLL.get()))
                        .when(LootItemKilledByPlayerCondition.killedByPlayer())
                        .when(LootItemRandomChanceWithLootingCondition.randomChanceAndLootingBoost(0.025F, 0.01F))
                )
        );
        this.add(SSEntityTypes.PIGLIN_SUMMON, consumer, LootTable.lootTable()
                .withPool(LootPool.lootPool().setRolls(ConstantValue.exactly(1))
                        .add(LootItem.lootTableItem(SSItems.PIGLIN_SCROLL.get()).when(LootItemRandomChanceCondition.randomChance(0.01F)))
                        .apply(LootingEnchantFunction.lootingMultiplier(ConstantValue.exactly(0.01F)))
                        .when(LootItemKilledByPlayerCondition.killedByPlayer())
                )
        );

        /* TODO - Tier 3 */
        this.add(SSEntityTypes.CREEPER_SUMMON, consumer, LootTable.lootTable()
                .withPool(LootPool.lootPool().setRolls(ConstantValue.exactly(1))
                        .add(LootItem.lootTableItem(SSItems.CREEPER_SCROLL.get()))
                        .when(LootItemKilledByPlayerCondition.killedByPlayer())
                        .when(LootItemRandomChanceWithLootingCondition.randomChanceAndLootingBoost(0.025F, 0.01F))
                )
        );
        this.add(SSEntityTypes.CHARGED_CREEPER_SUMMON, consumer, LootTable.lootTable()
                .withPool(LootPool.lootPool().setRolls(ConstantValue.exactly(1))
                        .add(LootItem.lootTableItem(SSItems.CHARGED_CREEPER_SCROLL.get()))
                        .when(LootItemKilledByPlayerCondition.killedByPlayer())
                        .when(LootItemRandomChanceWithLootingCondition.randomChanceAndLootingBoost(0.025F, 0.01F))
                )
        );
        this.add(SSEntityTypes.PIGLIN_BRUTE_SUMMON, consumer, LootTable.lootTable()
                .withPool(LootPool.lootPool().setRolls(ConstantValue.exactly(1))
                        .add(LootItem.lootTableItem(SSItems.PIGLIN_BRUTE_SCROLL.get()))
                        .when(LootItemKilledByPlayerCondition.killedByPlayer())
                        .when(LootItemRandomChanceWithLootingCondition.randomChanceAndLootingBoost(0.025F, 0.01F))
                )
        );
        this.add(SSEntityTypes.SHULKERMAN_SUMMON, consumer, LootTable.lootTable()
                .withPool(LootPool.lootPool().setRolls(ConstantValue.exactly(1))
                        .add(LootItem.lootTableItem(SSItems.IRON_GOLEM_SCROLL.get()))
                        .when(LootItemKilledByPlayerCondition.killedByPlayer())
                        .when(LootItemRandomChanceWithLootingCondition.randomChanceAndLootingBoost(0.025F, 0.01F))
                )
        );
        this.add(SSEntityTypes.IRON_GOLEM_SUMMON, consumer, LootTable.lootTable()
                .withPool(LootPool.lootPool().setRolls(ConstantValue.exactly(1))
                        .add(LootItem.lootTableItem(SSItems.IRON_GOLEM_SCROLL.get()))
                        .when(LootItemKilledByPlayerCondition.killedByPlayer())
                        .when(LootItemRandomChanceWithLootingCondition.randomChanceAndLootingBoost(0.025F, 0.01F))
                )
        );
    }

    private <T extends Entity> void add(Supplier<EntityType<T>> type, BiConsumer<ResourceLocation, LootTable.Builder> consumer, LootTable.Builder builder) {
        consumer.accept(type.get().getDefaultLootTable(), builder);
    }

    @SuppressWarnings("unused")
    private void add(ResourceLocation type, BiConsumer<ResourceLocation, LootTable.Builder> consumer, LootTable.Builder builder) {
        consumer.accept(type, builder);
    }
}
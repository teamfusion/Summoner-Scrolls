package com.github.teamfusion.summonerscrolls.common.registry;

import com.github.teamfusion.summonerscrolls.common.entity.ISummon;
import com.github.teamfusion.summonerscrolls.common.util.ScrollUtil;
import net.minecraft.network.chat.Component;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.MobSpawnType;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.TieredItem;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.gameevent.GameEvent;

public class SSEvents {
    public static void useScroll(Player player, InteractionHand hand) {
        Level level = player.getLevel();
        if (level.isClientSide()) {
            // Do nothing if this is the client side
            return;
        }

        // Get the item in the player's hand
        ItemStack itemStack = player.getItemInHand(hand);

        // Check if the item is a TieredItem
        if (itemStack.getItem() instanceof TieredItem item) {
            // Check if the item is on cooldown and the player has enough XP
            int xpCost = player.isCreative() ? ScrollUtil.getXP(itemStack) : 0;
            player.giveExperienceLevels(-xpCost);
            if (!player.getCooldowns().isOnCooldown(item) && player.experienceLevel >= xpCost) {
                // Get the entity type and spawn the entity
                EntityType<?> entityType = ScrollUtil.getEntityType(itemStack);
                Entity entity = entityType.spawn((ServerLevel) level, itemStack, player, player.blockPosition().offset(player.getDirection().getNormal()), MobSpawnType.MOB_SUMMONED, true, true);
                if (entityType == SSEntityTypes.BEE_SUMMON.get()) {
                    entityType.spawn((ServerLevel) level, itemStack, player, player.blockPosition().offset(player.getDirection().getNormal()), MobSpawnType.MOB_SUMMONED, true, true);
                    entityType.spawn((ServerLevel) level, itemStack, player, player.blockPosition().offset(player.getDirection().getNormal()), MobSpawnType.MOB_SUMMONED, true, true);
                    entityType.spawn((ServerLevel) level, itemStack, player, player.blockPosition().offset(player.getDirection().getNormal()), MobSpawnType.MOB_SUMMONED, true, true);
                    entityType.spawn((ServerLevel) level, itemStack, player, player.blockPosition().offset(player.getDirection().getNormal()), MobSpawnType.MOB_SUMMONED, true, true);
                }
                if (entityType == SSEntityTypes.CAVE_SPIDER_SUMMON.get()) {
                    entityType.spawn((ServerLevel) level, itemStack, player, player.blockPosition().offset(player.getDirection().getNormal()), MobSpawnType.MOB_SUMMONED, true, true);
                    entityType.spawn((ServerLevel) level, itemStack, player, player.blockPosition().offset(player.getDirection().getNormal()), MobSpawnType.MOB_SUMMONED, true, true);
                }
                // Check if the entity is an ISummon
                if (entity instanceof ISummon summon) {
                    // Set the owner UUID, add cooldown, set despawn delay, deduct XP, damage item
                    summon.setOwnerUUID(player.getUUID());
                    if (!player.isCreative()) {
                        player.getCooldowns().addCooldown(item, 1200);
                        summon.setDespawnDelay(600);
                        itemStack.hurt(ScrollUtil.getDurability(itemStack), level.random, (ServerPlayer) player);
                    }

                    // Trigger ENTITY_PLACE event, display success message
                    level.gameEvent(player, GameEvent.ENTITY_PLACE, player.blockPosition().offset(player.getDirection().getNormal()));
                    String entityName = entity.getDisplayName().getString();
                    player.displayClientMessage(Component.translatable("message.summonerscrolls.summon_success", entityName), true);
                }
            }
            // Display appropriate error message
            if (player.getCooldowns().isOnCooldown(item)) {
                // Display cooldown message
                float cooldownTicks = player.getCooldowns().getCooldownPercent(item, 0);
                int remainingTicks = (int) (cooldownTicks * 600);
                // 20 ticks in 1 second
                int remainingSeconds = Math.max(0, remainingTicks / 20);
                player.displayClientMessage(Component.translatable("message.summonerscrolls.cooldown", remainingSeconds), true);
            } else if (player.experienceLevel < xpCost) {
                player.displayClientMessage(Component.translatable("message.summonerscrolls.not_enough_xp", xpCost), true);
            }
        }
    }
}
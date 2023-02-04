package com.github.teamfusion.summonerscrolls;

import com.github.teamfusion.summonerscrolls.client.SSClient;
import com.github.teamfusion.summonerscrolls.client.particle.SummonerScrollsParticles;
import com.github.teamfusion.summonerscrolls.common.entity.ISummon;
import com.github.teamfusion.summonerscrolls.common.registry.SSEnchantments;
import com.github.teamfusion.summonerscrolls.common.registry.SSEntityTypes;
import com.github.teamfusion.summonerscrolls.common.registry.SSItems;
import com.github.teamfusion.summonerscrolls.common.sound.SummonerScrollsSoundEvents;
import com.github.teamfusion.summonerscrolls.common.util.ScrollUtil;
import com.github.teamfusion.summonerscrolls.common.util.loot.SSLootTables;
import com.github.teamfusion.summonerscrolls.common.util.trade.SSTrades;
import dev.architectury.event.EventResult;
import dev.architectury.event.events.common.InteractionEvent;
import dev.architectury.registry.CreativeTabRegistry;
import dev.architectury.utils.EnvExecutor;
import net.fabricmc.api.EnvType;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.InteractionResultHolder;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.MobSpawnType;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.SwordItem;
import net.minecraft.world.item.TieredItem;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.gameevent.GameEvent;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Objects;

public class SummonerScrolls {
    public static final String MOD_ID = "summonerscrolls";
    public static final String MOD_NAME = "Summoner Scrolls";
    public static final Logger LOGGER = LoggerFactory.getLogger(MOD_NAME);

    public static final CreativeModeTab SCROLLS_TAB = CreativeTabRegistry.create(new ResourceLocation(MOD_ID, "scrolls_tab"), () ->
            new ItemStack(SSItems.ENHANCEMENT_SCROLL.get()));
    
    public static void commonInitialize() {
        LOGGER.info("Initializing {}", MOD_NAME);

        SSEnchantments.ENCHANTMENTS.register();
        SSItems.ITEMS.register();
        SSEntityTypes.ENTITY_TYPES.register();
        SummonerScrollsSoundEvents.SOUND_EVENTS.register();

        SSEntityTypes.postRegister();

        SummonerScrollsParticles.init();
        SSLootTables.init();
        SSTrades.init();

        InteractionEvent.RIGHT_CLICK_BLOCK.register((Player player, InteractionHand hand, BlockPos pos, Direction face) -> {
            ItemStack stack = player.getItemInHand(hand);
            EntityType<?> entityType2 = ScrollUtil.getEntityType(stack);
            Level level = player.getLevel();
            BlockState blockState = level.getBlockState(pos);

            if (stack.getItem() instanceof SwordItem) {
                BlockPos blockPos2;
                if (blockState.getCollisionShape(level, pos).isEmpty()) {
                    blockPos2 = pos;
                } else {
                    blockPos2 = pos.relative(face);
                }
                if (player.totalExperience >= ScrollUtil.getXP(stack)) {
                    Entity summon = entityType2.spawn((ServerLevel) level, stack, player, blockPos2, MobSpawnType.MOB_SUMMONED, true, !Objects.equals(pos, blockPos2) && face == Direction.UP);
                    if (summon instanceof ISummon mob) {
                        spawnSummon(player, stack, level, pos, mob);
                        return EventResult.interruptTrue();
                    }
                }
            }
            return EventResult.pass();
        });

        InteractionEvent.CLIENT_RIGHT_CLICK_AIR.register((Player player, InteractionHand hand) -> {
            ItemStack stack = player.getItemInHand(hand);
            EntityType<?> entityType = ScrollUtil.getEntityType(stack);
            ItemStack itemStack = player.getItemInHand(hand);
            BlockPos blockPos = player.getOnPos();
            Level level = player.getLevel();

            if (stack.getItem() instanceof TieredItem) {
                if (level.mayInteract(player, blockPos)) {
                    if (player.totalExperience >= ScrollUtil.getXP(stack)) {
                        Entity summon = entityType.spawn((ServerLevel) level, itemStack, player, blockPos, MobSpawnType.MOB_SUMMONED, true, true);
                        if (summon instanceof ISummon mob) {
                            spawnSummon(player, stack, level, blockPos, mob);
                        }
                    }
                }
            }
        });

        EnvExecutor.runInEnv(EnvType.CLIENT, () -> SSClient::commonClientInitialize);
    }

    private static void spawnSummon(Player player, ItemStack stack, Level level, BlockPos blockPos, ISummon mob) {
        mob.setOwnerUUID(player.getUUID());
        player.getCooldowns().addCooldown(stack.getItem(), 1200);
        mob.setDespawnDelay(600);
        player.giveExperiencePoints(-ScrollUtil.getXP(stack));
        stack.hurt(ScrollUtil.getDurability(stack), level.random, (ServerPlayer) player);

        level.gameEvent(player, GameEvent.ENTITY_PLACE, blockPos);
    }

    //todo: put todos in respective classes
    //todo: blue enchantment glare for summon scrolls
    //todo: create spawn eggs
    //TODO: add enchantment target for all tools
    //todo: add comments for everything
    //todo: use less accesswidener stuff and more accessors
}
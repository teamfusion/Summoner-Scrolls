package com.github.teamfusion.summonerscrolls.fabric;

import com.github.teamfusion.summonerscrolls.SummonerScrolls;
import com.github.teamfusion.summonerscrolls.common.entity.ISummon;
import com.github.teamfusion.summonerscrolls.common.registry.SSEvents;
import com.github.teamfusion.summonerscrolls.common.util.ScrollUtil;
import net.fabricmc.api.ModInitializer;
import net.fabricmc.fabric.api.event.player.UseItemCallback;
import net.minecraft.network.chat.TranslatableComponent;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResultHolder;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.MobSpawnType;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.TieredItem;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.gameevent.GameEvent;

public class SummonerScrollsFabric implements ModInitializer {
    @Override
    public void onInitialize() {
        UseItemCallback.EVENT.register((player, world, hand)-> {
            SSEvents.useScroll(player, hand);
            return InteractionResultHolder.pass(ItemStack.EMPTY);
        });
        SummonerScrolls.commonInitialize();
    }
}
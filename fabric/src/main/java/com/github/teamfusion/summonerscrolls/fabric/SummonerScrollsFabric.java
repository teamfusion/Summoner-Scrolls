package com.github.teamfusion.summonerscrolls.fabric;

import com.github.teamfusion.summonerscrolls.SummonerScrolls;
import com.github.teamfusion.summonerscrolls.common.registry.SSEvents;
import net.fabricmc.api.ModInitializer;
import net.fabricmc.fabric.api.event.player.UseItemCallback;
import net.minecraft.world.InteractionResultHolder;
import net.minecraft.world.item.ItemStack;

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
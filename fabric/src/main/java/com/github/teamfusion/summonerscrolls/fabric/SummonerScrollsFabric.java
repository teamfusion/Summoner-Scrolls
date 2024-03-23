package com.github.teamfusion.summonerscrolls.fabric;

import com.github.teamfusion.summonerscrolls.SummonerScrolls;
import com.github.teamfusion.summonerscrolls.common.registry.SSEvents;
import com.github.teamfusion.summonerscrolls.common.registry.SSItems;
import net.fabricmc.api.ModInitializer;
import net.fabricmc.fabric.api.event.player.UseItemCallback;
import net.fabricmc.fabric.api.itemgroup.v1.FabricItemGroup;
import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.minecraft.core.Registry;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceKey;
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
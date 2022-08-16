package com.github.teamfusion.summoner_scrolls.forge;

import com.github.teamfusion.summoner_scrolls.SummonerScrolls;
import com.github.teamfusion.summoner_scrolls.item.SummonerScrollsItems;
import dev.architectury.platform.forge.EventBuses;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;

@Mod(SummonerScrolls.MOD_ID)
public class SummonerScrollsForge {
    public SummonerScrollsForge() {
        EventBuses.registerModEventBus(SummonerScrolls.MOD_ID, FMLJavaModLoadingContext.get().getModEventBus());
        SummonerScrolls.commonInitialize();
    }
}
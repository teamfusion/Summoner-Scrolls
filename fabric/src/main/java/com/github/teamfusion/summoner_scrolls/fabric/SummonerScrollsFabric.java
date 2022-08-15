package com.github.teamfusion.summoner_scrolls.fabric;

import com.github.teamfusion.summoner_scrolls.SummonerScrolls;
import net.fabricmc.api.ModInitializer;

public class SummonerScrollsFabric implements ModInitializer {
    @Override
    public void onInitialize() {
        SummonerScrolls.init();
    }
}
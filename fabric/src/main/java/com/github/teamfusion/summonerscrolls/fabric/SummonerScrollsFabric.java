package com.github.teamfusion.summonerscrolls.fabric;

import com.github.teamfusion.summonerscrolls.SummonerScrolls;
import net.fabricmc.api.ModInitializer;

public class SummonerScrollsFabric implements ModInitializer {
    @Override
    public void onInitialize() {
        SummonerScrolls.commonInitialize();
    }
}
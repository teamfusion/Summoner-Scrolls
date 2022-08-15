package com.github.teamfusion.summoner_scrolls.quilt;

import com.github.teamfusion.summoner_scrolls.SummonerScrolls;
import org.quiltmc.loader.api.ModContainer;
import org.quiltmc.qsl.base.api.entrypoint.ModInitializer;

public class SummonerScrollsQuilt implements ModInitializer {
    @Override
    public void onInitialize(ModContainer mod) {
        SummonerScrolls.init();
    }
}
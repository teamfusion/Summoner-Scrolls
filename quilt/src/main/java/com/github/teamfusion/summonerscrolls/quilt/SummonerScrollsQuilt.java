package com.github.teamfusion.summonerscrolls.quilt;

import com.github.teamfusion.summonerscrolls.SummonerScrolls;
import org.quiltmc.loader.api.ModContainer;
import org.quiltmc.qsl.base.api.entrypoint.ModInitializer;

public class SummonerScrollsQuilt implements ModInitializer {
    @Override
    public void onInitialize(ModContainer mod) {
        SummonerScrolls.commonInitialize();
    }
    //todo: update quilt
}
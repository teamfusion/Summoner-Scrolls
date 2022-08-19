package com.github.teamfusion.summonerscrolls.forge;

import com.github.teamfusion.summonerscrolls.SummonerScrolls;
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
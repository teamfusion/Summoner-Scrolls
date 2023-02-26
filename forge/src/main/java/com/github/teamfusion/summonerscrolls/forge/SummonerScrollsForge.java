package com.github.teamfusion.summonerscrolls.forge;

import com.github.teamfusion.summonerscrolls.SummonerScrolls;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.fml.common.Mod;

@Mod(SummonerScrolls.MOD_ID)
public class SummonerScrollsForge {
    public SummonerScrollsForge() {
//        var bus = FMLJavaModLoadingContext.get().getModEventBus();
//
//        EventBuses.registerModEventBus(SummonerScrolls.MOD_ID, bus);
        SummonerScrolls.commonInitialize();

        MinecraftForge.EVENT_BUS.register(CommonEvents.class);
    }
}
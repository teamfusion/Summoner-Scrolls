package com.github.teamfusion.summonerscrolls.forge;

import com.github.teamfusion.summonerscrolls.SummonerScrolls;
import dev.architectury.platform.forge.EventBuses;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;

@Mod(SummonerScrolls.MOD_ID)
public class SummonerScrollsForge {
    public SummonerScrollsForge() {
        var bus = FMLJavaModLoadingContext.get().getModEventBus();

        EventBuses.registerModEventBus(SummonerScrolls.MOD_ID, bus);
        SummonerScrolls.commonInitialize();

        MinecraftForge.EVENT_BUS.register(AnvilUpdateEvents.class);
    }
}
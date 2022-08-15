package com.github.teamfusion.summoner_scrolls.fabric;

import com.github.teamfusion.summoner_scrolls.SummonerScrollsExpectPlatform;
import net.fabricmc.loader.api.FabricLoader;

import java.nio.file.Path;

public class SummonerScrollsExpectPlatformImpl {
    /**
     * This is our actual method to {@link SummonerScrollsExpectPlatform#getConfigDirectory()}.
     */
    public static Path getConfigDirectory() {
        return FabricLoader.getInstance().getConfigDir();
    }
}

package com.github.teamfusion.summoner_scrolls.fabric;

import com.github.teamfusion.summoner_scrolls.SummonerScrollsExpectPlatform;
import org.quiltmc.loader.api.QuiltLoader;

import java.nio.file.Path;

public class SummonerScrollsExpectPlatformImpl {
    /**
     * This is our actual method to {@link SummonerScrollsExpectPlatform#getConfigDirectory()}.
     */
    public static Path getConfigDirectory() {
        return QuiltLoader.getConfigDir();
    }
}

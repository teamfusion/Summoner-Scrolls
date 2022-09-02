package com.github.teamfusion.summonerscrolls.fabric;

import com.github.teamfusion.summonerscrolls.SummonerScrollsExpectPlatform;
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

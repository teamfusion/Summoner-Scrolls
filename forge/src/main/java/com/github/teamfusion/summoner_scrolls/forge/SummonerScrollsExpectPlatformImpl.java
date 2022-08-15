package com.github.teamfusion.summoner_scrolls.forge;

import com.github.teamfusion.summoner_scrolls.SummonerScrollsExpectPlatform;
import net.minecraftforge.fml.loading.FMLPaths;

import java.nio.file.Path;

public class SummonerScrollsExpectPlatformImpl {
    /**
     * This is our actual method to {@link SummonerScrollsExpectPlatform#getConfigDirectory()}.
     */
    public static Path getConfigDirectory() {
        return FMLPaths.CONFIGDIR.get();
    }
}

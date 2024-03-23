package com.github.teamfusion.summonerscrolls.platform;

import dev.architectury.injectables.annotations.ExpectPlatform;

public class Environment {
    @ExpectPlatform
    public static boolean isClientSide() {
        throw new AssertionError();
    }
}
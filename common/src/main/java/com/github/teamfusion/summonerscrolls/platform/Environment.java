package com.github.teamfusion.summonerscrolls.platform;

import dev.architectury.injectables.annotations.ExpectPlatform;

public class Environment {
//    @ExpectPlatform
//    public static CreativeModeTab createTab(ResourceLocation location, Supplier<ItemStack> icon) {
//        throw new AssertionError();
//    }

    @ExpectPlatform
    public static boolean isClientSide() {
        throw new AssertionError();
    }
}
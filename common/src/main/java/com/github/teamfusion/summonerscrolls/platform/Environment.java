package com.github.teamfusion.summonerscrolls.platform;

import dev.architectury.injectables.annotations.ExpectPlatform;
import net.minecraft.world.item.CreativeModeTab;

import java.util.function.Consumer;

public class Environment {
    @ExpectPlatform
    public static CreativeModeTab createTab(Consumer<CreativeModeTab.Builder> mapper) {
        throw new AssertionError();
    }

    @ExpectPlatform
    public static boolean isClientSide() {
        throw new AssertionError();
    }
}
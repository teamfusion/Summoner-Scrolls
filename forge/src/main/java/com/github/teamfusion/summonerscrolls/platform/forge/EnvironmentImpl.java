package com.github.teamfusion.summonerscrolls.platform.forge;

import net.minecraft.world.item.CreativeModeTab;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.fml.loading.FMLLoader;

import java.util.function.Consumer;

public class EnvironmentImpl {
    public static CreativeModeTab createTab(Consumer<CreativeModeTab.Builder> consumer) {
        CreativeModeTab.Builder builder = CreativeModeTab.builder();
        consumer.accept(builder);
        return builder.build();
    }

    public static boolean isClientSide() {
        return FMLLoader.getDist() == Dist.CLIENT;
    }
}

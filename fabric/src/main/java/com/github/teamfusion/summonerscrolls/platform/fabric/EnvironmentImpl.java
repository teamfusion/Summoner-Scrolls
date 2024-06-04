package com.github.teamfusion.summonerscrolls.platform.fabric;

import net.fabricmc.api.EnvType;
import net.fabricmc.fabric.api.itemgroup.v1.FabricItemGroup;
import net.fabricmc.loader.api.FabricLoader;
import net.minecraft.world.item.CreativeModeTab;

import java.util.function.Consumer;

public class EnvironmentImpl {
    public static CreativeModeTab createTab(Consumer<CreativeModeTab.Builder> mapper) {
        CreativeModeTab.Builder builder = FabricItemGroup.builder();
        mapper.accept(builder);
        return builder.build();
    }
    
    public static boolean isClientSide() {
        return FabricLoader.getInstance().getEnvironmentType() == EnvType.CLIENT;
    }
}

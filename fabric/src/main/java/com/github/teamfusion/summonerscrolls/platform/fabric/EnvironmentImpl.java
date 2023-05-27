package com.github.teamfusion.summonerscrolls.platform.fabric;

import net.fabricmc.api.EnvType;
import net.fabricmc.fabric.api.itemgroup.v1.FabricItemGroup;
import net.fabricmc.loader.api.FabricLoader;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.ItemStack;

import java.util.function.Supplier;

public class EnvironmentImpl {
    public static CreativeModeTab createTab(ResourceLocation location, Supplier<ItemStack> icon) {
        return FabricItemGroup.builder(location).icon(icon).build();
    }

    public static boolean isClientSide() {
        return FabricLoader.getInstance().getEnvironmentType() == EnvType.CLIENT;
    }
}

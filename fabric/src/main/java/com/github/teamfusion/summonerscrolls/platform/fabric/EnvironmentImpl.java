package com.github.teamfusion.summonerscrolls.platform.fabric;

import com.github.teamfusion.summonerscrolls.common.registry.SSItems;
import net.fabricmc.api.EnvType;
import net.fabricmc.fabric.api.itemgroup.v1.FabricItemGroup;
import net.fabricmc.loader.api.FabricLoader;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.ItemStack;

import java.util.function.Supplier;

public class EnvironmentImpl {
    public static CreativeModeTab createTab(ResourceLocation location, Supplier<ItemStack> icon) {
        return FabricItemGroup.builder().icon(icon).title(Component.literal(location.getPath())).displayItems((itemDisplayParameters, output) -> {
            output.accept(SSItems.BEE_SCROLL.get());
        }).build();
    }

    public static boolean isClientSide() {
        return FabricLoader.getInstance().getEnvironmentType() == EnvType.CLIENT;
    }
}

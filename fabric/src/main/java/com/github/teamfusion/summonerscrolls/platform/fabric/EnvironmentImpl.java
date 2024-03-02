package com.github.teamfusion.summonerscrolls.platform.fabric;

import com.github.teamfusion.summonerscrolls.common.registry.SSItems;
import net.fabricmc.api.EnvType;
import net.fabricmc.fabric.api.itemgroup.v1.FabricItemGroup;
import net.fabricmc.loader.api.FabricLoader;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;

import java.util.List;
import java.util.function.Supplier;

public class EnvironmentImpl {
    public static CreativeModeTab createTab(String location, Supplier<ItemStack> icon, List<Item> items) {
        return FabricItemGroup.builder()
                .icon(() -> new ItemStack(icon.get().getItem()))
                .title(Component.literal(location))
                .displayItems((enabledFeatures, entries) -> {
                    for (Item item: items) {
                        entries.accept(item);
                    }
                    entries.accept(SSItems.BEE_SCROLL.get());
                })
                .build();
    }

    public static boolean isClientSide() {
        return FabricLoader.getInstance().getEnvironmentType() == EnvType.CLIENT;
    }
}

package com.github.teamfusion.summonerscrolls.common.registry;

import com.github.teamfusion.summonerscrolls.SummonerScrolls;
import com.github.teamfusion.summonerscrolls.platform.CoreRegistry;
import com.github.teamfusion.summonerscrolls.platform.common.resource.CreativeModTabBuilder;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;

import java.util.function.Supplier;

public class SSCreativeTabs {
    public static final CoreRegistry<CreativeModeTab> TABS = CoreRegistry.create(BuiltInRegistries.CREATIVE_MODE_TAB, SummonerScrolls.MOD_ID);

    public static final Supplier<CreativeModeTab> SCROLLS_TAB = TABS.register("scrolls_tab", ()-> createTab(
            new ResourceLocation(SummonerScrolls.MOD_ID),
            () -> new ItemStack(SSItems.ENHANCEMENT_SCROLL.get()),
            (itemDisplayParameters, output) -> SSItems.ENTRIES.forEach(item -> output.accept(item.get()))
    ));

    public static CreativeModeTab createTab(ResourceLocation location, Supplier<ItemStack> icon, CreativeModeTab.DisplayItemsGenerator itemsGenerator) {
        return new CreativeModTabBuilder().title(Component.keybind(location.toString())).icon(icon).displayItems(itemsGenerator).build();
    }
}
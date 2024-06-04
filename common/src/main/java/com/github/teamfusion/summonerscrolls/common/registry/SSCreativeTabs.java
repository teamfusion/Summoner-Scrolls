package com.github.teamfusion.summonerscrolls.common.registry;

import com.github.teamfusion.summonerscrolls.SummonerScrolls;
import com.github.teamfusion.summonerscrolls.platform.CoreRegistry;
import com.github.teamfusion.summonerscrolls.platform.Environment;
import dev.architectury.registry.CreativeTabRegistry;
import dev.architectury.registry.registries.DeferredRegister;
import dev.architectury.registry.registries.RegistrySupplier;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.core.registries.Registries;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.CreativeModeTabs;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;

import java.util.function.Supplier;

public class SSCreativeTabs {
    public static final CoreRegistry<CreativeModeTab> TABS = CoreRegistry.create(BuiltInRegistries.CREATIVE_MODE_TAB, SummonerScrolls.MOD_ID);

    public static final Supplier<CreativeModeTab> SUMMONER_SCROLLS = TABS.register(
        "summoner_scrolls",
        () -> Environment.createTab(builder -> {
            builder.title(Component.translatable("tab.summoner_scrolls"));
            builder.icon(() -> new ItemStack(SSItems.BEE_SCROLL.get()));
            builder.displayItems((parameters, output) -> {
                output.accept(SSItems.ZOMBIE_SCROLL.get());
                output.accept(SSItems.SPIDER_SCROLL.get());
                output.accept(SSItems.SKELETON_SCROLL.get());
                output.accept(SSItems.BEE_SCROLL.get());
                output.accept(SSItems.HUSK_SCROLL.get());
                output.accept(SSItems.STRAY_SCROLL.get());
                output.accept(SSItems.CAVE_SPIDER_SCROLL.get());
                output.accept(SSItems.ENDERMAN_SCROLL.get());
                output.accept(SSItems.PIGLIN_SCROLL.get());
                output.accept(SSItems.CREEPER_SCROLL.get());
                output.accept(SSItems.CHARGED_CREEPER_SCROLL.get());
                output.accept(SSItems.PIGLIN_BRUTE_SCROLL.get());
                output.accept(SSItems.SHULKERMAN_SCROLL.get());
                output.accept(SSItems.IRON_GOLEM_SCROLL.get());
            });
            builder.build();
        })
    );
}
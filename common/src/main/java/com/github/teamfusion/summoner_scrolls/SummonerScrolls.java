package com.github.teamfusion.summoner_scrolls;

import com.github.teamfusion.enchantment.SummonerScrollsEnchantments;
import com.github.teamfusion.summoner_scrolls.item.SummonerScrollsItems;
import dev.architectury.registry.CreativeTabRegistry;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.ItemStack;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class SummonerScrolls {
    public static final String MOD_ID = "summoner_scrolls";
    public static final String MOD_NAME = "Summoner Scrolls";
    public static final Logger LOGGER = LoggerFactory.getLogger(MOD_NAME);

    public static final CreativeModeTab SCROLLS_TAB = CreativeTabRegistry.create(new ResourceLocation(MOD_ID, "scrolls_tab"), () ->
            new ItemStack(SummonerScrollsItems.EMPTY_SUMMONER_SCROLL.get()));
    
    public static void commonInitialize() {
        LOGGER.info("Initializing {}", MOD_NAME);

        SummonerScrollsItems.ITEMS.register();
        SummonerScrollsEnchantments.ENCHANTMENTS.register();
    }

    //TODO: add lang
}
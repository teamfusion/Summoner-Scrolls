package com.github.teamfusion.summoner_scrolls;

import dev.architectury.registry.CreativeTabRegistry;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;

public class SummonerScrolls {
    public static final String MOD_ID = "summoner_scrolls";

    public static final CreativeModeTab SCROLLS_TAB = CreativeTabRegistry.create(new ResourceLocation(MOD_ID, "scrolls_tab"), () ->
            new ItemStack(Items.DIRT));
    
    public static void init() {
        System.out.println(SummonerScrollsExpectPlatform.getConfigDirectory().toAbsolutePath().normalize().toString());
    }

    //TODO: add lang
}
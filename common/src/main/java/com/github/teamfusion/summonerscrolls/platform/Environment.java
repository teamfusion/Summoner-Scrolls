package com.github.teamfusion.summonerscrolls.platform;

import dev.architectury.injectables.annotations.ExpectPlatform;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;

import java.util.List;
import java.util.function.Supplier;

public class Environment {
    @ExpectPlatform
    public static CreativeModeTab createTab(String location, Supplier<ItemStack> icon, List<Item> items) {
        throw new AssertionError();
    }

    @ExpectPlatform
    public static boolean isClientSide() {
        throw new AssertionError();
    }
}
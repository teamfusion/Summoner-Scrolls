package com.github.teamfusion.summonerscrolls.platform.forge;

import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.fml.loading.FMLLoader;

import java.util.function.Supplier;

public class EnvironmentImpl {
    public static CreativeModeTab createTab(ResourceLocation location, Supplier<ItemStack> icon) {
        return CreativeModeTab.builder(CreativeModeTab.Row.BOTTOM, 1).title(Component.translatable(location.toString().replace(":", "."))).icon(icon).build();
    }

    public static boolean isClientSide() {
        return FMLLoader.getDist() == Dist.CLIENT;
    }
}

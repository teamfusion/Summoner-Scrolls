package com.github.teamfusion.summonerscrolls.platform.forge;

import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.ItemStack;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.fml.loading.FMLLoader;

import java.util.function.Supplier;

@SuppressWarnings("NullableProblems")
public class EnvironmentImpl {
//    public static CreativeModeTab createTab(ResourceLocation location, Supplier<ItemStack> icon) {
//        return new CreativeModeTab(location.toString().replace(":", ".")) {
//            @Override public ItemStack makeIcon() {
//                return icon.get();
//            }
//        };
//    }

    public static boolean isClientSide() {
        return FMLLoader.getDist() == Dist.CLIENT;
    }
}

package com.github.teamfusion.summonerscrolls.platform.fabric;

import net.fabricmc.api.EnvType;
import net.fabricmc.loader.api.FabricLoader;

public class EnvironmentImpl {
//    public static CreativeModeTab createTab(ResourceLocation location, Supplier<ItemStack> icon) {
//        return FabricItemGroup.builder().icon(icon).title(Component.literal(location.getPath())).displayItems((itemDisplayParameters, output) -> {
//            output.accept(SSItems.BEE_SCROLL.get());
//        }).build();
//    }

    public static boolean isClientSide() {
        return FabricLoader.getInstance().getEnvironmentType() == EnvType.CLIENT;
    }
}

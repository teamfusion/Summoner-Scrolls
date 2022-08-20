package com.github.teamfusion.summonerscrolls.item;

import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;

import javax.annotation.ParametersAreNonnullByDefault;

@ParametersAreNonnullByDefault
public class ScrollItem extends Item {
    public ScrollItem(Properties properties) {
        super(properties);
    }

    @Override
    public boolean isEnchantable(ItemStack itemStack) {
        return false;
    }
}
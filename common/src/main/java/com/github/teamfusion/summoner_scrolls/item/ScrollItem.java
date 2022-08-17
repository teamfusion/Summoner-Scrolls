package com.github.teamfusion.summoner_scrolls.item;

import net.minecraft.nbt.CompoundTag;
import net.minecraft.nbt.ListTag;
import net.minecraft.world.item.EnchantedBookItem;
import net.minecraft.world.item.ItemStack;

public class ScrollItem extends EnchantedBookItem {
    public ScrollItem(Properties properties) {
        super(properties);
    }


    public static ListTag getEnchantments(ItemStack itemStack) {
        CompoundTag compoundTag = itemStack.getTag();
        return compoundTag != null ? compoundTag.getList("StoredEnchantments", 10) : new ListTag();
    }
}

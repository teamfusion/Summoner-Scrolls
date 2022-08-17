package com.github.teamfusion.summoner_scrolls.mixin;

import net.minecraft.world.item.EnchantedBookItem;
import net.minecraft.world.item.Item;
import org.spongepowered.asm.mixin.Mixin;

@Mixin(EnchantedBookItem.class)
public class EnchantedBookItemMixin extends Item {
    public EnchantedBookItemMixin(Properties properties) {
        super(properties);
    }
}
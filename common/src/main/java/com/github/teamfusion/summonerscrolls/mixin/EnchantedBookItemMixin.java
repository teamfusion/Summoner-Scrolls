package com.github.teamfusion.summonerscrolls.mixin;

import net.minecraft.world.item.EnchantedBookItem;
import net.minecraft.world.item.Item;
import org.spongepowered.asm.mixin.Mixin;

@Mixin(EnchantedBookItem.class)
public class EnchantedBookItemMixin extends Item {
    public EnchantedBookItemMixin(Properties properties) {
        super(properties);
    }
}
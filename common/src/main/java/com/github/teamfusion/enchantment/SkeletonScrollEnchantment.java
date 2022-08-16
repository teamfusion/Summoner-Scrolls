package com.github.teamfusion.enchantment;

import net.minecraft.world.item.enchantment.Enchantment;

import javax.annotation.ParametersAreNonnullByDefault;

@ParametersAreNonnullByDefault
public class SkeletonScrollEnchantment extends ScrollEnchantment {
    @Override
    protected boolean checkCompatibility(Enchantment enchantment) {
        return super.checkCompatibility(enchantment) &&
                enchantment != SummonerScrollsEnchantments.ZOMBIE_SCROLL_ENCHANTMENT.get() &&
                enchantment != SummonerScrollsEnchantments.SPIDER_SCROLL_ENCHANTMENT.get() &&
                enchantment != SummonerScrollsEnchantments.ENDERMAN_SCROLL_ENCHANTMENT.get();
    }
}
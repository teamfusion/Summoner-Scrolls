package com.github.teamfusion.summonerscrolls.enchantment;

import net.minecraft.world.item.enchantment.Enchantment;

import javax.annotation.ParametersAreNonnullByDefault;

@ParametersAreNonnullByDefault
public class CreeperScrollEnchantment extends ScrollEnchantment {
    @Override
    protected boolean checkCompatibility(Enchantment enchantment) {
        return super.checkCompatibility(enchantment) &&
                enchantment != SummonerScrollsEnchantments.ENDERMAN_SCROLL_ENCHANTMENT.get() &&
                enchantment != SummonerScrollsEnchantments.SKELETON_SCROLL_ENCHANTMENT.get() &&
                enchantment != SummonerScrollsEnchantments.SPIDER_SCROLL_ENCHANTMENT.get() &&
                enchantment != SummonerScrollsEnchantments.ZOMBIE_SCROLL_ENCHANTMENT.get();
    }
}
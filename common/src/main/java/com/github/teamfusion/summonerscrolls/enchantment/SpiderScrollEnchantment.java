package com.github.teamfusion.summonerscrolls.enchantment;

import net.minecraft.world.item.enchantment.Enchantment;

import javax.annotation.ParametersAreNonnullByDefault;

@ParametersAreNonnullByDefault
public class SpiderScrollEnchantment extends ScrollEnchantment {
    @Override
    protected boolean checkCompatibility(Enchantment enchantment) {
        return super.checkCompatibility(enchantment) &&
                enchantment != SummonerScrollsEnchantments.SKELETON_SCROLL_ENCHANTMENT.get() &&
                enchantment != SummonerScrollsEnchantments.ZOMBIE_SCROLL_ENCHANTMENT.get() &&
                enchantment != SummonerScrollsEnchantments.ENDERMAN_SCROLL_ENCHANTMENT.get();
    }
}
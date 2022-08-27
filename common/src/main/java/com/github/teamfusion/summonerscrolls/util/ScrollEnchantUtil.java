package com.github.teamfusion.summonerscrolls.util;

import com.github.teamfusion.summonerscrolls.enchantment.SummonerScrollsEnchantments;
import com.github.teamfusion.summonerscrolls.entity.SummonerScrollsEntityTypes;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.enchantment.Enchantment;
import net.minecraft.world.item.enchantment.EnchantmentHelper;

public class ScrollEnchantUtil {
    public static EntityType<?> getEntityType(ItemStack stack) {
        EntityType<?> type = null;
        for(Enchantment enchantment : EnchantmentHelper.getEnchantments(stack).keySet()) {
            if (enchantment == SummonerScrollsEnchantments.ZOMBIE_SCROLL_ENCHANTMENT.get()){
                type = SummonerScrollsEntityTypes.ZOMBIE_SUMMON.get();
            }
        }
        for(Enchantment enchantment : EnchantmentHelper.getEnchantments(stack).keySet()) {
            if (enchantment == SummonerScrollsEnchantments.SKELETON_SCROLL_ENCHANTMENT.get()){
                type = EntityType.SKELETON;
            }
        }
        for(Enchantment enchantment : EnchantmentHelper.getEnchantments(stack).keySet()) {
            if (enchantment == SummonerScrollsEnchantments.SPIDER_SCROLL_ENCHANTMENT.get()){
                type = EntityType.SPIDER;
            }
        }
        for(Enchantment enchantment : EnchantmentHelper.getEnchantments(stack).keySet()) {
            if (enchantment == SummonerScrollsEnchantments.SKELETON_SCROLL_ENCHANTMENT.get()){
                type = EntityType.SKELETON;
            }
        }
        for(Enchantment enchantment : EnchantmentHelper.getEnchantments(stack).keySet()) {
            if (enchantment == SummonerScrollsEnchantments.CREEPER_SCROLL_ENCHANTMENT.get()){
                type = EntityType.CREEPER;
            }
        }
        return type;
    }
}
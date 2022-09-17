package com.github.teamfusion.summonerscrolls.util;

import com.github.teamfusion.summonerscrolls.enchantment.SummonerScrollsEnchantments;
import com.github.teamfusion.summonerscrolls.entity.SummonerScrollsEntityTypes;
import com.github.teamfusion.summonerscrolls.item.SummonerScrollsItems;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.enchantment.Enchantment;
import net.minecraft.world.item.enchantment.EnchantmentHelper;

public class ScrollEnchantUtil {
    //todo: add 5x bee types
    public static EntityType<?> getEntityType(ItemStack stack) {
        EntityType<?> type = null;
        /* Summon Types - Tier 1 */
        for(Enchantment enchantment : EnchantmentHelper.getEnchantments(stack).keySet()) {
            if (enchantment == SummonerScrollsEnchantments.ZOMBIE_SCROLL_ENCHANTMENT.get()){
                type = SummonerScrollsEntityTypes.ZOMBIE_SUMMON.get();
            }
        }
        for(Enchantment enchantment : EnchantmentHelper.getEnchantments(stack).keySet()) {
            if (enchantment == SummonerScrollsEnchantments.SPIDER_SCROLL_ENCHANTMENT.get()){
                type = EntityType.SPIDER;
            }
        }
        for(Enchantment enchantment : EnchantmentHelper.getEnchantments(stack).keySet()) {
            if (enchantment == SummonerScrollsEnchantments.SKELETON_SCROLL_ENCHANTMENT.get()){
                type = SummonerScrollsEntityTypes.SKELETON_SUMMON.get();
            }
        }
        for(Enchantment enchantment : EnchantmentHelper.getEnchantments(stack).keySet()) {
            if (enchantment == SummonerScrollsEnchantments.BEE_SCROLL_ENCHANTMENT.get()){
                type = EntityType.BEE;
            }
        }

        /* Summon Types - Tier 2 */
        for(Enchantment enchantment : EnchantmentHelper.getEnchantments(stack).keySet()) {
            if (enchantment == SummonerScrollsEnchantments.HUSK_SCROLL_ENCHANTMENT.get()){
                type = SummonerScrollsEntityTypes.HUSK_SUMMON.get();
            }
        }
        for(Enchantment enchantment : EnchantmentHelper.getEnchantments(stack).keySet()) {
            if (enchantment == SummonerScrollsEnchantments.STRAY_SCROLL_ENCHANTMENT.get()){
                type = EntityType.STRAY;
            }
        }
        for(Enchantment enchantment : EnchantmentHelper.getEnchantments(stack).keySet()) {
            if (enchantment == SummonerScrollsEnchantments.CAVE_SPIDER_SCROLL_ENCHANTMENT.get()){
                type = EntityType.CAVE_SPIDER;
            }
        }
        for(Enchantment enchantment : EnchantmentHelper.getEnchantments(stack).keySet()) {
            if (enchantment == SummonerScrollsEnchantments.ENDERMAN_SCROLL_ENCHANTMENT.get()){
                type = EntityType.ENDERMAN;
            }
        }
        for(Enchantment enchantment : EnchantmentHelper.getEnchantments(stack).keySet()) {
            if (enchantment == SummonerScrollsEnchantments.PIGLIN_SCROLL_ENCHANTMENT.get()){
                type = EntityType.PIGLIN;
            }
        }

        /* Summon Types - Tier 3 */
        for(Enchantment enchantment : EnchantmentHelper.getEnchantments(stack).keySet()) {
            if (enchantment == SummonerScrollsEnchantments.CREEPER_SCROLL_ENCHANTMENT.get()){
                type = EntityType.CREEPER;
            }
        }
//        for(Enchantment enchantment : EnchantmentHelper.getEnchantments(stack).keySet()) {
//            if (enchantment == SummonerScrollsEnchantments.CHARGED_CREEPER_SCROLL_ENCHANTMENT.get()){
//                type = EntityType.CHARGED_CREEPER;
//            }
//        }
        for(Enchantment enchantment : EnchantmentHelper.getEnchantments(stack).keySet()) {
            if (enchantment == SummonerScrollsEnchantments.PIGLIN_BRUTE_SCROLL_ENCHANTMENT.get()){
                type = EntityType.PIGLIN_BRUTE;
            }
        }
        for(Enchantment enchantment : EnchantmentHelper.getEnchantments(stack).keySet()) {
            if (enchantment == SummonerScrollsEnchantments.IRON_GOLEM_SCROLL_ENCHANTMENT.get()){
                type = EntityType.IRON_GOLEM;
            }
        }
        return type;
    }

    public static int getXP(ItemStack stack) {
        int summonXP = 0;

        /* Summon XP - Tier 1 */
        for(Enchantment enchantment : EnchantmentHelper.getEnchantments(stack).keySet()) {
            if (enchantment == SummonerScrollsEnchantments.ZOMBIE_SCROLL_ENCHANTMENT.get()){
                summonXP = 10;
            }
        }
        for(Enchantment enchantment : EnchantmentHelper.getEnchantments(stack).keySet()) {
            if (enchantment == SummonerScrollsEnchantments.SPIDER_SCROLL_ENCHANTMENT.get()){
                summonXP = 10;
            }
        }
        for(Enchantment enchantment : EnchantmentHelper.getEnchantments(stack).keySet()) {
            if (enchantment == SummonerScrollsEnchantments.SKELETON_SCROLL_ENCHANTMENT.get()){
                summonXP = 15;
            }
        }
        for(Enchantment enchantment : EnchantmentHelper.getEnchantments(stack).keySet()) {
            if (enchantment == SummonerScrollsEnchantments.BEE_SCROLL_ENCHANTMENT.get()){
                summonXP = 15;
            }
        }

        /* Summon Types - Tier 2 */
        for(Enchantment enchantment : EnchantmentHelper.getEnchantments(stack).keySet()) {
            if (enchantment == SummonerScrollsEnchantments.HUSK_SCROLL_ENCHANTMENT.get()){
                summonXP = 20;
            }
        }
        for(Enchantment enchantment : EnchantmentHelper.getEnchantments(stack).keySet()) {
            if (enchantment == SummonerScrollsEnchantments.STRAY_SCROLL_ENCHANTMENT.get()){
                summonXP = 20;
            }
        }
        for(Enchantment enchantment : EnchantmentHelper.getEnchantments(stack).keySet()) {
            if (enchantment == SummonerScrollsEnchantments.CAVE_SPIDER_SCROLL_ENCHANTMENT.get()){
                summonXP = 15;
            }
        }
        for(Enchantment enchantment : EnchantmentHelper.getEnchantments(stack).keySet()) {
            if (enchantment == SummonerScrollsEnchantments.ENDERMAN_SCROLL_ENCHANTMENT.get()){
                summonXP = 30;
            }
        }
        for(Enchantment enchantment : EnchantmentHelper.getEnchantments(stack).keySet()) {
            if (enchantment == SummonerScrollsEnchantments.SKELETON_SCROLL_ENCHANTMENT.get()){
                summonXP = 30;
            }
        }

        /* Summon Types - Tier 3 */
        for(Enchantment enchantment : EnchantmentHelper.getEnchantments(stack).keySet()) {
            if (enchantment == SummonerScrollsEnchantments.CREEPER_SCROLL_ENCHANTMENT.get()){
                summonXP = 40;
            }
        }
        for(Enchantment enchantment : EnchantmentHelper.getEnchantments(stack).keySet()) {
            if (enchantment == SummonerScrollsEnchantments.PIGLIN_BRUTE_SCROLL_ENCHANTMENT.get()){
                summonXP = 50;
            }
        }
        for(Enchantment enchantment : EnchantmentHelper.getEnchantments(stack).keySet()) {
            if (enchantment == SummonerScrollsEnchantments.IRON_GOLEM_SCROLL_ENCHANTMENT.get()){
                summonXP = 50;
            }
        }
//        for(Enchantment enchantment : EnchantmentHelper.getEnchantments(stack).keySet()) {
//            if (enchantment == SummonerScrollsEnchantments.CHARGED_CREEPER_SCROLL_ENCHANTMENT.get()){
//                summonXP = 60;
//            }
//        }

        return summonXP;
    }

    public static int getScrollXPCount(ItemStack stack) {
        Item item = stack.getItem();
        int summonXP = 0;

        /* Summon XP - Tier 1 */
        if (item == SummonerScrollsItems.ZOMBIE_SCROLL.get()){
            summonXP = 10;
        }
        if (item == SummonerScrollsItems.SPIDER_SCROLL.get()){
            summonXP = 10;
        }
        if (item == SummonerScrollsItems.SKELETON_SCROLL.get()){
            summonXP = 15;
        }
        if (item == SummonerScrollsItems.BEE_SCROLL.get()){
            summonXP = 15;
        }

        /* Summon Types - Tier 2 */
        if (item == SummonerScrollsItems.HUSK_SCROLL.get()){
            summonXP = 20;
        }
        if (item == SummonerScrollsItems.STRAY_SCROLL.get()){
            summonXP = 20;
        }
        if (item == SummonerScrollsItems.CAVE_SPIDER_SCROLL.get()){
            summonXP = 15;
        }
        if (item == SummonerScrollsItems.ENDERMAN_SCROLL.get()){
            summonXP = 30;
        }
        if (item == SummonerScrollsItems.SKELETON_SCROLL.get()){
            summonXP = 30;
        }

        /* Summon Types - Tier 3 */
        if (item == SummonerScrollsItems.CREEPER_SCROLL.get()){
            summonXP = 40;
        }
        if (item == SummonerScrollsItems.PIGLIN_BRUTE_SCROLL.get()){
            summonXP = 50;
        }
        if (item == SummonerScrollsItems.IRON_GOLEM_SCROLL.get()){
            summonXP = 50;
        }
//        if (item == SummonerScrollsItems.CHARGED_CREEPER_SCROLL.get()){
//            summonXP = 60;
//        }

        return summonXP;
    }

    public static int getDurability(ItemStack stack) {
        int durability = 0;

        /* Summon XP - Tier 1 */
        for(Enchantment enchantment : EnchantmentHelper.getEnchantments(stack).keySet()) {
            if (enchantment == SummonerScrollsEnchantments.ZOMBIE_SCROLL_ENCHANTMENT.get()){
                durability = 1;
            }
        }
        for(Enchantment enchantment : EnchantmentHelper.getEnchantments(stack).keySet()) {
            if (enchantment == SummonerScrollsEnchantments.SPIDER_SCROLL_ENCHANTMENT.get()){
                durability = 1;
            }
        }
        for(Enchantment enchantment : EnchantmentHelper.getEnchantments(stack).keySet()) {
            if (enchantment == SummonerScrollsEnchantments.SKELETON_SCROLL_ENCHANTMENT.get()){
                durability = 2;
            }
        }
        for(Enchantment enchantment : EnchantmentHelper.getEnchantments(stack).keySet()) {
            if (enchantment == SummonerScrollsEnchantments.BEE_SCROLL_ENCHANTMENT.get()){
                durability = 5;
            }
        }

        /* Summon Types - Tier 2 */
        for(Enchantment enchantment : EnchantmentHelper.getEnchantments(stack).keySet()) {
            if (enchantment == SummonerScrollsEnchantments.HUSK_SCROLL_ENCHANTMENT.get()){
                durability = 5;
            }
        }
        for(Enchantment enchantment : EnchantmentHelper.getEnchantments(stack).keySet()) {
            if (enchantment == SummonerScrollsEnchantments.STRAY_SCROLL_ENCHANTMENT.get()){
                durability = 5;
            }
        }
        for(Enchantment enchantment : EnchantmentHelper.getEnchantments(stack).keySet()) {
            if (enchantment == SummonerScrollsEnchantments.CAVE_SPIDER_SCROLL_ENCHANTMENT.get()){
                durability = 5;
            }
        }
        for(Enchantment enchantment : EnchantmentHelper.getEnchantments(stack).keySet()) {
            if (enchantment == SummonerScrollsEnchantments.ENDERMAN_SCROLL_ENCHANTMENT.get()){
                durability = 5;
            }
        }
        for(Enchantment enchantment : EnchantmentHelper.getEnchantments(stack).keySet()) {
            if (enchantment == SummonerScrollsEnchantments.PIGLIN_SCROLL_ENCHANTMENT.get()){
                durability = 10;
            }
        }

        /* Summon Types - Tier 3 */
        for(Enchantment enchantment : EnchantmentHelper.getEnchantments(stack).keySet()) {
            if (enchantment == SummonerScrollsEnchantments.CREEPER_SCROLL_ENCHANTMENT.get()){
                durability = 10;
            }
        }
        for(Enchantment enchantment : EnchantmentHelper.getEnchantments(stack).keySet()) {
            if (enchantment == SummonerScrollsEnchantments.PIGLIN_BRUTE_SCROLL_ENCHANTMENT.get()){
                durability = 10;
            }
        }
        for(Enchantment enchantment : EnchantmentHelper.getEnchantments(stack).keySet()) {
            if (enchantment == SummonerScrollsEnchantments.IRON_GOLEM_SCROLL_ENCHANTMENT.get()){
                durability = 15;
            }
        }
//        for(Enchantment enchantment : EnchantmentHelper.getEnchantments(stack).keySet()) {
//            if (enchantment == SummonerScrollsEnchantments.CHARGED_CREEPER_SCROLL_ENCHANTMENT.get()){
//                durability = 15;
//            }
//        }

        return durability;
    }
}
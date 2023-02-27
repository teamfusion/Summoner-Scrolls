package com.github.teamfusion.summonerscrolls.common.util;

import com.github.teamfusion.summonerscrolls.common.registry.SSEnchantments;
import com.github.teamfusion.summonerscrolls.common.registry.SSEntityTypes;
import com.github.teamfusion.summonerscrolls.common.registry.SSItems;
import com.google.common.collect.ImmutableMap;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.enchantment.Enchantment;
import net.minecraft.world.item.enchantment.EnchantmentHelper;

import java.util.Map;

public class ScrollUtil {
    private static final Map<EntityType<? extends LivingEntity>, Enchantment> SCROLL_SUMMONEABLES = ImmutableMap.of(
            /* Summon Types - Tier 1 */
            SSEntityTypes.ZOMBIE_SUMMON.get(), SSEnchantments.ZOMBIE_SCROLL_ENCHANTMENT.get(),
            SSEntityTypes.SPIDER_SUMMON.get(), SSEnchantments.SPIDER_SCROLL_ENCHANTMENT.get(),
            SSEntityTypes.SKELETON_SUMMON.get(), SSEnchantments.SKELETON_SCROLL_ENCHANTMENT.get(),
            /* Summon Types - Tier 2 */
            SSEntityTypes.HUSK_SUMMON.get(), SSEnchantments.HUSK_SCROLL_ENCHANTMENT.get(),
            SSEntityTypes.STRAY_SUMMON.get(), SSEnchantments.STRAY_SCROLL_ENCHANTMENT.get(),
            SSEntityTypes.CAVE_SPIDER_SUMMON.get(), SSEnchantments.CAVE_SPIDER_SCROLL_ENCHANTMENT.get(),
            SSEntityTypes.ENDERMAN_SUMMON.get(), SSEnchantments.ENDERMAN_SCROLL_ENCHANTMENT.get(),
            /* Summon Types - Tier 3 */
            SSEntityTypes.CREEPER_SUMMON.get(), SSEnchantments.CREEPER_SCROLL_ENCHANTMENT.get(),
            SSEntityTypes.CHARGED_CREEPER_SUMMON.get(), SSEnchantments.CHARGED_CREEPER_SCROLL_ENCHANTMENT.get()
    );

    //todo: add 5x bee types
    private static EntityType<?> type;

    public static EntityType<?> getEntityType(ItemStack stack) {
        /* Summon Types - Tier 1 */
        SCROLL_SUMMONEABLES.forEach((summon, scroll) -> {
            for (Enchantment enchantment : EnchantmentHelper.getEnchantments(stack).keySet()) {
                if (enchantment == scroll) {
                    type = summon;
                    break;
                }
            }
        });

        return type;

//        SSEntityTypes.ZOMBIE_SUMMON.listen((summon) -> {
//            for (Enchantment enchantment : EnchantmentHelper.getEnchantments(stack).keySet()) {
//                if (enchantment == SSEnchantments.ZOMBIE_SCROLL_ENCHANTMENT.get()) {
//                    type = summon;
//                }
//            }
//        });
//        SSEntityTypes.SPIDER_SUMMON.listen((summon) -> {
//            for (Enchantment enchantment : EnchantmentHelper.getEnchantments(stack).keySet()) {
//                if (enchantment == SSEnchantments.SPIDER_SCROLL_ENCHANTMENT.get()) {
//                    type = summon;
//                }
//            }
//        });
//        SSEntityTypes.SKELETON_SUMMON.listen((summon) -> {
//            for (Enchantment enchantment : EnchantmentHelper.getEnchantments(stack).keySet()) {
//                if (enchantment == SSEnchantments.SKELETON_SCROLL_ENCHANTMENT.get()) {
//                    type = summon;
//                }
//            }
//        });
//        /*
//*        for(Enchantment enchantment : EnchantmentHelper.getEnchantments(stack).keySet()) {
//*            if (enchantment == SSEnchantments.BEE_SCROLL_ENCHANTMENT.get()){
//*                type = EntityType.BEE;
//*            }
//*        }
//         */
//
//        /* Summon Types - Tier 2 */
//        SSEntityTypes.HUSK_SUMMON.listen((summon) -> {
//            for (Enchantment enchantment : EnchantmentHelper.getEnchantments(stack).keySet()) {
//                if (enchantment == SSEnchantments.HUSK_SCROLL_ENCHANTMENT.get()) {
//                    type = summon;
//                }
//            }
//        });
//        SSEntityTypes.STRAY_SUMMON.listen((summon) -> {
//            for (Enchantment enchantment : EnchantmentHelper.getEnchantments(stack).keySet()) {
//                if (enchantment == SSEnchantments.STRAY_SCROLL_ENCHANTMENT.get()) {
//                    type = summon;
//                }
//            }
//        });
//        SSEntityTypes.CAVE_SPIDER_SUMMON.listen((summon) -> {
//            for (Enchantment enchantment : EnchantmentHelper.getEnchantments(stack).keySet()) {
//                if (enchantment == SSEnchantments.CAVE_SPIDER_SCROLL_ENCHANTMENT.get()) {
//                    type = summon;
//                }
//            }
//        });
//        SSEntityTypes.ENDERMAN_SUMMON.listen((summon) -> {
//            for (Enchantment enchantment : EnchantmentHelper.getEnchantments(stack).keySet()) {
//                if (enchantment == SSEnchantments.ENDERMAN_SCROLL_ENCHANTMENT.get()) {
//                    type = summon;
//                }
//            }
//        });
///*
//*        for(Enchantment enchantment : EnchantmentHelper.getEnchantments(stack).keySet()) {
//*            if (enchantment == SSEnchantments.ENDERMAN_SCROLL_ENCHANTMENT.get()){
//*                type = EntityType.ENDERMAN;
//*            }
//*        }
//*        for(Enchantment enchantment : EnchantmentHelper.getEnchantments(stack).keySet()) {
//*            if (enchantment == SSEnchantments.PIGLIN_SCROLL_ENCHANTMENT.get()){
//*                type = EntityType.PIGLIN;
//*            }
//*        }
//         */
//
//        /* Summon Types - Tier 3 */
//        SSEntityTypes.CREEPER_SUMMON.listen((summon) -> {
//            for (Enchantment enchantment : EnchantmentHelper.getEnchantments(stack).keySet()) {
//                if (enchantment == SSEnchantments.CREEPER_SCROLL_ENCHANTMENT.get()) {
//                    type = summon;
//                }
//            }
//        });
//        SSEntityTypes.CHARGED_CREEPER_SUMMON.listen((summon) -> {
//            for (Enchantment enchantment : EnchantmentHelper.getEnchantments(stack).keySet()) {
//                if (enchantment == SSEnchantments.CHARGED_CREEPER_SCROLL_ENCHANTMENT.get()) {
//                    type = summon;
//                }
//            }
//        });
///*
//*        for(Enchantment enchantment : EnchantmentHelper.getEnchantments(stack).keySet()) {
//*            if (enchantment == SSEnchantments.PIGLIN_BRUTE_SCROLL_ENCHANTMENT.get()){
//*                type = EntityType.PIGLIN_BRUTE;
//*            }
//*        }
//*        for(Enchantment enchantment : EnchantmentHelper.getEnchantments(stack).keySet()) {
//*            if (enchantment == SSEnchantments.IRON_GOLEM_SCROLL_ENCHANTMENT.get()){
//*                type = EntityType.IRON_GOLEM;
//*            }
//*        }
//        */
//        return type;
    }

    public static int getXP(ItemStack stack) {
        int summonXP = 0;

        /* Summon XP - Tier 1 */
        for(Enchantment enchantment : EnchantmentHelper.getEnchantments(stack).keySet()) {
            if (enchantment == SSEnchantments.ZOMBIE_SCROLL_ENCHANTMENT.get()){
                summonXP = 10;
            }
        }
        for(Enchantment enchantment : EnchantmentHelper.getEnchantments(stack).keySet()) {
            if (enchantment == SSEnchantments.SPIDER_SCROLL_ENCHANTMENT.get()){
                summonXP = 10;
            }
        }
        for(Enchantment enchantment : EnchantmentHelper.getEnchantments(stack).keySet()) {
            if (enchantment == SSEnchantments.SKELETON_SCROLL_ENCHANTMENT.get()){
                summonXP = 15;
            }
        }
        for(Enchantment enchantment : EnchantmentHelper.getEnchantments(stack).keySet()) {
            if (enchantment == SSEnchantments.BEE_SCROLL_ENCHANTMENT.get()){
                summonXP = 15;
            }
        }

        /* Summon Types - Tier 2 */
        for(Enchantment enchantment : EnchantmentHelper.getEnchantments(stack).keySet()) {
            if (enchantment == SSEnchantments.HUSK_SCROLL_ENCHANTMENT.get()){
                summonXP = 20;
            }
        }
        for(Enchantment enchantment : EnchantmentHelper.getEnchantments(stack).keySet()) {
            if (enchantment == SSEnchantments.STRAY_SCROLL_ENCHANTMENT.get()){
                summonXP = 20;
            }
        }
        for(Enchantment enchantment : EnchantmentHelper.getEnchantments(stack).keySet()) {
            if (enchantment == SSEnchantments.CAVE_SPIDER_SCROLL_ENCHANTMENT.get()){
                summonXP = 15;
            }
        }
        for(Enchantment enchantment : EnchantmentHelper.getEnchantments(stack).keySet()) {
            if (enchantment == SSEnchantments.ENDERMAN_SCROLL_ENCHANTMENT.get()){
                summonXP = 30;
            }
        }
        for(Enchantment enchantment : EnchantmentHelper.getEnchantments(stack).keySet()) {
            if (enchantment == SSEnchantments.SKELETON_SCROLL_ENCHANTMENT.get()){
                summonXP = 30;
            }
        }

        /* Summon Types - Tier 3 */
        for(Enchantment enchantment : EnchantmentHelper.getEnchantments(stack).keySet()) {
            if (enchantment == SSEnchantments.CREEPER_SCROLL_ENCHANTMENT.get()){
                summonXP = 40;
            }
        }
        for(Enchantment enchantment : EnchantmentHelper.getEnchantments(stack).keySet()) {
            if (enchantment == SSEnchantments.PIGLIN_BRUTE_SCROLL_ENCHANTMENT.get()){
                summonXP = 50;
            }
        }
        for(Enchantment enchantment : EnchantmentHelper.getEnchantments(stack).keySet()) {
            if (enchantment == SSEnchantments.IRON_GOLEM_SCROLL_ENCHANTMENT.get()){
                summonXP = 50;
            }
        }
        for(Enchantment enchantment : EnchantmentHelper.getEnchantments(stack).keySet()) {
            if (enchantment == SSEnchantments.CHARGED_CREEPER_SCROLL_ENCHANTMENT.get()){
                summonXP = 60;
            }
        }

        return summonXP;
    }

    public static int getScrollXPCount(ItemStack stack) {
        Item item = stack.getItem();
        int summonXP = 0;

        /* Summon XP - Tier 1 */
        if (item == SSItems.ZOMBIE_SCROLL.get()){
            summonXP = 10;
        }
        if (item == SSItems.SPIDER_SCROLL.get()){
            summonXP = 10;
        }
        if (item == SSItems.SKELETON_SCROLL.get()){
            summonXP = 15;
        }
        if (item == SSItems.BEE_SCROLL.get()){
            summonXP = 15;
        }

        /* Summon Types - Tier 2 */
        if (item == SSItems.HUSK_SCROLL.get()){
            summonXP = 20;
        }
        if (item == SSItems.STRAY_SCROLL.get()){
            summonXP = 20;
        }
        if (item == SSItems.CAVE_SPIDER_SCROLL.get()){
            summonXP = 15;
        }
        if (item == SSItems.ENDERMAN_SCROLL.get()){
            summonXP = 30;
        }
        if (item == SSItems.SKELETON_SCROLL.get()){
            summonXP = 30;
        }
        if (item == SSItems.PIGLIN_SCROLL.get()){
            summonXP = 30;
        }

        /* Summon Types - Tier 3 */
        if (item == SSItems.CREEPER_SCROLL.get()){
            summonXP = 40;
        }
        if (item == SSItems.PIGLIN_BRUTE_SCROLL.get()){
            summonXP = 50;
        }
        if (item == SSItems.IRON_GOLEM_SCROLL.get()){
            summonXP = 50;
        }
        if (item == SSItems.CHARGED_CREEPER_SCROLL.get()){
            summonXP = 60;
        }

        return summonXP;
    }

    public static int getDurability(ItemStack stack) {
        int durability = 0;

        /* Summon XP - Tier 1 */
        for(Enchantment enchantment : EnchantmentHelper.getEnchantments(stack).keySet()) {
            if (enchantment == SSEnchantments.ZOMBIE_SCROLL_ENCHANTMENT.get()){
                durability = 1;
            }
        }
        for(Enchantment enchantment : EnchantmentHelper.getEnchantments(stack).keySet()) {
            if (enchantment == SSEnchantments.SPIDER_SCROLL_ENCHANTMENT.get()){
                durability = 1;
            }
        }
        for(Enchantment enchantment : EnchantmentHelper.getEnchantments(stack).keySet()) {
            if (enchantment == SSEnchantments.SKELETON_SCROLL_ENCHANTMENT.get()){
                durability = 2;
            }
        }
        for(Enchantment enchantment : EnchantmentHelper.getEnchantments(stack).keySet()) {
            if (enchantment == SSEnchantments.BEE_SCROLL_ENCHANTMENT.get()){
                durability = 5;
            }
        }

        /* Summon Types - Tier 2 */
        for(Enchantment enchantment : EnchantmentHelper.getEnchantments(stack).keySet()) {
            if (enchantment == SSEnchantments.HUSK_SCROLL_ENCHANTMENT.get()){
                durability = 5;
            }
        }
        for(Enchantment enchantment : EnchantmentHelper.getEnchantments(stack).keySet()) {
            if (enchantment == SSEnchantments.STRAY_SCROLL_ENCHANTMENT.get()){
                durability = 5;
            }
        }
        for(Enchantment enchantment : EnchantmentHelper.getEnchantments(stack).keySet()) {
            if (enchantment == SSEnchantments.CAVE_SPIDER_SCROLL_ENCHANTMENT.get()){
                durability = 5;
            }
        }
        for(Enchantment enchantment : EnchantmentHelper.getEnchantments(stack).keySet()) {
            if (enchantment == SSEnchantments.ENDERMAN_SCROLL_ENCHANTMENT.get()){
                durability = 5;
            }
        }
        for(Enchantment enchantment : EnchantmentHelper.getEnchantments(stack).keySet()) {
            if (enchantment == SSEnchantments.PIGLIN_SCROLL_ENCHANTMENT.get()){
                durability = 10;
            }
        }

        /* Summon Types - Tier 3 */
        for(Enchantment enchantment : EnchantmentHelper.getEnchantments(stack).keySet()) {
            if (enchantment == SSEnchantments.CREEPER_SCROLL_ENCHANTMENT.get()){
                durability = 10;
            }
        }
        for(Enchantment enchantment : EnchantmentHelper.getEnchantments(stack).keySet()) {
            if (enchantment == SSEnchantments.PIGLIN_BRUTE_SCROLL_ENCHANTMENT.get()){
                durability = 10;
            }
        }
        for(Enchantment enchantment : EnchantmentHelper.getEnchantments(stack).keySet()) {
            if (enchantment == SSEnchantments.IRON_GOLEM_SCROLL_ENCHANTMENT.get()){
                durability = 15;
            }
        }
        for(Enchantment enchantment : EnchantmentHelper.getEnchantments(stack).keySet()) {
            if (enchantment == SSEnchantments.CHARGED_CREEPER_SCROLL_ENCHANTMENT.get()){
                durability = 15;
            }
        }

        return durability;
    }
}
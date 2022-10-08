package com.github.teamfusion.summonerscrolls.common.enchantment;

import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.enchantment.Enchantment;
import net.minecraft.world.item.enchantment.EnchantmentCategory;


public class ScrollEnchantment extends Enchantment {
    //todo: make the checkCompatibility on the anvil mixin/event
    public ScrollEnchantment() {
        super(Rarity.RARE, EnchantmentCategory.BREAKABLE, new EquipmentSlot[]{ EquipmentSlot.MAINHAND, EquipmentSlot.OFFHAND });
    }

    @Override
    public boolean isTreasureOnly() {
        return true;
    }
}
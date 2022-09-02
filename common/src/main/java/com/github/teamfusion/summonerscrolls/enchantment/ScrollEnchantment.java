package com.github.teamfusion.summonerscrolls.enchantment;

import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.item.enchantment.Enchantment;
import net.minecraft.world.item.enchantment.EnchantmentCategory;

public class ScrollEnchantment extends Enchantment {
    protected ScrollEnchantment() {
        super(Rarity.RARE, EnchantmentCategory.WEAPON, new EquipmentSlot[]{ EquipmentSlot.MAINHAND, EquipmentSlot.OFFHAND });
    }
}
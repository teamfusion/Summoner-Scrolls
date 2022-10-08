package com.github.teamfusion.summonerscrolls.common.util;

import com.github.teamfusion.summonerscrolls.common.item.ScrollItem;
import net.minecraft.network.chat.TextComponent;
import net.minecraft.world.Container;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.inventory.AnvilMenu;
import net.minecraft.world.item.DiggerItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.SwordItem;
import net.minecraft.world.item.enchantment.Enchantment;
import net.minecraft.world.item.enchantment.EnchantmentHelper;

import javax.annotation.Nonnull;
import java.util.Map;

public class InventoryUtil {
    //todo: check if you can combine scrolls
    public static boolean onAnvilChange(AnvilMenu container, @Nonnull ItemStack left, @Nonnull ItemStack right, Container outputSlot, String name, int baseCost, Player player) {
        Item leftItem = left.getItem();
        Item rightItem = right.getItem();

        if (rightItem instanceof ScrollItem scrollItem) {
            Enchantment enchantment = scrollItem.getEnchantment().get();

            if ((leftItem instanceof DiggerItem || leftItem instanceof SwordItem)) {
                Map<Enchantment, Integer> enchantments = EnchantmentHelper.getEnchantments(left);
                enchantments.put(enchantment, 1);
                ItemStack copy = left.copy();
                EnchantmentHelper.setEnchantments(enchantments, copy);
                copy.setHoverName(new TextComponent(name));

                outputSlot.setItem(0, copy);
                container.cost.set(8);
            }
        }
        return false;
    }
}
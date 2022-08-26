package com.github.teamfusion.summonerscrolls.util;

import com.github.teamfusion.summonerscrolls.item.ScrollItem;
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

public class AnvilUtil {
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

                outputSlot.setItem(0, copy);
                container.cost.set(8);
            }
        }
        return false;
    }
}

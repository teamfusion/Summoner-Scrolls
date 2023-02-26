package com.github.teamfusion.summonerscrolls.common.util;

import com.github.teamfusion.summonerscrolls.common.enchantment.ScrollEnchantment;
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

@SuppressWarnings({"unused"})
public class InventoryUtil {
    //todo: check if you can combine scrolls
    public static boolean onAnvilChange(AnvilMenu container, @Nonnull ItemStack left, @Nonnull ItemStack right, Container outputSlot, String name, int baseCost, Player player) {
        Item leftItem = left.getItem();
        Item rightItem = right.getItem();

        if (rightItem instanceof ScrollItem scrollItem) {
            Enchantment enchantment = scrollItem.getEnchantment().get();

            if ((leftItem instanceof DiggerItem || leftItem instanceof SwordItem)) {

                replaceScrollEnchants(enchantment, left, right, name, outputSlot, container);


            }
        }
        return false;
    }

    private static void replaceScrollEnchants(Enchantment newEnchant, ItemStack insert, ItemStack result, String name, Container outputSlot, AnvilMenu container) {
        ItemStack lefte = insert.copy();
        Map<Enchantment, Integer> insertMap = EnchantmentHelper.getEnchantments(insert);
        Map<Enchantment, Integer> resultMap = EnchantmentHelper.getEnchantments(result);
//        Iterator<Map.Entry<Enchantment, Integer>> var5 = map.entrySet().iterator();

        for (Enchantment enchantment : resultMap.keySet()) {
            if (enchantment == newEnchant) {
                return;
            } else if (enchantment instanceof ScrollEnchantment) {
                resultMap.remove(enchantment);
                insertMap.put(newEnchant, 1);
                ItemStack copy = result.copy();
                EnchantmentHelper.setEnchantments(resultMap, copy);
                if (name != null && !name.isEmpty()) {
                    copy.setHoverName(new TextComponent(name));
                }

                outputSlot.setItem(0, copy);
                container.cost.set(8);
            } else {
                insertMap.put(newEnchant, 1);
                ItemStack copy = insert.copy();
                EnchantmentHelper.setEnchantments(insertMap, copy);
                if (name != null && !name.isEmpty()) {
                    copy.setHoverName(new TextComponent(name));
                }

                outputSlot.setItem(0, copy);
                container.cost.set(8);
            }
        }
    }
}

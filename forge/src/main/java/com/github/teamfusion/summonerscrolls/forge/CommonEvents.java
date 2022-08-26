package com.github.teamfusion.summonerscrolls.forge;

import com.github.teamfusion.summonerscrolls.SummonerScrolls;
import com.github.teamfusion.summonerscrolls.item.ScrollItem;
import net.minecraft.world.item.DiggerItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.SwordItem;
import net.minecraft.world.item.enchantment.Enchantment;
import net.minecraft.world.item.enchantment.EnchantmentHelper;
import net.minecraftforge.event.AnvilUpdateEvent;
import net.minecraftforge.eventbus.api.EventPriority;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

import java.util.Map;

@Mod.EventBusSubscriber(modid = SummonerScrolls.MOD_ID)
public class CommonEvents {
    @SubscribeEvent(priority = EventPriority.HIGHEST)
    static void anvilUpdate(AnvilUpdateEvent event) {
        ItemStack left = event.getLeft();
        Item leftItem = left.getItem();
        ItemStack right = event.getRight();
        Item rightItem = right.getItem();

        if (rightItem instanceof ScrollItem scrollItem) {
            Enchantment enchantment = scrollItem.getEnchantment().get();

            if ((leftItem instanceof DiggerItem || leftItem instanceof SwordItem)) {
                Map<Enchantment, Integer> enchantments = EnchantmentHelper.getEnchantments(left);
                enchantments.put(enchantment, 1);
                ItemStack copy = left.copy();
                EnchantmentHelper.setEnchantments(enchantments, copy);

                event.setOutput(copy);
                event.setCost(8);
            }
        }
    }
}
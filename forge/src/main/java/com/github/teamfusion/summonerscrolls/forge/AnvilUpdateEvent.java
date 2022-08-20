package com.github.teamfusion.summonerscrolls.forge;

import com.github.teamfusion.enchantment.SummonerScrollsEnchantments;
import com.github.teamfusion.summonerscrolls.SummonerScrolls;
import com.github.teamfusion.summonerscrolls.item.ScrollItem;
import com.github.teamfusion.summonerscrolls.item.SummonerScrollsItems;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.SwordItem;
import net.minecraft.world.item.enchantment.Enchantment;
import net.minecraft.world.item.enchantment.EnchantmentHelper;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.eventbus.api.EventPriority;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

import java.util.Map;

@Mod.EventBusSubscriber(modid = SummonerScrolls.MOD_ID)
public class AnvilUpdateEvent {
    @SubscribeEvent(priority = EventPriority.HIGHEST)
    public void onAnvilUpdate(net.minecraftforge.event.AnvilUpdateEvent event) {
        ItemStack left = event.getLeft();
        ItemStack right = event.getRight();
        Enchantment enchantment = SummonerScrollsEnchantments.ZOMBIE_SCROLL_ENCHANTMENT.get();

        if (left.getItem() instanceof SwordItem && right.is(SummonerScrollsItems.ZOMBIE_SCROLL.get())) {
            Map<Enchantment, Integer> enchantments = EnchantmentHelper.getEnchantments(left);
            enchantments.put(enchantment, 1);

            ItemStack copy = left.copy();
            EnchantmentHelper.setEnchantments(enchantments, copy);
            event.setOutput(copy);
            event.setCost(14);
        }
    }
}

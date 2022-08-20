package com.github.teamfusion.summonerscrolls.mixin;

import com.github.teamfusion.enchantment.SummonerScrollsEnchantments;
import com.github.teamfusion.summonerscrolls.item.ScrollItem;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.enchantment.Enchantment;
import net.minecraft.world.item.enchantment.EnchantmentHelper;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

import java.util.HashMap;
import java.util.Map;

@Mixin(EnchantmentHelper.class)
public class EnchantmentHelperMixin {
    @Inject(method = "getEnchantments", at = @At("HEAD"), cancellable = true)
    private static void getEnchantments(ItemStack stack, CallbackInfoReturnable<Map<Enchantment, Integer>> callbackInfoReturnable) {
//        EnchantedBookItem.addEnchantment(newStack,
        Enchantment enchantment = SummonerScrollsEnchantments.ZOMBIE_SCROLL_ENCHANTMENT.get();

        if (stack.getItem() instanceof ScrollItem && enchantment != null) {
            Map<Enchantment, Integer> map = new HashMap<>();
            map.put(enchantment, 1);
            callbackInfoReturnable.setReturnValue(map);
        }
    }
}
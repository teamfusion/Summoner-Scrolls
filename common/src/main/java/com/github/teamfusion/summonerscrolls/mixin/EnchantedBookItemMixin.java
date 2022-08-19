package com.github.teamfusion.summonerscrolls.mixin;

import com.github.teamfusion.enchantment.SummonerScrollsEnchantments;
import com.github.teamfusion.summonerscrolls.item.SummonerScrollsItems;
import net.minecraft.world.item.EnchantedBookItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.enchantment.EnchantmentInstance;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

import static net.minecraft.world.item.EnchantedBookItem.addEnchantment;

@Mixin(EnchantedBookItem.class)
public class EnchantedBookItemMixin extends Item {
    public EnchantedBookItemMixin(Properties properties) {
        super(properties);
    }

    @Inject(method = "createForEnchantment", at = @At("HEAD"))
    private static void createForEnchantment(EnchantmentInstance enchantmentInstance, CallbackInfoReturnable<ItemStack> cir) {
        ItemStack itemStack = new ItemStack(SummonerScrollsItems.ZOMBIE_SCROLL.get());
        addEnchantment(itemStack, enchantmentInstance);
        cir.setReturnValue(itemStack);
    }
}
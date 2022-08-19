package com.github.teamfusion.summonerscrolls.mixin;

import com.github.teamfusion.summonerscrolls.item.ScrollItem;
import com.github.teamfusion.summonerscrolls.item.SummonerScrollsItems;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.nbt.ListTag;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.EnchantedBookItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.enchantment.Enchantment;
import net.minecraft.world.item.enchantment.EnchantmentInstance;
import org.jetbrains.annotations.Nullable;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

import java.util.Iterator;
import java.util.Map;

@Mixin(net.minecraft.world.item.enchantment.EnchantmentHelper.class)
public abstract class EnchantmentHelper {
    @Shadow
    public static Map<Enchantment, Integer> deserializeEnchantments(ListTag listTag) {
        return null;
    }

    @Shadow
    public static CompoundTag storeEnchantment(@Nullable ResourceLocation resourceLocation, int i) {
        return null;
    }

    @Shadow
    @Nullable
    public static ResourceLocation getEnchantmentId(Enchantment enchantment) {
        return null;
    }

    @Inject(method = "getEnchantments", at = @At(value = "HEAD"), cancellable = true)
    private static void getEnchantments(ItemStack itemStack, CallbackInfoReturnable<Map<Enchantment, Integer>> cir) {
        if (!(itemStack.getItem() instanceof ScrollItem)) {
            return;
        }

        ListTag listTag = EnchantedBookItem.getEnchantments(itemStack);
        cir.setReturnValue(deserializeEnchantments(listTag));
    }

    @Inject(method = "setEnchantments", at = @At(value = "HEAD"))
    private static void setEnchantments(Map<Enchantment, Integer> map, ItemStack itemStack, CallbackInfo ci) {
        ListTag listTag = new ListTag();

        for (Map.Entry<Enchantment, Integer> enchantmentIntegerEntry : map.entrySet()) {
            Enchantment enchantment = enchantmentIntegerEntry.getKey();
            if (enchantment != null) {
                int i = enchantmentIntegerEntry.getValue();
                listTag.add(storeEnchantment(getEnchantmentId(enchantment), i));
                if (itemStack.is(SummonerScrollsItems.ZOMBIE_SCROLL.get())) {
                    EnchantedBookItem.addEnchantment(itemStack, new EnchantmentInstance(enchantment, i));
                }
            }
        }

        if (listTag.isEmpty()) {
            itemStack.removeTagKey("Enchantments");
        } else if (!itemStack.is(SummonerScrollsItems.ZOMBIE_SCROLL.get())) {
            itemStack.addTagElement("Enchantments", listTag);
        }
    }
}
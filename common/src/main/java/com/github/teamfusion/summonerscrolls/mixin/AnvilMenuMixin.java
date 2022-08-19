package com.github.teamfusion.summonerscrolls.mixin;

import net.minecraft.world.entity.player.Inventory;
import net.minecraft.world.inventory.*;
import net.minecraft.world.item.ItemStack;
import org.jetbrains.annotations.Nullable;
import org.spongepowered.asm.mixin.Final;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;
import org.spongepowered.asm.mixin.injection.callback.LocalCapture;

import java.util.Map;

@Mixin(AnvilMenu.class)
public abstract class AnvilMenuMixin extends ItemCombinerMenu {
    @Shadow @Final private DataSlot cost;

    @Shadow private int repairItemCountCost;

    @Shadow private String itemName;

    @Shadow
    public static int calculateIncreasedRepairCost(int i) {
        return 0;
    }

    public AnvilMenuMixin(@Nullable MenuType<?> menuType, int i, Inventory inventory, ContainerLevelAccess containerLevelAccess) {
        super(menuType, i, inventory, containerLevelAccess);
    }

    @Inject(method = "createResult", at = @At(value = "INVOKE", target = "Lnet/minecraft/world/item/ItemStack;is(Lnet/minecraft/world/item/Item;)Z"), locals = LocalCapture.PRINT)
    public void createResult(CallbackInfo ci, ItemStack itemStack, int i, int j, int k, ItemStack itemStack2, ItemStack itemStack3, Map map) {


    }

//    @Override
//    public void createResult() {
//        ItemStack itemStack = this.inputSlots.getItem(0);
//        this.cost.set(1);
//        int i = 0;
//        int j = 0;
//        int k = 0;
//        if (itemStack.isEmpty()) {
//            this.resultSlots.setItem(0, ItemStack.EMPTY);
//            this.cost.set(0);
//        } else {
//            ItemStack itemStack2 = itemStack.copy();
//            ItemStack itemStack3 = this.inputSlots.getItem(1);
//            Map<Enchantment, Integer> map = EnchantmentHelper.getEnchantments(itemStack2);
//            j += itemStack.getBaseRepairCost() + (itemStack3.isEmpty() ? 0 : itemStack3.getBaseRepairCost());
//            this.repairItemCountCost = 0;
//            if (!itemStack3.isEmpty()) {
//                boolean bl = itemStack3.is(SummonerScrollsItems.ZOMBIE_SCROLL.get()) && !EnchantedBookItem.getEnchantments(itemStack3).isEmpty();
//                int l;
//                int m;
//                int n;
//                if (itemStack2.isDamageableItem() && itemStack2.getItem().isValidRepairItem(itemStack, itemStack3)) {
//                    l = Math.min(itemStack2.getDamageValue(), itemStack2.getMaxDamage() / 4);
//                    if (l <= 0) {
//                        this.resultSlots.setItem(0, ItemStack.EMPTY);
//                        this.cost.set(0);
//                        return;
//                    }
//
//                    for(m = 0; l > 0 && m < itemStack3.getCount(); ++m) {
//                        n = itemStack2.getDamageValue() - l;
//                        itemStack2.setDamageValue(n);
//                        ++i;
//                        l = Math.min(itemStack2.getDamageValue(), itemStack2.getMaxDamage() / 4);
//                    }
//
//                    this.repairItemCountCost = m;
//                } else {
//                    if (!bl && (!itemStack2.is(itemStack3.getItem()) || !itemStack2.isDamageableItem())) {
//                        this.resultSlots.setItem(0, ItemStack.EMPTY);
//                        this.cost.set(0);
//                        return;
//                    }
//
//                    if (itemStack2.isDamageableItem() && !bl) {
//                        l = itemStack.getMaxDamage() - itemStack.getDamageValue();
//                        m = itemStack3.getMaxDamage() - itemStack3.getDamageValue();
//                        n = m + itemStack2.getMaxDamage() * 12 / 100;
//                        int o = l + n;
//                        int p = itemStack2.getMaxDamage() - o;
//                        if (p < 0) {
//                            p = 0;
//                        }
//
//                        if (p < itemStack2.getDamageValue()) {
//                            itemStack2.setDamageValue(p);
//                            i += 2;
//                        }
//                    }
//
//                    Map<Enchantment, Integer> map2 = EnchantmentHelper.getEnchantments(itemStack3);
//                    boolean bl2 = false;
//                    boolean bl3 = false;
//                    Iterator var23 = map2.keySet().iterator();
//
//                    label155:
//                    while(true) {
//                        Enchantment enchantment;
//                        do {
//                            if (!var23.hasNext()) {
//                                if (bl3 && !bl2) {
//                                    this.resultSlots.setItem(0, ItemStack.EMPTY);
//                                    this.cost.set(0);
//                                    return;
//                                }
//                                break label155;
//                            }
//
//                            enchantment = (Enchantment)var23.next();
//                        } while(enchantment == null);
//
//                        int q = (Integer)map.getOrDefault(enchantment, 0);
//                        int r = (Integer)map2.get(enchantment);
//                        r = q == r ? r + 1 : Math.max(r, q);
//                        boolean bl4 = enchantment.canEnchant(itemStack);
//                        if (this.player.getAbilities().instabuild || itemStack.is(SummonerScrollsItems.ZOMBIE_SCROLL.get())) {
//                            bl4 = true;
//                        }
//
//                        for (Enchantment enchantment2 : map.keySet()) {
//                            if (enchantment2 != enchantment && !enchantment.isCompatibleWith(enchantment2)) {
//                                bl4 = false;
//                                ++i;
//                            }
//                        }
//
//                        if (!bl4) {
//                            bl3 = true;
//                        } else {
//                            bl2 = true;
//                            if (r > enchantment.getMaxLevel()) {
//                                r = enchantment.getMaxLevel();
//                            }
//
//                            map.put(enchantment, r);
//                            int s = switch (enchantment.getRarity()) {
//                                case COMMON -> 1;
//                                case UNCOMMON -> 2;
//                                case RARE -> 4;
//                                case VERY_RARE -> 8;
//                            };
//
//                            if (bl) {
//                                s = Math.max(1, s / 2);
//                            }
//
//                            i += s * r;
//                            if (itemStack.getCount() > 1) {
//                                i = 40;
//                            }
//                        }
//                    }
//                }
//            }
//
//            if (StringUtils.isBlank(this.itemName)) {
//                if (itemStack.hasCustomHoverName()) {
//                    k = 1;
//                    i += k;
//                    itemStack2.resetHoverName();
//                }
//            } else if (!this.itemName.equals(itemStack.getHoverName().getString())) {
//                k = 1;
//                i += k;
//                itemStack2.setHoverName(new TextComponent(this.itemName));
//            }
//
//            this.cost.set(j + i);
//            if (i <= 0) {
//                itemStack2 = ItemStack.EMPTY;
//            }
//
//            if (k == i && k > 0 && this.cost.get() >= 40) {
//                this.cost.set(39);
//            }
//
//            if (this.cost.get() >= 40 && !this.player.getAbilities().instabuild) {
//                itemStack2 = ItemStack.EMPTY;
//            }
//
//            if (!itemStack2.isEmpty()) {
//                int t = itemStack2.getBaseRepairCost();
//                if (!itemStack3.isEmpty() && t < itemStack3.getBaseRepairCost()) {
//                    t = itemStack3.getBaseRepairCost();
//                }
//
//                if (k != i || k == 0) {
//                    t = calculateIncreasedRepairCost(t);
//                }
//
//                itemStack2.setRepairCost(t);
//                EnchantmentHelper.setEnchantments(map, itemStack2);
//            }
//
//            this.resultSlots.setItem(0, itemStack2);
//            this.broadcastChanges();
//        }
//    }
}
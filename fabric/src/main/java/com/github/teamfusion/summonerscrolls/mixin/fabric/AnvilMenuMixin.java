package com.github.teamfusion.summonerscrolls.mixin.fabric;

import com.github.teamfusion.summonerscrolls.util.AnvilUtil;
import net.minecraft.world.entity.player.Inventory;
import net.minecraft.world.inventory.AnvilMenu;
import net.minecraft.world.inventory.ContainerLevelAccess;
import net.minecraft.world.inventory.ItemCombinerMenu;
import net.minecraft.world.inventory.MenuType;
import net.minecraft.world.item.ItemStack;
import org.jetbrains.annotations.Nullable;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.At.Shift;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;
import org.spongepowered.asm.mixin.injection.callback.LocalCapture;

import java.util.Map;

@Mixin(AnvilMenu.class)
public abstract class AnvilMenuMixin extends ItemCombinerMenu {
    @Shadow private String itemName;

    public AnvilMenuMixin(@Nullable MenuType<?> menuType, int i, Inventory inventory, ContainerLevelAccess containerLevelAccess) {
        super(menuType, i, inventory, containerLevelAccess);
    }

    @Inject(method = "createResult", at = @At(value = "INVOKE", target = "Lnet/minecraft/world/item/ItemStack;isEmpty()Z", ordinal = 1, shift = Shift.AFTER), locals = LocalCapture.CAPTURE_FAILHARD, cancellable = true)
    private void createResult(CallbackInfo ci, ItemStack left, int i, int j, int k, ItemStack right, ItemStack itemStack3, Map map) {
        AnvilMenu anvilMenu = (AnvilMenu) (Object) this;
        if (!AnvilUtil.onAnvilChange(anvilMenu, left, right, this.resultSlots, this.itemName, j, this.player)) {
            ci.cancel();
        }
    }
}
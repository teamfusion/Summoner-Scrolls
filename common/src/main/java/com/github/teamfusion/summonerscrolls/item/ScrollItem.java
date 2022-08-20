package com.github.teamfusion.summonerscrolls.item;

import dev.architectury.registry.registries.RegistrySupplier;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.enchantment.Enchantment;

import javax.annotation.ParametersAreNonnullByDefault;

@ParametersAreNonnullByDefault
public class ScrollItem extends Item {
    public RegistrySupplier<Enchantment> enchantment;

    public ScrollItem(RegistrySupplier<Enchantment> enchantment, Properties properties) {
        super(properties);
        this.enchantment = enchantment;
    }

    public RegistrySupplier<Enchantment> getEnchantment() {
        return enchantment;
    }
}
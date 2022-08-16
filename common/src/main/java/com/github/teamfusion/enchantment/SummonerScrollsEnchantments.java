package com.github.teamfusion.enchantment;

import com.github.teamfusion.summoner_scrolls.SummonerScrolls;
import dev.architectury.registry.registries.DeferredRegister;
import dev.architectury.registry.registries.RegistrySupplier;
import net.minecraft.core.Registry;
import net.minecraft.world.item.enchantment.Enchantment;

public class SummonerScrollsEnchantments {
    public static final DeferredRegister<Enchantment> ENCHANTMENTS = DeferredRegister.create(SummonerScrolls.MOD_ID, Registry.ENCHANTMENT_REGISTRY);

    public static final RegistrySupplier<Enchantment> ZOMBIE_SCROLL_ENCHANTMENT = register("scrutiny", new ZombieScrollEnchantment());
    public static final RegistrySupplier<Enchantment> SKELETON_SCROLL_ENCHANTMENT = register("illuminate", new SkeletonScrollEnchantment());
    public static final RegistrySupplier<Enchantment> SPIDER_SCROLL_ENCHANTMENT = register("indicate", new SpiderScrollEnchantment());
    public static final RegistrySupplier<Enchantment> ENDERMAN_SCROLL_ENCHANTMENT = register("discovery", new EndermanScrollEnchantment());

    private static RegistrySupplier<Enchantment> register(String id, Enchantment enchantment) {
        return ENCHANTMENTS.register(id, () -> enchantment);
    }
}
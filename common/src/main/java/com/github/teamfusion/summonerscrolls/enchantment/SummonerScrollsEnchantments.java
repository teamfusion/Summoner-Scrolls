package com.github.teamfusion.summonerscrolls.enchantment;

import com.github.teamfusion.summonerscrolls.SummonerScrolls;
import dev.architectury.registry.registries.DeferredRegister;
import dev.architectury.registry.registries.RegistrySupplier;
import net.minecraft.core.Registry;
import net.minecraft.world.item.enchantment.Enchantment;

public class SummonerScrollsEnchantments {
    public static final DeferredRegister<Enchantment> ENCHANTMENTS = DeferredRegister.create(SummonerScrolls.MOD_ID, Registry.ENCHANTMENT_REGISTRY);

    public static final RegistrySupplier<Enchantment> ZOMBIE_SCROLL_ENCHANTMENT = register("zombie_scroll", new ZombieScrollEnchantment());
    public static final RegistrySupplier<Enchantment> SKELETON_SCROLL_ENCHANTMENT = register("skeleton_scroll", new SkeletonScrollEnchantment());
    public static final RegistrySupplier<Enchantment> SPIDER_SCROLL_ENCHANTMENT = register("spider_scroll", new SpiderScrollEnchantment());
    public static final RegistrySupplier<Enchantment> ENDERMAN_SCROLL_ENCHANTMENT = register("enderman_scroll", new EndermanScrollEnchantment());
    public static final RegistrySupplier<Enchantment> CREEPER_SCROLL_ENCHANTMENT = register("creeper_scroll", new CreeperScrollEnchantment());

    private static RegistrySupplier<Enchantment> register(String id, Enchantment enchantment) {
        return ENCHANTMENTS.register(id, () -> enchantment);
    }
}
package com.github.teamfusion.summonerscrolls.enchantment;

import com.github.teamfusion.summonerscrolls.SummonerScrolls;
import dev.architectury.registry.registries.DeferredRegister;
import dev.architectury.registry.registries.RegistrySupplier;
import net.minecraft.core.Registry;
import net.minecraft.world.item.enchantment.Enchantment;

public class SummonerScrollsEnchantments {
    public static final DeferredRegister<Enchantment> ENCHANTMENTS = DeferredRegister.create(SummonerScrolls.MOD_ID, Registry.ENCHANTMENT_REGISTRY);

    //todo: make enchantment classes or automatic way
    public static final RegistrySupplier<Enchantment> BEE_SCROLL_ENCHANTMENT = register("bee_scroll", new ScrollEnchantment());
    public static final RegistrySupplier<Enchantment> CAVE_SPIDER_SCROLL_ENCHANTMENT = register("cave_spider_scroll", new ScrollEnchantment());
    public static final RegistrySupplier<Enchantment> CHARGED_CREEPER_SCROLL_ENCHANTMENT = register("charged_creeper_scroll", new ScrollEnchantment());
    public static final RegistrySupplier<Enchantment> HUSK_SCROLL_ENCHANTMENT = register("husk_scroll", new ScrollEnchantment());
    public static final RegistrySupplier<Enchantment> IRON_GOLEM_SCROLL_ENCHANTMENT = register("iron_golem_scroll", new ScrollEnchantment());
    public static final RegistrySupplier<Enchantment> PIGLIN_BRUTE_SCROLL_ENCHANTMENT = register("piglin_brute_scroll", new ScrollEnchantment());
    public static final RegistrySupplier<Enchantment> PIGLIN_SCROLL_ENCHANTMENT = register("piglin_scroll", new ScrollEnchantment());
    public static final RegistrySupplier<Enchantment> STRAY_SCROLL_ENCHANTMENT = register("stray_scroll", new ScrollEnchantment());
    public static final RegistrySupplier<Enchantment> ZOMBIE_SCROLL_ENCHANTMENT = register("zombie_scroll", new ScrollEnchantment());
    public static final RegistrySupplier<Enchantment> SKELETON_SCROLL_ENCHANTMENT = register("skeleton_scroll", new ScrollEnchantment());
    public static final RegistrySupplier<Enchantment> SPIDER_SCROLL_ENCHANTMENT = register("spider_scroll", new ScrollEnchantment());
    public static final RegistrySupplier<Enchantment> ENDERMAN_SCROLL_ENCHANTMENT = register("enderman_scroll", new ScrollEnchantment());
    public static final RegistrySupplier<Enchantment> CREEPER_SCROLL_ENCHANTMENT = register("creeper_scroll", new ScrollEnchantment());

    private static RegistrySupplier<Enchantment> register(String id, Enchantment enchantment) {
        return ENCHANTMENTS.register(id, () -> enchantment);
    }
}
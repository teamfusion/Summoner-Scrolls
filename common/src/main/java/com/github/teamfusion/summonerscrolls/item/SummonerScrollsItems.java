package com.github.teamfusion.summonerscrolls.item;

import com.github.teamfusion.summonerscrolls.SummonerScrolls;
import dev.architectury.registry.registries.DeferredRegister;
import dev.architectury.registry.registries.RegistrySupplier;
import net.minecraft.core.Registry;
import net.minecraft.world.item.BookItem;
import net.minecraft.world.item.EnchantedBookItem;
import net.minecraft.world.item.Item;

import java.util.function.Function;
import java.util.function.Supplier;

@SuppressWarnings("unused")
public class SummonerScrollsItems {
    public static final DeferredRegister<Item> ITEMS = DeferredRegister.create(SummonerScrolls.MOD_ID, Registry.ITEM_REGISTRY);

    /* Mob Scrolls */
    public static final RegistrySupplier<Item> ZOMBIE_SCROLL = ITEMS.register("zombie_summoner_scroll", () ->
            new ScrollItem(new Item.Properties().tab(SummonerScrolls.SCROLLS_TAB)));
    public static final RegistrySupplier<Item> SKELETON_SCROLL = ITEMS.register("skeleton_summoner_scroll", () ->
            new ScrollItem(new Item.Properties().tab(SummonerScrolls.SCROLLS_TAB)));
    public static final RegistrySupplier<Item> SPIDER_SCROLL = ITEMS.register("spider_summoner_scroll", () ->
            new ScrollItem(new Item.Properties().tab(SummonerScrolls.SCROLLS_TAB)));
    public static final RegistrySupplier<Item> ENDERMAN_SCROLL = ITEMS.register("enderman_summoner_scroll", () ->
            new ScrollItem(new Item.Properties().tab(SummonerScrolls.SCROLLS_TAB)));

    private static RegistrySupplier<Item> register(String id, Function<Item.Properties, Item> item) {
        return register(id, () -> item.apply(new Item.Properties().tab(SummonerScrolls.SCROLLS_TAB)));
    }

    private static RegistrySupplier<Item> register(String id, Supplier<Item> item) {
        return ITEMS.register(id, item);
    }
}
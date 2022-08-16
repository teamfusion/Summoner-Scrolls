package com.github.teamfusion.summoner_scrolls.item;

import com.github.teamfusion.summoner_scrolls.SummonerScrolls;
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

    /* Empty Scroll */
    public static final RegistrySupplier<Item> EMPTY_SUMMONER_SCROLL = ITEMS.register("empty_summoner_scroll", () ->
            new BookItem(new Item.Properties().tab(SummonerScrolls.SCROLLS_TAB)));

    /* Mob Scrolls */
    public static final RegistrySupplier<Item> ZOMBIE_SCROLL = ITEMS.register("zombie_summoner_scroll", () ->
            new EnchantedBookItem(new Item.Properties().tab(SummonerScrolls.SCROLLS_TAB)));
    public static final RegistrySupplier<Item> SKELETON_SCROLL = ITEMS.register("skeleton_summoner_scroll", () ->
            new BookItem(new Item.Properties().tab(SummonerScrolls.SCROLLS_TAB)));
    public static final RegistrySupplier<Item> SPIDER_SCROLL = ITEMS.register("spider_summoner_scroll", () ->
            new BookItem(new Item.Properties().tab(SummonerScrolls.SCROLLS_TAB)));
    public static final RegistrySupplier<Item> ENDERMAN_SCROLL = ITEMS.register("enderman_summoner_scroll", () ->
            new BookItem(new Item.Properties().tab(SummonerScrolls.SCROLLS_TAB)));

    /* Mob Essence Stone's */
    public static final RegistrySupplier<Item> ZOMBIE_ESSENCE_STONE = ITEMS.register("zombie_essence_stone", () ->
            new BookItem(new Item.Properties().tab(SummonerScrolls.SCROLLS_TAB)));
    public static final RegistrySupplier<Item> SKELETON_ESSENCE_STONE = ITEMS.register("skeleton_essence_stone", () ->
            new BookItem(new Item.Properties().tab(SummonerScrolls.SCROLLS_TAB)));
    public static final RegistrySupplier<Item> SPIDER_ESSENCE_STONE = ITEMS.register("spider_essence_stone", () ->
            new BookItem(new Item.Properties().tab(SummonerScrolls.SCROLLS_TAB)));
    public static final RegistrySupplier<Item> ENDERMAN_ESSENCE_STONE = ITEMS.register("enderman_essence_stone", () ->
            new BookItem(new Item.Properties().tab(SummonerScrolls.SCROLLS_TAB)));

    private static RegistrySupplier<Item> register(String id, Function<Item.Properties, Item> item) {
        return register(id, () -> item.apply(new Item.Properties().tab(SummonerScrolls.SCROLLS_TAB)));
    }

    private static RegistrySupplier<Item> register(String id, Supplier<Item> item) {
        return ITEMS.register(id, item);
    }
}
package com.github.teamfusion.summonerscrolls.item;

import com.github.teamfusion.summonerscrolls.enchantment.SummonerScrollsEnchantments;
import com.github.teamfusion.summonerscrolls.SummonerScrolls;
import dev.architectury.registry.registries.DeferredRegister;
import dev.architectury.registry.registries.RegistrySupplier;
import net.minecraft.core.Registry;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.StandingAndWallBlockItem;
import net.minecraft.world.level.block.Blocks;

import java.util.function.Function;
import java.util.function.Supplier;

@SuppressWarnings("unused")
public class SummonerScrollsItems {
    public static final DeferredRegister<Item> ITEMS = DeferredRegister.create(SummonerScrolls.MOD_ID, Registry.ITEM_REGISTRY);

    public static final RegistrySupplier<Item> ENHANCEMENT_SCROLL = ITEMS.register("enhancement_summoner_scroll", () ->  new Item(new Item.Properties().stacksTo(16).tab(SummonerScrolls.SCROLLS_TAB)));

    /* Mob Scrolls - Tier 1 */
    public static final RegistrySupplier<Item> ZOMBIE_SCROLL = ITEMS.register("zombie_summoner_scroll", () ->
            new ScrollItem(SummonerScrollsEnchantments.ZOMBIE_SCROLL_ENCHANTMENT, new Item.Properties().stacksTo(1).tab(SummonerScrolls.SCROLLS_TAB)));
    public static final RegistrySupplier<Item> SPIDER_SCROLL = ITEMS.register("spider_summoner_scroll", () ->
            new ScrollItem(SummonerScrollsEnchantments.SPIDER_SCROLL_ENCHANTMENT, new Item.Properties().stacksTo(1).tab(SummonerScrolls.SCROLLS_TAB)));
    public static final RegistrySupplier<Item> SKELETON_SCROLL = ITEMS.register("skeleton_summoner_scroll", () ->
            new ScrollItem(SummonerScrollsEnchantments.SKELETON_SCROLL_ENCHANTMENT, new Item.Properties().stacksTo(1).tab(SummonerScrolls.SCROLLS_TAB)));
    public static final RegistrySupplier<Item> BEE_SCROLL = ITEMS.register("bee_summoner_scroll", () ->
            new ScrollItem(SummonerScrollsEnchantments.BEE_SCROLL_ENCHANTMENT, new Item.Properties().stacksTo(1).tab(SummonerScrolls.SCROLLS_TAB)));

    /* Mob Scrolls - Tier 2 */
    public static final RegistrySupplier<Item> HUSK_SCROLL = ITEMS.register("husk_summoner_scroll", () ->
            new ScrollItem(SummonerScrollsEnchantments.HUSK_SCROLL_ENCHANTMENT, new Item.Properties().stacksTo(1).tab(SummonerScrolls.SCROLLS_TAB)));
    public static final RegistrySupplier<Item> STRAY_SCROLL = ITEMS.register("stray_summoner_scroll", () ->
            new ScrollItem(SummonerScrollsEnchantments.STRAY_SCROLL_ENCHANTMENT, new Item.Properties().stacksTo(1).tab(SummonerScrolls.SCROLLS_TAB)));
    public static final RegistrySupplier<Item> CAVE_SPIDER_SCROLL = ITEMS.register("cave_spider_summoner_scroll", () ->
            new ScrollItem(SummonerScrollsEnchantments.CAVE_SPIDER_SCROLL_ENCHANTMENT, new Item.Properties().stacksTo(1).tab(SummonerScrolls.SCROLLS_TAB)));
    public static final RegistrySupplier<Item> ENDERMAN_SCROLL = ITEMS.register("enderman_summoner_scroll", () ->
            new ScrollItem(SummonerScrollsEnchantments.ENDERMAN_SCROLL_ENCHANTMENT, new Item.Properties().stacksTo(1).tab(SummonerScrolls.SCROLLS_TAB)));
    public static final RegistrySupplier<Item> PIGLIN_SCROLL = ITEMS.register("piglin_summoner_scroll", () ->
            new ScrollItem(SummonerScrollsEnchantments.PIGLIN_SCROLL_ENCHANTMENT, new Item.Properties().stacksTo(1).tab(SummonerScrolls.SCROLLS_TAB)));

    /* Mob Scrolls - Tier 3 */
    public static final RegistrySupplier<Item> CREEPER_SCROLL = ITEMS.register("creeper_summoner_scroll", () ->
            new ScrollItem(SummonerScrollsEnchantments.CREEPER_SCROLL_ENCHANTMENT, new Item.Properties().stacksTo(1).tab(SummonerScrolls.SCROLLS_TAB)));
    public static final RegistrySupplier<Item> CHARGED_CREEPER_SCROLL = ITEMS.register("charged_creeper_summoner_scroll", () ->
            new ScrollItem(SummonerScrollsEnchantments.CHARGED_CREEPER_SCROLL_ENCHANTMENT, new Item.Properties().stacksTo(1).tab(SummonerScrolls.SCROLLS_TAB)));
    public static final RegistrySupplier<Item> PIGLIN_BRUTE_SCROLL = ITEMS.register("piglin_brute_summoner_scroll", () ->
            new ScrollItem(SummonerScrollsEnchantments.PIGLIN_BRUTE_SCROLL_ENCHANTMENT, new Item.Properties().stacksTo(1).tab(SummonerScrolls.SCROLLS_TAB)));
//    public static final RegistrySupplier<Item> SHULKERMAN_SCROLL = ITEMS.register("shulkerman_summoner_scroll", () ->
//            new ScrollItem(SummonerScrollsEnchantments.SHULKERMAN_SCROLL_ENCHANTMENT, new Item.Properties().stacksTo(1).tab(SummonerScrolls.SCROLLS_TAB)));
    public static final RegistrySupplier<Item> IRON_GOLEM_SCROLL = ITEMS.register("iron_golem_summoner_scroll", () ->
            new ScrollItem(SummonerScrollsEnchantments.IRON_GOLEM_SCROLL_ENCHANTMENT, new Item.Properties().stacksTo(1).tab(SummonerScrolls.SCROLLS_TAB)));

    /* Mob Scrolls - Tier 4 */
//    public static final RegistrySupplier<Item> WARDEN_SCROLL = ITEMS.register("warden_summoner_scroll", () ->
//            new ScrollItem(SummonerScrollsEnchantments.WARDEN_SCROLL_ENCHANTMENT, new Item.Properties().stacksTo(1).tab(SummonerScrolls.SCROLLS_TAB)));
//    public static final RegistrySupplier<Item> HEROBRINE_SCROLL = ITEMS.register("herobrine_summoner_scroll", () ->
//            new ScrollItem(SummonerScrollsEnchantments.HEROBRINE_SCROLL_ENCHANTMENT, new Item.Properties().stacksTo(1).tab(SummonerScrolls.SCROLLS_TAB)));


    /* Enhancement Scrolls */
//    public static final RegistrySupplier<Item> ENHANCEMENT_SCROLL = ITEMS.register("enhancement_scroll", () ->
//            new Item(new Item.Properties().stacksTo(1).tab(SummonerScrolls.SCROLLS_TAB)));

    /* Extra Items */
    public static final RegistrySupplier<Item> INVISIBLE_SUMMON_LIGHT = ITEMS.register("invisible_summon_light", () ->
            new StandingAndWallBlockItem(Blocks.TORCH, Blocks.WALL_TORCH, new Item.Properties().stacksTo(1)));

    private static RegistrySupplier<Item> register(String id, Function<Item.Properties, Item> item) {
        return register(id, () -> item.apply(new Item.Properties().tab(SummonerScrolls.SCROLLS_TAB)));
    }

    private static RegistrySupplier<Item> register(String id, Supplier<Item> item) {
        return ITEMS.register(id, item);
    }
}
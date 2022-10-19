package com.github.teamfusion.summonerscrolls.common.registry;

import com.github.teamfusion.summonerscrolls.SummonerScrolls;
import com.github.teamfusion.summonerscrolls.common.item.ScrollItem;
import com.github.teamfusion.summonerscrolls.common.item.SummonerBowItem;
import com.github.teamfusion.summonerscrolls.common.item.SummonerTiers;
import dev.architectury.registry.registries.DeferredRegister;
import dev.architectury.registry.registries.RegistrySupplier;
import net.minecraft.core.Registry;
import net.minecraft.world.item.*;
import net.minecraft.world.level.block.Blocks;

import java.util.function.Function;
import java.util.function.Supplier;

@SuppressWarnings({"unused"})
public class SSItems {
    public static final DeferredRegister<Item> ITEMS = DeferredRegister.create(SummonerScrolls.MOD_ID, Registry.ITEM_REGISTRY);

    /* Mob Scrolls - Tier 1 */
    public static final RegistrySupplier<Item> ZOMBIE_SCROLL = ITEMS.register("zombie_summoner_scroll", () ->
            new ScrollItem(SSEnchantments.ZOMBIE_SCROLL_ENCHANTMENT, new Item.Properties().stacksTo(1).tab(SummonerScrolls.SCROLLS_TAB)));
    public static final RegistrySupplier<Item> SPIDER_SCROLL = ITEMS.register("spider_summoner_scroll", () ->
            new ScrollItem(SSEnchantments.SPIDER_SCROLL_ENCHANTMENT, new Item.Properties().stacksTo(1).tab(SummonerScrolls.SCROLLS_TAB)));
    public static final RegistrySupplier<Item> SKELETON_SCROLL = ITEMS.register("skeleton_summoner_scroll", () ->
            new ScrollItem(SSEnchantments.SKELETON_SCROLL_ENCHANTMENT, new Item.Properties().stacksTo(1).tab(SummonerScrolls.SCROLLS_TAB)));
    public static final RegistrySupplier<Item> BEE_SCROLL = ITEMS.register("bee_summoner_scroll", () ->
            new ScrollItem(SSEnchantments.BEE_SCROLL_ENCHANTMENT, new Item.Properties().stacksTo(1).tab(SummonerScrolls.SCROLLS_TAB)));

    /* Mob Scrolls - Tier 2 */
    public static final RegistrySupplier<Item> HUSK_SCROLL = ITEMS.register("husk_summoner_scroll", () ->
            new ScrollItem(SSEnchantments.HUSK_SCROLL_ENCHANTMENT, new Item.Properties().stacksTo(1).tab(SummonerScrolls.SCROLLS_TAB)));
    public static final RegistrySupplier<Item> STRAY_SCROLL = ITEMS.register("stray_summoner_scroll", () ->
            new ScrollItem(SSEnchantments.STRAY_SCROLL_ENCHANTMENT, new Item.Properties().stacksTo(1).tab(SummonerScrolls.SCROLLS_TAB)));
    public static final RegistrySupplier<Item> CAVE_SPIDER_SCROLL = ITEMS.register("cave_spider_summoner_scroll", () ->
            new ScrollItem(SSEnchantments.CAVE_SPIDER_SCROLL_ENCHANTMENT, new Item.Properties().stacksTo(1).tab(SummonerScrolls.SCROLLS_TAB)));
    public static final RegistrySupplier<Item> ENDERMAN_SCROLL = ITEMS.register("enderman_summoner_scroll", () ->
            new ScrollItem(SSEnchantments.ENDERMAN_SCROLL_ENCHANTMENT, new Item.Properties().stacksTo(1).tab(SummonerScrolls.SCROLLS_TAB)));
    public static final RegistrySupplier<Item> PIGLIN_SCROLL = ITEMS.register("piglin_summoner_scroll", () ->
            new ScrollItem(SSEnchantments.PIGLIN_SCROLL_ENCHANTMENT, new Item.Properties().stacksTo(1).tab(SummonerScrolls.SCROLLS_TAB)));

    /* Mob Scrolls - Tier 3 */
    public static final RegistrySupplier<Item> CREEPER_SCROLL = ITEMS.register("creeper_summoner_scroll", () ->
            new ScrollItem(SSEnchantments.CREEPER_SCROLL_ENCHANTMENT, new Item.Properties().stacksTo(1).tab(SummonerScrolls.SCROLLS_TAB)));
    public static final RegistrySupplier<Item> CHARGED_CREEPER_SCROLL = ITEMS.register("charged_creeper_summoner_scroll", () ->
            new ScrollItem(SSEnchantments.CHARGED_CREEPER_SCROLL_ENCHANTMENT, new Item.Properties().stacksTo(1).tab(SummonerScrolls.SCROLLS_TAB)));
    public static final RegistrySupplier<Item> PIGLIN_BRUTE_SCROLL = ITEMS.register("piglin_brute_summoner_scroll", () ->
            new ScrollItem(SSEnchantments.PIGLIN_BRUTE_SCROLL_ENCHANTMENT, new Item.Properties().stacksTo(1).tab(SummonerScrolls.SCROLLS_TAB)));
    /*
    * public static final RegistrySupplier<Item> SHULKERMAN_SCROLL = ITEMS.register("shulkerman_summoner_scroll", () ->
            * new ScrollItem(SummonerScrollsEnchantments.SHULKERMAN_SCROLL_ENCHANTMENT, new Item.Properties().stacksTo(1).tab(SummonerScrolls.SCROLLS_TAB)));
            */
    public static final RegistrySupplier<Item> IRON_GOLEM_SCROLL = ITEMS.register("iron_golem_summoner_scroll", () ->
            new ScrollItem(SSEnchantments.IRON_GOLEM_SCROLL_ENCHANTMENT, new Item.Properties().stacksTo(1).tab(SummonerScrolls.SCROLLS_TAB)));

    /* Mob Scrolls - Tier 4
        * public static final RegistrySupplier<Item> HEROBRINE_SCROLL = ITEMS.register("herobrine_summoner_scroll", () ->
        * new ScrollItem(SummonerScrollsEnchantments.HEROBRINE_SCROLL_ENCHANTMENT, new Item.Properties().stacksTo(1).tab(SummonerScrolls.SCROLLS_TAB)));
     */

    /* Extra Summon Items */
    public static final RegistrySupplier<Item> ENHANCEMENT_SCROLL = ITEMS.register("enhancement_scroll", () ->
            new Item(new Item.Properties().stacksTo(16).tab(SummonerScrolls.SCROLLS_TAB)));

    public static final RegistrySupplier<Item> INVISIBLE_SUMMON_LIGHT = ITEMS.register("invisible_summon_light", () ->
            new StandingAndWallBlockItem(Blocks.TORCH, Blocks.WALL_TORCH, new Item.Properties().stacksTo(1)));

    /* Summon Tools */
    public static final RegistrySupplier<Item> SUMMON_BOW = ITEMS.register("summon_bow", () ->
            new SummonerBowItem(new Item.Properties().stacksTo(1).tab(SummonerScrolls.SCROLLS_TAB)));
    public static final RegistrySupplier<Item> SUMMON_ARROW = ITEMS.register("summon_arrow", () ->
            new ArrowItem(new Item.Properties().stacksTo(1).tab(SummonerScrolls.SCROLLS_TAB)));
    public static final RegistrySupplier<Item> SUMMON_SWORD = ITEMS.register("summon_sword", () ->
            new SwordItem(SummonerTiers.SUMMONER, 3, -2.4F, new Item.Properties().stacksTo(1).tab(SummonerScrolls.SCROLLS_TAB)));
    public static final RegistrySupplier<Item> SUMMON_AXE = ITEMS.register("summon_axe", () ->
            new AxeItem(SummonerTiers.SUMMONER, 6.0F, -3.0F, new Item.Properties().stacksTo(1).tab(SummonerScrolls.SCROLLS_TAB)));
    public static final RegistrySupplier<Item> SUMMON_PICKAXE = ITEMS.register("summon_pickaxe", () ->
            new PickaxeItem(SummonerTiers.SUMMONER, 1, -2.8F, new Item.Properties().stacksTo(1).tab(SummonerScrolls.SCROLLS_TAB)));
    public static final RegistrySupplier<Item> SUMMON_SHOVEL = ITEMS.register("summon_shovel", () ->
            new ShovelItem(SummonerTiers.SUMMONER, 1.5F, -3.0F, new Item.Properties().stacksTo(1).tab(SummonerScrolls.SCROLLS_TAB)));
    public static final RegistrySupplier<Item> SUMMON_HOE = ITEMS.register("summon_hoe", () ->
            new HoeItem(SummonerTiers.SUMMONER, -2, -3.0F, new Item.Properties().stacksTo(1).tab(SummonerScrolls.SCROLLS_TAB)));

    private static RegistrySupplier<Item> register(String id, Function<Item.Properties, Item> item) {
        return register(id, () -> item.apply(new Item.Properties().tab(SummonerScrolls.SCROLLS_TAB)));
    }

    private static RegistrySupplier<Item> register(String id, Supplier<Item> item) {
        return ITEMS.register(id, item);
    }
}
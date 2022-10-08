package com.github.teamfusion.summonerscrolls.datagen.client;

import com.github.teamfusion.summonerscrolls.common.registry.SSEnchantments;
import com.github.teamfusion.summonerscrolls.common.registry.SSEntityTypes;
import com.github.teamfusion.summonerscrolls.common.registry.SSItems;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import net.minecraft.data.DataGenerator;
import net.minecraft.data.DataProvider;
import net.minecraft.data.HashCache;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.enchantment.Enchantment;

import javax.annotation.ParametersAreNonnullByDefault;
import java.io.IOException;
import java.nio.file.Path;
import java.util.Map;
import java.util.TreeMap;

@ParametersAreNonnullByDefault
public final class LanguageGenerator implements DataProvider {
    private static final Gson GSON = new GsonBuilder().setPrettyPrinting().disableHtmlEscaping().create();
    private final Map<String, String> data = new TreeMap<>();
    private final DataGenerator generator;


    public LanguageGenerator(DataGenerator generator) {
        this.generator = generator;
    }

    @Override
    public void run(HashCache cache) throws IOException {
        this.addTranslations();
        Path path = this.generator.getOutputFolder().resolve("assets/summonerscrolls/lang/en_us.json");
        DataProvider.save(GSON, cache, GSON.toJsonTree(this.data), path);
    }

    @Override
    public String getName() {
        return "Language: en_us";
    }

    private void addTranslations() {
        // Entities
        this.entity(SSEntityTypes.ZOMBIE_SUMMON.get(), "Zombie Summon");
        this.entity(SSEntityTypes.SKELETON_SUMMON.get(), "Skeleton Summon");

        this.entity(SSEntityTypes.HUSK_SUMMON.get(), "Husk Summon");

        //  "entity.summonerscrolls.zombie_summon": "Zombie Summon",
        //  "entity.summonerscrolls.skeleton_summon": "Skeleton Summon",
        //  "entity.summonerscrolls.spider_summon": "Spider Summon",
        //  "entity.summonerscrolls.bee_summon": "Bee Summon",
        //
        //  "entity.summonerscrolls.husk_scroll": "Husk Summon",
        //  "entity.summonerscrolls.stray_scroll": "Stray Summon",
        //  "entity.summonerscrolls.cave_spider_scroll": "Cave Spider Summon",
        //  "entity.summonerscrolls.enderman_scroll": "Enderman Summon",
        //  "entity.summonerscrolls.piglin_scroll": "Piglin Summon",
        //
        //  "entity.summonerscrolls.creeper_scroll": "Creeper Summon",
        //  "entity.summonerscrolls.charged_creeper_scroll": "Charged Creeper Summon",
        //  "entity.summonerscrolls.piglin_brute_scroll": "Piglin Brute Summon",
        //  "entity.summonerscrolls.shulkerman_scroll": "Shulkerman Summon",
        //  "entity.summonerscrolls.iron_golem_scroll": "Iron Golem Summon",

        // Items
        this.item(SSItems.ENHANCEMENT_SCROLL.get(), "Summon Enhancement Scroll");

        this.item(SSItems.ZOMBIE_SCROLL.get(), "Zombie Summoner Scroll");
        this.item(SSItems.SKELETON_SCROLL.get(), "Skeleton Summoner Scroll");
        this.item(SSItems.SPIDER_SCROLL.get(), "Spider Summoner Scroll");
        //todo: bee swarm?
        this.item(SSItems.BEE_SCROLL.get(), "Bee Swarm Summoner Scroll");

        this.item(SSItems.HUSK_SCROLL.get(), "Husk Summoner Scroll");
        this.item(SSItems.STRAY_SCROLL.get(), "Stray Summoner Scroll");
        this.item(SSItems.CAVE_SPIDER_SCROLL.get(), "Cave Spider Summoner Scroll");
        this.item(SSItems.ENDERMAN_SCROLL.get(), "Enderman Summoner Scroll");
        this.item(SSItems.PIGLIN_SCROLL.get(), "Piglin Summoner Scroll");

        this.item(SSItems.CREEPER_SCROLL.get(), "Creeper Summoner Scroll");
        this.item(SSItems.CHARGED_CREEPER_SCROLL.get(), "Charged Creeper Summoner Scroll");
        this.item(SSItems.PIGLIN_BRUTE_SCROLL.get(), "Piglin Brute Summoner Scroll");
//        this.item(SSItems.SK.get(), "Shulkerman Summoner Scroll");
        this.item(SSItems.IRON_GOLEM_SCROLL.get(), "Iron Golem Summoner Scroll");

        this.item(SSItems.INVISIBLE_SUMMON_LIGHT.get(), "Invisible Summon Light");

        // Enchantment
        this.enchantment(SSEnchantments.ZOMBIE_SCROLL_ENCHANTMENT.get(), "Zombie Summon");
        this.enchantment(SSEnchantments.SPIDER_SCROLL_ENCHANTMENT.get(), "Spider Summon");
        this.enchantment(SSEnchantments.SKELETON_SCROLL_ENCHANTMENT.get(), "Skeleton Summon");
        this.enchantment(SSEnchantments.BEE_SCROLL_ENCHANTMENT.get(), "Bee Summon");

        this.enchantment(SSEnchantments.HUSK_SCROLL_ENCHANTMENT.get(), "Husk Summon");
        this.enchantment(SSEnchantments.STRAY_SCROLL_ENCHANTMENT.get(), "Stray Summon");
        this.enchantment(SSEnchantments.CAVE_SPIDER_SCROLL_ENCHANTMENT.get(), "Cave Spider Summon");
        this.enchantment(SSEnchantments.ENDERMAN_SCROLL_ENCHANTMENT.get(), "Enderman Summon");
        this.enchantment(SSEnchantments.PIGLIN_SCROLL_ENCHANTMENT.get(), "Piglin Summon");

        this.enchantment(SSEnchantments.CREEPER_SCROLL_ENCHANTMENT.get(), "Creeper Summon");
        this.enchantment(SSEnchantments.CHARGED_CREEPER_SCROLL_ENCHANTMENT.get(), "Charged Creeper Summon");
        this.enchantment(SSEnchantments.PIGLIN_BRUTE_SCROLL_ENCHANTMENT.get(), "Piglin Brute Summon");
//        this.enchantment(SSEnchantments.BEE_SCROLL_ENCHANTMENT.get(), "Shulkerman Summon");
        this.enchantment(SSEnchantments.IRON_GOLEM_SCROLL_ENCHANTMENT.get(), "Iron Golem Summon");

        // Misc
        this.add("itemGroup.summonerscrolls.scrolls_tab", "Summoner Scrolls");
        this.add("item.summonerscrolls.scroll.xp_warning", "Required XP:");
    }

    private void item(Item entry, String name) {
        this.add(entry.getDescriptionId(), name);
    }

    private void entity(EntityType<?> entry, String name) {
        this.add(entry.getDescriptionId(), name);
    }

    private void enchantment(Enchantment entry, String name) {
        this.add(entry.getDescriptionId(), name);
    }

    private void add(String key, String value) {
        if (this.data.put(key, value) != null) throw new IllegalStateException("Duplicate translation key " + key);
    }

    //todo: make tools use handheld models
}
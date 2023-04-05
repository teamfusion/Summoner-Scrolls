package com.github.teamfusion.summonerscrolls.common.registry;

import com.github.teamfusion.summonerscrolls.SummonerScrolls;
import com.github.teamfusion.summonerscrolls.common.entity.BeeSummon;
import com.github.teamfusion.summonerscrolls.common.entity.CaveSpiderSummon;
import com.github.teamfusion.summonerscrolls.common.entity.CreeperSummon;
import com.github.teamfusion.summonerscrolls.common.entity.EndermanSummon;
import com.github.teamfusion.summonerscrolls.common.entity.HuskSummon;
import com.github.teamfusion.summonerscrolls.common.entity.IronGolemSummon;
import com.github.teamfusion.summonerscrolls.common.entity.PiglinBruteSummon;
import com.github.teamfusion.summonerscrolls.common.entity.PiglinSummon;
import com.github.teamfusion.summonerscrolls.common.entity.SkeletonSummon;
import com.github.teamfusion.summonerscrolls.common.entity.SpiderSummon;
import com.github.teamfusion.summonerscrolls.common.entity.StraySummon;
import com.github.teamfusion.summonerscrolls.common.entity.ZombieSummon;
import com.github.teamfusion.summonerscrolls.platform.CoreRegistry;
import com.github.teamfusion.summonerscrolls.platform.common.MobRegistry;
import net.minecraft.core.Registry;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.LivingEntity;

import java.util.function.Supplier;

@SuppressWarnings({"unused"})
public class SSEntityTypes {
    public static final CoreRegistry<EntityType<?>> ENTITY_TYPES = CoreRegistry.create(Registry.ENTITY_TYPE, SummonerScrolls.MOD_ID);

    /* Summon Entities - Tier 1 */
    public static final Supplier<EntityType<ZombieSummon>> ZOMBIE_SUMMON = ENTITY_TYPES.register("zombie_summon", ZombieSummon.TYPE);
    public static final Supplier<EntityType<SpiderSummon>> SPIDER_SUMMON = ENTITY_TYPES.register("spider_summon", SpiderSummon.TYPE);
    public static final Supplier<EntityType<SkeletonSummon>> SKELETON_SUMMON = ENTITY_TYPES.register("skeleton_summon", SkeletonSummon.TYPE);
    public static final Supplier<EntityType<BeeSummon>> BEE_SUMMON = ENTITY_TYPES.register("bee_summon", BeeSummon.TYPE);

    /* Summon Entities - Tier 2 */
    public static final Supplier<EntityType<HuskSummon>> HUSK_SUMMON = ENTITY_TYPES.register("husk_summon", HuskSummon.TYPE);
    public static final Supplier<EntityType<StraySummon>> STRAY_SUMMON = ENTITY_TYPES.register("stray_summon", StraySummon.TYPE);
    public static final Supplier<EntityType<CaveSpiderSummon>> CAVE_SPIDER_SUMMON = ENTITY_TYPES.register("cave_spider_summon", CaveSpiderSummon.TYPE);
    public static final Supplier<EntityType<EndermanSummon>> ENDERMAN_SUMMON = ENTITY_TYPES.register("enderman_summon", EndermanSummon.TYPE);
    public static final Supplier<EntityType<PiglinSummon>> PIGLIN_SUMMON = ENTITY_TYPES.register("piglin_summon", PiglinSummon.TYPE);

    /* Summon Entities - Tier 3 */
    public static final Supplier<EntityType<CreeperSummon>> CREEPER_SUMMON = ENTITY_TYPES.register("creeper_summon", CreeperSummon.TYPE);
    public static final Supplier<EntityType<CreeperSummon>> CHARGED_CREEPER_SUMMON = ENTITY_TYPES.register("charged_creeper_summon", CreeperSummon.TYPE_CHARGED);
    public static final Supplier<EntityType<PiglinBruteSummon>> PIGLIN_BRUTE_SUMMON = ENTITY_TYPES.register("piglin_brute_summon", PiglinBruteSummon.TYPE);
//    //    public static final Supplier<EntityType<> SHULKERMAN_SUMMON = ENTITY_TYPES.register("shulkerman_summoner_scroll", () -> new ScrollItem(SummonerScrollsEnchantments.SHULKERMAN_SCROLL_ENCHANTMENT, new Item.Properties().stacksTo(1).tab(SummonerScrolls.SCROLLS_TAB)));
    public static final Supplier<EntityType<IronGolemSummon>> IRON_GOLEM_SUMMON = ENTITY_TYPES.register("iron_golem_summon", IronGolemSummon.TYPE);

    /* Summon Entities - Tier 4 */
//    public static final Supplier<EntityType<> WARDEN_SUMMON = ENTITY_TYPES.register("warden_summoner_scroll", () ->new ScrollItem(SummonerScrollsEnchantments.WARDEN_SCROLL_ENCHANTMENT, new Item.Properties().stacksTo(1).tab(SummonerScrolls.SCROLLS_TAB)));
//    public static final Supplier<EntityType<> HEROBRINE_SUMMON = ENTITY_TYPES.register("herobrine_summoner_scroll", () ->new ScrollItem(SummonerScrollsEnchantments.HEROBRINE_SCROLL_ENCHANTMENT, new Item.Properties().stacksTo(1).tab(SummonerScrolls.SCROLLS_TAB)));


    public static void postRegister() {
        MobRegistry.attributes(ZOMBIE_SUMMON, ZombieSummon::createSummonAttributes);
        MobRegistry.attributes(SPIDER_SUMMON, SpiderSummon::createSummonAttributes);
        MobRegistry.attributes(SKELETON_SUMMON, SkeletonSummon::createSummonAttributes);
        MobRegistry.attributes(BEE_SUMMON, BeeSummon::createSummonAttributes);

        MobRegistry.attributes(HUSK_SUMMON, HuskSummon::createSummonAttributes);
        MobRegistry.attributes(STRAY_SUMMON, StraySummon::createSummonAttributes);
        MobRegistry.attributes(CAVE_SPIDER_SUMMON, CaveSpiderSummon::createSummonAttributes);
        MobRegistry.attributes(ENDERMAN_SUMMON, CaveSpiderSummon::createSummonAttributes);
        MobRegistry.attributes(PIGLIN_SUMMON, PiglinSummon::createSummonAttributes);

        MobRegistry.attributes(CREEPER_SUMMON, CreeperSummon::createSummonAttributes);
        MobRegistry.attributes(CHARGED_CREEPER_SUMMON, CreeperSummon::createSummonAttributes);
        MobRegistry.attributes(PIGLIN_BRUTE_SUMMON, PiglinBruteSummon::createSummonAttributes);
        MobRegistry.attributes(IRON_GOLEM_SUMMON, IronGolemSummon::createSummonAttributes);
    }

    private static <T extends LivingEntity> Supplier<EntityType<T>> register(String id, EntityType.Builder<T> builder) {
        return ENTITY_TYPES.register(id, () -> builder.build(new ResourceLocation(SummonerScrolls.MOD_ID, id).toString()));
    }
}
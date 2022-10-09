package com.github.teamfusion.summonerscrolls.common.registry;

import com.github.teamfusion.summonerscrolls.SummonerScrolls;
import com.github.teamfusion.summonerscrolls.common.entity.HuskSummon;
import com.github.teamfusion.summonerscrolls.common.entity.SkeletonSummon;
import com.github.teamfusion.summonerscrolls.common.entity.ZombieSummon;
import com.github.teamfusion.summonerscrolls.common.item.ScrollItem;
import dev.architectury.registry.level.entity.EntityAttributeRegistry;
import dev.architectury.registry.registries.DeferredRegister;
import dev.architectury.registry.registries.RegistrySupplier;
import net.minecraft.core.Registry;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.item.Item;

public class SSEntityTypes {
    public static final DeferredRegister<EntityType<?>> ENTITY_TYPES = DeferredRegister.create(SummonerScrolls.MOD_ID, Registry.ENTITY_TYPE_REGISTRY);

    /* Summon Entities - Tier 1 */
    public static final RegistrySupplier<EntityType<ZombieSummon>> ZOMBIE_SUMMON = ENTITY_TYPES.register("zombie_summon", ZombieSummon.TYPE);
//    public static final RegistrySupplier<EntityType<>> SPIDER_SUMMON = ENTITY_TYPES.register("spider_summon", ZombieSummon.TYPE);
    public static final RegistrySupplier<EntityType<SkeletonSummon>> SKELETON_SUMMON = ENTITY_TYPES.register("skeleton_summon", SkeletonSummon.TYPE);
//    public static final RegistrySupplier<EntityType<>> BEE_SUMMON = ENTITY_TYPES.register("bee_summon", ZombieSummon.TYPE);

    /* Summon Entities - Tier 2 */
    public static final RegistrySupplier<EntityType<HuskSummon>> HUSK_SUMMON = ENTITY_TYPES.register("husk_summon", HuskSummon.TYPE);
//    public static final RegistrySupplier<EntityType<>> STRAY_SUMMON = ENTITY_TYPES.register("stray_summon", ZombieSummon.TYPE);
//    public static final RegistrySupplier<EntityType<>> CAVE_SPIDER_SUMMON = ENTITY_TYPES.register("cave_spider_summon", ZombieSummon.TYPE);
//    public static final RegistrySupplier<EntityType<>> ENDERMAN_SUMMON = ENTITY_TYPES.register("enderman_summon", ZombieSummon.TYPE);
//    public static final RegistrySupplier<EntityType<>> PIGLIN_SUMMON = ENTITY_TYPES.register("piglin_summon", ZombieSummon.TYPE);

    /* Summon Entities - Tier 3 */
//    public static final RegistrySupplier<EntityType<>> CREEPER_SUMMON = ENTITY_TYPES.register("creeper_summon", ZombieSummon.TYPE);
//    public static final RegistrySupplier<EntityType<>> CHARGED_CREEPER_SUMMON = ENTITY_TYPES.register("charged_creeper_summon", ZombieSummon.TYPE);
//    public static final RegistrySupplier<EntityType<>> PIGLIN_BRUTE_SUMMON = ENTITY_TYPES.register("piglin_brute_summon", ZombieSummon.TYPE);
//    //    public static final RegistrySupplier<EntityType<> SHULKERMAN_SUMMON = ENTITY_TYPES.register("shulkerman_summoner_scroll", () ->
////            new ScrollItem(SummonerScrollsEnchantments.SHULKERMAN_SCROLL_ENCHANTMENT, new Item.Properties().stacksTo(1).tab(SummonerScrolls.SCROLLS_TAB)));
//    public static final RegistrySupplier<EntityType<>> IRON_GOLEM_SUMMON = ENTITY_TYPES.register("iron_golem_summon", ZombieSummon.TYPE);

    /* Summon Entities - Tier 4 */
//    public static final RegistrySupplier<EntityType<> WARDEN_SUMMON = ENTITY_TYPES.register("warden_summoner_scroll", () ->
//            new ScrollItem(SummonerScrollsEnchantments.WARDEN_SCROLL_ENCHANTMENT, new Item.Properties().stacksTo(1).tab(SummonerScrolls.SCROLLS_TAB)));
//    public static final RegistrySupplier<EntityType<> HEROBRINE_SUMMON = ENTITY_TYPES.register("herobrine_summoner_scroll", () ->
//            new ScrollItem(SummonerScrollsEnchantments.HEROBRINE_SCROLL_ENCHANTMENT, new Item.Properties().stacksTo(1).tab(SummonerScrolls.SCROLLS_TAB)));


    public static void postRegister() {
        EntityAttributeRegistry.register(ZOMBIE_SUMMON, ZombieSummon::createSummonAttributes);
        EntityAttributeRegistry.register(HUSK_SUMMON, HuskSummon::createSummonAttributes);
        EntityAttributeRegistry.register(SKELETON_SUMMON, SkeletonSummon::createSummonAttributes);
    }

    private static <T extends LivingEntity> RegistrySupplier<EntityType<T>> register(String id, EntityType.Builder<T> builder) {
        return ENTITY_TYPES.register(id, () -> builder.build(new ResourceLocation(SummonerScrolls.MOD_ID, id).toString()));
    }
}
package com.github.teamfusion.summonerscrolls.entity;

import com.github.teamfusion.summonerscrolls.SummonerScrolls;
import dev.architectury.registry.level.entity.EntityAttributeRegistry;
import dev.architectury.registry.registries.DeferredRegister;
import dev.architectury.registry.registries.RegistrySupplier;
import net.minecraft.core.Registry;
import net.minecraft.world.entity.EntityType;

public class SummonerScrollsEntities {
    public static final DeferredRegister<EntityType<?>> ENTITY_TYPES = DeferredRegister.create(SummonerScrolls.MOD_ID, Registry.ENTITY_TYPE_REGISTRY);

    public static final RegistrySupplier<EntityType<ZombieSummon>> ZOMBIE_SUMMON = ENTITY_TYPES.register("zombie_summon", ZombieSummon.TYPE);

    static {
        EntityAttributeRegistry.register(ZOMBIE_SUMMON, ZombieSummon::createAttributes);
    }
}
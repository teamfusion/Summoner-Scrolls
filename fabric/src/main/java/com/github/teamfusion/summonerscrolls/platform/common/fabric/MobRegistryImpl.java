package com.github.teamfusion.summonerscrolls.platform.common.fabric;

import net.fabricmc.fabric.api.object.builder.v1.entity.FabricDefaultAttributeRegistry;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.ai.attributes.AttributeSupplier;

import java.util.function.Supplier;

@SuppressWarnings("ConstantConditions")
public class MobRegistryImpl {
    public static void attributes(Supplier<? extends EntityType<? extends LivingEntity>> type, Supplier<AttributeSupplier.Builder> builder) {
        FabricDefaultAttributeRegistry.register(type.get(), builder.get());
    }
}

package com.github.teamfusion.summonerscrolls.entity;

import com.google.common.base.Suppliers;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.MobCategory;
import net.minecraft.world.entity.monster.Zombie;
import net.minecraft.world.level.Level;

import java.util.function.Supplier;

public class ZombieSummon extends Zombie {
    public static final Supplier<EntityType<ZombieSummon>> TYPE = Suppliers.memoize(() -> EntityType.Builder.of(ZombieSummon::new, MobCategory.MISC).sized(0.98F, 0.7F).clientTrackingRange(8).build("zombie_summon"));

    public ZombieSummon(EntityType<? extends Zombie> entityType, Level level) {
        super(entityType, level);
    }
}
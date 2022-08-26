package com.github.teamfusion.summonerscrolls.entity;

import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.monster.Zombie;
import net.minecraft.world.level.Level;

public class SummonZombie extends Zombie {
    public SummonZombie(EntityType<? extends Zombie> entityType, Level level) {
        super(entityType, level);
    }
}
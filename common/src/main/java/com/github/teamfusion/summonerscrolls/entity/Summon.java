package com.github.teamfusion.summonerscrolls.entity;

import com.github.teamfusion.summonerscrolls.client.particle.SummonerScrollsParticles;
import net.minecraft.util.Mth;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.monster.Enemy;
import net.minecraft.world.level.LevelAccessor;

import java.util.Random;
import java.util.UUID;

public interface Summon {
    void setOwnerUUID(UUID uuid);

    UUID getOwnerUUID();

    LivingEntity getOwner();

    LivingEntity getSummon();

    void setDespawnDelay(int i);

    int getDespawnDelay();

    default void spawnSummonParticles(Random random, LevelAccessor level, double x, double y, double z) {
        for (float i = 0; i < Mth.TWO_PI; i += random.nextFloat(3.2F) + 0.5F) {
            level.addParticle(SummonerScrollsParticles.SUMMON_PARTICLE.get(), x + Mth.cos(i) * 1.0D, y, z + Mth.sin(i) * 1.0D, 0.0D, 0.0D, 0.0D);
        }
    }

    default boolean isEnemy(LivingEntity livingEntity) {
        if (livingEntity instanceof Summon summon) {
            if (summon.getOwner() == this.getOwner()) {
                return false;
            }
        }
        return livingEntity instanceof Enemy;
    }

    default boolean isAngryAt(LivingEntity livingEntity) {
        if (!this.getSummon().canAttack(livingEntity)) {
            return false;
        } else {
            return livingEntity.getType() == EntityType.PLAYER && !livingEntity.getUUID().equals(this.getOwnerUUID());
        }
    }
}
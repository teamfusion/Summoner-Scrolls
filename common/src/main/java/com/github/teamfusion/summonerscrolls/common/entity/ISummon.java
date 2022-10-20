package com.github.teamfusion.summonerscrolls.common.entity;

import com.github.teamfusion.summonerscrolls.client.particle.SummonerScrollsParticles;
import com.github.teamfusion.summonerscrolls.common.entity.goal.FollowOwnerGoal;
import com.github.teamfusion.summonerscrolls.common.entity.goal.OwnerHurtByTargetGoal;
import net.minecraft.util.Mth;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Mob;
import net.minecraft.world.entity.PathfinderMob;
import net.minecraft.world.entity.ai.goal.*;
import net.minecraft.world.entity.ai.goal.target.NearestAttackableTargetGoal;
import net.minecraft.world.entity.monster.Enemy;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.LevelAccessor;

import java.util.Random;
import java.util.UUID;

@SuppressWarnings("unused")
public interface ISummon {
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
        if (livingEntity instanceof ISummon summon) {
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

    default void commonGoals(GoalSelector targetSelector, GoalSelector goalSelector) {
        if (this.getSummon() instanceof PathfinderMob mob) {
            targetSelector.addGoal(1, new OwnerHurtByTargetGoal(mob));
            targetSelector.addGoal(3, new NearestAttackableTargetGoal<>(mob, Mob.class, 5, false, false, this::isEnemy));
            targetSelector.addGoal(4, new NearestAttackableTargetGoal<>(mob, Player.class, 10, true, false, this::isAngryAt));
            goalSelector.addGoal(5, new WaterAvoidingRandomStrollGoal(mob, 1.0));
            goalSelector.addGoal(6, new FollowOwnerGoal(mob, 1.0, 10.0F, 2.0F, false));
            goalSelector.addGoal(7, new LookAtPlayerGoal(mob, Player.class, 6.0F));
            goalSelector.addGoal(8, new RandomLookAroundGoal(mob));
        }
    }
}
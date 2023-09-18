package com.github.teamfusion.summonerscrolls.common.entity;

import com.github.teamfusion.summonerscrolls.client.particle.SummonerScrollsParticles;
import com.github.teamfusion.summonerscrolls.common.entity.goal.FollowOwnerGoal;
import com.github.teamfusion.summonerscrolls.common.entity.goal.OwnerHurtByTargetGoal;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.util.Mth;
import net.minecraft.util.RandomSource;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Mob;
import net.minecraft.world.entity.PathfinderMob;
import net.minecraft.world.entity.ai.goal.GoalSelector;
import net.minecraft.world.entity.ai.goal.LookAtPlayerGoal;
import net.minecraft.world.entity.ai.goal.RandomLookAroundGoal;
import net.minecraft.world.entity.ai.goal.WaterAvoidingRandomStrollGoal;
import net.minecraft.world.entity.ai.goal.target.HurtByTargetGoal;
import net.minecraft.world.entity.ai.goal.target.NearestAttackableTargetGoal;
import net.minecraft.world.entity.ai.goal.target.ResetUniversalAngerTargetGoal;
import net.minecraft.world.entity.monster.Creeper;
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

    default void spawnSummonParticles(RandomSource random, LevelAccessor level, double x, double y, double z) {
        for (float i = 0; i < Mth.TWO_PI; i += random.nextFloat() + 0.5F) {
            level.addParticle(SummonerScrollsParticles.SUMMON_PARTICLE.get(), x + Mth.cos(i) * 1.0D, y, z + Mth.sin(i) * 1.0D, 0.0D, 0.0D, 0.0D);
        }
    }

    default void spawnCoolParticles(RandomSource random, LevelAccessor level, double x, double y, double z) {
        for (float i = 0; i < Mth.TWO_PI; i += random.nextFloat() + 1F) {
            level.addParticle(ParticleTypes.EXPLOSION, x + Mth.cos(i) * 0.5D, y, z + Mth.sin(i) * 0.5D, 0.0D, 0.0D, 0.0D);
        }
    }

    default void spawnSummonParticles(Random random, LevelAccessor level, double x, double y, double z, float intensity, double intensity2) {
        for (float i = 0; i < Mth.TWO_PI; i += random.nextFloat(intensity) + intensity2) {
            level.addParticle(SummonerScrollsParticles.SUMMON_PARTICLE.get(), x + Mth.cos(i) * intensity2, y, z + Mth.sin(i) * intensity2, 0.0D, 0.0D, 0.0D);
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

    default boolean isSummonAngryAt(LivingEntity livingEntity) {
        if (!this.getSummon().canAttack(livingEntity)) {
            return false;
        } else {
            return !livingEntity.getUUID().equals(this.getOwnerUUID());
        }
    }

    default void commonGoals(GoalSelector targetSelector, GoalSelector goalSelector) {
        if (this.getSummon() instanceof Mob mob) {
            targetSelector.addGoal(1, new OwnerHurtByTargetGoal(mob));
            targetSelector.addGoal(3, new NearestAttackableTargetGoal<>(mob, Mob.class, 5, false, false, this::isEnemy));
            if (mob instanceof PathfinderMob pathfinderMob) {
                goalSelector.addGoal(5, new WaterAvoidingRandomStrollGoal(pathfinderMob, 1.0));
                targetSelector.addGoal(3, new HurtByTargetGoal(pathfinderMob));
            }
            goalSelector.addGoal(6, new FollowOwnerGoal(mob, 1.0, 10.0F, 2.0F, false));
            goalSelector.addGoal(7, new LookAtPlayerGoal(mob, Player.class, 6.0F));
            targetSelector.addGoal(8, new ResetUniversalAngerTargetGoal(mob, true));
            goalSelector.addGoal(9, new RandomLookAroundGoal(mob));
        }
    }
}
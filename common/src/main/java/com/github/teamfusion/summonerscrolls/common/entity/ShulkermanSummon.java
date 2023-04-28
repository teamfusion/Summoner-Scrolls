package com.github.teamfusion.summonerscrolls.common.entity;

import net.minecraft.core.Direction;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.world.Difficulty;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.ai.attributes.AttributeSupplier;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.entity.ai.goal.Goal;
import net.minecraft.world.entity.ai.goal.MeleeAttackGoal;
import net.minecraft.world.entity.monster.EnderMan;
import net.minecraft.world.entity.monster.Monster;
import net.minecraft.world.entity.projectile.ShulkerBullet;
import net.minecraft.world.level.Level;

import java.util.EnumSet;

public class ShulkermanSummon extends EndermanSummon {
    public ShulkermanSummon(EntityType<? extends EnderMan> entityType, Level level) {
        super(entityType, level);
    }

    @Override
    protected void registerGoals() {
        this.commonGoals(this.targetSelector, this.goalSelector);
        this.goalSelector.addGoal(2, new MeleeAttackGoal(this, 1.0, true));
        this.goalSelector.addGoal(4, new ShulkermanSummon.ShulkermanAttackGoal());
    }

    class ShulkermanAttackGoal extends Goal {
        private int attackTime;

        public ShulkermanAttackGoal() {
            this.setFlags(EnumSet.of(Flag.MOVE, Flag.LOOK));
        }

        public boolean canUse() {
            LivingEntity livingEntity = ShulkermanSummon.this.getTarget();
            if (livingEntity != null && livingEntity.isAlive()) {
                return ShulkermanSummon.this.level.getDifficulty() != Difficulty.PEACEFUL;
            } else {
                return false;
            }
        }

        public void start() {
            this.attackTime = 20;
//            ShulkermanSummon.this.setRawPeekAmount(100);
        }

        public void stop() {
//            ShulkermanSummon.this.setRawPeekAmount(0);
        }

        public boolean requiresUpdateEveryTick() {
            return true;
        }

        public void tick() {
            if (ShulkermanSummon.this.level.getDifficulty() != Difficulty.PEACEFUL) {
                --this.attackTime;
                LivingEntity livingEntity = ShulkermanSummon.this.getTarget();
                if (livingEntity != null) {
                    ShulkermanSummon.this.getLookControl().setLookAt(livingEntity, 180.0F, 180.0F);
                    double d = ShulkermanSummon.this.distanceToSqr(livingEntity);
                    if (d < 400.0) {
                        if (this.attackTime <= 0) {
                            this.attackTime = 20 + ShulkermanSummon.this.random.nextInt(10) * 20 / 2;
                            ShulkermanSummon.this.level.addFreshEntity(new ShulkerBullet(ShulkermanSummon.this.level, ShulkermanSummon.this, livingEntity, Direction.Axis.X));
                            ShulkermanSummon.this.playSound(SoundEvents.SHULKER_SHOOT, 2.0F, (ShulkermanSummon.this.random.nextFloat() - ShulkermanSummon.this.random.nextFloat()) * 0.2F + 1.0F);
                        }
                    } else {
                        ShulkermanSummon.this.setTarget(null);
                    }

                    super.tick();
                }
            }
        }
    }

    public static AttributeSupplier.Builder createSummonAttributes() {
        return Monster.createMonsterAttributes().add(Attributes.FOLLOW_RANGE, 35.0)
                .add(Attributes.MOVEMENT_SPEED, 0.3)
                .add(Attributes.ATTACK_DAMAGE, 10.0)
                .add(Attributes.ARMOR, 2.0)
                .add(Attributes.MAX_HEALTH, 40.0)
                .add(Attributes.SPAWN_REINFORCEMENTS_CHANCE);
    }
}
package com.github.teamfusion.summonerscrolls.common.entity.goal;

import com.github.teamfusion.summonerscrolls.common.entity.StraySummon;
import com.github.teamfusion.summonerscrolls.common.registry.SSItems;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.ai.goal.RangedBowAttackGoal;
import net.minecraft.world.entity.monster.Monster;
import net.minecraft.world.entity.monster.RangedAttackMob;
import net.minecraft.world.entity.projectile.ProjectileUtil;

public class SummonerRangedBowAttackGoal<T extends Monster & RangedAttackMob> extends RangedBowAttackGoal<T> {
    private final T mob;

    public SummonerRangedBowAttackGoal(T monster, double d, int i, float f) {
        super(monster, d, i, f);
        this.mob = monster;
    }

    @Override
    protected boolean isHoldingBow() {
        return this.mob.isHolding(SSItems.SUMMON_BOW.get());
    }

    @Override
    public void tick() {
        LivingEntity livingEntity = this.mob.getTarget();
        if (livingEntity != null) {
            double d = this.mob.distanceToSqr(livingEntity.getX(), livingEntity.getY(), livingEntity.getZ());
            boolean bl = this.mob.getSensing().hasLineOfSight(livingEntity);
            boolean bl2 = this.seeTime > 0;
            if (bl != bl2) {
                this.seeTime = 0;
            }

            if (bl) {
                ++this.seeTime;
            } else {
                --this.seeTime;
            }

            if (!(d > (double)this.attackRadiusSqr) && this.seeTime >= 20) {
                this.mob.getNavigation().stop();
                ++this.strafingTime;
            } else {
                this.mob.getNavigation().moveTo(livingEntity, this.speedModifier);
                this.strafingTime = -1;
            }

            if (this.strafingTime >= 20) {
                if ((double)this.mob.getRandom().nextFloat() < 0.3) {
                    this.strafingClockwise = !this.strafingClockwise;
                }

                if ((double)this.mob.getRandom().nextFloat() < 0.3) {
                    this.strafingBackwards = !this.strafingBackwards;
                }

                this.strafingTime = 0;
            }

            if (this.strafingTime > -1) {
                if (d > (double)(this.attackRadiusSqr * 0.75F)) {
                    this.strafingBackwards = false;
                } else if (d < (double)(this.attackRadiusSqr * 0.25F)) {
                    this.strafingBackwards = true;
                }

                this.mob.getMoveControl().strafe(this.strafingBackwards ? -0.5F : 0.5F, this.strafingClockwise ? 0.5F : -0.5F);
                this.mob.lookAt(livingEntity, 30.0F, 30.0F);
            } else {
                this.mob.getLookControl().setLookAt(livingEntity, 30.0F, 30.0F);
            }

            if (this.mob.isUsingItem()) {
                if (!bl && this.seeTime < -60) {
                    this.mob.stopUsingItem();
                } else if (bl) {
                    int i = this.mob.getTicksUsingItem();
                    if (i >= 20) {
                        this.mob.stopUsingItem();
                        if (this.mob instanceof StraySummon)
                            this.mob.performRangedAttack(livingEntity, 2.0F);
                        else
                            this.mob.performRangedAttack(livingEntity, 1.0F);
                        this.attackTime = this.attackIntervalMin;
                    }
                }
            } else if (--this.attackTime <= 0 && this.seeTime >= -60) {
                this.mob.startUsingItem(ProjectileUtil.getWeaponHoldingHand(this.mob, SSItems.SUMMON_BOW.get()));
            }

        }
    }
}
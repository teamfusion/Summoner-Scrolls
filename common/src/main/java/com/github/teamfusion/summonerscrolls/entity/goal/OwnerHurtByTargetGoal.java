package com.github.teamfusion.summonerscrolls.entity.goal;

import java.util.EnumSet;

import com.github.teamfusion.summonerscrolls.entity.ZombieSummon;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Mob;
import net.minecraft.world.entity.TamableAnimal;
import net.minecraft.world.entity.ai.goal.Goal.Flag;
import net.minecraft.world.entity.ai.goal.target.TargetGoal;
import net.minecraft.world.entity.ai.targeting.TargetingConditions;

public class OwnerHurtByTargetGoal extends TargetGoal {
    private final ZombieSummon mob;
    private LivingEntity ownerLastHurtBy;
    private int timestamp;

    public OwnerHurtByTargetGoal(ZombieSummon mob) {
        super(mob, false);
        this.mob = mob;
        this.setFlags(EnumSet.of(Flag.TARGET));
    }

    public boolean canUse() {
        LivingEntity livingEntity = this.mob.getOwner();
        if (livingEntity == null) {
            return false;
        } else {
            this.ownerLastHurtBy = livingEntity.getLastHurtByMob();
            int i = livingEntity.getLastHurtByMobTimestamp();
            return i != this.timestamp && this.canAttack(this.ownerLastHurtBy, TargetingConditions.DEFAULT) && this.mob.wantsToAttack(this.ownerLastHurtBy, livingEntity);
        }
    }

    public void start() {
        this.mob.setTarget(this.ownerLastHurtBy);
        LivingEntity livingEntity = this.mob.getOwner();
        if (livingEntity != null) {
            this.timestamp = livingEntity.getLastHurtByMobTimestamp();
        }

        super.start();
    }
}
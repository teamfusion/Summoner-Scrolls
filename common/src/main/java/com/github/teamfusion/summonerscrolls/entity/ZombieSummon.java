package com.github.teamfusion.summonerscrolls.entity;

import com.github.teamfusion.summonerscrolls.entity.goal.FollowOwnerGoal;
import com.github.teamfusion.summonerscrolls.entity.goal.OwnerHurtByTargetGoal;
import com.google.common.base.Suppliers;
import net.minecraft.MethodsReturnNonnullByDefault;
import net.minecraft.world.entity.*;
import net.minecraft.world.entity.ai.goal.MeleeAttackGoal;
import net.minecraft.world.entity.ai.goal.target.NearestAttackableTargetGoal;
import net.minecraft.world.entity.monster.Enemy;
import net.minecraft.world.entity.monster.Zombie;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.Level;
import org.jetbrains.annotations.Nullable;

import javax.annotation.ParametersAreNonnullByDefault;
import java.util.UUID;
import java.util.function.Supplier;

//todo: make dyeable, make it hold invisble torch for dynamic lighting, shift-right click to cancel summon, impermeable summon

@MethodsReturnNonnullByDefault
@ParametersAreNonnullByDefault
public class ZombieSummon extends Zombie {
    public static final Supplier<EntityType<ZombieSummon>> TYPE = Suppliers.memoize(() -> EntityType.Builder.of(ZombieSummon::new, MobCategory.MISC).sized(0.6F, 1.95F).clientTrackingRange(8).build("zombie_summon"));

    public static UUID ownerUUID;

    public ZombieSummon(EntityType<? extends Zombie> entityType, Level level) {
        super(entityType, level);
    }

    public MobType getMobType() {
        return SummonerMobTypes.SUMMON;
    }

    @Override
    protected void registerGoals() {
        this.targetSelector.addGoal(1, new OwnerHurtByTargetGoal(this));
        this.targetSelector.addGoal(3, new NearestAttackableTargetGoal<>(this, Mob.class, 5, false, false, (livingEntity) -> livingEntity instanceof Enemy));
        this.targetSelector.addGoal(4, new NearestAttackableTargetGoal<>(this, Player.class, 10, true, false, this::isAngryAt));
        this.goalSelector.addGoal(5, new MeleeAttackGoal(this, 1.0, true));
        this.goalSelector.addGoal(6, new FollowOwnerGoal(this, 1.0, 10.0F, 2.0F, false));
    }

    public boolean isAngryAt(LivingEntity livingEntity) {
        if (!this.canAttack(livingEntity)) {
            return false;
        } else {
            return livingEntity.getType() == EntityType.PLAYER && !livingEntity.getUUID().equals(this.getOwnerUUID());
        }
    }

    @Override
    public boolean isBaby() {
        return false;
    }

    @Override
    protected boolean isSunSensitive() {
        return false;
    }

    @Nullable
    public LivingEntity getOwner() {
        try {
            UUID uUID = this.getOwnerUUID();
            return uUID == null ? null : this.level.getPlayerByUUID(uUID);
        } catch (IllegalArgumentException var2) {
            return null;
        }
    }

    public UUID getOwnerUUID() {
        return ownerUUID;
    }

    public void setOwnerUUID(@Nullable UUID uUID) {
        ownerUUID = uUID;
    }
}
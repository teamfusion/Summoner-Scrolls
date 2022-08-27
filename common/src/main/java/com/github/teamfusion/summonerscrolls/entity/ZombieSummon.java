package com.github.teamfusion.summonerscrolls.entity;

import com.github.teamfusion.summonerscrolls.entity.goal.FollowOwnerGoal;
import com.github.teamfusion.summonerscrolls.entity.goal.OwnerHurtByTargetGoal;
import com.github.teamfusion.summonerscrolls.util.ScrollEnchantUtil;
import com.google.common.base.Suppliers;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.network.syncher.EntityDataAccessor;
import net.minecraft.network.syncher.EntityDataSerializers;
import net.minecraft.network.syncher.SynchedEntityData;
import net.minecraft.server.players.OldUsersConverter;
import net.minecraft.world.entity.*;
import net.minecraft.world.entity.ai.goal.LeapAtTargetGoal;
import net.minecraft.world.entity.ai.goal.MeleeAttackGoal;
import net.minecraft.world.entity.ai.goal.target.NearestAttackableTargetGoal;
import net.minecraft.world.entity.monster.Creeper;
import net.minecraft.world.entity.monster.Enemy;
import net.minecraft.world.entity.monster.Zombie;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.Level;
import org.jetbrains.annotations.Nullable;

import java.util.Optional;
import java.util.UUID;
import java.util.function.Supplier;

public class ZombieSummon extends Zombie {
    public static final Supplier<EntityType<ZombieSummon>> TYPE = Suppliers.memoize(() -> EntityType.Builder.of(ZombieSummon::new, MobCategory.MISC).sized(0.98F, 0.7F).clientTrackingRange(8).build("zombie_summon"));

    protected static final EntityDataAccessor<Optional<UUID>> DATA_OWNERUUID_ID = SynchedEntityData.defineId(ZombieSummon.class, EntityDataSerializers.OPTIONAL_UUID);

    public ZombieSummon(EntityType<? extends Zombie> entityType, Level level) {
        super(entityType, level);
        this.setOwnerUUID(ScrollEnchantUtil.getOwner().getUUID());
    }

    public MobType getMobType() {
        return SummonerMobTypes.SUMMON;
    }

    @Override
    protected void registerGoals() {
        this.goalSelector.addGoal(4, new LeapAtTargetGoal(this, 0.4F));
        this.goalSelector.addGoal(5, new MeleeAttackGoal(this, 1.0, true));
        this.targetSelector.addGoal(1, new OwnerHurtByTargetGoal(this));
        this.goalSelector.addGoal(6, new FollowOwnerGoal(this, 1.0, 10.0F, 2.0F, false));
        this.targetSelector.addGoal(3, new NearestAttackableTargetGoal(this, Mob.class, 5, false, false, (livingEntity) -> livingEntity instanceof Enemy));
        this.targetSelector.addGoal(4, new NearestAttackableTargetGoal(this, Player.class, 10, true, false, (object -> {
            LivingEntity livingEntity = (LivingEntity) object;
            if (!livingEntity.getUUID().equals(this.getOwnerUUID())) {
                return false;
            } if (!this.canAttack(livingEntity)) {
                return false;
            } else {
                return livingEntity.getType() == EntityType.PLAYER;
            }
        })));
    }

    @Override
    public boolean isBaby() {
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

    public void addAdditionalSaveData(CompoundTag compoundTag) {
        super.addAdditionalSaveData(compoundTag);
        if (this.getOwnerUUID() != null) {
            compoundTag.putUUID("Owner", this.getOwnerUUID());
        }
    }

    public void readAdditionalSaveData(CompoundTag compoundTag) {
        super.readAdditionalSaveData(compoundTag);
        UUID uUID;
        if (compoundTag.hasUUID("Owner")) {
            uUID = compoundTag.getUUID("Owner");
        } else {
            String string = compoundTag.getString("Owner");
            uUID = OldUsersConverter.convertMobOwnerIfNecessary(this.getServer(), string);
        }

        if (uUID != null) {
            try {
                this.setOwnerUUID(uUID);
            } catch (Throwable ignored) {
            }
        }
    }

    public UUID getOwnerUUID() {
        return (UUID)((Optional)this.entityData.get(DATA_OWNERUUID_ID)).orElse(null);
    }

    public void setOwnerUUID(@Nullable UUID uUID) {
        this.entityData.set(DATA_OWNERUUID_ID, Optional.ofNullable(uUID));
    }

    public boolean wantsToAttack(LivingEntity livingEntity, LivingEntity livingEntity2) {
        return true;
    }

    @Override
    protected boolean isSunSensitive() {
        return false;
    }
}
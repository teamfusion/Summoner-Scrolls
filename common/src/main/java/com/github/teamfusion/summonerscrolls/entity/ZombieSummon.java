package com.github.teamfusion.summonerscrolls.entity;

import com.github.teamfusion.summonerscrolls.client.particle.SummonerScrollsParticles;
import com.github.teamfusion.summonerscrolls.entity.goal.FollowOwnerGoal;
import com.github.teamfusion.summonerscrolls.entity.goal.OwnerHurtByTargetGoal;
import com.github.teamfusion.summonerscrolls.item.SummonerScrollsItems;
import com.github.teamfusion.summonerscrolls.sound.SummonerScrollsSoundEvents;
import com.google.common.base.Suppliers;
import net.minecraft.MethodsReturnNonnullByDefault;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.util.Mth;
import net.minecraft.world.DifficultyInstance;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.entity.*;
import net.minecraft.world.entity.ai.attributes.AttributeSupplier;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.entity.ai.goal.LookAtPlayerGoal;
import net.minecraft.world.entity.ai.goal.MeleeAttackGoal;
import net.minecraft.world.entity.ai.goal.RandomLookAroundGoal;
import net.minecraft.world.entity.ai.goal.target.NearestAttackableTargetGoal;
import net.minecraft.world.entity.monster.Enemy;
import net.minecraft.world.entity.monster.Monster;
import net.minecraft.world.entity.monster.Zombie;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;

import javax.annotation.ParametersAreNonnullByDefault;
import java.util.UUID;
import java.util.function.Supplier;

@MethodsReturnNonnullByDefault
@ParametersAreNonnullByDefault
public class ZombieSummon extends Zombie implements Summon {
    public static final Supplier<EntityType<ZombieSummon>> TYPE = Suppliers.memoize(() -> EntityType.Builder.of(ZombieSummon::new, MobCategory.MISC).sized(0.6F, 1.95F).clientTrackingRange(8).build("zombie_summon"));

    public static UUID ownerUUID;
    private int despawnDelay;

    public ZombieSummon(EntityType<? extends Zombie> entityType, Level level) {
        super(entityType, level);
    }

    public MobType getMobType() {
        return SummonerMobTypes.SUMMON;
    }

    @Override
    protected void registerGoals() {
        this.targetSelector.addGoal(1, new OwnerHurtByTargetGoal(this));
        this.targetSelector.addGoal(3, new NearestAttackableTargetGoal<>(this, Mob.class, 5, false, false, this::isEnemy));
        this.targetSelector.addGoal(4, new NearestAttackableTargetGoal<>(this, Player.class, 10, true, false, this::isAngryAt));
        this.goalSelector.addGoal(5, new MeleeAttackGoal(this, 1.0, true));
        this.goalSelector.addGoal(6, new FollowOwnerGoal(this, 1.0, 10.0F, 2.0F, false));
        this.goalSelector.addGoal(7, new LookAtPlayerGoal(this, Player.class, 6.0F));
        this.goalSelector.addGoal(8, new RandomLookAroundGoal(this));
    }

    @Override
    public LivingEntity getOwner() {
        try {
            UUID uUID = this.getOwnerUUID();
            return uUID == null ? null : this.level.getPlayerByUUID(uUID);
        } catch (IllegalArgumentException var2) {
            return null;
        }
    }

    @Override
    public UUID getOwnerUUID() {
        return ownerUUID;
    }

    @Override
    public void setOwnerUUID(UUID uUID) {
        ownerUUID = uUID;
    }

    public boolean isAngryAt(LivingEntity livingEntity) {
        if (!this.canAttack(livingEntity)) {
            return false;
        } else {
            return livingEntity.getType() == EntityType.PLAYER && !livingEntity.getUUID().equals(this.getOwnerUUID());
        }
    }

    public boolean isEnemy(LivingEntity livingEntity) {
        if (livingEntity instanceof Summon summon) {
            if (summon.getOwner() == this.getOwner()) {
                return false;
            }
        }
        return livingEntity instanceof Enemy;
    }

    @Override
    public boolean isBaby() {
        return false;
    }

    @Override
    protected boolean isSunSensitive() {
        return false;
    }

    @Override
    public boolean hurt(DamageSource damageSource, float f) {
        if (damageSource.getEntity() == this.getOwner()) {
            return false;
        }
        return super.hurt(damageSource, f);
    }

    @Override
    public void push(Entity entity) {
        if (entity == this.getOwner()) {
            return;
        }
        super.push(entity);
    }

    @Override
    protected void doPush(Entity entity) {
        if (entity == this.getOwner()) {
            return;
        }
        super.doPush(entity);
    }

    @Override
    protected InteractionResult mobInteract(Player player, InteractionHand interactionHand) {
        if (player.isShiftKeyDown()) {
            this.kill();
            return InteractionResult.SUCCESS;
        }
        return super.mobInteract(player, interactionHand);
    }

    @Override
    protected SoundEvent getDeathSound() {
        return SummonerScrollsSoundEvents.SUMMON_DEATH.get();
    }

    @Override
    public void addAdditionalSaveData(CompoundTag compoundTag) {
        super.addAdditionalSaveData(compoundTag);
        compoundTag.putInt("DespawnDelay", this.despawnDelay);
    }

    @Override
    public void readAdditionalSaveData(CompoundTag compoundTag) {
        super.readAdditionalSaveData(compoundTag);
        if (compoundTag.contains("DespawnDelay", 99)) {
            this.despawnDelay = compoundTag.getInt("DespawnDelay");
        }
    }

    @Override
    protected boolean shouldDropLoot() {
        return false;
    }

    @Override
    protected void populateDefaultEquipmentSlots(DifficultyInstance difficultyInstance) {
        this.setItemSlot(EquipmentSlot.OFFHAND, new ItemStack(SummonerScrollsItems.INVISIBLE_SUMMON_LIGHT.get()));
    }

    @Override
    public void aiStep() {
        super.aiStep();
        if (!this.level.isClientSide) {
            this.maybeDespawn();
        }
        spawnSummonParticles();
    }

    @Override
    public void setDespawnDelay(int i) {
        this.despawnDelay = i;
    }

    @Override
    public int getDespawnDelay() {
        return this.despawnDelay;
    }

    private void maybeDespawn() {
        if (this.despawnDelay > 0 && --this.despawnDelay == 0) {
            this.kill();
        }
    }

    private void spawnSummonParticles() {
        for (float i = 0; i < Mth.TWO_PI; i += this.random.nextFloat(3.2F) + 0.5F) {
            this.level.addParticle(SummonerScrollsParticles.SUMMON_PARTICLE.get(), this.getX() + Mth.cos(i) * 1.0D, this.getRandomY(), this.getZ() + Mth.sin(i) * 1.0D, 0.0D, 0.0D, 0.0D);
        }
    }

    public static AttributeSupplier.Builder createSummonAttributes() {
        return Monster.createMonsterAttributes().add(Attributes.FOLLOW_RANGE, 35.0).add(Attributes.MOVEMENT_SPEED, 0.3).add(Attributes.ATTACK_DAMAGE, 3.0).add(Attributes.ARMOR, 2.0).add(Attributes.SPAWN_REINFORCEMENTS_CHANCE);
    }
}
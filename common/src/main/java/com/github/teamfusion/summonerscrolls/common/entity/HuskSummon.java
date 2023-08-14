package com.github.teamfusion.summonerscrolls.common.entity;

import com.github.teamfusion.summonerscrolls.common.registry.SSItems;
import com.github.teamfusion.summonerscrolls.common.sound.SummonerScrollsSoundEvents;
import com.google.common.base.Suppliers;
import net.minecraft.MethodsReturnNonnullByDefault;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.util.RandomSource;
import net.minecraft.world.DifficultyInstance;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.MobCategory;
import net.minecraft.world.entity.MobSpawnType;
import net.minecraft.world.entity.MobType;
import net.minecraft.world.entity.SpawnGroupData;
import net.minecraft.world.entity.ai.attributes.AttributeSupplier;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.entity.ai.goal.MeleeAttackGoal;
import net.minecraft.world.entity.monster.Husk;
import net.minecraft.world.entity.monster.Monster;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.ServerLevelAccessor;
import org.jetbrains.annotations.Nullable;

import javax.annotation.ParametersAreNonnullByDefault;
import java.util.UUID;
import java.util.function.Supplier;

@ParametersAreNonnullByDefault
@MethodsReturnNonnullByDefault
public class HuskSummon extends Husk implements ISummon {
    public static final Supplier<EntityType<HuskSummon>> TYPE = Suppliers.memoize(() -> EntityType.Builder.of(HuskSummon::new, MobCategory.MISC).sized(0.6F, 1.95F).clientTrackingRange(8).build("husk_summon"));

    public static UUID ownerUUID;
    private int despawnDelay;

    public HuskSummon(EntityType<? extends Husk> entityType, Level level) {
        super(entityType, level);
    }

    public MobType getMobType() {
        return MobType.UNDEFINED;
    }

    @Override
    protected void registerGoals() {
        this.commonGoals(this.targetSelector, this.goalSelector);
        goalSelector.addGoal(2, new MeleeAttackGoal(this, 1.0, true));
    }

    @Override
    public LivingEntity getSummon() {
        return this;
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
    protected void dropEquipment() {
        super.dropEquipment();
        ItemStack itemstack = this.getItemBySlot(EquipmentSlot.OFFHAND);
        if (!itemstack.isEmpty()) {
            this.setItemSlot(EquipmentSlot.OFFHAND, ItemStack.EMPTY);
        }
    }

    @Override
    protected void populateDefaultEquipmentSlots(RandomSource randomSource, DifficultyInstance difficultyInstance) {
        this.setItemSlot(EquipmentSlot.OFFHAND, new ItemStack(SSItems.INVISIBLE_SUMMON_LIGHT.get()));
        super.populateDefaultEquipmentSlots(randomSource, difficultyInstance);
    }

    @Override
    public void aiStep() {
        super.aiStep();
        this.maybeDespawn();
        this.spawnSummonParticles(this.random, this.level, this.getX(), this.getRandomY(), this.getZ());
    }

    @Override
    public boolean doHurtTarget(Entity entity) {
        boolean bl = super.doHurtTarget(entity);
        if (entity instanceof LivingEntity livingEntity) {
            if (bl && this.getMainHandItem().isEmpty()) {
                float f = this.level.getCurrentDifficultyAt(this.blockPosition()).getEffectiveDifficulty();
                livingEntity.addEffect(new MobEffectInstance(MobEffects.HUNGER, 140 * (int) f), this);
                livingEntity.setSecondsOnFire(8);
            }
        }

        return bl;
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

    public static AttributeSupplier.Builder createSummonAttributes() {
        return Monster.createMonsterAttributes().add(Attributes.FOLLOW_RANGE, 35.0)
                .add(Attributes.MOVEMENT_SPEED, 0.4)
                .add(Attributes.ATTACK_DAMAGE, 6.0)
                .add(Attributes.ARMOR, 2.0)
                .add(Attributes.SPAWN_REINFORCEMENTS_CHANCE);
    }

    @Override
    protected boolean isSunBurnTick() {
        return false;
    }

    float time = 0;
    @Override
    public void tick() {
        if (this.isSumoningCooldown()) {
            time--;
            this.setDeltaMovement(0,0,0);
            this.spawnCoolParticles(this.random, this.level, this.getX(), this.getRandomY(), this.getZ());
        }
        super.tick();
    }

    public boolean isSumoningCooldown() {
        return time >= 0;
    }

    @Nullable
    @Override
    public SpawnGroupData finalizeSpawn(ServerLevelAccessor serverLevelAccessor, DifficultyInstance difficultyInstance, MobSpawnType mobSpawnType, @Nullable SpawnGroupData spawnGroupData, @Nullable CompoundTag compoundTag) {
        time = 75;
        return super.finalizeSpawn(serverLevelAccessor, difficultyInstance, mobSpawnType, spawnGroupData, compoundTag);
    }
}
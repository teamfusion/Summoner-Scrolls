package com.github.teamfusion.summonerscrolls.common.entity;

import com.google.common.base.Suppliers;
import net.minecraft.MethodsReturnNonnullByDefault;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.MobCategory;
import net.minecraft.world.entity.projectile.AbstractArrow;
import net.minecraft.world.entity.projectile.Arrow;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;

import javax.annotation.ParametersAreNonnullByDefault;
import java.util.UUID;
import java.util.function.Supplier;

@MethodsReturnNonnullByDefault
@ParametersAreNonnullByDefault
public class StraySummon extends SkeletonSummon implements ISummon {
    public static final Supplier<EntityType<StraySummon>> TYPE = Suppliers.memoize(() -> EntityType.Builder.of(StraySummon::new, MobCategory.MISC).sized(0.6F, 1.99F).clientTrackingRange(8).build("stray_summon"));

    public static UUID ownerUUID;

    public StraySummon(EntityType<? extends StraySummon> entityType, Level level) {
        super(entityType, level);
    }

    @Override
    public SoundEvent getAmbientSound() {
        return SoundEvents.STRAY_AMBIENT;
    }

    @Override
    public SoundEvent getHurtSound(DamageSource damageSource) {
        return SoundEvents.STRAY_HURT;
    }

    @Override
    protected AbstractArrow getArrow(ItemStack itemStack, float f) {
        AbstractArrow abstractArrow = super.getArrow(itemStack, f);
        if (abstractArrow instanceof Arrow) {
            ((Arrow)abstractArrow).addEffect(new MobEffectInstance(MobEffects.MOVEMENT_SLOWDOWN, 600));
        }

        return abstractArrow;
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
    public LivingEntity getOwner() {
        try {
            UUID uUID = this.getOwnerUUID();
            return uUID == null ? null : this.level.getPlayerByUUID(uUID);
        } catch (IllegalArgumentException var2) {
            return null;
        }
    }

    @Override
    public LivingEntity getSummon() {
        return this;
    }
}
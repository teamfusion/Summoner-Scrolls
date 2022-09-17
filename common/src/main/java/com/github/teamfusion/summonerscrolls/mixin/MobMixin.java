package com.github.teamfusion.summonerscrolls.mixin;

import com.github.teamfusion.summonerscrolls.entity.Summon;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.Mob;
import net.minecraft.world.level.Level;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Mixin(Mob.class)
public abstract class MobMixin extends Entity {
    public MobMixin(EntityType<?> entityType, Level level) {
        super(entityType, level);
    }

    @Inject(method = "isSunBurnTick", at = @At("HEAD"), cancellable = true)
    protected void isSunBurnTick(CallbackInfoReturnable<Boolean> cir) {
        if (this instanceof Summon) {
            cir.setReturnValue(false);
        }
    }
}
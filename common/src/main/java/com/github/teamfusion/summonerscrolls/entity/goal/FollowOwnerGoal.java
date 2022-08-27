package com.github.teamfusion.summonerscrolls.entity.goal;

import net.minecraft.core.BlockPos;
import net.minecraft.world.entity.LivingEntity;
import com.github.teamfusion.summonerscrolls.entity.ZombieSummon;
import net.minecraft.world.entity.ai.goal.Goal;
import net.minecraft.world.entity.ai.navigation.FlyingPathNavigation;
import net.minecraft.world.entity.ai.navigation.GroundPathNavigation;
import net.minecraft.world.entity.ai.navigation.PathNavigation;
import net.minecraft.world.level.LevelReader;
import net.minecraft.world.level.block.LeavesBlock;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.pathfinder.BlockPathTypes;
import net.minecraft.world.level.pathfinder.WalkNodeEvaluator;

import java.util.EnumSet;

public class FollowOwnerGoal extends Goal {
    public static final int TELEPORT_WHEN_DISTANCE_IS = 12;
    private static final int MIN_HORIZONTAL_DISTANCE_FROM_PLAYER_WHEN_TELEPORTING = 2;
    private static final int MAX_HORIZONTAL_DISTANCE_FROM_PLAYER_WHEN_TELEPORTING = 3;
    private static final int MAX_VERTICAL_DISTANCE_FROM_PLAYER_WHEN_TELEPORTING = 1;
    private final ZombieSummon summon;
    private LivingEntity owner;
    private final LevelReader level;
    private final double speedModifier;
    private final PathNavigation navigation;
    private int timeToRecalcPath;
    private final float stopDistance;
    private final float startDistance;
    private float oldWaterCost;
    private final boolean canFly;

    public FollowOwnerGoal(ZombieSummon summon, double d, float f, float g, boolean bl) {
        this.summon = summon;
        this.level = summon.level;
        this.speedModifier = d;
        this.navigation = summon.getNavigation();
        this.startDistance = f;
        this.stopDistance = g;
        this.canFly = bl;
        this.setFlags(EnumSet.of(Flag.MOVE, Flag.LOOK));
    }

    public boolean canUse() {
        LivingEntity livingEntity = this.summon.getOwner();
        if (livingEntity == null) {
            return false;
        } else if (livingEntity.isSpectator()) {
            return false;
        } else if (this.summon.distanceToSqr(livingEntity) < (double) (this.startDistance * this.startDistance)) {
            return false;
        } else {
            this.owner = livingEntity;
            return true;
        }
    }

    public boolean canContinueToUse() {
        if (this.navigation.isDone()) {
            return false;
        } else {
            return !(this.summon.distanceToSqr(this.owner) <= (double) (this.stopDistance * this.stopDistance));
        }
    }

    public void start() {
        this.timeToRecalcPath = 0;
        this.oldWaterCost = this.summon.getPathfindingMalus(BlockPathTypes.WATER);
        this.summon.setPathfindingMalus(BlockPathTypes.WATER, 0.0F);
    }

    public void stop() {
        this.owner = null;
        this.navigation.stop();
        this.summon.setPathfindingMalus(BlockPathTypes.WATER, this.oldWaterCost);
    }

    public void tick() {
        this.summon.getLookControl().setLookAt(this.owner, 10.0F, (float) this.summon.getMaxHeadXRot());
        if (--this.timeToRecalcPath <= 0) {
            this.timeToRecalcPath = this.adjustedTickDelay(10);
            if (!this.summon.isLeashed() && !this.summon.isPassenger()) {
                if (this.summon.distanceToSqr(this.owner) >= 144.0) {
                    this.teleportToOwner();
                } else {
                    this.navigation.moveTo(this.owner, this.speedModifier);
                }

            }
        }
    }

    private void teleportToOwner() {
        BlockPos blockPos = this.owner.blockPosition();

        for (int i = 0; i < 10; ++i) {
            int j = this.randomIntInclusive(-3, 3);
            int k = this.randomIntInclusive(-1, 1);
            int l = this.randomIntInclusive(-3, 3);
            boolean bl = this.maybeTeleportTo(blockPos.getX() + j, blockPos.getY() + k, blockPos.getZ() + l);
            if (bl) {
                return;
            }
        }

    }

    private boolean maybeTeleportTo(int i, int j, int k) {
        if (Math.abs((double) i - this.owner.getX()) < 2.0 && Math.abs((double) k - this.owner.getZ()) < 2.0) {
            return false;
        } else if (!this.canTeleportTo(new BlockPos(i, j, k))) {
            return false;
        } else {
            this.summon.moveTo((double) i + 0.5, (double) j, (double) k + 0.5, this.summon.getYRot(), this.summon.getXRot());
            this.navigation.stop();
            return true;
        }
    }

    private boolean canTeleportTo(BlockPos blockPos) {
        BlockPathTypes blockPathTypes = WalkNodeEvaluator.getBlockPathTypeStatic(this.level, blockPos.mutable());
        if (blockPathTypes != BlockPathTypes.WALKABLE) {
            return false;
        } else {
            BlockState blockState = this.level.getBlockState(blockPos.below());
            if (!this.canFly && blockState.getBlock() instanceof LeavesBlock) {
                return false;
            } else {
                BlockPos blockPos2 = blockPos.subtract(this.summon.blockPosition());
                return this.level.noCollision(this.summon, this.summon.getBoundingBox().move(blockPos2));
            }
        }
    }

    private int randomIntInclusive(int i, int j) {
        return this.summon.getRandom().nextInt(j - i + 1) + i;
    }
}

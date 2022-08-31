package com.github.teamfusion.summonerscrolls.mixin;

import com.github.teamfusion.summonerscrolls.entity.ZombieSummon;
import com.github.teamfusion.summonerscrolls.util.ScrollEnchantUtil;
import net.minecraft.MethodsReturnNonnullByDefault;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.InteractionResultHolder;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.MobSpawnType;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.TieredItem;
import net.minecraft.world.item.context.UseOnContext;
import net.minecraft.world.level.ClipContext;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.gameevent.GameEvent;
import net.minecraft.world.phys.BlockHitResult;
import net.minecraft.world.phys.HitResult;
import org.spongepowered.asm.mixin.Mixin;

import javax.annotation.ParametersAreNonnullByDefault;
import java.util.Objects;

@MethodsReturnNonnullByDefault
@ParametersAreNonnullByDefault
@Mixin(TieredItem.class)
public abstract class TieredItemMixin extends Item {
    public TieredItemMixin(Properties properties) {
        super(properties);
    }

    @Override
    public InteractionResult useOn(UseOnContext useOnContext) {
        Player player = useOnContext.getPlayer();
        ItemStack stack = useOnContext.getItemInHand();
        EntityType<?> entityType2 = ScrollEnchantUtil.getEntityType(stack);
        Level level = useOnContext.getLevel();

        assert player != null;

        if (!(level instanceof ServerLevel)) {
            return InteractionResult.SUCCESS;
        } else {
            ItemStack itemStack = useOnContext.getItemInHand();
            BlockPos blockPos = useOnContext.getClickedPos();
            Direction direction = useOnContext.getClickedFace();
            BlockState blockState = level.getBlockState(blockPos);

            BlockPos blockPos2;
            if (blockState.getCollisionShape(level, blockPos).isEmpty()) {
                blockPos2 = blockPos;
            } else {
                blockPos2 = blockPos.relative(direction);
            }
            Entity summon = entityType2.spawn((ServerLevel)level, itemStack, player, blockPos2, MobSpawnType.MOB_SUMMONED, true, !Objects.equals(blockPos, blockPos2) && direction == Direction.UP);
            if (summon instanceof ZombieSummon mob) {
                mob.setOwnerUUID(player.getUUID());
                player.getCooldowns().addCooldown(this, 1200);
                mob.setDespawnDelay(600);
                level.gameEvent(player, GameEvent.ENTITY_PLACE, blockPos);
            }

            return InteractionResult.SUCCESS;
        }
    }

    @Override
    public InteractionResultHolder<ItemStack> use(Level level, Player player, InteractionHand interactionHand) {
        ItemStack stack = player.getItemInHand(interactionHand);

        EntityType<?> entityType = ScrollEnchantUtil.getEntityType(stack);

        ItemStack itemStack = player.getItemInHand(interactionHand);
        BlockHitResult hitResult = getPlayerPOVHitResult(level, player, ClipContext.Fluid.SOURCE_ONLY);
        if (hitResult.getType() != HitResult.Type.BLOCK) {
            return InteractionResultHolder.pass(itemStack);
        } else if (!(level instanceof ServerLevel)) {
            return InteractionResultHolder.success(itemStack);
        } else {
            BlockPos blockPos = hitResult.getBlockPos();
            if (level.mayInteract(player, blockPos) && player.mayUseItemAt(blockPos, hitResult.getDirection(), itemStack)) {
                if (entityType.spawn((ServerLevel)level, itemStack, player, blockPos, MobSpawnType.MOB_SUMMONED, false, false) == null) {
                    return InteractionResultHolder.pass(itemStack);
                } else {
                    level.gameEvent(GameEvent.ENTITY_PLACE, player);
                    return InteractionResultHolder.success(itemStack);
                }
            } else {
                return InteractionResultHolder.fail(itemStack);
            }
        }
    }
}
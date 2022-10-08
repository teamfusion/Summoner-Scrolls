package com.github.teamfusion.summonerscrolls.mixin;

import com.github.teamfusion.summonerscrolls.common.entity.ISummon;
import com.github.teamfusion.summonerscrolls.common.util.ScrollUtil;
import net.minecraft.MethodsReturnNonnullByDefault;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.server.level.ServerPlayer;
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
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.gameevent.GameEvent;
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
        EntityType<?> entityType2 = ScrollUtil.getEntityType(stack);
        Level level = useOnContext.getLevel();

        assert player != null;

        ItemStack itemStack = useOnContext.getItemInHand();
        BlockPos blockPos = useOnContext.getClickedPos();
        Direction direction = useOnContext.getClickedFace();
        BlockState blockState = level.getBlockState(blockPos);

        if (level.mayInteract(player, blockPos)) {
            if (!(level instanceof ServerLevel)) {
                return InteractionResult.SUCCESS;
            } else {
                BlockPos blockPos2;
                if (blockState.getCollisionShape(level, blockPos).isEmpty()) {
                    blockPos2 = blockPos;
                } else {
                    blockPos2 = blockPos.relative(direction);
                }
                if (player.totalExperience >= ScrollUtil.getXP(stack)) {
                    Entity summon = entityType2.spawn((ServerLevel) level, itemStack, player, blockPos2, MobSpawnType.MOB_SUMMONED, true, !Objects.equals(blockPos, blockPos2) && direction == Direction.UP);
                    if (summon instanceof ISummon mob) {
                        spawnSummon(player, stack, level, blockPos, mob);
                        return InteractionResult.SUCCESS;
                    } else {
                        return InteractionResult.FAIL;
                    }
                }
            }
        }
        return InteractionResult.FAIL;
    }

    @Override
    public InteractionResultHolder<ItemStack> use(Level level, Player player, InteractionHand interactionHand) {
        ItemStack stack = player.getItemInHand(interactionHand);
        EntityType<?> entityType = ScrollUtil.getEntityType(stack);
        ItemStack itemStack = player.getItemInHand(interactionHand);
        BlockPos blockPos = player.getOnPos();

        if (level.mayInteract(player, blockPos)) {
            if (!(level instanceof ServerLevel)) {
                return InteractionResultHolder.success(itemStack);
            } else {
                if (player.totalExperience >= ScrollUtil.getXP(stack)) {
                    Entity summon = entityType.spawn((ServerLevel) level, itemStack, player, blockPos, MobSpawnType.MOB_SUMMONED, true, true);
                    if (summon instanceof ISummon mob) {
                        spawnSummon(player, stack, level, blockPos, mob);
                        return InteractionResultHolder.success(itemStack);
                    } else {
                        return InteractionResultHolder.fail(itemStack);
                    }
                }
            }
        }
        return InteractionResultHolder.fail(itemStack);
    }

    private void spawnSummon(Player player, ItemStack stack, Level level, BlockPos blockPos, ISummon mob) {
        mob.setOwnerUUID(player.getUUID());
        player.getCooldowns().addCooldown(this, 1200);
        mob.setDespawnDelay(600);
        player.giveExperiencePoints(-ScrollUtil.getXP(stack));
        stack.hurt(ScrollUtil.getDurability(stack), level.random, (ServerPlayer) player);

        level.gameEvent(player, GameEvent.ENTITY_PLACE, blockPos);
    }
}
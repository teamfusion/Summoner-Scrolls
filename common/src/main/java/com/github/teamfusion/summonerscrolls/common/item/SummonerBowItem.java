package com.github.teamfusion.summonerscrolls.common.item;

import com.github.teamfusion.summonerscrolls.common.registry.SSItems;
import net.minecraft.MethodsReturnNonnullByDefault;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.sounds.SoundSource;
import net.minecraft.stats.Stats;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.projectile.AbstractArrow;
import net.minecraft.world.item.ArrowItem;
import net.minecraft.world.item.BowItem;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.enchantment.EnchantmentHelper;
import net.minecraft.world.item.enchantment.Enchantments;
import net.minecraft.world.level.Level;

import java.util.function.Predicate;

@MethodsReturnNonnullByDefault
public class SummonerBowItem extends BowItem {
    public static final Predicate<ItemStack> SUMMONER_ARROW_ONLY = (itemStack) -> itemStack.is(SSItems.SUMMON_ARROW.get());

    public SummonerBowItem(Properties properties) {
        super(properties);
    }

    @Override
    public void releaseUsing(ItemStack itemStack, Level level, LivingEntity livingEntity, int i) {
        if (livingEntity instanceof Player player) {
            boolean bl = player.getAbilities().instabuild || EnchantmentHelper.getItemEnchantmentLevel(Enchantments.INFINITY_ARROWS, itemStack) > 0;
            ItemStack itemStack2 = player.getProjectile(itemStack);
            if (!itemStack2.isEmpty() || bl) {
                if (itemStack2.isEmpty()) {
                    itemStack2 = new ItemStack(SSItems.SUMMON_ARROW.get());
                }

                int j = this.getUseDuration(itemStack) - i;
                float f = getPowerForTime(j);
                if (!((double)f < 0.1)) {
                    boolean bl2 = bl && itemStack2.is(SSItems.SUMMON_ARROW.get());
                    if (!level.isClientSide) {
                        ArrowItem arrowItem = (ArrowItem)(itemStack2.getItem() instanceof ArrowItem ? itemStack2.getItem() : SSItems.SUMMON_ARROW.get());
                        AbstractArrow abstractArrow = arrowItem.createArrow(level, itemStack2, player);
                        abstractArrow.shootFromRotation(player, player.getXRot(), player.getYRot(), 0.0F, f * 3.0F, 1.0F);
                        if (f == 1.0F) {
                            abstractArrow.setCritArrow(true);
                        }

                        int k = EnchantmentHelper.getItemEnchantmentLevel(Enchantments.POWER_ARROWS, itemStack);
                        if (k > 0) {
                            abstractArrow.setBaseDamage(abstractArrow.getBaseDamage() + (double)k * 0.5 + 0.5);
                        }

                        int l = EnchantmentHelper.getItemEnchantmentLevel(Enchantments.PUNCH_ARROWS, itemStack);
                        if (l > 0) {
                            abstractArrow.setKnockback(l);
                        }

                        if (EnchantmentHelper.getItemEnchantmentLevel(Enchantments.FLAMING_ARROWS, itemStack) > 0) {
                            abstractArrow.setSecondsOnFire(100);
                        }

                        itemStack.hurtAndBreak(1, player, (player2) -> player2.broadcastBreakEvent(player.getUsedItemHand()));
                        if (bl2 || player.getAbilities().instabuild && (itemStack2.is(SSItems.SUMMON_ARROW.get()) || itemStack2.is(Items.SPECTRAL_ARROW) || itemStack2.is(Items.TIPPED_ARROW))) {
                            abstractArrow.pickup = AbstractArrow.Pickup.CREATIVE_ONLY;
                        }

                        level.addFreshEntity(abstractArrow);
                    }

                    level.playSound(null, player.getX(), player.getY(), player.getZ(), SoundEvents.ARROW_SHOOT, SoundSource.PLAYERS, 1.0F, 1.0F / (level.getRandom().nextFloat() * 0.4F + 1.2F) + f * 0.5F);
                    if (!bl2 && !player.getAbilities().instabuild) {
                        itemStack2.shrink(1);
                        if (itemStack2.isEmpty()) {
                            player.getInventory().removeItem(itemStack2);
                        }
                    }

                    player.awardStat(Stats.ITEM_USED.get(this));
                }
            }
        }
    }

    @Override
    public Predicate<ItemStack> getAllSupportedProjectiles() {
        return SUMMONER_ARROW_ONLY;
    }
}

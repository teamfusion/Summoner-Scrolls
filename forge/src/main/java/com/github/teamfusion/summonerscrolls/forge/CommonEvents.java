package com.github.teamfusion.summonerscrolls.forge;

import com.github.teamfusion.summonerscrolls.SummonerScrolls;
import com.github.teamfusion.summonerscrolls.common.item.ScrollItem;
import com.github.teamfusion.summonerscrolls.common.registry.SSEvents;
import com.github.teamfusion.summonerscrolls.common.registry.SSItems;
import com.github.teamfusion.summonerscrolls.platform.CoreRegistry;
import net.minecraft.core.registries.Registries;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.*;
import net.minecraft.world.item.enchantment.Enchantment;
import net.minecraft.world.item.enchantment.EnchantmentHelper;
import net.minecraftforge.event.AnvilUpdateEvent;
import net.minecraftforge.event.entity.player.PlayerInteractEvent;
import net.minecraftforge.eventbus.api.EventPriority;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.registries.RegisterEvent;
import net.minecraftforge.registries.RegistryObject;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Map;
import java.util.Set;
import java.util.function.Supplier;

@Mod.EventBusSubscriber(modid = SummonerScrolls.MOD_ID)
public class CommonEvents {
    @SubscribeEvent(priority = EventPriority.HIGHEST)
    static void anvilUpdate(AnvilUpdateEvent event) {
        ItemStack left = event.getLeft();
        Item leftItem = left.getItem();
        ItemStack right = event.getRight();
        Item rightItem = right.getItem();

        if (rightItem instanceof ScrollItem scrollItem) {
            Enchantment enchantment = scrollItem.getEnchantment().get();

            if ((leftItem instanceof DiggerItem || leftItem instanceof SwordItem)) {
                Map<Enchantment, Integer> enchantments = EnchantmentHelper.getEnchantments(left);

                boolean canEnchant = true;
                for (Enchantment enchantment2 : enchantments.keySet()) {
                    if (enchantment2 != enchantment && (!enchantment.isCompatibleWith(enchantment2) || !enchantment2.isCompatibleWith(enchantment))) {
                        canEnchant = false;
                        break;
                    }
                }

                if (canEnchant) {
                    enchantments.put(enchantment, 1);
                    ItemStack copy = left.copy();
                    EnchantmentHelper.setEnchantments(enchantments, copy);
                    String name = event.getName();
                    if (name != null && !name.isEmpty()) {
                        copy.setHoverName(Component.literal(name));
                    }

                    event.setOutput(copy);
                    event.setCost(8);
                }
            }
        }
    }

    @SubscribeEvent()
    public static void onEntityInteract(PlayerInteractEvent.RightClickItem event) {
        Player player = event.getEntity();
        InteractionHand hand = event.getHand();
        SSEvents.useScroll(player, hand);
    }

    private static final ResourceKey<CreativeModeTab> TAB = ResourceKey.create(Registries.CREATIVE_MODE_TAB, new ResourceLocation(SummonerScrolls.MOD_ID, "scrolls_tab"));

    @SubscribeEvent()
    public static void creativeModeTabRegister(RegisterEvent event) {
        event.register(Registries.CREATIVE_MODE_TAB, helper -> {
            helper.register(TAB, CreativeModeTab.builder().icon(() -> new ItemStack(SSItems.ENHANCEMENT_SCROLL.get()))
                    .title(Component.translatable("scrolls_tab"))
                    .displayItems((params, output) ->
                            SSItems.ENTRIES.forEach(
                                    (reg) -> output.accept(new ItemStack(reg.get()))
                            ))
                    .build());
        });
    }
}
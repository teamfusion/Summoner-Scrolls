package com.github.teamfusion.summonerscrolls.events;

import com.github.teamfusion.summonerscrolls.entity.ZombieSummon;
import dev.architectury.event.EventResult;
import dev.architectury.event.events.common.InteractionEvent;
import net.minecraft.world.item.ItemStack;

public class CommonEvents {
    public static void interactSummonEvent() {
        InteractionEvent.INTERACT_ENTITY.register((player, entity, hand) -> {
            ItemStack stack = player.getItemInHand(hand);
            if (entity instanceof ZombieSummon) {
                return EventResult.pass();
            }

            return EventResult.interruptFalse();
        });
    }
}
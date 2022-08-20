package com.github.teamfusion.summonerscrolls.forge;

import com.github.teamfusion.enchantment.SummonerScrollsEnchantments;
import com.github.teamfusion.summonerscrolls.SummonerScrolls;
import com.github.teamfusion.summonerscrolls.item.ScrollItem;
import dev.architectury.platform.forge.EventBuses;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.SwordItem;
import net.minecraft.world.item.enchantment.Enchantment;
import net.minecraft.world.item.enchantment.EnchantmentHelper;
import net.minecraftforge.event.AnvilUpdateEvent;
import net.minecraftforge.eventbus.api.EventPriority;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;

import java.util.Map;

@Mod(SummonerScrolls.MOD_ID)
public class SummonerScrollsForge {
    public SummonerScrollsForge() {
        EventBuses.registerModEventBus(SummonerScrolls.MOD_ID, FMLJavaModLoadingContext.get().getModEventBus());
        SummonerScrolls.commonInitialize();
    }


}
package com.github.teamfusion.summonerscrolls.common.sound;

import com.github.teamfusion.summonerscrolls.SummonerScrolls;
import com.github.teamfusion.summonerscrolls.platform.CoreRegistry;
import net.minecraft.core.Registry;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.sounds.SoundEvent;

import java.util.function.Supplier;

public class SummonerScrollsSoundEvents {
    public static final CoreRegistry<SoundEvent> SOUND_EVENTS = CoreRegistry.create(Registry.SOUND_EVENT, SummonerScrolls.MOD_ID);

    public static final Supplier<SoundEvent> SUMMON_DEATH = SOUND_EVENTS.register("entity.summon.death", ()->
            new SoundEvent(new ResourceLocation(SummonerScrolls.MOD_ID, "entity.summon.death")));
}

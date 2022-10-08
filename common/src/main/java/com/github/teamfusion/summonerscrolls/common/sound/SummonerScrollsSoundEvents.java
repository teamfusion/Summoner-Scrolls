package com.github.teamfusion.summonerscrolls.common.sound;

import com.github.teamfusion.summonerscrolls.SummonerScrolls;
import dev.architectury.registry.registries.DeferredRegister;
import dev.architectury.registry.registries.RegistrySupplier;
import net.minecraft.core.Registry;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.sounds.SoundEvent;

public class SummonerScrollsSoundEvents {
    public static final DeferredRegister<SoundEvent> SOUND_EVENTS = DeferredRegister.create(SummonerScrolls.MOD_ID, Registry.SOUND_EVENT_REGISTRY);

    public static final RegistrySupplier<SoundEvent> SUMMON_DEATH = SOUND_EVENTS.register("entity.summon.death", ()->
            new SoundEvent(new ResourceLocation(SummonerScrolls.MOD_ID, "entity.summon.death")));
}

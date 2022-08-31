package com.github.teamfusion.summonerscrolls.client.particle;

import com.github.teamfusion.summonerscrolls.SummonerScrolls;
import dev.architectury.platform.Platform;
import dev.architectury.registry.client.particle.ParticleProviderRegistry;
import dev.architectury.registry.registries.DeferredRegister;
import dev.architectury.registry.registries.RegistrySupplier;
import dev.architectury.utils.Env;
import net.minecraft.core.Registry;
import net.minecraft.core.particles.ParticleType;
import net.minecraft.core.particles.SimpleParticleType;

public class SummonerScrollsParticles {
    public static final DeferredRegister<ParticleType<?>> PARTICLE_TYPES = DeferredRegister.create(SummonerScrolls.MOD_ID, Registry.PARTICLE_TYPE_REGISTRY);

    public static final RegistrySupplier<SimpleParticleType> SUMMON_PARTICLE = PARTICLE_TYPES.register("summon", () -> new SimpleParticleType(false) {});

    public static void init() {
        PARTICLE_TYPES.register();
        if (Platform.getEnvironment() == Env.CLIENT) {
            ParticleProviderRegistry.register(SUMMON_PARTICLE, SummonParticle.Provider::new);
        }
    }
}

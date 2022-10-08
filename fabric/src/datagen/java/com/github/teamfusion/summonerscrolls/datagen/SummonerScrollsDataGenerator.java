package com.github.teamfusion.summonerscrolls.datagen;

import com.github.teamfusion.summonerscrolls.datagen.client.LanguageGenerator;
import com.github.teamfusion.summonerscrolls.datagen.client.ModelGenerator;
import net.fabricmc.fabric.api.datagen.v1.DataGeneratorEntrypoint;
import net.fabricmc.fabric.api.datagen.v1.FabricDataGenerator;

public final class SummonerScrollsDataGenerator implements DataGeneratorEntrypoint {
    @Override
    public void onInitializeDataGenerator(FabricDataGenerator gen) {
        gen.addProvider(ModelGenerator::new);
        gen.addProvider(LanguageGenerator::new);
    }
    //todo: particle and sounds generator
}
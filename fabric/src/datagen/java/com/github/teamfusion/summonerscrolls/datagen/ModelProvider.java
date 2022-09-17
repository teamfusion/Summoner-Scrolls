package com.github.teamfusion.summonerscrolls.datagen;

import com.github.teamfusion.summonerscrolls.item.SummonerScrollsItems;
import dev.architectury.registry.registries.RegistrySupplier;
import net.fabricmc.fabric.api.datagen.v1.FabricDataGenerator;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricModelProvider;
import net.minecraft.data.models.BlockModelGenerators;
import net.minecraft.data.models.ItemModelGenerators;
import net.minecraft.data.models.model.ModelTemplates;
import net.minecraft.world.item.Item;

public final class ModelProvider extends FabricModelProvider {
    public ModelProvider(FabricDataGenerator gen) {
        super(gen);
    }

    @Override
    public void generateBlockStateModels(BlockModelGenerators gen) {
    }

    @Override
    public void generateItemModels(ItemModelGenerators gen) {
        for (RegistrySupplier<Item> item : SummonerScrollsItems.ITEMS) {
            if (item.get() != SummonerScrollsItems.SUMMON_BOW.get()) {
                gen.generateFlatItem(item.get(), ModelTemplates.FLAT_ITEM);
            }
        }
    }
}
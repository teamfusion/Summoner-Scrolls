package com.github.teamfusion.summonerscrolls.datagen.client;

import com.github.teamfusion.summonerscrolls.common.registry.SSItems;
import dev.architectury.registry.registries.RegistrySupplier;
import net.fabricmc.fabric.api.datagen.v1.FabricDataGenerator;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricModelProvider;
import net.minecraft.data.models.BlockModelGenerators;
import net.minecraft.data.models.ItemModelGenerators;
import net.minecraft.data.models.model.ModelTemplates;
import net.minecraft.world.item.Item;

public final class ModelGenerator extends FabricModelProvider {
    public ModelGenerator(FabricDataGenerator dataGenerator) {
        super(dataGenerator);
    }

    @Override
    public void generateBlockStateModels(BlockModelGenerators gen) {
    }

    @Override
    public void generateItemModels(ItemModelGenerators gen) {
        for (RegistrySupplier<Item> item : SSItems.ITEMS) {
            if (item.get() != SSItems.SUMMON_BOW.get()) {
                gen.generateFlatItem(item.get(), ModelTemplates.FLAT_ITEM);
            }
        }
    }

    //todo: bow model
}
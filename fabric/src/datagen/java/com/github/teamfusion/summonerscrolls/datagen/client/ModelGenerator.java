package com.github.teamfusion.summonerscrolls.datagen.client;

import com.github.teamfusion.summonerscrolls.common.registry.SSItems;
import net.fabricmc.fabric.api.datagen.v1.FabricDataGenerator;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricModelProvider;
import net.minecraft.data.models.BlockModelGenerators;
import net.minecraft.data.models.ItemModelGenerators;
import net.minecraft.data.models.model.ModelTemplates;
import net.minecraft.world.item.Item;

import java.lang.reflect.Field;
import java.lang.reflect.Modifier;

public final class ModelGenerator extends FabricModelProvider {
    public ModelGenerator(FabricDataGenerator dataGenerator) {
        super(dataGenerator);
    }

    @Override
    public void generateBlockStateModels(BlockModelGenerators gen) {
    }

    @Override
    public void generateItemModels(ItemModelGenerators gen) {
        for (Field field : SSItems.class.getDeclaredFields()) {
            if (Modifier.isStatic(field.getModifiers()) && field.getType().isAssignableFrom(Item.class)) {
                try {
                    Item item = (Item) field.get(null);
                    if (item != SSItems.SUMMON_BOW) {
                        gen.generateFlatItem(item, ModelTemplates.FLAT_ITEM);
                    }
                } catch (IllegalAccessException e) {
                    System.out.println("Could not generate summoner items.");
                }
            }
        }
    }

    //todo: bow model
}
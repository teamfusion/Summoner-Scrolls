package com.github.teamfusion.summonerscrolls.datagen.client;

import com.github.teamfusion.summonerscrolls.common.registry.SSItems;
import net.fabricmc.fabric.api.datagen.v1.FabricDataGenerator;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricModelProvider;
import net.minecraft.data.models.BlockModelGenerators;
import net.minecraft.data.models.ItemModelGenerators;
import net.minecraft.data.models.model.ModelTemplates;

public final class ModelGenerator extends FabricModelProvider {
    public ModelGenerator(FabricDataGenerator dataGenerator) {
        super(dataGenerator);
    }

    @Override
    public void generateBlockStateModels(BlockModelGenerators gen) {
    }

    @Override
    public void generateItemModels(ItemModelGenerators gen) {
        gen.generateFlatItem(SSItems.ZOMBIE_SCROLL.get(), ModelTemplates.FLAT_ITEM);
        gen.generateFlatItem(SSItems.SPIDER_SCROLL.get(), ModelTemplates.FLAT_ITEM);
        gen.generateFlatItem(SSItems.SPIDER_JOCKEY_SCROLL.get(), ModelTemplates.FLAT_ITEM);
        gen.generateFlatItem(SSItems.SKELETON_SCROLL.get(), ModelTemplates.FLAT_ITEM);
        gen.generateFlatItem(SSItems.BEE_SCROLL.get(), ModelTemplates.FLAT_ITEM);

        gen.generateFlatItem(SSItems.HUSK_SCROLL.get(), ModelTemplates.FLAT_ITEM);
        gen.generateFlatItem(SSItems.STRAY_SCROLL.get(), ModelTemplates.FLAT_ITEM);
        gen.generateFlatItem(SSItems.CAVE_SPIDER_SCROLL.get(), ModelTemplates.FLAT_ITEM);
        gen.generateFlatItem(SSItems.ENDERMAN_SCROLL.get(), ModelTemplates.FLAT_ITEM);
        gen.generateFlatItem(SSItems.PIGLIN_SCROLL.get(), ModelTemplates.FLAT_ITEM);

        gen.generateFlatItem(SSItems.CREEPER_SCROLL.get(), ModelTemplates.FLAT_ITEM);
        gen.generateFlatItem(SSItems.CHARGED_CREEPER_SCROLL.get(), ModelTemplates.FLAT_ITEM);
        gen.generateFlatItem(SSItems.PIGLIN_BRUTE_SCROLL.get(), ModelTemplates.FLAT_ITEM);
        gen.generateFlatItem(SSItems.SHULKERMAN_SCROLL.get(), ModelTemplates.FLAT_ITEM);
        gen.generateFlatItem(SSItems.IRON_GOLEM_SCROLL.get(), ModelTemplates.FLAT_ITEM);

        gen.generateFlatItem(SSItems.ENHANCEMENT_SCROLL.get(), ModelTemplates.FLAT_ITEM);
        gen.generateFlatItem(SSItems.INVISIBLE_SUMMON_LIGHT.get(), ModelTemplates.FLAT_ITEM);

        gen.generateFlatItem(SSItems.SUMMON_ARROW.get(), ModelTemplates.FLAT_ITEM);
        gen.generateFlatItem(SSItems.SUMMON_SWORD.get(), ModelTemplates.FLAT_HANDHELD_ITEM);
        gen.generateFlatItem(SSItems.SUMMON_AXE.get(), ModelTemplates.FLAT_HANDHELD_ITEM);
        gen.generateFlatItem(SSItems.SUMMON_PICKAXE.get(), ModelTemplates.FLAT_HANDHELD_ITEM);
        gen.generateFlatItem(SSItems.SUMMON_SHOVEL.get(), ModelTemplates.FLAT_HANDHELD_ITEM);
        gen.generateFlatItem(SSItems.SUMMON_HOE.get(), ModelTemplates.FLAT_HANDHELD_ITEM);
    }

    //todo: bow model
}
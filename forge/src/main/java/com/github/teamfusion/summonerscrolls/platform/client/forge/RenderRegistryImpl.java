package com.github.teamfusion.summonerscrolls.platform.client.forge;

import com.github.teamfusion.summonerscrolls.SummonerScrolls;
import net.minecraft.client.model.geom.ModelLayerLocation;
import net.minecraft.client.model.geom.builders.LayerDefinition;
import net.minecraft.client.renderer.ItemBlockRenderTypes;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.level.block.Block;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.client.event.EntityRenderersEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

import java.util.Arrays;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import java.util.function.Consumer;
import java.util.function.Supplier;

@Mod.EventBusSubscriber(modid = SummonerScrolls.MOD_ID, value = Dist.CLIENT, bus = Mod.EventBusSubscriber.Bus.MOD)
public class RenderRegistryImpl {
    private static final Set<Consumer<EntityRenderersEvent.RegisterRenderers>> RENDERERS = ConcurrentHashMap.newKeySet();
    private static final Set<Consumer<EntityRenderersEvent.RegisterLayerDefinitions>> DEFINITIONS = ConcurrentHashMap.newKeySet();

    public static void block(RenderType type, Block... blocks) {
        Arrays.stream(blocks).forEach(block -> ItemBlockRenderTypes.setRenderLayer(block, type));
    }

    @SubscribeEvent
    public static void registerRenderer(EntityRenderersEvent.RegisterRenderers event) {
        RENDERERS.forEach(consumer -> consumer.accept(event));
    }

    public static <T extends Entity> void renderer(Supplier<? extends EntityType<? extends T>> type, EntityRendererProvider<T> renderer) {
        RENDERERS.add(event -> event.registerEntityRenderer(type.get(), renderer));
    }

    @SubscribeEvent
    public static void registerLayerDefinition(EntityRenderersEvent.RegisterLayerDefinitions event) {
        DEFINITIONS.forEach(consumer -> consumer.accept(event));
    }

    public static void layerDefinition(ModelLayerLocation layer, Supplier<LayerDefinition> definition) {
        DEFINITIONS.add(event -> event.registerLayerDefinition(layer, definition));
    }
}

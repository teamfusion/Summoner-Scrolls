package com.github.teamfusion.summonerscrolls.client.render;

import com.github.teamfusion.summonerscrolls.SummonerScrolls;
import com.mojang.blaze3d.vertex.DefaultVertexFormat;
import com.mojang.blaze3d.vertex.VertexFormat;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.resources.ResourceLocation;

public class SummonItemGlintRenderType extends RenderType {
    public SummonItemGlintRenderType(String string, VertexFormat vertexFormat, VertexFormat.Mode mode, int i, boolean bl, boolean bl2, Runnable runnable, Runnable runnable2) {
        super(string, vertexFormat, mode, i, bl, bl2, runnable, runnable2);
    }

    public static RenderType getGlintDirect() {
        return RenderType.create("summon_item_glint_direct", DefaultVertexFormat.POSITION_TEX, VertexFormat.Mode.QUADS, 256, CompositeState.builder()
                .setShaderState(RENDERTYPE_GLINT_DIRECT_SHADER)
                .setTextureState(new TextureStateShard(new ResourceLocation(SummonerScrolls.MOD_ID, "textures/misc/summon_item_glint.png"), true, false))
                .setWriteMaskState(COLOR_WRITE)
                .setCullState(NO_CULL)
                .setDepthTestState(EQUAL_DEPTH_TEST)
                .setTransparencyState(GLINT_TRANSPARENCY)
                .setTexturingState(GLINT_TEXTURING)
                .createCompositeState(false));
    }
}

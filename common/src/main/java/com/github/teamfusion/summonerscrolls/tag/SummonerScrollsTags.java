package com.github.teamfusion.summonerscrolls.tag;

import com.github.teamfusion.summonerscrolls.SummonerScrolls;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.EntityTypeTags;
import net.minecraft.tags.TagKey;
import net.minecraft.world.entity.EntityType;

public class
SummonerScrollsTags {
    public static class EntityTypes {
        public static final TagKey<EntityType<?>> SUMMON = tag("summon");

        private static TagKey<EntityType<?>> tag(String name) {
            return EntityTypeTags.create(new ResourceLocation(SummonerScrolls.MOD_ID, name).toString());
        }
    }
}
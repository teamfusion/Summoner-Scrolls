package com.github.teamfusion.summonerscrolls.entity;

import net.minecraft.world.entity.LivingEntity;

import java.util.UUID;

public interface Summon {
    void setOwnerUUID(UUID uuid);

    UUID getOwnerUUID();

    LivingEntity getOwner();

    void setDespawnDelay(int i);

    int getDespawnDelay();
}
package com.github.teamfusion.summonerscrolls.entity;

import java.util.UUID;

public interface Summon {
    void setOwnerUUID(UUID uuid);

    void setDespawnDelay(int i);
}

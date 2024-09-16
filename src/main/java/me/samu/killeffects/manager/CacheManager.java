package me.samu.killeffects.manager;

import me.samu.killeffects.KillEffects;

import java.util.HashMap;
import java.util.UUID;

public class CacheManager {
    private KillEffects killEffects;

    public CacheManager(KillEffects killEffects) {
        this.killEffects = killEffects;
    }

    // HASHMAP
    private HashMap<UUID, Animation> animazioni = new HashMap<>();

    public HashMap<UUID, Animation> getAnimazioni() { return animazioni; }
}

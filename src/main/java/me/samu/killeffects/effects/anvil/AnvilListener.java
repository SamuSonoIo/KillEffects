package me.samu.killeffects.effects.anvil;

import org.bukkit.entity.EntityType;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDamageByEntityEvent;

public class AnvilListener implements Listener {
    @EventHandler
    public void onDamage(EntityDamageByEntityEvent e) {
        if (e.getDamager().getType().equals(EntityType.FALLING_BLOCK)) {
            e.setCancelled(true);
        }
    }
}

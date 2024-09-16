package me.samu.killeffects.listener;

import me.samu.killeffects.KillEffects;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.PlayerDeathEvent;

import java.util.Objects;

public class PlayerDeath implements Listener {

    private KillEffects killEffects;

    public PlayerDeath(KillEffects killEffects) { this.killEffects = killEffects; }

    @EventHandler
    public void onDeath(PlayerDeathEvent e) {
        Player target = e.getEntity().getPlayer();
        if (e.getEntity().getKiller() != null && e.getEntity().getKiller().getType().equals(EntityType.PLAYER)) {
            Player player = e.getEntity().getKiller();
            if (killEffects.getCacheManager().getAnimazioni().containsKey(player.getUniqueId())) {
                killEffects.getKillEffectManager().playAnim(player, target, killEffects.getCacheManager().getAnimazioni().get(player.getUniqueId()));
            }
        }
    }
}

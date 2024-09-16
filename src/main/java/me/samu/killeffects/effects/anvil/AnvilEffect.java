package me.samu.killeffects.effects.anvil;

import me.samu.killeffects.KillEffects;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.block.Block;
import org.bukkit.entity.Player;
import org.bukkit.scheduler.BukkitRunnable;

import java.util.HashMap;
import java.util.UUID;

public class AnvilEffect {
    private KillEffects killEffects;

    public AnvilEffect(KillEffects killEffects) { this.killEffects = killEffects; }

    private HashMap<UUID, Location> luoghi = new HashMap<>();

    public void playAnvil(Player target) {
        double x = target.getLocation().getX();
        double y = target.getLocation().getY() + 10;
        double z = target.getLocation().getZ();
        Block blocco = target.getWorld().getBlockAt((int) x, (int) y, (int) z);
        blocco.setType(Material.ANVIL);
        luoghi.put(target.getUniqueId(), target.getLocation());
        new BukkitRunnable() {
            @Override
            public void run() {
                target.getWorld().getBlockAt(luoghi.get(target.getUniqueId())).setType(Material.AIR);
                luoghi.remove(target.getUniqueId(), target.getLocation());
            }
        }.runTaskLater(killEffects, 100);
    }
}

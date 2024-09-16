package me.samu.killeffects.effects.fireworks;

import me.samu.killeffects.KillEffects;
import org.bukkit.Color;
import org.bukkit.FireworkEffect;
import org.bukkit.entity.Firework;
import org.bukkit.entity.Player;
import org.bukkit.inventory.meta.FireworkMeta;

public class FireWorkEffect {

    private KillEffects killEffects;

    public FireWorkEffect(KillEffects killEffects) { this.killEffects = killEffects; }

    public void playFireWork(Player target) {
        Firework firework = target.getWorld().spawn(target.getLocation(), Firework.class);
        FireworkMeta meta = firework.getFireworkMeta();
        meta.addEffect(FireworkEffect.builder().withColor(Color.RED).withColor(Color.ORANGE).with(FireworkEffect.Type.BALL_LARGE).withFlicker().build());
        meta.setPower(2);
        firework.setFireworkMeta(meta);
    }

}

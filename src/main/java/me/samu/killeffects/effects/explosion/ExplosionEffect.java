package me.samu.killeffects.effects.explosion;

import me.samu.killeffects.KillEffects;
import org.bukkit.Particle;
import org.bukkit.Sound;
import org.bukkit.entity.Player;

public class ExplosionEffect {

    private KillEffects killEffects;

    public ExplosionEffect(KillEffects killEffects) { this.killEffects = killEffects; }

    public void playExplosion(Player target) {
        target.getWorld().spawnParticle(Particle.EXPLOSION_HUGE, target.getLocation(), 10);
        target.getWorld().playSound(target.getLocation(), Sound.ENTITY_GENERIC_EXPLODE, 1f, 1f);
    }

}

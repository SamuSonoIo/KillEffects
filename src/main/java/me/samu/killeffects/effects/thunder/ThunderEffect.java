package me.samu.killeffects.effects.thunder;

import me.samu.killeffects.KillEffects;
import org.bukkit.entity.Player;

public class ThunderEffect {

    private KillEffects killEffects;

    public ThunderEffect(KillEffects killEffects) { this.killEffects = killEffects; }

    public void playThunder(Player target) {
        target.getWorld().strikeLightningEffect(target.getLocation());
    }

}

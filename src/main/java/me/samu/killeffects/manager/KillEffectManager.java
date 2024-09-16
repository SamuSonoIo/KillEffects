package me.samu.killeffects.manager;

import me.samu.killeffects.KillEffects;
import org.bukkit.Bukkit;
import org.bukkit.EntityEffect;
import org.bukkit.entity.Player;

public class KillEffectManager {
    private KillEffects killEffects;

    public KillEffectManager(KillEffects killEffects) { this.killEffects = killEffects; }

    public void playAnim(Player player, Player target, Animation animation) {
        switch (animation) {
            case ANVIL:
                killEffects.anvilEffect.playAnvil(target);
                break;
            case EXPLOSION:
                killEffects.explosionEffect.playExplosion(target);
                break;
            case THUNDER:
                killEffects.thunderEffect.playThunder(target);
                break;
            case FIREWORK:
                killEffects.fireWorkEffect.playFireWork(target);
                break;
            default:
                return;
        }
    }

}

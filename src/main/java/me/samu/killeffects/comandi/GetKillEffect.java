package me.samu.killeffects.comandi;

import me.samu.killeffects.KillEffects;
import me.samu.killeffects.utils.ConfigUtils;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class GetKillEffect implements CommandExecutor {

    private KillEffects killEffects;

    public GetKillEffect(KillEffects killEffects) { this.killEffects = killEffects; }

    @Override
    public boolean onCommand(CommandSender commandSender, Command command, String s, String[] args) {
        if (commandSender instanceof Player) {
            Player player = (Player) commandSender;
            if (killEffects.getCacheManager().getAnimazioni().get(player.getUniqueId()) != null) {
                player.sendMessage(String.valueOf(ConfigUtils.getMessage("EffectType") + killEffects.getCacheManager().getAnimazioni().get(player.getUniqueId())));
            } else {
                player.sendMessage(String.valueOf(ConfigUtils.getMessage("EffectTypeNull")));
            }
        }
        return false;
    }
}

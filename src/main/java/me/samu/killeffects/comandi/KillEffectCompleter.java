package me.samu.killeffects.comandi;

import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.command.TabCompleter;

import java.util.ArrayList;
import java.util.List;

public class KillEffectCompleter implements TabCompleter {

    List<String> arguments = new ArrayList<String>();

    @Override
    public List<String> onTabComplete(CommandSender commandSender, Command command, String s, String[] args) {
        if (arguments.isEmpty()) {
            arguments.add("reload");
        }

        List<String> result = new ArrayList<String>();
        if (args.length == 1) {
            for ( String a : arguments ) {
                if (a.toLowerCase().startsWith(args[0].toLowerCase())) {
                    result.add(a);
                }
                return result;
            }
        }

        return null;
    }
}

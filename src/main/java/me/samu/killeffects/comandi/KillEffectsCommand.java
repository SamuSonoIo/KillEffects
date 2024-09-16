package me.samu.killeffects.comandi;

import me.samu.killeffects.KillEffects;
import me.samu.killeffects.utils.ConfigUtils;
import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.persistence.PersistentDataType;
import org.bukkit.NamespacedKey;

public class KillEffectsCommand implements CommandExecutor {

    private KillEffects killEffects;

    public KillEffectsCommand(KillEffects killEffects) { this.killEffects = killEffects; }

    @Override
    public boolean onCommand(CommandSender commandSender, Command command, String s, String[] args) {
        if (!(commandSender instanceof Player player)) {
            Bukkit.getLogger().warning("Command only for players");
            return true;
        }

        if (args.length == 1 && args[0].equalsIgnoreCase("reload")) {
            if (!player.hasPermission("KillEffects.Reload")) {
                player.sendMessage(ConfigUtils.getMessage("NoPermission"));
                return true;
            } else {
                player.sendMessage(ConfigUtils.getMessage("Reloaded"));
                killEffects.reloadConfig();
                return true;
            }
        }

        Inventory gui = Bukkit.createInventory(player, 9, "§cᴋɪʟʟ ᴇꜰꜰᴇᴄᴛѕ");

        // ITEMSTACK
        ItemStack anvil = new ItemStack(Material.ANVIL);
        ItemMeta anvilMeta = anvil.getItemMeta();
        anvilMeta.setDisplayName(ConfigUtils.getItemName("Anvil"));
        NamespacedKey anvilKey = new NamespacedKey(killEffects, "effect_type");
        anvilMeta.getPersistentDataContainer().set(anvilKey, PersistentDataType.STRING, "anvil");
        anvil.setItemMeta(anvilMeta);

        ItemStack explosion = new ItemStack(Material.TNT);
        ItemMeta explosionMeta = explosion.getItemMeta();
        explosionMeta.setDisplayName(ConfigUtils.getItemName("Explosion"));
        NamespacedKey explosionKey = new NamespacedKey(killEffects, "effect_type");
        explosionMeta.getPersistentDataContainer().set(explosionKey, PersistentDataType.STRING, "explosion");
        explosion.setItemMeta(explosionMeta);

        ItemStack thunder = new ItemStack(Material.TRIDENT);
        ItemMeta thunderMeta = thunder.getItemMeta();
        thunderMeta.setDisplayName(ConfigUtils.getItemName("Thunder"));
        NamespacedKey thunderKey = new NamespacedKey(killEffects, "effect_type");
        thunderMeta.getPersistentDataContainer().set(thunderKey, PersistentDataType.STRING, "thunder");
        thunder.setItemMeta(thunderMeta);

        ItemStack firework = new ItemStack(Material.FIREWORK_STAR);
        ItemMeta fireMeta = firework.getItemMeta();
        fireMeta.setDisplayName(ConfigUtils.getItemName("FireWorks"));
        NamespacedKey fireKey = new NamespacedKey(killEffects, "effect_type");
        fireMeta.getPersistentDataContainer().set(fireKey, PersistentDataType.STRING, "firework");
        firework.setItemMeta(fireMeta);

        gui.setItem(0, anvil);
        gui.setItem(1, explosion);
        gui.setItem(2, thunder);
        gui.setItem(3, firework);

        player.openInventory(gui);

        return true;
    }
}

package me.samu.killeffects.listener;

import me.samu.killeffects.KillEffects;
import me.samu.killeffects.manager.Animation;
import me.samu.killeffects.utils.ConfigUtils;
import org.bukkit.NamespacedKey;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.persistence.PersistentDataType;

import java.util.Map;
import java.util.Objects;

public class InventoryClick implements Listener {

    private final KillEffects killEffects;

    public InventoryClick(KillEffects killEffects) {
        this.killEffects = killEffects;
    }

    @EventHandler
    public void onClick(InventoryClickEvent e) {
        if (e.getView().getTitle().equals("§cᴋɪʟʟ ᴇꜰꜰᴇᴄᴛѕ")) {
            e.setCancelled(true);

            Player player = (Player) e.getWhoClicked();
            if (e.getCurrentItem() != null && e.getCurrentItem().hasItemMeta()) {
                ItemMeta itemMeta = Objects.requireNonNull(e.getCurrentItem().getItemMeta());

                Map<String, Animation> animationMap = Map.of(
                        "anvil", Animation.ANVIL,
                        "explosion", Animation.EXPLOSION,
                        "thunder", Animation.THUNDER,
                        "firework", Animation.FIREWORK
                );


                NamespacedKey key = new NamespacedKey(killEffects, "effect_type");
                String effectType = itemMeta.getPersistentDataContainer().get(key, PersistentDataType.STRING);

                if (effectType != null && animationMap.containsKey(effectType)) {
                    killEffects.getCacheManager().getAnimazioni().put(player.getUniqueId(), animationMap.get(effectType));
                    player.sendMessage(ConfigUtils.getMessage("Selected") + animationMap.get(effectType));
                    killEffects.getYamlLoader().getYamlConfiguration().set(player.getUniqueId().toString(), effectType);
                    killEffects.getYamlLoader().saveFile();
                }
            }
        }
    }
}

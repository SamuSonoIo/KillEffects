package me.samu.killeffects.manager.files;

import me.samu.killeffects.KillEffects;
import me.samu.killeffects.manager.Animation;
import org.bukkit.Bukkit;
import org.bukkit.configuration.file.YamlConfiguration;

import java.io.File;
import java.io.IOException;
import java.util.UUID;

public class YamlLoader {

    private KillEffects killEffects;

    private File file;

    private YamlConfiguration yamlConfiguration;

    public YamlLoader(KillEffects killEffects) {
        this.killEffects = killEffects;
        this.file = new File(killEffects.getDataFolder(), "data.yml");
        this.yamlConfiguration = YamlConfiguration.loadConfiguration(file);
    }

    public void initFiles() {
        if (!file.exists()) {
            try {
                file.createNewFile();
            } catch (IOException e) {
                Bukkit.getLogger().warning("Impossibile to generate data.yml file, contact the support on discord!");
            }
        }
    }

    public void initData() {
        if (file.exists()) {
            for (String key : yamlConfiguration.getKeys(false)) {
                try {
                    UUID uuid = UUID.fromString(key);
                    String animationName = yamlConfiguration.getString(key);

                    if (animationName != null) {
                        try {
                            Animation animation = Animation.valueOf(animationName.toUpperCase());
                            killEffects.getCacheManager().getAnimazioni().put(uuid, animation);
                        } catch (IllegalArgumentException ex) {
                            Bukkit.getLogger().warning("Found invalid animation type in data.yml: " + animationName + " for UUID: " + uuid);
                        }
                    } else {
                        Bukkit.getLogger().warning("No animation name found for UUID: " + uuid);
                    }

                } catch (IllegalArgumentException e) {
                    Bukkit.getLogger().warning("Invalid UUID in data.yml: " + key);
                }
            }
        }
    }


    public File getFile() { return file; }

    public YamlConfiguration getYamlConfiguration() { return yamlConfiguration; }

    public void saveFile() {
        try {
            yamlConfiguration.save(file);
        } catch (IOException e) {
            Bukkit.getLogger().warning("Impossible to save data.yml file, contact the support on discord");
        }
    }

}

package me.samu.killeffects;

import me.samu.killeffects.comandi.GetKillEffect;
import me.samu.killeffects.comandi.KillEffectCompleter;
import me.samu.killeffects.comandi.KillEffectsCommand;
import me.samu.killeffects.effects.anvil.AnvilEffect;
import me.samu.killeffects.effects.anvil.AnvilListener;
import me.samu.killeffects.effects.explosion.ExplosionEffect;
import me.samu.killeffects.effects.fireworks.FireWorkEffect;
import me.samu.killeffects.effects.thunder.ThunderEffect;
import me.samu.killeffects.listener.InventoryClick;
import me.samu.killeffects.listener.PlayerDeath;
import me.samu.killeffects.manager.CacheManager;
import me.samu.killeffects.manager.KillEffectManager;
import me.samu.killeffects.manager.files.YamlLoader;
import me.samu.killeffects.utils.ConfigUtils;
import org.bukkit.plugin.java.JavaPlugin;

public final class KillEffects extends JavaPlugin {
    // MANAGERS
    private CacheManager cacheManager;
    private KillEffectManager killEffectManager;
    private YamlLoader yamlLoader;
    // EFFECTS
    public AnvilEffect anvilEffect;
    public ExplosionEffect explosionEffect;
    public ThunderEffect thunderEffect;
    public FireWorkEffect fireWorkEffect;
    // UTILS
    private ConfigUtils configUtils;

    @Override
    public void onEnable() {
        // CONFIG
        getConfig().options().copyDefaults(true);
        saveDefaultConfig();
        // UTILS
        configUtils = new ConfigUtils(this);
        // MANAGER
        killEffectManager = new KillEffectManager(this);
        cacheManager = new CacheManager(this);
        yamlLoader = new YamlLoader(this);
        yamlLoader.initFiles();
        yamlLoader.initData();
        // EFFECTS
        anvilEffect = new AnvilEffect(this);
        explosionEffect = new ExplosionEffect(this);
        thunderEffect = new ThunderEffect(this);
        fireWorkEffect = new FireWorkEffect(this);
        // COMANDI
        getCommand("killeffects").setExecutor(new KillEffectsCommand(this));
        getCommand("killeffects").setTabCompleter(new KillEffectCompleter());
        getCommand("getkilleffect").setExecutor(new GetKillEffect(this));
        // LISTENERS
        getServer().getPluginManager().registerEvents(new AnvilListener(), this);
        getServer().getPluginManager().registerEvents(new InventoryClick(this), this);
        getServer().getPluginManager().registerEvents(new PlayerDeath(this), this);
    }

    @Override
    public void onDisable() {
        cacheManager.getAnimazioni().clear();
    }

    public CacheManager getCacheManager() { return cacheManager; }

    public KillEffectManager getKillEffectManager() { return killEffectManager; }

    public YamlLoader getYamlLoader() { return yamlLoader; }
}

package me.samu.killeffects.utils;

import me.samu.killeffects.KillEffects;

public class ConfigUtils {

    private static KillEffects killEffects;

    public ConfigUtils(KillEffects killEffects) { this.killEffects = killEffects; }

    public static String getItemName(String string) { return killEffects.getConfig().getString("GUI.ItemNames." + string); }

    public static String getMessage(String string) { return killEffects.getConfig().getString("Messages." + string);}

}

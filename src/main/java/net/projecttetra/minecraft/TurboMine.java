package net.projecttetra.minecraft;

import org.bukkit.plugin.java.JavaPlugin;

public class TurboMine extends JavaPlugin
{
    @Override
    public void onEnable() {
        this.getLogger().info("enable " + this.getClass().getSimpleName());
    }

    @Override
    public void onDisable() {
        this.getLogger().info("disable " + this.getClass().getSimpleName());
    }
}


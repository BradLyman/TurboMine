package net.projecttetra.minecraft.spigot;

import org.bukkit.plugin.java.JavaPlugin;

public class TurboMine extends JavaPlugin
{
    @Override
    public void onEnable() {
        this.getLogger().info("enable " + this.getClass().getSimpleName());

        this.getServer()
            .getPluginManager()
            .registerEvents(new DrillListener(), this);
    }

    @Override
    public void onDisable() {
        this.getLogger().info("disable " + this.getClass().getSimpleName());
    }
}


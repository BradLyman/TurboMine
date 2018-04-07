package net.projecttetra.minecraft.spigot.plugin;

import org.bukkit.plugin.java.JavaPlugin;

public class TurboMine extends JavaPlugin
{
    @Override
    public void onEnable() {
        this.getLogger().info("enable " + this.getClass().getSimpleName());

        this.getServer()
            .getPluginManager()
            .registerEvents(new DrillListener(), this);

        this.getServer()
            .getPluginManager()
            .registerEvents(new VeinListener(), this);
    }

    @Override
    public void onDisable() {
        this.getLogger().info("disable " + this.getClass().getSimpleName());
    }
}


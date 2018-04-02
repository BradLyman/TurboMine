package net.projecttetra.minecraft.spigot;

/**
 * This package is the interface between this plugin's logic and the Spigot
 * server API. The native Minecraft classes and the Spigot API are both
 * difficult to test because the objects have tons of fields and methods.
 * Thus the contents of this package require live play-testing instead of
 * targeted unit-testing.
 *
 * This is the only package which is allowed to reference types from the
 * Spigot and NMC packages. This package should depend on the plugin logic.
 *
 * Always look for ways to move logic out of this package.
 */

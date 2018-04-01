package net.projecttetra.minecraft.spigot;

import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockBreakEvent;
import net.projecttetra.minecraft.OffhandTool;

/**
 * Objects of this class represent the Spigot-native listener which activates
 * an Offhand Tool.
 */
public class DrillListener implements Listener
{
    private final OffhandTool offhandTool =
        new OffhandTool(
            "drill",
            () -> { System.out.println("drill applied"); }
        );

    @EventHandler
    public void breakBlock(final BlockBreakEvent event) {
        offhandTool.breakBlock(new OffHandItemName(event));
    }
}

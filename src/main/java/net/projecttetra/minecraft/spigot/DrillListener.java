package net.projecttetra.minecraft.spigot;

import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockBreakEvent;
import net.projecttetra.minecraft.Tool;

/**
 * Objects of this class represent the Spigot-Native listener which activates
 * a drill.
 */
public class DrillListener implements Listener
{
    private final Tool drill =
        new Tool(
            "drill",
            (block) -> {
                System.out.println("drill activated");
            }
        );

    @EventHandler
    public void breakBlock(final BlockBreakEvent event) {
        drill.breakBlocksWith(null, new OffHandItemName(event));
    }
}

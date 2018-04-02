package net.projecttetra.minecraft.spigot;

import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockBreakEvent;
import org.bukkit.inventory.ItemStack;
import java.util.Optional;
import net.projecttetra.minecraft.Block;
import net.projecttetra.minecraft.SquareVolume;
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
            new SquareVolume()
        );

    @EventHandler
    public void breakBlock(final BlockBreakEvent event) {
        final Block center =
            new WorldBlock(
                event.getBlock().getWorld(),
                event.getBlock(),
                mainItem(event)
            );

        drill.breakBlocksWith(center, new OffHandItemName(event));
    }

    private Optional<ItemStack> mainItem(final BlockBreakEvent event) {
        return Optional
            .ofNullable(event.getPlayer())
            .map((player) -> player.getEquipment())
            .map((equipment) -> equipment.getItemInMainHand());
    }
}

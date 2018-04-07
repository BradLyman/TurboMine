package net.projecttetra.minecraft.spigot.plugin;

import java.util.Optional;
import net.projecttetra.minecraft.Block;
import net.projecttetra.minecraft.DFSVolume;
import net.projecttetra.minecraft.Tool;
import net.projecttetra.minecraft.spigot.OffHandItemName;
import net.projecttetra.minecraft.spigot.WorldBlock;
import net.projecttetra.minecraft.spigot.BlockHasSameType;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockBreakEvent;
import org.bukkit.inventory.ItemStack;

public final class VeinListener implements Listener
{
    final BlockHasSameType typeMatcher = new BlockHasSameType();
    final Tool vein =
        new Tool(
            "vein",
            new DFSVolume(typeMatcher)
        );

    @EventHandler
    public void breakBlock(final BlockBreakEvent event)
    {
        typeMatcher.setWorld(event.getBlock().getWorld());
        final Block center =
            new WorldBlock(
                event.getBlock().getWorld(),
                event.getBlock(),
                mainItem(event)
            );
        vein.breakBlocksWith(center, new OffHandItemName(event));
    }

    private Optional<ItemStack> mainItem(final BlockBreakEvent event) {
        return Optional
            .ofNullable(event.getPlayer())
            .map((player) -> player.getEquipment())
            .map((equipment) -> equipment.getItemInMainHand());
    }
}

package net.projecttetra.minecraft.spigot;

import java.util.Optional;
import lombok.NonNull;
import lombok.Value;
import org.bukkit.event.block.BlockBreakEvent;

import net.projecttetra.minecraft.OffhandTool;

/**
 * Objects of this class represent the name of the item in the player's offhand
 * at the time a block is broken.
 */
@Value
public final class OffHandItemName implements OffhandTool.Name {

    @NonNull BlockBreakEvent event;

    /**
     * Get the name of the offhand item from the event, or else "".
     */
    @Override
    public String display() {
        return Optional
            .of(event.getPlayer())
            .map((player) -> player.getEquipment())
            .map((equipment) -> equipment.getItemInOffHand())
            .map((item) -> item.getItemMeta())
            .map((meta) -> meta.getDisplayName())
            .orElse("");
    }
}

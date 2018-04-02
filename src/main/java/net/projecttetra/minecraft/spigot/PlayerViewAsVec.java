package net.projecttetra.minecraft.spigot;

import lombok.AllArgsConstructor;
import lombok.NonNull;
import net.projecttetra.minecraft.linalg.Vector;
import org.bukkit.event.block.BlockBreakEvent;

/**
 * Objects of this class represent the player's view direction as our Vector.
 */
@AllArgsConstructor
public final class PlayerViewAsVec implements Vector
{
    public PlayerViewAsVec(final BlockBreakEvent event)
    {
        this(event.getPlayer().getLocation().getDirection());
    }

    @NonNull private final org.bukkit.util.Vector vec;

    @Override
    public double x()
    {
        return vec.getX();
    }

    @Override
    public double y()
    {
        return vec.getY();
    }

    @Override
    public double z()
    {
        return vec.getZ();
    }
}

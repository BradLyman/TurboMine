package net.projecttetra.minecraft.spigot;

import java.util.Comparator;
import net.projecttetra.minecraft.Block;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.World;

public final class BlockHasSameType implements Comparator<Block>
{
    private World world;

    public void setWorld(final World world) {
        this.world = world;
    }

    @Override
    public int compare(final Block lhs, final Block rhs)
    {
        final Material m1 =
            new Location(
                world,
                lhs.location().x(),
                lhs.location().y(),
                lhs.location().z()
            ).getBlock().getType();
        final Material m2 =
            new Location(
                world,
                rhs.location().x(),
                rhs.location().y(),
                rhs.location().z()
            ).getBlock().getType();
        return m1.compareTo(m2);
    }
}

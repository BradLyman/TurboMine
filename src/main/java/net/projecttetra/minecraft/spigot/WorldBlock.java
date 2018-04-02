package net.projecttetra.minecraft.spigot;

import java.util.Optional;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import lombok.Value;
import net.projecttetra.minecraft.Block;
import net.projecttetra.minecraft.linalg.Vector;
import org.bukkit.World;
import org.bukkit.inventory.ItemStack;

/**
 * Objects of this class represent a block with coordinates relative to the
 * minecraft world.
 */
@Value
@RequiredArgsConstructor
public class WorldBlock implements Block {

    @NonNull World world;
    @NonNull org.bukkit.block.Block nmsBlock;
    @NonNull Optional<ItemStack> breakWith;

    @Override
    public void breakThis() {
        if (breakWith.isPresent()) {
            System.out.println("break block with tool");
            nmsBlock.breakNaturally(breakWith.get());
        }
        else {
            nmsBlock.breakNaturally();
        }
    }

    @Override
    public Block offset(final Vector vector) {
        return new WorldBlock(
            world,
            nmsBlock
                .getLocation()
                .add(vector.x(), vector.y(), vector.z())
                .getBlock(),
            breakWith
        );
    }

    @Override
    public Vector location() {
        return new NMSBlockAsVector(nmsBlock);
    }
}

@Value
class NMSBlockAsVector implements Vector
{
    @NonNull org.bukkit.block.Block nmsBlock;

    @Override
    public double x() {
        return nmsBlock.getX();
    }

    @Override
    public double y() {
        return nmsBlock.getY();
    }

    @Override
    public double z() {
        return nmsBlock.getZ();
    }

}

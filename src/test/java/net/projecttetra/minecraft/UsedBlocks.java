package net.projecttetra.minecraft;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import net.projecttetra.minecraft.linalg.Vector;

/**
 * Objects of this class represent all of the blockes accessed using a single
 * origin block.
 */
public final class UsedBlocks implements Block, Iterable<Block>
{
    /**
     * The decorated block.
     */
    private final Block block;

    /**
     * Identify blocks by the const representation of their position.
     * Using Vector.Const grants control over the hash function and prevents
     * accidental duplicate block entries.
     */
    private final Map<Vector.Const, Block> used;

    public UsedBlocks(final Block block)
    {
        this(
            block,
            new HashMap<>()
        );
    }

    private UsedBlocks(
            final Block block,
            final Map<Vector.Const, Block> blocks)
    {
        this.block = block;
        this.used = blocks;
        this.used.put(
            new Vector.Const(block.location()),
            block
        );
    }

    @Override
    public Iterator<Block> iterator()
    {
        return used.values().iterator();
    }

    @Override
    public void breakThis()
    {
        block.breakThis();
    }

    @Override
    public Block offset(Vector vector)
    {
        return new UsedBlocks(
            block.offset(vector),
            used
        );
    }

    @Override
    public Vector location()
    {
        return block.location();
    }
}

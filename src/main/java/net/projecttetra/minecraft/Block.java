package net.projecttetra.minecraft;

import net.projecttetra.minecraft.linalg.Vector;

/**
 * Objects of this type represent a block in a minecraft world.
 */
public interface Block
{
    /**
     * Break the block.
     */
    void breakThis();

    /**
     * Retrieve a block who's position is offset from this block.
     */
    Block offset(final Vector vector);

    /**
     * The blocks location.
     */
    Vector location();
}

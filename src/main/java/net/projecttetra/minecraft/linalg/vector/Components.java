package net.projecttetra.minecraft.linalg.vector;

import net.projecttetra.minecraft.linalg.Vector;

/**
 * Objects of this type represent the axis-aligned vectors which can be summed
 * to describe a single directional vector.
 */
public interface Components
{
    Vector[] aligned();
}

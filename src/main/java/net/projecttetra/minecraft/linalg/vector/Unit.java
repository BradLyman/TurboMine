package net.projecttetra.minecraft.linalg.vector;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import net.projecttetra.minecraft.linalg.Vector;

/**
 * Objects of this class represent a vector with unit length.
 */
@AllArgsConstructor(access = AccessLevel.PRIVATE)
public final class Unit implements Vector
{
    private final double length;
    private final Vector vector;

    public Unit(final Vector v)
    {
        this(
            Math.sqrt(v.x()*v.x() + v.y()*v.y() + v.z()*v.z()),
            v
        );
    }

    @Override
    public double x()
    {
        return vector.x() / length;
    }

    @Override
    public double y()
    {
        return vector.y() / length;
    }

    @Override
    public double z()
    {
        return vector.z() / length;
    }
}

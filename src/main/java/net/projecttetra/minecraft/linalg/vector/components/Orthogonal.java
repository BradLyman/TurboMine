package net.projecttetra.minecraft.linalg.vector.components;

import lombok.AllArgsConstructor;
import lombok.NonNull;
import net.projecttetra.minecraft.linalg.Vector;
import net.projecttetra.minecraft.linalg.vector.Components;

/**
 * Objects of this class represent the decomposition of a vector by three
 * orthogonal projections.
 */
@AllArgsConstructor
public final class Orthogonal implements Components
{
    @NonNull private final Vector vector;

    @Override
    public Vector[] aligned()
    {
        return new Vector[]
        {
            new Vector.Const(vector.x(), 0.0, 0.0),
            new Vector.Const(0.0, vector.y(), 0.0),
            new Vector.Const(0.0, 0.0, vector.z())
        };
    }
}

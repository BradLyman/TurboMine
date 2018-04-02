package net.projecttetra.minecraft.linalg.vector.components;

import lombok.AllArgsConstructor;
import lombok.NonNull;
import net.projecttetra.minecraft.linalg.Vector;
import net.projecttetra.minecraft.linalg.vector.Components;
import net.projecttetra.minecraft.linalg.vector.Unit;

/**
 * Objects of this class represent the components of a vector which have been
 * normalized to unit length.
 */
@AllArgsConstructor
public class Normalized implements Components
{
    @NonNull private final Components raw;

    @Override
    public Vector[] aligned()
    {
        return aligned(raw.aligned());
    }

    private Vector[] aligned(final Vector[] unnormalized)
    {
        return new Vector[]
        {
            new Unit(unnormalized[0]),
            new Unit(unnormalized[1]),
            new Unit(unnormalized[2])
        };
    }
}

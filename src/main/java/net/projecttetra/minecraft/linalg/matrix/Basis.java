package net.projecttetra.minecraft.linalg.matrix;

import lombok.AllArgsConstructor;
import lombok.NonNull;
import lombok.Value;
import net.projecttetra.minecraft.linalg.Matrix;
import net.projecttetra.minecraft.linalg.Vector;

/**
 * Objects of this class represent a change-of-basis for a vector space.
 */
@Value
@AllArgsConstructor
public class Basis implements Matrix
{
    @NonNull Vector i;
    @NonNull Vector j;
    @NonNull Vector k;

    @Override
    public Vector transform(final Vector v)
    {
        return new Vector.Const(
            i.x()*v.x() + j.x()*v.y() + k.x()*v.z(),
            i.y()*v.x() + j.y()*v.y() + k.y()*v.z(),
            i.z()*v.x() + j.z()*v.y() + k.z()*v.z()
        );
    }
}

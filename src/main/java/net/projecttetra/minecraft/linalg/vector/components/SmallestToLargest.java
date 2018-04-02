package net.projecttetra.minecraft.linalg.vector.components;

import java.util.Arrays;
import java.util.Comparator;
import lombok.AllArgsConstructor;
import lombok.NonNull;
import net.projecttetra.minecraft.linalg.Vector;
import net.projecttetra.minecraft.linalg.vector.Components;

/**
 * Objects of this class represent a vector's components ordered from
 * largest to smallest.
 */
@AllArgsConstructor
public class SmallestToLargest implements Components
{
    @NonNull private final Components comps;

    @Override
    public Vector[] aligned()
    {
        final Vector[] unsorted = comps.aligned();
        Arrays.sort(unsorted, new SmallestFirst());
        return unsorted;
    }

    static class SmallestFirst implements Comparator<Vector>
    {
        /**
         * -1 means |lhs| < |rhs|
         *  0 means |lhs| = |rhs|
         *  1 means |lhs| > |rhs|
         */
        @Override
        public int compare(final Vector lhs, final Vector rhs)
        {
            return Double.compare(norm(lhs), norm(rhs));
        }

        private double norm(final Vector v)
        {
            return Math.sqrt(v.x()*v.x() + v.y()*v.y() + v.z()*v.z());
        }
    }
}

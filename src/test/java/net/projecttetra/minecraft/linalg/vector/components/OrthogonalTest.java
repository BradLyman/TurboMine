package net.projecttetra.minecraft.linalg.vector.components;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.hasItemInArray;

import net.projecttetra.minecraft.linalg.Vector;
import net.projecttetra.minecraft.linalg.vector.VectorMatches;

import org.junit.Test;

public class OrthogonalTest
{
    @Test
    public void vector_should_decompose_into_axis_projections()
    {
        final Vector vec = new Vector.Const(0.03, 1237.0, -1389076);
        assertThat(
            "X component should be present",
            new Orthogonal(vec).aligned(),
            hasItemInArray(VectorMatches.value(vec.x(), 0.0, 0.0))
        );
        assertThat(
            "Y component should be present",
            new Orthogonal(vec).aligned(),
            hasItemInArray(VectorMatches.value(0.0, vec.y(), 0.0))
        );
        assertThat(
            "Z component should be present",
            new Orthogonal(vec).aligned(),
            hasItemInArray(VectorMatches.value(0.0, 0.0, vec.z()))
        );
    }
}

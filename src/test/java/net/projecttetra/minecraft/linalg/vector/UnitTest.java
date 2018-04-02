package net.projecttetra.minecraft.linalg.vector;

import static org.hamcrest.MatcherAssert.assertThat;

import net.projecttetra.minecraft.linalg.Vector;
import org.junit.Test;

public class UnitTest
{
    @Test
    public void axis_aligned_units_should_be_exact()
    {
        assertThat(
            "X axis",
            new Unit(new Vector.Const(3.1393, 0.0, 0.0)),
            VectorMatches.value(1.0, 0.0, 0.0)
        );
        assertThat(
            "Y axis",
            new Unit(new Vector.Const(0.0, 37.98347, 0.0)),
            VectorMatches.value(0.0, 1.0, 0.0)
        );
        assertThat(
            "Z axis",
            new Unit(new Vector.Const(0.0, 0.0, 0.3902547)),
            VectorMatches.value(0.0, 0.0, 1.0)
        );
    }

    @Test
    public void arbitrary_vector_should_get_normalized()
    {
        final double x = -0.093547908;
        final double y = 9438.587;
        final double z = -5897.11245;
        final double len = Math.sqrt(x*x + y*y + z*z);

        final Vector normalized = new Unit(new Vector.Const(x, y, z));
        assertThat(
            normalized,
            VectorMatches.value(x/len, y/len, z/len)
        );
    }
}

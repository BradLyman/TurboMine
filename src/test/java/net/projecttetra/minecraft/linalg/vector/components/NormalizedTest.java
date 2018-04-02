package net.projecttetra.minecraft.linalg.vector.components;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.hasItemInArray;
import static org.hamcrest.Matchers.allOf;

import net.projecttetra.minecraft.linalg.Vector;
import net.projecttetra.minecraft.linalg.vector.Unit;
import net.projecttetra.minecraft.linalg.vector.VectorMatches;

import org.junit.Test;

public class NormalizedTest
{
    @Test
    public void vectors_should_be_normalized()
    {
        final Vector a = new Vector.Const(0.324, -10934, 347.34);
        final Vector b = new Vector.Const(548095, -0.31254, 9757.0098);
        final Vector c = new Vector.Const(-213.0, 3245, 542);

        assertThat(
            new Normalized(
                new ListedComponents(new Vector[] {a, b, c})
            ).aligned(),
            allOf(
                hasItemInArray(VectorMatches.value(new Unit(a))),
                hasItemInArray(VectorMatches.value(new Unit(b))),
                hasItemInArray(VectorMatches.value(new Unit(c)))
            )
        );
    }
}

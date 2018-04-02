package net.projecttetra.minecraft.linalg.vector;

import static org.hamcrest.MatcherAssert.assertThat;

import org.junit.Test;

import net.projecttetra.minecraft.linalg.Vector;

public class SumTest
{
    @Test
    public void values_should_be_summed()
    {
        assertThat(
            new Sum(
                new Vector.Const(1.0, 2.0, 3.0),
                new Vector.Const(10.0, 12.0, 32.0)
            ),
            VectorMatches.value(11.0, 14.0, 35.0)
        );
    }
}

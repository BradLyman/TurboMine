package net.projecttetra.minecraft.linalg.vector.components;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;
import static org.hamcrest.Matchers.equalTo;

import net.projecttetra.minecraft.linalg.Vector;
import org.junit.Test;

public final class SmallestToLargestTest
{
    @Test
    public void components_should_be_in_the_correct_order()
    {
        final Vector largest = new Vector.Const(100, -932, 0.3452);
        final Vector middle = new Vector.Const(50, 50, -50);
        final Vector smallest = new Vector.Const(0.0, 0.0, -0.123);
        assertThat(
            new SmallestToLargest(
                new ListedComponents(new Vector[]{middle, smallest, largest})
            ).aligned(),
            is(equalTo(new Vector[] {smallest, middle, largest}))
        );
    }
}


package net.projecttetra.minecraft;

import static org.hamcrest.MatcherAssert.assertThat;

import org.junit.Test;

import net.projecttetra.minecraft.linalg.Vector;
import net.projecttetra.minecraft.linalg.vector.VectorMatches;

public final class ViewSpaceBlockTest
{
    @Test
    public void positive_z_should_always_point_with_look_vector()
    {
        final Vector look = new Vector.Const(-0.001, 1.0, 0.01);
        assertThat(
            new ViewSpaceBlock(new InMemoryBlock(), look)
                .offset(new Vector.Const(0.0, 0.0, 1.0))
                .location(),
            VectorMatches.value(0.0, 1.0, 0.0)
        );
    }

    @Test
    public void largest_component_should_snap_to_z_axis()
    {
        final Vector look = new Vector.Const(0.9, 0.3, -0.2);
        assertThat(
            new ViewSpaceBlock(new InMemoryBlock(), look)
                .offset(new Vector.Const(0.0, 0.0, 1.0))
                .location(),
            VectorMatches.value(1.0, 0.0, 0.0)
        );
    }

    @Test
    public void smallest_component_should_snap_to_x_axis()
    {
        final Vector look = new Vector.Const(0.1, -0.8, 0.01);
        assertThat(
            new ViewSpaceBlock(new InMemoryBlock(), look)
                .offset(new Vector.Const(1.0, 0.0, 0.0))
                .location(),
            VectorMatches.value(0.0, 0.0, 1.0)
        );
    }
}

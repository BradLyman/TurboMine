package net.projecttetra.minecraft;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;
import static org.hamcrest.Matchers.iterableWithSize;

import org.junit.Test;

public class SquareVolumeTest {

    @Test
    public void should_break_the_square_of_the_radius_1() {
        assertBrokenInRadius(1);
    }

    @Test
    public void should_break_the_square_of_the_radius_2() {
        assertBrokenInRadius(2);
    }

    @Test
    public void should_break_the_square_of_the_radius_3() {
        assertBrokenInRadius(3);
    }

    @Test
    public void should_break_the_square_of_the_radius_4() {
        assertBrokenInRadius(4);
    }

    private void assertBrokenInRadius(final int radius)
    {
        final UsedBlocks blocks = new UsedBlocks(new InMemoryBlock());
        new SquareVolume(radius).breakAllAt(blocks);

        final int sideLength = radius*2 + 1;
        final int area = sideLength * sideLength;
        assertThat(
            area + " blocks should be broken when radius is " + radius,
            blocks,
            is(iterableWithSize(area))
        );
    }
}

package net.projecttetra.minecraft.linalg.vector;

import lombok.AllArgsConstructor;
import lombok.NonNull;
import net.projecttetra.minecraft.linalg.Vector;
import org.hamcrest.Description;
import org.hamcrest.TypeSafeDiagnosingMatcher;

/**
 * Objects of this class are responsible for verifying that two vectors
 * match echother to within a reasonable tolerance.
 */
@AllArgsConstructor
public final class VectorMatches extends TypeSafeDiagnosingMatcher<Vector>
{
    @NonNull private final Vector.Const vector;

    public static VectorMatches value(
        final double x,
        final double y,
        final double z)
    {
        return new VectorMatches(new Vector.Const(x, y, z));
    }

    public static VectorMatches value(final Vector vector)
    {
        return new VectorMatches(vector);
    }

    public VectorMatches(final Vector vector)
    {
        this(new Vector.Const(vector));
    }

    @Override
    public void describeTo(final Description description)
    {
        description
            .appendText("a vector ")
            .appendValue(vector);
    }

    @Override
    protected boolean matchesSafely(
            final Vector item,
            final Description mismatchDescription)
    {
        final Vector.Const constItem = new Vector.Const(item);
        mismatchDescription
            .appendText("got actual value ")
            .appendValue(constItem)
            .appendText(". ");

        if (!smartEquals(vector.x(), item.x()))
        {
            mismatchDescription
                .appendText("X component off by [")
                .appendValue(absoluteDifference(vector.x(), item.x()))
                .appendText("]");
            return false;
        }
        if (!smartEquals(vector.y(), item.y()))
        {
            mismatchDescription
                .appendText("Y component off by [")
                .appendValue(absoluteDifference(vector.y(), item.y()))
                .appendText("]");
            return false;
        }
        if (!smartEquals(vector.z(), item.z()))
        {
            mismatchDescription
                .appendText("Z component off by [")
                .appendValue(absoluteDifference(vector.z(), item.z()))
                .appendText("]");
            return false;
        }
        return true;
    }

    private double absoluteDifference(final double a, final double b)
    {
        return Math.abs(Math.abs(a) - Math.abs(b));
    }

    /**
     * Intelligently compare double values for equality.
     */
    private boolean smartEquals(final double lhs, final double rhs)
    {
        final double a = Math.abs(lhs);
        final double b = Math.abs(rhs);
        final double diff = Math.abs(a - b);

        if (a == b)
        {
            return true;
        }
        else if (a == 0 || b == 0 || diff < Double.MIN_NORMAL)
        {
            return absoluteCompare(diff);
        }
        else
        {
            return relativeCompare(a, b, diff);
        }
    }

    /**
     * Returns true if the difference is less than the machine epsilon
     * measured at 1.0. This is only a useful comparison tool if diff is
     * very small.
     */
    private boolean absoluteCompare(final double diff) {
        return diff < Math.ulp(1.0);
    }

    /**
     * Computes the relative difference with the requirement that the relative
     * difference is less than the machine epsilon computed at 1.0.
     * This is an effective measurement technique for larger values.
     */
    private boolean relativeCompare(
            final double a,
            final double b,
            final double diff)
    {
        final double relative = diff / Math.min((a + b), Double.MAX_VALUE);
        return relative < Math.ulp(1.0);
    }
}

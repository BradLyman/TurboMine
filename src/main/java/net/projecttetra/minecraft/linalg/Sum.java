package net.projecttetra.minecraft.linalg;

/**
 * Objects of this class represent the sum of two vectors.
 */
public final class Sum implements Vector
{
    private final Vector a;
    private final Vector b;

    public Sum(final Vector a, final Vector b)
    {
        this.a = a;
        this.b = b;
    }

    @Override
    public double x() {
        return a.x() + b.x();
    }

    @Override
    public double y() {
        return a.y() + b.y();
    }

    @Override
    public double z() {
        return a.z() + b.z();
    }
}

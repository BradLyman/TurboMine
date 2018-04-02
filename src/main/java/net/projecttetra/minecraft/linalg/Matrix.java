package net.projecttetra.minecraft.linalg;

/**
 * An object of this class represents a linear transformation of a vector.
 */
public interface Matrix
{
    Vector transform(final Vector vector);
}

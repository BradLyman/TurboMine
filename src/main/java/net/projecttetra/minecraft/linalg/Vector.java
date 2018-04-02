package net.projecttetra.minecraft.linalg;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Value;

/**
 * Objects of this type represent a 3-dimensional vector.
 */
public interface Vector {

    double x();
    double y();
    double z();

    /**
     * Objects of this class represent a constant valued vector.
     */
    @Value
    @Getter(AccessLevel.NONE)
    @RequiredArgsConstructor
    public final class Const implements Vector {

        double x;
        double y;
        double z;

        @Override
        public double x() { return x; }

        @Override
        public double y() { return y; }

        @Override
        public double z() { return z; }
    }
}

package net.projecttetra.minecraft;

import net.projecttetra.minecraft.linalg.Vector;

/**
 * Objects of this class represent a volume of blocks arranged in a solid
 * square.
 */
public class SquareVolume implements Tool.Volume {

    private final int radius;

    public SquareVolume()
    {
        this(1);
    }

    public SquareVolume(int radius)
    {
        this.radius = radius;
    }

    @Override
    public void breakAllAt(Block block) {
        for (int x = -radius; x <= radius; x++) {
            for (int y = -radius; y <= radius; y++) {
                block.offset(new Vector.Const(x, y, 0.0)).breakThis();
            }
        }
    }
}

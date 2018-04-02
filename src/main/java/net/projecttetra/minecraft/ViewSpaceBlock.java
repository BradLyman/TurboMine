package net.projecttetra.minecraft;

import lombok.AllArgsConstructor;
import lombok.NonNull;
import net.projecttetra.minecraft.linalg.Vector;
import net.projecttetra.minecraft.linalg.matrix.Basis;
import net.projecttetra.minecraft.linalg.vector.components.Normalized;
import net.projecttetra.minecraft.linalg.vector.components.Orthogonal;
import net.projecttetra.minecraft.linalg.vector.components.SmallestToLargest;

/**
 * Objects of this type represent a block with coordinate system relative
 * to the direction the player is looking.
 */
@AllArgsConstructor
public final class ViewSpaceBlock implements Block
{
    @NonNull final Block worldBlock;
    @NonNull final Basis viewBasis;

    public ViewSpaceBlock(
        final Block worldBlock,
        final Vector lookDirection)
    {
        this(
            worldBlock,
            new Basis(
                new Normalized(
                    new SmallestToLargest(
                        new Orthogonal(lookDirection)
                    )
                )
            )
        );
    }

    @Override
    public void breakThis() {
        worldBlock.breakThis();
    }

    @Override
    public Block offset(final Vector vector) {
        return worldBlock.offset(
            viewBasis.transform(vector)
        );
    }

    @Override
    public Vector location() {
        return worldBlock.location();
    }
}

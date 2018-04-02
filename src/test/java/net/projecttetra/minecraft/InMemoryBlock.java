package net.projecttetra.minecraft;

import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import lombok.Value;
import net.projecttetra.minecraft.linalg.Vector;
import net.projecttetra.minecraft.linalg.Sum;

/**
 * Objects of this class represent a block which has all metadata stored in an
 * in-memory document.
 */
@Value
@RequiredArgsConstructor
class InMemoryBlock implements Block
{
    static class Document
    {
        boolean broken = false;
    }

    @NonNull Vector location;
    @NonNull Document document = new Document();

    public InMemoryBlock()
    {
        this(new Vector.Const(0, 0, 0));
    }

    @Override
    public Block offset(final Vector vector)
    {
        return new InMemoryBlock(new Sum(location, vector));
    }

    @Override
    public Vector location()
    {
        return location;
    }

    @Override
    public void breakThis()
    {
        document.broken = true;
    }

    public boolean broken()
    {
        return document.broken;
    }
}

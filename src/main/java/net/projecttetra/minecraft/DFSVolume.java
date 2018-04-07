package net.projecttetra.minecraft;

import java.util.Arrays;
import java.util.Comparator;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.Stack;
import java.util.stream.Collectors;

import lombok.AllArgsConstructor;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import net.projecttetra.minecraft.linalg.Vector;

@AllArgsConstructor
public final class DFSVolume implements Tool.Volume
{
    private final Comparator<Block> similarBlocks;

    @Override
    public void breakAllAt(final Block block)
    {
        final Set<HashedBlock> toBreak = new HashSet<>();
        final Set<HashedBlock> observed = new HashSet<>();
        final Stack<HashedBlock> stack = new Stack<>();

        toBreak.add(new HashedBlock(block));
        stack.push(new HashedBlock(block));

        while (
            !stack.isEmpty() &&
            toBreak.size() < 64 &&
            observed.size() < 1500
        ) {
            final HashedBlock activeBlock = stack.pop();
            System.out.println(
                "check blocks around: " +
                new Vector.Const(activeBlock.location())
            );
            final Iterable<Block> blocks = new AdjacentBlocks(activeBlock);
            for (final Block nearby : blocks)
            {
                final HashedBlock next = new HashedBlock(nearby);
                if (toBreak.contains(next) || observed.contains(next)) {
                    continue;
                }

                if (similarBlocks.compare(activeBlock, nearby) == 0)
                {
                    toBreak.add(next);
                    stack.push(next);
                }
                else
                {
                    observed.add(next);
                }
            }
        }
        System.out.println(
            "checked " + (toBreak.size() + observed.size()) + " blocks"
        );
        System.out.println("break " + toBreak.size() + " blocks");
        toBreak.forEach(Block::breakThis);

        System.out.println(
            toBreak.stream()
                .map((b) -> {
                    final Vector v = new Vector.Const(b.location());
                    return v.toString() +
                        " | v" + v.hashCode() +
                        " | b" + b.hashCode();
                })
                .collect(Collectors.joining("\n", "[", "]"))
        );
    }
}

@AllArgsConstructor
class HashedBlock implements Block
{
    final @NonNull Block block;

    @Override
    public void breakThis() {
        block.breakThis();
    }

    @Override
    public Block offset(final Vector vector) {
        return block.offset(vector);
    }

    @Override
    public Vector location() {
        return block.location();
    }

    @Override
    public int hashCode() {
        return new Vector.Const(block.location()).hashCode();
    }

    @Override
    public boolean equals(final Object o)
    {
        if (o instanceof HashedBlock)
        {
            final HashedBlock b = (HashedBlock)o;
            return b.hashCode() == hashCode();
        }
        else
        {
            return false;
        }
    }
}

@RequiredArgsConstructor
class AdjacentBlocks implements Iterable<Block>
{
    static final List<Vector> offsets =
        Arrays.asList(
            new Vector.Const(1.0, 1.0, 1.0),
            new Vector.Const(1.0, 1.0, 0.0),
            new Vector.Const(1.0, 1.0, -1.0),

            new Vector.Const(1.0, 0.0, 1.0),
            new Vector.Const(1.0, 0.0, 0.0),
            new Vector.Const(1.0, 0.0, -1.0),

            new Vector.Const(1.0, -1.0, 1.0),
            new Vector.Const(1.0, -1.0, 0.0),
            new Vector.Const(1.0, -1.0, -1.0),


            new Vector.Const(0.0, 1.0, 1.0),
            new Vector.Const(0.0, 1.0, 0.0),
            new Vector.Const(0.0, 1.0, -1.0),

            new Vector.Const(0.0, 0.0, 1.0),
            // new Vector.Const(0.0, 0.0, 0.0),
            new Vector.Const(0.0, 0.0, -1.0),

            new Vector.Const(0.0, -1.0, 1.0),
            new Vector.Const(0.0, -1.0, 0.0),
            new Vector.Const(0.0, -1.0, -1.0),


            new Vector.Const(-1.0, 1.0, 1.0),
            new Vector.Const(-1.0, 1.0, 0.0),
            new Vector.Const(-1.0, 1.0, -1.0),

            new Vector.Const(-1.0, 0.0, 1.0),
            new Vector.Const(-1.0, 0.0, 0.0),
            new Vector.Const(-1.0, 0.0, -1.0),

            new Vector.Const(-1.0, -1.0, 1.0),
            new Vector.Const(-1.0, -1.0, 0.0),
            new Vector.Const(-1.0, -1.0, -1.0)
        );

    private final @NonNull Block block;

    @Override
    public Iterator<Block> iterator()
    {
        return new Iterator<Block>()
        {
            private final Iterator<Vector> offset = offsets.iterator();

            @Override
            public boolean hasNext() {
                return offset.hasNext();
            }

            @Override
            public Block next() {
                return block.offset(offset.next());
            }
        };
    }
}

package net.projecttetra.minecraft;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;

import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import lombok.Value;
import net.projecttetra.minecraft.linalg.Vector;
import org.junit.Test;

public class ToolTest
{
    @Test
    public void tool_should_be_applied_when_name_matches() {
        final FakeBlock block = new FakeBlock();
        new Tool("drill", new Original())
            .breakBlocksWith(block, new StaticName("drill"));

        assertThat(block.broken(), is(true));
    }

    @Test
    public void tool_should_not_be_applied_when_names_dont_match() {
        final FakeBlock block = new FakeBlock();
        new Tool("drill", new Original())
            .breakBlocksWith(block, new StaticName("aoeu"));

        assertThat(block.broken(), is(false));
    }
}

@RequiredArgsConstructor
class StaticName implements Tool.Name
{
    @NonNull private final String name;

    @Override
    public String display()
    {
        return name;
    }
}

class Original implements Tool.Volume
{
    @Override
    public void breakAllAt(final Block block)
    {
        block.breakThis();
    }
}

@Value
@RequiredArgsConstructor
class FakeBlock implements Block
{
    static class InMemory
    {
        boolean broken = false;
    }

    @NonNull Vector location;
    @NonNull InMemory inMemory = new InMemory();

    public FakeBlock()
    {
        this(new Vector.Const(0, 0, 0));
    }

    @Override
    public Block offset(final Vector vector)
    {
        return new FakeBlock();
    }

    @Override
    public Vector location()
    {
        return location;
    }

    @Override
    public void breakThis()
    {
        inMemory.broken = true;
    }

    public boolean broken()
    {
        return this.inMemory.broken;
    }
}

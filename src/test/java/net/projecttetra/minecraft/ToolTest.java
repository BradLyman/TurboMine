package net.projecttetra.minecraft;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;

import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import org.junit.Test;

public class ToolTest
{
    @Test
    public void tool_should_be_applied_when_name_matches() {
        final InMemoryBlock block = new InMemoryBlock();
        new Tool("drill", new Original())
            .breakBlocksWith(block, new StaticName("drill"));

        assertThat(block.broken(), is(true));
    }

    @Test
    public void tool_should_not_be_applied_when_names_dont_match() {
        final InMemoryBlock block = new InMemoryBlock();
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


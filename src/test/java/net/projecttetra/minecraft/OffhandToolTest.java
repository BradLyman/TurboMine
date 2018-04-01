package net.projecttetra.minecraft;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;

import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import org.junit.Test;

public class OffhandToolTest
{
    @Test
    public void tool_should_be_applied_when_name_matches() {
        final SimpleTool tool = new SimpleTool();
        new OffhandTool("drill", tool).breakBlock(new StaticName("drill"));

        assertThat(tool.applied(), is(true));
    }

    @Test
    public void tool_should_not_be_applied_when_names_dont_match() {
        final SimpleTool tool = new SimpleTool();
        new OffhandTool("drill", tool).breakBlock(new StaticName("aoeu"));

        assertThat(tool.applied(), is(false));
    }
}

@RequiredArgsConstructor
class StaticName implements OffhandTool.Name {

    @NonNull private final String name;

    @Override
    public String display() {
        return name;
    }
}

class SimpleTool implements Runnable {

    private boolean applied = false;

    @Override
    public void run() {
        this.applied = true;
    }

    public boolean applied() {
        return applied;
    }
}

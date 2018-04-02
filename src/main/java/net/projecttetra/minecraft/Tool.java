package net.projecttetra.minecraft;

import lombok.NonNull;
import lombok.Value;

/**
 * Objects of this class represent a tool which activates based on the actual
 * name of an item.
 */
@Value
public final class Tool {

    public interface Name {
        String display();
    }

    public interface Volume {
        void breakAllAt(final Block block);
    }

    @NonNull String expected;
    @NonNull Volume volume;

    /**
     * Break a block using a named item.
     */
    public void breakBlocksWith(final Block block, final Name actual) {
        if (expected.equals(actual.display())) {
            volume.breakAllAt(block);
        }
    }
}

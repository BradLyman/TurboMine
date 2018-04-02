package net.projecttetra.minecraft;

import lombok.NonNull;
import lombok.Value;

/**
 * Objects of this class represent a tool which activates based on the item
 * in the player's offhand.
 */
@Value
public final class Tool {

    public interface Name {
        String display();
    }

    @NonNull String expected;
    @NonNull Runnable behavior;

    public void breakBlock(final Name actual) {
        if (expected.equals(actual.display())) {
            behavior.run();
        }
    }
}

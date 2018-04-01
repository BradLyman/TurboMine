package net.projecttetra.minecraft;

import lombok.NonNull;
import lombok.Value;

/**
 * Objects of this class represent a tool which activates based on the item
 * in the player's offhand.
 */
@Value
public final class OffhandTool {

    public interface Name {
        String display();
    }

    @NonNull String expected;
    @NonNull Runnable tool;

    public void breakBlock(final Name offhand) {
        if (expected.equals(offhand.display())) {
            tool.run();
        }
    }
}

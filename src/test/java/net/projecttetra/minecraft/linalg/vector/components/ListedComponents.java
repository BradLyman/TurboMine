package net.projecttetra.minecraft.linalg.vector.components;

import lombok.AllArgsConstructor;
import lombok.NonNull;
import net.projecttetra.minecraft.linalg.Vector;
import net.projecttetra.minecraft.linalg.vector.Components;

@AllArgsConstructor
public class ListedComponents implements Components
{
    @NonNull private final Vector[] components;

    @Override
    public Vector[] aligned()
    {
        return components;
    }
}

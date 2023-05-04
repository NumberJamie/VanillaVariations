package net.nrjam.vavs.item.custom;

import com.google.common.collect.Sets;
import net.minecraftforge.common.ToolAction;

import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class ModToolActions
{
    public static final ToolAction SALT_OXIDIZE = ToolAction.get("salt_oxidize");

    public static final Set<ToolAction> DEFAULT_SALT_ACTIONS = of(SALT_OXIDIZE);

    private static Set<ToolAction> of(ToolAction... actions) {
        return Stream.of(actions).collect(Collectors.toCollection(Sets::newIdentityHashSet));
    }
}

package com.ivenhov.permcheck;

import java.util.EnumSet;

/**
 *
 * @author daniel
 */
public class PermissionNameSet {

    private final EnumSet<PermissionName> set;

    private PermissionNameSet(EnumSet<PermissionName> set) {
        this.set = set;
    }

    public static PermissionNameSet with(PermissionName... add) {
        EnumSet<PermissionName> set = newSetWith(null, add);
        PermissionNameSet newset = new PermissionNameSet(set);
        return newset;
    }

    public static PermissionNameSet from(PermissionNameSet existing, PermissionName toAdd) {
        EnumSet<PermissionName> pns;
        if (existing == null) {
            pns = newSetWith(null, toAdd);
        } else {
            pns = newSetWith(existing.set, toAdd);
        }
        PermissionNameSet newset = new PermissionNameSet(pns);
        return newset;
    }

    private static EnumSet<PermissionName> newSetWith(EnumSet<PermissionName> set, PermissionName... toAdd) {
        if (set == null && (toAdd == null || toAdd.length == 0))
            return EnumSet.noneOf(PermissionName.class);
        if (set == null)
            return EnumSet.of(toAdd[0], toAdd);
        if (toAdd == null || toAdd.length == 0)
            return set;
        EnumSet<PermissionName> pns = EnumSet.copyOf(set);
        for (PermissionName pn : toAdd) {
            pns.add(pn);
        }
        return pns;
    }
}

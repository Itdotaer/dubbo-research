package com.itdotaer.basiclearn.collections;

import java.util.HashSet;
import java.util.Set;

/**
 * TreeStooges
 *
 * @author jt_hu
 * @date 2018/11/21
 */
public final class TreeStooges {

    private final Set<String> stooges = new HashSet<>();

    public TreeStooges() {
        stooges.add("a");
        stooges.add("b");
        stooges.add("c");
    }

    public boolean contains(String stooge) {
        return stooges.contains(stooge);
    }

}

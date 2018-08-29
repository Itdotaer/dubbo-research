package com.itdotaer.basiclean.collections;

import java.util.HashMap;
import java.util.LinkedHashMap;

/**
 * LinkedHashMapTest
 *
 * @author jt_hu
 * @date 2018/7/19
 */
public class LinkedHashMapTest {

    public static void main(String[] args) {
        HashMap<Long, String> map = new LinkedHashMap<Long, String>();

        map.put(1L, "hello");
        map.put(2L, "world");

        map.get(1L);
        map.get(2L);
    }

}

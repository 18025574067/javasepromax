package com.itheima.d1_collection_set;

import java.util.LinkedHashSet;
import java.util.Set;

public class SetDemo4 {
    public static void main(String[] args) {
        // 看看Set系列集合的特点：HashSet LinkedHashSet TreeSet

        Set<String> sets = new LinkedHashSet<>(); // 有序，不重复，无索引。

        sets.add("Java");
        sets.add("Java");
        sets.add("MySQL");
        sets.add("MySQL");
        sets.add("SpringBoot");
        sets.add("SpringBoot");
        sets.add("HTML");
        sets.add("HTML");

        System.out.println(sets);

    }
}
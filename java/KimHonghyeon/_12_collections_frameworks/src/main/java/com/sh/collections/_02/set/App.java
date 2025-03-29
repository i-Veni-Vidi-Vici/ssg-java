package com.sh.collections._02.set;

import java.util.Collection;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

public class App {
    public static void main(String[] args) {
        HashSet<Integer> set1 = new HashSet<>();
        Set<Integer> set2 = new HashSet<>();
        Collection set3 = new HashSet<>();

        HashSet<String> set = new HashSet<>();
        System.out.println(set.add("java"));
        System.out.println(set.add("java"));
        System.out.println(set.add("java"));
        System.out.println(set);
        set.clear();
        System.out.println(set);
    }
}

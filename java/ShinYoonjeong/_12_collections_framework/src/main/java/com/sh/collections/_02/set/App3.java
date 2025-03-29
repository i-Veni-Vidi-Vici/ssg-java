package com.sh.collections._02.set;

import java.util.*;

/**
 * set <----> List
 * 1. Set -> List 중복을 제거하고 싶을때
 * 2. List -> Set
 */
public class App3 {
    public static void main(String[] args) {
        Set<String> set = new HashSet<>();
        set.add("홍길동");
        set.add("신사임당");
        set.add("강감찬");
        System.out.println(set);

        List<String> list = new ArrayList<>(set);
        Collections.sort(list);
        System.out.println(list);
    }
}

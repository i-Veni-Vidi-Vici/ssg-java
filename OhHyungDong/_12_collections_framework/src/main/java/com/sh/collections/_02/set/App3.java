package com.sh.collections._02.set;

import java.util.*;

/**
 * Set <---> List
 * 1. Set -> List : 순서 / 정렬 기능이 필요할 때
 * 2. List -> Set : 중복을 제거 하고싶을 때
 */
public class App3 {
    public static void main(String[] args) {
        Set<String> set = new HashSet<>();
        set.add("홍길동");
        set.add("신사임당");
        set.add("강감찬");
        System.out.println(set);

        // set -> List
        List<String> list = new ArrayList<>((set));
        Collections.sort(list);
        System.out.println(list);

        list.add("홍길동");
        list.add("신사임당");
        list.add("홍길동");
        System.out.println(list);

        Set<String> set2 = new HashSet<>(list);
        System.out.println(set2);
    }
}

package com.sh.collections._02.set;

import java.util.*;

/**
 * <pre>
 * Set <---> List
 * 1. Set -> List : 순서/정렬 기능이 필요할때
 * 2. List -> Set : 중복을 제거하고 싶을때
 * </pre>
 */
public class App3 {
    public static void main(String[] args) {
        Set<String> set = new HashSet<>();
        set.add("홍길동");
        set.add("신사임당");
        set.add("강감찬");
        System.out.println(set); // [신사임당, 홍길동, 강감찬]

        // Set -> List
        List<String> list = new ArrayList<>(set);
        Collections.sort(list);
        System.out.println(list); // [강감찬, 신사임당, 홍길동]

        list.add("홍길동");
        list.add("신사임당");
        list.add("강감찬");
        System.out.println(list); // [강감찬, 신사임당, 홍길동, 홍길동, 신사임당, 강감찬]

        // List -> Set
        Set<String> set2 = new HashSet<>(list);
        System.out.println(set2); // [신사임당, 홍길동, 강감찬]
    }
}

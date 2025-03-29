package com.sh.collections._02.set;

import java.util.*;

/**
 * <pre>
 *  Set <---> List
 *  1. Set -> List 순서/정렬기능이 필요할때
 *  2. List -> set 중복을 제거하고 싶을때
 *  </--->
 *
 *
 * </pre>
 *
 */
public class App3 {
    public static void main(String[] args) {
        Set<String> set = new HashSet<>();
        set.add("홍길동");
        set.add("신사임당");
        set.add("강감찬");
        System.out.println(set);
//        Collections.sort();
        List<String> list = new ArrayList<>(set);
        Collections.sort(list);
        System.out.println(list);

        list.add("홍길동");
        list.add("신사임당");
        list.add("강감찬");
        System.out.println(list); // 중복 들어감

        Set<String> set2 = new HashSet<>(list); // 중복제거
        System.out.println(set2);
    }
}

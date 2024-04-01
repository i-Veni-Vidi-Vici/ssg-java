package com.sh.collections._02.set;

import java.util.*;

/**
 * <pre>
 * Set <----> List
 * 1. Set -> List : 순서/정렬기능이 필요할 때 set에서 list로 바꿔서 사용
 * 2. List -> Set : 중복을 제거하고 싶을 때 list에서 set으로 바꿔서 사용
 * </pre>
 */
public class App3 {
    public static void main(String[] args) {
        Set<String> set = new HashSet<>();
        set.add("홍길동");
        set.add("신사임당");
        set.add("강감찬");
        System.out.println(set);

        // list로 변환하는 방법
        List<String> list = new ArrayList<>(set);
        Collections.sort(list);
        System.out.println(list); // [강감찬, 신사임당, 홍길동]

        list.add("홍길동");
        list.add("신사임당");
        list.add("강감찬");
        System.out.println(list);

        // set으로 전환하는 방법
        Set<String> set2 = new HashSet<>(list);
        System.out.println(set2);
    }
}

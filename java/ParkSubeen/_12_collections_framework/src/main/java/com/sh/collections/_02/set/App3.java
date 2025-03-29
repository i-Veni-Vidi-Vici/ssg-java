package com.sh.collections._02.set;

import java.util.*;

/**
 * <pre>
 * Set <---> List
 * 1. Set -> List 순서/정렬기능이 필요할때
 * 2. List -> Set 중복을 제거하고 싶을때
 * </pre>
 */
public class App3 {
    public static void main(String[] args) {
        Set<String> set = new HashSet<>();
        set.add("홍길동");
        set.add("신사임당");
        set.add("강감찬");
        System.out.println(set);

        List<String> list = new ArrayList<>(set); // set 자리에 set 말고도 Collection이 올 수 있다.
        Collections.sort(list);
        System.out.println(list); // [강감찬, 신사임당, 홍길동]

        list.add("홍길동");
        list.add("신사임당");
        list.add("강감찬");
        System.out.println(list);

        Set<String> set2 = new HashSet<>(list); // Collection자리에 list를 인자로 줌.
        System.out.println(set2);
    }
}

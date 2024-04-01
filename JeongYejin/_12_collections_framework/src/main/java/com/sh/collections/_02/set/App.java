package com.sh.collections._02.set;

import java.util.Collection;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

/**
 * <pre>
 * Set 인터페이스
 * - 중복을 허용해서는 안되는 데이터를 관리한다.
 * - ****중복안돼****
 * - 저장된 순서를 관리하지 않는다.
 * - 구현클래스 HashSet, LinkedHashSet(저장된 순서 기억), TreeSet(오름차순 정렬처리)
 * - List와 공통된 부모인터페이스 Collection을 공유한다.
 * </pre>
 */
public class App {
    public static void main(String[] args) {
//        HashSet set1 = new HashSet();
//        Set set2 = new HashSet();
//        Collection set3 = new HashSet();

        Set<String> set = new HashSet<>();
        // add(E) 요소추가
        set.add("java");
        set.add("mysql");
        set.add("html");
        set.add("css");
        set.add("spring");

        // 중복저장
        set.add("java");
        System.out.println(set.add("java")); // boolean값 반환

        // 전체 요소 수
        System.out.println(set.size()); // 5

        // 포함 여부
        System.out.println(set.contains("spring")); // true
        System.out.println(set.contains("node.js")); // false

//        set.indexOf(); // Set에는 인덱스기반의 메소드가 존재하지 않는다.
//        set.get(0);
//
//        for (int i = 0; i < set.size(); i++) {
//            set.get(i);
//        }

        // toString
        System.out.println(set);

        // 반복처리 - 인덱스가 존재하지 않으므로, 일반 for문을 사용할 수 없다.
        // 1. for each
        for (String str : set) {
            System.out.println(str);
        }

        Iterator<String> iter = set.iterator();
        while (iter.hasNext()) {
            String next = iter.next();
            System.out.println(next);
        }
        System.out.println(iter.hasNext()); // false

        System.out.println(set);

        System.out.println(set.isEmpty()); // false

        // clear() 모든 요소 제거
        set.clear();

        // isEmpty() 비어있는지 여부
        System.out.println(set.isEmpty()); // true
    }
}

package com.sh.collections._02.set;

import java.util.Collection;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

/**
 * <pre>
 * Set 인터페이스
 * - 중복을 허용해서는 안되는 데이터 관리
 * - 저장된 순서를 관리하지 않음
 * - 구현클래스 HashSet, LinkedHashSet(저장된 순서 기억), TreeSet(오름차순 정렬)
 * </pre>
 */

public class App {
    public static void main(String[] args) {
        // 다형성 고려하여 아래와 같이 사용가능
//        HashSet set1 = new HashSet<>();
//        Set set2 = new HashSet();
//        Collection set3 = new HashSet();

        Set<String> set = new HashSet<>();
        // add(E) 요소추가
        set.add("java");
//        System.out.println(set.add("java")); // true (없는값 저장할때)
        set.add("mysql");
        set.add("html");
        set.add("css");
        set.add("spring");

        // 중복저장
        set.add("java"); // 중복저장 X, [spring, css, java, mysql, html]
//        System.out.println(set.add("java")); // false (있는값 저장할때)

        // 전체 요소수
        System.out.println(set.size());

        // 포함여부
        System.out.println(set.contains("spring")); // true
        System.out.println(set.contains("node.js")); // false

        // toString
        System.out.println(set); // 순서 고려 X, [spring, css, java, mysql, html]

        // Set에는 인덱스기반의 메소드 존재 X
//        set.indexOf();
//        set.get(0);
//        반복처리 : 인덱스가 존재하지 않으므로, 일반 for문을 사용할 수 없음
        // 1. for each
        for (String str : set){
            System.out.println(str);
        }
        // 2. Iterator
        Iterator<String> iter = set.iterator();
        while (iter.hasNext()) {
            String next = iter.next();
            System.out.println(next);
        }

        // clear() : 모든 요소 제거
        set.clear();

        // 비어있는지 여부
        System.out.println(set.isEmpty()); // true
    }
}

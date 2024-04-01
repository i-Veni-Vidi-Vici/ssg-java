package com.sh.collections._02.set;

import java.util.Collection;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

/**
 * Set 인터페이스
 * - 중복을 허용해서는 안되는 데이터를 관리한다.
 * - 저장된 순서를 관리하지 않는다.
 * - 구현 클래스 HashSet, LinkedHashSet(저장된 순서 기억), TreeSet(오름차순 정렬처리)
 * - List 와 공통된 부모인터페이스 Collection 을 공유한다.
 */
public class App {
    public static void main(String[] args) {
//        HashSet set1 = new HashSet();
//        Set set2 = new HashSet(); // 일반적으로 사용
//        Collection set3 = new HashSet();

        Set<String> set = new HashSet<>();
        // add(E) 요소 추가
        set.add("java"); // return true
        set.add("mysql");
        set.add("html");
        set.add("js");
        set.add("css");
        // 중복 저장
        set.add("css"); // return false
        set.add("css");

        // 전체 요소수
        System.out.println(set.size());

        // 포함 여부
        System.out.println(set.contains("java"));
        System.out.println(set.contains("node"));

        // set.indexOf() // set 에는 인덱스기반의 메소드가 없다.

        // toString
        System.out.println(set);

        // 반복처리: 인덱스가 존재하지 않으므로, 일반 for 문을 사용할 수 없다.
        // 1. for each
        for (String str: set) {
            System.out.println(set);
        }

        // 2. Iterator
        Iterator<String> iter = set.iterator();
        while (iter.hasNext()) {
            System.out.println(iter.next());
        }

        // isEmpty() 비어있는지 여부
        System.out.println(set.isEmpty());

        // clear() 모든 요소 제거
        set.clear();
    }
}

package com.sh.collections._02.set;

import java.util.Collection;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

/**
 * <pre>
 * Set 인터페이스
 * - 중복을 허용해서는 안되는 데이터를 관리한다.
 * - 저장된 순서를 관리하지 않는다.
 * - 구현클래스 HashSet, LinkedHashSet(저장된 순서 기억), TreeSet(오름차순 정렬처리)
 * - List와 공통된 부모 인터페이스 Collection을 공유하고 있다. --> 호출할 수 있는 메소드가 비슷하다.
 * - List와 Set은 비슷. Map은 결이 다름.
 *
 * </pre>
 */

public class App {
    public static void main(String[] args) {
//        HashSet set1 = new HashSet();
//        Set set2 = new HashSet();
//        Collection set3 = new HashSet();
        Set<String> set = new HashSet<>();
        // add(E) 요소추가
        System.out.println(set.add("java")); // True
        set.add("mysql");
        set.add("html");
        set.add("css");
        set.add("spring");

        // 중복저장
        System.out.println(set.add("java")); // False

        // 전체 요소 수
        System.out.println(set.size()); // 5

        // 포함여부
        System.out.println(set.contains("spring")); // True
        System.out.println(set.contains("node.js")); // False

//        set.indexOf() // set에는 인덱스 기반의 메소드 존재 X
//        set.get(0) , for 문도 안됨.

        // toString 오버라이드가 되어 있음 바로 확인.
        System.out.println(set); // 순서 관심 없음.

        // 반복처리 - 인덱스가 존재 X, 일반 for문 사용불가.(for-each, iterator)
        // 1. for each
        for(String str : set){
            System.out.println(str);
        }
        // 2. Iterator
        Iterator<String> iter = set.iterator();
        while (iter.hasNext()){
            String next = iter.next();
            System.out.println(next);
        }

        // Clear() 모든 요소 제거
        set.clear();

        // isEmpty() 비어있는지 여부
        System.out.println(set.isEmpty());
    }
}

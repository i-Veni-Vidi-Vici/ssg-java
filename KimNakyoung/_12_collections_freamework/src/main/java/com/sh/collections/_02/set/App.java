package com.sh.collections._02.set;

import java.util.Collections;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

/**
 * <pre>
 * Set 인터페이스
 * - 중복을 허용해서는 안되는 데이터를 관리한다.
 * - 저장된 순서를 관리하지 않는다.
 * - 구현클래스 HashSet, LinkedHashSet(저장된 순서 기억), TreeSet(오름차순 정렬처리)
 * LinkedHashSet 순서는 있는데 인덱스는 없어!!
 * - Lsit와 공통된 부모인터페이스 Collection을 공유한다.
 *
 * </pre>
 *
 *
 */


public class App {
    public static void main(String[] args) {
//        HashSet set1 = new HashSet();
//        Set set2 = new HashSet();
//        Collections set3 = new HashSet(); //파라미터 어쩌구 는

        Set<String> set = new HashSet<>();
        // add(E)요소 추가
        System.out.println(set.add("java"));
        set.add("mysql");
        set.add("html");
        set.add("css");
        set.add("spring");

        //중복저장
        // 이거 해도 자바 두개 안뜸 (같은 요소 있으면 추가저장x)
        System.out.println(set.add("java"));  // false 이미 있는거 저장이라

        System.out.println(set.size()); // 5

        // 포함 여부
        System.out.println(set.contains("spring")); // true
        System.out.println(set.contains("node.js")); // false

//        set.indexOf() // Set에는 인덱스기반의 메소드가 존재하지 않는다.
//        set.get(0) //이런거 없음
        // toString 오버라이드 되있음

        //toString
        System.out.println(set);

        //반복처리 - 인덱스가 존재하지 않으므로, 일반 for문을 사용할 수 없다.
        // 1.for each (인덱스 기반x)
        for (String s : set) {
            System.out.println(s);

        }
        // 2. Iterator 반복자 객체 만들고 while문 안에서 다음꺼 있니? 있으먄 줘바
        Iterator<String> iter = set.iterator();
        while (iter.hasNext()){
            String next = iter.next();
            System.out.println(next);
        }
        //clear() 모든 요소 제거
        set.clear();

        // isEmpty() 비어있는지 여부
        System.out.println(set.isEmpty());



    }
}

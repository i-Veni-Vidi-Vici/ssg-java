package com.sh.collections._02.set;

import java.util.Collection;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

/**
 * <pre>
 *     Set인터페이스
 *     - 중복을 허용해서는 안되는 데이터를 관리한다. // like 집합
 *     - 저장된 순서를 관리하지 않는다.
 *     - 구현 클래스는 HashSet, LinkedHashSet(저장된 순서 기억) 순서는 있는데 인덱스는 없음 주의, TreeSet(오름차순 정렬처리)
 *     - List와 공통된 부모 인터페이스 Collection을 공유하다.
 * </pre>
 */
public class App {
    public static void main(String[] args) {
//        HashSet set1 = new HashSet();
//        Set set2 = new HashSet();               // 주로 이렇게 많이 사용한다.
//        Collection set3 = new HashSet();

        Set<String> set = new HashSet<>();

        // 요소 추가 add(E)
        System.out.println(set.add("java"));      // 잘 저장되었으면 true 리턴
        set.add("mysql");
        set.add("html");
        set.add("css");
        set.add("spring");

        // 중복저장
        System.out.println(set.add("java"));      // 잘 저장 되지 않았으면 false 리턴

        // 전체 요소 개수
        System.out.println(set.size());

        // 포함 여부
        System.out.println(set.contains("spring"));
        System.out.println(set.contains("node.js"));

        // indexOf() set에는 인덱스 기반의 메소드가 존재하지 않는다.
//        set.indexOf();
//        set.get(0);

        // toString()
        System.out.println(set);                    // [spring, css, java, mysql, html]
                                                    // 저장순서 X

        // 반복 처리 시 set은 인덱스가 존재하지 않으므로, 일반 for문을 사용할 수 없다.
        // 1. for each
        for (String str: set) {
            System.out.println(str);
        }
        System.out.println("[for each]");

        // 2. Iterator
        Iterator<String> iter = set.iterator();
        while(iter.hasNext()) {
            String next = iter.next();
            System.out.println(next);
        }

        // clear() 모든 요소 제거
        set.clear();

        // 비어있는지 여부 isEmpty()
        System.out.println(set.isEmpty());

    }
}

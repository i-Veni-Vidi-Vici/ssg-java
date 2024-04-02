package com.sh.collections._02.set;

import java.util.*;

/**
 * <pre>
 *  Set 인터페이스
 *  - 중복을 허용해서는 안되는 데이터를 관리한다.
 *  - 저장된 순서를 관리하지 않는다. - HashSet
 *  - 구현 클래스 HashSet, LinkedHashSet(저장된 순서 기억), TreeSet(오름차순 정렬 처리 자동)
 *  - List와 공통된 부모 인터페이스 Collection을 공유한다.
 *
 * </pre>
 */
public class App {
    public static void main(String[] args) {
//        HashSet set1 = new HashSet();
//        Set set2 = new HashSet();
//        Collection set3 = new HashSet();

        Set<String> set = new HashSet<>();
        //요소 추가
        System.out.println(set.add("java")); // 중복된 저장 값이 없으면 true 반환
        set.add("java2");
        set.add("java3");
        set.add("java4");
        set.add("java5");

        //중복 저장 값이 있으면 false반환
        System.out.println(set.add("java"));

        //전체 요소수
        System.out.println(set.size());

        //포함 여부
        System.out.println(set.contains("spring"));
        //set.indexOf() // set에는 인덱스 기반의 메소드가 존재하지 않는다.
        //set.get(0) 존재하지 않는다.

        //toString
        System.out.println(set);

        //반복처리 - 인덱스가 존재하지 않으므로, 일반 for문을 사용할 수 없다.
        //1. for each
        for(String s : set){
            System.out.println(s);
        }
        //2. Iterator
        Iterator<String> iterator = set.iterator();
        while(iterator.hasNext()){
            String next = iterator.next();
            System.out.println(next);
        }

        //clear() 모든 요소 제거
        set.clear();

        //isempty() 비어있는지 여부
        System.out.println(set.isEmpty());
    }
}

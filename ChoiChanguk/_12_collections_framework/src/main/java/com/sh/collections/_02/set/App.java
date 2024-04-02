package com.sh.collections._02.set;

import java.util.*;

/**
 * <pre>
 * Set인터페이스
 * - 중복을 허용해서는 안되는 데이터를 관리한다.
 * - 저장된 순서를 관리하지 않는다.
 * - 구현클래스 hashSet, LinkedHashSet(순서 관리 기억), TreeSet(오른차순 정렬)
 * - List와 공통된 부모인터페이스 Colleciton을 공휴한다.
 * </pre>
 */
public class App {
    public static void main(String[] args) {
//        HashSet set1=new HashSet();
//        Set set2=new HashSet();// 이걸 많이 사용한다
//        Collection set3 = HashSet();

        Set<String> set = new HashSet<>();
        set.add("java");
        set.add("mysql");
        set.add("html");
        set.add("css");
        set.add("spring");
        //toString 오버라이드 되어 있다
        System.out.println(set);

        //중복 저장
        System.out.println(set.add("java"));//추가 저장은 안한다
        System.out.println(set);

        //전체 요소수
        System.out.println("size : "+set.size());

        //포함 여부
        System.out.println("포함 : "+set.contains("java"));

        //set계열에는 index 기반의 메소드가 존재하지 않는다
        //set.get(0) 이런거 없다

        //반복처리 - 인덱스가 존재하지 않으므로 일반 for문은 사용 불가
        System.out.println("   for each   ");
        for(String str: set)
            System.out.println(str);

        // 2.Iterator 객체 후 -> 다음거 있니??
        Iterator<String> iterator=set.iterator();
        System.out.println("  while문   ");
        while(iterator.hasNext())
        {
            String next=iterator.next();
            System.out.println(next);
        }

        // isEmpty 있다
        System.out.println(set.isEmpty());

        //set.clear() 모든 요소 제거
        //set.clear();

    }
}

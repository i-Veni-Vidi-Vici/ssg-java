package com.sh.collections._02.set;

import java.util.*;

/**
 * set 인터페이스
 * -중복을 허용해서는 안되는 데이터를 관리한다.
 * -저장된 순서를 관리하지 않는다.
 * -구현클래스 Hashset.linkedhashset(저장된 순서 기억).Treeset(오름차순 정렬)
 * -list와 공통된 부모인터페이스 Collection을 공유한다.
 */
public class App {
    public static void main(String[] args) {
        HashSet set1 = new HashSet();
        Set set2 = new HashSet();
        Collection set3 = new HashSet();

        Set<String> set = new HashSet<>();
        //add(E) 요소추가
        set.add("java");
        set.add("html");
        set.add("mysql");
        set.add("css");
        set.add("spring");

        //중복저장 안됨
        set.add("java");
        //전체 요소 수
        System.out.println(set.size());
        //포함 여부
        System.out.println(set.contains("spring"));

        //set.indexOf()  //set에는 인덱스 기반의 메소드가 존재하지 않는다.
        //set.get(O)

        System.out.println(set);
        //반복처리 -인덱스가 존재하지 않으므로 , 일반 for문을 사용할 수 없다.
        for(String str : set){
            System.out.println(str);
        }
        //2.Iterator
        Iterator<String> iter = set.iterator();
        while(iter.hasNext()){
            String next = iter.next();
            System.out.println(next);
        }
        //모든요소 제거
        set.clear();
        //isEmpty
        System.out.println(set.isEmpty());


    }
}

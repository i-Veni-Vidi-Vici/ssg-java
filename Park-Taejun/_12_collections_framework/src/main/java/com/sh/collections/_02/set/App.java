package com.sh.collections._02.set;

import java.util.Collections;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

public class App {
    public static void main(String[] args) {
//        HashSet set1 = new HashSet();
//        Set set2 =new HashSet();
//        Collection set3 = new HashSet();

        Set<String> set = new HashSet<>();
        // add(E) 요소추가
        set.add("java");
        set.add("mysql");
        set.add("heml");
        set.add("css");
        set.add("spring");

        //toString
        System.out.println(set);

        // 중복저장
        set.add("java");

        System.out.println(set.add("java")); //false

        //전체 요소수
        System.out.println(set.size());

        //포함 여부
        System.out.println(set.contains("spring"));//true
        System.out.println(set.contains("node.js"));//false

        //set.indexOf() //Set 에는 인덱스기반의 메소드가 존재하지 않는다
        //set.get(0)

        //toString
        System.out.println(set);

        // 반복처리 - 인덱스가 존재하지 않으므로, 일반 for 문을 사용 할 수 없다

        //1. for each
        for(String str : set){
            System.out.println(str);
        }

        //2.Iterator
        Iterator<String> iter = set.iterator();
        while (iter.hasNext()){
            String next = iter.next();
            System.out.println(next);
        }
        //clear () 모든 요소 제가
        set.clear();

        // isEmpty() 비어있는지 여부
        System.out.println(set.isEmpty());

    }
}

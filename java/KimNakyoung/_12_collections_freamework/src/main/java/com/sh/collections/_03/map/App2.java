package com.sh.collections._03.map;

import java.util.*;

/**
 * <pre>
 * Map 요소 순회
 * - map은 반복접근 안돼요
 * - 모든 요소를 빠짐없이 열람하는 것
 *
 *  1. keySet()를 이용
 *  2. entrySet()를 이용
 *
 * </pre>
 *
 */

public class App2 {
    public static void main(String[] args) {
        Map<String,Double> map = new HashMap<>();
        map.put("one", 1.2345);
        map.put("two", 2.3456);
        map.put("three", 3.4563);
        map.put("four", 4.5678);
        map.put("five", 5.6789);

        // 안돼요
//        for(?? elem : map) {} // map자체를 foreach 접근할 수 없다.
        // 1. keySet
        Set<String> keyset = map.keySet(); // key의 타입

        System.out.println(keyset);

        // 1-1. for..each

        for (String s : keyset) {
            Double value = map.get(s);
            System.out.println(s + " = " + value);
        }
            // 1-2. Iterator
        Iterator<String> iterator = keyset.iterator();
        while(iterator.hasNext()) {
            String key = iterator.next();
            Double value = map.get(key);
            System.out.println(key + " = " + value);
        }

        //2. entrySet() : Set<Entry> -> K , V를 묶은 타입 Node의 부모인터페이스
        Set<Map.Entry<String,Double>> entrySet = map.entrySet();
        System.out.println(entrySet);
        // 2-1. foreach
        for (Map.Entry<String, Double> stringDoubleEntry : entrySet) {
            String key = stringDoubleEntry.getKey(); // ctrl + alt + v
            Double value = stringDoubleEntry.getValue();
            System.out.println(key + "=" + value);
        }

        // 2-2 iterator

        Iterator<Map.Entry<String,Double>> iterator1 = map.entrySet().iterator();
        while (iterator1.hasNext()) {
            Map.Entry<String,Double> next = iterator1.next(); // next에서 꺼냈을때 타입은 맵.엔트리
            String key = next.getKey(); // ctrl + alt + v
            Double value = next.getValue();
            System.out.println(key + "=" + value);
        }

        // value만 순회하기
        Collection<Double> values = map.values();// 얘 리턴타입은 컬렉션이다. // set은 아님 벨류는 중복되기가능

        //for each 가능

        for (Double value : values) {
            System.out.println(value);
        }




    }
}

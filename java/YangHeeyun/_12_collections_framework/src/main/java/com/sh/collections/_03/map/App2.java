package com.sh.collections._03.map;

import java.util.*;

/**
 * <Pre>
 * Map 요소 순회
 * - 모든 요소를 빠짐없이 열람하는 것
 *
 * 1. KeySet() 이용
 * 2. entrySet() 이용
 *
 * </Pre>
 */
public class App2 {
    public static void main(String[] args) {
        Map<String, Double> map = new HashMap<>();
        map.put("one", 1.2345);
        map.put("two", 2.3456);
        map.put("three", 3.4563);
        map.put("four", 4.5678);
        map.put("five", 5.6789);
        System.out.println(map);

        //for(?? elem:map){} // map자체를 foreach로 접근하라 수 없다.

        //1. keySet(key값만 모아서 Set으로 만들기)
        Set<String> keySet = map.keySet();
        System.out.println(keySet);

        //Set으로 만든 다음 열람하는 방법
        // 1-1. for..each
        for (String key : keySet) {
            Double value = map.get(key); // key로 value값을 반환받는 방법
            System.out.println(key + " = " + value);
        }
        // 1 - 2. Iterator
        Iterator<String> iter = keySet.iterator();
        while (iter.hasNext()) {
            String key = iter.next();
            Double value = map.get(key);
            System.out.println(key + " = " + value);
        }
        // 2. entrySet() : Set<Entry> -> K,V를 묶은 타입 Node의 부모인터페이스
        Set<Map.Entry<String, Double>> entrySet = map.entrySet();
        // 2-1. foreach
        for (Map.Entry<String, Double> entry : entrySet) {
            String key = entry.getKey();
            Double value = entry.getValue();
            System.out.println(key + " = " + value);
        }
        //2-2. Iterator
        Iterator<Map.Entry<String, Double>> iter2 = entrySet.iterator();
        while (iter2.hasNext()) {
            Map.Entry<String, Double> next = iter2.next();
            String key = next.getKey();
            Double value = next.getValue();
            System.out.println(key + " = " + value);
        }

        // value만 순회하기
        Collection<Double> values = map.values(); // list,set
        for (Double value : values) {
            System.out.println(value);
        }
    }
}
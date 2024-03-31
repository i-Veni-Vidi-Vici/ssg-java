package com.sh.collections._03.map;

import java.util.*;

/**
 * <pre>
 * Map 요소 순회
 * - 모든 요소를 빠짐없이 열람하는 것
 *
 * 1. keySet()를 이용
 * 2. entrySet()를 이용
 *
 * </pre>
 */
public class App2 {
    public static void main(String[] args) {
        Map<String, Double> map = new HashMap<>();
        map.put("one", 1.2345);
        System.out.println(map);
        map.put("two", 2.3456);
        map.put("three", 3.4567);
        map.put("four", 4.5678);
        map.put("five", 5.6789);

        System.out.println(map);

//        for (? ele : map) {} // map자체를 foreach로 접근할 수 없다.
        // 1. keySet
//        Set<?> keySet = map.keySet(); // 가능!
        Set<String> keySet = map.keySet(); // set으로 만들어서 반복접근 가능해짐 (인덱스로는 안됨)
        System.out.println(keySet);
        // 1-1. for..each
        for(String key : keySet) {
            Double value = map.get(key);
            System.out.print(key);
            System.out.print(" = ");
            System.out.println(value);
        }
        // 1-2. Iterator
        Iterator<String> iter = keySet.iterator();
        while (iter.hasNext()) {
//            System.out.println(iter.next());
            String key = iter.next();
            System.out.println(key + " " + map.get(key));
        }

        // 2. entrySet() : set<Entry> -> K, V를 묶은 타입 Node의 부모 인터페이스
        Set<Map.Entry<String, Double>> entrySet = map.entrySet();
        System.out.println(entrySet);
        // 2-1. for...each
        for (Map.Entry<String, Double> entry : entrySet) {
            String key = entry.getKey();
            Double value = entry.getValue();
            System.out.println(key + " = " + value);
        }
        // 2-2. iterator
        Iterator<Map.Entry<String, Double>> iterSet = map.entrySet().iterator();
        while (iterSet.hasNext()) {
            Map.Entry<String, Double> next = iterSet.next();
            System.out.println(next);
            String key = next.getKey();
            Double value = next.getValue();
//            System.out.println(key + " = " + value);
        }
        // value만 순회하기
        Collection<Double> values = map.values(); // list, set
        for (Double value : values) {
            System.out.println(value);
        }
    }
}

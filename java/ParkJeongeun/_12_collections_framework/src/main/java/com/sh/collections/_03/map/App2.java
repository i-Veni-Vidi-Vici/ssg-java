package com.sh.collections._03.map;

import java.util.*;

/**
 * <pre>
 * Map의 요소 순회
 * - 모든 요소를 빠짐없이 열람하는 것
 *
 * 1. keySet()
 * 2. entrySet()
 * </pre>
 */
public class App2 {
    public static void main(String[] args) {
        Map<String, Double> map = new HashMap<>();
        map.put("one", 1.2345);
        map.put("two", 2.3456);
        map.put("three", 3.4567);
        map.put("four", 4.5678);
        map.put("five", 5.6789);
        System.out.println(map);

        // for(?? elem : map){} // map 자체를 for each로 접근할 수 없음
        // 1. keySet : key 값만 출력
        Set<String> keySet = map.keySet();
        System.out.println(keySet); // [four, one, two, three, five]
        // 1-1. for each
        for (String key : keySet) {
            Double value = map.get(key);
            System.out.println(key + " = " + value);
        }
        // 1-2. Iterator
        Iterator<String> iter = keySet.iterator();
        while (iter.hasNext()) {
            String key = iter.next();
            Double value = map.get(key);
            System.out.println(key + " = " + value);
        }
        // 2. entrySet() : Set<Entry> -> K,V를 묶은 타입 Node의 부모 인터페이스
        Set<Map.Entry<String, Double>> entrySet = map.entrySet();
        // 2-1. for each
        for (Map.Entry<String, Double> entry: entrySet) {
            String key = entry.getKey();
            Double value = entry.getValue();
            System.out.println(key + " = " + value);
        }
        // 2-2. iterator
        Iterator<Map.Entry<String, Double>> iter2 = entrySet.iterator();
        while (iter2.hasNext()) {
            Map.Entry<String, Double> entry = iter2.next();
//            String key = entry.getKey();
//            Double value = entry.getValue();
            System.out.println(entry);
        }

        // value만 순회하기
        Collection<Double> values = map.values(); // list 또는 set
        for (Double value : values) {
            System.out.println(value);
        }
    }
}

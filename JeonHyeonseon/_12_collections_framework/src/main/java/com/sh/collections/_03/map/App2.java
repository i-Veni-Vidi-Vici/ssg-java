package com.sh.collections._03.map;

import java.util.*;

/**
 * <pre>
 * Map의 요소 순회
 * - 모든 요소를 빠짐없이 열람하는 것
 *
 * 1. keySet()을 이용
 * 2. entrySet()을 이용
 *
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

//        for(?? elem : map){} // map자체를 foreach에 접근할 수 없다
        // 1. keySet
        Set<String> keyset = map.keySet();
        System.out.println(keyset);
         // 1-1. for..each
        for(String key : keyset) {
            Double value = map.get(key); // value의 타입이 Double인 것은 위(19줄)에서 알 수 있다.
            System.out.println(key + " = " + value);
        }

        // 1-2. Iterator
        Iterator<String> iter = map.keySet().iterator();
        while(iter.hasNext()) {
            String key = iter.next();
            Double value = map.get(key);
            System.out.println(key + " = " + value);
        }

        // 2. entrySet() : Set<Entry> -> K, V를 묶은 타입 Node의 부모인터페이스
        Set<Map.Entry<String, Double>> entrySet = map.entrySet();
        System.out.println(entrySet);
        // 2-1. foreach
        for (Map.Entry<String, Double> entry : entrySet) {
            String key = entry.getKey();
            Double value = entry.getValue();
            System.out.println(key + " = " + value);
        }
        // 2-2. iterator
        Iterator<Map.Entry<String, Double>> iterator = map.entrySet().iterator();
        while(iterator.hasNext()) {
            Map.Entry<String, Double> next = iterator.next();
            String key = next.getKey();
            Double value = next.getValue();
            System.out.println(key + " + " + value);
        }

        // value만 순회하기
        Collection<Double> values = map.values(); // list, set
        for(Double value : values) {
            System.out.println(value);
        }
    }
}

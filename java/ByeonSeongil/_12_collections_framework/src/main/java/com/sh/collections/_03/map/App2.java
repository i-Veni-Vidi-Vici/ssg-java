package com.sh.collections._03.map;

import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

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
        map.put("two", 2.3456);
        map.put("three", 3.4563);
        map.put("four", 4.5678);
        map.put("five", 5.6789);

        System.out.println(map);

        // for(?? elem : map) {}   // map자체를 foreach로 접근할 수 없음
        // 1.ketSet
        Set<String> keySet = map.keySet();
        System.out.println(keySet);
        // 1-1 for..each
        for (String k : keySet) {
            Double value = map.get(k);
            System.out.println(k);
        }

        // 1-2 Iterator
        Iterator<String> iterator = keySet.iterator();
        while (iterator.hasNext()) {
            String key = iterator.next();
            Double value = map.get(key);
            System.out.println(key +" = "+ value);
        }

        // 2. entrySet() : Set<Entry> -> K, V를 묶은 타입 Node의 부모인터페이스
        Set<Entry<String, Double>> entrySet = map.entrySet();
        System.out.println(entrySet);
        // 2-1. foreach
        for (Entry<String, Double> entry : entrySet) {
            String key = entry.getKey();
            Double value = entry.getValue();
            System.out.println(key +" = " + value);

        }

        // 2-2 iterator
        Iterator<Entry<String, Double>> iterator1 = entrySet.iterator();
        while (iterator1.hasNext()) {
            Entry<String, Double> next = iterator1.next();
            String key = next.getKey();
            Double value = next.getValue();
            System.out.println(key +" = " + value);

        }

        // value만 순회하기
        Collection<Double> values = map.values();
        for (Double value : values) {
            System.out.println(value);
        }

    }
}

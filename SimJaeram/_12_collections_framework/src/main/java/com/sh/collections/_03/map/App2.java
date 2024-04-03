package com.sh.collections._03.map;

import java.util.*;

/**
 * <pre>
 *     Map 요소의 순회
 *     - 저장 순서 X
 *     - 모든 요소를 빠짐없이 열람하는 것이 순회이다.
 *     - 맵은 인덱스 없음, 또한 for each문으로 반복을 이용하여 접근할 수 없다.
 *
 *     1. keySet()를 이용
 *     2. entrySet()을 이용
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

        System.out.println(map);                // 저장 순서 X

        // Map은 for each문 사용불가
        // Map 자체를 for each 접근할 수 없다.
//        for (?? : map) {}

        // 1. keySet set으로 만들어 반복 접근한다.
        Set<String> keySet = map.keySet();
        System.out.println(keySet);

        // 1 - 1 for...each
        for (String key : keySet) {
            Double value = map.get(key);
            System.out.println(key + " = " + value);
        }

        // 1 - 2 Iterator
        Iterator<String> iter = keySet.iterator();
        while(iter.hasNext()) {
            String key = iter.next();
            Double value = map.get(key);
            System.out.println(key + " = " + value);
        }

        // 2. entrySet() : Set<Entry> -> K, V를 묶은 타입 Node의 부모인터페이스
        Set<Map.Entry<String, Double>> entrySet = map.entrySet();
        // 2-1. foreach
        for (Map.Entry<String, Double> entry : entrySet) {
            String key = entry.getKey();
            Double value = entry.getValue();
            System.out.println(key + " = " + value);
        }
        System.out.println();

        // 2-2 Iterator
        Iterator<Map.Entry<String, Double>> iter2 = entrySet.iterator();
        while(iter2.hasNext()) {
            Map.Entry<String, Double> next = iter2.next();
            String key = next.getKey();
            Double value = next.getValue();
            System.out.println(key + " = " + value);
        }

        // value만 순회하기
        Collection<Double> values = map.values();      // list, set
        for(Double value : values) {
            System.out.println(value);
        }


    }
}

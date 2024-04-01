package com.sh.collections._03.map;

import java.util.*;

/**
 * Map 요소 순회
 * - 모든 요소를 빠짐 없이 열람하는
 * 1. keySet()
 * 2. entrySet()
 */
public class App2 {
    public static void main(String[] args) {
        Map<String, Double> map = new HashMap<>();
        map.put("one", 1.2345);
        map.put("two", 2.2345);
        map.put("three", 3.2345);
        map.put("four", 4.2345);
        map.put("five", 5.2345);
        System.out.println(map);

        // 1. keySet
        Set<String> keySet = map.keySet();
        System.out.println(keySet);
        for (String key: keySet) {
            Double value = map.get(key);
            System.out.println(value);
        }

        Iterator<String> iter = map.keySet().iterator();
        while (iter.hasNext()) {
            System.out.println(map.get(iter.next()));
        }

        // 2. entrySet():Set<Entry> -> K, V 를 묶은 타입 Node 의 부모인터페이스
        Set<Map.Entry<String, Double>> entrySet = map.entrySet();
        // 2-1. for each
        for (Map.Entry<String, Double> entry: entrySet) {
            String key = entry.getKey();
            Double value = entry.getValue();
            System.out.println(key + " = " + value);
        }

        // 2-2. Iterator
        Iterator<Map.Entry<String, Double>> iterator = map.entrySet().iterator();
        while (iterator.hasNext()) {
            Map.Entry<String, Double> entry = iterator.next();
            String key = entry.getKey();
            Double value = entry.getValue();
            System.out.println(key + " = " + value);
        }

        // value 만 순회
        Collection<Double> values = map.values(); // list, set
        for (Double dNum : values) {
            System.out.println(dNum);
        }
    }

}

package com.sh.collections._03.map;

import java.util.*;
//import java.util.*;

/**
 * Map 요소 순회
 * - 모든 요소를 빠짐 없이 열람하는 것
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

        /*
        // 1. KeySet
        Set<String> keySet = map.keySet();
        System.out.println(keySet);

        for(String key : keySet){
            Double value = map.get(key);
            System.out.println(key + " = " + value);
        }

        Iterator<String> iterator = keySet.iterator();
        while(iterator.hasNext()){
            String key = iterator.next();
            Double value = map.get(key);
            System.out.println(value);
        }
        */
        // 2. entrySet() : Set<Entry> -> K,V를 묶은 타입 Node의 부모 인터페이스
        Set<Map.Entry<String,Double>> entrySet = map.entrySet();
        // 2-1. foreach
        System.out.println("entry foreach 출력");
        for(Map.Entry<String, Double> entry : entrySet){
            String key = entry.getKey();
            Double value = map.get(key);
            System.out.println(value);
            System.out.println(entry);
        }

        //2-2. iterator
        Iterator<Map.Entry<String, Double>> iterator = entrySet.iterator();
        System.out.println("-엔트리셋 이터레이터버전-");
        while(iterator.hasNext()){
            Map.Entry<String, Double> ent = iterator.next();
            System.out.println(ent.getKey() + " , " +ent.getValue());
        }

        //value만 순회하기
        System.out.println("value만 순회하기");
        Collection<Double> values = map.values();   //list, set
        for(Double value : values){
            System.out.println(value);
        }

    }
}

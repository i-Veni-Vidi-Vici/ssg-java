package com.sh.collections._03.map;

import java.util.*;

public class App2 {
    public static void main(String[] args) {
        Map<String, Double> map = new HashMap<>();
        map.put("one", 1.2345);
        map.put("two", 2.3456);
        map.put("three", 3.4567);
        map.put("four", 4.5678);
        map.put("five", 5.6789);

        System.out.println(map);

//        for(?? elem : map){} // map 자체를 foreach로 접근 불가
        // 1. keySet
        Set<String> ketSet = map.keySet();
        System.out.println(ketSet);
        // 1-1 for .. each
//        for(String key : ketSet){
//            Double value = map.get (key);
//            System.out.println(key + "  =  " + value);
//        }
        //1-2 Iterator
//        Iterator<String> iterator = ketSet.iterator();

        //2. entrySet : Set<Entry> -> K,V를 묶은 타입 Node의 부모인터페이스
        Set<Map.Entry<String, Double>> entrySet = map.entrySet();
        //2-1. foreach
        for (Map.Entry<String, Double> entry : entrySet){
            String key = entry.getKey();
            Double value = entry.getValue();
            System.out.println(key + " = " + value);
        }

        // 2-2. iterator

        Iterator<Map.Entry<String, Double>> iterator = entrySet.iterator();
        while (iterator.hasNext()){
            Map.Entry<String, Double> next = iterator.next();
            String key = next.getKey();
            Double value = next.getValue();
            System.out.println(key + " = " + value);

        }
           //value 만 순회하기
        Collection<Double> values = map. values(); //반복접근을 허락해줌
        for(Double value : values){
            System.out.println(value);
        }

    }
}

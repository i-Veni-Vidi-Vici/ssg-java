package com.sh.collections._03.map;

import java.util.*;

/**
 * <pre>
 *  Map의 요소 순회
 *  - 순서 유지하지 않고, Key로써 value접근
 *  - 모든 요소를 빠짐없이 열람하는 것을 의미함.
 *
 * Map에서 접근하기 위해서는 -> map에 대한 객체 -> set으로 정리 하고 나서 set에서 for-each, Iterator로 접근
 * Map<K,V> map = new HashMap<>(); -> Set<String> keyset = map.keyset(); -> for - each, iterator
 *  1. keySet()메소드를 이용
 *  2. entrySet() 메소드를 이용
 * </pre>
 */
public class App2 {
    public static void main(String[] args) {
        Map<String, Double> map = new HashMap<>();
        map.put("one", 1.2345);
        map.put("two", 2.345);
        map.put("three", 3.45);
        map.put("four", 4.5);
        System.out.println(map);

        //for(?? elem : map){} //map 자체를 foreach로 접근할 수 없다.
        // 1. keySet

        Set<String> keySet = map.keySet();
        System.out.println(keySet);
        // 1-1. for.. each
        for(String s : keySet){
            Double value = map.get(s);
            System.out.println(s + " = " + value);
        }
        // 1-2. Iterator
        System.out.println("Iterator 이용 ");
        Iterator<String> iterator = keySet.iterator();
        while(iterator.hasNext()){
            String s = iterator.next();
            System.out.println(s);
        }


        //2. entrySet() : set<Entry> -> K, V를 묶은 타입 Node의 부모 인터페이스
        Set<Map.Entry<String, Double>> entrySet = map.entrySet();
        System.out.println(entrySet); // entry는 four=4.5를 한 묶음으로 사용

        //2-1. for each
        for(Map.Entry<String,Double> entry : entrySet){
            String key = entry.getKey();
            Double value = entry.getValue();
            System.out.println(key + "=" + value);
        }

        //2-2 iterator
        System.out.println();
        Iterator<Map.Entry<String, Double>> iterator1 = entrySet.iterator();
        while(iterator1.hasNext()){
            Map.Entry<String, Double> s = iterator1.next();
            System.out.println(s);
        }

        //value만 순회하기
        //list객체로 생각하기, set이라고 생각되면 중복되는 value값이 있어서 값이 날아갈 수 도 있음.
        Collection<Double> values = map.values(); //list, set
        for(Double value : values) System.out.println(value); //list이기 때문에 중복값이 발생 할 수 도 있음.
    }
}

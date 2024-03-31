package collections._03.map;

import java.util.*;

/**
 * <pre>
 * Map 요소 순회
 * - 모든 요소를 빠짐없이 열람하는 것
 *
 * 1. keySet()룰 이용
 * 2. entrySet()를 이용
 * </pre>
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

        // for(?? elem : map) {} // map 자체를 forEach 접근할 수 없다.
        // 1. keySet
        Set<String> keySet = map.keySet();
        System.out.println(keySet);

        // 1-1. for..each
//        for (String key: keySet) {
//            Double value =  map.get(key);
//            System.out.println(key + " = " + value);
//        }

        // 1-2. iterator
//        Iterator<String> iter = map.keySet().iterator();
//        while (iter.hasNext()) {
//            String key = iter.next();
//            Double value = map.get(key);
//            System.out.println(key + " = " + value);
//        }

        // 2. entrySet() : Set<Entry> -> K, V를 묶은 타입 Node 의 부모인터페이스
        Set<Map.Entry<String, Double>> entrySet = map.entrySet();

        // 2-1. foreach
//        for (Map.Entry<String, Double> entry : entrySet) {
//            String key = entry.getKey();
//            Double value = entry.getValue();
//            System.out.println(key + " = " + value);
////            System.out.println(entry);
//        }

        // 2-2 iterator
//        Iterator<Map.Entry<String, Double>> iterator = map.entrySet().iterator();
//        while (iterator.hasNext()) {
//            String key = iterator.next().getKey();
//            Double value = map.get(key);
//            System.out.println(key + " = " + value);
//        }

        // value 만 순회하기
        Collection<Double> values = map.values(); // list, set
        for (Double value : values) {
            System.out.println(value);
        }

    }
}

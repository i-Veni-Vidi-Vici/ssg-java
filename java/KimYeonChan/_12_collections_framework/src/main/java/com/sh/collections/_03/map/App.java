package com.sh.collections._03.map;

import java.util.HashMap;
import java.util.Map;

/**
 * Map 인터페이스
 * - key/value 를 쌍으로 하나의 요소로써 저장한다.
 * - Key: 요소를 찾기 위한 식별자 역할
 *      1. key 는 중복을 허용하지 않는다.
 *      2. key 가 중복된 값을 저장하면, 기존 값이 덮어 써진다.
 * value: key 식별자와 연결된 값. key 가 다르다면 중복이 가능하다.
 * - 구현 클래스 HashMap, LinkedHashMap, TreeMap
 * - 레거시 클래스 (HashTable, Properties) 중에서는 Properties 를 지금도 많이 사용하고 있다.
 *      -
 */
public class App {
    public static void main(String[] args) {
//        HashMap map1 = new HashMap();
//        Map map2 = new HashMap();

        Map<String, Integer> map = new HashMap<>();
        // put(K, V) 요소 저장
        map.put("홍길동", 23);
        map.put("심사임당", 40);
//        map.put(50, "이순신");
        System.out.println(map);

        System.out.println(map.get("홍길동"));
        System.out.println(map.get("김연찬"));

        // 중복된 key 저장
        Integer removed = map.put("홍길동", 33);
        System.out.println(removed);

        System.out.println(map.size());

        // containsKey():boolean
        System.out.println(map.containsKey("홍길동"));
        System.out.println(map.containsKey("김연찬"));

        // containsValue():boolean
        System.out.println(map.containsValue(33));
        System.out.println(map.containsValue(300));

        System.out.println(map.remove("홍길동"));
        System.out.println(map.remove("김연찬"));
    }
}

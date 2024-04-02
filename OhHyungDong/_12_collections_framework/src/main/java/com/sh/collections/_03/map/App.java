package com.sh.collections._03.map;

import java.util.HashMap;
import java.util.Map;

/**
 * <pre>
 *  Map Interface
 *  - key/value를 쌍으로 하나의 요소로써 저장한다.
 *  - key란 ? 요소를 찾기위한 식별자 역할
 *      1. key는 중복을 허용하지 않는다.
 *      2. key가 중복된 값을 저장하면 기존값이 덮어써진다.
 *  - Value란 ? key식별자와 연결된 값. key가 다르다면 value의 중복이 가능하다.
 *
 *
 *  - 구현 클래스 HashMap, LinkedHashMap, TreeMap
 *  - legacy Class -> HashTable, Properties 중에서는 유일하게 Properties를 지금도 많이 사용한다.
 *      - key/value 타입을 모두 String으로 한정하므로써, 설정 정보 관리에 최적화 되어 있기 떄문이다.
 * </pre>
 */
public class App {
    public static void main(String[] args) {
//        HashMap map1 = new HashMap();
//        Map map2 = new HashMap();

        Map<String, Integer> map = new HashMap<>();

        //put(K,V) : 요소 저장
        map.put("홍길동", 23);
        map.put("신사임당", 30); //int -> Integer.valueOf(40) : Auto Boxing
        map.put("이순신", 50);

        //중복된 key로 저장
        Integer removed = map.put("홍길동", 33);
        System.out.println("removed = " + removed);
        //toString
        System.out.println(map);

        //get(k) : Value 값 가져오기
        Integer value = map.get("홍길동");
        System.out.println(value);

        //size() : int 요소(k-v)의 개수
        System.out.println(map.size());

        //remove(K) : Value 삭제
        System.out.println(map.remove("홍길동")); // key값으로 삭제하면 value값이 반환되고, 요소에서는 아예 삭제가 이루어짐
        System.out.println(map);// false 반환

        //contatinsKey() : boolean
        System.out.println(map.containsKey("홍길동"));
        //containsValue() : boolean
        System.out.println(map.containsValue(33));
    }
}

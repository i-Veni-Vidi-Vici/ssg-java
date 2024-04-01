package com.sh.collections._03.map;

import java.util.HashMap;
import java.util.Map;

/**
 * <pre>
 * Map 인터페이스
 * - key/value를 쌍으로 하나의 요소로써 저장한다.
 * - key란 ? 요소를 찾기 위한 식별자 역할
 *      1. key는 중복을 허용하지 않는다.
 *      2. key가 중복된 값을 저장하면, 기존값이 덮어써진다.
 * - value란? key식별자와 연결된 값. key가 다르다면 중복 가능하다.
 *
 * - 구현클래스 HashMap, LinkedHashMap, TreeMap 등이 있다.
 * - 레거시클래스 (HashTable, Properties) 중에서는 유일하게 Properties를 지금도 많이 사용하고 있다.
 *      - key/value 타입을 모두 String으로 한정하므로써, 설정정보 관리에 최적화되어 있기 때문이다.
 *
 * </pre>
 */
public class App {
    public static void main(String[] args) {
//        HashMap map1 = new HashMap();
//        Map map2 = new HashMap();

        Map<String, Integer> map = new HashMap<>();

        // put<K, V) 요소 저장
        System.out.println(map.put("홍길동", 23)); // null이 반환됐음
        map.put("신사임당", 50); // int -> Integer.valueOf(40) : auto-boxing처리
//        map.put(45, "이순신");

        // 중복된 key로 저장
        Integer removed = map.put("홍길동", 33); // 덮어쓰기
        System.out.println("removed = " + removed);

        // toString
        System.out.println(map); // {신사임당=50, 홍길동=23}

        // get(K):V 요소 가져오기 -> key를 가져오고 value를 반환한다
        Integer value = map.get("홍길동");
        System.out.println("홍길동 = " + value);

        // size():int 요소(k-v)의 개수
        System.out.println(map.size());

        // remove(K):삭제
        System.out.println(map.remove("홍길동"));
        System.out.println(map);

        // containsKey():boolean
        System.out.println(map.containsKey("홍길동")); // false

        // containsValue():boolean
        System.out.println(map.containsValue(33)); // false
    }
}

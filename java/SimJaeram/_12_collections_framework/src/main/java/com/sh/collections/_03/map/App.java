package com.sh.collections._03.map;

import java.util.HashMap;
import java.util.Map;

/**
 * <pre>
 *     Map 인터페이스
 *     - key/value를 쌍으로 하나의 요소로써 저장한다.
 *     - key란? 요소를 찾기 위한 식별자 역할을 한다.
 *          1. key는 중복을 허용하지 않는다.
 *          2. key가 중복된 값을 저장하면, 기존 값이 덮어써진다.
 *
 *     - value란? key 식별자와 연결된 값, key가 다르다면 value의 중복이 가능하다.
 *
 *     - 구현클래스 HashMap, LinkedHashMap, TreeMap
 *     - 레거시클래스 HashTable, Properties 중에서는 유일하게 Properties를 지금도 많이 사용하고 있다.
 *          // key/value의 타입을 모두 String으로 한정하므로써, 설정 정보 관리에 최적화 되어 있기 때문이다.
 *
 * </pre>
 */
public class App {
    public static void main(String[] args) {
//        HashMap map1 = new HashMap<>();         // 이름에 이처럼 Hash가 붙은 것은 HashCode로 관리하고 있다.
//        Map map2 = new HashMap();

        Map<String, Integer> map = new HashMap<>();

        // put(K, V) 요소 저장
        System.out.println(map.put("홍길동", 23)); // int -> Integer.valueOf(40) auto-boxing 처리, null
        map.put("신사임당", 40);
//        map.put(50, "이순신");                   // key, value 순서 맞춰서
        map.put("이순신", 50);

        // 중복된 key로 저장 시 덮어써진다. 리턴 값은 덮어써진 요소의 value이다. Set과 상이 주의
        // 중복되지 않으면 지워진 요소가 없으므로 null이 리턴된다.
        Integer removed = map.put("홍길동", 33);
        map.put("홍길동", 33);

        // toString
        System.out.println(map);                    // {신사임당=40, 홍길동=23, 이순신=50}

        // get(K):V 요소 가져오기
        Integer value = map.get("홍길동");
        System.out.println("홍길동 = " + value);

        // size():int 요소(k-v)의 개수
        System.out.println(map.size());

        // remove(K): 삭제, Key로 요소를 삭제한다, 리턴값은 value이다.
        System.out.println(map.remove("홍길동"));      // 33
        System.out.println(map);

        // containsKey():boolean, 홍길동이라는 키를 갖는 요소가 있는지
        System.out.println(map.containsKey("홍길동"));     // false

        // containsValue():booean
        System.out.println(map.containsKey(33));          // false
    }
}

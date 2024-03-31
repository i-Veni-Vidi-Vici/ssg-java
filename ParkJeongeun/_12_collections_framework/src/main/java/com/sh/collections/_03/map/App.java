package com.sh.collections._03.map;

import java.util.HashMap;
import java.util.Map;

/**
 * <pre>
 * Map 인터페이스
 * - key/value를 쌍으로 하나의 요소로써 저장
 * - key : 요소를 찾기위한 식별자 역할
 *   - key는 중복허용 X
 *   - key가 중복된 값을 저장하면, 기존값에 덮어써짐
 * - value : key식별자와 연결된 값, key가 다르면 중복가능
 *
 * 구현클래스 HashMap, LinkedHashMap, TreeMap
 * 레거시 클래스 (HashTable, Properties) 중에서는 유일하게 Properties를 지금도 많이 사용하고 있음
 *   - key/value 타입을 모두 String으로 한정함으로써, 설정정보 관리에 최적화 되어있기 때문
 * </pre>
 */
public class App {
    public static void main(String[] args) {
//        HashMap map1 = new HashMap();
//        Map map2 = new HashMap();

        Map<String, Integer> map = new HashMap<>();

        // 요소저장 put(K, V)
        map.put("홍길동", 23);
        map.put("신사임당", 40); // int값 집어넣으면 Integer.valueOf(40) 으로 auto boxing처리

        // 중복된 key 저장
        Integer removed = map.put("홍길동", 33);
        System.out.println(removed); // 23 (지워진 값 반환)

        // toString
        System.out.println(map); // {신사임당=40, 홍길동=23}

        // 요소 가져오기 get(K):V
        Integer value = map.get("홍길동");
        System.out.println(value); // 23

        // 요소(k-v) 개수 size():int
        System.out.println(map.size()); // 2

        // 삭제 remove(K)
        System.out.println(map.remove("홍길동")); // 33 (value 요소 반환)
        System.out.println(map);

        // 요소 확인 containsKey():boolean
        System.out.println(map.containsKey("홍길동")); // true

        // containsValue():boolean
        System.out.println(map.containsValue(33)); // true
    }
}

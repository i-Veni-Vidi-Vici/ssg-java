package collections._03.map;

import java.util.HashMap;
import java.util.Map;

/**
 * <pre>
 * Map 인터페이스
 * - key/value 를 쌍으로 하나의 요소로써 저장한다.
 * - key 란? 요소를 찾기 위한 식별자 역할
 *      1. key 는 중복을 허용하지 않는다.
 *      2. key 가 중복된 값을 저장하면, 기존 값이 덮어써진다.
 * - value 란? key 식별자와 연결된 값. key 가 다르다면 중복 가능하다.
 *
 * - 구현클래스 HashMap, LinkedHashMap, TreeMap
 * - 레거시 클래스 (HashTable, Properties) 중에서는 유일하게 Properties 를 지금도 많이 사용.
 *      - key/value 타입을 모두 String 으로 한정함으로써, 설정정보 관리에 최적화 되어있기 때문.
 * </pre>
 */
public class App {
    public static void main(String[] args) {
//        HashMap map1 = new HashMap();
//        Map map2 = new HashMap();

        Map<String, Integer> map = new HashMap<>();
        // put(K, V) 요소저장
        map.put("홍길동", 23);
        map.put("신사임당", 40); // int -> Integer.valueOf(40) auto-boxing 처리
//        map.put(50, "이순신");

        // toString
        System.out.println(map);

        // get(K):V 요소 가져오기
        Integer value = map.get("홍길동");
        System.out.println("홍길동 = " + value);

        // size():int 요소(k-v)의 개수
        System.out.println(map.size());

        // remove(K):V삭제
        System.out.println(map.remove("홍길동"));
        System.out.println(map);

        // containsKey():boolean
        System.out.println(map.containsKey("홍길동")); // true
        // containsValue():boolean
        System.out.println(map.containsValue(33)); // true
    }
}

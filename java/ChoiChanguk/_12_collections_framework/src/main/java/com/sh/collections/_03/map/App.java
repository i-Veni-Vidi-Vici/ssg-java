package com.sh.collections._03.map;

import java.util.HashMap;
import java.util.Map;

/**
 * <pre>
 * Map
 * - key/value를 쌍으로 저장한다.
 * - Key란? 요소를 찾기 위한 식별자 역할을 한다
 *   1. key는 중복을 허용하지 않는다.
 *   2. key가 중복된 값을 저장하면, 기존값이 덮어써진다.
 * - value란? key식별자와 연결된 값, key가 다르다면 중복이 가능하다
 *
 * - 구현클래스 HashMap, LinkedHashMap, TreeMap
 * - 레거시 클래스 (HashTable, Properties) 중에서는 유일하게 Properties를 지금도 많이 사용하고 있다.
 *    - Key/value 타입을 모두 String으로 한정하므로써, 설정정보 관리에 최적화 되어 있기 때문이다.
 *
 * </pre>
 */
public class App {
    public static void main(String[] args) {

        //앞에 hash가 붙으면 내부적으로 hash값을 쓴다
        //슈퍼클래스가 Map까지 밖에 없다
        //HashMap m1=new HashMap<>();

        Map<String ,Integer> map=new HashMap<>();

        //요소저장 put(K,V)
        map.put("홍길동", 23);
        map.put("신산임당", 40);// 자동으로 Integer.valueOf(40) auto-boxing처리
        map.put("이순신", 50);

        //toString 자동으로 오버라이딩 되어 있음
        System.out.println(map);

        //get(K):V 키값을 넣으면 value값이 나온다
        System.out.println(map.get("홍길동"));
        map.put("홍길동",6565);
        System.out.println(map.get("홍길동"));

        //size : int 요소의 개수(k-v) 쌍
        System.out.println(map.size());

        //containsKey:boolean
        System.out.println(map.containsKey("홍길동"));

        //containsValue:boolean
        System.out.println(map.containsValue(50));

        //remove
        map.remove("홍길동");
        System.out.println("제거 후 : "+map);

    }
}

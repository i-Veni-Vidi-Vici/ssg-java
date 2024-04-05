package com.sh.lambda._05.collection;

import java.util.Map;
import java.util.Objects;

/**
 * <pre>
 * Map에서 람다를 인자로 하는 메소드
 * </pre>
 */
public class App2 {
    public static void main(String[] args) {
        // 불변한 맵 객체 생성 (k, v모두 null값을 허용하지 않는다)
        // Map.of, List.of, Set.of jdk9부터 추가 Unmodifiable Collection을 반환
        // ->읽기 전용 Collection
        Map<Integer, String > map
                = Map.of(1,"홍길동",2,"신사임당",3,"이순신");

        //forEach(BiConsumer<>)
        map.forEach((k,v)-> System.out.println(k+"="+v));

        // conputerIfAbsent(K, Function<K,V>)
        map.computeIfAbsent(10,(k)->"세종대왕");
        map.computeIfAbsent(3,(k)->"이순신순신");

        //map.computeIfPresent(K,BiFunction(K,V));
        map.computeIfPresent(2,(k,v)->v+"사임당");


        System.out.println(map);
    }
}

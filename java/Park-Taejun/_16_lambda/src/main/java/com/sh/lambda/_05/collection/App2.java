package com.sh.lambda._05.collection;

import java.util.HashMap;
import java.util.Map;

/**
 * Map에서 람다를 인자로 하는 메소드
 */
public class App2 {
    public static void main(String[] args) {
        // 불변한 맵 객체 생성 (k, v 모두 null 값을 허용하지 않는다.)
        // Map.of, List.of, Set.of jdk9 부터 추가 Unmodifiable Collection 반환
//        Map<Integer, String> map = Map.of(1, "홍길동", 2, "신사임당",3, "이순신");
        Map<Integer, String> map = new HashMap<>();
        map.put(1, "홍길동");
        map.put(2, "신사임당");
        map.put(3, "이순신");
        //forEach(BiConsumer<>) // 인자를 2개 받고 리턴값은 없다
        map.forEach((k, v) -> System.out.println(k + " = " + v));

        // computeIfAbsent(K, Function<K V>)
        map.computeIfAbsent(10, (K) -> " 세종대왕"); // 존재하지 않는 값 키 10이 없으면 추가해줘라 있으면 말고잉!!
        map.computeIfAbsent(3, (K) -> " 이순신순신"); // 존재하는 값이므로 처리 x, 없을 때만 처리 됨

        // computeIfPresend(K, BiFunction<K, V, V>)
        map.computeIfPresent(2, (k,v) -> v + "사임당"); //얘는 존재하면 추가해주는 것이라고 하시네욤!!!!!!!!

        System.out.println(map);

        System.out.println(map);
    }
}

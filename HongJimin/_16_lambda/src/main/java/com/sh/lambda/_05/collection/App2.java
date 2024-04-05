package com.sh.lambda._05.collection;

import java.util.HashMap;
import java.util.Map;

/**
 * Map에서 람다를 인자로 하는 메소드
 */
public class App2 {
    public static void main(String[] args) {
        // 불변한 맵 객체 생성(k, v 모두 null값을 허용하지 않는다.)
//        Map<Integer, String> map = Map.of(1, "홍길동", 2, "신사임당", 3, "이순신");
        Map<Integer, String> map = new HashMap<>();
        map.put(1, "홍길동");
        map.put(2, "신사임당");
        map.put(3, "이순신");

        //forEach(BiConsumer<K, V>)
        map.forEach((k, v) -> System.out.println(k + " = " + v));

        //computeIfAbsent(K, Function,<K, V>)
        map.computeIfAbsent(10, (k) -> "세종대왕"); //없을 때만 처리됨
        map.computeIfAbsent(3, (k) -> "이순신순신");
        System.out.println(map); //{1=홍길동, 2=신사임당, 3=이순신, 10=세종대왕}

        //computeIfPresend(K, BiFunction<K, V, V>)
        map.computeIfPresent(2, (k, v) ->  v+ "사임당");
        System.out.println(map);//{1=홍길동, 2=신사임당사임당, 3=이순신, 10=세종대왕}
    }
}

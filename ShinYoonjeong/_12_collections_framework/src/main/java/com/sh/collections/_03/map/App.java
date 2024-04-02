package com.sh.collections._03.map;

import java.util.HashMap;
import java.util.Map;

public class App {
    public static void main(String[] args) {
        Map<String, Integer> map = new HashMap();

        map.put("홍길동", 23);
        map.put("신사임당", 40); // int -> Integer.valueOf(40) auto-boxing 처리

        // 중복된 key로 저장
        Integer removed = map.put("홍길동", 33);

        // toString
        System.out.println(map);

        // get(k):v 요소 가져오기
        Integer value = map.get(("홍길동"));
        System.out.println("홍길동 = " + value);

        // size():int 요소의 개수
        System.out.println(map.size());
        // remove(k):V삭제
        System.out.println(map.remove("홍길동"));
        System.out.println(map);

        // containsKey():boolean
        System.out.println(map.containsKey("홍길동"));
        // containsValue():boolean
        System.out.println(map.containsValue(33));

    }

}

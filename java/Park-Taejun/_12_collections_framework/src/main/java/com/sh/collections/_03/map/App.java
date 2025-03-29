package com.sh.collections._03.map;

import java.util.HashMap;
import java.util.Map;

public class App {
    public static void main(String[] args) {
//        HashMap map1 = new HashMap();
//        Map map2 = new HashMap();

        Map<String, Integer> map = new HashMap<>(); //타입 두개를 보내야 함

        // put(K, V)요소저장
        System.out.println(map.put("홍길동", 23));
        map.put("신사임당", 30); // int -> Integer.valueOf(40) auto-boxing 처리가됨
//        map.put("이순신", 50);

        //중복된 key로 저장
        Integer removed = map.put("홍길동", 33);
        System.out.println("removed : " + removed);

        System.out.println(map);

        //get(k) : V 요소 가져오기 KEY 를 전달하고 V 를 받아옴
        Integer value = map.get("홍길동");
        System.out.println("홍길동 = " + value);

        // size() : int 요소 ( k-v)의 개수
        System.out.println(map.size());

        // remove(k):V 삭제
        System.out.println(map.remove("홍길동"));
        System.out.println(map);

        // containsKey() : boolean
        System.out.println(map.containsKey("홍길동"));

        System.out.println(map.containsValue(33));

    }

}

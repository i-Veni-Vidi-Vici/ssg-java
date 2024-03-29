package com.sh.collections._03.map;

import java.util.*;

public class App {
    public static void main(String[] args) {
//    HashMap map1 = new HashMap<>();
//    Map map2 = new HashMap();
        Map<String, Integer> map = new HashMap<>();
        //put(K, V) 요소저장
        map.put("홍길동", 23); //중복된 값이 아니면 null 반환
        map.put("신사임당", 40);    //int -> Integer.valueOf(40)

        System.out.println(map);
        //중복된 키로 저장
        Integer removed = map.put("홍길동", 33); //중복이면 덮어씌움 23->33
        //삭제된 값이 반환 된다. removed = 23
        System.out.println("removed = "+removed);

        System.out.println(map);

        Integer value = map.get("홍길동");
        System.out.println("홍길동 = " + value);

        System.out.println(map.size()); //size
        System.out.println(map.containsKey("홍길동")); //true
        System.out.println(map.containsValue(33)); //true
        map.remove("홍길동");
        System.out.println(map);
        map.clear();    //모든 요소 삭제
        System.out.println(map);

    }
}

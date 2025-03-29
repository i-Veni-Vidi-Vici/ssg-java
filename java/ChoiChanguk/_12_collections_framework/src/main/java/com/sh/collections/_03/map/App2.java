package com.sh.collections._03.map;

import java.awt.desktop.AboutEvent;
import java.security.Key;
import java.util.*;

/**
 * <pre>
 *  1. ketSet()를 이용
 *  2. entrySet()를 이용
 *
 * </pre>
 */
public class App2 {
    public static void main(String[] args) {
        Map<String ,Double>map=new HashMap<>();
        map.put("one",1.23456);
        map.put("two",2.23456);
        map.put("three",3.23456);
        map.put("four",4.23456);
        map.put("five",5.23456);
        map.put("six",6.23456);

        System.out.println(map);

        //map은 for each는 안된다
        //1. keySet으로 관리한다
        Set<String> keyset = map.keySet();// 키값들을 모아둿다 = 그럼 String이겟다
        System.out.println(keyset);

        //1-1 for..each
        for(String str: keyset) {
            Double v = map.get(str);//이 맵에 키값을 넣으니 value값을 반환한다
        }

        //1-2 Iterator
        Iterator<String >iteratorStrint=keyset.stream().iterator();
//        while (iteratorStrint.hasNext()) {
//            String key=iterator.next();
//        }

        //2. entrySet() : Set<Entry> -> K,V를 묵은 타입 Node의 부모인터페이스
        Set<Map.Entry<String, Double>> entrySet = map.entrySet();// 이건 엔트리 set까지 묶은거
        //2-1 for each
        System.out.println("-------for each--------");
        for( Map.Entry<String,Double> entry : entrySet)
        {
            String key=entry.getKey();
            double value=entry.getValue();
            System.out.println(key +" "+value);
        }
        // 2-2. iterator
        Iterator<Map.Entry<String ,Double>> iterator=map.entrySet().iterator();
        //Iterator로 할껀데 지금 맵안에 있는 키+값을=서브클래스 메소드인 entry로 묶을거고
        //여기는 Entry로 담겨질 애들 = 여기서 Map에서 entry로 묶이는 애들
        // MAP안에 있는 key+value이거를 엔트리로 묶고 -> MAP을 나오면 엔트리 묶음이다
        // 키셋=MAP안에 있는 키값만들 묶은 애들을 따로 자리를 만든다

        //set을 순회하는 방법 = for each, Iterator
        System.out.println("-------iterator while문-------");
        while(iterator.hasNext())
        {
            Map.Entry<String, Double> entry=iterator.next();
            String key=entry.getKey();
            Double value=entry.getValue();
            System.out.println(key+"   "+value);
        }

        Collection<Double> values = map.values();
        System.out.println("-------value값만,  중복이 있을 수 있다-------");
        for(Double val:values)
        {
            System.out.println(val);
        }
    }
}

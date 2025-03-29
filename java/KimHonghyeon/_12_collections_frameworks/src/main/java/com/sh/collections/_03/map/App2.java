package com.sh.collections._03.map;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

public class App2 {
    public static void main(String[] args) {
        Map<String, Double> map = new HashMap<>();
        map.put("one", 1.234);
        map.put("two", 2.345);
        map.put("three", 3.456);
        Set<String> keySet = map.keySet();
        Iterator iter = keySet.iterator();
        while(iter.hasNext()){
            System.out.println(map.get(iter.next()));
        }
        Set<Map.Entry<String, Double>> entrySet = map.entrySet();
        Iterator iter2 = entrySet.iterator();
        while(iter2.hasNext()){
            System.out.println(iter2.next());
        }
    }
}

package com.sh.collections._03.map;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

/**
 * 1.KeySet()를 이용
 * 2.entrySet()를 이용
 *
 */
public class App2 {
    public static void main(String[] args) {
        Map<String,Double> map = new HashMap<>();
        map.put("one",1.2345);
        map.put("two",2.2345);
        map.put("three",3.2345);
        map.put("four",4.2345);
        map.put("five",5.2345);
        System.out.println(map);

        //for(?? elem:map){}//map 자체를 foreach 접근할 수 없다.
        //1.keySet
        Set<String> keySet = map.keySet();
        System.out.println(keySet);
        for(String key : keySet){
            Double value = map.get(key);
            System.out.println(key+" = "+value);
        }




        Set<Map.Entry<String,Double>> entrySet = map.entrySet();
        System.out.println(entrySet);



       //2-1 foreach
      //  for(Map.Entry<String,Double>entry: map.entrySet(){
       //     String key = entry.getKey();
        //    Double value = entry.getValue();
         //   System.out.println(key+ "=" + value);
       // }

    }
}

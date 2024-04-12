package com.sh.collections._02.set;

import java.util.*;

/**
 *<pre>
 *  LinkedHashSet - 저장한 순서를 유지
 *  TreeSet  - 정렬을 지원
 *</pre>
 */
public class App4 {
    public static void main(String[] args) {
        Set<String> set1 = new LinkedHashSet<>();
        set1.add("아메리카노");
        set1.add("카페라떼");
        set1.add("플랫화이트");

        for(String name : set1){
            System.out.println(name);
        }

        Set<String> set2 = new TreeSet<>();
        set2.add("Americano");
        set2.add("Latte");
        set2.add("Flat White");
        set2.add("Latte");
        System.out.println(set2);


        //로또 번호 생성하기 1-45사이의 중복없는 숫자 6개를 오름차순으로 정렬해서 출력
        Set<Integer> set = new TreeSet<>();
        Random rnd = new Random();
        int n ;

        for(int i = 0; i<set.size(); i++){
            n = rnd.nextInt(45) + 1;
            set.add(n);
            if(set.size() == 6) break;

        }
        System.out.println(set);
    }
}

package com.sh.collections._02.set;

import java.util.*;

public class App4 {
    public static void main(String[] args) {
        Set<String> set2 = new TreeSet<>();
        set2.add("Latte");
        set2.add("Americano");
        set2.add("Flat White");
        System.out.println(set2);   // [Americano, Flast White, Latte]

        //로또번호 생성하기 (1~45 사이의 중복 없는 숫자 6개를 오름차순 정렬해서 출력

        Set<Integer> set3 = new TreeSet<>();
        while(set3.size()<6){
            set3.add((int)(Math.random()*45+1));
        }
        System.out.println(set3);
    }

}

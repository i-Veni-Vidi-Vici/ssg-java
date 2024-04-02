package com.sh.collections._02.set;

import java.util.LinkedHashSet;
import java.util.Set;
import java.util.TreeSet;

/**
 * LinkedHashSet - 저장한 순서를 유지해줌
 * TreeSet
 */

public class App4 {
    public static void main(String[] args) {
        Set<String> set1 = new LinkedHashSet<>();
        set1.add("아메리카노");
        set1.add("카페라떼");
        set1.add("플랫치노");
        System.out.println(set1);

        for (String name : set1)
            System.out.println(name);

        Set<String> set2 = new TreeSet<>();
        set2.add("Americano");
        set2.add("Latte");
        set2.add("Flatchino");

        System.out.println(set2); // [Americano, Flat WhITE, Latte]

        // 로또 번호 생성하기 (1~45 사이의 중복없는 숫자 6개를 오름차순 정렬해서 출력)

        Set<Integer> lottoSet = new TreeSet<>();
        for (;lottoSet.size() < 6;) {
            lottoSet.add((int) (Math.random() * 45) + 1);

        }
        System.out.println(lottoSet);



    }
}

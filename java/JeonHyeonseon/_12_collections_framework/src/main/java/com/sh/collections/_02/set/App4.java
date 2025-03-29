package com.sh.collections._02.set;

import java.util.LinkedHashSet;
import java.util.Random;
import java.util.Set;
import java.util.TreeSet;

/**
 * <pre>
 * LinkedHashSet - 저장한 순서를 유지해주는 것
 * TreeSet - 정렬을 지원하는 것
 * </pre>
 */
public class App4 {
    public static void main(String[] args) {
        Set<String> set1 = new LinkedHashSet<>();
        set1.add("아메리카노");
        set1.add("라떼");
        set1.add("플랫화이트");
        System.out.println(set1);

        for(String name : set1)
            System.out.println(name);  // 저장한 순서대로 꺼내올 수 있다.

        Set<String> set2 = new TreeSet<>();
        set2.add("Latte");
        set2.add("Americano");
        set2.add("Flat White");
        System.out.println(set2); // [Americano, Flat White, Latte], 정렬해서 출력

        // 로또 번호 생성하기 (1 ~ 45 사이의 중복없는 숫자 6개를 오름차순 정렬해서 출력)
        Set<Integer> lottoSet = new TreeSet<>();
        while(lottoSet.size() < 6) {
            lottoSet.add((int)(Math.random() * 45) + 1);
        }
        System.out.println(lottoSet);

    }
}

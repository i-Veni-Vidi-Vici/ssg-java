package com.sh.collections._02.set;

import java.util.LinkedHashSet;
import java.util.Random;
import java.util.Set;
import java.util.TreeSet;

/**
 * <pre>
 * LinkedHashSet - 저장한 순서를 유지
 * TreeSet - 정렬을 지원
 * </pre>
 *
 */
public class App4 {
    public static void main(String[] args) {
        Set<String> set1 = new LinkedHashSet<>();
        set1.add("아메리카노");
        set1.add("라떼");
        set1.add("플랫화이트");
        System.out.println(set1);
        for(String name : set1)
            System.out.println(name);
        Set<String> set2 = new TreeSet<>();
        set2.add("Americano");
        set2.add("Latte");
        set2.add("Flat White");
        System.out.println(set2);

        Set<Integer> lottoNums = new TreeSet<>();
        while (lottoNums.size() < 6) {
            lottoNums.add((int)(Math.random() * 45) + 1);
        }

        for (int num : lottoNums) {
            System.out.println(num);
        }
    }
}

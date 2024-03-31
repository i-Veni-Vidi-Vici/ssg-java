package com.sh.collections._02.set;

import java.util.LinkedHashSet;
import java.util.Set;
import java.util.TreeSet;

/**
 * LinkedHashSet - 저장한 순서를 유지
 */
public class App4 {
    public static void main(String[] args) {
        Set<String> set1 = new LinkedHashSet<>();
        set1.add("아메리카노");
        set1.add("라떼");
        set1.add("플레인");
        System.out.println(set1);
        for (String name : set1) {
            System.out.println(name);
        }

        Set<String> set2 = new TreeSet<>();
        set2.add("a");
        set2.add("b");
        set2.add("c");
        System.out.println(set2);
        for (String E : set2) {
            System.out.println(E);
        }

        // 로또 번호 생성하기
        Set<Integer> lottoNumSet = new TreeSet<>();
        while (lottoNumSet.size() < 6) {
            lottoNumSet.add((int)(Math.random() * 45) + 1);
        }
        System.out.println(lottoNumSet);
    }
}

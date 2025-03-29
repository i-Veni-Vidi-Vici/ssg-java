package com.sh.collections._02.set;

import java.util.LinkedHashSet;
import java.util.Random;
import java.util.Set;
import java.util.TreeSet;

/**
 * <pre>
 * LinkedHashSet - 저장한 순서 유지
 * TreeSet - 정렬을 지원
 * </pre>
 */

public class App4 {
    public static void main(String[] args) {
        Set<String> set1 = new LinkedHashSet<>();
        set1.add("아메리카노");
        set1.add("카페라떼");
        set1.add("플랫화이트");
        System.out.println(set1); // 순서대로 잘나옴.

        for(String name: set1)
            System.out.println(name);

        Set<String> set2 = new TreeSet<>();
        set2.add("CafeLatte");
        set2.add("Americano");
        set2.add("FlatWhite");
        System.out.println(set2); // TreeSet 정렬해줌. [Americano, CafeLatte, FlatWhite]

        // 로또 번호 생성하기 (1~45 사이의 중복없는 숫자 6개를 오름차순 정렬해서 출력)
        Random rnd = new Random();
        Set<Integer> lottoNum = new TreeSet<>();
        while (lottoNum.size() < 6)
            lottoNum.add(rnd.nextInt(45) + 1);
        System.out.println(lottoNum);

//        Set<Integer> lottoSet = new TreeSet<>();
//        for(; lottoSet.size() < 6;){
//            lottoSet.add((int)(Math.random() * 45) + 1);
//        }
//        System.out.println(lottoSet);
//        //강사님꺼

    }
}

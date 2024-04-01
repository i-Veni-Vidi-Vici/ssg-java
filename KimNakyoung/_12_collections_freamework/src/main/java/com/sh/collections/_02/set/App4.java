package com.sh.collections._02.set;

import java.util.LinkedHashSet;
import java.util.Random;
import java.util.Set;
import java.util.TreeSet;

/**
 * <pre>
 * LinkedHashSet - 저장한 순서를 유지
 * TreeSet - 정렬을 지원
 *
 * </pre>
 *
 *
 */
public class App4 {
    public static void main(String[] args) {
        Set<String> set1 = new LinkedHashSet<>();
        set1.add("아메리카노");
        set1.add("라떼");
        set1.add("플랫화이트");
        System.out.println(set1);

        for (String s : set1) {
            System.out.println(s);

            Set<String> set2 = new TreeSet<>();
            set2.add("Americano");
            set2.add("latte");
            set2.add("Flat White");
            System.out.println(set2);

            //로또 번호 생성하기 ( 1~ 45사이의 중복없는 숫자 6개를 오름차순 정렬해서 출력)
            //set을 쓰면 중복 알아서 제거!

            // 6번 돌리면 부족할 수도 왜냐면 중복제거하면 횟수는 차감이니까
//            Set<Integer> lottoNums = new TreeSet<>();
////            for (int i = 0; i < 6; i++) {
////                lottoNums.add((int) (Math.random() * 45) + 1);
////            }
////            System.out.println(lottoNums);

            Set<Integer> setLotto = new TreeSet<>();
            while (setLotto.size() < 6) {
                setLotto.add((int)(Math.random() * 45) + 1);
            }

            for (Integer lottoNum : setLotto) {
                System.out.println(lottoNum);

            }
            // 이름
            //List -> nameLsit,names
            // [] -> nameArr,names
            // Set -> nameSet
            // Map -> studentMap


        }

    }
}

package com.sh.collections._02.set;

import java.util.HashSet;
import java.util.Set;
import java.util.TreeSet;

/**
 * <pre>
 * LinkedHashSet - 저장한 순서를 유지
 * TreeSet - 정렬을 지원한다
 * </pre>
 */
public class App4 {
    public static void main(String[] args) {
        Set<String> set1=new HashSet<>();
        set1.add("아메리카노");
        set1.add("헤이즐넛 아메리카노");
        set1.add("플랫화이트");
        System.out.println(set1);

        for(String str:set1)
        {
            System.out.println(str);
        }

        Set<String>set2=new TreeSet<>();
        set2.add("Americano");
        set2.add("latte");
        set2.add("flat White");
        System.out.println(set2);

        for(String str:set2)
            System.out.println(str);

        //로또 번호 생성하기(1~45 중복없는 숫자 6개 오름차순)
        int random=(int)(Math.random()*45)+1;

        Set<Integer> lotto=new HashSet<>();

        //for문은 6번 돌면 떙이지만, 이건 중복은 들어가기 때문에
        //6번 돌렷는데 2개가 중복이면, 4개만 들어가있다
        //그러니 사이즈로 판별을 한다, 사이즈가 6개가 될 때까지 돌린다
        while (lotto.size()<6) {
            lotto.add((int)(Math.random()*45)+1);
        }
        System.out.println(lotto);
    }
}

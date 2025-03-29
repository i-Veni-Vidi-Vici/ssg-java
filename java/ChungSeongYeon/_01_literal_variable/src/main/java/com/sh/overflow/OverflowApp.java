package com.sh.overflow;

/**
 * <pre>
 * overflow
 * - 자료형별로 표현할 수 있는 최대값을 벗어나면 다시 최소값을 순환 처리하는 것
 *
 *
 * </pre>
 *  */

public class OverflowApp {

    public static void main(String[] args){

        int i = Integer.MAX_VALUE; // 2_147_483_647
//        i = i + 1; // 좌항의 공간에 우항의 결과값을 대입.
          // 범위가 -2_147_483_648 ~ 2_147_483_647 이어서 -2_147_483_648로 순환처리
        i = i + 2; //-2_147_483_647로 순환처리
        System.out.println(i);

        int j = Integer.MIN_VALUE;
        j = j - 1;
        System.out.println(j); // 순환처리되면 -2_147_483_648보다 작아지니까 2_147_483_647가 나올 듯.(O)


    }

}

package com.sh.loop._while;

import java.util.Scanner;

/**
 * <pre>
 * while 표현식
 *
 * 초기식;
 * while(조건식){
 *     // 반복실행구문
 *     증감식;
 * }
 * </pre>
 */

public class While {
    public void test() {
        // 1 ~ 10 출력
//        int i = 1;
//        while (i <= 10){
//            System.out.println(i);
//            i++;
//        }

        // 10 ~ 1 출력
//        int i = 10;
//        while (i > 0){
//            System.out.println(i);
//            i--;
//        }

        // 1 ~ 20까지 중에서 짝수 출력
        int i = 2;
        while (i <= 20) {
            System.out.println(i);
            i += 2;
        }
    }

    /**
     * 1 ~ 10 누적합 구하기
     */

    public void test2(){
        int sum = 0;
        int i = 1; // 초기식
//        while (i <= 10){ // 조건식
//            sum += i; // 반복실행구문
//            i++; // 증감식
//        }
        while (i <= 10){ // 조건식
            sum += i++; // 반복실행구문 + 증감식 /i++이 후위증감식이어서 가능
        }
        System.out.println(sum);
    }

    /**
     * 문자열에 인덱스별로 접근하기
     *
     */
    public void test3(){
        Scanner sc = new Scanner(System.in);
        System.out.println("아무말이나 적으세요 : ");
        String str = sc.nextLine();
        int i = 0;
        while (i < str.length()){
            char ch = str.charAt(i);
            System.out.println(ch);
            i++;
        }
    }

    /**
     * 구구단 2 ~ 9단
     */
    public void test4(){
        int i = 2;
        while (i <= 9) {
            int j = 1;
            while (j <= 9){
                System.out.printf("%d * %d = %d\n", i, j, i * j);
                j++;
            }
            i++;
            System.out.println();
        }
    }
}

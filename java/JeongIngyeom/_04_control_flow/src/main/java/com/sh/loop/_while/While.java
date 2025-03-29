package com.sh.loop._while;

import java.util.Scanner;

/**
 * <pre>
 * while표현식
 *
 * 초기식;
 * while(조건식){
 *     반복실행구문
 *
 *     증감식
 * }
 * </pre>
 */
public class While {

    public void test1() {
//        // 1~10 출력
//        int i = 1;
//        while (i <= 10) {
//            System.out.println(i);
//            i++;
//        }

//        // 10~1 출력
//        int i = 10;
//        while (i >= 1) {
//            System.out.println(i);
//            i--;
//        }

        // 1~20 짝수만 출력
        int i = 2;
        while (i <= 20) {
            System.out.println(i);
            i += 2;
        }
    }

    /**
     * 누적합 구하기
     */
    public void test2() {
        int sum = 0;
        int i = 1;
//        while (i <= 10) {
//            sum += i;
//            i++;
//        }

        while (i <= 10) {
            sum += i++;
        }
        System.out.println(sum);
    }

    /**
     * 문자열에 인덱스별로 접근하기
     * - "apple"
     */
    public void test3() {
        Scanner sc = new Scanner(System.in);
        System.out.println("아무말이나 하세요....");
        String str = sc.nextLine();

        // 마지막 인덱스는 글자수-1과 동일하다.
        int i = 0;
        while (i < str.length()) {
            System.out.println(str.charAt(i++));
        }
    }

    /**
     * 구구단 2단~9구단 출력하기
     */
    public void test4() {
        int i = 2;
        while (i <= 9) {
            int j = 1;
            while (j <= 9) {
                System.out.printf("%d x %d = %d\n", i, j, i * j);
                j++;
            }
            System.out.println();
            i++;
        }
    }
}

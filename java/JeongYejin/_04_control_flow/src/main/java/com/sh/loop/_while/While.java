package com.sh.loop._while;

import java.util.Scanner;

/**
 * <pre>
 * while 표현식
 *
 * 초기식;
 * while(조건식){
 *     //반복실행구문
 *
 *     증감식;
 * }
 * </pre>
 */
public class While {
    public void test1() {
        // 1 ~ 10 출력
//        int i = 1;
//        while (i <= 10) {
//            System.out.println(i);
//            i++;
//        }
        // 10 ~ 1 출력
//        int i = 10;
//        while (i > 0) {
//            System.out.println(i);
//            i--;
//        }

        // 2 4 6 8 10 12 14 16 18 20
        int i = 2;
        while (i <= 20) {
            System.out.printf("%d ", i);
            i += 2;
        }
    }

    /**
     * 1 ~ 10 누적합 구하기
     */
    public void test2() {
        int sum = 0;
        int i = 1; // 초기식
        while (i <= 10) { // 조건식
            sum += i; // 반복실행
            i++; //증감식
        }
        while (i <= 10) {
            sum += i++; // sum = sum + i++
        }
        System.out.println(sum);
    }

    /**
     * 문자열에 인덱스별로 접근하기
     * - "apple"
     */

    public void test3() {
        Scanner sc = new Scanner(System.in);
        String str = "apple";
        System.out.println("아무말이나 하세요...!");
        str = sc.nextLine();
        int i = 0;
//        while (i <= 5) { // StringIndexOutOfBoundsException
        while (i < str.length()) {
            char ch = str.charAt(i);
            System.out.println(i + " : " + ch);
            i++;
        }
    }

    public void test4() {
        int dan = 2;
        while (dan <= 9) {
            System.out.printf("\t%d단\n",dan);
            int n = 1;
            while (n <= 9) {
                System.out.printf("%d * %d = %d\n", dan, n, dan*n);
                n++;
            }
            System.out.println();
            dan++;
        }
    }
}
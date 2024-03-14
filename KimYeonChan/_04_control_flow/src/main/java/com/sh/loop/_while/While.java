package com.sh.loop._while;

import java.util.Scanner;

/**
 * while 표현식
 * 초기식;
 * while (조건식) {
 *     // 반복 실행구문
 *     증감식
 * }
 */
public class While {
    // 1~10
    public void test1() {
//        int i = 1;
//        while (i <= 10) {
//            System.out.println(i);
//            i++;
//        }

//        int i = 10;
//        while (i >= 1) {
//            System.out.println(i);
//            i--;
//        }

        int i = 2;
        while (i <= 20) {
            System.out.println(i);
            i += 2;
        }
    }

    public void test2() {
        int sum = 0;
        int i = 1;
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
        System.out.print("문자열 입력: ");
        String str = sc.nextLine();
        int i =0;
        while (i < str.length()) {
            System.out.println(str.charAt(i));
            i++;
        }
    }

    /**
     * 구구단 2~9
     */
    public void test4() {
        int i = 2;

        while (i <= 9) {
            System.out.printf("===%d단===\n", i);
            int j = 1;
            while (j <= 9) {
                System.out.printf("%d * %d = %d\n", i, j, i * j);
                j++;
            }
            i++;
        }
    }
}

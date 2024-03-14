package com.sh._while;

import java.util.Scanner;

/**
 * while 표현식
 *
 * 초기식
 * while(조건식){
 *
 *     //반복실행구문
 *     증감식
 * }
 */
public class While {

    public void test1() {
//        // 1 ~ 10출력
//        int i = 1;
//        while (i <=10){
//            System.out.println(i);
//            i ++;
//        }
//    }

        // 2 4 6 8 10 12 14 16 18 20 출력
        int i = 2;
        while (i <= 20) {
            System.out.println(i);
            i += 2;
        }



    }
    /**
     * 1 ~ 10 누적합 구하기
     */
    public void test2() {
        int sum = 0;
        int i = 1;
        while (1 <= 10) {
            sum += 1;
            i++;

        }

    }

    /**
     * 문자열에 인덱스별로 접근하기
     * - "apple"
     */
    public void test3(){
        Scanner sc = new Scanner(System.in);
        System.out.println("아무말이나 하세요....");
        // 마지막 인덱스는 글자수 - 1과 동일하다.
        String str = sc.nextLine();
        int i = 0;
        while (i<str.length()){
           char ch = str.charAt(i);
            System.out.println(i + " : " + ch);
            i++;

        }

    }

    public void test4(){
        int dan = 2;
        while (dan < 10){
            System.out.printf("------%d단----\n", dan);
            int n = 1;
            while (n <= 9){
                System.out.printf("%d * %d = %d\n", dan, n, dan * n);
                n++;

            }
            dan ++;
        }


    }
}









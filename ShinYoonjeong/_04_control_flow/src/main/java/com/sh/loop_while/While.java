package com.sh.loop_while;

import java.util.Scanner;

/**
 * while표현식
 *
 * whrltlr;
 * while(조건식){
 *     //반복실행구문
 *
 *     증감식;
 * }
 */
public class While {
    public void test1(){
        // 1 ~ 10 출력
        int i = 1;
        while(i <= 10){
            System.out.println(2*i);
            i++;

        }

    }

    /**
     * 1 ~ 10 누적합 구하기
     */
    public void test2(){
        int sum = 0;
        int i = 1; // 초기식
        while(i <= 10){ // 조건식
        //    sum += i; // 반복실행
            //            i++; // 증감식
            sum += i++; // sum = sum + i++
        }
        System.out.println(sum);
    }

    /**
     * 문자열에 인덱스별로 접근하기
     * - "apple"
     */
    public void test3(){
        Scanner sc = new Scanner(System.in);
        System.out.println("아무말이나 하세요...");
        // 마지막 인덱스는 글자수 -1과 동일하다.
        String str = sc.nextLine();
        int i = 0;
        while(i<str.length()){
            char ch = str.charAt(i);
            System.out.println(i + " : " + ch);
            i++;

        }
    }
    public void test4(){
        int i=2;
        while(i<=9)
        {
            int j=1;
            while(j<=9)
            {
                System.out.printf("%d * %d = %d\n", i, j, i*j);
                j++;

            }
            i++;

        }
    }
}

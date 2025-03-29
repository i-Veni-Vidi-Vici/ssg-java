package com.sh.loop._while;

import java.util.Scanner;

/**
 * <pre>
 * while표현식
 * 
 * 초기식;
 * while(조건식){
 *     // 반복실행구문
 *
 *     증감식;
 * }
 *
 * </pre>
 */
public class While {
    public void test1() {
        // 1 ~ 10 출력
//        int i = 1;
//        while(i <= 10){
//            System.out.println(i);
//            i++;
//        }

        // 10 ~ 1 출력
//        int i = 10;
//        while(i > 0){
//            System.out.println(i);
//            i--;
//        }
        
        // 2 4 6 8 10 12 14 16 18 20 출력
        int i = 2;
        while(i <= 20){
            System.out.println(i);
            i += 2;
        }
    }

    /**
     * 1 ~ 10누적합 구하기
     */
    public void test2(){
        int sum = 0;
        int i = 1; // 초기식
//        while(i <= 10){ // 조건식
//            sum += i; // 반복실행
//            i++; // 증감식
//        }
        while(i <= 10) {
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
        System.out.println("아무말이나 하세요....");
        // 마지막 인덱스는 글자수 - 1과 동일하다.
        String str = sc.nextLine();
        System.out.println(str.length()); // 문자열의 길이 반환
        int i = 0;
        while(i < str.length()){
            char ch = str.charAt(i);
            System.out.println(i + " : " + ch);
            i++;
        }
    }

    /**
     * 구구단 2 ~ 9단 while문으로 출력하기
     *
     */
    public void test4() {
        int dan = 2;
        while(dan <= 9){
            System.out.printf("----%d단----\n", dan);
            int n = 1;
            while(n <= 9){
                System.out.printf("%d * %d = %d\n", dan, n, dan * n);
                n++;
            }
            System.out.println();
            dan++;
        }
    }
}

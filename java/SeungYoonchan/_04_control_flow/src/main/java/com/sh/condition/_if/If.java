package com.sh.condition._if;

import java.util.Scanner;

/**
 * <pre>
 *     if 표현식
 *     if (조건식){
 *         // 조건식이 true인 경우 실행코드
 *     }
 * </pre>
 */
public class If {
    public void test() {
        Scanner sc = new Scanner(System.in);
        System.out.println("> 정수 입력하세요.");
        // 짝수 입력값인 경우
        int num = sc.nextInt();
        if (num % 2 == 0) {
            System.out.println("🎉🎉🎉");
        }
        if(num<0){
            System.out.println("🎉🎉🎉");
        }
        System.out.println("종료");
    }
    public void test2(){
        Scanner sc = new Scanner(System.in);
        System.out.println("> 정수 입력하세요.");
        // 짝수 입력값인 경우
        int num = sc.nextInt();

        if(num>0){
            if (num % 2 == 0) {
                System.out.println("양수 & 짝수");
            }
            System.out.println("홀수");
        }
        System.out.println("프로그램 종료");
    }
}

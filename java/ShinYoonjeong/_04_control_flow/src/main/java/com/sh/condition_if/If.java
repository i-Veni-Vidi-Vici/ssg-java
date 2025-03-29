package com.sh.condition_if;

import java.util.Scanner;

/**
 * if 표현식
 * if(조건식){
 *     // 조건식이 true인 경우 실행코드
 * }
 */
public class If {
    public void test() {
        // 짝수 입력값인 경우에만 빵빠레
        Scanner sc = new Scanner(System.in);
        System.out.println("> 정수 입력하세요.");
        int num = sc.nextInt();
        // 짝수 일때 true를 반환하는 조건식
        if(num % 2 == 0){
            System.out.println("짝수 🎉🎉🎉");
        }
        // 음수 일때 빵빠레
        if(num < 0){
            System.out.println("음수 ✨✨✨");
        }
        System.out.println("프로그램 종료!!!");


    }

    /**
     * 중첩 if문
     */
    public void test2(){
        Scanner sc = new Scanner(System.in);
        // 사용자 입력 정수, 양수 이면서, 짝수인지 체크
        System.out.println("> 정수 입력 : ");
        int num = sc.nextInt();
        if(num > 0){
            if(num % 2 == 0){
                System.out.println("양수 & 짝수 🐱‍🏍🐱‍🏍🐱‍🏍");


            }
        }
        System.out.println("프로그램 종료!!!");
    }
}

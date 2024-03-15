package com.sh.condition._if;

import java.util.Scanner;

public class If {
    public void test(){
        Scanner sc = new Scanner(System.in);
        System.out.println("> 정수 입력하세요.");
        //짝수 입력값인 경우에만 빵빠레!
        int num = sc.nextInt();
        //짝수 일때 true를 반환하는 조건식
        if(num % 2 == 0){
            System.out.println("짝수 짝짝짝");
        }
        //음수이면 빵빠레
        if(num < 0){
            System.out.println("음수입니다");
        }

        System.out.println("프로그램 종료!!!");

    }
    /**
     * 중첩 if문
     *
     */
    public void test2(){
        Scanner sc = new Scanner(System.in);
        System.out.println(">정수 입력 : ");
        int num = sc.nextInt();
        //정수, 양수, 짝수 체크
        if(num > 0){
            if(num % 2 == 0){
                System.out.println("양수&짝수");
            }
        }
        System.out.println("프로그램 종료!!");
    }
}

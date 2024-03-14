package com.sh.condition._if;

import java.util.Objects;
import java.util.Scanner;

/**
 * if-else 표현식
 *
 * if(조건식){
 *     // 조건식이 true인 경우 실행코드
 * }
 * else{
 *     //조건식이 false인 경우 실행코드
 * }
 * 실행블럭의 코드가 단 한줄인 경우만 {}블럭을 생략할 수 있다.
 */
public class IfElse {
    public void test() {
        Scanner sc = new Scanner(System.in);
        // 사용자 입력 정수 홀수/짝수 구분
        System.out.println("> 정수 입력 : ");
        int num = sc.nextInt();

        // num % 2 == 1, num % 2 != 0
        if(num % 2 == 1){
            // 조건식이 false : 홀수일 때 실행코드
            System.out.println("홀수입니다!!! 🎉🎉🎉");
        }
        else {
            // 조건식이 true : 짝수일 때 실행코드
            System.out.println("짝수입니다!! 👌👌👌");
        }
        System.out.println("프로그램 종료!!!");
    }

    /**
     * 사용자 성별(M/F)을 입력받고, 남자인 경우 장난감 여자인 경우 장미꽃을 출력하세요
     */
    public void test2(){
        Scanner sc = new Scanner(System.in);
        System.out.println("> 성별을 입력하세요");
        //String user = sc.next();
        char user = sc.next().charAt(0);
        if(user == 'M'){
            System.out.println("장난감");
        }
        else if (user == 'F') {
            System.out.println("장미꽂");
        }
        System.out.println("프로그램을 종료합니다!");
    }

    /**
     *  사용자 입력 정수에 따라 양수/0/음수 출력하세요!
     *  - 중첩 if 사용가능
     */
    public void test3(){
        Scanner sc = new Scanner(System.in);
        System.out.println("> 정수입력 : ");
        int num = sc.nextInt();

        if(num > 0){
            System.out.println("양수입니다.");
        }
        if (num == 0){
            System.out.println("0 입니다.");
        }
        if (num < 0){
            System.out.println("음수입니다.");
        }
        System.out.println("프로그램을 종료합니다!!!");
    }
}

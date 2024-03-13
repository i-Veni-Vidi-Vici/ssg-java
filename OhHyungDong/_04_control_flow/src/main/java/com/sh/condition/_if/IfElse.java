package com.sh.condition._if;

import java.util.Scanner;

/**
 * if(조건식){
 *     //조건식이 True인 경우 실행 코드
 * }
 * else(조건식){
 *     //조건식이 false인 경우 실행코드
 * }
 */
public class IfElse {

    public void test()
    {
        Scanner scanner = new Scanner(System.in);
        int num = scanner.nextInt();

        //사용자 입력 정수 홀수/짝수 구분 홀수 -> num % 2 != 0 or num % 2 == 1
        if(num % 2 != 0) System.out.println("홀수입니다.🥩"); //홀수 일 때 실행 코드, 조건식이 true
        else System.out.println("짝수입니다. 🥞"); //짝수일 때 실행 코드, 조건식이 false
    }

    //사용자 성별을 입력 받고, 남자인 경우 장난감 여자인 경우 장미 꽃
    public void test2()
    {
        Scanner scan = new Scanner(System.in);
        System.out.println("입력 : ");
        char gender = scan.next().charAt(0);
        if(gender == 'M') System.out.println("장난감 ");
        else System.out.println("장미 꽃");
    }

    // 입력 정수에 따라 양수 / 0 / 음수 출력
    public void test3()
    {
        Scanner scan = new Scanner(System.in);
        System.out.println("정수입력 : ");

        int num = scan.nextInt();
        if(num >=0) {
            if(num == 0 ) System.out.println("0입니다.");
            else System.out.println("양수입니다.");
        }
        else System.out.println("음수입니다.");
    }


}

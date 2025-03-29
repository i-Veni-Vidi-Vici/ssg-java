package com.sh.condition._if;

/**
 * <pre>
 * if~else 표현식
 *
 * if() {
 *
 * }
 * else{
 *
 * }
 * </pre>
 */

import java.util.Scanner;

public class IfElse {
    public void test() {
        Scanner sc = new Scanner(System.in);

        //사용자 입력 정수 훌수/짝수 구분
        System.out.print(" 정수 입력 해주세요 : ");
        int num=sc.nextInt();

        if(num%2==0)
        {
            System.out.println("짝수 입니다");
        }
        else
        {
            System.out.println("홀수 입니다");
        }
    }

    /**
     * 사용자 성별을 입력 받고/ 남자 = 장난감, 여자 = 장미꽃
     */
    public void test2() {
        Scanner sc=new Scanner(System.in);

        System.out.print(" 성별 입력 해주세요 M or F : ");
        char gender=sc.next().charAt(0);

        if(gender == 'M')
        {
            System.out.println("남자, 장난감을 줍니다");
        }
        else
        {
            System.out.println("여성, 장미꽃을 줍니다");
        }
    }

    /**
     * 사용자 입력 정수에 따라 양수/0/음수 출력
     * 중첩 if가능
     */
    public void test3(){
        Scanner sc = new Scanner(System.in);
        System.out.print(" 정수를 입력 하세요 : ");
        int num = sc.nextInt();

        if (num == 0)
        {
            System.out.println("0 입니다");
        }
        if (num < 0)
        {
            System.out.println("음수 입니다");
        }
        if (num > 0)
        {
            System.out.println("양수 입니다");
        }
    }

}

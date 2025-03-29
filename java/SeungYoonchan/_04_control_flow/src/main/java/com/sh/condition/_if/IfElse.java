package com.sh.condition._if;

import java.util.Scanner;

/**
 * <pre>
 *     if~else 표현식
 *
 *     if (조건식) {
 *         // 조건식이 true인 경우
 *     }
 *     else{
 *         // 조건식이 false인 경우
 *     }
 *
 * </pre>
 */
public class IfElse {
    public void test() {
        Scanner sc = new Scanner(System.in);
        System.out.println("> 정수 입력하세요.");
        int num = sc.nextInt();

        if (num % 2 == 0) {
            System.out.println("짝수");
        }
        else{
            System.out.println("홀수");
        }
    }

    public void test2(){
        Scanner sc = new Scanner(System.in);
        System.out.print("성별을 입력하세요 : ");
        char ch = sc.next().charAt(0);
        if(ch=='M'){
            System.out.println("장난감");
        }
        else{
            System.out.println("장미꽃");
        }
    }

    /**
     * <pre>
     *     사용자 입력 정수에 따라 양수 / 0 / 음수 출력하세요
     * </pre>
     */
    public void test3(){
        Scanner sc = new Scanner(System.in);
        System.out.println("> 정수 입력하세요.");
        int num = sc.nextInt();

        if(num>0){System.out.println("양수");}
        if(num==0){System.out.println("0");}
        if(num<0){System.out.println("음수");}
    }
}

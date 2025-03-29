package com.sh.condition._if;

import java.util.Scanner;

/**
 * <pre>
 * if표현식
 * if(조건식){
 *      // 조건식이 true인 경우 실행코드
 * }
 * </pre>
 */
public class If {
    public void test() {
        Scanner sc = new Scanner(System.in);
        System.out.print(" 정수를 입력 해주세요 : ");
        int num=sc.nextInt();
        if (num%2==0) {
            System.out.println("짝수 입니다");
        }

        if(num%2!=0) {
            System.out.println(" 홀수 입니다 ");
        }

        if(num<0) {
            System.out.println("음수 입니다");
        }
        if(num>0) {
            System.out.println("양수 입니다");
        }

    }

    public void test2() {
        Scanner sc = new Scanner(System.in);

        // 사용자 입력 정수, 양수 이면서 짝수인지 확인
        System.out.print("숫자 입력 해주세요 : ");

        int num=sc.nextInt();

        if (num % 2 == 0)
        {
            System.out.print("짝수 + ");

            if(num>0)
                System.out.println("양수 입니다");
            else
                System.out.println("음수 입니다");
        }
        else
        {

            System.out.print("홀수 + ");

            if(num>0)
                System.out.println("양수 입니다");
            else
                System.out.println("음수 입니다");
        }

    }

}

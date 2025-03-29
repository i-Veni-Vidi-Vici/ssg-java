package com.sh.condition._if;

import java.util.Scanner;

/**
 * if 표현식
 * if(조건식)
 * {
 *    //조건식이 true인 경우 실행코드
 * }
 */
public class If {
    public void test()
    {
        //짝수 입력 값인 경우에만 빵빠레!
        Scanner scan = new Scanner(System.in);
        System.out.println("정수 입력하세요. ");
        int num = scan.nextInt();
        if(num % 2 == 0)
        {
            System.out.println("🎉");
        }
        //음수이면 빵빠레
        if(num < 0)
        {
            System.out.println("🎉 음수입니다.");
        }
        System.out.println("프로그램 종료 !");
    }

    public void test2()
    {
        Scanner scan = new Scanner(System.in);
        // 사용자 입력 정수, 양수이면서 짝수 인지 체크
        int num = scan.nextInt();

        if(num >0 && num %2 ==0) System.out.println("양수이면서 짝수 ! 🌸");
        System.out.println("프로그램 종료 !");
    }
}

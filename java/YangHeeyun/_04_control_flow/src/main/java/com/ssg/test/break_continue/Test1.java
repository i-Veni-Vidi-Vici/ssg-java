package com.ssg.test.break_continue;

import java.util.Scanner;

/**
 * 1. 정수 한 개를 입력 받아, 1부터 입력 받은 정수까지의 홀수의 곱을 출력하세요.
 * 2. 출력예시
 * 정수를 하나 입력하세요. => 10
 * 1부터 10까지 홀수의 곱은 945입니다.
 */
public class Test1 {
    public static void main(String[] args){
        Test1 t = new Test1();
        t.test();
    }

    public void test(){
        Scanner sc = new Scanner(System.in);
        System.out.print("정수 하나 입력하세요. => ");
        int n = sc.nextInt();

        // 홀수의 곱
        int multiply = 1;

        for(int i=1;i<=n;i++) {
            if (i % 2 == 0) {
               continue;
            }
            multiply *= i;
        }
        System.out.printf("1부터 %d까지 홀수의 곱은 %d입니다.", n, multiply);
    }
}

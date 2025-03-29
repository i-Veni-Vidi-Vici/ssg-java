package com.sgg.test.break_continue;

import java.util.Scanner;

public class Test2 {
    public static void main(String[] args) {

        /**
         * 사용자로부터 정수를 두개 입력 받아서, 작은 정수에서 큰 정수까지 홀수의 합을 구하세요.
         *     - 큰수/작은수에 해당하는 변수를 사용
         */
        Scanner sc = new Scanner(System.in);
        System.out.print("정수를 하나 입력하세요 => ");
        int num1 = sc.nextInt();
        System.out.print("다른 정수를 하나 입력하세요 => ");
        int num2 = sc.nextInt();
        int sum = 0; // 총합

        int big = 0; // 큰 수
        int small = 0; // 작은 수

        if(num1 > num2) {
            big = num1;
            small = num2;
        } else {
            big = num2;
            small = num1;
        }
        for(int i = small; i <= big; i++) {
            if(i % 2 == 0) {
                continue;
            }
            sum += i;
        }
        System.out.println(small + "부터 " + big + "까지의 홀수의 합은 " + sum + "입니다.");
    }
}

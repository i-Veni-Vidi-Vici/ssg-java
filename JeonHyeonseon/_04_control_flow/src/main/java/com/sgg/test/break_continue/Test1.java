package com.sgg.test.break_continue;

import java.util.Scanner;

public class Test1 {
    public static void main(String[] args) {

        // 정수 한개를 입력 받아, 1부터 입력 받은 정수까지의 홀수의 곱을 출력하세요

        // 1. 정수 한 개를 입력
        // 2. 1부터 입력 받은 정수까지
        // 3. 홀수를 구하는 식
        // 4. 홀수의 곱 출력

        Scanner sc = new Scanner(System.in);
        System.out.print("정수를 하나 입력하세요. => ");
        int num = sc.nextInt();
        long product = 1;  // 홀수의 곱의 초기화

        // 1부터 입력받은 정수(10)까지의 홀수의 곱
        // 1 * 3 * 5 * 7 * 9
        for(int i = 1; i <= num; i += 2) {
            if(i % 2 == 0) {
                continue;
            } product *= i;
        }
        System.out.println("1부터 10까지 홀수의 곱은 " + product + "입니다.");
    }
}

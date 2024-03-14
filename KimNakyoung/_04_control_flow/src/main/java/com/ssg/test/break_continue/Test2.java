package com.ssg.test.break_continue;

import java.util.Scanner;

/**
 * 1. 사용자로부터 정수를 두개 입력 받아서, 작은 정수에서 큰 정수까지 홀수의 합을 구하세요.
 *     - 큰수/작은수에 해당하는 변수를 사용
 *
 */

public class Test2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("정수를 하나 입력하세요. => ");
        int num1 = sc.nextInt();
        System.out.print("다른 정수를 하나 입력하세요. => ");
        int num2 = sc.nextInt();
        int sum = 0; // 총합

        int min = (num1 < num2 ? num1 : num2); // 작은 수
        int max = (num1 > num2 ? num1 : num2); // 큰 수

        // 작은수 부터 큰수까지 홀수의 합 구하기
        for (int i = min ; i <= max; i++ ){
            if(i % 2 != 0){
                sum += i;
            }
        }System.out.println(min + "부터 " + max + "까지의 홀수의 합은 " + sum + "입니다");

    }
}

package com.ssg.test.break_continue;

import java.util.Scanner;

public class Test2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("정수를 하나 입력하세요. => ");
        int num1 = sc.nextInt();
        System.out.print("다른 정수를 하나 입력하세요. => ");
        int num2 = sc.nextInt();

        int min = Math.min(num1, num2);
        int max = Math.max(num1, num2);

        int sum = 0;
        for(int i = min; i <= max; i++) {
            if(i % 2 == 0) {
                continue;
            } else {
                sum += i;
            }
        }
        System.out.println(min+ "부터 "+ max +"까지 홀수의 합은 " + sum + "입니다.");
    }
}

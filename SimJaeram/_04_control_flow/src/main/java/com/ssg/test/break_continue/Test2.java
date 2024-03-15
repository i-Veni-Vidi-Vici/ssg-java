package com.ssg.test.break_continue;

import java.util.Scanner;

public class Test2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int num1, num2;
        int min, max, sum = 0;

        // 사용자로부터 정수를 두 개 입력
        System.out.print("정수를 하나 입력하세요. => ");
        num1 = sc.nextInt();
        System.out.print("다른 정수를 하나 입력하세요. => ");
        num2 = sc.nextInt();

        // 큰수/작은수 판별
        if(num1 > num2) {
            max = num1;
            min = num2;
        } else {
            max = num2;
            min = num1;
        }
        
        // 작은 정수에서 큰 정수까지 홀수의 합
        for(int i = min; i <= max; i++) {
            if (i % 2 == 0) {
                continue;
            }
            sum += i;
//            if(i % 2 == 1) {
//                sum += i;
//            }
        }

        System.out.printf("%d부터 %d까지의 홀수의 합은 %d입니다.", min, max, sum);
    }
}

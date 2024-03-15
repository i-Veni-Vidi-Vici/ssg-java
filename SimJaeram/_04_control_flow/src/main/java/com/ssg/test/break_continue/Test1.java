package com.ssg.test.break_continue;

import java.util.Scanner;

public class Test1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("정수를 하나 입력하세요. => ");
        int num = sc.nextInt();
        int result  = 1;

        for(int i = 1; i <= num; i++) {
            if(i % 2 == 0) {
                continue;
            }
            result *= i;

//            if(i % 2 == 1) {
//                result *= i;
//            }
        }

        System.out.printf("1부터 %d까지 홀수의 곱은 %d입니다.", num, result);
    }
}

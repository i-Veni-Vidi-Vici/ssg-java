package com.ssg.test.break_continue;

import java.util.Scanner;

public class Test1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("정수를 하나 입력하세요. => ");
        int num = sc.nextInt();

        int mul = 1;
        for(int i = 1; i <= num; i++) {
            if(i % 2 == 0) {
                continue;
            } else {
                mul *= i;
            }
        }
        System.out.println("1부터 10까지 홀수의 곱은 " + mul + "입니다.");
    }
}

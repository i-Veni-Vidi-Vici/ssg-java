package com.ssg.test.loop;

import java.util.Scanner;

public class Test1 {
    public static void main(String[] args) {
        // 문제 1.
        Scanner sc = new Scanner(System.in);
        System.out.println("정수 입력 : ");
        int num = sc.nextInt();

        int sum = 0;
        for(int i = 2; i <= num; i += 2) {
//            System.out.println(i);
            sum += i;
        }
        System.out.println("합 : " + sum);
    }
}

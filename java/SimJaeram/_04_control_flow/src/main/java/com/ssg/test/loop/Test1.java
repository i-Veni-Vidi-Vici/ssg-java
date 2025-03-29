package com.ssg.test.loop;

import java.util.Scanner;

public class Test1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int num = 0;
        int sum = 0;

        System.out.println("정수 입력 : ");
        num = sc.nextInt();

        for(int i = 1; i <= num; i++) {
            if(i % 2 == 0) {
                sum += i;
            }
        }

        System.out.println("1부터 " + num + "까지 존재하는 짝수의 합은 " + sum + "입니다.");
    }
}

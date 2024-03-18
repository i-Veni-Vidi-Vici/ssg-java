package com.ssg.test.array;

import java.util.Scanner;

public class Test5 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("홀수인 양의 정수를 하나 입력: ");
        int num = sc.nextInt();

        int[] arr = new int[num];
        int k = 0;
        if (num % 2 != 0) {
            for (int i = 0; i < num; i++) {
                if (i < (num / 2) + 1) {
                    arr[i] = ++k;
                } else {
                    arr[i] = --k;
                }
                System.out.print(arr[i] + " ");
            }
        } else {
            System.out.println("잘못 입력했습니다. 홀수가 아닙니다.");
        }
    }
}

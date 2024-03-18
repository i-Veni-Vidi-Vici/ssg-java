package com.ssg.test.array;

import java.util.Scanner;

public class Test5 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("홀수인 양의 정수를 하나 입력하세요  ==>");
        int num = sc.nextInt();
        if (num % 2 == 0) {
            System.out.println("잘못 입력했습니다. 홀수가 아닙니다.");
            return;
        }

        int[] result = new int[num];


        for (int i = 0; i < result.length; i++) {
            if (i < result.length / 2) {
                result[i] = i+1;
            } else {
                result[i] = result.length-i;
            }
        }

        for (int i : result) {
            System.out.print(i);
        }
    }
}

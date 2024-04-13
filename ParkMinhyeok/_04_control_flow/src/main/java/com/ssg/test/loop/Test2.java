package com.ssg.test.loop;

import java.util.Scanner;

public class Test2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("정수입력: ");
        int num = sc.nextInt();
        char odd = '수';
        char even = '박';
        String result = "";
        for (int i = 1; i <= num; i++) {
            if (i % 2 == 0) {
                result += even;
            } else {
                result += odd;
            }
        }
        System.out.println(result);
    }
}

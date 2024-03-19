package com.sh.condition._if;

import java.util.Scanner;

public class Test3 {
    public static void test() {
        Scanner sc = new Scanner(System.in);
        System.out.print("> 체중입력(kg) :");
        int num1 = sc.nextInt();
        System.out.print("> 신장입력(cm) :");
        int num2 = sc.nextInt();
        double BMI = ((double) num1 / ((double) num2 /100 * num2/100));
        System.out.println("BMI 지수 : " + Math.round(BMI * 10) / 10.0);
        System.out.println("----------------------------------------------");

        if (BMI >= 30) {
            System.out.println("고도비만입니다.");
        }
        if (BMI < 30) {
            if (BMI >= 25) {
                System.out.println("비만입니다.");
            }
        }
        if (BMI < 25) {
            if (BMI >= 23) {
                System.out.println("과체중입니다.");
            }
        }
        if (BMI < 25) {
            if (BMI >= 23) {
                System.out.println("과체중입니다.");
            }
        }
        if (BMI < 23) {
            if (BMI >= 18.5) {
                System.out.println("정상체중입니다.");
            }
        }
        if (BMI < 18.5) {
            System.out.println("저체중입니다.");
        }
    }
}

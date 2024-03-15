package com.ssg.test.condition._if;

import java.util.Scanner;

public class Test3 {
    public void test() {
        Scanner sc = new Scanner(System.in);
        System.out.print("체중입력(kg): ");
        int weight = sc.nextInt();
        System.out.print("키입력(cm): ");
        double height = sc.nextDouble();

        System.out.println("--------------------------");
        double resultBMI = weight / ((height / 100.0) * (height / 100.0));
        System.out.println("BMI 지수: " + Math.round(resultBMI * 10) / 10.0);

        if (resultBMI >= 30) {
            System.out.println("고도비만입니다.");
        }
        else if (resultBMI >= 25) {
            System.out.println("비만입니다.");
        }
        else if (resultBMI >= 23) {
            System.out.println("과체중입니다.");
        }
        else if (resultBMI >= 18.5) {
            System.out.println("정상체중입니다.");
        }
        else {
            System.out.println("저체중입니다.");
        }
    }
}

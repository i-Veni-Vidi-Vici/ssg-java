package com.ssg.test.condition._if;

import java.util.Scanner;

public class Test3 {
    public void test() {
        Scanner sc = new Scanner(System.in);
        System.out.println("신장입력(cm) : ");
        int height = sc.nextInt();
        System.out.println("체중입력(kg) :");
        int weight = sc.nextInt();

        System.out.println("-------------------");

        // BMI 계산
        double bmi = weight / ((height * 0.01) * (height * 0.01));
        System.out.println("BMI 지수 : " + bmi);

        // BMI별 체중
        if (bmi > 30) {
            System.out.println("고도비만입니다.");
        }
        else if (bmi >= 25) {
            System.out.println("비만입니다.");
        }
        else if (bmi >= 23) {
            System.out.println("과체중입니다.");
        }
        else if (bmi >= 18.5) {
            System.out.println("정상체중입니다.");
        }
        else if (bmi < 18.5) {
            System.out.println("저체중입니다.");
        }
        else {
            System.out.println("다시 입력해주세요.");
        }
    }
}

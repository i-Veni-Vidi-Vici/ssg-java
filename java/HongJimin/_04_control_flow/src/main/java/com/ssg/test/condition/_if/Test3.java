package com.ssg.test.condition._if;

import java.util.Scanner;

public class Test3 {
    public void test () {
        Scanner sc = new Scanner(System.in);
        System.out.print("> 신장 입력(cm) : ");
        int heightCm = sc.nextInt();
        double heightM = heightCm * 0.01; // cm를 m으로 바꾸는 과정

        System.out.print("> 체중 입력 : ");
        int weight = sc.nextInt();

        double bmi = weight / (heightM * heightM); // BMI 계산식
        String Bmi = "";

        if (bmi >= 30) {
            Bmi = "고도비만";
        } else if (bmi >=25) {
            Bmi = "비만";
        } else if (bmi >=23) {
            Bmi = "과체중";
        } else if (bmi >=18.5) {
            Bmi = "정상체중";
        } else{
            Bmi = "저체중";
        }
        System.out.println("================");
        System.out.println("BMI 지수 : " + bmi);
        System.out.println(Bmi + "입니다.");
    }
}

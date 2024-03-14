package com.ssg.test.condition._if;

import java.util.Scanner;

public class Test3 {
    public void test() {
        Scanner sc = new Scanner(System.in);
        System.out.print("체중입력(kg) : ");
        int weight = sc.nextInt();
        System.out.print("신장입력(cm) : ");
        int height = sc.nextInt();
        System.out.println("----------------------------");

        double bmi = weight / ((height * 0.01) *(height * 0.01));
        String result = "";
        if (bmi >= 30) {
            result = "고도비만";
        } else if (bmi >= 25) {
            result = "비만";
        } else if (bmi >= 23) {
            result = "과체중";
        } else if (bmi >= 18.5) {
            result = "정상체중";
        } else {
            result = "저체중";
        }
        System.out.println("BMI 지수 : " + bmi);
        System.out.println(result + "입니다.");
    }
}

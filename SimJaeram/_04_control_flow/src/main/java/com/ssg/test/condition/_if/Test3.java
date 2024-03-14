package com.ssg.test.condition._if;

import java.util.Scanner;

public class Test3 {
    public void test() {
        Scanner sc = new Scanner(System.in);
        
        double weight;
        double height;
        double bmi;
        String result = "";
        
        System.out.print("체중입력(kg) : ");
        weight = sc.nextDouble();
        System.out.print("신장입력(cm) : ");
        height = sc.nextDouble();
        bmi = weight / ((height/10) * (height/10));

        if (bmi < 18.5) {
            result = "저체중";
        } else if (bmi < 23) {
            result = "정상체중";
        } else if (bmi < 25) {
            result = "과체중";
        } else if (bmi < 30) {
            result = "비만";
        } else {
            result = "고도비만";
        }

        System.out.println("----------------------------------");
        System.out.println("BMI 지수 : " + bmi);
        System.out.println(result + "입니다.");
    }
}

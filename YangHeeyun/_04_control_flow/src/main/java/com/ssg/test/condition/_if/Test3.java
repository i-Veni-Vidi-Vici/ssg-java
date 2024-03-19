package com.ssg.test.condition._if;

import java.sql.SQLOutput;
import java.util.Scanner;

public class Test3 {
    public static void main(String[] args) {
        Test3 t3 = new Test3();
        t3.test();
    }

    public void test() {
        Scanner sc = new Scanner(System.in);

        System.out.print("체중입력(kg) : ");
        int weight= sc.nextInt();
        System.out.print("신장입력(cm) : ");
        double height = sc.nextInt() *0.01;
        String result = "";

        // BMI 계산식
        double BMI = weight / (height * height);

        if (BMI < 18.5) {
            result = "저체중";
        } else if (BMI < 23) {
            result = "정상체중";
        } else if (BMI < 25) {
            result = "과체중";
        } else if (BMI < 30) {
            result = "비만";
        } else if (BMI <= 30) {
            result = "고도비만";
        }

        System.out.println("--------------------------");
        // Math.round(소수점 일의 자리에서 반올림)
        System.out.println("BMI 지수 : " + Math.round(BMI*10)/10.0);
        System.out.println(result + "입니다.");
    }
}


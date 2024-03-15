package com.ssg.test.condition._if;

import java.util.Scanner;

public class Test3 {

    public void test() {
        Scanner sc = new Scanner(System.in);
        System.out.print("체중입력(kg) : ");
        int kg = sc.nextInt();
        System.out.print("신장입력(cm) : ");
        int cm = sc.nextInt();
        double m = cm * 0.01;
        System.out.println("-----------------------");
        double bmi = (Math.round(kg / (m * m) * 10)/ 10.0);
        String result = "";

        if(bmi < 18.5) {
            result = "저체중";
        }
        else if(bmi < 23) {
            result = "정상체중";
        }
        else if(bmi < 25) {
            result = "과체중";
        }
        else if(bmi < 30) {
            result = "비만";
        }
        else {
            result = "고도비만";
        }

        System.out.println("BMI 지수 : " + bmi);
        System.out.println(result + "입니다.");
    }
}

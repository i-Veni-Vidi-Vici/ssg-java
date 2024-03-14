package com.ssg.test.condition._if;

import java.util.Scanner;

public class Test3 {
    public void test() {
        Scanner sc = new Scanner(System.in);

        System.out.print("체중 입력(kg) : ");
        int w = sc.nextInt();

        System.out.print("신장 입력(cm) : ");
        // double h = (double)sc.nextInt()/100;
        double h = sc.nextInt() / 100.0;



        // 결과 문자열
        String result = "";

        // BMI 계산식 = 체중(kg) / (신장(m) * 신장(m) )
        double bmi = w / (h * h);

        if (bmi < 18.5) {
            result = "저체중";
        } else if (bmi >= 18.5 && bmi < 23) {
            result = "정상체중";
        } else if (bmi >= 23 && bmi < 25) {
            result = "과체중";
        } else if (bmi >= 25 && bmi < 30) {
            result = "비만";
        } else {
            result = "고도비만";
        }

        System.out.println("--------------------");
        System.out.println("bmi지수 : " + Math.round(bmi * 10) / 10.0 );
        System.out.println(result + "입니다.");

    }
}

package com.ssg.test.condition._if;

import java.util.Scanner;

public class Test3 {
    public void test() {
        Scanner sc = new Scanner(System.in);
        System.out.print("체중입력(kg) : ");
        double weight = sc.nextInt();  // 체중
        System.out.print("신장입력(cm) : ");
        double height = sc.nextInt();  // 신장
        System.out.println("----------------------");

        double bmi = weight / Math.pow(height*0.01,2);    // Math.pow() 제곱근
        double roundsBmi = Math.round(bmi*10) / 10.0;   // BMI 반올림
        System.out.println("BMI 지수 : " + roundsBmi);  // Math.round() 반올림

        if(bmi<=30)
            System.out.println("고도비만입니다.");
        else if (bmi <= 25)
                System.out.println("비만입니다.");
        else if (bmi <= 23)
                System.out.println("과체중입니다.");
        else if (bmi <= 18.5)
                System.out.println("정상체중입니다.");
        else if (bmi < 0)
                System.out.println("저체중입니다.");
        else
            System.out.println("잘못 입력 하셨습니다.  프로그램을 종료합니다.");
    }
}

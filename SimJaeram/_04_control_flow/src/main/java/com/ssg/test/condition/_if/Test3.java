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
        bmi = weight / ((height/100) * (height/100));

        // 간결한 코드 짧은 코드도 좋지만, 동료가 잘 읽을 수 있는 코드가 더 좋은 코드
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

        // Math 클래스의 메소드는 소수점 몇번째 자리까지 반올림 하라는 설정할 수 없어, 소수점을 올린 뒤 다시 되돌리는 방식 코딩
        System.out.println("----------------------------------");
        System.out.println("BMI 지수 : " + Math.round(bmi * 10) / 10.0);
        System.out.println(result + "입니다.");
    }
}

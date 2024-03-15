package com.ssg.test.condition._if;

import java.util.Scanner;

public class Test3 {
    public void test(){
        Scanner sc = new Scanner(System.in);

        System.out.print("키 입력 (cm) : ");
        double height = sc.nextDouble();
        System.out.print("몸무게 입력 (kg) : ");
        double weight = sc.nextDouble();

        //System.out.println(" > 입력한 키는 " + height + " m 입니다.");
        //System.out.println(" > 입력한 몸무게는 " + weight + " kg 입니다.");

        System.out.println("----------------------------------------------");
        double bmi = weight / (height * height * 0.0001);
        bmi = Math.round(bmi); // round를 사용해서 반올림
        System.out.println(" > BMI 지수는 " + bmi + " 입니다.");

        String result = null;
        if(bmi < 18.5){
            result = "저체중";
        }
        else if (bmi >= 18.5 && bmi < 23) {
            result = "정상체중";
        }
        else if (bmi >= 23 && bmi < 25){
            result = "과체중";
        }
        else if (bmi >= 25 && bmi < 30){
            result = "비만";
        }
        else{
            result = "고도비만";
        }

        System.out.println("> " + result + " 입니다.");
    }
}

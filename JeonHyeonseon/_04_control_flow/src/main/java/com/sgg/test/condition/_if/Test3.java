package com.sgg.test.condition._if;

import java.util.Scanner;

public class Test3 {
    public void test() {
        Scanner sc = new Scanner(System.in);
        System.out.print("체중입력(kg) : ");
        double weight = sc.nextDouble();
        System.out.print("신장입력(cm) : ");
        double height = sc.nextDouble();
        System.out.println("---------------------------");

        Double BMI = weight / ((height / 100) * (height / 100));
        //System.out.println(height = height / 100);
        String result = "";

        System.out.println("BMI지수 : " + Math.round(BMI*10) / 10.0);

        if(BMI < 18.5) {
            System.out.println("저체중");
        }
        else if(BMI >= 18.5 && BMI < 23){
            System.out.println("정상체중");
        }
        else if(BMI >= 23 && BMI < 25){
            System.out.println("과체중");
        }
        else if(BMI >= 25 && BMI < 30){
            System.out.println("비만");
        }
        else if(BMI >= 30){
            System.out.println("고도비만");
        }
        System.out.println(result + "입니다.");
    }
}

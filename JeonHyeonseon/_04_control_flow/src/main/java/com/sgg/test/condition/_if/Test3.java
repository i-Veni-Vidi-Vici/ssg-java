package com.sgg.test.condition._if;

import java.util.Scanner;

public class Test3 {
    public void test() {
        Scanner sc = new Scanner(System.in);
        System.out.println("당신의 몸무게를 입력하시오");
        double weight = sc.nextDouble();
        System.out.println("당신의 키를 입력하시오");
        double height = sc.nextDouble();
        System.out.println("---------------------------");

        Double BMI = weight / ((height / 100) * (height / 100));
        //System.out.println(height = height / 100);

        System.out.println("BMI지수 : " + BMI);

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
    }
}

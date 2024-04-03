package com.ssg.test.condition._if;

import java.util.Scanner;

public class Test3 {
    public void test3(){
        Scanner scanner = new Scanner(System. in);
        System.out.println(" 키를 입력해주세요");
        int height = scanner.nextInt();

        System.out.println("몸무계를 입력해주세요");
        int fat = scanner.nextInt();

        String result;
        double BMI = (double) fat /((height)*(height)*0.0001);

        if(BMI < 18.5){
            result= "BMI 는 " + BMI + "이며 저체중 입니다.";
        } else if (BMI >= 18.5 && BMI < 23 ){
            result = "BMI 는 " + BMI + "이며 정상체중 입니다.";

        } else if (BMI >= 23 && BMI < 25){
            result = "BMI 는 " + BMI + "이며 과체중 입니다.";
        }
         else if (BMI >= 25 && BMI < 30){
             result = "BMI 는 " + BMI + "이며 비만 입니다.";
        }
         else {
             result = "고도비만 입니다.";


    }
        System.out.println(result);

}
}

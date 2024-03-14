package com.ssg.test.condition._if;

import java.util.Scanner;

/**
 * 조건문 if 실습문제
 * - 문제 1
 */
public class Test3 {

    /**
     *
     * - 키(cm)와 몸무게(kg)을 입력 받고, BMI(체질량지수)를 계산하여 계산된 값에 따라
     *     - 저체중(18.5미만),
     *     - 정상체중(18.5이상 23미만),
     *     - 과체중(23이상 25미만),
     *     - 비만(25이상 30미만),
     *     - 고도비만(30이상)을 출력하세요.
     *
     */

    public void test(){
        Scanner sc = new Scanner(System.in);
        System.out.print("체중입력(kg) : ");
        int weight = sc.nextInt();
        System.out.print("신장입력(cm) : ");
        int height = sc.nextInt();
        System.out.println("--------------");

        double bmi = weight / ((height * 0.01 )*(height*0.01));
        double roundedBmi = Math.round(bmi * 10.0) / 10.0;

        String condition ;

        if (bmi < 18.5){
            condition = "저체중";

        }
        else if (bmi < 23){
            condition = "정상체중";
        }
        else if (bmi < 25){
            condition = "과체중";
        }
        else if (bmi < 30){
            condition = "비만";
        }else {
            condition = "고도비만";
        }
        // 왜 변수 안만들고 Math.round ((bmi * 10.0) / 10.0)) 하면 왜 안될까
        System.out.println("BMI 지수 : " + roundedBmi);
        System.out.println(condition + "입니다.");

    }


}

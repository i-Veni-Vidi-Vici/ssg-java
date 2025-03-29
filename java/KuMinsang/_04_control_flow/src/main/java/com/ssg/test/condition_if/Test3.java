package com.ssg.test.condition_if;

import java.util.Scanner;

/**
 * - 키(cm)와 몸무게(kg)을 입력 받고, BMI(체질량지수)를 계산하여 계산된 값에 따라
 *     - 저체중(18.5미만),
 *     - 정상체중(18.5이상 23미만),
 *     - 과체중(23이상 25미만),
 *     - 비만(25이상 30미만),
 *     - 고도비만(30이상)을 출력하세요.
 *
 *     BMI 계산식 = 체중(kg) / (신장(m) * 신장(m) )
 */
public class Test3 {
    public void test(){
        Scanner sc = new Scanner(System.in);
        int height=0;   //키
        int weight=0;   //몸무게
        double bmi = 0;    //BMI지수

        System.out.println(">체중입력(kg) : ");
        weight = sc.nextInt();
        System.out.println(">신장입력(cm) : ");
        height = sc.nextInt();
        System.out.println("---------------------");
        bmi = weight / ( (double) height/100 * (double) height/100);
        bmi = Double.parseDouble(String.format("%.1f",bmi));

        System.out.println("BMI 지수 : " + bmi);
        if(bmi>=30){
            System.out.println("고도비만");
        }else if(bmi>=25){
            System.out.println("비만");
        }else if(bmi>=23){
            System.out.println("과체중");
        }else if(bmi>=18.5){
            System.out.println("정상체중");
        }else if(bmi<18.5){
            System.out.println("저체중");
        }
    }
}

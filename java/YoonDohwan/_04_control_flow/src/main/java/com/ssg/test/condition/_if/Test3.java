package com.ssg.test.condition._if;

import java.util.Scanner;

public class Test3 {
    public void test() {
        Scanner sc = new Scanner(System.in);
        System.out.print("체중입력(kg) : ");
        double kg = sc.nextInt();
        sc.nextLine();
        System.out.print("신장입력(cm) : ");
        double cm = sc.nextInt();
        double bmi = ((kg*10000)/(cm*cm));
        String formatbmi=String.format("%.1f",bmi);
        String biman = " ";
        if(bmi<18.5){
            biman="저체중";
        }
        else if(bmi>=18.5&&bmi<23){
            biman="정상체중";
        }
        else if(bmi>=23&&bmi<25){
            biman="과체중";
        }
        else if(bmi>=25&&bmi<30){
            biman="비만";
        }
        else{
            biman="고도비만";
        }
        System.out.println("--------------------");
        System.out.println("BMI 지수 : "+formatbmi);
        System.out.println(biman);
    }
}

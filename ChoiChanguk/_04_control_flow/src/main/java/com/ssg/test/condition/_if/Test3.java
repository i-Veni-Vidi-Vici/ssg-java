package com.ssg.test.condition._if;

import java.util.Scanner;

public class Test3 {
    public void test() {
        double height;
        double weight;
        double BMI;
        Scanner sc = new Scanner(System.in);

        System.out.print("체중입력(kg) : ");
        weight = sc.nextInt();

        System.out.print("신장입력(m) : ");
        height = sc.nextInt();

        System.out.println("height = " + height*100);




        height=height*0.01;

        BMI=(double) weight/(height*height);

        System.out.println("--------------------------");
        System.out.println("BMI 지수 : "+BMI);

        if(BMI<18.5)
        {
            System.out.println("저체중입니다");
        }
        else if(BMI>=18.5&&BMI<23)
        {
            System.out.println("정상체중입니다");
        }
        else if(BMI>=23&&BMI<25)
        {
            System.out.println("과제충입니다");
        }
        else if(BMI>=25&&BMI<30)
        {
            System.out.println("비만입니다");
        }
        else {
            System.out.println("고도비만입니다");
        }
    }
}

package com.ssg.test.condition._if;

import java.util.Scanner;

public class Test3 {
    public void test(){
        Scanner sc = new Scanner(System.in);
        System.out.println("키를 입력하세요 : ");
        double cm = sc.nextInt();
        System.out.println("몸무게를 입력하세요 : ");
        double kg = sc.nextInt();
        double BMI = kg / ((cm/100)*(cm/100));
        System.out.println("BMI 지수 : " + Math.round(BMI*10)/10.0);
        if(BMI>=30)
        {
            System.out.println("고도비만입니다.");
        }
        else if(BMI>=25)
        {
            System.out.println("비만입니다.");
        }
        else if(BMI>=23)
        {
            System.out.println("과체중입니다.");
        }
        else if(BMI>=18.5)
        {
            System.out.println("정상체중입니다.");
        }
        else
        {
            System.out.println("저체중입니다.");
        }
    }
}

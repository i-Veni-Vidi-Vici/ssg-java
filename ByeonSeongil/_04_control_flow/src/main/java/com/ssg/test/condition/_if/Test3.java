package com.ssg.test.condition._if;

import java.util.Scanner;

public class Test3 {
    public void test() {
        Scanner sc = new Scanner(System.in);
        System.out.print("체중입력(kg) : ");
        int weight = sc.nextInt();

        System.out.print("신장입력(cm) : ");
        int height = sc.nextInt();
        System.out.println("--------------------");

        double result = ((double) weight)/(height*height)*100*100;

        System.out.println("BMI 지수 : "+ result);

        if (result >= 30) {
            System.out.println("고도비만");
        } else if (result >= 25) {
            System.out.println("비만");
        }else if (result >= 23) {
            System.out.println("과체중");
        }else if (result >= 18.5) {
            System.out.println("정상체중");
        }else System.out.println("저체중");

    }
}

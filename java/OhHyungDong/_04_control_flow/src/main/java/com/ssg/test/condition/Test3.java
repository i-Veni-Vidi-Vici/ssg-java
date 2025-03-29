package com.ssg.test.condition;

import java.util.Scanner;

public class Test3 {

    public void test()
    {
        Scanner scanner = new Scanner(System.in);
        System.out.println("신장입력(cm) : ");
        double height = scanner.nextDouble();
        double heightM = height / 100;
        System.out.println("체중입력(kg) : ");
        double weight = scanner.nextDouble();
        double bmi = weight /(heightM * heightM);
        System.out.println("------------------");
        System.out.printf("BMI 지수 : %.1f\n", bmi);

        if(bmi > 30) System.out.println("고도비만입니다. ");
        else if(bmi >= 25) System.out.println("비만입니다. ");
        else if(bmi>=23) System.out.println("과체중입니다.");
        else if(bmi>=18.5) System.out.println("정상체중입니다. ");
        else System.out.println("저체중입니다.");
    }

}

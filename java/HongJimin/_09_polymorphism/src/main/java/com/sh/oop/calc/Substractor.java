package com.sh.oop.calc;

import java.util.Scanner;

public class Substractor extends Calculator{

    Scanner sc = new Scanner(System.in);


    @Override
    public void calc() {
        System.out.println("두 정수 입력 : ");
        int n = sc.nextInt();
        int m = sc.nextInt();
        int result = n - m;
        System.out.println(n + " - " + m + " = " + result);
    }
}

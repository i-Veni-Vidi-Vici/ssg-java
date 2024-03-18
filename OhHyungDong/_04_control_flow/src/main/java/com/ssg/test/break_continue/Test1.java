package com.ssg.test.break_continue;

import java.util.Scanner;

public class Test1 {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        System.out.println("정수를 하나 입력하세요. ");
        int n = scanner.nextInt();
        int m = 1;
        for(int i = 1; i<=5; i++)
        {
            if(i % 2 == 1){
                m *= i; // m  * i
            }
            else continue;
        }
        System.out.println("1부터 " + n + "까지의 곱은 " + m +"입니다. ");
    }
}

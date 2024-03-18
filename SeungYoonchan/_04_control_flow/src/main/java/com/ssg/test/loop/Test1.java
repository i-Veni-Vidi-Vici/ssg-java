package com.ssg.test.loop;

import java.util.Scanner;

public class Test1 {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);

        System.out.print("정수를 입력하세요 : ");
        int num = sc.nextInt();

        int sum = 0;
        for (int i = 1; i <= num; i++) {
            sum = sum + i;
        }

        System.out.println("합 : " + sum);
    }

}

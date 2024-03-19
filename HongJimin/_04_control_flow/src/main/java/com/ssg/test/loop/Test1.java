package com.ssg.test.loop;

import java.util.Scanner;

public class Test1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("정수 입력 : ");

        int userNum = sc.nextInt();
        int sum = 0;

        for (int num = 1; num <= userNum; num++) {
            if (num %2 == 0) {
                sum += num;
            }
        }

        System.out.println(userNum +"까지의 짝수의 합은 " + sum + "입니다!");

    }
}

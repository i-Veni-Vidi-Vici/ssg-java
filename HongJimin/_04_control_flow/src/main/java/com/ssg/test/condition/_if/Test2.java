package com.ssg.test.condition._if;

import java.util.Scanner;

public class Test2 {
    public void test() {
        Scanner sc = new Scanner(System.in);
        System.out.print("> 정수 입력 ( 1 ~ 10 ) : ");
        int num = sc.nextInt();

        if (num >= 1 && num <=10) {
            if (num % 2 ==0) {
                System.out.println("입력된 수 = 짝수");
            }
            else if(num % 2 ==1) {
                System.out.println("입력된 수 = 홀수");
            }
        } else {
            System.out.println("반드시 1 ~ 10 사이의 정수를 입력해야 합니다!");
        }


    }
}

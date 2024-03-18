package com.ssg.test.loop;

import java.util.Scanner;

public class Test1 {
    public static void main(String[] args) {
        Test1 test1 = new Test1();
        test1.test();
    }

    public void test() {
        Scanner sc = new Scanner(System.in);
        System.out.print("정수입력 : ");
        int num = sc.nextInt(); // 입력 받은 정수
        int sum = 0;    // 1 ~ num까지 존재하는 짝수의 합

        for(int i=1; i<=num; i++) {
            if(i % 2 == 0) {
                sum += i;
            }
        }
        System.out.println("1 ~ 입력받은 정수까지 존재하는 짝수의 합 : " + sum);
    }
}

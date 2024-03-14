package com.ssg.test.break_continue;

import java.util.Scanner;

public class Test2 {
    public static void main(String[] args) {
        Test2 test2 = new Test2();
        test2.test();
    }

    public void test() {
        Scanner sc =  new Scanner(System.in);
        System.out.print("정수를 하나 입력하세요. => ");
        int num1 = sc.nextInt(); // 입력받은 정수
        System.out.print("다른 정수를 하나 입력하세요. => ");
        int num2 = sc.nextInt();    // 입력받은 다른 정수
        int sumOdd = 0;    // 작은 num ~ 큰 num까지 홀수의 합

        if(num1 >= num2) {  // 큰 정수가 num1일 때
            for(int i=num2; i<=num1; i++) {
                if(i % 2 == 1) {
                    sumOdd += i;
                    continue;
                }
            }
            System.out.println(num2 + "부터 " + num1 + "까지의 홀수의 합은 " + sumOdd + "입니다.");
        } else {    // 큰 정수가 num2일 때
            for(int i=num1; i<=num2; i++) {
                if(i % 2 == 1) {
                    sumOdd += i;
                    continue;
                }
            }
            System.out.println(num1 + "부터 " + num2 + "까지의 홀수의 합은 " + sumOdd + "입니다.");
        }
    }
}

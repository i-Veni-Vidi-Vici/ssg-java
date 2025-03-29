package com.ssg.test.break_continue;

import java.util.Scanner;

public class Test1 {
    public static void main(String[] args) {
        Test1 test1 = new Test1();
        test1.test();
    }

    public void test() {
        Scanner sc = new Scanner(System.in);
        System.out.print("정수를 하나 입력하세요. => ");
        int num = sc.nextInt(); // 입력받은 정수
        int multiplyOdd = 1;   // 1 ~ num까지의 홀수의 곱

        for(int i=1; i<=num; i++) {
            if(i % 2 == 1) {
                multiplyOdd *= i;   // 홀수를 계속 곱한다.
                continue;
            }
        }
        System.out.println("1부터 10까지 홀수의 곱은 " + multiplyOdd + " 입니다.");
    }
}

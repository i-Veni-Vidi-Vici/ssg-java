package com.ssg.test.loop;

import java.util.Scanner;

public class Test2 {
    public static void main(String[] args) {
        Test2 test2 = new Test2();
        test2.test();
    }

    public void test() {
        Scanner sc = new Scanner(System.in);
        System.out.print("정수입력 : ");
        int num = sc.nextInt(); // 입력받은 정수

        for(int i=1; i<=num; i++) {
            if(i%2 == 1)  // 홀수
                System.out.print("수");
            else    // 짝수
                System.out.print("박");
        }
    }
}


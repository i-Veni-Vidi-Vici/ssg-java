package com.ssg.test.loop;

import java.util.Scanner;

public class Test1 {
    public static void main(String[] args) {
        Test1 test1 = new Test1();
        test1.test();
    }

    public void test() {
        Scanner sc = new Scanner(System.in);
        System.out.print("정수를 입력하세요 : ");
        int userNum = sc.nextInt();
        int sum = 0;
        for (int i = 1; i <= userNum; i++) {
            if (i % 2 == 0) {
                sum += i;
            }
        }
        System.out.println(sum);
    }
}

package com.ssg.test.loop;

import java.util.Scanner;

public class Test2 {
    public static void main(String[] args) {
        Test2 test2 = new Test2();
        test2.test();
    }

    private void test() {
        Scanner sc = new Scanner(System.in);
        System.out.println("정수를 입력하세요 : ");
        int userNum = sc.nextInt();
        String sum = "";
        for (int i = 1; i <= userNum; i++) {
            if (i % 2 == 0) {
                sum += "박";
            } else {
                sum += "수";
            }
        }
        System.out.println(sum);
    }

}

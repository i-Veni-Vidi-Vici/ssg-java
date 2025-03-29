package com.ssg.test.loop;

import java.util.Scanner;

public class Test4 {
    public static void main(String[] args) {
        Test4 test4 = new Test4();
        test4.test();
    }

    private void test() {
        Scanner sc = new Scanner(System.in);
        System.out.print("문자열 입력 : ");
        String userStr = sc.nextLine();
        System.out.print("문자 입력 : ");
        char userChar = sc.next().charAt(0);
        int sum = 0;
        if (userChar >= 'A' && userChar <= 'Z' || userChar >= 'a' && userChar <= 'z') {
            for (int i = 0; i < userStr.length(); i++) {
                if (userStr.charAt(i) == userChar) {
                    sum += 1;
                }
            }
            System.out.printf("'%c'가 포함된 개수 : %d 개\n", userChar, sum);
        } else {
            System.out.println("영문자가 아닙니다.");
        }
    }
}

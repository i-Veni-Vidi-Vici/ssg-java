package com.ssg.test.array;

import java.util.Scanner;

public class Test4 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("전화번호 입력 : ");
        String phoneNumber = sc.next();
        char[] copiedNumber = new char[phoneNumber.length()];
        for (int i = 0; i < phoneNumber.length(); i++) {
            if (i >= 3 && i <= 6) {
                copiedNumber[i] = '*';
                continue;
            }
            copiedNumber[i] = phoneNumber.charAt(i);
        }

        System.out.print("출력 : ");
        for (int i = 0; i < copiedNumber.length; i++) {
            System.out.print(copiedNumber[i]);
        }
    }
}

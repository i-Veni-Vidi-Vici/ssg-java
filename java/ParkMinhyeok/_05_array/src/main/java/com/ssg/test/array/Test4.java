package com.ssg.test.array;

import java.util.Scanner;

public class Test4 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("전화번호를 입력해주세요: ");
        String phoneNumber = scanner.next();
        char[] phoneNumberArray = phoneNumber.toCharArray();

        if (phoneNumber.length() == 11) {
            for (int i = 3; i < 7; i++) {
                phoneNumberArray[i] = '*';
            }
        } else {
            System.out.println("잘못된 전화번호입니다.");
            return;
        }
        System.out.println("출력 : " + new String((phoneNumberArray)));
    }
}

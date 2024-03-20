package com.ssg.test.array;

import java.util.Arrays;
import java.util.Scanner;

public class Test4 {
    public static void main(String[] args) {
        Test4 test4 = new Test4();
        test4.test();
    }

    private void test() {
        Scanner scanner = new Scanner(System.in);
        // 전화번호 입력 받기
        System.out.print("전화번호를 입력 : ");
        String phoneNum = scanner.nextLine();


        // 가운데 4자리를 *로 가리기
        char[] maskedPhoneNumber = phoneNum.toCharArray();
        for (int i = 3; i < 7; i++) {
            maskedPhoneNumber[i] = '*';
        }
        System.out.println("가운데 4자리 *로 가린 전화번호: " + new String(maskedPhoneNumber));
    }
}
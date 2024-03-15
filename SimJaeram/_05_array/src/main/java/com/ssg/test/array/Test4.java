package com.ssg.test.array;

import java.util.Scanner;

public class Test4 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String phone = "";
        char[] phoneArr = new char[11];

        // 전화번호 입력
        System.out.print("전화번호 입력 : ");
        phone = sc.next();
        for(int i = 0; i < phone.length(); i++) {
            phoneArr[i] = phone.charAt(i);
            if(i == 3 || i == 4 || i == 5 || i == 6) {
                phoneArr[i] = '*';
            }
        }

        // 전화번호 출력
        System.out.print("출력 : ");
        for(int i = 0; i < phoneArr.length; i++) {
            System.out.print(phoneArr[i]);
        }

    }
}

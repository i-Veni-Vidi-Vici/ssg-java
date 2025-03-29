package com.ssg.test.array;

import java.util.Scanner;

public class Test4 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        char [] userNumber = new char[11];

        System.out.print("전화번호 입력 : ");
        String phoneNumber = sc.next();

        for (int i = 0; i < userNumber.length; i++) {
            userNumber[i] = phoneNumber.charAt(i);
            if (i >=3 && i <=6) {
                userNumber[i] = '*';
            }
        }

        System.out.print("출력 : ");

        for (int j = 0; j < userNumber.length; j++) {
            System.out.print(userNumber[j]);
        }

    }

}

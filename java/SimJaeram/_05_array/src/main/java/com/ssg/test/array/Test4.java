package com.ssg.test.array;

import java.util.Scanner;

public class Test4 {
    public static void main(String[] args) {
        // 변수 선언
        Scanner sc = new Scanner(System.in);
        String phone = "";
        char[] phoneArr = new char[11];
        char[] phoneArrStar = new char[11];

        // 전화번호 입력
        System.out.print("전화번호 입력 : ");
        phone = sc.next();
        for(int i = 0; i < phone.length(); i++) {
            phoneArr[i] = phone.charAt(i);
        }

        // 전화번호 출력
        System.out.print("출력 : ");
        for(int i = 0; i < phoneArr.length; i++) {
            // 전화번호 가운데 4자리 *로 마스킹
            phoneArrStar[i] = phoneArr[i];
            if(i == 3 || i == 4 || i == 5 || i == 6) {
                phoneArrStar[i] = '*';
            }

            // 출력
            System.out.print(phoneArrStar[i]);
        }

    }
}

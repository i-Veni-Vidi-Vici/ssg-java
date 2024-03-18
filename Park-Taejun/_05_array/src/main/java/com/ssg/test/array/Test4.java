package com.ssg.test.array;

import java.util.Scanner;

public class Test4 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("전화번호를 입력하세요 : ");
        String str = sc.nextLine();

        char[] phoneNumber = new char[str.length()]; // str 길이 만큼 char 배열 그릇 생성 phoneNumber 인덱스 0부터 시작하므로
        System.out.print("출력");
        int i;
        for (i = 0; i < str.length(); i++) {
            if (i >= 3 && i <= 6) {
                phoneNumber[i] = '*';
            } else {
                phoneNumber[i] = str.charAt(i);

            }
            System.out.print(phoneNumber[i]);
        }


    }
}




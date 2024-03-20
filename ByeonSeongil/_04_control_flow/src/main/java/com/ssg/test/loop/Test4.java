package com.ssg.test.loop;

import java.util.Scanner;

public class Test4 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("문자열 입력:");
        String str = sc.next();

        System.out.print("검색할 문자 입력:");
        char value = sc.next().charAt(0);

        /// 소문자만
        if (!(value >= 'a' && value <= 'z')) {
            System.out.println("영문자 아님");
            return;
        }

        int count = 0;
        for (int i = 0; i < str.length(); i++) {
            if (str.charAt(i) == value) {
                count++;
            }
        }
        System.out.printf("'%c'가 포함된 개수: %d", value, count);
    }
}

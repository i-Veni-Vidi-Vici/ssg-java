package com.ssg.test.loop;

import java.util.Scanner;

public class Test4 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("문자열 입력: ");
        String str = sc.next();
        System.out.print("검색할 문자: ");
        char word = sc.next().charAt(0);

        if ((word >= 'A' && word <= 'Z') || (word >= 'a' && word <= 'z')) {
            int count = 0;
            for (int i = 0; i < str.length(); i++) {
                if (str.charAt(i) == word) {
                    count++;
                }
            }
            System.out.println(count);
        }
        else {
            System.out.println("영문자가 아닙니다.");
        }

    }
}

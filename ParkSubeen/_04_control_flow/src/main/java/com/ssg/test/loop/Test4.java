package com.ssg.test.loop;

import java.util.Scanner;

public class Test4 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("문자열 입력 : ");
        String str = sc.next();

        System.out.print("검색할 문자 입력 : ");
        char ch = sc.next().charAt(0);

        if((ch >= 'A' && ch <= 'Z') || (ch >= 'a' && ch <= 'z')) {
            int i = 0;
            int sum = 0;
            while (i < str.length()) {
                if (str.charAt(i) == ch) {
                    sum += 1;
                }
                i++;
            }
            System.out.printf("'%c'가 포함된 갯수 : %d 개", ch, sum);
        } else {
            System.out.println("영문자가 아닙니다.");
        }
    }
}

package com.ssg.test.loop;

import java.util.Scanner;

public class Test4 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("문자열 입력 : ");
        String str = sc.nextLine();
        System.out.print("검색할 문자 입력 : ");
        char ch = sc.next().charAt(0);
        int cnt = 0;


        if (ch >= 'A' && ch <= 'Z' || ch >= 'a' && ch <= 'z') {
            for (int i = 0; i < str.length(); i++) {
                if (str.charAt(i) == ch) {
                    cnt += 1;
                }
            }
            System.out.println(ch + "가 포함된 갯수 : " + cnt);
        } else {
            System.out.println("영문자가 아닙니다");
        }
    }
}

package com.ssg.test.loop;

import java.util.Scanner;

public class Test4 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("문자열 입력 : ");
        String str = sc.nextLine();
        System.out.print("검색할 문자입력 : ");
        char n = sc.next().charAt(0);
        int num = 0;

        if ((n >= 65 && n <= 90) || n >= 97 && n <= 122) {
            for (int i = 0; i < str.length(); i++) {
                if (str.charAt(i) == n) {
                    num++;
                }
            }
            System.out.println(n + "가 포함된 갯수 : " + num + "개");

        }
        else{
            System.out.println("영문자가 아닙니다");
        }
    }
}

package com.ssg.test.loop;

import java.util.Scanner;

public class Test4 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("문자열 입력 : ");
        String str = sc.nextLine();
        System.out.println("검색할 문자 입력 : ");
        char a = sc.nextLine().charAt(0);
        if (a <= 96 || a >= 123) {
            System.out.println("영문자가 아닙니다.");

        } else {
            int num = 0;
            int i = 0;
            while (i < str.length()) {
                if (a == str.charAt(i)) {
                    num += 1;
                }
                i++;
            }
            System.out.println("'" + a + "'" + "가 포함된 갯수 : " + num + "개");
        }
    }

}

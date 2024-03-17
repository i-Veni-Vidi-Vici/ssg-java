package com.ssg.test.array;

import java.util.Scanner;

public class Test3 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("문자열 입력 : ");
        String s = sc.next();
        System.out.print("검색 문자 입력 : ");
        char c = sc.next().charAt(0);

        int count = 0;
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == c) {
                count++;
            }
        }
        System.out.println("출력 : 입력하신 문자열 " + s + "에서 찾으시는 문자 " + c + "는 " + count + "개 입니다.");
    }
}

package com.ssg.test.array;

import java.util.Scanner;

public class Test3 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("문자열 입력: ");
        String str = sc.next();
        System.out.print("검색문자 입력:  ");
        char searchWord = sc.next().charAt(0);

        int count = 0;
        for (int i = 0; i < str.length(); i++) {
            if (str.charAt(i) == searchWord) {
                count++;
            }
        }

        System.out.printf("출력: 입력하신 문자열 %s에서 찾으시는 문자 %s은 %d개 입니다.", str, searchWord, count);
    }
}

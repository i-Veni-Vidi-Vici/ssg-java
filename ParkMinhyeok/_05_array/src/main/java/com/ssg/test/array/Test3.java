package com.ssg.test.array;

import java.util.Arrays;
import java.util.Scanner;

public class Test3 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int cnt = 0;

        System.out.println("문자열 입력 : ");
        String str =  scanner.next();
        char [] charArray = str.toCharArray();
//        System.out.println("charArray: " + Arrays.toString(charArray));

        System.out.println("검색 문자 입력 : ");
        char ch = scanner.next().charAt(0);

        for (char c : charArray) {
            if (c == ch) {
                cnt++;
            }
        }
        System.out.printf("출력 : 입력하신 문자열 %s에서 찾으시는 문자 %c은 %d개 입니다", str, ch, cnt);

    }
}

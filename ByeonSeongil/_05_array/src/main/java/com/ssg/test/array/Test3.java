package com.ssg.test.array;

import java.util.Scanner;

public class Test3 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("문자열 입력 :");
        String value = sc.next();
        String[] str = value.split("");

        System.out.print("검색 문자 입력 :");
        String next = sc.next();

        int count =0;
        for (String string : str) {
            if (string.equals(next)) {
                count++;
            }
        }

        System.out.printf("입력하신 문자열 %s에서 같은 문자는 %d입니다.", value, count);
    }
}

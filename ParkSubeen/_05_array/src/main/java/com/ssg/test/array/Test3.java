package com.ssg.test.array;

import java.util.Scanner;

public class Test3 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("문자열 입력 : ");
        String str = sc.next();

        String[] arr = new String[str.length()];
        for(int i = 0; i < str.length(); i++) {
            arr[i] = String.valueOf(str.charAt(i));
        }

        System.out.print("검색문자 입력 : ");
        char search = sc.next().charAt(0);

        int num = 0;
        for(int i = 0; i < str.length(); i++) {
            if(arr[i].equals(String.valueOf(search))) {
                num += 1;
            }
        }
        System.out.printf("출력: 입력하신 문자열 %s에서 찾으시는 문자 %c은 %d개 입니다", str, search, num);
    }
}

package com.ssh.test.loop;

import java.util.Scanner;

public class Test4 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        while (true) {
            System.out.print("문자열 입력 : ");
            String s = sc.next();

            System.out.print("검색할 문자 입력 : ");
            char c = sc.next().charAt(0);
            if (!(c >= 'a' && c <= 'z') && !(c >= 'A' && c <= 'Z')) {
                System.out.println("영문자가 아닙니다.");
                break;
            }

            int count = 0;
            for (int i = 0; i < s.length(); i++) {
                if (s.charAt(i) == c) {
                    count++;
                }
            }
            System.out.println("'" + c + "'가 포함된 갯수 : " + count + "개\n");
        }
    }
}

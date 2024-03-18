package com.ssg.test.array;

import java.util.Scanner;

public class Test4 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("전화번호 입력: ");
        String value = sc.next();
        String[] result = value.split("");
        for (int i = 3; i <= 6; i++) {
            result[i] = "*";
        }
        System.out.print("출력: ");
        for (String string : result) {

            System.out.print(string);
        }
    }
}

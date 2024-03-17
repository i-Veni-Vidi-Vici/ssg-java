package com.ssg.test.array;

import java.util.Scanner;

public class Test4 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("전화번호 입력: ");
        String phone = sc.next();
        String show = "";

        for (int i = 0; i < phone.length(); i++) {
            if (i >= 3 && i <= 6) {
                show += '*';
            } else {
              show += phone.charAt(i);
            }
        }

        System.out.println(show);
    }
}

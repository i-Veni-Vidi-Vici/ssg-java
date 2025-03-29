package com.ssg.test.array;

import java.util.Scanner;

public class Test4 {
    public static void main(String[] args) {
        char [] phone = new char[11];
        String str;
        Scanner sc = new Scanner(System.in);
        System.out.print("> 전화번호 입력 : ");
        str = sc.next();
        phone = str.toCharArray();

        for(int i=3; i<7;i++ ){
            phone[i] = '*';
        }
        for(int i=0; i<11; i++) {
            System.out.print(phone[i]);
        }
    }
}

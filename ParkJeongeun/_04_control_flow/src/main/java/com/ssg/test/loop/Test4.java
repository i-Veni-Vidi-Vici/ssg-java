package com.ssg.test.loop;

import java.util.Scanner;

public class Test4 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("> 문자열 입력 : ");
        String str = sc.nextLine();
        System.out.print("> 검색할 문자 입력 : ");
        char ch = sc.next().charAt(0);

        boolean range = (ch >= 65 && ch <= 90) || (ch >= 97 && ch <= 122);
        if (range == false) {
            System.out.println("영문자가 아닙니다.");
            return;
        }

        System.out.print("> \'" + ch + "\'가 포함된 개수 : ");
        int sum = 0;
        char n = ' ';
        for (int i = 0; i < str.length(); i++){
            n = str.charAt(i);
            if (ch == n){
                sum += 1;
            }
        }
        System.out.println(sum + "개");
    }
}
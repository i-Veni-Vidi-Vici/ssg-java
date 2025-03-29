package com.ssg.test.loop;

import java.util.Scanner;

public class Test4 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String str = "";
        char ch;
        int strLeng;
        int count = 0;

        System.out.print("문자열 입력 : ");
        str = sc.nextLine();
        System.out.print("검색할 문자 입력 : ");
        ch = sc.next().charAt(0);
        strLeng = str.length();

        if(((ch >= 65 && ch <= 90)||(ch >= 97 && ch <= 122)) == false) {
            System.out.println("영문자가 아닙니다.");
            return;
        }

        for(int i = 0; i < strLeng; i++) {
            if(ch == str.charAt(i)) {
                count++;
            }
        }

        System.out.println(ch + "가 포함된 갯수 : " + count + "개");
    }
}

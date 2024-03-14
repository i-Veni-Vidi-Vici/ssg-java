package com.ssg.test.loop;

import java.util.Scanner;

public class Test4 {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.print("문자 입력 : ");
        String userStr = sc.next();

        System.out.println("검색할 문자 입력 : ");
        char searchStr = sc.next().charAt(0); // 검색할 문자

        if (searchStr < 'A' || (searchStr >= 'Z' && searchStr <'a')) {
            System.out.println("영문자가 아닙니다. 프로그램 끝!");
        }
        else {
            for (int i = 0; i <userStr.length(); i++) {
                char word = userStr.charAt(i); //내가 입력한 문자의 첫 글자

                if(word == userStr.charAt(i)) {
                    int count = 0;
                }
            }

            int count = 0;
            while (count <= userStr.length()) {
                for (int i= 0; i < userStr.length() - 1; i++){

                }
            }
        }



    }
}

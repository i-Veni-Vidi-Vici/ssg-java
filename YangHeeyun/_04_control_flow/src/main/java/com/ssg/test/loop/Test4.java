package com.ssg.test.loop;

import java.util.Scanner;

public class Test4 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("문자열 입력 : ");
        String sentence = sc.nextLine();
        System.out.print("검색할 문자 입력 : ");
        char word = sc.next().charAt(0);

        int wordNum = 0;
        if((word >= 'A' && word <= 'Z') || (word >= 'a' && word <= 'z')) {
            for (int i = 0; i < sentence.length(); i++) {
                if (sentence.charAt(i) == word) {
                    wordNum++;
                }
            }
            System.out.printf("'%c'가 포함된 갯수 : %d 개",word,wordNum);
        }else{
            System.out.println("영문자가 아닙니다.");
        }

    }
}
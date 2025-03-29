package com.ssg.test.loop;

import java.util.Scanner;

public class Test4 {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.print("문자 입력 : ");
        String userStr = sc.next();

        System.out.println("검색할 문자 입력 : ");
        char searchStr = sc.next().charAt(0); // 검색할 문자
        int count = 0; //똑같은 문자 개수 확인 카운트

        if (searchStr < 'A' || (searchStr >= 'Z' && searchStr <'a')) {
            System.out.println("영문자가 아닙니다. 프로그램 끝!");
        }
        else {
            for (int i = 0; i <= userStr.length(); i++) {
                char word = userStr.charAt(i); // 입력한 문자가 검색할 문자와 같은지 비교하기 위한 변수

                if(word == searchStr) {
                    count ++;
                }
            }
        }
        System.out.println(searchStr + "은 " + userStr + "안에 " + count + "개 있습니다.");



    }
}

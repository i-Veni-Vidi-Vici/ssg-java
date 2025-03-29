package com.ssg.test.array;

import java.util.Arrays;
import java.util.Scanner;

public class Test3 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("문자열 입력: ");
        String str = sc.next();
        System.out.println("검색할 문자 입력: ");
        char sChar = sc.next().charAt(0);

        int count = 0;
        for(int i = 0; i<str.length(); i++){
            if(str.charAt(i) == sChar){
                count++;
            }
        }
        System.out.println("입력하신 문자열 " + str + "에서 찾으시는 문자 " + sChar + "은 " + count + "개 입니다.");
    }
}

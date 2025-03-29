package com.ssg.test.loop;

import java.util.Scanner;

public class Test4 {
    public static void main(String[] args) {
        // 문제 4.
        Scanner sc = new Scanner(System.in);
        System.out.print("문자열 입력 : ");
        String str = sc.nextLine();
        System.out.print("문자 입력 : ");
        char ch = sc.nextLine().charAt(0);
        int answer = 0;
        // 검색할 문자가 영문자인지 아닌지 검사하는 과정
        if( (ch >= 65 && ch <= 90) || (ch >= 97 && ch <= 122) ) {
        // 검색할 문자가 영문자일 경우, 문자열에 그 문자가 몇 개 들어있는지 갯수 확인하는 과정
            // 문자열의 문자를 문자열의 길이만큼 하나하나씩 뽑기
            for (int i = 0; i < str.length(); i++) {
                // 문자열의 문자 하나하나와 검색할 문자가 같으면 answer에 합치기
                if (str.charAt(i) == ch) {
                    answer += 1;
                }
            }
            System.out.println("'" + ch + "'가 포함된 갯수 : " + answer + "개");
        }
        else {
            System.out.println("영문자가 아닙니다.");
        }
    }
}

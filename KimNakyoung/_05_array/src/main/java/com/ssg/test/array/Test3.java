package com.ssg.test.array;

import java.util.Scanner;

/**
 *
 * - 문자열을 하나 입력 받아 문자 배열에 넣고
 * - 검색할 문자를 하나 입력 받아
 * - 검색 문자가 문자열에 몇 개인지 개수를 출력하는 프로그램을 작성하세요.
 */
public class Test3 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("문자열 입력: ");
        String string = sc.nextLine(); // 문자열
        System.out.println("검색할 문자 입력 : ");
        char searchChar = sc.nextLine().charAt(0); // 검색할 문자 입력

        int cnt = 0;
        for (int i = 0; i < string.length(); i++) {
            if (string.charAt(i) == searchChar) {
                cnt++;
            }

        }
        System.out.println("입력하신 문자열 " + string + "에서 찾으시는 문자 " + searchChar + "은 " + cnt + "개 입니다" );


    }

}

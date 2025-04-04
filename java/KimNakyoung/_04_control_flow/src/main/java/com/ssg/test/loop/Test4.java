package com.ssg.test.loop;

import java.util.Scanner;

/**
 * - 문자열과 문자열에서 검색될 문자를 입력 받아 문자열에 그 문자가 몇 개이었는지 개수를 확인하는 프로그램을 작성하세요.
 * - 또, 검색할 문자가 영문자가 아니면 "영문자가 아닙니다." 출력후
 * 프로그램을 종료하세요.
 * - 문자열의 길이를 리턴하는 String의 메소드를 api에서 찾아 사용하세요.
 */
public class Test4 {
    public static void main(String[] args) {

        String str = "";
        char chSearch = ' '; // char 반드시 값 할당.
        int count = 0;
        char tmp;
        Scanner sc = new Scanner(System.in);
        System.out.print("문자열 입력 : ");
        str = sc.nextLine();
        System.out.print("검색할 문자 입력 : ");
        chSearch = sc.next().charAt(0);

        // 검색 할 문자가 영문자가 아니면 종료
        if (!(('A' <= chSearch) && ('Z' >= chSearch)) || ('a' <= chSearch) && ('z' >= chSearch)) {
            System.out.println("영문자가 아닙니다.");
            return;
        }

        for (int i = 0; i < str.length(); i++) {

            tmp = str.charAt(i);
            // char은 기본타입이라 비교연산자 가능, String은 참조타입이라 비교연산자 불가능
            if (chSearch == tmp){
                count ++;
            }

        }System.out.println("'" + chSearch+ "'" + "가 포함된 갯수 :"+ count + "개");

    }
}
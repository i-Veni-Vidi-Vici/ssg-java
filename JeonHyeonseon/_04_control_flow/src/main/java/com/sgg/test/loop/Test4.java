package com.sgg.test.loop;

import java.util.Scanner;

public class Test4 {
    public static void main(String[] args) {

        /**
         * - 문자열과 문자열에서 검색될 문자를 입력 받아 문자열에 그 문자가 몇 개이었는지 개수를 확인하는 프로그램을 작성하세요.
         * - 또, 검색할 문자가 영문자가 아니면 "영문자가 아닙니다." 출력후 프로그램을 종료하세요.
         * - 문자열의 길이를 리턴하는 String의 메소드를 api에서 찾아 사용하세요.
         */

        Scanner sc = new Scanner(System.in);
        System.out.print("문자열 입력 : " );
        String str = sc.nextLine(); // String은 문자열
        System.out.print("검색할 문자 입력 : ");
        char text = sc.next().charAt(0); // 0번째 인덱스 문자를 가져온다.

        if((text >= 'A' && text <= 'Z') || (text >= 'a' && text <= 'z')) {

            // 문자 유효성 체크
            int count = 0; // 개수보관할 변수

            for(int i = 0; i < str.length(); i++){
                char ch = str.charAt(i); // ch가 뭘까.
                if (ch == text) // 만약 문자와 ch가 같다면
                    count++; // 개수가 증가한다.

            }
        } else {
            System.out.println("영문자가 아닙니다.");
        }
    }
}

package com.ssg.test.loop;

import java.util.Scanner;

public class Test4 {
    public static void main(String[] args) {
        Test4 test4 = new Test4();
        test4.test();
    }

    public void test() {
        Scanner sc = new Scanner(System.in);
        System.out.print("문자열 입력 : ");
        String str = sc.next(); // 입력한 문자열
        System.out.print("검색할 문자 입력 : ");
        char letter = sc.next().charAt(0);  // 검색할 문자
        int cnt = 0;  // 문자가 포함된 갯수
        boolean isEng = (letter>='A' && letter<='Z') || (letter>='a' && letter<='z');

        if(isEng) {
            for (int i = 0; i < str.length(); i++) {
                if (str.charAt(i) == letter)
                    cnt++;
            }
            System.out.println("'" + letter + "'가 포함된 갯수 : " + cnt + "개");
        } else
            System.out.println("영문자가 아닙니다.");
    }
}

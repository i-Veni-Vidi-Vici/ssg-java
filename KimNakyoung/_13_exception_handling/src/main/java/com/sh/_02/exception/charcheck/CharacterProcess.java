package com.sh._02.exception.charcheck;

import java.util.Scanner;

public class CharacterProcess {
    String s = "";
    public int countAlpha(String s) {
        int count = 0;
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) >= 'a' && s.charAt(i) <= 'z' || s.charAt(i) >= 'A' && s.charAt(i) <= 'Z') {
                count++;
            }
            if (s.charAt(i) == ' ') { // 공백 문자가 있는지 확인
                throw new CharCheckException("체크할 문자열 안에 공백 포함할 수 없습니다.");
            }
        }
            System.out.println("영문자 개수는 " + count + "입니다.");

        return count;
    }



    public void test1() {
        Scanner sc = new Scanner(System.in);
        System.out.println("문장을 입력해주세요");
        s = sc.nextLine(); // 공백있는건 nextLine()이다.
        try {
            countAlpha(s);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

    }
}

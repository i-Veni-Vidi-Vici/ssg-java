package com.ssg.exception.charcheck;

import java.util.Scanner;

public class CharacterProcess {

    public void countAlpha(String s){
        int cnt = 0;
        try {
            for (int i = 0; i < s.length(); i++) {
                char ch = s.charAt(i);
                if ((ch >= 'a' && ch <= 'z') || (ch >= 'A' && ch <= 'Z')) {
                    cnt++;
                }  if (s.contains(" ")) {
                    throw new CharCheckException("에러: 문자열에 공백이 포함되어 있습니다.");
                }
            }
            System.out.println("입력된 영문자는 : " + cnt + "개입니다.");
        } catch (CharCheckException e) {
            throw new CharCheckException(e.getMessage());
        }
    }
}

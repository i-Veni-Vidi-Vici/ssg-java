package com.ssg.exception.charcheck;

public class CharacterProcess {
    public CharacterProcess() {}

    public int countAlpha(String s) {
        int countChar = 0;
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == ' ') {
                throw new RuntimeException("체크할 문자열 안에 공백 포함할 수 없습니다.");
            }

            if ((s.charAt(i) >= 'A' && s.charAt(i) <= 'Z') || (s.charAt(i) >= 'a' && s.charAt(i) <= 'z')) {
                countChar++;
            }
        }
        return countChar;
    }
}

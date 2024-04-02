package com.ssg.exception.charcheck;

public class CharacterProcess {
    public int countAlpha(String s) throws CharCheckException {
        int count =0;

        for (char c : s.toCharArray()) {
            if ((c >= 'a' && c <= 'z') || c >= 'A' && c <= 'Z') {
                count++;
            } else if (c == ' ') {

                throw new CharCheckException("체크할 문자열 안에 공백 포함 불가");
            }

        }

        return count;
    }
}

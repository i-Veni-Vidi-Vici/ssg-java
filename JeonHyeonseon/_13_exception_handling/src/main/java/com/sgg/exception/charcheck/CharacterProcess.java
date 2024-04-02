package com.sgg.exception.charcheck;

public class CharacterProcess {
    public CharacterProcess() {} // 기본생성자

    public static int countAlpha(String s) {
        int count = 0; // 전달된 문자열값에서 영문자가 몇 개인지 세기
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == ' ') { // 공백문자가 있다면
                throw new CharCheckException("체크할 문자열 안에 공백 포함할 수 없습니다.");
            }
            if((s.charAt(i) >= 'A' && s.charAt(i) <= 'Z') ||
                    (s.charAt(i) >= 'a' && s.charAt(i) <= 'z'));
            count++;
        }
        return count;  // 카운트해서 리턴
    }

}

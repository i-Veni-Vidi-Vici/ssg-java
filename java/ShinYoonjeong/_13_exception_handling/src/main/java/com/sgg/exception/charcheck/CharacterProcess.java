package com.sgg.exception.charcheck;

public class CharacterProcess {
    public int countAlpha(String s){
        int count = 0;

        if(s.contains(" ")){
            throw new CharCheckException("체크할 문자열 안에 공백 포함할 수 없습니다.");
        }
        for (char c : s.toCharArray()) {
            if (Character.isLetter(c)) {
                    count++;
            }
        }


        return count;


    }
}

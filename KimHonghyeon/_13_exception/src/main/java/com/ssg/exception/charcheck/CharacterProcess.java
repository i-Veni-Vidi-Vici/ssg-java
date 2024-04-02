package com.ssg.exception.charcheck;

public class CharacterProcess {
    public int countAlpha(String str) throws CharCheckException{
        if (str.contains(" "))throw new CharCheckException("문자열 안에 공백을 포함할 수 없습니다.");
        else{
            int count =0;
            for(int i = 0; i<str.length(); i++){
                if(Character.isAlphabetic(str.charAt(i)))count++;
            }
            return count;
        }
    }
}

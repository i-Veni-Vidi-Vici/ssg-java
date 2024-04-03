package com.ssg.exception.charcheck;

public class CharacterProcess {
    public int countAlpha(String s){
        int count = 0;
        char ch;
        for(int i = 0; i<s.length();i++)
        {
            ch = s.charAt(i);
            if(ch == ' ') throw  new CharCheckException("체크 할 문자열 안에 공백은 포함 할 수 없습니다.");
            else if((ch>= 'a' && ch <= 'z') || (ch >='A' && ch<='Z')) count ++;
        }
        return count;
    }
}

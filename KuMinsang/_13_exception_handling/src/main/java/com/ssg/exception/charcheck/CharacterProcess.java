package com.ssg.exception.charcheck;

public class CharacterProcess {
    public CharacterProcess() {
    }
    public int countAlpha(String s){
        int cnt=0;
        for(char ch : s.toCharArray()){
            if(('a'<=ch && ch<='z') || ('A'<=ch && ch<='Z'))
                cnt++;
            else if(ch == ' '){
                throw new CharCheckException("체크할 문자열 안에 공백 포함할 수 없습니다");
            }
        }
        return cnt;
    }
}

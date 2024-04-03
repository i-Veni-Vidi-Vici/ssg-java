package com.ssg.exception.charcheck;

import java.util.Iterator;

public class CharacterProcess {

    public int countAlpha(String str) {
        int cnt = 0;
        try {
            for (int i = 0; i < str.length(); i++)
            {
                if (str.charAt(i) == ' ')
                {
                    throw new CharCheckException("체크할 문자열 안에 공백 포함할 수 없습니다.");
                }
                else cnt++;
            }
        } catch (CharCheckException e) {
            System.out.println(e.getMessage());
        }
        return cnt;
    }
}


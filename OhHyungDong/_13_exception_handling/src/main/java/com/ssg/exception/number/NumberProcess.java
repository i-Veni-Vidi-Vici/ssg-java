package com.ssg.exception.number;

import com.ssg.exception.charcheck.CharCheckException;

public class NumberProcess {
    public boolean checkDouble(int a, int b){
        if((a < 1 || a> 100) || (b < 1 || b>100)) throw new NumberRangeException("1부터 100사이의 값이 아닙니다.");
        else if(a % b == 0) return true;
        else return false;

    }
}

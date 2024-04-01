package com.sgg.exception.number;

public class NumberProcess {
    public NumberProcess(){} // 기본생성자

    public boolean checkDouble(int a, int b) {
        if((a >= 1 && a <= 100) && (b >= 1 && b <= 100)){
            return a % b == 0;
        }
        else {
            throw new NumberRangeException("1부터 100사이의 값이 아닙니다.");
        }
    }
}

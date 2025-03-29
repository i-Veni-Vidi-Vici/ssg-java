package com.sgg.exception.number;

public class NumberProcess {
    public boolean checkDouble(int a, int b){

        if(!(1<=a&&a<=100||1<=b&&b<=100))
            throw new NumberRangeException("1 부터 100 사이의 값이 아닙니다.");
        if(a%b==0){
            return true;
        }
        return false;



    }
}

package com.ssg.exception.number;

public class NumberProcess {
    public boolean checkDouble(int num1, int num2) {

        if(num1<0 || 100 < num1){
            throw new NumberRangeException("1부터 100사이의 값이 아닙니다");
        }else if(num2<0 || 100 < num2){
            throw new NumberRangeException("1부터 100사이의 값이 아닙니다");
        }
        if(num1%num2 == 0){
            return true;
        }else{
            return false;
        }
    }
}

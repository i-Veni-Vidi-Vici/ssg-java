package com.ssg.exception.number;

import java.util.Scanner;

public class NumberProcess {
    public boolean checkDouble(int a, int b) throws NumberRangeException{
        if(a<1 || a>100 || b<1 || a>100) throw new NumberRangeException("1~100사이의 값이 아닙니다.");
        else return (a%b==0);
    }
}

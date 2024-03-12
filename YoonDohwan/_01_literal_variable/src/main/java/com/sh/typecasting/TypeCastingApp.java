package com.sh.typecasting;
/*
컴퓨터의 작동원리
-같은 타입의 자료형끼리 연산이 가능하다.
-결과 역시 같은 타입이다.

형변환
-다른 타입끼리 연산해야 하는 경우, 필연적으로 형변환이 필요하다.
-자동현변환(암묵적 형변환)-컴파일러가 자동으로 수행하는 형변환
     -크기가 작은 타입에서 큰 타입으로 자동으로 변환된다.
     -정수는 실수로 자동 변환된다.
     -문자는 정수 int로 자동변환된다
     -값이 유실되지 않는 범위에서 자동변환된다.
     -byte(1) - short (2) -
-수동형변환(명시적 형변환)-코드로써 직접 수행하는 형변환



 */
public class TypeCastingApp {
    public static void main(String[] args){
        byte bnum=100;
        short snum=bnum;//대입연산,byte 값을 short 공간에 대입.byte가
        int inum = snum;//int=short short가 int로 변환후 대입연산
        long lnum=inum;//long=int int가 long으로 변환후 대입연산
        long result = inum + lnum;//int+long -> int가 long으로 변환후 long+long -> long 결과
        //실수관련
        float fnum=123.456f;
        double dnum=fnum;
        double result2=fnum+dnum;
        long eight = 8;
        float fvalue = eight;
        System.out.println(fvalue);
        float result3 = inum+fvalue;//int+float-> int가 float로 변환후 float+float -> float 결과
        //문자 관련
        char ch = 'a';
        int iChar= ch;
        System.out.println(iChar);

    }
}

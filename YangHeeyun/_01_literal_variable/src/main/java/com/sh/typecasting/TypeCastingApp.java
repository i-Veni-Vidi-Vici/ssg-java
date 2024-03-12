package com.sh.typecasting;

public class TypeCastingApp {
    public static void main(String[] args) {
        //정수 관련
        byte bnum= 100;
        short snum= bnum; // 대입연산. byte값을 short 공간에 대입. byte가 short로 자동형변환 후에 대입연산
        int inum=snum; // int= short short가 int로 변환 후 대입연산
        long lnum=inum; // long =int int가 long으로 변환 후 대입연산

        long result = inum + lnum; // int + long -> int가 long으로 변환 후 long + long -< long 결과

        // 실수 관련
        float fnum=123.456f;
        double dnum= fnum; // float이 double로 자동변환 후에 대입연산

        double result2 = fnum+dnum; // float + double -> float이 double로 변환 후 double + double -> double 결과값

        // 정수/실수 관련
        long eight = 8;
        float fValue = eight; // 소수점을 부여해서 float으로 변환. 데이터 손실은 없다.

        System.out.println(fValue);

        float result3 = inum +fValue; // int + float -> int가 float로 변환 후 float + float -> float 결과

        //문자 관련
        char ch= 'a';
        int iChar = ch; // int=char -> char를 int로 변환 후 대입연산
        System.out.println(iChar);
    }

}

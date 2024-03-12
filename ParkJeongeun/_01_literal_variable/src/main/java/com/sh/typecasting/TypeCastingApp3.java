package com.sh.typecasting;

/**
 * 예외적인 형변환 케이스
 * - 정수값을 char에 대입하는 경우 자동변환
 * - int 보다 작은 정수형 연산은 모두 int로 변환 후 처리
 */

public class TypeCastingApp3 {

    public static void main(String[] args) {
        // 정수를 문자에 대입
        char ch = 97; // char = int
        System.out.println(ch); // a

        ch = 100; //char 2byte이므로 65536개(0~65535)의 값 표현가능
//        ch = 70000; // 범위를 벗어난 수는 자동처리 X

        // byte, short 연산
        byte bnum1 = 10;
        byte bno2 = 20;
//        byte bResult = bnum1 + bno2; // int + int
        byte bResult = (byte)(bnum1 + bno2);
        System.out.println(bResult);
    }
}

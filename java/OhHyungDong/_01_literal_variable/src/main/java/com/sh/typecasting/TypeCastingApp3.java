package com.sh.typecasting;

/**
 * <pre>
 * 예외적인 형변환 클래스
 * - 정수값을 char에 대입하는 경우 자동으로 변환처리된다.
 * - int보다 작은 정수형 연산은 모두 int로 변환 후 처리된다 .
 * </pre>
 */

public class TypeCastingApp3 {
    public static void main(String[] args) {
        //정수를 문자에 대입하는 경우

        char ch = 97; // 정수값을 char에 대입하는 경우 자동으로 변환 처리된다.
        System.out.println(ch);

        ch = 100; //char - 2byte이므로 65536개(0 ~ 65535)의 값을 표쳔 가능
        ch = 45000;
        // ch = 70000 범위를 벗어난 수는 자동처리 할 수 없다.
        System.out.println(ch);

        //byte, short 연산
        byte bnum1 = 10;
        byte bnum2 = 20;
        byte bResult = (byte)(bnum2 + bnum1);//byte + byte -> int + int -> int형으로
    }
}

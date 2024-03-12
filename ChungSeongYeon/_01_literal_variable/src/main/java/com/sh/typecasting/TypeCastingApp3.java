package com.sh.typecasting;

/**
 * 예외적인 형변환 케이스
 * - 정수 값을 char에 대입하는 경우 자동 변환 처리된다.
 * - int보다 작은 정수형 연산은 모두 int로 변환 후 처리된다.
 */

public class TypeCastingApp3 {
    public static void main(String[] args){

        //정수를 문자에 대입하는 경우
        char ch = 97; // char에 int를 대입?
        System.out.println(ch); // a

        ch = 45000; // char는 2byte이므로 65536개(0~65535)의 값을 표현할 수 있다.
        System.out.println(ch); // 45000 = 꿈 이라고 한글 한 글자가 결과로 나온다. 범위를 벗어난 수는 자동 처리 할 수 없다.

        // byte, short 연산
        byte bno1 = 10;
        byte bno2 = 20;
        byte bResult = (byte)(bno1 + bno2); // byte + byte -> int + int -> int |
        // byte bResult = bno1 + bno2; -> 오류 발생. 우항에서 제공한 값은 int -> 정수의 기본 값이기 때문에.
        System.out.println(bResult);
    }
}

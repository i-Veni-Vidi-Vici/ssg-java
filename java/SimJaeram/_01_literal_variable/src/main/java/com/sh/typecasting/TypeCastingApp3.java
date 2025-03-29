package com.sh.typecasting;

/**
 * <pre>
 *     예외적인 형변환 케이스
 *     - 정수값을 char에 대입하는 경우 자동변환 처리된다.
 *     - int보다 작은 정수형 연산은 모두 int로 변환 후 처리된다.
 * </pre>
 */

public class TypeCastingApp3 {
    public static void main(String[] args) {
        // 정수를 문자에 대입하는 경우
        char ch = 97; // char = int
        System.out.println(ch); // a

        ch = 45000; // char는 2 byte이므로 65536개(0~65535)의 값을 표현가능
//        ch = 70000; // 범위를 벗어난 수는 자동처리할 수 없다.
        System.out.println(ch); // 꿈

        // byte, short 연산
        byte bno1 = 10;
        byte bno2 = 20;
        byte bResult = (byte) (bno1 + bno2); // byte + byte 이더라도 내부적으로 계산하기 int가 최적화 되어있어서 int로 변환되어 계산된다.
        System.out.println(bResult);
    }
}

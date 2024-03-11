package com.sh.typecasting;

public class TypeCastingApp3 {
    /**
     * 예외적인 형변환 케이스
     * - 정수값을 char에 대입하는 경우 자동변환 처리된다.
     * - int보다 작은 정수형 연산은 모두 int로 변환후 처리된다.
     * @param args
     */
    public static void main(String[] args) {
        // 정수를 문자에 대입하는 경우
        char ch =97; // char = int
        System.out.println(ch);

        ch = 45000; // char = 2byte 이므로 65536개(0~65535)의 값을 표현 가능
        // ch = 70000 // 범위를 벗어난 수는 자동처리할 수 없다.
        System.out.println(ch);

        // byte, short연산
        byte bnum1 = 10;
        byte bnum2 = 20;
        byte bResult = (byte) (bnum1 + bnum2); // byte + byte -> int + int
    }
}

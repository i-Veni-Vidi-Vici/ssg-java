package com.sh.typecasting;

/**
 * <h3>예외적인 형변환</h3>
 * <pre>
 *     - 정수값을 char에 대입하는 경우 자동 변환
 *     - int 보다 작은 정수형 연산은 모두 int 로 변환 후 처리된다.
 * </pre>
 */
public class TypeCastingApp3 {
    public static void main(String[] args){
        // 정수를 문자에 대입하는 경우
        char ch = 97;
        System.out.println(ch); // a

        ch = 45000; // char 2byte 이므로 65536개(0~65536)의 값을 표현 가능
        System.out.println(ch);

        // byte, short 연산
        byte bnum1 = 10;
        byte bnum2 = 20;
        byte bResult = (byte)(bnum1 + bnum2); // int 보다 작은 정수형 연산은 모두 int 로 변환 후 처리된다.

    }
}

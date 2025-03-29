package com.sh.typecasting;

/**
 *
 */
public class TypeCastingApp3 {
    public static void main(String[] args) {
        //정수를 문자에 대입하는 경우
        char ch = 97;
        System.out.println(ch); // a

        ch = 45000; //char 2byte이므로 65536개 (0 ~ 65535)의 값을 표현 가능
//        ch = 70000; //범위를 벗어난 수는 자동처리할 수 없움
        System.out.println(ch);

        // byte, short 연산
        byte bnum1 = 10;
        byte bnum2 = 20;
        byte bResult = (byte) (bnum1 + bnum2); // byte + byte -> int + int -> int
        System.out.println(bResult);
    }
}

package com.sh.typecasting;

/**
 * 예외적인 형변환 케이스
 * - 정수 값을 char에 대입하는 경우 자동변환 처리된다
 * - int보다 작은 정수형 연산은 모두 int로 변환 후 처리된다
 */

public class TypeCasting3 {
    public static void main(String[] args) {
        // 정수를 문자에 대입하는 경우
        int a = 97;
        char ch = (char)a;
        System.out.println(ch); //문자 a가 출력

        ch = 40304; // char 2byte이므로 65536개 (0 ~ 6535)의 값을 표현가능
        //    ch = 70000; //범위를 벗어난 수는 자동처리할 수 없다.
        System.out.println(ch);

        // byte, short 연산
        byte bnum1 = 10;
        byte bnum2 = 20;

        int bRsult = (bnum1 + bnum2); //바이트 + 바이트 연산은 인트+인트->인트
        //예외적으로 효율적이기 때문에 채택


    }
}

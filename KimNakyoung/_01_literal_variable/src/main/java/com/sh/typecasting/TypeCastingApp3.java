package com.sh.typecasting;

/**
 * 예외적인 형변환 케이스
 * - 정수값을 char에 대입하는 경우 자동변환 처리된다.
 * - int 보다 작은 정수형 연산은 모두 int로 변환후 처리된다.
 *
 */



// 이름 바꾸기 단축키 바꿀거 누르고 shift + f6
public class TypeCastingApp3 {
    public static void main(String[] args) {
        // 정수를 문자에 대입하는 경우
         char ch = 97; // char = int 작은타입으로 바꿈
        System.out.println(ch); //a
        ch = 100; //  char 2byte이므로 (0~65536) 65536개의 값을 표현가능 양수음수구분x
//        ch = 70000; // 65536 넘어가서 안됨 범위를 벗어난 수를 자동처리할 수 없다.
        ch = 45000;
        System.out.println(ch); // 꿈

        // byte, short 연산
        byte bnum1 = 10;
        byte bnum2 = 20;
//        byte bResult = bnum1 + bnum2; // byte + byte -> int + int -> int
        byte bResult = (byte) (bnum1 + bnum2);
        System.out.println(bResult);

    }
}

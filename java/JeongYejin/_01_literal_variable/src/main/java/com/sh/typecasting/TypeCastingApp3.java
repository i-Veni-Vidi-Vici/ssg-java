package com.sh.typecasting;

/**
 * <pre>
 * 예외적인 형변환 케이스
 * - 정수값을 char에 대입하는 경우 자동변환 처리된다.
 * - int보다 작은 정수형 연산은 모두 int로 변환 후 처리된다.
 * </pre>
 */

public class TypeCastingApp3 {
    public static void main(String[] args) {
        // 정수를 문자에 대입하는 경우
        int ch = 'a';
        char c = 97;
        System.out.println(ch);
        System.out.println(c);

/*        c = 70000; // char 2byte이므로 65536개 (0~65535)의 값을 표현가능
        System.out.println(c); //error: incompatible types: possible lossy conversion from int to char
        */

        // byte, short 연산
        byte bNum1 = 10;
        byte bNum2 = 20;
        byte bResult = (byte) (bNum1 + bNum2); // byte + byte -> int + int -> int
        System.out.println(bResult);

    }
}

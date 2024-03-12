package com.sh.typecasting;

/**
 * <pre>
 * 컴퓨터 작동원리
 * - 같은 타입의 자료형끼리 연산이 가능하다.
 * - 결과 역시 같은 타입이다.
 * 형변환
 * - 다른 타입끼리 연산해야 하는 경우 필연적으로 형변환이 필요하다.
 * - 자동형변환 (암묵적 형변환) - 컴파일러가 자동으로 수행하는 형변환
 *      - 크기가 작은 타입에서 큰 타입으로 자동으로 변환된다.
 *      - 정수는 실수로 자동 변환된다.
 *      - 문자는 정수 int로 자동 변환된다.
 *      - 값이 유실되지 않는 범위에서 자동변환된다.
 *      - (byte(1) - short/char(2) - int(4) - long(8)) - (float(4) - double(8))
 *      - long -> float 크기가 작아짐 ( 지수 표현식. . . )
 * - 수동형변환 (명시적 형변환) - 코드로써 직접 수행하는 형변환
 * </pre>
 */

public class TypeCastingApp {
    public static void main(String[] args) {
        byte bnum = 100;
        short snum = bnum; // byte가 short로 자동형변환후에 대입연산
        int inum = snum; // short -> int
        long lnum = inum; // int -> long

//        int result = inum + lnum; // incompatible types, long이 int에 담길 수 없다.
        long result = inum + lnum;
        System.out.println(lnum);
        System.out.println(result);

        // 실수 관련
        float fnum = 123.456f;
        double dnum = fnum; // float -> double -> 대입
        System.out.println(dnum);

        double result2 = fnum + dnum; // fnum -> double, double + double
        System.out.println(result2);

        // 정수/실수 관련
         long eight = 8;
         float fValue = eight; // 정수 -> 실수, 데이터 손실 X
        System.out.println(fValue);

        float result3 = inum + fValue;
        System.out.println(result3);

        char ch = 'a';
        int ichar = ch;
        System.out.println(ichar);
    }
}

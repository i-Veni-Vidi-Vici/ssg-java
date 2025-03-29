package com.sh.typecasting;

/**
 * ### **컴퓨터 작동 원리**
 *
 * - 같은 타입의 자료형끼리 연산이 가능함
 * - 결과 역시 같은 타입이다.
 *
 * ### 형 변환
 *
 * - 다른 타입끼리 연산해야 하는 경우, 필연적으로 형변환이 필요하다.
 * - 자동형변환 (암묵적 형변환) → 컴파일러가 자동으로 수행
 *     - 크기가 작은 타입에서 큰 타입으로 자동으로 변환된다.
 *     - 정수는 실수로 자동 변환된다.
 *     - 문자는 정수 int로 자동 변환된다.
 *     - 값이 유실되지 않는 범위 내에서 자동 변환됨
 *     - (byte → short → int → long) (float → double) 방향으로 형변환이 됨
 * - 수동형변환 (명시적 형변환) →  개발자가 코드로 직접 함
 */
public class TypeCastingApp {
    public static void main(String[] args) {

        //정수 관련
        byte bnum = 100;
        short snum = bnum; // 대입 연산. byte 값을 short 공간에 대입. byte가 short로 자동 형변환 된 후에 대입 연산함!
        int inum = snum; // int = short short가 int로 변환 후 대입 연산됨
        long lnum = inum; //long = int int가 long으로 변환 후 대입 연산

        long result = inum + lnum; // int + long -> int가 long으로 변환후 long + long -> long

        //실수 관련 O
        float fnum = 123.456f;
        double dnum = fnum; // float이 double로 자동 변환 후에 대입 연산됨

        double result2 = fnum + dnum; // float+ double -> float이 double로 변환 후 double + double -> double

        // 정수 / 실수 관련
        long eight = 8;
        float fValue = eight; // eight = 8.0으로 소수점으 부여해 float으로 변환. 데이터 손실은 없음

        System.out.println(fValue);
        float result3 = inum + fValue; // int + float -> int가 float으로 변환 후 float + float -> float

        // 문자 관련
        char ch = 'a';
        int iChar = ch; // int = char -> char를 int로 변환후 대입 연산
        System.out.println(iChar);

    }
}

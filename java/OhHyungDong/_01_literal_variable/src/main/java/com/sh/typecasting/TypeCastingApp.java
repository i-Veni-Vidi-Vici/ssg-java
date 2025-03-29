package com.sh.typecasting;

/**
 * <pre>
 * 컴퓨터 작동원리
 * - 같은 타입의 자료형끼리 연산이 가능하다.
 * - 결과 역시 같은 타입이다.
 *
 * 형변환
 * - 다른 타입끼리 연산해야 하는 경우, 필연적으로 형변환이 필요하다.
 * - 자동형변환(암묵적 형변환) - 자바의 컴파일러가 자동으로 수행
 *  - 크기가 작은 타입 -> 큰 타입으로 자동 변환
 *  - 정수는 실수로 자동 변환
 *  - 문자는 정수 int로 자동 변환된다.
 *  - 값이 유실되지 않는 범위에서 자동 변환된다.
 *  - byte - short/char - int - long - float - double
 * - 수동형변환(명시적 형변환) - 컴파일러가 아닌 사용자가 코드로써 직접 수행하는 형변환
 * </pre>
 */
public class TypeCastingApp {

    public static void main(String[] args) {
        // 정수관련 변환
        byte bnum = 100;
        short snum = bnum; // 대입 연산, byte 값을 short 공간에 대입 -> byte가 short로 자동형변환 후에 대입연산
        int inum = snum; // short -> int로 변환 후 대입연산됨.
        long lnum = inum; // long = int가 long으로 변환 후 대입 연산

        long result = inum + lnum; //int + long => long으로 형변환이 되기 떄문에 resutl의 변수명은 long이 되어야함.
        System.out.println("snum = " + snum);

        //실수 관련 변환
        float fnum = 123.456f;
        double dnum = fnum; //float이 double로 자동변환 후에 대입 연산

        double result2 = fnum + dnum; // float + double -> double로 형변환이 되기 때문에 result2의 값은 double이 되어야 함

        // 정수/실수 관련
        long eight = 8;
        float fValue = eight; // 정수형이 소수점을 부여해서 float형으로 변환이 됐고, 데이터 손실은 없음.
        System.out.println(fValue);

        float result3 = inum + fValue; // int + float -> float형으로 변환되기 떄문에 자료형은 float

        //문자 관련
        char ch = '오';
        int iChar = ch ; // ch -> int 형으로 변환되서 정수형으로 변환됨.
        System.out.println(iChar);
    }
}

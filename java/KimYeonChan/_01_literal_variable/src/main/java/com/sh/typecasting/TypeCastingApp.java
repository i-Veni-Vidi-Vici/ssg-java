package com.sh.typecasting;

public class TypeCastingApp {
    /**
     * <pre>
     * 컴퓨터 작동원리
     * - 같은 타입의 자료형끼리 연산이 가능하다.
     * - 결과 역시 같은 타입이다.

     * 형변환
     * - 다른 타입끼리 연산해야 하는 경우, 필연적으로 형변환이 필요하다.
     * - 자동 형변환 (암묵적형변환): 컴파일러가 자동으로 수행하는 형변환
     *     - 크기가 작은 타입에서 큰 타입으로 자동으로 변환된다.
     *     - 정수는 실수로 자동 변환된다.
     *     - 문자는 정수 int로 자동 변환된다.
     *     - 값이 유실되지 않는 범위에서 자동변환된다.
     *     - (byte(1) > short/char(2) > int(4) > long(8)) > (float(4) > double(8)) // 지수형식으로 변환가능하다.
     *
     * - 수동 형변환 (명시적형변환): 코드로써 직접 수행하는 형변환
     *
     * </pre>
     * @param args
     */
    public static void main(String[] args) {
        // 정수 관련
        byte bnum = 100;
        short snum = bnum; // 대입연산자. byte값을 short공간에 대입. byte가 short로 자동형변환후에 대입연산.
        int inum = snum;
        long lnum = inum;

        long result1 = inum + lnum; // int + long -> int가 long으로 변환 후 long + long 결과값 long

        // 실수 관련
        float fnum = 123.456f;
        double dnum = fnum; // float이 double로 자동변환후에 대입연산
        double result2 = fnum + dnum; // float + dnum -> float가 double으로 변환 후 double + double 결과값 double

        // 정수/실수 연산
        long eight = 8;
        float fvalue = eight; // 소수점을 부여해서

        float result3 = inum + fvalue;
        // 문자 관련

        char ch = '9';
        int ichar = ch;



    }
}

package com.sh.typecasting;

public class TypeCastingApp {
    /**
     * <pre>
     * 컴퓨터 작동원리
     * - 같은 타입의 자료형끼리 연산이 가능하다.
     * - 결과 역시 같은 타입이다.
     *
     * 형변환
     * - 다른 타입끼리 연산해야 하는 경우, 필연적으로 형변환이 필요하다.
     * - 자동 형변환 (암묵적 형변환) - 컴파일러가 자동으로 수행하는 형변환
     *      - 크기가 작은 타입에서 큰 타입으로 자동으로 변환된다.
     *      - 정수는 실수로 자동 변환된다.
     *      - 문자는 정수 int로 자동 변환된다.
     *      - 값이 유실되지 않는 범위에서 자동변환이 된다.
     *      - (byte(1) -> short/char(2) -> int(4) -> long(8)) - (float(4) -> double(8))
     * - 수동 형변환 (명시적 형변환) - 코드로써 직접 수행하는 형변환
     *
     * </pre>
     */
    public static void main(String[] args) {
        // 정수 관련
        byte bnum = 100;
        short snum = bnum; // 대입 연산. byte값을 short공간에 대입. byte가 short로 자동형변환 후에 대입연산.
        int inum = snum; // int = short short가 int로 변환 후 대입연산
        long lnum = snum; // long = int int가 long으로 변환 후 대입연산

        long resuit = inum + lnum; //int + long -> int가 long으로 변환후 long + long 결과


        //실수 관련
        float fnum = 123.456f;
        double dnum = fnum; // float이 double로 자동변환후에 대입연산

        double resuit2 = fnum + dnum; // float + double -> float이 double로 변환후 double+ double 결과

        // 정수/실수 관련
        long eight = 8;
        float fValue = eight; // 소수점을 부여해서 float으로 변환. 데이터 손실은 없다.

        float resuit3 = inum + fValue; // int + float -> int가 float로 변환 후 float + float 결과

        //문자 관련
        char ch = 'a';
        int iChar = ch; // int = char -> char를 int로 변환 후 대입연산


        System.out.println(snum);
    }
}

package com.sh.typecasting;

/**
 * <h3>컴퓨터 작동 원리</h3>
 * <pre>
 *     - 같은 타입의 자료형끼리 연산이 가능하다
 *     - 결과 역시 같은 타입이다.
 *
 *     형변환
 *     - 다른 타입끼리 연산해야 하는 경우 형변환이 필요하다.
 *     - 자동 형변환 ( 암묵적 형변환 ) -> 컴파일러가 자동으로 수행
 *          - 크기가 작은 타입에서 큰 타입으로 자동으로 변환된다.
 *          - 정수는 실수로 자동으로 변환된다.
 *          - 문자는 정수 int로 자동 변환된다.
 *          - 값이 유실되지 않는 범위에서 자동 변환된다.
 *          - (byte(1) -> short(2) -> int(4) -> long(8)) -> (float(4) - double(8))
 *     - 수동 형변환 ( 명시적 형변환 ) -> 코드로써 직접 수행
 *          -
 *
 * </pre>
 *
 */
public class TypeCastingApp {
    public static void main(String[] args){
        // 정수 관련
        byte bnum = 100;
        short snum = bnum;
        int inum = snum;
        long lnum = inum;

        long result = inum + lnum; // int가 long으로 변환 후 long + long 결과

        // 실수 관련
        float fnum = 123.456f;  // float 자료형은 뒤에 f를 붙여줘야함
        double dnum = fnum; // float이 double로 자동 변환 후 대입 연산

        // 정수, 실수 관련
        long eight = 8;
        float fValue = eight; // 소수점을 부여해서 float으로 변환. 데이터 손실은 없다.
        System.out.println(fValue);

        // 문자 관련
        char ch = 'a';
        int iChar = ch;
        System.out.println(iChar); // 97
    }
}

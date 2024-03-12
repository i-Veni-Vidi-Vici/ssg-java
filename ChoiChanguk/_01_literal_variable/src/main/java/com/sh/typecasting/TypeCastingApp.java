package com.sh.typecasting;

/**
 * <pre>
 * 컴퓨터 작동원리
 * - 같은 타입의 자료형끼리 연산이 가능하다.
 * - 결과 역시 같은 타입이다.
 *
 * 형변환
 * - 다른 타입끼리 연산해야 하는 경우, 필연적으로 형변화이 필요하다.
 * - 자동형변환(암묵적 형변환) - 컴파일러가 자동으로 수행하는 형변환
 *      - 크기가 작은->큰 타입으로 자동 변환된다.
 *      - 정수는 실수로 자동 변환된다.
 *      - 문자는 정수 int로 변환된다.
 *      - 값이 유실되지 않는 범위에서 자동변환 된다.
 *      - (byte1 - short2/char2 - int4 - long8) - (float4 - double8)
 * - 수동형변환(명시적 형변환) - 코드로써 직접 수행하는 형변환
 *
 * </pre>
 */

public class TypeCastingApp {
    public static void main(String[] args)
    {
        // 정수 관련
        byte bnum = 10;
        short snum = bnum;//byte->short 자동변환 후 대입연산
        int inum = snum;// short->int 자동변환 후 대입연산
        long lnum=inum;// int->long 자동변환 후 대입연산

        //int result = inum+lnum;//int+long -> int가 long로 자료형변환되지만 실행이 안됨

        //실수 관련
        float fnum = 123.456f;
        double dnum = fnum;//float이 double로 자동변황 후 대입연산

        double result2= fnum+dnum;// fnum->double형변환 후 대입연산

        //정수/실수 관련
        long eight=8;
        float fValue=eight;// 소수점을 부여해서 float으로 변환, 데이터 손실은 없다.
        System.out.println(fValue);

        float result3=inum+fValue;

        //문자 관련
        char ch = 'a';
        int iChar = 97;
        ch= (char) iChar;
        System.out.println(iChar);
        System.out.println(ch);
    }
}

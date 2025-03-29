package com.sh.typecasting;

/**
 * 컴퓨터의 작동 원리
 * - 같은 타입의 자료형끼리 연산이 가능하다.
 * - 결과 역시 같은 타입니다.
 *
 *  형변환
 * - 다른 타입끼리 연산을 하는 경우 반드시 형변환이 필요하다
 * - 묵시적 형변환 = 컴파일러가 자동으로 수행하는 형변환
 *      - 크기가 작은 타입에서 큰 타입으로 자동 변환한다.
 *      - 정수는 실수로 자동 변환된다
 *      - 문자는 정수 int로 자동 변환된다
 *      - 값이 유실되는 않는 범위에서 자동변환된다.
 *      - (byte -> short -> int -> long) (float -> double)
 *      -
 *      -
 * - 명시적 형변환 = 코드로써 직접 수행하는 형변환
 *
 */
public class TypeCastingApp {
    public static void main(String[] args) {
        // 정수 관련
        byte bnum = 100;
        short snum = bnum; //byte가 short로 캐스팅
        int inum = snum; // short가 int 로 캐스팅
        long result = snum; //int가 long 으로 캐스팅
        // 실수 관련
        float fnum = 123.456f;
        double dnum = fnum; // float가 double로 캐스팅
        double result2 = fnum + dnum; // float + double -> float가 double로 변환 후 double + double 연산

        //정수 + 실수 연산
        long eight = 8;
        float fvalue = eight; //소수점을 부여해서 float으로 변환 이때 데이터 손실은 없다
        System.out.println(fvalue);

        float reslt3 = inum + fvalue; //int + float -> int를 float로 변환 -> float + float

        //문자관련
        char ch = 'a';
        int ichar = ch; // int = char -> char를 int로 변환 후 대입연산






        System.out.println(snum);
    }
}

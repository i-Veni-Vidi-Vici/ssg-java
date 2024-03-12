package com.sh.typecasting;

/**
 * <pre>
 *     컴퓨터 작동원리
 *     - 같은 타입의 자료형끼리 연산
 *     - 결과: 같은 타입
 *
 *     형변환
 *     - 다른 타입끼리 연산할경우, 형변환 필요
 *     - 자동 형변환 (암무적 형변환) -컴파일러가 수행
 *          -크기가 작은 타입에서 큰 타입으로 자동 변환
 *          -정수는 실수로
 *          - 문자는 정수 (int)로
 *          - 값이 유실되지 않는 범위에서
 *          byte - short/char - int - long - float - double
 *     - 수동 형변환 (명시적 형변환) -
 *
 * </pre>
 */
public class TypeCatingApp {
    public static void main(String[] args) {
        byte bnum = 100;
        short snum = bnum;
        System.out.println(snum);

        int inum = snum;
        long lnum = inum;

        long result = inum + lnum;


        // 실수

        float fnum = 123.456f;
        double dnum = fnum;

        double result2 = fnum + dnum;

        long eight = 8;
        float fValue = eight;
        System.out.println(fValue);

        float result3 = inum + fValue;

        // 문자 관련
        char ch = 'a';
        int iChar = ch;


    }
}

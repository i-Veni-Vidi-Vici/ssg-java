package com.sh.typecasting;

/**
 * <pre>
 *     - 수동 형변환 (명시적 형변환) -
 *
 * - 크기가 큰 자료형에서 작은 자료형으로 변환하는 경우, 값이 손실된다.
 * - 실수형에 정수형으로 변환하는 경우
 *
 * </pre>
 */
public class TypeCatingApp2 {
    public static void main(String[] args) {
        double dnum = 123.456;
        int inum = (int) dnum;
        System.out.println(inum);

        int max = Integer.MAX_VALUE; // 0111...111
        System.out.println("This is INT_MAX: " + max);


        short smax = (short) max;
        System.out.println("This is short casted INT_MAX: " + smax);

        int min = Integer.MIN_VALUE; // 1000...000
        System.out.println("This is INT_MIN: " + min);


        short smin = (short) min;
        System.out.println("This is short casted INT_MIN: " + smin);
    }
}

package com.sh.typecasting;

/**
 * 명시적 형변환 (수동변환)
 * - 크기가 큰 자료형에서 작은 자료형으로 변환하는 경우, 값이 손실 된다.
 * - 실수형에서 정수형으로 변환하는 경우
 */


public class TypeCatingApp2 {
    public static void main(String[] args){
        //실수에서 정수로 변환
        double dnum = 123.456;
        int inum = (int) dnum;
        System.out.println(inum);

        // 작은 정수형으로 변환
        int i = 100;
        Byte b = (byte) i;
        System.out.println(b); // 100값이 0인 비트 들만 제거되면서 값을 유지

        i = 500;
        b = (byte) i;
        System.out.println(b); // -12값이 있는 비트가 제거되면서 값이 변경
    }
}

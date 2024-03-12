package com.sh.typecasting;


/**
 * <pre>
 * - 수동형 변환 ( 명시적 형변환 , 강제형변환 )
 * - 크기가 큰 자료형에서 작은 자료형으로 변환하는 경우 값이 손실된다.
 * - 실수형에서 정수형으로 변환하는 경우 -> 소수점에 대한 값이 상실됨.
 * </pre>
 */
public class TypeCastingApp2 {
    public static void main(String[] args) {
        //실수 -> 정수로 변환
        double dnum = 123.456;
        int inum = (int)dnum; //(int) 캐스팅 연산자
        System.out.println(inum);

        //작은 정수형으로 변환
        int i = 100;
        byte b = (byte)i;
        System.out.println(b);

        i = 500;
        b = (byte) i;
        System.out.println(b); //byte 범위보다 값이 더큰 값이 대입되기 때문에 값이 있는 비트들이 제거되면서 값이 변경됨 -> b : -12 출력
    }
}

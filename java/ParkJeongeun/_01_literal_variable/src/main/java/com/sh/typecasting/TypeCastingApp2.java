package com.sh.typecasting;

/**
 * <pre>
 * 수동형변환 (명시적 형변환, 강제 형변환)
 * - 크기가 큰 자료형에서 작은 자료형으로 변환하는 경우, 값이 손실
 * - 실수형에서 정수형으로 변환하는 경우
 * </pre>
 */
public class TypeCastingApp2 {

    public static void main(String[] args) {
        // 실수에서 정수로 변환
        double dnum = 123.456;
        int inum = (int) dnum; // 캐스팅(형변환) 연산자
        System.out.println(inum); //123

        // 작은 정수형으로 변환
        int i = 100;
        byte b = (byte) i;
        System.out.println(b); //100 값이 0인 비트들만 제거되어 값 유지

        i = 500;
        b = (byte) i;
        System.out.println(b); // -12 값이 있는 비트들이 제거되면서 값 변경

    }
}

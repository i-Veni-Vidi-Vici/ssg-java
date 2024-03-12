package com.sh.typecasting;

/**
 * <pre>
 *     수동형변환 (명시적형변환, 강제형변환)
 *     - 크기가 큰 자료형에서 작은 자료형으로 변환하는 경우, 값이 손실된다.
 *     - 실수형에서 정수형으로 변환하는 경우
 * </pre>
 */
public class TypeCastingApp2 {
    public static void main(String[] args) {
        // 실수에서 정수로 변환
        double dnum = 123.456;
        int inum = (int) dnum;  // 캐스팅 연산자
        System.out.println(inum);

        // 작은 정수형으로 변환
        int i = 100;
        byte b = (byte) i; // byte = int  
        System.out.println(b); // 100은 byte가 표현할 수 있는 범위 안의 수 이므로 강제형변환하더라도 값 그대로
                                // 값이 0인 비트들만 제거되어서 값을 유지

        i = 500;
        b = (byte) i;
        System.out.println(b); // 500은 byte가 표현할 수 있는 범위 안의 수 이므로 강제형변환시 값 변함
                                // 값이 저장된 비트들도 제거되어서 값이 변경
        
    }
}

package com.sh.typecasting;


/**
 *
 * <pre>
 * 수동형변환 (명시적형변환. 강제형변환)
 * - 크기가 큰 자료형에서 작은 자료형으로 변환하는 경우, 값이 손실된다.
 * - 실수형에서 정수형으로 변환하는 경우
 * </pre>
 */
public class TypeCastingApp2 {
    public static void main(String[] args){
        double dnum = 123.456;
//        int inum = dnum; //  double을 int공간에 담을 수 없다.
        int inum = (int) dnum ; //강제 변환 캐스팅(형변환) 연산자 사용
        System.out.println(inum);

        // 작은 정수형으로 변환
        int i = 100;
//        byte b = i;
        byte b = (byte) i ;
        System.out.println(b); // 100 값이 0인 비트들만 제거되어서 값을 유지

        i = 500;
        b = (byte) i;
        System.out.println(b); // -12값이 있는 비트들이 제거되면서 값이 변경


    }
}

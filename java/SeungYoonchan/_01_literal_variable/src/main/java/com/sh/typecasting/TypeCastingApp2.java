package com.sh.typecasting;

/**
 * <h3>수동 형변환</h3>
 * <pre>
 *     - 크기가 큰 자료형에서 작은 자료형으로 변환하는 경우 값이 손실된다.
 *     - 실수형에서 정수형으로 변환하는 경우
 * </pre>
 *
 */
public class TypeCastingApp2 {
    public static void main(String[] args){
        double dnum = 123.456;
        int inum = (int)dnum;
        System.out.println(inum); //123

        int i = 100;
        byte b = (byte)i;
        System.out.println(b);


    }
}

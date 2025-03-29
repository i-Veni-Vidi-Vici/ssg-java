package com.sh.typecasting;
/*
수동형변환(명시적형변환, 강제형변환)
크기가 큰 자료형에서 작은 자료형으로 변환하는 경우, 값이 손실된다.
실수형에서 정수형으로 변환하는 경우
 */
public class TypeCastingApp2 {
    public static void main(String[] args){
        double dnum=123.456;
        int inum= (int)dnum;//캐스팅 연산자
        System.out.println(inum);

        //작은 정수형으로 변환
        int i = 500;
        byte b = (byte)i;
        System.out.println(b);//값이 있는 비트들이 제거되면서 값이 변경





    }
}

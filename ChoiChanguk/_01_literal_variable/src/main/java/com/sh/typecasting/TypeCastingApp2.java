package com.sh.typecasting;

/**
 * <pre>
 * - 수동형변환 - 명시적 형변환, 강제형변환
 * - 크기가 큰->작은 하면 큰값에 값이 손실된다
 * - 실수->정수로 변환 하는 경우
 * </pre>
 */
public class TypeCastingApp2 {
    public static void main(String[] args)
    {
        double dnum=123.456;
        int inum=(int)dnum;// 캐스팅 연산자
        System.out.println(inum);

        //작은 정수형으로 변환
        int i=100;
        byte b=(byte) i;
        System.out.println(b); // 100 값이 0인 비트들만 제거되어서 값을 유지
    }
}

package com.sh.typecasting;

public class TypeCastingApp2 {
    /**
     * <pre>
     * 수동형변환 (명시적형변환, 강제형변환
     * - 크기가 큰 자료형에서 작은 자료형으로 반대하는 겅우)
     * 크기가 큰 자료형에서 작은 자료형으로 변환하는경우, 값이 손실이된다.
     * - 실수형에서 정수형으로 변환하는 경우
     * </pre>
     * @param args
     */
    public static void main(String[] args) {
        // 실수에서 정수로 변환
        double dnum = 123.456;
        int inume = (int) dnum; // 캐스팅 연산자

        // 작은 정수형으로 변환
        int i = 100;
        byte bnum = (byte)i;
        System.out.println(bnum); // 100 값이 0인 비트들만 제거되어서 값을 유지


    }
}

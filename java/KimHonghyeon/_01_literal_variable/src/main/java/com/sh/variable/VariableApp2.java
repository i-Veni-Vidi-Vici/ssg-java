package com.sh.variable;

public class VariableApp2 {

    /**
     * 변수사용 방법
     * 1. 자료형을 지정하여 선언
     * 2. 변수에 값을 대입(초기화)
     * 3. 변수 사용(출력문, 피연산자 등)
     *
     * 자료형(Primitive) -> 다양한 리터럴을 형태에 따라 지정한 크기의 공간으로 처리할지 컴파일러와 약속한 단위
     * 1. 정수(byte(1B), short(2B), int(4B), long(8B))
     * 2. 실수(double(8B), float(4B))
     * 3. 문자(char(1B?))
     * 4. 논리(boolean())
     *
     * 문자열은 String 참조 자료형(객체)
     *
     * @param args
     */
    public static void main(String[] args) {
        //선언
        byte bNum;
        short sNum;
        int iNum;  //정수 기본형
        long lNum;
        float fNum;
        double dNum; // 실수 기본형
        char cNum;
        boolean boolNum;
        //값 대입
        bNum = 5;
        sNum = 10;
        iNum = 11;
        lNum = 15;
        fNum = 1.00f;
        dNum = 1.22;  //
        cNum = 'C';
        boolNum = true;
        //사용
        System.out.println("bNum = " + bNum);
        System.out.println("sNum = " + sNum);
        System.out.println("iNum = " + iNum);
        System.out.println("lNum = " + lNum);
        System.out.println("fNum = " + fNum);
        System.out.println("dNum = " + dNum);
        System.out.println("cNum = " + cNum);
        System.out.println("boolNum = " + boolNum);

        //선언과 값 대입 동시에 가능
        int a = 10;
        



    }
}

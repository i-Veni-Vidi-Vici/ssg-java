package com.sh.variable;

public class VariableApp2 {
    /**
     * 변수 사용 방법.
     * 1. 자료형을 지정해서 선언한다.
     * 2. 변수의 값을 대입니다.
     * 3. 변수를 사용한다.(출력문, 피연산자등)
     *
     * 기본 자료형(8가지)
     * - 다양한 리터럴 (값)을 형태에 따라 지정한 공간으로 처리할 지 컴파일러와 약속한 단위
     * 1. 정수
     * -byte(1byte)
     * -short(2byte)
     * -int(4byte) - 기본형
     * -lng(4byte)
     * 2. 실수
     * -float(4byte) - 유효자리수 7자리까집 보장
     * -double(8byte) - 기본형, 유효자리수 16자리까지 보장
     * 3. 문자
     * -char(2byte)
     * 4. 논리
     * -boolean(1byte)
     *
     * 문자열은 참조자료형 String 타입으로 처리한다. (기본형은 아님)
     */
    public static void main(String[] args)
    {
        //1. 선언
        //정수를 사용시에는 int를 기본적으로 사용한다.
        byte bnum;
        short snum;
        int inum;
        int lnum;
        //실수를 사용시에는 double을 기본적으로 사용한다.
        float fnum;
        double dnum;
        //문자
        char ch;
        //논리
        boolean bool;
        //문자열
        String str;

        //2. 값 대임
        bnum=123;
        snum=10_000;//=10000 콤마를 못넣으니 이렇게 한다
        inum = 1_000_000;
        lnum = 1_000_000_000;
        fnum = 123.456f; // 모든 실수 리터럴의 기본타입은 double이므로, f나 F를 붙여줘야 한다.
        dnum=123.456;

        ch='a';
        ch=97;

        bool=true;

        str="안녕하세요 이제 마지막 시간입니다";
        System.out.println("bnum = "  +bnum);
        System.out.println("snum = "  +snum);
        System.out.println("inum = "  +inum);
        System.out.println("lnum = "  +lnum);
        System.out.println("fnum = "  +fnum);
        System.out.println("dnum = "  +dnum);
        System.out.println(ch);
        System.out.println(!bool);
        System.out.println(str);

        //초기화 - 변수의 선언과 값 대입을 동시에 하는 것
        int i =100;
        System.out.println(i);

        // 선언 - 값대임 - 사용의 순서를 반드시 지켜야 한다.

    }
}

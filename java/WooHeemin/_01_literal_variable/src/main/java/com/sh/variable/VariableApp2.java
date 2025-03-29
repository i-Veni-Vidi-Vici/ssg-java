package com.sh.variable;

public class VariableApp2 {

    /**
     * 변수 사용 방법
     * 1. 자료형을 지정해서 선언
     * 2. 변수에 값을 대입한다.
     * 3. 변수를 사용한다. (출력문, 피연산자등)
     *
     * 기본 자료형 (8가지)
     *  - 다양한 리터럴(값)을 형태에 따라 지정한 크기의 공간으로 처리할지 컴파일러와 약속한 단위
     * 1.정수
     * - byte (1byte)
     * - short (2byte)
     * - int (4byte) **
     * - long (8byte)
     * 2.실수
     * - float (4byte)
     * - double (8byte) **
     * 3.문자
     * - char (2byte)
     * 4.논리
     * - boolean (1byte)
     *
     * 문자열은 참조자료형 String을 이용하여 처리
     *
     */
    public static void main(String[] args) {

        // 1. 선언
        // 정수를 사용시에는 int를 기본적으로 사용한다.
        byte bnum;
        short snum;
        int inum;
        long lnum;

        //2. 실수 double
        float fnum;
        double dnum;

        char ch;
        boolean bool;

        ch = 'ㅋ';
        ch = 97;

        bool = true;
        bool = false;
        bool = !bool;

        bnum = 123;
        snum = 10000;
        inum = 1_000_000;
        lnum = 1_000_000_000;
        fnum = 123.456f;
        dnum = 123.456;

        System.out.println("bnum = " + bnum);
        System.out.println("snum= " + snum);
        System.out.println("inum = " + inum);
        System.out.println("lnum= " + lnum);
        System.out.println("fnum = " + fnum);
        System.out.println("dnum= " + dnum);
        System.out.println("ch = " + ch);
        System.out.println("bool = + " + bool);



        System.out.println("INT MAX = " + Integer.MAX_VALUE);
        System.out.println("INT MIN = " + Integer.MIN_VALUE);
        System.out.println("SHORT MAX = " + Short.MAX_VALUE);

        // 초기화 - 변수의 선언과 값 대입을 동시에 하는 것
        int i = 100;

        // 선언 - 값대입 - 사용의 순서를 반드시 지켜야 한다.
        double d;

    }
}

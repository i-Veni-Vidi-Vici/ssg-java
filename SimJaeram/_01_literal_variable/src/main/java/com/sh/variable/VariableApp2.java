package com.sh.variable;

public class VariableApp2 {
    /**
     * 변수 사용 방법
     * 1. 자료형을 지정해서 선언
     * 2. 변수에 값을 대입한다.
     * 3. 변수를 사용한다. (출력문, 피연산자등)
     *
     * 기본 자료형(8가지)
     * - 다양한 리터럴(값)을 형태에 따라 지정한 크기듸 공간으로 처리할지 컴파일러와 약속한 단위
     * 1. 정수
     *  - byte(1byte)
     *  - short(2byte)
     *  - int(4byte) - 기본형
     *  - long(8byte)
     * 2. 실수
     *  - float(4byte) - 유효자리수 7자리까지 보장
     *  - double(8byte) - 기본형. 유효자리수 16자리까지 보장
     * 3. 문자
     *  - char(2byte)
     * 4. 논리
     *  - boolean(1bit)
     *
     *  문자열은 참조자료형 String타입으로 처리한다.
     * @param args
     */
    public static void main(String[] args) {
        // 1. 선언
        // 정수 사용시에는 int를 기본적으로 사용한다.
        byte bnum;
        short snum;
        int inum;
        long lnum;
        // 실수를 사용시에는 double을 기본적으로 사용한다.
        float fnum;
        double dnum;
        // 문자
        char ch;
        // 논리
        boolean bool;
        // 문자열
        String str;

        // 2. 값대입
        bnum = 123;
        snum = 10_000;
        inum = 1_000_000;
        lnum = 1_000_000_000;
        fnum = 123.45f; // 모든 실수 리터럴의 기본타입은 double이므로,f나 F를 접미사로 사용해 float 임을 명시
        dnum = 123.456;
        ch = 'ㅋ';
        ch = 97; // 정수를 대입하면, ascii code 표에 따라 문자로 변환 후 처리한다.

        bool = true;
        bool = false;
        bool = !bool;

        str = "안녕하세요.";

        // 3. 사용
        System.out.println("bnum = " + bnum);
        System.out.println("snum = " + snum);
        System.out.println("inum = " + inum);
        System.out.println("lnum = " + lnum);
        System.out.println("fnum = " + fnum);
        System.out.println("dnum = " + dnum);
        System.out.println("ch = " + ch);
        System.out.println("bool= " + bool);
        System.out.println("str = " + str);

        // 초기화 - 변수의 선언과 값대입을 동시에 하는  것
        int i = 100;
        System.out.println(i);

        // 선언 - 값대입 - 사이ㅛㅇ의 순서를 반드시 지켜야 한다.
        double d;
//        System.out.println(d);
//        System.out.println(abc);
    }
}

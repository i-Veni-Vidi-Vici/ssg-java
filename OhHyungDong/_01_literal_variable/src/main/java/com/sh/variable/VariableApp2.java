package com.sh.variable;

public class VariableApp2 {
    /**
     * 변수 사용 방법
     * 1. 자료형을 지정해서 선언.
     * 2. 변수의 값을 대입.
     * 3. 변수를 사용 (출력문, 연산식)
     * 
     * 기본 자료형( 8가지 )
     * - 다양한 리터럴(값)을 형태에 따라 지정한 크기의 공간으로 처리할지 컴파일러와 약속한 단위
     * 1. 정수 -byte(1byte), short(2byte), int(4byte)- 기본형, long(8byte) 
     * 2. 실수 - float(4byte) - 유효자리 7자리까지 보장, double(8byte) - 기본형, 유효 자리수 16자리까지 보장
     * 3. 문자 - char(2byte)
     * 4. 논리형 - boolean(1byte)
     *
     * - 문자열은 참조자료형 String으로 처리함.(기본형 x)
     * - 참조형들의 크기는 모두 4byte로 고정
     * @param args
     */
    public static void main(String[] args) {
        //1. 선언
        // 정수를 사용시에는 int를 기본형으로 사용한다.
        byte bnum;
        short snum;
        int inum;
        int lnum;

        //실수를 사용시에는 double를 기본형으로 사용한다.
        float fnum;
        double dnum;

        char ch;

        boolean bool;

        String str;
        //2. 대입
        bnum = 123;
        snum = 10_000;
        inum = 1_000_000;
        lnum = 100_000_000;
        fnum = 123.456f; //모든 실수 리터럴의 기본타입은 double이므로, float임을 명시해줘야함.
        dnum = 123.456;
       // ch = 'ㅋ';
        ch = 97; // 정수를 대입하면 아스키 코드값에 따라서 문자를 변환 후 처리
        bool = true;
        bool = !bool; // 느낌표 연산자는 반대를 말함.
        str = "abc";


        //3. 사용 
        System.out.println("bnum = " + bnum);
        System.out.println("snum = " + snum);
        System.out.println("inum = " + inum);
        System.out.println("lnum = " + lnum);
        System.out.println("fnum = " + fnum);
        System.out.println("dnum = " + dnum);
        System.out.println("ch = " + ch);
        System.out.println("bool = " + bool);
        System.out.println("str = " + str);

        //초기화 - 변수의 선언과 값 대입을 동시에 사용.
        int i = 100;
        System.out.println("i = " + i);

        // 선언 -> 값 대입 -> 사용의 순서를 반드시 지켜야함.
    }

}

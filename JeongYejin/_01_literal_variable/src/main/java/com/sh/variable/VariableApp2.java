package com.sh.variable;

public class VariableApp2 {
    /**
     * 변수 사용 방법
     * 1. 자료형을 지정해서 선언한다.
     * 2. 변수에 값을 대입한다.햣
     * 3. 변수를 사용한다. (출력문, 피연산자 등)
     *
     * 자료형
     * - 다양한 리터럴(값)을 형태에 따라 지정한 크기의 공간으로 처리하기로 컴파일러와 약속한 단위
     * 1. 정수
     *  - byte(1byte)
     *  - short(2byte)
     *  - int(4byte) - basic
     *  - long(8햣 byte)
     * 2. 실수
     *  - float(4byte)
     *  - double(8byte) - basic
     * 3. 문자
     *  - char(2byte)
     * 4. 논리
     *  - boolean(1byte)
     *
     * 문자열은 참조자료형(4byte) String타입으로 처리한다.
     *
     * @param args
     */
    public static void main(String[] args) {
        // 1. decalration
        // 정수 기본 int
        byte bnum;
        short snum;
        int inum;
        long lnum;
        // 실수 기본 double
        float fnum;
        double dnum;
        // 문자
        char ch;
        // 논리
        boolean bool;
        // 문자열
        String str;

        // 2. definition
        bnum = 123;
        snum = 10_000; //콤마대신 가독성을 위해 _(underscore) 사용
        inum = 1_000_000;
        lnum = 10_000_000;

        fnum = 123.456f; //default는 double, f나 F를 접미사로 사용해 float임을 명시함.
        dnum = 123.456;

        ch = 'ㅎ';
        ch = 97; // 정수를 대입하면, ASCII code표에 따라 문자로 변환 후 처리한다.

        bool = true;

        str = "안녕하세요";

        // 3. usage
        System.out.println("bnum = " + bnum);
        System.out.println("snum = " + snum);
        System.out.println("inum = " + inum);
        System.out.println("lnum = " + lnum);
        System.out.println("fnum = " + fnum);
        System.out.println("dnum = " + dnum);
        System.out.println("ch = " + ch);
        System.out.println("bool = " + bool);
        System.out.println("!bool = " + !bool);
        System.out.println("str = " + str);

        // 초기화 - 변수의 선언과 값대입을 동시에 하는 것
        int i = 100; // declaration + definition
        System.out.println(i); // usage

        // 선언 - 값대입 - 사용의 순서를 반드시 지켜야 한다.
        /*
        double d;
        System.out.println(d);
        System.out.println(abc);
        */
    }
}

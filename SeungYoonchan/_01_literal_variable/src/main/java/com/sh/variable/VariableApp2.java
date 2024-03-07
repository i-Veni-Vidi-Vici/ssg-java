package com.sh.variable;

public class VariableApp2 {
    /**
     *  <h3>변수 사용 방법</h3>
     *  <pre>
     *      1. 자료형을 지정해서 선언한다.
     *      2. 변수에 값을 대입한다.
     *      3. 변수를 사용한다. (출력문, 피연산자 등)
     *  </pre>
     *  <h3>기본 자료형 (8가지)</h3>
     *  <pre>
     *      다양한 리터럴(값)을 형태에 따라 지정한 크기의 공간으로 처리할지 컴파일러와 약속한 단위
     *      1. 정수
     *      - byte      (1byte)
     *      - short     (2byte)
     *      - int       (4byte) * 기본형
     *      - long      (8byte)
     *      2. 실수
     *      - float     (4byte)
     *      - double    (8byte) * 기본형
     *      3. 문자
     *      - char      (2byte)
     *      4. 논리
     *      - boolean   (1byte)
     *  </pre>
     *
     * @param args
     */
    public static void main(String[] args){
        //1. 선언
        byte bnum;
        short snum;
        int inum;
        long lnum;

        float fnum;
        double dnum;

        char ch;

        boolean bool;

        //2. 값 대입
        bnum = 123;
        snum = 10_000;
        inum = 1_000_000;
        lnum = 1_000_000_000;

        fnum = 123.456f; // 모든 실수 리터럴의 기본타입은 double이므로, f나 F를 접미사로 사용해 float임을 명시해야함
        dnum = 123.456;

        ch = 'A';

        bool = true;
        //3. 사용
        System.out.println("bnum = " + bnum);
        System.out.println("snum = " + snum);
        System.out.println("inum = " + inum);
        System.out.println("lnum = " + lnum);
        System.out.println();
        System.out.println("fnum = " + fnum);
        System.out.println("dnum = " + dnum);

    }
}

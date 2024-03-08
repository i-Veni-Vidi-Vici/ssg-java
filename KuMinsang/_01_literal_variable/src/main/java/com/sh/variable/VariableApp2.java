package com.sh.variable;

import java.security.KeyStore;

/**
 * 변수 사용 방법
 * - 자료형을 지정하여 선언
 * - 변수에 값을 대입한다
 * - 변수를 사용한다
 * -
 * 자료형 (primitive type) 8가지
 *      다양한 literal을 형태에 따라 지정한 크기의 공간으로 처리할지 컴파일러와 약속한 단위
 * - 정수
 *      Byte = 1Byte
 *      short = 2Byte
 *      int = 4Byte
 *      long = 8Byte
 * - 실수
 *      float = (4Byte) - 유효자리수 7자리까지 보장
 *      double = (8Byte) - 기본형. 유효자리수 16자리까지 보장
 * - 문자
 *      char(2Byte)
 * - 논리
 *      boolean(1Byte)
 */
public class VariableApp2 {
    public static void main(String[] args){
        //1. 선언
        //정수
        // 정수를 사용시에는 int를 기본적으로 사용한다
        byte bnum;
        short snum;
        int inum;
        long lnum;

        //실수
        //실수를 사용시에는 double 기본적으로 사용한다
        double dnum;
        float fnum;

        //문자
        char ch = 's';
        boolean Tff = true;
        String a = "안녕하세요";

        //2. 값 대입
        bnum=123;
        snum = 10_000;
        inum = 1_000_000;
        lnum = 1_000_000_000;
        fnum = 123.456f; //모든 실수 타입의 기본타입은 double이므로, f나 F를 접미사로 사용해 float임을 명시해야함
        dnum = 123.45678;

        //3. 사용
        System.out.println("bnum = " +  bnum);
        System.out.println("snum = " + snum);
        System.out.println("inum = " + inum);
        System.out.println("lnum = " + lnum + "\n");
        System.out.println("fnum = " + fnum);
        System.out.println("dnum = " + dnum);
        System.out.println(ch);
        System.out.println(ch=97); //ch는 97이 대입되여 ASCII코드에 따라 a가 된다
        System.out.println(ch); //위에서 실행된 변경이 그대로 유지
        System.out.println(Tff);
        System.out.println("str = " + a);

        //초기화 - 변수의 선언과 값대입을 동시에 하는 것
        int k = 100;
        System.out.println(k);



    }
}

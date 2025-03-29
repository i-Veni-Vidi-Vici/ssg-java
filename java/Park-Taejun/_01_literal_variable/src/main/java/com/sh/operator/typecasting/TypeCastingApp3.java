package com.sh.operator.typecasting;

/**
 * 예외적인 형변환 케이스
 */

public class TypeCastingApp3 {
    public static void main(String[] args  ) {
       // 정수를 문자에 대입하는 경우
       char ch = 97; //char = int
        System.out.println(ch);

        ch = 45000;

        System.out.println(ch);

        //byte short 연산
        byte bno1 = 10;
        byte bno2 = 20;
        byte bResult =(byte) (bno1 + bno2);
        System.out.println(bResult);

    }
}

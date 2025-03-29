package com.sh.typecasting;

/**
 * 예외적인 형변환 케이스
 * - 정수값을 char에 대입하는 경우 자동변환 처리되낟.
 * - int 보다 작은 정수형 연산은 모두 int로 변환후 처리된다
 */

public class TypeCastingApp3 {

    public static void main(String[] args) {

        char ch = 97;
        char eight = '8';
        final int EIGHT = (int) (eight - '0');

        System.out.println(EIGHT);
        System.out.println(ch);


    }


}

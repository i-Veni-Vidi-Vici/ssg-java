package com.sh.operator.assignment;

/**
 * 대입 연산자 =
 * - 좌항의 변수(공간)에 우항의 값을 대입
 * - 우항에 다른 변수를 사용한다 해도, 값으로써 처리
 *  <pre>
 *  복합대입 산술연산자
 *  +=
 *  -=
 *  *=
 *  /=
 *  %=
 *  </pre>
 */



public class AssigmentOperatorApp {
    public static void main(String[] args){
        int num = 10;

        num = num +3;
        num += 3; // 복합A연산자
        System.out.println(num);

        num -= 3;
        System.out.println(num);

//        (num =- 1) == (num = -1)

        num *= 3;
        System.out.println(num);

        num /= 5;
        System.out.println(num);

        num %= 5;
        System.out.println(num);

    }
}

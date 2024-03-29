package com.sh.operator.assignment;

/**
 * <pre>
 * 대입 연산자 =
 * - 좌항의 변수(공간)에 우항의 값을 대입
 * - 우항에 다른 변수를 사용한다 해도, 값으로써 처리
 *
 * 복합대입 산술연산자
 * +=
 * -=
 * *=
 * /=
 * %=
 *
 * </pre>
 */
public class AssignmentOperatorApp {
    public static void main(String[] args) {
        int num = 10;

        // 복합대입 연산자
//        num = num + 3;
        num += 3;
//        num =+ 3;
        System.out.println(num);

        num -= 3;
        System.out.println(num);

        num *= 3;
        System.out.println(num);

        num /= 5;
        System.out.println(num);

        num %= 5;
        System.out.println(num);

        // 순서에 유의해야 한다.
        num =- 1; // num = -1;
        System.out.println(num);

    }
}
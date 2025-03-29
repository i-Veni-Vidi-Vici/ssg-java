package com.sh.operator.assignment;

/**
 * 대입 연산자
 * 좌항의 변수(공간)에 우항의 값을 대입하라
 * 우항에 다른 변수를 사용한다 해도, 값으로써 처리
 *
 * 복합대입 산술연산자도 지원을함
 *  +=
 *  -=
 *  *=
 *  /=
 *  %=
 *
 */

public class AssignmentOperatorApp {
    public static void main(String[] args) {
        int num = 10;

        // 복합대입 연산자
        num += 3;
        System.out.println(num);

        num -= 3;
        System.out.println(num);

        num *= 3;
        System.out.println(num);

        num /= 5;
        System.out.println(num);

        num %= 5;
        System.out.println(num);

        num -= 1; // num = -1; 은 그냥 -1 을 출력하는것과 같으므로 순서에 유의한다!!
        System.out.println(num);

    }
}

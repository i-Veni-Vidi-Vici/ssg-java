package com.sh.operator.assignment;

/**
 * 대입 연산자 =
 * - 좌항의 변수(공간) 우항의 값을 대입
 * - 우항의 다른 변수를 사용한다 해도, 값으로써 처리
 *
 * 복합대입 산술 연산자
 * +=
 * -=
 * *=
 * /=
 * %=
 *
 */
public class AssignmentOperator {
    public static void main(String[] args) {
        int num = 10;

        num = num + 3; //13
        System.out.println(num);
        num += 3; //16
        System.out.println(num);
        num -= 3; //13
        System.out.println(num);
        num *= 3; //39
        System.out.println(num);
        num /=3; //13
        System.out.println(num);
        num %= 5; //3
        System.out.println(num);

        num -= -1; //4
        System.out.println(num);


    }
}

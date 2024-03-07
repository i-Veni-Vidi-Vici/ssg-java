package com.sh.literal;

import java.sql.SQLOutput;

public class LiteralApp2 {
    /**
     * 간단한 연산 - 오칙연산 (+ - * / %)
     */

    public static void main(String[] args) {
        // 1. 정수와 정수 연산 - 정수 사이의 연산 결과는 정수이다.
        System.out.println(123 + 456);
        System.out.println(123 - 456);
        System.out.println(123 * 10); // 1230
        System.out.println(123 / 10); // 12
        System.out.println(123 % 10); //3

        // 2. 실수와 실수 연산 - 실수 사이의 연산 결과는 정수이다.
        System.out.println(1.23 + 1.123);
        System.out.println(1.23 - 1.123);
        System.out.println(1.23 * 10.0);
        System.out.println(1.1234 / 10.0);
        System.out.println(1.1234 / 10.00);
        System.out.println(1.23 % 10.0);
        System.out.println(1.23 % 10.00);

        // 3. 정수와 실수 연산 - 정수,실수사이의 연산 결과 실수이다.
        System.out.println(123 + 0.5);
        System.out.println(123 - 0.5);
        System.out.println(123 * 0.5);
        System.out.println(123 / 0.5);
        System.out.println(123 % 0.5);

        //4. 문자와 문자 연산 - 문자는 정수로 변환후 연산이 가능하다.
        System.out.println('a' + 'b');
        System.out.println('a' - 'b');
        System.out.println('a' * 'b');
        System.out.println('a' / 'b');
        System.out.println('a' % 'b');

        //5. 문자와 정수 연산 - 문자는 정수로 변환후 연산이 가능하다.
        System.out.println('a' + 1);
        System.out.println('a' - 1);
        System.out.println('a' * 1);
        System.out.println('a' / 1);
        System.out.println('a' % 1);

        //6. 문자와 실수 연산 - 문자는 실수로 변환후 연산이 가능하다.
        System.out.println('a' + 1.0);
        System.out.println('a' - 1.0);
        System.out.println('a' * 1.0);
        System.out.println('a' / 1.0);
        System.out.println('a' % 1.0);

        //7. 문자열
        System.out.println("hello" + "world");

        //8. 문자열과 다른값의 연산
        System.out.println("hello" + 123);

        //9. 논리값과 오칙연산은 불가능하다.

        //10. 문자열과 다른 타입의 값 더하기 심화
        // 프로그램은 기본적으로 위에서 아래로, 왼쪽에서 오른쪽으로 코드릴 처리한다
        System.out.println("기차" + 10 + 20);// "기차1020"
        System.out.println("기차" + (10 + 20));
        System.out.println("김밥" + 'a' + 'b');
        System.out.println('a' + 'b' + "김밥");



    }
}

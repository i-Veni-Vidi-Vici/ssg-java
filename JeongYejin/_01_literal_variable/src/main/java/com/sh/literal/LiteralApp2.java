package com.sh.literal;

public class LiteralApp2 {
    /**
     * 간단한 연산 - 오칙연산 (+ - * / %)
     * @param args
     */
    public static void main(String[] args) {
        // 1. 정수와 정수 연산 - 정수 사이의 연산 결과는 정수이다.
        System.out.println(123 + 456);
        System.out.println(123 - 456);
        System.out.println(123 * 10);
        System.out.println("123 / 10 = " + 123 / 10);
        System.out.println("123.0 / 10.0 = " +123.0 / 10.0);
        System.out.println(123 % 10);
        System.out.println();

        // 2. 실수와 실수 연산 - 실수 사이의 연산 결과는 실수이다.
        System.out.println(1.23 + 1.23);
        System.out.println(1.23 - 1.23);
        System.out.println(1.23 * 1.23);
        System.out.println(1.23 / 1.23);
        System.out.println(1.23 % 1.23);
        System.out.println();

        // 3. 정수와 실수 연산 - 정수/실수 사이의 연산 결과는 실수이다.
        System.out.println(123 + 0.5);
        System.out.println(123 - 0.5);
        System.out.println(123 * 0.5);
        System.out.println(123 / 0.5);
        System.out.println(123 % 0.5);
        System.out.println();

        // 4. 문자와 문자 연산 - 문자는 정수로 변환 후 연산이 가능하다.
        // ASCII code표에 기준 a -> 97, b -> 98로 변환 후 연산
        System.out.println('a' + 'b');
        System.out.println('a' - 'b');
        System.out.println('a' * 'b');
        System.out.println('a' / 'b');
        System.out.println('a' % 'b');
        System.out.println();

        // 5. 문자와 정수 연산 - 문자는 정수로 변환 후 연산이 가능하다.
        System.out.println('a' + 1);
        System.out.println('a' - 1);
        System.out.println('a' * 1);
        System.out.println('a' / 1);
        System.out.println('a' % 1);
        System.out.println();

        // 6. 문자와 실수 연산 - 문자는 실수로 변환 후 연산이 가능하다.
        System.out.println('a' + 1.0);
        System.out.println('a' - 1.0);
        System.out.println('a' * 1.0);
        System.out.println('a' / 1.0);
        System.out.println('a' % 1.0);
        System.out.println();

        // 7. 문자열 연산 - 문자열은 더하기 연산만 지원한다.
        System.out.println("hello" + "world");
        System.out.println();

        // 8. 문자열과 다른 값의 연산 - 모두 문자열로써 더하기 연산처리된다.
        System.out.println("hello " + 123);
        System.out.println("hello " + 123.456);
        System.out.println("hello " + 'a');
        System.out.println("hello " + true);
        System.out.println();

        // 9. 논리값과 오칙연산은 불가능하다.
//        System.out.println(true + true);
//        System.out.println(true - 123);

        // 10. 문자열과 다른 타입의 값 더하기 심화
        System.out.println("기차" + 10 + 20); //기차1020
        System.out.println("기차" + (10 + 20)); //기차30
        System.out.println(10 + 20 + "기차"); //30기차
        System.out.println('a' + 'b' + "김밥"); // 97 + 98 + "김밥" // 195김밥
        System.out.println();

        System.out.println(9 + 9 + "9"); //"189"
        System.out.println(9 + "9" + 9); //"999"
        System.out.println("9" + 9 + 9); //"999"

    }
}

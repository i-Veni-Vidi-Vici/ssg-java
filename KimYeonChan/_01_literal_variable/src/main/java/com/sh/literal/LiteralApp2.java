package com.sh.literal;

public class LiteralApp2 {
    /**
     * 간단한 연산: 오칙연산 (+, -, *, /, %)
     * @param args
     */
    public static void main(String[] args) {
        // 1. 정수와 정수 연산
        System.out.println(123 + 456);
        System.out.println(123 - 456);
        System.out.println(123 * 456);
        System.out.println(123 / 10);
        System.out.println(123 % 10);

        // 2. 실수와 실수의 연산
        System.out.println(1.23 + 1.23);
        System.out.println(1.23 - 1.23);
        System.out.println(1.23 * 1.23);
        System.out.println(1.23 / 10.0);
        System.out.println(1.23 % 10.0);

        // 4. 정수와 실수의 연산
        System.out.println(123 + 0.5);
        System.out.println(123 - 0.5);
        System.out.println(123 * 0.5);
        System.out.println(123 / 0.5);
        System.out.println(123 % 0.5);

        // 4. 문자와 문자 연산: 문자는 정수로 변환 후 연산이 가능하다.
        // ascii code표에 기준해서 a -> 97, b -> 98로 변환 후 연산
        System.out.println('a' + 'b');
        System.out.println('a' - 'b');
        System.out.println('a' * 'b');
        System.out.println('a' / 'b');
        System.out.println('a' % 'b');

        // 5. 문자와 정수 연산: 문자는 정수로 변환 후 연산이 가능하다.
        System.out.println('a' + 1);
        System.out.println('a' - 1);
        System.out.println('a' * 1);
        System.out.println('a' / 1);
        System.out.println('a' % 1);

        // 6. 문자와 실수 연산: 문자는 실수로 변환 후 연간이 가능하다.
        System.out.println('a' + 1.0);
        System.out.println('a' - 1.0);
        System.out.println('a' * 1.0);
        System.out.println('a' / 1.0);
        System.out.println('a' % 1.0);

        // 7. 문자열 연산: 문자열은 더하기연산만 지원한다.
        System.out.println("hello" + "world");

        // 8. 문자열과 다른 값의 연산: 모두 문자열로써 더하기 연산처리된다.
        System.out.println("hello" + 123);
        System.out.println("hello" + 123.456);
        System.out.println("hello" + 'a');

        // 9. 논리값과 오칙연산은 불가하다.

        // 10. 문자열과 다른 타입의 값 더하기 심화
        // 프로그램은 위에서 아래로, 왼쪽에서 오른쪽으로 코드를 처리한다.
        System.out.println("기차" + 10 + 20);
        System.out.println("기차" + (10 + 20));
        System.out.println("김밥" + 'a' + 'b');
        System.out.println('a' + 'b' + "김밥");
    }
}

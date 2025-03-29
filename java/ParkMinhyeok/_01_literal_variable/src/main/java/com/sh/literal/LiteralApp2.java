package com.sh.literal;

public class LiteralApp2 {
    /**
     *
     *
     */
    public static void main(String[] args) {
        // 1. 정수와 정수 연산
        System.out.println();

        // 2. 실수와 실수 연산
        // 3. 정수와 실수 연산 - 정수/실수 사이의 연산 결과 실수이다.
        // 4. 문자와 문자 연산 - 문자는 정수로 변환 후 연산이 가능하다.
        // ascii code 표에 기준해서 a -> 97, b -> 98로 변환 후 연산
        System.out.println('a' + 'b');
        System.out.println('a' - 'b');
        System.out.println('a' * 'b');
        System.out.println('a' / 'b');
        System.out.println('a' % 'b');

        // 5. 문자와 정수 연산 - 문자는 정수로 변환 후 연산이 가능하다.
        // 6. 문자와 실수 연산 - 문자는 실수로 변환 후 연산이 가능하다.
        // 7. 문자열 연산 - 문자열은 더하기 연산만 지원한다.
        // 8. 문자열과 다른 값의 연산 - 모두 문자열로써 더하기 연산 처리된다.
        // 9. 논리값과 오칙연산은 불가능하다.
        // 10. 문자열과 다른 타입의 값 더하기 심화
        // 프로그램은 기본적으로 위에서 아래로, 왼쪽에서 오른쪽으로 코드를 처리한다.
        System.out.println("기차" + 10 + 20); // 기차1020
        System.out.println('a' + 'b' + "김밥"); // 195김밥
    }
}

package com.sh.literal;

public class LiteralApp2 {
    /**
     * <h3>간단한 연산</h3>
     * <pre>
     *     - 오칙 연산 ( + - * / % )
     *     - 더하기, 빼기, 곱하기, 나누기, 나머지
     * </pre>
     * @param args
     */
    public static void main (String[] args){
        //1. 정수와 정수 연산
        System.out.println("정수와 정수 연산");
        System.out.println(123+10);
        System.out.println(123-10);
        System.out.println(123*10);
        System.out.println(123/10);
        System.out.println(123%10);
        System.out.println();

        //2. 실수와 실수 연산
        System.out.println("실수와 정수 연산");
        System.out.println(1.23+1.23);
        System.out.println(1.23-1.23);
        System.out.println(1.23*10.0);
        System.out.println(1.23/10.0);
        System.out.println(1.23%10.0);
        System.out.println();

        //3. 정수와 실수 연산 - 정수/실수 사이의 연산 결과는 실수이다.
        System.out.println("정수와 실수 연산");
        System.out.println(123+0.5);
        System.out.println(123-0.5);
        System.out.println(123*0.5);
        System.out.println(123/0.5);
        System.out.println(123%0.5);
        System.out.println();

        //4. 문자와 문자 연산 - 문자는 정수로 변환 후 연산
        // ascii code 표에 따라서 a -> 97, b -> 98 로 변환
        System.out.println('a' + 'b');
        System.out.println('a' - 'b');
        System.out.println('a' * 'b');
        System.out.println('a' / 'b');
        System.out.println('a' % 'b');
        System.out.println();

        //5. 문자와 정수 연산 - 문자는 정수로 변환 후 연산이 가능하다.
        System.out.println('a'+2);
        System.out.println('a'-2);
        System.out.println('a'*2);
        System.out.println('a'/2);
        System.out.println('a'%2);
        System.out.println();

        //6. 문자와 실수 연산 - 문자는 실수로 변환 후 연산이 가능하다.
        System.out.println('a'+2.0);
        System.out.println('a'-2.0);
        System.out.println('a'*2.0);
        System.out.println('a'/2.0);
        System.out.println('a'%2.0);
        System.out.println();

        //7. 문자열 연산 - 문자열은 더하기 연산만 지원한다.
        System.out.println("hello" + "world"); // -> helloworld
        System.out.println();

        //8. 문자열과 다른 값의 연산 - 모두 문자열로써 더하기 연산 처리된다.
        System.out.println("hello" + 123); // -> hello123
        System.out.println("hello" + 123.456); // -> hello123.456
        System.out.println();

        //9. 논리값과 숫자의 오칙연산은 불가능하다. ( True , False )
        //   논리값과 문자열의 연산을 하면 문자열로써 더하기 연산 처리된다.

        //10. 문자열과 다른 타입의 값 더하기 심화
        // 프로그램은 기본적으로 위에서 아래로, 왼쪽에서 오른쪽으로 코드를 처리한다.
        System.out.println("기차" + 10+20);       // 기차1020
        System.out.println("기차" + (10+20));     // 기차30
        System.out.println("김밥" + 'a'+'b');     // 김밥ab
        System.out.println("김밥" + ('a'+'b'));   // 김밥195
        System.out.println('a'+'b'+"김밥");       // 195김밥
    }
}

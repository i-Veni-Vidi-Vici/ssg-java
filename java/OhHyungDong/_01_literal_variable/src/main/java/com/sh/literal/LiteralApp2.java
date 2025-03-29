package com.sh.literal;

public class LiteralApp2 {
    /**
     * 간단한 연산 - 오칙연산 (+ - * / %)
     * @param args
     */
    public static void main(String[] args) {
        //1. 정수와 정수 연산 -> 정수로 출력
        System.out.println(123 + 456);
        System.out.println(123 - 456);
        System.out.println(123 * 10);
        System.out.println(123 / 10);
        System.out.println(123 % 10);

        //2. 실수와 실수 연산 -> 실수로 출력
        System.out.println(1.23 + 1.23 );
        System.out.println(1.23 - 1.23 );
        System.out.println(1.23 * 10.0 );
        System.out.println(1.23 / 10.0 );
        System.out.println(1.23 % 10.0 );
        System.out.println();

        //3. 정수와 실수 연산 -> 실수로 출력
        System.out.println(123 + 0.5);
        System.out.println(123 - 0.5);
        System.out.println(123 * 0.5);
        System.out.println(123 / 0.5);
        System.out.println(123 % 0.5);


        //4. 문자와 문자 연산 -> 문자는 정수로 변환 후 연산이 가능하다.
        // a = 97 b = 98 아스키 코드 값에 의해서 값이 변경됨.
        System.out.println('a' + 'b');
        System.out.println('a' - 'b');
        System.out.println('a' *'b');
        System.out.println('a' / 'b');
        System.out.println('a' % 'b');

        //5. 문자와 정수 - 문자는 정수로 변환 후에 연산이 가능하다.
        System.out.println('a' + 1 );
        System.out.println('a' - 1);
        System.out.println('a' * 1);
        System.out.println('a' / 1);
        System.out.println('a' % 1);

        //6. 문자와 실수 - 문자는 실수로 변환 후 연산이 가능 함
        System.out.println('a' + 1.0 );
        System.out.println('a' - 1.0);
        System.out.println('a' * 1.0);
        System.out.println('a' / 1.0);
        System.out.println('a' % 1.0);

        //7. 문자열 연산 - 더하기 연산만 지원
        System.out.println("Hello" + "world"); //HelloWorld

        //8. 문자열과 다른 값의 연산 - 모두 문자열로써 더하기 연산처리 됨.(실수, 정수, 문자, boolean형)
        System.out.println("hello" + 123);

        //9. 논리값과의 오칙 연산은 불가능함.
//        System.out.println(true + true );
//        System.out.println(true + 234);

        //10. 문자열과 다른 타입의 값 더하기 심화.
        //프로그램은 기본적으로 위-> 아래, 왼 -> 오 코드를 처리함.
        System.out.println("기차" + 10 + 20); //기차1020
        System.out.println("기차" + (10 + 20)); //기차 30
        System.out.println("기차" + 'a' + 'b'); //기차ab
        System.out.println('a' + 'b' + "기차"); //195기차
        System.out.println();

        System.out.println(9 + 9 + "9"); // "189"
        System.out.println(9 + "9"+ 9); //999
        System.out.println("9" + 9 + 9); //999




    }
}

package com.sh.literal;

public class LiteralApp2 {
    /**
     * 간단한 연산 - 오칙연산(+ - * / %)
     * @param args
     */
    public static void main(String[] args){
        // 1. 정수와 정수 연산
        System.out.println(123 + 456); //579
        System.out.println(123 - 456); //-333
        System.out.println(123 * 10); //1230
        System.out.println(123 / 10); //12
        System.out.println(126 / 10); //12 <-소숫점 이하 버림
        System.out.println(123 % 456); //123

        // 2. 실수와 실수 연산 - 실수와 실수의 연산 결과는 실수이다
        System.out.println(1.23 + 1.23); //2.46
        System.out.println(1.23 - 1.23); //0.0
        System.out.println(1.23 * 10.0); //12.3
        System.out.println(1.23 / 10.0); //0.123
        System.out.println(1.23 % 10.0); //1.23
        System.out.println();

        // 3. 정수와 실수 연산 - 무조건 실수로 결과가 나온다
        System.out.println(123 + 0.5); //2.46
        System.out.println(123 - -0.5); //0.0
        System.out.println(123 * 0.5); //12.3
        System.out.println(123 / 0.5); //0.123
        System.out.println(123 % 0.5);
        System.out.println((123 % 0.5)+"\n개행문자테스트"); //1.23

        // 4. 문자와 문자의 연산 - 문자는 정수로 변환 후 연산이 가능하다
        System.out.println('a'+'b');
        System.out.println('a'-'b');
        System.out.println('a'*'b');
        System.out.println('a'/'b');
        System.out.println('a'%'b');
        System.out.println();
        System.out.println((char) 65); //A <-대문자

        //6. 문자와 실수 연산 - 문자는 실수로 변환 후 연산이 가능하다
        System.out.println('a' + 1.0); //9.8
        System.out.println('a' - 1.0);
        System.out.println('a' * 1.0);
        System.out.println('a' / 1.0);
        System.out.println('a' % 1.0 + "\n");

        //7. 문자열 연산 - 문자열은 더하기 연산만 지원한다
        /*
        System.out.println("hello" - "world");
        System.out.println("hello" * "world");
        System.out.println("hello" / "world");
        System.out.println("hello" % "world");
        */
        //8. 문자열과 다른 값의 연산 - 모두 문자열로써 더하기 연산 처리된다.
        System.out.println("hello" + 123); //hello123
        System.out.println("hello" + 123.456); //hello123.456
        System.out.println("hello" + 'a');  //helloa
        System.out.println("hello" + true); //hellotrue

        // 9. 논리값과 오칙연산은 불가능하다
//        System.out.println(true + true);
//        System.out.println(true - 123);
//        System.out.println(true * false);
        // 10. 문자열과 다른 타입의 값 더하기 심화
        // 프로그램은 기본적을 위에서 아래로, 왼쪽에서 오른쪽을 코드를 처리한다.
        System.out.println("기차" + 10 + 20); //기차1020
        System.out.println("기차" + (10 + 20)); //기차30
        System.out.println("김밥" + 'a' + 'b'); //김밥ab
        System.out.println('a' + 'b' + "김밥"); //195김밥
        //a와b가 정수 연산이 되고 김밥이 문자열 연산으로 뒤에 붙는다

        System.out.println( 9+ 9 +"9"); //189
        System.out.println( 9+ "9" +9); //999
        System.out.println( "9"+ 9 +9); //999

        System.out.println("Char자료형 size ="+ Character.SIZE + "bit");
        /*  C에서는 char의 크기가 1Byte이다
            그러나 자바에서는 char의 크기가 2Byte인데
            이는 C가 매우 오래된 언어라서 ASCII코드를 표준으로 개발되었기 때문이다
            ASCII코드는 1Byte를 사용한다
            따라서 ASCII코드 값은 1Byte내에 모두 표현 가능했다
            하지만 아시아권 언어를 지원함에 따라 유니코드가 제정되었고 유니코드는 2Byte다
            JAVA에서는 유니코드를 표준으로 삼기 때문에 char는 2Byte다
         */
        System.out.println("Int자료형 size ="+ Integer.SIZE + "bit");

    }
}

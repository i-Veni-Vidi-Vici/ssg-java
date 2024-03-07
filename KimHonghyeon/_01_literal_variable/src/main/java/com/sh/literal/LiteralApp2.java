package com.sh.literal;

public class LiteralApp2 {
    public static void main(String[] args) {
        // 정수-정수 연산
        System.out.println(123+456);
        System.out.println(123-456);
        System.out.println(123*10);
        System.out.println((double)123/10);
        System.out.println(123%10);

        //실수 연산
        System.out.println(1.23+1.23);
        System.out.println(1.23-1.00);
        System.out.println(1.23*10.0);
        System.out.println(1.23/10.0);
        System.out.println(1.23%10.0);

        //문자 연산(아스키 코드 값 연산)
        System.out.println('A' + 'B');
        System.out.println('c' - 'A');
        System.out.println('c'/'A');
        System.out.println('c'*'A');
        System.out.println('c'%'A');

        System.out.println('A'+1);
        System.out.println('A'-1);
        System.out.println('C'%10);

        //문자 실수 연산(문자->정수)
        System.out.println('C'+1.00);
        System.out.println('R'*1.2);

        //문자열 연산(더하기만 연산자로 지원)
        System.out.println("Hello " + "World!");

        //문자열 + 다른 리터럴 타입 -> 모두 문자열로 변환 후 더해짐
        System.out.println("Hello " + 12332);

        //논리값과 연산자 연산 불가능(문자열에 더하기만 제외)

        //문자열과 다른 타입 더하기 심화
        System.out.println("기차" + 10 + 20);
        System.out.println(10 + 20 + "기차");
        System.out.println("기차" + (10+20));

        System.out.println(9 + 9 +"9");
        System.out.println(9 + "9" + 9);
        System.out.println("9" + 9 + 9);



    }
}

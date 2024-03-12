package com.sh.literal;

public class LiteralApp2 {
    /**
     * 간단한 연산 - 오칙연산 ( + - * / %)
     * @param args
     */
    public static void main(String[] args)
    {
        //1. 정수와 정수 연산, 정수와 정수는 정수
        System.out.println(4654651+16543);
        System.out.println(4654651-16543);
        System.out.println(461*13);
        System.out.println(4654651.0/16543.0);
        System.out.println(4654651%16543);
        System.out.println("----------------------------");

        //2. 실수와 실수의 연산, 실수와 실수는 실수
        System.out.println(65345354.54654+65687.32534654);
        System.out.println(65453484.54654-65687.32534654);
        System.out.println(654.54654*65687.32534654);
        System.out.println(655384534.54654/65687.32534654);
        System.out.println(65453453454.54654%65687.32534654);
        System.out.println("--------------------");
        //3. 정수와 실수는 실수다
        System.out.println(654+65.325);
        System.out.println(654-65.325);
        System.out.println(654/65.325);
        System.out.println(654*65.325);
        System.out.println(654%65.325);
        System.out.println("----------------------------");

        //4. 문자와 문자 연산, 아스키코드 기준으로 바뀐다
        System.out.println('a'+'b');
        System.out.println('a'-'b');
        System.out.println('a'*'b');
        System.out.println('a'/'b');
        System.out.println('a'%'b');
        System.out.println("----------------------------");

        //5. 문자와 정수 연산이 가능
        System.out.println('a'+3);
        System.out.println('a'-3);
        System.out.println('a'*3);
        System.out.println('a'/3);
        System.out.println('a'%3);
        System.out.println("----------------------------");

        //6. 문자와 실수 연산
        System.out.println('a'+3.3);
        System.out.println('a'-3.3);
        System.out.println('a'*3.3);
        System.out.println('a'/3.3);
        System.out.println('a'%3.3);
        System.out.println("----------------------------");

        //7. 문자열은 더하기만 지원
        System.out.println("ㅁㄴㅇㄻㅇㄹ"+"asdfaefadf"+'ㅁ');
        System.out.println("----------------------------");

        //8. 문자열과 다른 값의 연산, 문자열+숫자 or 문자 or false, true = 아예 문자열로 취급
        System.out.println("문자열"+1123);
        System.out.println("문자열"+'ㅁ');
        System.out.println("----------------------------");

        //9. 논리값(ture, false)과 오칙 연산은 불가능하다.
        System.out.println("---------------------------");

        //10. 왼쪽->오른쪽, 위에서->아래로
        System.out.println("기차"+10+20);//문자열+숫자 = 문자열 + 숫자 = 문자열
        System.out.println("기차"+(10+20));
        System.out.println('a'+('b'+"김밥"));System.out.println("---------------------------");

        //연습
        System.out.println(9+9+"9");//189
        System.out.println(9+"9"+9);//999
        System.out.println("9"+9+9);//

    }
}

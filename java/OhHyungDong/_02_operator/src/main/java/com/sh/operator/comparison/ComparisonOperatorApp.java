package com.sh.operator.comparison;

/**
 * <pre>
 *  비교 연산자
 *  - 연산 결과는 boolean타입이다.
 *  - if문 혹은 삼항 연산자의 조건식으로 자주 사용된다.
 *
 *  - 항상 좌항 기준으로 읽어야댐.
 *  > : 좌항이 우항보다 크니 ?
 *  < : 좌항이 우항보다 작니 ?
 *  >= : 좌항이 우항보다 크거나 같니 ?
 *  <= : 좌항이 우항보다 작거나 같이 ?
 *  == : 좌항과 우항이 같니 ?
 *  != : 좌항과 우항이 다르니 ?
 *
 * </pre>
 */
public class ComparisonOperatorApp {
    public static void main(String[] args) {
        //정수 비교
        int a = 10, b = 15;
        System.out.println(a > b);
        System.out.println(a >= b);
        System.out.println(a < b);
        System.out.println(a <= b);
        System.out.println(a == b);
        System.out.println(a != b);

       //실수 비교
        double c =  5.5;
        double d = 1.5;
        System.out.println(c > d);
        System.out.println(c >= d);
        System.out.println(c < d);
        System.out.println(c <= d);
        System.out.println(c == d);
        System.out.println(c != d);

        //문자 비교도 크기 비교가 가능하다.
        //int 하위의 타입(byte, short, char)은 int로 형변환 후 연산한다.
        char e = 'a'; // 97
        char f = 'A'; // 65
        System.out.println(e <f); // char < char -> int < int
        System.out.println(e <= f);
        System.out.println(e > f);
        System.out.println(e >= f);
         System.out.println(e == f);
         System.out.println(e != f);

         //논리 비교  - 동등비교만 가능
        boolean bool1 = true;
        boolean bool2 = false;

        System.out.println(bool1 == bool2);
        System.out.println(bool1 != bool2);
        // System.out.println(bool1 > bool2); // 컴파일 오류 발생

        //문자열 비교 - 동등비교만 가능하다.
        String str1 ="java";
        String str2 = "java";
        System.out.println(str1 == str2);
        System.out.println(str1 != str2);








    }
}

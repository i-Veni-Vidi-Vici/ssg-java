package com.sh.operator.comparison;

/**
 * <pre>
 * 비교 연산자
 * - 연산결과는 boolean 타입이다.
 * - if문 혹은 심함연산자의 조건식으로 사용된다.
 * > 좌항이 우항보다 큰가?
 * < 좌항이 우항보다 작은가?
 * >= 좌항이 우항보다 크거나 같은가?
 * <= 좌항이 우항보다 작거나 같은가?
 * == 좌우항이 같은가?
 * != 좌항과 우항이 다른가?
 * </pre>
 */
public class ComparisonOperatorApp {
    public static void main(String[] args) {
        // 정수비교
        int a = 10;
        int b = 15;
        System.out.println(a > b); //false
        System.out.println(a < b); //true
        System.out.println(a >= b); //false
        System.out.println(a <= b); //true
        System.out.println(a == b); //false
        System.out.println(a != b); //true

        // 실수비교
        double c = 5.5;
        double d = 9.123;
        System.out.println(c > d); //false
        System.out.println(c < d); //true
        System.out.println(c >= d); //false
        System.out.println(c <= d); //true
        System.out.println(c == d); //false
        System.out.println(c != d); //true

        // 문자 비교 - 문자도 크기비교가 가능하다.
        // int 하위의 타입(byte, short, char)은 int로 형변환후 연산한다.

        char e = 'a'; // 97
        char f = 'A'; // 65
        System.out.println(e < f); // char < char -> int < int
        System.out.println(e > f);
        System.out.println(e <= f);
        System.out.println(e >= f);
        System.out.println(e == f);
        System.out.println(e != f);

        System.out.println('a' > 'A'); //true

        // 논리 비교 - 동등비교만 가능하다.
        boolean bool1 = true;
        boolean bool2 = false;
        System.out.println(bool1 == bool2);
        System.out.println(bool1 =! bool2);

        // 문자열 비교 - 동등비교만 가능하다.
        String str1 = "java1";
        String str2 = "java2";
        System.out.println(str1.equals(str2));
    }
}

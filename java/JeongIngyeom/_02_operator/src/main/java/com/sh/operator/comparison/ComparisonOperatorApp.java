package com.sh.operator.comparison;

public class ComparisonOperatorApp {

    /**
     * <pre>
     * 비교연산자
     * - 연산 결과는 boolean타입이다.
     * - if문 혹은 삼항연산자의 조건식으로 사용된다.
     *
     * >
     * <
     * >=
     * <=
     * ==
     * !=
     *
     * </pre>
     * @param args
     */
    public static void main(String[] args) {
        // 정수 비교
        int a = 10;
        int b = 15;
        System.out.println(a > b);
        System.out.println(a < b);
        System.out.println(a >= b);
        System.out.println(a <= b);
        System.out.println(a == b);
        System.out.println(a != b);

        // 실수 비교
        double c = 5.5;
        double d = 9.123;
        System.out.println(c > d);
        System.out.println(c < d);
        System.out.println(c >= d);
        System.out.println(c <= d);
        System.out.println(c == d);

        // 문자 비교- 문자도 크기 비교가 가능하다.
        char e = 'a';
        char f = 'A';
        System.out.println(e < f);
        System.out.println(e > f);
        System.out.println(e <= f);
        System.out.println(e >= f);
        System.out.println(e == f);
        System.out.println(e != f);

        // 논리 비교 - 동등 비교만 가능하다.
        boolean bool1 = true;
        boolean bool2 = false;
        System.out.println(bool1 == bool2);
        System.out.println(bool1 != bool2);

        // 문자열 비교 - 동등비교만 가능하다.
        String str1 = "java";
        String str2 = "java";
        System.out.println(str1 == str2);
        System.out.println(str1 != str2);

    }
}

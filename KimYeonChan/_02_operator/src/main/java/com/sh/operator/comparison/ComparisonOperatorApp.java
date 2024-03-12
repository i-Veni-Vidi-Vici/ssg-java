package com.sh.operator.comparison;

    /**
     * <pre>
     *
     * 비교연산자
     * - 연산결과는 boolean 타입이다.
     * - if 문 혹은 삼항연산자의 조건식으로 사용된다.
     *
     * > 좌항이 우항보다 큰가?
     * < 좌항이 우항보다 작은가?
     * >= 좌항이 우항보다 크거나 같은가?
     * <= 좌항이 우항보다 작거나 같은가?
     * == 좌우항이 같은가?
     * != 좌우항이 다른가?
     * </pre>
     */
public class ComparisonOperatorApp {
    public static void main(String[] args) {
        int a = 10;
        int b = 15;
        System.out.println(a > b); // false
        System.out.println(a < b); // true
        System.out.println(a >= b); // false
        System.out.println(a <= b); // true
        System.out.println(a == b); // false
        System.out.println(a != b); // true

        double c = 5.5;
        double d = 9.123;
        System.out.println(c > d); // false
        System.out.println(c < d); // true
        System.out.println(c >= d); // false
        System.out.println(c <= d); // true
        System.out.println(c == d); // false
        System.out.println(c != d); // true

        // int 하위의 타입(byte, short, char)은 int 로 형변환 후 연산한다.
        char e = 'a';
        char f = 'A';
        System.out.println(e > f); // false
        System.out.println(e < f); // true
        System.out.println(e >= f); // false
        System.out.println(e <= f); // true
        System.out.println(e == f); // false
        System.out.println(e != f); // true

        // 논리 비교
        boolean bool1 = true;
        boolean bool2 = false;
        System.out.println(bool1 == bool2); // false
        System.out.println(bool1 != bool2); // true


        String str1 = "true";
        String str2 = "false";
        System.out.println(str1 == str2); // false
        System.out.println(str1 != str2); // true
    }
}

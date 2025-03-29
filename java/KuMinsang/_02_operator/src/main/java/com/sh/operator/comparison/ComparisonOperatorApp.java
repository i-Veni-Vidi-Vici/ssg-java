package com.sh.operator.comparison;

/**
 * 비교연산자
 * - 연산 결과는 boolean 타입니다
 * - if 혹은 삼항 연산자의 조건식으로 사용된다.
 * > 좌항이 우항보다 큰가
 * < 좌항이 우항보다 작은가
 * >= 좌항이 우항보다 크거나 같은가
 * <= 좌항이 우항보다 작거나 같은가
 * == 좌우항이 같은가
 * != 좌우항이 다른가
 */
public class ComparisonOperatorApp {
    public static void main(String[] args) {
        //정수비교
        int a = 10;
        int b = 15;
        System.out.println(a > b); //f
        System.out.println(a < b); //t
        System.out.println(a >= b); //f
        System.out.println(a <= b); //t
        System.out.println(a == b); //f
        System.out.println(a != b); //t

        //실수비교
        double c = 5.5;
        double d = 9.123;
        System.out.println(c > d); //f
        System.out.println(c < d);  //t
        System.out.println(c >= d); //f
        System.out.println(c <= d); //t
        System.out.println(c == d); //f
        System.out.println(c != d);  //t

        //문자비교
        char e = 'a'; //97
        char f = 'A'; //65
        System.out.println(e > f); //t
        System.out.println(e < f); //f
        System.out.println(e >= f); //t
        System.out.println(e <= f); //f
        System.out.println(e == f); //f
        System.out.println(e != f); //t

        //논리 비교 - 동등 비교만 가능하다
        boolean bool1 = true;
        boolean bool2 = false;


    }
}

package com.sh.operator.comparison;

/**
 * <pre>
 * 비교 연산자
 * - 연산결과는 boolean 타입
 * - if문 혹은 삼항연산자의 조건식으로 사용됨
 *
 * (무조건 좌항 기준으로 읽기)
 * > 좌항이 우항보다 큰가?
 * < 좌항이 우항보다 작은가?
 * >= 좌항이 우항보다 크거나 같은가?
 * <= 좌항이 우항보다 작거나 같은가?
 * == 좌우항이 같은가?
 * != 좌우항이 다른가?
 *
 * </pre>
 */
public class ComparisonOperatorApp {
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
        System.out.println(c != d);

        // 문자 비교 : 문자도 크기 비교 가능
        // int 하위타입(byte, short, char)은 int로 형변환 후 연산
        char e = 'a'; // 97
        char f = 'A'; // 65
        System.out.println(e < f); // int < int
        System.out.println(e > f);
        System.out.println(e <= f);
        System.out.println(e >= f);
        System.out.println(e == f);
        System.out.println(e != f);

        // 논리 비교 : 동등비교만 가능
        boolean bool1 = true;
        boolean bool2 = false;
        System.out.println(bool1 == bool2);
        System.out.println(bool1 != bool2);
//        System.out.println(bool1 > bool2); // 컴파일 오류

        // 문자열 비교 : 동등비교만 가능
        String str1 = "java";
        String str2 = "java";
        System.out.println(str1 == str2);
        System.out.println(str1 != str2);


    }
}

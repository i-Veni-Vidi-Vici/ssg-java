package com.sh.operator.comparison;

public class ComparisonOperatorApp {
    public static void main(String[] args) {
        //정수 비교
        int a = 10;
        int b = 15;
        System.out.println(a > b); //false
        System.out.println(a < b); // true
        System.out.println(a >= b); // false
        System.out.println(a <= b); //true
        System.out.println(a == b); // false
        System.out.println(a != b); // true

        //실수 비교
        double c = 5.5;
        double d = 9.5;
        System.out.println(c > d); //false
        System.out.println(c < d); // true
        System.out.println(c >= d); // false
        System.out.println(c <= d); //true
        System.out.println(c == d); // false
        System.out.println(c != d); // true

        //문자 비교 - 문자도 크기 비교가 가능하다.
        //int 하위의 타입 (byte, short, char)은 int로 형변환후 연산한다.
        char e = 'a'; //97
        char f = 'A'; //65
        System.out.println(e < f); //char < char -> int < int
        System.out.println(e > f); //char > char -> int > int
        System.out.println(e <= f); //char <= char -> int <= int
        System.out.println(e >= f); //char >= char -> int >= int
        System.out.println(e == f);//char == char -> int == int
        System.out.println(e != f); //char != char -> int != int

        System.out.println('a' > 'A'); //true

        //논리 비교 - 동등 비교만 가능함
        boolean bool1 = true;
        boolean bool2 = false;
        System.out.println(bool1 == bool2); // false
        System.out.println(bool1 != bool2); // true
//        System.out.println( bool1 > bool2); // 컴파일 오류

        // 문자열 비교 - 동등 비교만 가능하다.
        String str1 = "java";
        String str2 = "java";
        System.out.println(str1 == str2); //true
        System.out.println(str1 != str2); //false



    }
}

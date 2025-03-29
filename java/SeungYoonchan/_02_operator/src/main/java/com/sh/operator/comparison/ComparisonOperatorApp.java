package com.sh.operator.comparison;

/**
 * <h3> 비교 연산자 </h3>
 * <pre>
 *     - 연산 결과는 boolean 타입이다.
 *     - if문 혹은 삼항연산자의 조건식으로 사용된다,
 *
 *     > 좌항이 우항보다 큰가? GT ( greater than )
 *     < 좌항이 우항보다 작은가? LT ( less than )
 *     >= 좌항이 우항보다 크거나 같은가
 *     <= 좌항이 우항보다 작거나 같은가
 * </pre>
 */
public class ComparisonOperatorApp {
    public static void main(String[] args){
        // 정수 비교
        int a = 10;
        int b = 15;
        System.out.println(a > b);  //false
        System.out.println(a < b);  //true
        System.out.println(a >= b); //false
        System.out.println(a <= b); //true
        System.out.println(a == b); //false
        System.out.println(a != b); //ture
        
        //실수 비교
        double c = 5.5;
        double d = 9.123;
        System.out.println(c > d);  //false
        System.out.println(c < d);  //true
        System.out.println(c >= d); //false
        System.out.println(c <= d); //true
        System.out.println(c == d); //false
        System.out.println(c != d); //ture
    
        // 문자 비교
        // int 하위의 타입 (byte, short, char)은 int 로 형변환 후 연산한다.

        char e = 'a';
        char f = 'A';

        System.out.println(e > d);  //false
        System.out.println(e > d);  //true
        System.out.println(e <= d); //true
        System.out.println(e >= d); //true
        System.out.println(e == d); //false
        System.out.println(e != d); //ture

        System.out.println('a' > 'A');

        //논리 비교
        boolean bool1 = true;
        boolean bool2 = false;

        System.out.println(bool1==bool2); // false
        System.out.println(bool1!=bool2); // true
//        System.out.println(boo1>bool2); // 컴파일 오류

        String str1 = "java";
        String str2 = "java";
        System.out.println(str1==str2);
        System.out.println(str1!=str2);

    }
}

package com.sh.operator.comparison;

/**
 * <pre>
 * 비교연산자
 * - 연산결과는 boolean 타입이다.
 * - if문 혹은 삼항연산자의 조건식
 * 무조건 좌항 기준
 * > ex) 좌항>우항 = 왼쪽이 오른쪽보다 큰가??
 * < ex) 좌항<우항 = 왼쪽이 오른쪽보다 작은가??
 * <= ex) 좌항<=우항 = 왼쪽이 오른쪽보다 작거나 같은가??
 * >= ex) 좌항>=우항 = 왼쪽이 오른쪽보다 큰거나 작은가??
 * == ex) 좌항==우항 = 왼쪽과 오른쪽이 같은가??
 * != ex) 좌항!=우항 = 왼쪽과 오른쪽이 다른가??
 * </pre>
 */
public class ComparisonOperatorApp {
    public static void main(String[] args)
    {
        //정수 연산
        int a=10;
        int b=15;
        System.out.println("정수 연산");
        System.out.println("a>b = "+(a>b));
        System.out.println(a<b);
        System.out.println(a>=b);
        System.out.println(a<=b);
        System.out.println(a==b);
        System.out.println(a!=b);
        System.out.println("--------------------");

        //실수 연산
        System.out.println("실수 연산");
        double a1=10.156;
        double b1=15.5978;
        System.out.println(a1>b1);
        System.out.println(a1<b1);
        System.out.println(a1>=b1);
        System.out.println(a1<=b1);
        System.out.println(a1==b1);
        System.out.println(a1!=b1);
        System.out.println("--------------------");

        //문자 비교
        System.out.println("문자 연산");
        char e='a';// 아스키코드 값 a=97
        char e1='A';// 아스키코드 값 A=65
        System.out.println(e>e1);
        System.out.println(e<e1);
        System.out.println(e>=e1);
        System.out.println(e<=e1);
        System.out.println(e==e1);
        System.out.println(e!=e1);
        System.out.println("--------------------");

        //논리 비교
        System.out.println("논리 비교");
        boolean bool1=true;
        boolean bool2=false;
        System.out.println(bool1==bool2);
        System.out.println(bool1!=bool2);
        System.out.println("--------------------");

        String str1 = "java";
        String str2 = "java";
        System.out.println(str1 == str2);
        System.out.println(str1 != str2);



    }
}

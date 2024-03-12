package com.sh.operator.comparison;
/*
비교연산자
연산결과는 boolean타입이다.
-if문 혹은 삼항연산자의 조건식
> 좌항이 우항보다 큰다
< 좌항이 우항보다 작은가
>= 좌항이 우항보다 크거나 같은가?
<= 좌항이 우항보다 작거나 같은가?
== 좌우항이 같은가?
!= 좌우항이 다른가?
 */

public class ComparisonOperatorApp {
    public static void main(String[] args){
        int a=10;
        int b=15;
        System.out.println(a>b);
        System.out.println(a<b);
        System.out.println(a>=b);
        System.out.println(a<=b);
        System.out.println(a==b);
        System.out.println(a!=b);
        double c=5.5;
        double d=9.123;
        System.out.println(c>d);
        System.out.println(c<d);
        System.out.println(c>=d);
        System.out.println(c<=d);
        System.out.println(c==d);
        System.out.println(c!=d);
        char e='a'; //97
        char f='A'; //65
        System.out.println(e>f); //t
        System.out.println(e<f); //f
        System.out.println(e>=f);//t
        System.out.println(e<=f);//f
        System.out.println(e==f);//f
        System.out.println(e!=f);//t

        boolean bool1 = true;
        boolean bool2 = false;
        System.out.println(bool1 == bool2);
        System.out.println(bool1 != bool2);

        String str1="java";
        String str2="java";
        System.out.println(str1==str2);
        System.out.println(str1!=str2);


    }
}

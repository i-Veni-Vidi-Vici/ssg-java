package com.sh.operator.logical;

/**
 * 논리연산자
 * - && (and)(논리곱) 좌우항이 모두 true인 경우 true를 반환
 * - || (or) (논리합) 좌항 또는 우항이 true인 경우 true를 반환
 * 논리 부정 연산자
 * - ! 논리 값을 반전
 * -
 */

public class LogicalOperatorApp {
    public static void main(String[] args) {
        System.out.println(true && true); //t
        System.out.println(true && false); //f
        System.out.println(false && false); //f
        System.out.println(false && true); //f

        System.out.println(true || true); //t
        System.out.println(true || false); //t
        System.out.println(false || false); //t
        System.out.println(false || true); //f

        //논리 연산자 적용
        int a = 10;
        int b = 20;
        int c = 30;
        int d = 40;
        System.out.println((a<b) && (c>d)); //(a가b보다 작은가?)T && (c가 d보다 큰가)F -> T && F -> F
        System.out.println(a == b && c > d);
        System.out.println((a+b == c) && d > 100);   //a+b가 c고 d가 100보다 큰 가
        System.out.println(a<b && (b*c)>d*d);   //a 가 b보다 작으면서 b와 c의 곱이 d의 제곱보다 큰 가

        System.out.println(a > b || c < d);
        System.out.println((a<(b+100)) || (c==d)); //a가 b + 100보다 작거나 c 와 d가 동일한가 t|| f = t
        System.out.println((a != b) || (c>d*2));   //a와 b가 다르거나 c가 d *2보다 큰가
        System.out.println(((a+b+c)>d) || (d>0));  // a+b+c가 d보다 크거나 d가 양수인지 여부
        //이항 논리연산자(&& ||)는 이항 비교연산자(> < =)보다 우선순위가 낮으므로 위의 식들은 모두 괄호 없이도 동작한다
        //산술 > 비교연산자 > 논리연산자 > 대입연산자

        //범위에 포함되는가 여부
        int x = 55;
        System.out.println(1<x && x<100); // x 가 1에서 100사이의 숫자인가
        /*1<x<100이 안되는 이유
            1<x가 먼저 연산되면서 boolean 값 true가 반환 된다
            이어지는 연산식에서 true<100가 된다
            boolean 과 int 형의 비교는 불가능 하므로 에러가 발생한다
        */
        /*
            1<x -> true     x<100 -> true
            true && true -> true
         */





    }
}

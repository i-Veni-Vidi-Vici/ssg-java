package com.sh.operator.logical;

/**
 * 논리연산자
 * && (and) 좌우항이 모두 true인 경우 true를 반환
 * !! (or) 좌항 또는 우항이 true 인 경우 true를 반환
 *
 *
 *
 */
public class LogicalOperatorApp {
    public static void main(String [] args){
        //논리연산자
        System.out.println(true && true);
        System.out.println(true && false);
        System.out.println(false && true);
        System.out.println(true && true);



        System.out.println(true || true);
        System.out.println(true || false);
        System.out.println(false || true);
        System.out.println(false || false);
        System.out.println();

        // 논리 연산자 적용
        int a = 10;
        int b = 20;
        int c = 30;
        int d = 40;
        System.out.println(a < b && c > d ); //a가 b보다 작으면서 c가 d보다 큰지
        System.out.println(a == b && c > d ); // a와 b가 같으면서 c가 d 보다 큰지 여부
        System.out.println((a + b) == c && d > 100 );// a+b가 c와 같으면서 d 가 100 보다 큰지 여부?
        System.out.println(a < b && (b * c) > d * d );

        System.out.println(a > b || c < d); // a가 b보다 크거나 c가 d보다 작은지 여부
        System.out.println(a < b+100 || c == d ); // a가 b + 100보다 작거나 c와 d가 동일한지 여부
        System.out.println(a != b || c > d*2); // a와 b가 다르거나 c가 d*2보다 큰지 여부
        System.out.println(a + b +  c > d || d > 0 ); // a + b + c가 d보다 크거나 d가 양수인지 여부
        System.out.println();

        // 범위에 포함되는가 여부
        int x = 55;
        System.out.println(x >= 1 && x <= 100); // x 가 1에서 100사이 숫자인가 여부?



    }

}

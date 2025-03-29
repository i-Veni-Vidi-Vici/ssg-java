package com.sh.operator.increment;

/**
 * 증감 연산자
 * a++ 변수 a를 1증가 시킨다
 * a-- 변수 a를 1감소 시킨다
 */
public class IncrementOperatorApp {
    public static void main(String[] args) {

        int a = 10;
        int b = 5;
        int c = 3;

        System.out.println(++a); //a를 +1 한 후 연산 11
        System.out.println(a++); //a를 연산 한 후 +1 11
        System.out.println(a);  // 윗줄에서 증가하여 12

        System.out.println(--a); //a를 -1한 후 연산 11
        System.out.println(a--); //a를 연산 한 후 -1 11
        System.out.println(a);  //10

        System.out.println(++a + b ); // 10+1 + 5 = 16
        System.out.println(a++ + b); // 11 + 5 = 16 // a = 12
        System.out.println(a + b); //17
        System.out.println(a++ + b + c); // 12 + 5 + 3 = 20 , a++ -> 13
        System.out.println(a); //13

    }
}

package com.sh.operator.increment;

/**
 *  a++ 변수 a를 1 증가시킨다
 *  a-- 변수 a를 1 감소시킨다.
 *
 *  연산자 위치에 처리방식 달라진다
 *  전위 증감연산자 ++a --a 먼저 증감처리후 인접연산에 사용된다.
 *  후위 증감연산자 a++ a-- 인접연산에 먼저 값을 사용한 후 증감처리 한다.
 *
 */
public class IncrementOperatorApp {
    public static void main(String[] args){
        int a =10;
        a++;
        a++;
        a++;
        System.out.println(a);
        a--;
        System.out.println(a);

        // 전위 증감 연산자
        int m = 20;
       // System.out.println(++m); // 이때 인접연산은 출력이다.
       // int m2 = ++m + 2;
      //  System.out.println("m = " + m + ", m2 =" +m2);//\
        int m3 = ++m;
        System.out.println("m =" + m + ", m3 = " + m3);//



        //후위 증감 연산자
        int n = 30;
 //       System.out.println(n++);
 //       System.out.println(n);
        int n3 = n++;
        System.out.println("n = " + n +", n3 = " +n3);

        int x = 40;
        int y = 50;
        int z = x++ + --y;
        System.out.println("x = " + x + ", y = " + y + ", z = " + z);






    }
}

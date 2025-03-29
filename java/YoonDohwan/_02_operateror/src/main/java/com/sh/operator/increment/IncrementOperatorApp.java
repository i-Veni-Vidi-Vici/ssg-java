package com.sh.operator.increment;
/*
증감연산자
a++   변수 a를 1증가시킨다.
a--   변수 a를 1감소시킨다.
연산자 위치에 처리방식 달라진다.
-전위 증감연산자 ++a --a  먼저 증감처리후 인접연산에 사용된다.
-후위 증감연산자 a++ a--  인접연산에 먼저 값을 사용한후 증감처리 한다.


 */

public class IncrementOperatorApp {
    public static void main(String[] args){
        int a=10;
        a++;
        System.out.println(a);

        int m=20;
        System.out.println(++m);
      /*  System.out.println(n++);
        System.out.println(n);

       */
        int n=30;
        /*int n2= n++ +3;
        System.out.println("n = " +n + ",n2 = " +n2); //31+34 65

        int m3 = ++m;
        System.out.println("m=" +m+", m3="+m3); //
        */
        int n3= n++;
        System.out.println(n);
        System.out.println(n3);

        int x=40;
        int y=50;
        int z = x++ + --y;
        System.out.println("x= " +x+ "y= "+y+"z ="+z);//x= 41 y= 49  z= 89



    }
}

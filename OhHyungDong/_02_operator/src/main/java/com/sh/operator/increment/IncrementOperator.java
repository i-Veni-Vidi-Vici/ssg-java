package com.sh.operator.increment;


/**
 * <pre>
 * 증감 연산자
 * a++ : 변수 a를 1증가 시킨다.
 * a-- : 변수 a를 1감소 시킨다.
 * 
 * 연산자의 위치에 따라 처리방식이 달라진다.
 * - 전위 증감 연산자 : ++a, --a
 * 1. 먼저 증감처리 후 인접 연산에 사용된다.
 *
 * - 후위 증감 연산자 a++, a--
 * 2. 인접연산에 먼저 값을 사용 한 후 증감 처리한다.
 * </pre>
 */
public class IncrementOperator {
    public static void main(String[] args) {
        //단항 연산자
        int a= 10;
        ++a;
        System.out.println("a = " + a);
        a--;
        System.out.println("a = " + a);

        //전위 증감 연산자
        int m = 20;
//        System.out.println(++m); //인접연산은 출력  = 증가 후 출력 m = 21
//        int m2 = ++m + 2; //23
//        System.out.println("m =" + m + "m2 = " + m2);
        int m3 = ++m; // m3 : 21 m : 21 , 인접연산은 '=' 대입 연산자
        System.out.println("m3 = " + m3 + " m = " + m);
//        //후위 증감 연산자
        int n = 30;
//        int n2 = n++ + 3; //n2 = 33 n = 31
//        System.out.println("n2 = " + n2 + " n : " + n);
//        System.out.println(m++); // 출력 후 증가 m = 22
//        System.out.println("m = " + m);
        int n3 = n++; // n3 = 30 n = 31
        System.out.println("n3 :"+ n3 + " n: "+ n);

        int x = 40;
        int y = 50;
        int z = x++ + --y; // x=41 z = 89 y=49
        System.out.println("x = " + x + " y =" + y + " z = " + z);
    }
}

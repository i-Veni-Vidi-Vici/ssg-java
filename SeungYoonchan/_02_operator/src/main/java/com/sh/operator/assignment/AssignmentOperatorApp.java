package com.sh.operator.assignment;

/**
 * <h3> 대입 연산자 </h3>
 * <pre>
 *     - 좌항의 변수에 우항의 값을 대입한다.
 *     - 우항에 다른 변수를 사용한다 해도 값으로 처리된다.
 *
 *     복합대입 산술 연산자
 *     - +=, -=, *=, /=, %=r
 * </pre>
 */
public class AssignmentOperatorApp {
    public static void main(String[] args){
        // 단항연산자
        int a = 10;
        a++;
        a++;
        a++;
        System.out.println(a);
        a--;
        System.out.println(a);

        // 전위 증감 연산자
        int m = 20;
//        System.out.println("++m = " + ++m); //21
        int m2 = ++m + 2;
//        System.out.println("m = " + m + ", m2 = " + m2);
        int m3 = ++m;
        System.out.println("m = " + ", m3 = " + m3);
        // 후위 증감 연산자
        int n = 30;
//        System.out.println("n++ : " + n++); //출력 30 후 n++
//        System.out.println(n);
//        int n2 = n++ + 3;
//        System.out.println("n = " + n + ", n2 = " + n2); //31, 33
        int n3 = n++;
        System.out.println("n = " + n + ", n3 = " + n3);// 31, 30

        int x = 40;
        int y = 50;
        int z = x++ + --y;
        System.out.println("x = " + x + ", y = " + y + ", z = " + z); // 41, 49, 89



    }
}

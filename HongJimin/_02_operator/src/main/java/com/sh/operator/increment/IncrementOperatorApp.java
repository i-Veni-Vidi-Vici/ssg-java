package com.sh.operator.increment;

/**
 *### 증감 연산자
 *
 * - `**a++**` : 변수 a를 1 증가시킴
 * - `**a-**` : 변수 a를 1 감소시킴
 * - 연산자의 위치에 따라 처리 방식이 달라짐
 * - **전위 증감 연산자 : 먼저 증감 처리후 인접 연산에 사용됨**
 *     - `**++a**`
 *     - `**--a**`
 *
 * - **후위 증감 연산자 : 인접 연산에 먼저 값을 사용한 후 증감처리함**
 *     - `**a++**`
 *     - `**a--**`
 */
public class IncrementOperatorApp {
    public static void main(String[] args) {
        // 단한 연산자
        int a = 10;
        a++;
        a++;
        a++;
        System.out.println(a);
        a--;
        System.out.println(a);

        //전위 증감 연산자
        int m = 20;
//        System.out.println(++m); //이때 인접 연산은 출력이다.
//        int m2 = ++m +2; //이때 인접 연산은 +이다.
//        System.out.println("m = " + m + ", m2 = " + m2); //m = 21, m2 = 23
        int m3 = ++m; // 이때 인접 연산은 =이다.
        System.out.println("m = " + m + ", m3 = " + m3); //m = 21, m3 = 21

        //후위 증감 연산자
        int n = 30;
//        System.out.println(n++); //30
//        System.out.println(n); //31
//        int n2 = n++ + 3;
//        System.out.println("n = " + n + ", n2 = " + n2); //n = 31, n2 = 33
        int n3 = n++;
        System.out.println("n = " + n + ", n3 = " + n3); // n = 31, n3 = 30

        int x = 40;
        int y = 50;
        int z = x++ + --y; //x = 40, y = 49, z = 89 , x는 연산 후에 41이 됨
        System.out.println("x = " + x + ", y = " + y + ", z = " + z); //x = 41, y = 49, z = 89


    }
}

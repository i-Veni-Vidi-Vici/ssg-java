package com.sh.operator.increment;

/**
 * <pre>
 * 증감 연산자
 * a++ = 1증가
 * a-- = 1감소
 * 연산자 위치에 처리방식 달라진다.
 * -전위 증감연산자 ++a, --a 증감 먼저 처리 -> 인접연산 한다
 * -후위 증감연산자 a++, a-- 인접연산 먼저 처리-> 증감처리
 * </pre>
 */

public class IncrementOperatorApp {
    public static void main(String[] args) {
        int a=10;
        a++;//1 증가 시킨다
        System.out.println("a = "+a);

        int b=10;
        b--;//1 감소시킨다
        System.out.println("b =" +b);


        int d=20;
        int d1 = ++d + 2;//증가 후 +2 진행
        System.out.println("d = "+d+", m1 = "+d1);

        int e=30;
        int e1 = e++ + 3;//e+3 계산 후, e++
        //e1 = e++;
        //e1 = e1 + 3;
        System.out.println("e = "+e+", e1 = "+e1);

        int x = 40;
        int y=50;
        int z = x++ + --y;//40+49
        //int z = x++;
        //int z = z+ --y; 이렇게 계산한다고 생각하면 됩니다
        System.out.println("x = "+x+", y = "+y+", z = "+z);
    }

}

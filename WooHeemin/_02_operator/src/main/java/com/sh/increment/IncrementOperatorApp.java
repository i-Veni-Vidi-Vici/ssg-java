package com.sh.increment;


/**
 * <pre>
 *     증감 연산자
 *     a++
 *     a--
 *
 *     전위 증감연산자 ++a --a 선 증감후
 *     후위 증감연산자 a-- a++
 * </pre>
 */
public class IncrementOperatorApp {

    public static void main(String[] args) {
        int ten = 10;

        ten++;
        System.out.println(ten);

        ten--;
        System.out.println(ten);

        System.out.println(++ten);
        System.out.println(--ten);

        System.out.println(ten--);
        System.out.println(ten++);

    }


}

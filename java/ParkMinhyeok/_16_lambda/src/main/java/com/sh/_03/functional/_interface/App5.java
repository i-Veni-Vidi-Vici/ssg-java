package com.sh._03.functional._interface;

import java.util.function.BinaryOperator;
import java.util.function.UnaryOperator;

/**
 * <pre>
 * Operator 함수형 인터페이스 관련
 * - Function 자매품. 매개변수와 리턴값의 타입이 동일한 경우 사용한다.
 * </pre>
 */
public class App5 {
    public static void main(String[] args) {
        // UnaryOperator<T>#apply(T):T
        UnaryOperator<String> unaryOperator = (str) -> str.toLowerCase();
        System.out.println(unaryOperator.apply("HelloWorld"));

        // BinaryOperator<T>#apply(T, T):T
        BinaryOperator<String> binaryOperator = (str1, str2) -> str1 + str2;
        System.out.println(binaryOperator.apply("ㅋㅋㅋㅋ", "world"));

        //IntUnaryOperator#applyAsInt(int):int
        //IntBinaryOperator#applyAsInt(int, int):int
        //LongBinaryOperator#applyAsLong(long):long
        //LongBinaryOperator#applyAsLong(long, long):long
        //DoubleBinaryOperator#applyAsDouble(double):double
        //DoubleBinaryOperator#applyAsDouble(double, double):double
    }

}

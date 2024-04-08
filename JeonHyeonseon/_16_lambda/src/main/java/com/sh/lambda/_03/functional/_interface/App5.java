package com.sh.lambda._03.functional._interface;

import java.util.function.BinaryOperator;
import java.util.function.UnaryOperator;

/**
 * <pre>
 * Operator 함수형 인터페이스 관련
 *  - Function 자매품, 매개변수와 리턴값의 타입이 동일한 경우 사용한다.
 * </pre>
 */
public class App5 {
    public static void main(String[] args) {
        // UnaryOperator<T>#apply(T):T  -> Unary는 1개
        UnaryOperator<String> unaryOperator = (str) -> str.toLowerCase();  // (str) : str라는 문자열로 받는다는 의미
        System.out.println(unaryOperator.apply("HelloWorld"));

        // BinaryOperator<T>#apply(T, T):T -> Binary는 2개
        BinaryOperator<String> binaryOperator = (str1, str2) -> str1 + str2;
        System.out.println(binaryOperator.apply("야호", "enjoy~"));

        // IntUnaryOperator#applyAsInt(int):int Operator가 들어가면 매개변수와 리턴타입이 같다고 보면 된다.
        // IntBinaryOperator#applyAsInt(int, int):int
        // LongUnaryOperator#applyAsLong(long):long
        // LongBinaryOperator#applyAsLong(long, long):long
        // DoubleUnaryOperator#applyAsDouble(double):double
        // DoubleBinaryOperator#applyAsDouble(double, double):double

    }
}

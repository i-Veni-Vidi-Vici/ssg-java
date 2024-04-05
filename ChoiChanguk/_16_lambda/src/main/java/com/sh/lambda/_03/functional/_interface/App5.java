package com.sh.lambda._03.functional._interface;

import java.util.Locale;
import java.util.function.BinaryOperator;
import java.util.function.UnaryOperator;

/**
 * <pre>
 * Operator 함수형 인터페이스 관련
 * - Function 자매품, 매개변수와 리턴값의 타입이 동일한 경우 사용한다.
 * </pre>
 */
public class App5 {
    public static void main(String[] args) {
        //UnaryOperator<T>#apply(T):T
        UnaryOperator<String> unaryOperator=(str)->str.toLowerCase();
        System.out.println(unaryOperator.apply("ASDQWEQWE"));
        //BinaryOperator<T>#apply(T,T):T

        //BinaryOperator<T>#apply(T,T):T
        BinaryOperator<String > binaryOperator=(str1,str2)->str1+str1;
        System.out.println(binaryOperator.apply("123","456"));
    }
}

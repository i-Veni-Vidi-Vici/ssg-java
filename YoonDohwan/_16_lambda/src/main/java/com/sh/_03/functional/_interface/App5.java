package com.sh._03.functional._interface;

import java.util.function.BinaryOperator;
import java.util.function.UnaryOperator;

/**
 * operator 함수형 인터페이스 관련
 * -function 자매품 매개변수와 리턴값의 타입이 동일한 경우 사용한다.
 */
public class App5 {
    public static void main(String[] args) {
        UnaryOperator<String> unaryOperator = (str)->str.toLowerCase();
        System.out.println(unaryOperator.apply("HelloWorld"));

        BinaryOperator<String> binaryOperator = (str1, str2) -> str1+str2;
        System.out.println(binaryOperator.apply("ㅋㅋㅋㅋㅋ","world"));
    }
}

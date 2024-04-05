package com.sh.lambda_04.method.reference;

import java.util.function.Function;

public class App {
    public static void main(String[] args) {
        Function<String, Integer> function = (str) -> str.length();
        System.out.println(function.apply("abcde"));
    }
}

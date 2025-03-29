package com.sh._02.anonymous.clazz;

public class App {
    public static void main(String[] args) {
        Calculator plusCalculator = new Calculator() {
            @Override
            public int calc(int a, int b) {
                return a + b;
            }
        };

        // 익명 클래스를 사용한 계산기 객체의 메서드 호출
        int result = plusCalculator.calc(10, 20);
        System.out.println(result);

        // 람다식을 사용한 계산기 객체 생성
        Calculator divideCalculator = (a, b) -> a / b;
        // 람다식을 사용한 계산기 객체의 메서드 호출
        result = divideCalculator.calc(10, 2);
        System.out.println(result);

        // 람다식을 사용한 프린터 객체 생성
        Printer printer = str -> System.out.println(str);
        // 람다식을 사용한 프린터 객체의 메서드 호출
        printer.print("안녕");

        // 람다식을 사용한 정수 함수 객체 생성
        Func.IntFunc square = n -> n * n;
        // 람다식을 사용한 정수 함수 객체의 메서드 호출
        System.out.println(square.calc(10));

        // 람다식을 사용한 실수 함수 객체 생성
        Func.DoubleFunc square2 = n -> n * n;
        // 람다식을 사용한 실수 함수 객체의 메서드 호출
        System.out.println(square2.calc(0.5));
    }
}
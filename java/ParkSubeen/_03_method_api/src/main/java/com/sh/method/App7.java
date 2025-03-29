package com.sh.method;

import java.sql.SQLOutput;

public class App7 {
    public static void main(String[] args) {
        App7 app = new App7();
        int a = 30;
        int b = 10;
        int sum = app.plus(a, b); // a, b는 매개인자
        System.out.println("합 : " + sum);

        int diff = app.minus(a, b);
        System.out.println("차 : " + diff);

        int product = app.multiply(a, b);
        System.out.println("곱 : " + product);

        int quotient = app.divide(a, b);
        System.out.println("몫 : " + quotient);

        int remainder = app.mod(a, b);
        System.out.println("나머지 : " + remainder);
    }

    public int plus(int a, int b) { // a, b는 매개변수
        return a + b;
    }

    public int minus(int a, int b) {
        return a - b;
    }

    public int multiply(int a, int b) {
        return a * b;
    }

    public int divide(int a, int b) {
        return a / b;
    }

    public int mod(int a, int b) {
        return a % b;
    }
}

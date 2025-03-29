package com.sh.method;

public class App7 {

    public static void main(String[] args) {
        App7 app = new App7();
        int a = 30;
        int b = 20;
        int sum = app.plus(a,b); // 호출부니까 a,b (매개인자 = 매개인수)
        System.out.println("합 : " + sum);

        int diff = app.minus(a,b);
        System.out.println("차 : " + diff);

        int product = app.multiply(a,b);
        System.out.println("곱 : " + product);

        int quotient = app.divide(a,b);
        System.out.println("몫 : " + quotient);

        int remainder = app.mod(a,b);
        System.out.println("나머지 : " + remainder);

    }
    // (매개변수 = 파라미터)
    public int plus(int a, int b) {
        return a + b;
    }

    public int minus(int a, int b) {
        return a - b ;
    }
    public int multiply(int a, int b) {
        return a * b ;
    }
    public int divide(int a, int b) {
        return a / b ;
    }
    public int mod(int a, int b) {
        return a % b ;
    }
}

package com.sh.method;

public class App7 {
    public static void main(String[] args) {
        App7 app = new App7();
        int a = 30;
        int b = 20;

        int sum = app.plus(a,b);
        System.out.println("합 : " + sum);

        int diff = app.minus(a,b);
        System.out.println("차 : " + diff);

        int multi = app.multiply(a,b);
        System.out.println("곱 : " + multi);

        int div = app.divide(a,b);
        System.out.println("몫 : " + div);

        int remain = app.mod(a,b);
        System.out.println("나머지 : " + remain);

    }
    public int plus(int a, int b)
    {
        return a + b;
    }
    public int minus(int a, int b){
        return a - b;
    }
    public int multiply(int a, int b)
    {
        return a * b;
    }
    public int divide(int a, int b)
    {
        return a / b;
    }
    public int mod(int a, int b)
    {
        return a % b;
    }
}
